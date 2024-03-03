package com.example.manzionepropertiesauthserver.config;

import com.example.manzionepropertiesauthserver.entity.UserMP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserMP, Long> {
    UserDetails findByUsername(String username);
}