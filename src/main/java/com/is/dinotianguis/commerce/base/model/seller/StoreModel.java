package com.is.dinotianguis.commerce.base.model.seller;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "store_model")
public class StoreModel implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", length = 4096)
    private String description;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private SellerModel seller;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ProductModel> products;

    public StoreModel()
    {
    }

    public StoreModel(final String name, final String description)
    {
        this.name = name;
        this.description = description;
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

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public SellerModel getSeller()
    {
        return seller;
    }

    public void setSeller(SellerModel seller)
    {
        this.seller = seller;
    }

    public Collection<ProductModel> getProducts()
    {
        return products;
    }

    public void setProducts(Collection<ProductModel> products)
    {
        this.products = products;
    }
}