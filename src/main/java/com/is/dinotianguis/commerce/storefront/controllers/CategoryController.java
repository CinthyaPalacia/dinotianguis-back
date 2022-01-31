package com.is.dinotianguis.commerce.storefront.controllers;

import com.is.dinotianguis.commerce.base.service.CategoryService;
import com.is.dinotianguis.commerce.storefront.data.ProductData;
import com.is.dinotianguis.commerce.storefront.populator.CategoryDataPopulator;
import com.is.dinotianguis.commerce.storefront.data.CategoryData;
import com.is.dinotianguis.commerce.storefront.populator.ProductDataPopulator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/**/category")
@CrossOrigin
public class CategoryController
{
    protected static final String CATEGORY_CODE_PATH_VARIABLE_PATTERN = "/{categoryCode:.*}";
    protected static CategoryDataPopulator categoryPopulator;
    protected static ProductDataPopulator productPopulator;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = CATEGORY_CODE_PATH_VARIABLE_PATTERN, method = RequestMethod.GET)
    public ResponseEntity<?> getProductsWithCategory(@PathVariable("categoryCode") final Long categoryCode)
    {
        final List<ProductData> products = categoryService.findById(categoryCode).get()
                .getProducts().stream().map(p -> productPopulator.populate(p)).collect(Collectors.toList());
        return new ResponseEntity(products, HttpStatus.OK);
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    public ResponseEntity<?> getMenuCategories()
    {
        List<CategoryData> categoryData = categoryService
                .findForMenu().stream()
                .map(c -> categoryPopulator.populate(c)).collect(Collectors.toList());
        return new ResponseEntity(categoryData, HttpStatus.OK);
    }
}
