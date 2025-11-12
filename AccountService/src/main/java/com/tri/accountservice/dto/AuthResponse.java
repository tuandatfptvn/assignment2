package com.tri.accountservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record AuthResponse(boolean isAuthenticate, String jwtToken, String role) {
}
