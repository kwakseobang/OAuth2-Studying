package com.example.oauth2jwt.auth.controller;

import com.example.oauth2jwt.auth.dto.request.LoginRequestDto;
import com.example.oauth2jwt.auth.dto.request.SignUpRequestDto;
import com.example.oauth2jwt.auth.dto.response.AccessTokenResponseDto;
import com.example.oauth2jwt.auth.service.AuthService;
import com.example.oauth2jwt.global.response.ResponseData;
import com.example.oauth2jwt.global.response.responseItem.SuccessCode;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/auth")
@RequiredArgsConstructor
@RestController
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup") // 소셜 로그인 이외 로컬 회원가입.
    public ResponseEntity<ResponseData> signUp(@RequestBody SignUpRequestDto requestDto) {

        // 해당 Dto는 정보가 간단해 그냥 requstDto.filed()로 넘겨줘도 되자만  그냥 적용해봄.
        authService.signUp(requestDto.toSignUpData());
        return ResponseData.success(SuccessCode.CREATED_MEMBER);
    }

    @PostMapping("/login") // 소셜 로그인 이외 로컬 회원가입.
    public ResponseEntity<ResponseData<AccessTokenResponseDto>> login(
            HttpServletResponse response,
            @RequestBody LoginRequestDto requestDto
    ) {
        String accessToken = authService.login(response, requestDto.username(), requestDto.password());
        return ResponseData.success(SuccessCode.LOGIN_SUCCESS,
                new AccessTokenResponseDto(accessToken));
    }

//    @PostMapping("/reissue")

}
