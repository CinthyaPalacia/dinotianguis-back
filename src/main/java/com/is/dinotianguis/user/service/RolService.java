package com.is.dinotianguis.user.service;

import com.is.dinotianguis.user.enums.RolName;
import com.is.dinotianguis.user.model.Rol;
import com.is.dinotianguis.user.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService
{

    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRolName(RolName rolName)
    {
        return rolRepository.findByRolName(rolName);
    }

    public void save(Rol rol)
    {
        rolRepository.save(rol);
    }
}
