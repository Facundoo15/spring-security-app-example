package com.crymuzz.securityapp;

import com.crymuzz.securityapp.entity.PermissionEntity;
import com.crymuzz.securityapp.entity.RoleEntity;
import com.crymuzz.securityapp.entity.RoleEnum;
import com.crymuzz.securityapp.entity.UserEntity;
import com.crymuzz.securityapp.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;
import java.util.Set;

@SpringBootApplication
public class SecurityappApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityappApplication.class, args);
    }


//    @Bean
//    CommandLineRunner init(UserRepository userRepository){
//        return args -> {
//            // CREATE PERMISSIONS
//            PermissionEntity createPermission = PermissionEntity.builder().name("CREATE").build();
//            PermissionEntity readPermission = PermissionEntity.builder().name("READ").build();
//            PermissionEntity deletePermission = PermissionEntity.builder().name("DELETE").build();
//            PermissionEntity updatePermission = PermissionEntity.builder().name("UPDATE").build();
//
//            RoleEntity roleAdmin = RoleEntity.builder()
//                    .roleEnum(RoleEnum.ADMIN)
//                    .permissions(Set.of(createPermission, readPermission, deletePermission, updatePermission))
//                    .build();
//            RoleEntity roleUser = RoleEntity.builder()
//                    .roleEnum(RoleEnum.USER)
//                    .permissions(Set.of(createPermission, readPermission))
//                    .build();
//
//            // CREATE USERS
//            UserEntity userFavio = UserEntity.builder().username("Favio")
//                    .password(passwordEncoder("12345"))
//                    .isEnable(true)
//                    .accountNoExpired(true)
//                    .accountNoLocked(true)
//                    .credentialNoExpired(true)
//                    .roles(Set.of(roleAdmin))
//                    .build();
//            UserEntity userFacundo = UserEntity.builder().username("Facundo")
//                    .password(passwordEncoder("54321"))
//                    .isEnable(true)
//                    .accountNoExpired(true)
//                    .accountNoLocked(true)
//                    .credentialNoExpired(true)
//                    .roles(Set.of(roleUser))
//                    .build();
//            UserEntity userMarco = UserEntity.builder().username("Marco")
//                    .password(passwordEncoder("56789"))
//                    .isEnable(true)
//                    .accountNoExpired(true)
//                    .accountNoLocked(true)
//                    .credentialNoExpired(true)
//                    .roles(Set.of(roleAdmin))
//                    .build();
//
//            userRepository.saveAll(Arrays.asList(userFavio,userFacundo,userMarco));
//        };
//    }
//
//
//    private static String passwordEncoder(String password) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        return encoder.encode(password);
//    }

}
