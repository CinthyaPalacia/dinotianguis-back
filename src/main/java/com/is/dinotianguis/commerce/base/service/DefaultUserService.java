package com.is.dinotianguis.commerce.base.service;

import com.is.dinotianguis.commerce.base.model.customer.CustomerModel;
import com.is.dinotianguis.commerce.base.model.seller.SellerModel;
import com.is.dinotianguis.commerce.base.repository.customer.CustomerModelRepository;
import com.is.dinotianguis.commerce.base.repository.seller.SellerModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DefaultUserService extends com.is.dinotianguis.user.service.UserService {

    @Autowired
    private CustomerModelRepository customerRepository;

    @Autowired
    private SellerModelRepository sellerRepository;

    public void save(CustomerModel user)
    {
        customerRepository.save(user);
    }

    public void save(SellerModel user)
    {
        sellerRepository.save(user);
    }
}
