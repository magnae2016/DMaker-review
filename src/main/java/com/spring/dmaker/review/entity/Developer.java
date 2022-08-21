package com.spring.dmaker.review.entity;

import com.spring.dmaker.review.type.DeveloperLevelType;
import com.spring.dmaker.review.type.DeveloperSkillType;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Enumerated(EnumType.STRING)
    private DeveloperLevelType developerLevelType;

    @Enumerated(EnumType.STRING)
    private DeveloperSkillType developerSkillType;
}
