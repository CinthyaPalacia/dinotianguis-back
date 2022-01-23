package com.is.dinotianguis.commerce.base.repository.seller;

import com.is.dinotianguis.commerce.base.model.seller.StoreModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreModelRepository extends JpaRepository<StoreModel, Long>
{
    Optional<StoreModel> findByName(String name);
}