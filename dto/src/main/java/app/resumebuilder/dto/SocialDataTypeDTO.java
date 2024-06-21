package app.resume_builder.resume_builder_libs.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.util.Assert;

import java.io.File;
import java.io.Serializable;

/**
 * DTO класса SocialDataType
 */
@Getter
@Setter
@NoArgsConstructor
public final class SocialDataTypeDTO implements Serializable {

    private int id;

    private String link;

    private String name;

    private File imageFile;

    private ITemporaryCvDataSlicePropsDTO iTemporaryCvDataSliceProps;

    public SocialDataTypeDTO(int id,
                             String link,
                             String name,
                             File imageFile,
                             ITemporaryCvDataSlicePropsDTO iTemporaryCvDataSliceProps) {
        Assert.notNull(link, "Link cannot be null");
        Assert.notNull(name, "name cannot be null");
        Assert.notNull(id, "id cannot be null");
        Assert.notNull(imageFile, "imageFile cannot be null");
        Assert.notNull(iTemporaryCvDataSliceProps, "iTemporaryCvDataSliceProps cannot be null");

        this.id = id;
        this.link = link;
        this.name = name;
        this.imageFile = imageFile;
        this.iTemporaryCvDataSliceProps = iTemporaryCvDataSliceProps;
    }
}
