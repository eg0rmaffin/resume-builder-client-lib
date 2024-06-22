package app.resumebuilder.dao.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.util.Assert;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO класса StatePropsDTO
 */
@Getter
@Setter
@NoArgsConstructor
public final class StatePropsDTO implements Serializable {

    private int id;

    private Set<T_BlockElementDTO> activeElements;

    public StatePropsDTO(int id, Set<T_BlockElementDTO> activeElements) {
        Assert.notNull(activeElements, "ActiveElements cannot be null");
        Assert.notNull(id, "Id cannot be null");

        this.id = id;
        this.activeElements = activeElements;
    }
}
