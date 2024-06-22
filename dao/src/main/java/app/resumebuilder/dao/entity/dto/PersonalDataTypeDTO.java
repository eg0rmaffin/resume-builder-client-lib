package app.resumebuilder.dao.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.util.Assert;

import java.io.File;
import java.io.Serializable;
import java.util.Set;

/**
 * DTO класса PersonalDataType
 */
@Getter
@Setter
@NoArgsConstructor
public final class PersonalDataTypeDTO implements Serializable {

    private int id;

    private String fullName;

    private String adress;

    private String bio;

    private String position;

    private long phone;

    private String website;

    private String mail;

    private String password;

    private File image;

    private ITemporaryCvDataSlicePropsDTO iTemporaryCvDataSliceProps;

    private Set<RoleDTO> roleSet;

    public PersonalDataTypeDTO(int id,
                               String fullName,
                               String adress,
                               String bio,
                               String position,
                               long phone,
                               String website,
                               String mail,
                               String password,
                               File image,
                               ITemporaryCvDataSlicePropsDTO iTemporaryCvDataSliceProps,
                               Set<RoleDTO> roleSet) {
        Assert.notNull(id, "id cannot be null");
        Assert.notNull(fullName, "FullName cannot be null");
        Assert.notNull(adress, "Adress cannot be null");
        Assert.notNull(bio, "Bio cannot be null");
        Assert.notNull(position, "position cannot be null");
        Assert.notNull(phone, "Phone cannot be null");
        Assert.notNull(website, "Website cannot be null");
        Assert.notNull(mail, "Mail cannot be null");
        Assert.notNull(password,"Password cannot be null");
        Assert.notNull(roleSet, "Roles cannot be null");
        Assert.notNull(image, "Image cannot be null");
        Assert.notNull(iTemporaryCvDataSliceProps, "ITemporaryCvDataSliceProps cannot be null");

        this.id = id;
        this.fullName = fullName;
        this.adress = adress;
        this.bio = bio;
        this.position = position;
        this.phone = phone;
        this.website = website;
        this.mail = mail;
        this.password = password;
        this.image = image;
        this.iTemporaryCvDataSliceProps = iTemporaryCvDataSliceProps;
        this.roleSet = roleSet;
    }
}
