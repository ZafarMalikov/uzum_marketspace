package com.example.uzumorederservice.order;

import com.example.uzumorederservice.common.service.GenericCrudService;
import com.example.uzumorederservice.order.dto.OrderCreateDto;
import com.example.uzumorederservice.order.dto.OrderResponseDto;
import com.example.uzumorederservice.order.entity.Order;
import com.example.uzumorederservice.service.feign.NotificationServiceFeign;
import com.example.uzumorederservice.service.rabbit.mq.NotificationPublisher;
import com.example.uzumorederservice.stock.StockFeignClient;
import com.example.uzumorederservice.stock.StockResponseDto;
import com.example.uzumorederservice.stock.StockUpdateDto;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Getter
@RequiredArgsConstructor
public class OrderService extends GenericCrudService<Order, UUID, OrderCreateDto, OrderCreateDto, OrderCreateDto, OrderResponseDto>
{
    private final OrderRepository repository;
    private final Class<Order> EntityClass = Order.class;
    private final OrderDtoMapper mapper;
    private final StockFeignClient stockFeignClient;
    private final String phoneNumber = "998937797499";
    private final NotificationServiceFeign notificationServiceFeign;
    private final NotificationPublisher notificationPublisher;

    @Override
    @Transactional
    protected Order save( OrderCreateDto orderCreateDto )
    {

        String productId = orderCreateDto.getProductId();
        int orderQuantity = orderCreateDto.getCount();

        StockResponseDto stockResponseDto = stockFeignClient.getProduct( productId ).getBody();

        if( stockResponseDto != null && stockResponseDto.getCount() >= orderQuantity )
        {
            Order entity = mapper.toEntity( orderCreateDto );
            Order savedOrder = repository.save( entity );

            StockUpdateDto updateRequest = new StockUpdateDto( productId, orderQuantity );
            ResponseEntity<String> updateResponse = stockFeignClient.updateStock( updateRequest );

            if( updateResponse.getStatusCode() != HttpStatus.OK )
            {
                throw new RuntimeException( "Не удалось обновить инвентарь после создания заказа" );
            }
            notificationPublisher.publish( "Your order was successful" );

            return savedOrder;
        }
        else
        {
            notificationPublisher.publish( "Your order was unsuccessful" );
            throw new IllegalArgumentException( "Недостаточно товаров в инвентаре для создания заказа" );
        }
    }

    @Override
    protected Order updateEntity( OrderCreateDto orderCreateDto, Order order )
    {
        return null;
    }
}
