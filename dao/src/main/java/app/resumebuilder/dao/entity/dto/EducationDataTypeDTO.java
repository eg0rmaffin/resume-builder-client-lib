package app.resumebuilder.dao.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.util.Assert;

import java.io.Serializable;

/**
 * DTO класса EducationDataType
 */
@Getter
@Setter
@NoArgsConstructor
public final class EducationDataTypeDTO implements Serializable {

    private int id;

    private String description;

    private String position;

    private String fromYear;

    private String toYear;

    private String name;

    public EducationDataTypeDTO(int id,
                                String description,
                                String position,
                                String fromYear,
                                String toYear,
                                String name) {
        Assert.notNull(description, "Description cannot be null");
        Assert.notNull(position, "Position cannot be null");
        Assert.notNull(fromYear, "From year cannot be null");
        Assert.notNull(toYear, "To year cannot be null");
        Assert.notNull(name, "Name cannot be null");
        Assert.notNull(id, "Id cannot be null");

        this.id = id;
        this.description = description;
        this.position = position;
        this.fromYear = fromYear;
        this.toYear = toYear;
        this.name = name;
    }
}
