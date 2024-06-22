package app.resumebuilder.dao.entity.model;

import jakarta.persistence.*;
import lombok.Data;

/**
 * avatar_data_type table
 */
@Data
@Entity
@Table(name = "avatar_data_type")
public class AvatarDataType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    private String avatar;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AvatarDataType that = (AvatarDataType) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + id;
        return hashCode;
    }
}
