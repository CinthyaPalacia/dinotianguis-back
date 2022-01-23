package com.is.dinotianguis.commerce.base.model.order;

import com.is.dinotianguis.commerce.base.model.customer.CustomerModel;
import com.is.dinotianguis.commerce.base.model.abs.AbstractOrderModel;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "orders")
@DiscriminatorValue("order")
@PrimaryKeyJoinColumn(name = "abstract_order_id")
public class OrderModel extends AbstractOrderModel
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<OrderEntryModel> entries;

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private PaymentInfoModel paymentInfo;

    public OrderModel()
    {
        super();
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
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

    public PaymentInfoModel getPaymentInfo()
    {
        return paymentInfo;
    }

    public void setPaymentInfo(PaymentInfoModel paymentInfo)
    {
        this.paymentInfo = paymentInfo;
    }

}