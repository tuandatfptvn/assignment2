package com.tri.accountservice_se173191.controller;

import com.tri.accountservice_se173191.dto.ApiResponse;
import com.tri.accountservice_se173191.dto.AuthResponse;
import com.tri.accountservice_se173191.dto.UserLoginRequest;
import com.tri.accountservice_se173191.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/token")
    public ApiResponse<AuthResponse> getToken(@RequestBody UserLoginRequest request){
        return ApiResponse.success(authService.getToken(request));
    }

    @GetMapping("/ping")
    public String ping(){
        return "OK";
    }

    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    @GetMapping("/ping-role")
    public String ping2(){
        return "OK";
    }


}
