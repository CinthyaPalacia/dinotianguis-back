package com.is.dinotianguis.commerce.base.repository.customer;

import com.is.dinotianguis.commerce.base.model.customer.ReviewModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReviewModelRepository extends JpaRepository<ReviewModel, Long>
{
    @Override
    Optional<ReviewModel> findById(Long aLong);
}