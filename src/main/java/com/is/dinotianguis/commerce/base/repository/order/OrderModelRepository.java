package com.is.dinotianguis.commerce.base.repository.order;

import com.is.dinotianguis.commerce.base.model.order.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderModelRepository extends JpaRepository<OrderModel, Long>
{
    @Override
    Optional<OrderModel> findById(Long aLong);
}