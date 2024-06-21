package app.resume_builder.resume_builder_libs.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.util.Assert;

import java.io.Serializable;

/**
 * DTO класса ExperienceDataType
 */
@Getter
@Setter
@NoArgsConstructor
public final class ExperienceDataTypeDTO implements Serializable {

    private int id;

    private String description;

    private String position;

    private String fromYear;

    private String toYear;

    private String name;

    private ITemporaryCvDataSlicePropsDTO iTemporaryCvDataSliceProps;

    public ExperienceDataTypeDTO(int id,
                                 String description,
                                 String position,
                                 String fromYear,
                                 String toYear,
                                 String name,
                                 ITemporaryCvDataSlicePropsDTO iTemporaryCvDataSliceProps) {
        Assert.notNull(description, "Description cannot be null");
        Assert.notNull(position, "Position cannot be null");
        Assert.notNull(fromYear, "From year cannot be null");
        Assert.notNull(toYear, "To year cannot be null");
        Assert.notNull(name, "Name cannot be null");
        Assert.notNull(id, "Id cannot be null");
        Assert.notNull(iTemporaryCvDataSliceProps, "ITemporaryCvDataSliceProps cannot be null");

        this.id = id;
        this.description = description;
        this.position = position;
        this.fromYear = fromYear;
        this.toYear = toYear;
        this.name = name;
        this.iTemporaryCvDataSliceProps = iTemporaryCvDataSliceProps;
    }
}
