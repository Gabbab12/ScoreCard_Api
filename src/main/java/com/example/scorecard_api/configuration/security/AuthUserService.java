package com.example.scorecard_api.configuration.security;

import com.example.scorecard_api.exception.AccountNotActiveException;
import com.example.scorecard_api.model.CustomUserDetail;
import com.example.scorecard_api.model.User;
import com.example.scorecard_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(()-> new UsernameNotFoundException(
                email + " was not found"));
       if(user.getIsAccountActive()) {
           return new CustomUserDetail(user);
       }else
           throw new AccountNotActiveException("User account is not active");

    }
}


