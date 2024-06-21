package app.resume_builder.resume_builder_libs.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.util.Assert;

import java.io.Serializable;
import java.util.Map;

/**
 * DTO класса T_SectionElementProps
 */
@Getter
@Setter
@NoArgsConstructor
public final class T_SectionElementPropsDTO implements Serializable {

    private int id;

    private String key;

    private String text;

    private Map<String, String> wrapperStyle;

    private Map<String, String> textStyle;

    private Map<String, String> style;

    private T_BlockElementDTO tBlockElement;

    public T_SectionElementPropsDTO(int id,
                                    String key,
                                    String text,
                                    Map<String, String> wrapperStyle,
                                    Map<String, String> textStyle,
                                    Map<String, String> style,
                                    T_BlockElementDTO tBlockElement) {
        Assert.notNull(key, "Key cannot be null");
        Assert.notNull(text, "Text cannot be null");
        Assert.notNull(wrapperStyle, "wrapperStyle cannot be null");
        Assert.notNull(textStyle, "TextStyle cannot be null");
        Assert.notNull(style, "Style cannot be null");
        Assert.notNull(tBlockElement, "TBlockElement cannot be null");
        Assert.notNull(id, "Id cannot be null");

        this.id = id;
        this.key = key;
        this.text = text;
        this.wrapperStyle = wrapperStyle;
        this.textStyle = textStyle;
        this.style = style;
        this.tBlockElement = tBlockElement;
    }
}
