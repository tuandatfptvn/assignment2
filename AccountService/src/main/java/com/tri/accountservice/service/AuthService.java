package com.tri.accountservice.service;

import com.tri.accountservice.dto.AuthResponse;
import com.tri.accountservice.dto.UserLoginRequest;

public interface AuthService {
    AuthResponse getToken(UserLoginRequest request);

}
