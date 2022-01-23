package com.is.dinotianguis.commerce.base.repository.order;

import com.is.dinotianguis.commerce.base.model.order.OrderEntryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderEntryModelRepository extends JpaRepository<OrderEntryModel, Long>
{
    @Override
    Optional<OrderEntryModel> findById(Long aLong);
}