package app.resumebuilder.dao.entity.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * hobby_data_type table
 */

@Data
@Entity
@Table(name = "hobby_data_type")
public class HobbyDataType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "personal_data")
    private String hobby;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "i_temporary_cv_data_slice_props_id")
    private ITemporaryCvDataSliceProps iTemporaryCvDataSliceProps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HobbyDataType that = (HobbyDataType) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + id;
        return hashCode;
    }
}
