package com.is.dinotianguis.commerce.storefront.populator;

import com.is.dinotianguis.commerce.base.model.seller.ProductModel;
import com.is.dinotianguis.commerce.storefront.data.ProductData;
import org.apache.commons.lang3.StringUtils;

public class ProductDataPopulator
{
    public static ProductData populate(ProductModel productModel)
    {
        ProductData productData = new ProductData();
        productData.setId(productModel.getId());
        productData.setName(productModel.getName());
        productData.setDescription(productModel.getDescription());
        productData.setPrice(productModel.getPrice());
        productData.setImage(StringUtils.isNotBlank(productModel.getImage()) ? "/medias/" + productModel.getImage() : null);
        productData.setBrand(productModel.getBrand());
        productData.setVendorSku(productModel.getVendorSku());
        productData.setFinalPrice(productModel.getFinalPrice());
        productData.setSku(productModel.getSku());
        return productData;
    }
}
