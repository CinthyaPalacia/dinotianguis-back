package com.is.dinotianguis.commerce.base.repository.order;

import com.is.dinotianguis.commerce.base.model.order.PaymentInfoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaymentInfoModelRepository extends JpaRepository<PaymentInfoModel, Long>
{
    @Override
    Optional<PaymentInfoModel> findById(Long aLong);
}