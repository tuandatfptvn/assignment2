package com.tri.accountservice.service.impl;

import com.tri.accountservice.dto.AuthResponse;
import com.tri.accountservice.dto.UserLoginRequest;
import com.tri.accountservice.entity.User;
import com.tri.accountservice.repository.UserRepository;
import com.tri.accountservice.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtEncoder jwtEncoder;

    @Override
    public AuthResponse getToken(UserLoginRequest request) {
        User user = userRepository.findUserByEmail(request.getEmail());
        if(Objects.isNull(user) || !passwordEncoder.matches(request.getPassword(), user.getPassword()) || !user.isActive())
            return AuthResponse.builder()
                    .isAuthenticate(false)
                    .jwtToken(null)
                    .role(null)
                    .build();


        return AuthResponse.builder()
                .isAuthenticate(true)
                .jwtToken(generateToken(user))
                .role(String.valueOf(user.getRole()))
                .build();

    }

    public String generateToken(User user) {
        JwsHeader jwsHeader = JwsHeader.with(MacAlgorithm.HS256).build();
        JwtClaimsSet claimsSet = JwtClaimsSet.builder()
                .id(UUID.randomUUID().toString())
                .issuer("tri")
                .subject(user.getEmail())
                .claim("scp", user.getRole())
                .build();
        return jwtEncoder.encode(JwtEncoderParameters.from(jwsHeader, claimsSet)).getTokenValue();
    }


}
