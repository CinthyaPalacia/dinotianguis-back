package com.is.dinotianguis.user.repository;

import com.is.dinotianguis.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Integer>
{
    Optional<UserModel> findByUID(final String uid);
    boolean existsByUID(String uid);

}
