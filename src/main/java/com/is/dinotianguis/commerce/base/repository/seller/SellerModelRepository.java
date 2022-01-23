package com.is.dinotianguis.commerce.base.repository.seller;

import com.is.dinotianguis.commerce.base.model.seller.SellerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SellerModelRepository extends JpaRepository<SellerModel, Long>
{
    Optional<SellerModel> findByUID(String UID);
}