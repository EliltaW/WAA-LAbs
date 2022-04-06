package edu.miu.waa.lab1.service;

import edu.miu.waa.lab1.model.dto.request.LoginRequest;
import edu.miu.waa.lab1.model.dto.request.RefreshTokenRequest;
import edu.miu.waa.lab1.model.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
