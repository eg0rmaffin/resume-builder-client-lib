package app.resumebuilder.eurekaclientmodel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

/**
 * doc about class
 */
@Data
@Entity
@Table(name = "t_block_element")
public class T_BlockElement {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "source")
    private String source;

    @OneToOne
    @JoinColumn(name = "t_section_element_props_id")
    private T_SectionElementProps props;

    @OneToOne
    @JoinColumn(name = "layout_id")
    private Layout layout;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "state_props_id")
    private StateProps stateProps;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        T_BlockElement that = (T_BlockElement) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + id;
        return hashCode;
    }
}
