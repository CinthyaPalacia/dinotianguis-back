package com.is.dinotianguis.commerce.storefront.data;

import java.util.List;

public class CategoryData
{
    private Long id;
    private String name;
    private List<CategoryData> categories;

    public CategoryData(final Long id, final String name)
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

    public List<CategoryData> getCategories()
    {
        return categories;
    }

    public void setCategories(List<CategoryData> categories)
    {
        this.categories = categories;
    }
}
