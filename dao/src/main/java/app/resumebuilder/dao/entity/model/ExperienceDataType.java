package app.resumebuilder.dao.entity.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * experience_data_type table
 */

@Data
@Entity
@Table(name = "experience_data_type")
public class ExperienceDataType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "description")
    private String description;

    @Column(name = "position")
    private String position;

    @Column(name = "from_year")
    private String fromYear;

    @Column(name = "to_year")
    private String toYear;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "i_temporary_cv_data_slice_props_id")
    private ITemporaryCvDataSliceProps iTemporaryCvDataSliceProps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceDataType that = (ExperienceDataType) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + id;
        return hashCode;
    }
}
