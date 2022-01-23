package com.is.dinotianguis.commerce.base.repository.customer;

import com.is.dinotianguis.commerce.base.model.customer.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerModelRepository extends JpaRepository<CustomerModel, Long>
{
    Optional<CustomerModel> findByUID(final String UID);
}