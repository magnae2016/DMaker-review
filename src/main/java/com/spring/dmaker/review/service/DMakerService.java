package com.spring.dmaker.review.service;

import com.spring.dmaker.review.dto.CreateDeveloper;
import com.spring.dmaker.review.entity.Developer;
import com.spring.dmaker.review.exception.DMakerException;
import com.spring.dmaker.review.repository.DeveloperRepository;
import com.spring.dmaker.review.type.DMakerErrorCode;
import com.spring.dmaker.review.type.DeveloperLevelType;
import com.spring.dmaker.review.type.DeveloperSkillType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;

import static com.spring.dmaker.review.type.DMakerErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;

@Service
@RequiredArgsConstructor
public class DMakerService {
    private final DeveloperRepository developerRepository;

    @Transactional
    public void createDeveloper(CreateDeveloper.Request request) {

        validateCreateDeveloperRequest(request);

        Developer developer = Developer.builder()
                .developerLevel(DeveloperLevelType.JUNGIOR)
                .developerSkill(DeveloperSkillType.FULL_STACK)
                .name("Hannah Kim")
                .age(31)
                .experienceYears(7)
                .build();
        developerRepository.save(developer);
    }

    private void validateCreateDeveloperRequest(CreateDeveloper.Request request) {
        DeveloperLevelType developerLevelType = request.getDeveloperLevelType();
        Integer experienceYears = request.getExperienceYears();

        if (developerLevelType == DeveloperLevelType.SENIOR
                && experienceYears < 10) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        if (developerLevelType == DeveloperLevelType.JUNIOR && (experienceYears < 4 || experienceYears > 10)) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        if (developerLevelType == DeveloperLevelType.JUNIOR && experienceYears > 4) {
            throw new DMakerException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
        }

        developerRepository.findByMemberId(request.getMemberId()).ifPresent(developer -> {
            throw new DMakerException(DMakerErrorCode.DUPLICATED_MEMBER_ID);
        });

    }
}
