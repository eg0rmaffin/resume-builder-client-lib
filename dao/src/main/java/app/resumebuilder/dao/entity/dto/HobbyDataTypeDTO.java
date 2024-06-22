package app.resumebuilder.dao.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.util.Assert;

import java.io.Serializable;

/**
 * DTO класса HobbyDataType
 */
@Getter
@Setter
@NoArgsConstructor
public final class HobbyDataTypeDTO implements Serializable {

    private int id;

    private String hobby;

    private ITemporaryCvDataSlicePropsDTO iTemporaryCvDataSliceProps;

    public HobbyDataTypeDTO(int id, String hobby, ITemporaryCvDataSlicePropsDTO iTemporaryCvDataSliceProps) {
        Assert.notNull(hobby, "Hobby cannot be null");
        Assert.notNull(id, "Id cannot be null");
        Assert.notNull(iTemporaryCvDataSliceProps, "ITemporaryCvDataSliceProps cannot be null");

        this.id = id;
        this.hobby = hobby;
        this.iTemporaryCvDataSliceProps = iTemporaryCvDataSliceProps;
    }
}
