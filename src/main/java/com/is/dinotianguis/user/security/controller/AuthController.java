package com.is.dinotianguis.user.security.controller;

import com.is.dinotianguis.user.enums.RolName;
import com.is.dinotianguis.user.model.Rol;
import com.is.dinotianguis.user.model.UserModel;
import com.is.dinotianguis.user.security.dto.JwtDto;
import com.is.dinotianguis.user.security.dto.Message;
import com.is.dinotianguis.user.security.dto.AuthForm;
import com.is.dinotianguis.user.security.jwt.JwtProvider;
import com.is.dinotianguis.user.service.RolService;
import com.is.dinotianguis.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController
{

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
     AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService rolService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/register")
    public ResponseEntity<?> nuevo(@Valid @RequestBody AuthForm form, BindingResult bindingResult)
    {

        if(bindingResult.hasErrors())
        {
            return new ResponseEntity(new Message("datos incorrectos"), HttpStatus.BAD_REQUEST);
        }

        if(userService.existsByUID(form.getEmail()))
        {
            return new ResponseEntity(new Message("ese usuario ya existe"), HttpStatus.BAD_REQUEST);
        }

        final UserModel user = new UserModel(form.getEmail(), passwordEncoder.encode(form.getPassword()));
        Set<Rol> roles = new HashSet<>();
        Optional<Rol> customerRol = rolService.getByRolName(RolName.ROLE_CUSTOMER);
        roles.add(customerRol.get());
        user.setRoles(roles);
        user.setAccountNonExpired(Boolean.TRUE);
        user.setAccountNonLocked(Boolean.TRUE);
        user.setCredentialsNonExpired(Boolean.TRUE);
        user.setEnabled(Boolean.TRUE);
        userService.save(user);
        return new ResponseEntity(new Message("usuario guardado"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody AuthForm form, BindingResult bindingResult)
    {
        if(bindingResult.hasErrors())
        {
            return new ResponseEntity(new Message("campos mal puestos"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(form.getEmail(), form.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }
}
