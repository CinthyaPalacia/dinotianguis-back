package com.is.dinotianguis.user.repository;

import com.is.dinotianguis.user.enums.RolName;
import com.is.dinotianguis.user.model.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>
{
    Optional<Rol> findByRolName(RolName rolName);
    boolean existsByRolName(RolName rolName);
}
