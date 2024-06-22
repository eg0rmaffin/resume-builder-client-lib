package app.resumebuilder.dao.entity.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Map;

/**
 * t_section_element_props table
 */
@Data
@Entity
@Table(name = "t_section_element_props")
public class T_SectionElementProps {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "key")
    private String key;

    @Column(name = "text")
    private String text;

    @ElementCollection
    @Column(name = "wrapper_style")
    private Map<String, String> wrapperStyle;

    @ElementCollection
    @Column(name = "text_style")
    private Map<String, String> textStyle;

    @ElementCollection
    @Column(name = "style")
    private Map<String, String> style;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "props")
    private T_BlockElement tBlockElement;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T_SectionElementProps that = (T_SectionElementProps) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + id;
        return hashCode;
    }
}
