package com.example.config;

import com.example.entity.Personnel;
import com.example.service.impl.PersonnelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCUserDetailService implements UserDetailsService {
    @Autowired
    private PersonnelServiceImpl personnelServiceImpl;

    @Override
    public UserDetails loadUserByUsername(String personnelID) throws UsernameNotFoundException {
        Personnel personnel = personnelServiceImpl.getById(personnelID);
        if (personnel == null) {
            throw new UsernameNotFoundException("用户不存在");
        }

        String role = personnel.getPosition();
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" + role));

        return new User(
                personnel.getPersonnelId(),
                personnel.getPassword(),
                grantedAuthorityList
        );
    }
}