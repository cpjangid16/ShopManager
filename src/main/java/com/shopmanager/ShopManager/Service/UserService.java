package com.shopmanager.ShopManager.Service;

import com.shopmanager.ShopManager.Entity.User;
import com.shopmanager.ShopManager.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register (User user) {
       if(userRepository.existsByUsername(user.getUsername())) {
           throw new IllegalArgumentException("Username is already in use");
       }
       if(user.getRole() == null) user.setRole("ROLE_USER");
       user.setPassword(passwordEncoder.encode(user.getPassword()));
       return userRepository.save(user);
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
