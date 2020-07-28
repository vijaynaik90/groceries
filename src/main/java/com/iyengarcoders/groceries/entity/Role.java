package com.iyengarcoders.groceries.entity;

import com.iyengarcoders.groceries.utils.Constants;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 60)
    private Constants.RoleName name;

    public Role() {
    }

    public Long getId() {
        return id;
    }

    public Constants.RoleName getName() {
        return name;
    }

    public void setName(Constants.RoleName name) {
        this.name = name;
    }
}
