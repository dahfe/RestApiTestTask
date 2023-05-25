package test.restapi.cities.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import test.restapi.cities.exception.ModelExistsException;
import test.restapi.cities.model.User;
import test.restapi.cities.repository.RoleRepository;
import test.restapi.cities.repository.UserRepository;
import test.restapi.cities.security.JwtTokenUtil;
import test.restapi.cities.security.JwtUserDetailsService;
import test.restapi.cities.service.AuthService;


@Service
@Slf4j
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final JwtUserDetailsService jwtUserDetailsService;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public String loginWithUsernameAndPassword(String username, String password){
        authenticate(username, password);
        final UserDetails userDetails = jwtUserDetailsService
                .loadUserByUsername(username);
        return jwtTokenUtil.generateToken(userDetails);

    }

    private void authenticate(String username, String password){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new DisabledException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }

    @Override
    public void saveUser(User user) {
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            throw new ModelExistsException("Username already taken");
        }
        user.setRoles(roleRepository.findByName("ROLE_USER"));
        user.setUsername(user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}
