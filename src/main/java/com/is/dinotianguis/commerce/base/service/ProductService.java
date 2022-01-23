package com.is.dinotianguis.commerce.base.service;

import com.is.dinotianguis.commerce.base.model.seller.ProductModel;
import com.is.dinotianguis.commerce.base.repository.seller.ProductModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductService
{
    @Autowired
    private ProductModelRepository productRepository;

    public Optional<ProductModel> findBySku(final String sku)
    {
        return productRepository.findBySku(sku);
    }

    public void save(final ProductModel product)
    {
        productRepository.save(product);
    }
}
