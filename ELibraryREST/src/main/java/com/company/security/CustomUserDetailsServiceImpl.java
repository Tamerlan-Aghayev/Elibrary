package com.company.security;

import com.company.entity.PrivilegeEntity;
import com.company.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class CustomUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PrivilegeService privilegeService;

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        PrivilegeEntity privilegeEntity= privilegeService.getByUsername(email);

        if (privilegeEntity != null) {
            UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(email);

            builder.disabled(false);
            builder.password(privilegeEntity.getPassword());

            String[] authoritiesArr = {privilegeEntity.getPrivilege()};
            builder.authorities(authoritiesArr);

            return builder.build();
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

    }
}
