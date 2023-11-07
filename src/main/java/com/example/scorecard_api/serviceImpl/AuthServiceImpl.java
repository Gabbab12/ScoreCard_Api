package com.example.scorecard_api.serviceImpl;


import com.example.scorecard_api.configuration.security.AuthUserService;
import com.example.scorecard_api.configuration.security.JwtService;
import com.example.scorecard_api.dto.requestdto.LoginDto;
import com.example.scorecard_api.dto.responsedto.LoginResponse;
import com.example.scorecard_api.dto.responsedto.UserDto;
import com.example.scorecard_api.exception.AuthorizationException;
import com.example.scorecard_api.exception.UserNotFoundException;
import com.example.scorecard_api.model.User;
import com.example.scorecard_api.repository.UserRepository;
import com.example.scorecard_api.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    private final AuthUserService authUserService;

    private final JwtService jwtService;

    @Override
    public LoginResponse login(LoginDto loginDto) throws Exception {
        Authentication auth;
        try {
            auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));

        }catch (DisabledException | BadCredentialsException e){
            throw new Exception(e.getMessage());
        }

        if(auth.isAuthenticated()){
            SecurityContextHolder.getContext().setAuthentication(auth);
            UserDetails userDetails = authUserService.loadUserByUsername(loginDto.getEmail());

            User user = userRepository.findByEmail(loginDto.getEmail()).orElseThrow(()->new UserNotFoundException("User not found"));

            UserDto userDto = new UserDto(user.getId(),user.getFirstName(),user.getEmail(),user.getRole());

            String token = "Bearer " + jwtService.generateToken(userDetails);

            return new LoginResponse(true,"logged in successful",token,userDto);
        }else{
            throw new AuthorizationException("Email or password Not Authenticated ");
        }

    }
}