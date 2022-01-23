package com.is.dinotianguis.commerce.base.repository.seller;

import com.is.dinotianguis.commerce.base.model.seller.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface ProductModelRepository extends JpaRepository<ProductModel, Long>, JpaSpecificationExecutor<ProductModel> {
    @Override
    Optional<ProductModel> findById(Long aLong);
    Optional<ProductModel> findBySku(String sku);
}