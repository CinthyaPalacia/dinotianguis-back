package com.is.dinotianguis.commerce.base.model.seller;

import com.is.dinotianguis.commerce.base.model.CategoryModel;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "products")
public class ProductModel implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "sku", nullable = false, unique = true)
    private String sku;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "vendor_sku", nullable = false)
    private String vendorSku;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "description", nullable = false, length = 4096)
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "final_price", nullable = false)
    private BigDecimal finalPrice;

    @ManyToMany
    @JoinTable(name = "categories_products",
            joinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    private Collection<CategoryModel> categories = new java.util.ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "store_id", nullable = false)
    private StoreModel store;

    public ProductModel()
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

    public String getName() {
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

    public Collection<CategoryModel> getCategories()
    {
        return categories;
    }

    public void setCategories(Collection<CategoryModel> categories)
    {
        this.categories = categories;
    }

    public StoreModel getStore()
    {
        return store;
    }

    public void setStore(StoreModel store)
    {
        this.store = store;
    }


}