package com.is.dinotianguis.user.security.data;

import com.is.dinotianguis.user.model.UserModel;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserData implements UserDetails
{

    private final String userName;
    private final String password;
    private final Collection<? extends GrantedAuthority> authorities;
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;


    public UserData(final UserModel user, Collection<? extends GrantedAuthority> authorities)
    {
        this.userName = user.getUID();
        this.password = user.getPassword();
        this.authorities = authorities;
        this.accountNonExpired = BooleanUtils.isTrue(user.isAccountNonExpired());
        this.accountNonLocked = BooleanUtils.isTrue(user.isAccountNonLocked());
        this.credentialsNonExpired = BooleanUtils.isTrue(user.isCredentialsNonExpired());
        this.enabled = BooleanUtils.isTrue(user.isEnabled());
    }

    public static UserData build(final UserModel user)
    {
        List<GrantedAuthority> authorities =
                user.getRoles().stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getRolName().name()))
                        .collect(Collectors.toList());
        return new UserData(user, authorities);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities()
    {
        return authorities;
    }

    @Override
    public String getUsername()
    {
        return userName;
    }

    @Override
    public String getPassword()
    {
        return password;
    }

    @Override
    public boolean isAccountNonExpired()
    {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked()
    {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired()
    {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled()
    {
        return enabled;
    }
}
