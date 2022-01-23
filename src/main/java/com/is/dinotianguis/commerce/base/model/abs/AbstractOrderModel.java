package com.is.dinotianguis.commerce.base.model.abs;

import com.is.dinotianguis.commerce.base.model.customer.AddressModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "abstract_orders")
@Inheritance(strategy= InheritanceType.JOINED)
@DiscriminatorValue("abstract")
@DiscriminatorColumn(name = "type")
public class AbstractOrderModel implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private AddressModel deliveryAddress;

    public AbstractOrderModel()
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

    public AddressModel getDeliveryAddress()
    {
        return deliveryAddress;
    }

    public void setDeliveryAddress(AddressModel deliveryAddress)
    {
        this.deliveryAddress = deliveryAddress;
    }
}