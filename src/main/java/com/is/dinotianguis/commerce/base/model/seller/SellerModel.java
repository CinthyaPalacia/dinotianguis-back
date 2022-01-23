package com.is.dinotianguis.commerce.base.model.seller;

import com.is.dinotianguis.user.model.UserModel;

import javax.persistence.*;

@Entity
@Table(name = "sellers")
@DiscriminatorValue("seller")
public class SellerModel extends UserModel
{
    @OneToOne(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private StoreModel store;

    public SellerModel()
    {
        super();
    }

    public SellerModel(final String UID, final String password)
    {
        super(UID, password);
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