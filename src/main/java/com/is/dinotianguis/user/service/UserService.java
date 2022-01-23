package com.is.dinotianguis.user.service;

import com.is.dinotianguis.commerce.base.model.customer.CustomerModel;
import com.is.dinotianguis.user.model.UserModel;
import com.is.dinotianguis.user.repository.UserRepository;
import net.bytebuddy.dynamic.DynamicType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserService
{

    @Autowired
    UserRepository userRepository;

    public Optional<UserModel> getByUID(final String uid)
    {
        return userRepository.findByUID(uid);
    }

    public boolean existsByUID(final String uid)
    {
        return userRepository.existsByUID(uid);
    }

    public void save(UserModel user)
    {
        userRepository.save(user);
    }

    public Optional<UserModel> getCurrentUser()
    {
       try
       {
           final String UID = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
           return getByUID(UID);
       } catch (Exception ex)
       {
           return Optional.ofNullable(null);
       }
    }
}
