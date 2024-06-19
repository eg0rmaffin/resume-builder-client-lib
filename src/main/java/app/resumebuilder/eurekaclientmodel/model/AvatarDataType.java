package app.resumebuilder.eurekaclientmodel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * doc about class
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

    public void nothing() {
        System.out.println("asdasdad");
    }

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
