package app.resumebuilder.dao.entity.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * roles table
 */

@Entity
@Data
@Table(name = "roles")
public class RoleData {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "role_name")
    private String roleName;

    @Transient
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roleSet")
    private Set<PersonalDataType> users;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleData that = (RoleData) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + id;
        return hashCode;
    }

    @Override
    public String toString() {
        return roleName;
    }


}