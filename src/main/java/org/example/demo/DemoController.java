package org.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoController {

    private final DemoRepository repository;

    public DemoController(DemoRepository demoRepository) {
        repository = demoRepository;
    }

    @GetMapping
    public List<UserDTO> getUsers() {
        List<User> users = repository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();

        for (User user : users)
        {
            UserDTO userDTO = new UserDTO(user.getId(), user.getName());
            userDTOS.add(userDTO);
        }

        return userDTOS;
    }

    @PostMapping
    public void createUser(@RequestBody UserDTO userDTO) {
        User user = new User(userDTO.id(), userDTO.name());

        repository.save(user);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/demo").allowedOrigins("https://demo-iwmn.onrender.com");
            }
        };
    }
}
