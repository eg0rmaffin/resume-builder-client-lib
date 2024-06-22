package app.resumebuilder.dao.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.util.Assert;

import java.io.Serializable;

/**
 * DTO класса AvatarDataType
 */
@Getter
@Setter
@NoArgsConstructor
public final class AvatarDataTypeDTO implements Serializable {

    private int id;

    private String avatar;

    public AvatarDataTypeDTO(int id, String avatar) {
        Assert.notNull(id, "id cannot be null");
        Assert.notNull(avatar, "Avatar cannot be null");

        this.id = id;
        this.avatar = avatar;
    }
}

