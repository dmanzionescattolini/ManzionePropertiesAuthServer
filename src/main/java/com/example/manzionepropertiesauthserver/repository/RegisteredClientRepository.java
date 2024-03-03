package com.example.manzionepropertiesauthserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

import java.util.Optional;

public interface RegisteredClientRepository extends JpaRepository<RegisteredClient, Long> {

    RegisteredClient findByClientId(Long clientId);


}