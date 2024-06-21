package app.resumebuilder.eurekaclientmodel.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * doc about class
 */

@Data
@Entity
@Table(name = "layout")
public class Layout {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "layout")
    private T_BlockElement tBlockElement;

    @Column(name = "x")
    private int x;

    @Column(name = "i")
    private String i;

    @Column(name = "y")
    private int y;

    @Column(name = "w")
    private int w;

    @Column(name = "h")
    private int h;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Layout that = (Layout) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + id;
        return hashCode;
    }
}
