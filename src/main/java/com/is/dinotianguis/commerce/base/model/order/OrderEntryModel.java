package com.is.dinotianguis.commerce.base.model.order;

import com.is.dinotianguis.commerce.base.model.abs.AbstractOrderEntryModel;

import javax.persistence.*;

@Entity
@Table(name = "order_entries")
@DiscriminatorValue("order_entry")
public class OrderEntryModel extends AbstractOrderEntryModel
{
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private OrderModel order;

    public OrderEntryModel()
    {
        super();
    }

    public OrderModel getOrder()
    {
        return order;
    }

    public void setOrder(OrderModel order)
    {
        this.order = order;
    }
}