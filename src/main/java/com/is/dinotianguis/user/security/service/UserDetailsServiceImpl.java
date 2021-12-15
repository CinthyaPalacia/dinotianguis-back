package com.is.dinotianguis.user.security.service;

import com.is.dinotianguis.user.model.UserModel;
import com.is.dinotianguis.user.security.data.UserData;
import com.is.dinotianguis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String uid)
            throws UsernameNotFoundException
    {
        final UserModel user = userService.getByUID(uid).get();
        return UserData.build(user);
    }
}
