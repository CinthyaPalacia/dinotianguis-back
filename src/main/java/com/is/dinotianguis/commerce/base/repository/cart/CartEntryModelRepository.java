package com.is.dinotianguis.commerce.base.repository.cart;

import com.is.dinotianguis.commerce.base.model.cart.CartEntryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartEntryModelRepository extends JpaRepository<CartEntryModel, Long>
{
    @Override
    Optional<CartEntryModel> findById(Long aLong);
}