package com.is.dinotianguis.commerce.base.model.customer;

import com.is.dinotianguis.commerce.base.model.order.OrderModel;
import com.is.dinotianguis.commerce.base.model.cart.CartModel;
import com.is.dinotianguis.user.model.UserModel;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "customers")
@DiscriminatorValue("customer")
public class CustomerModel extends UserModel
{
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<CartModel> carts;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<OrderModel> orders;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<AddressModel> addresses;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<ReviewModel> reviews;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<CardModel> cards;

    public CustomerModel()
    {
        super();
    }

    public CustomerModel(final String name, final String password)
    {
        super(name, password);
    }

    public Collection<CartModel> getCarts()
    {
        return carts;
    }

    public void setCarts(Collection<CartModel> carts)
    {
        this.carts = carts;
    }

    public Collection<OrderModel> getOrders()
    {
        return orders;
    }

    public void setOrders(Collection<OrderModel> orders)
    {
        this.orders = orders;
    }

    public Collection<AddressModel> getAddresses()
    {
        return addresses;
    }

    public void setAddresses(Collection<AddressModel> addresses)
    {
        this.addresses = addresses;
    }

    public Collection<ReviewModel> getReviews()
    {
        return reviews;
    }

    public void setReviews(Collection<ReviewModel> reviews)
    {
        this.reviews = reviews;
    }

    public Collection<CardModel> getCards()
    {
        return cards;
    }

    public void setCards(Collection<CardModel> cards)
    {
        this.cards = cards;
    }
}