package com.spring.dmaker.review.service;

import com.spring.dmaker.review.entity.Developer;
import com.spring.dmaker.review.repository.DeveloperRepository;
import com.spring.dmaker.review.type.DeveloperLevelType;
import com.spring.dmaker.review.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;

    @Transactional
    public void createDeveloper() {
        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevelType.JUNGIOR)
                .developerSkill(DeveloperSkillType.FULL_STACK)
                .name("Hannah Kim")
                .age(31)
                .experienceYears(7)
                .build();
        developerRepository.save(developer);
    }
}
