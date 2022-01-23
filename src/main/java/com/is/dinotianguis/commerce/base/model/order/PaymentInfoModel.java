package com.is.dinotianguis.commerce.base.model.order;

import com.is.dinotianguis.commerce.base.model.customer.CardModel;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "payments_infos")
public class PaymentInfoModel implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private CardModel card;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @JoinColumn(name = "order_id")
    @OneToOne(fetch = FetchType.LAZY)
    private OrderModel order;

    public PaymentInfoModel()
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

    public CardModel getCard()
    {
        return card;
    }

    public void setCard(CardModel card)
    {
        this.card = card;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    public BigDecimal getAmount()
    {
        return amount;
    }

    public void setAmount(BigDecimal amount)
    {
        this.amount = amount;
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