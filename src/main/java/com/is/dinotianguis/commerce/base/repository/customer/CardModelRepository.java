package com.is.dinotianguis.commerce.base.repository.customer;

import com.is.dinotianguis.commerce.base.model.customer.CardModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CardModelRepository extends JpaRepository<CardModel, Long>
{
    @Override
    Optional<CardModel> findById(final Long id);
}