package com.is.dinotianguis.commerce.storefront.dto;

import java.util.List;

public class CategoryMenuDTO
{
    private Long id;
    private String name;
    private List<CategoryMenuDTO> categories;

    public CategoryMenuDTO(final Long id, final String name)
    {
        this.id = id;
        this.name = name;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public List<CategoryMenuDTO> getCategories()
    {
        return categories;
    }

    public void setCategories(List<CategoryMenuDTO> categories)
    {
        this.categories = categories;
    }
}
