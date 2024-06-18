package app.resumebuilder.eurekaclientmodel.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

/**
 * doc about class
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
