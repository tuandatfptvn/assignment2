package com.tri.accountservice_se173191.service;

import com.tri.accountservice_se173191.dto.AuthResponse;
import com.tri.accountservice_se173191.dto.UserLoginRequest;
import jakarta.servlet.http.HttpServletRequest;

public interface AuthService {
    AuthResponse getToken(UserLoginRequest request);

}
