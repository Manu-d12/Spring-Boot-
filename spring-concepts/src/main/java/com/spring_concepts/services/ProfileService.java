package com.spring_concepts.services;

import com.spring_concepts.Dao.ProfileDao;
import com.spring_concepts.entities.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import lombok.AllArgsConstructor;
import org.hibernate.internal.SessionImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@AllArgsConstructor
public class ProfileService {

    private final ProfileDao profileDao;

    public String createProfile(Map<String, String> data) {
        Profile profile = Profile.builder().name(data.get("name")).build();
        profileDao.save(profile);
        return "Profile created successfully!";

//        SessionImpl
//        EntityManagerFactory
    }
}
