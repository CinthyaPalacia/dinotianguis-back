package com.is.dinotianguis.commerce.base.model.cart;

import com.is.dinotianguis.commerce.base.model.abs.AbstractOrderEntryModel;

import javax.persistence.*;

@Entity
@Table(name = "cart_entries")
@DiscriminatorValue("cart_entry")
public class CartEntryModel extends AbstractOrderEntryModel
{
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cart_id", nullable = false)
    private CartModel cart;

    public CartEntryModel()
    {
        super();
    }

    public CartModel getCart()
    {
        return cart;
    }

    public void setCart(CartModel cart)
    {
        this.cart = cart;
    }
}