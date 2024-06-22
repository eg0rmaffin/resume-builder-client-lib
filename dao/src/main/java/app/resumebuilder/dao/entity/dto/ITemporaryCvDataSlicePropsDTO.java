package app.resumebuilder.dao.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.util.Assert;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO класса ITemporaryCvDataSliceProps
 */
@Getter
@Setter
@NoArgsConstructor
public final class ITemporaryCvDataSlicePropsDTO implements Serializable {

    private int id;

    private PersonalDataTypeDTO personalData;

    private Set<EducationDataTypeDTO> educationData;

    private Set<ExperienceDataTypeDTO> experienceData;

    private Set<SocialDataTypeDTO> socialData;

    private Set<HobbyDataTypeDTO> hobbyData;

    public ITemporaryCvDataSlicePropsDTO(
            int id,
            PersonalDataTypeDTO personalData,
            Set<EducationDataTypeDTO> educationData,
            Set<ExperienceDataTypeDTO> experienceData,
            Set<SocialDataTypeDTO> socialData,
            Set<HobbyDataTypeDTO> hobbyData) {
        Assert.notNull(personalData, "PersonalData cannot be null");
        Assert.notNull(educationData, "EducationData cannot be null");
        Assert.notNull(experienceData, "ExperienceData cannot be null");
        Assert.notNull(socialData, "SocialData cannot be null");
        Assert.notNull(hobbyData, "HobbyData cannot be null");

        this.id = id;
        this.personalData = personalData;
        this.educationData = educationData;
        this.experienceData = experienceData;
        this.socialData = socialData;
        this.hobbyData = hobbyData;
    }
}
