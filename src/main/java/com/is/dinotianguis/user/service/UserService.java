package com.is.dinotianguis.user.service;

import com.is.dinotianguis.user.model.UserModel;
import com.is.dinotianguis.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
