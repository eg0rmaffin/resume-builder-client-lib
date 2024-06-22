package app.resumebuilder.dao.entity.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.File;

/**
 * social_data_type table
 */

@Data
@Entity
@Table(name = "social_data_type")
public class SocialDataType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "link")
    private String link;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "image_file")
    private File imageFile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "i_temporary_cv_data_slice_props_id")
    private ITemporaryCvDataSliceProps iTemporaryCvDataSliceProps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialDataType that = (SocialDataType) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + id;
        return hashCode;
    }
}
