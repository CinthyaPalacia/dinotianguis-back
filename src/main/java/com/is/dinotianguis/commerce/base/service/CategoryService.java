package com.is.dinotianguis.commerce.base.service;

import com.is.dinotianguis.commerce.base.model.CategoryModel;
import com.is.dinotianguis.commerce.base.repository.CategoryModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CategoryService
{
    @Autowired
    private CategoryModelRepository categoryRepository;

    public Optional<CategoryModel> findByName(final String name)
    {
        return categoryRepository.findByName(name);
    }

    public void save(CategoryModel category)
    {
        categoryRepository.save(category);
    }

    public Collection<CategoryModel> findAll()
    {
        return categoryRepository.findAll();
    }

    public Collection<CategoryModel> findForMenu()
    {
        return categoryRepository.findForMenu();
    }
}
