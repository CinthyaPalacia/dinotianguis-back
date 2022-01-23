package com.is.dinotianguis.commerce.base.repository.customer;

import com.is.dinotianguis.commerce.base.model.customer.AddressModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AddressModelRepository extends JpaRepository<AddressModel, Long>
{
    @Override
    Optional<AddressModel> findById(Long aLong);
}