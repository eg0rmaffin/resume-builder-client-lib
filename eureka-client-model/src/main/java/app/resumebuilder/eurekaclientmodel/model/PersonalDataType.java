package app.resumebuilder.eurekaclientmodel.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * doc about class
 */

@Data
@Entity
@Table(name = "personal_data_type")
public class PersonalDataType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "adress")
    private String adress;

    @Column(name = "bio")
    private String bio;

    @Column(name = "position")
    private String position;

    @Column(name = "phone")
    private long phone;

    @Column(name = "website")
    private String website;

    @Column(name = "mail", unique = true)
    private String mail;

    @Column(name = "password")
    private String password;

    @Column(name = "image", columnDefinition="LONGBLOB")
    private File image;

    @OneToOne
    @JoinColumn(name = "i_temporary_cv_data_slice_props_id")
    private ITemporaryCvDataSliceProps iTemporaryCvDataSliceProps;

    @Fetch(FetchMode.JOIN)
    @ManyToMany
    @JoinTable(name = "users_roles_table",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleData> roleSet = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonalDataType that = (PersonalDataType) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + id;
        return hashCode;
    }
}
