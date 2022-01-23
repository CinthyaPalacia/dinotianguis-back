package com.is.dinotianguis.commerce.base.service;

import com.is.dinotianguis.commerce.base.model.cart.CartModel;
import com.is.dinotianguis.commerce.base.repository.cart.CartEntryModelRepository;
import com.is.dinotianguis.commerce.base.repository.cart.CartModelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class CartService
{
    @Autowired
    private CartModelRepository cartRepository;

    public Optional<CartModel> findById(Long id)
    {
        return cartRepository.findById(id);
    }

}
