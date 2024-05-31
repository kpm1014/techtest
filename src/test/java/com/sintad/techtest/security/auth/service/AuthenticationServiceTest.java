package com.sintad.techtest.security.auth.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.sintad.techtest.security.auth.dto.LoginUserDto;
import com.sintad.techtest.security.auth.dto.RegisterUserDto;
import com.sintad.techtest.security.auth.model.User;
import com.sintad.techtest.security.auth.repository.UserRepository;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class AuthenticationServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AuthenticationManager authenticationManager;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private AuthenticationService authenticationService;

    public AuthenticationServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSignup() {
        RegisterUserDto registerUserDto = new RegisterUserDto("John Doe", "john@example.com", "password");
        User user = new User("John Doe", "john@example.com", "encodedPassword");

        when(passwordEncoder.encode(registerUserDto.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(any(User.class))).thenReturn(user);

        User result = authenticationService.signup(registerUserDto);

        assertEquals("John Doe", result.getFullName());
        assertEquals("john@example.com", result.getEmail());
        assertEquals("encodedPassword", result.getPassword());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    public void testAuthenticate() {
        LoginUserDto loginUserDto = new LoginUserDto("john@example.com", "password");
        User user = new User("John Doe", "john@example.com", "encodedPassword");
        Authentication authentication = mock(Authentication.class);

        when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authentication);
        when(userRepository.findByEmail(loginUserDto.getEmail())).thenReturn(Optional.of(user));

        User result = authenticationService.authenticate(loginUserDto);

        assertEquals("John Doe", result.getFullName());
        assertEquals("john@example.com", result.getEmail());
        assertEquals("encodedPassword", result.getPassword());
        verify(authenticationManager, times(1)).authenticate(any(UsernamePasswordAuthenticationToken.class));
        verify(userRepository, times(1)).findByEmail(loginUserDto.getEmail());
    }
}
