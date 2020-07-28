package com.iyengarcoders.groceries.security;

import com.iyengarcoders.groceries.entity.Role;
import com.iyengarcoders.groceries.repositories.UserRepository;
import com.iyengarcoders.groceries.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

public class GroceryUserDetailsService extends JdbcUserDetailsManager {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private UserRepository userRepository;
    public static final String DEF_USERS_BY_USERNAME_QUERY =
            "SELECT a.username, a.password, a.enabled, b.org_id, b.email " +
                    "FROM users a INNER JOIN user_profile b ON (a.username = b.username)" +
                    "WHERE a.username = ? OR LOWER(b.email) = ?";


    @Override
    @Transactional
    public UserDetails loadUserByUsername(String usernameOrEmail) {
//        GroceryUser user = userRepository.loadUserByUsernameOrEmailAddress(usernameOrEmail);
//        return user;
        return null;
    }

    @Transactional
    public String createUserInDB(String username, String email, Set<Constants.RoleName> roles, String password) {
        if (username == null) {
            return null;
        }

        User user = GroceryUser.create(username, password, email,roles);
        // TODO: Check existence of user before attempting a create?  Could use userDetailsService.userExists(username)...
        createUser(user);
        return username;
    }

//    @Transactional
//    public UserDetails loadUserById(Long id){
//        GroceryUser user = userRepository.findById(id)
//                .orElseThrow(() -> new UsernameNotFoundException("Cannot find user with id:" + id));
//
//        return user;
//    }
//    @Override
//    protected List<UserDetails> loadUsersByUsername(String username) {
//        return getJdbcTemplate().query(DEF_USERS_BY_USERNAME_QUERY, new String[] {username, username.toLowerCase()}, new RowMapper<UserDetails>() {
//            public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
//                String username = rs.getString(1);
//                String password = rs.getString(2);
//                boolean enabled = rs.getBoolean(3);
//                long org = rs.getLong(4);
//                String email = rs.getString(5);
//                return new GroceryUser(username, password, enabled, true, true, true, org, email, AuthorityUtils.NO_AUTHORITIES);
//            }
//        });
//    }
}
