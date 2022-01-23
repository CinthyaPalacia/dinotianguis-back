package com.is.dinotianguis.user.model;

import com.is.dinotianguis.user.enums.RolName;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="roles")
public class Rol implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RolName rolName;

    public Rol()
    {
    }

    public Rol(@NotNull RolName rolName)
    {
        this.rolName = rolName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public RolName getRolName()
    {
        return rolName;
    }

    public void setRolName(RolName rolName)
    {
        this.rolName = rolName;
    }
}
