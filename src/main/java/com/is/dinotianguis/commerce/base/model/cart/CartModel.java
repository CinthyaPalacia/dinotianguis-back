package com.is.dinotianguis.commerce.base.model.cart;

import com.is.dinotianguis.commerce.base.model.customer.CustomerModel;
import com.is.dinotianguis.commerce.base.model.abs.AbstractOrderModel;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "carts")
@DiscriminatorValue("cart")
@PrimaryKeyJoinColumn(name = "abstract_order_id")
public class CartModel extends AbstractOrderModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<CartEntryModel> entries;

    public CartModel()
    {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerModel getCustomer()
    {
        return customer;
    }

    public void setCustomer(CustomerModel customer)
    {
        this.customer = customer;
    }

    public Collection<CartEntryModel> getEntries()
    {
        return entries;
    }

    public void setEntries(Collection<CartEntryModel> entries)
    {
        this.entries = entries;
    }
}