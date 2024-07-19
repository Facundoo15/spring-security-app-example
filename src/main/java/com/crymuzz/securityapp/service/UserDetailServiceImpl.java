package com.crymuzz.securityapp.service;

import com.crymuzz.securityapp.entity.UserEntity;
import com.crymuzz.securityapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscamos en la BD persistencia el nombre de usuario
        UserEntity userEntity = userRepository.findUserEntityByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario no existe: " + username));

        // Lista de autorizados
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        // Convertimos un en SimpleGrantedAuthoriry (Existe)
        userEntity.getRoles().forEach(rol -> authorities.add(new SimpleGrantedAuthority("ROLE_" + rol.getRoleEnum().name())));

        userEntity.getRoles()
                .stream()
                .flatMap(role -> role.getPermissions().stream())
                .forEach(permission -> authorities.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.isEnable(),
                userEntity.isAccountNoExpired(), userEntity.isCredentialNoExpired(), userEntity.isAccountNoLocked(), authorities);
    }


}
