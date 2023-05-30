package br.com.sweetspring.sweetspring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sweetspring.sweetspring.dto.UserDTO;
import br.com.sweetspring.sweetspring.entity.User;
import br.com.sweetspring.sweetspring.repository.UserRepository;
import br.com.sweetspring.sweetspring.services.TokenService;

@RestController
@RequestMapping("/Login")
public class LoginController {
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService token;

    @Autowired
    private UserRepository repository;

    @GetMapping("/")
    public String HelloWorld(){
        return "Hello world";
    }

    @PostMapping("/InsertUser")
    public User InsertUser(@RequestBody User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @PostMapping("/Login")
    public String Login(@RequestBody UserDTO user){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.email(), user.password());
        var authentication = this.authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        var userModel = (User) authentication.getPrincipal();
        var tokenGenerated = token.GenerateToken(userModel);
        return tokenGenerated;
    }

}
