package app.resumebuilder.dao.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.util.Assert;

import java.io.Serializable;

/**
 * DTO класса Layout
 */
@Getter
@Setter
@NoArgsConstructor
public final class LayoutDTO implements Serializable {

    private int id;

    private String i;

    private int x;

    private int y;

    private int w;

    private int h;

    public LayoutDTO(int id, String i, int x, int y, int w, int h) {
        Assert.notNull(id, "id cannot be null");
        Assert.notNull(i, "i cannot be null");
        Assert.notNull(x, "x cannot be null");
        Assert.notNull(y, "y cannot be null");
        Assert.notNull(w, "w cannot be null");
        Assert.notNull(h, "h cannot be null");

        this.id = id;
        this.i = i;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
}
