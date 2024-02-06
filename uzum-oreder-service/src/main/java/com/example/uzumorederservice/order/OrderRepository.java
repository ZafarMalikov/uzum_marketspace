package com.example.uzumorederservice.order;

import com.example.uzumorederservice.common.repository.GenericSpecificationRepository;
import com.example.uzumorederservice.order.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends GenericSpecificationRepository<Order, UUID> {
}
