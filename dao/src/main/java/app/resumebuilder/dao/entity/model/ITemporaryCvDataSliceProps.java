package app.resumebuilder.dao.entity.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * i_temporary_cv_data_slice_props table
 */

@Data
@Entity
@Table(name = "i_temporary_cv_data_slice_props")
public class ITemporaryCvDataSliceProps {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "iTemporaryCvDataSliceProps")
    private PersonalDataType personalData;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "educationData_id")
    private Set<EducationDataType> educationData;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "experienceData_id")
    private Set<ExperienceDataType> experienceData;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "socialData_id")
    private Set<SocialDataType> socialData;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "hobbyData_id")
    private Set<HobbyDataType> hobbyData;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ITemporaryCvDataSliceProps that = (ITemporaryCvDataSliceProps) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + id;
        return hashCode;
    }
}
