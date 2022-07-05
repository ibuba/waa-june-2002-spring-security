package com.edu.miu.service;

import com.edu.miu.Domain.Role;
import com.edu.miu.Domain.User;
import com.edu.miu.repository.UserRepo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@Transactional
public class UserD implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;

    @Override // converting  user  to user details
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);
        if (user ==null){
            throw new UsernameNotFoundException("User is not Found");
        }
else{
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                true,
                true,
                true,
                true,
                getAuthorities(user.getRoles()));

        }
    }
       // converting  from normal Roles to Spring Security roles
        private Collection <? extends GrantedAuthority> getAuthorities(List<Role> roles){
            return roles.stream()
                    .map(role -> new SimpleGrantedAuthority(role.getRole()))
                    .collect(Collectors.toList());
    }
}
