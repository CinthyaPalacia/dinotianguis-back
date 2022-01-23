package com.is.dinotianguis.commerce.base.repository.cart;

import com.is.dinotianguis.commerce.base.model.cart.CartModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartModelRepository extends JpaRepository<CartModel, Long>
{
    @Override
    Optional<CartModel> findById(Long aLong);
}