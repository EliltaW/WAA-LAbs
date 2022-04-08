package edu.miu.waa.lab1.service.impl;

import edu.miu.waa.lab1.model.User;
import edu.miu.waa.lab1.model.dto.request.LoginRequest;
import edu.miu.waa.lab1.model.dto.request.RefreshTokenRequest;
import edu.miu.waa.lab1.model.dto.response.LoginResponse;
import edu.miu.waa.lab1.service.AuthService;
import edu.miu.waa.lab1.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

//    @Autowired
//    ModelMapper modelMapper;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
       // User user = modelMapper.map(loginRequest, User.class);
        System.out.println("#################AuthServiceImpl########  user" + loginRequest.getEmail());

        try {
            System.out.println(">>>>>>>>" + loginRequest.getEmail());
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(loginRequest.getEmail());
        System.out.println(">>>>>>>>>>>>>>>>>>userDetailService" + userDetails.getUsername());

        final String accessToken = jwtUtil.generateToken(userDetails);
        final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        System.out.println("********" + loginResponse);
        return loginResponse;
    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtUtil.doGenerateToken( jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponse();
    }

}
