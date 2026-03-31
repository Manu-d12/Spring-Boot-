package com.spring_concepts.Controllers;

import com.spring_concepts.services.ProfileService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/profile")
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping
    public String createProfile(@RequestBody Map<String, String> data) {
        return this.profileService.createProfile(data);
    }
}
