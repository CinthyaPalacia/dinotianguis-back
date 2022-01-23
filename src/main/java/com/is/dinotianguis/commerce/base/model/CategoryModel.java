package com.is.dinotianguis.commerce.base.model;

import com.is.dinotianguis.commerce.base.model.seller.ProductModel;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryModel implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryModel parent;

    @OneToMany(mappedBy = "parent")
    private List<CategoryModel> categories;

    @ManyToMany(mappedBy = "categories")
    private Collection<ProductModel> products = new java.util.ArrayList<>();

    public CategoryModel()
    {
    }

    public CategoryModel(final String name)
    {
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

    public CategoryModel getParent()
    {
        return parent;
    }

    public void setParent(CategoryModel parent)
    {
        this.parent = parent;
    }

    public List<CategoryModel> getCategories()
    {
        return categories;
    }

    public void setCategories(List<CategoryModel> categories)
    {
        this.categories = categories;
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