package com.example.scorecard_api.controller;


import com.example.scorecard_api.dto.ChangePasswordRequest;
import com.example.scorecard_api.dto.ForgetPasswordRequest;
import com.example.scorecard_api.dto.ResetPasswordRequest;
import com.example.scorecard_api.dto.requestdto.LoginDto;
import com.example.scorecard_api.dto.responsedto.APIResponse;
import com.example.scorecard_api.dto.responsedto.LoginResponse;
import com.example.scorecard_api.service.AuthService;
import com.example.scorecard_api.service.SuperAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class AuthController {

        private  final AuthService authService;

        private final SuperAdminService superAdminService;

        @PostMapping("/login")
        public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto) throws Exception {

            return new ResponseEntity<>(authService.login(loginDto), HttpStatus.OK);
        }

        @GetMapping("/forgot-password")
        public ResponseEntity<APIResponse> forgotPassword(@RequestBody ForgetPasswordRequest forgotPasswordRequest) {
            try {
                return new ResponseEntity<>(new APIResponse<>(true, "Password reset link sent to your email",
                        superAdminService.forgotPassword(forgotPasswordRequest)), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(new APIResponse(false, "User not found", null), HttpStatus.BAD_REQUEST);
            }
        }

        @PostMapping("/reset-password")
        public ResponseEntity<APIResponse> resetPassword(@RequestBody ResetPasswordRequest resetPasswordRequest) {
            try {
                return new ResponseEntity<>(new APIResponse<>(true, "Password reset successfully",
                        superAdminService.resetPassword(resetPasswordRequest)), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(new APIResponse(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
            }
        }
        @PutMapping("/change-password")
        public ResponseEntity<APIResponse> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest, Principal principal) {
            String email = principal.getName();
            try {
                return new ResponseEntity<>(new APIResponse<>(true, "Password changed successfully",
                        superAdminService.changePassword(changePasswordRequest, email)), HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(new APIResponse(false, e.getMessage(), null), HttpStatus.BAD_REQUEST);
            }
        }

}
