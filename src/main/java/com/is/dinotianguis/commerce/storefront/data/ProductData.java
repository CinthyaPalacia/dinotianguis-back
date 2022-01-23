package com.is.dinotianguis.commerce.storefront.data;

import java.math.BigDecimal;

public class ProductData
{
    private Long id;
    private String sku;
    private String name;
    private String brand;
    private String vendorSku;
    private String image;
    private String description;
    private BigDecimal price;
    private BigDecimal finalPrice;

    public ProductData()
    {
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getSku()
    {
        return sku;
    }

    public void setSku(String sku)
    {
        this.sku = sku;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getBrand()
    {
        return brand;
    }

    public void setBrand(String brand)
    {
        this.brand = brand;
    }

    public String getVendorSku()
    {
        return vendorSku;
    }

    public void setVendorSku(String vendorSku)
    {
        this.vendorSku = vendorSku;
    }

    public String getImage()
    {
        return image;
    }

    public void setImage(String image)
    {
        this.image = image;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public BigDecimal getFinalPrice()
    {
        return finalPrice;
    }

    public void setFinalPrice(BigDecimal finalPrice)
    {
        this.finalPrice = finalPrice;
    }
}
