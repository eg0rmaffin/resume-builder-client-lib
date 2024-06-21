package app.resume_builder.resume_builder_libs.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.util.Assert;

import java.io.Serializable;

/**
 * DTO класса T_BlockElement
 */
@Getter
@Setter
@NoArgsConstructor
public final class T_BlockElementDTO implements Serializable {

    private int id;

    private String name;

    private String source;

    private T_SectionElementPropsDTO props;

    private LayoutDTO layout;

    private StatePropsDTO stateProps;

    public T_BlockElementDTO(int id,
                             String name,
                             String source,
                             T_SectionElementPropsDTO props,
                             LayoutDTO layout,
                             StatePropsDTO stateProps) {
        Assert.notNull(id, "id cannot be null");
        Assert.notNull(name, "Name cannot be null");
        Assert.notNull(source, "Source cannot be null");
        Assert.notNull(props, "Props cannot be null");
        Assert.notNull(layout, "Layout cannot be null");
        Assert.notNull(stateProps, "StateProps cannot be null");

        this.id = id;
        this.name = name;
        this.source = source;
        this.props = props;
        this.layout = layout;
        this.stateProps = stateProps;
    }
}
