package com.is.dinotianguis.commerce.storefront.populator;

import com.is.dinotianguis.commerce.base.model.CategoryModel;
import com.is.dinotianguis.commerce.storefront.data.CategoryData;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class CategoryDataPopulator
{
    public static CategoryData populate(CategoryModel categoryModel)
    {
        CategoryData categoryData = new CategoryData(categoryModel.getId(), categoryModel.getName());
        categoryData.setCategories(new ArrayList<>());
        if (!CollectionUtils.isEmpty(categoryModel.getCategories()))
        {
            categoryData.setCategories(categoryModel.getCategories().stream().map(c -> populate(c)).collect(Collectors.toList()));
        }
        return categoryData;
    }
}
