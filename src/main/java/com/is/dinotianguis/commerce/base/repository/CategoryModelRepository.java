package com.is.dinotianguis.commerce.base.repository;

import com.is.dinotianguis.commerce.base.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryModelRepository extends JpaRepository<CategoryModel, Long>, JpaSpecificationExecutor<CategoryModel> {
    Optional<CategoryModel> findByName(String name);

    @Query(value = "SELECT c FROM CategoryModel c WHERE c.parent is null ORDER BY c.id ASC")
    List<CategoryModel> findForMenu();
}