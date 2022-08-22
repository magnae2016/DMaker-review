package com.spring.dmaker.review.dto;

import com.spring.dmaker.review.type.DeveloperLevelType;
import com.spring.dmaker.review.type.DeveloperSkillType;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateDeveloper {
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @ToString
    public static class Request {
        @NotNull
        private DeveloperLevelType developerLevelType;
        @NotNull
        private DeveloperSkillType developerSkillType;
        @NotNull
        @Min(0)
        @Max(20)
        private Integer experienceYears;

        @NotNull
        @Size(min = 3, max = 50, message = "memberId size must 3 ~ 50")
        private String memberId;
        @NotNull
        @Size(min = 3, max = 20, message = "name size must 3 ~ 20")
        private String name;
        @Min(18)
        private Integer age;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private DeveloperLevelType developerLevelType;
        private DeveloperSkillType developerSkillType;
        private Integer experienceYears;
        private String memberId;
    }
}
