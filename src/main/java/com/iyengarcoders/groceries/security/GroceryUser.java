package com.iyengarcoders.groceries.security;

import com.iyengarcoders.groceries.utils.Constants;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GroceryUser extends User {

    private String email;
    // username will be unique and this username will be used in user_profile table.
    public GroceryUser(String username, String password, String email, Collection<? extends GrantedAuthority> authorities) {
        this(username, password, email, true,true,true,true,authorities);
    }

//    public GroceryUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//    }

    public GroceryUser(String username, String password,String email, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
        this.email = email;
    }

    public static GroceryUser create(String username, String password, String emailAddress, Set<Constants.RoleName> roles){
        List<GrantedAuthority> authorities = roles.stream().map(role ->
                new SimpleGrantedAuthority(role.name())
        ).collect(Collectors.toList());

        return new GroceryUser(username, password, emailAddress,true, true, true,true,authorities);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
