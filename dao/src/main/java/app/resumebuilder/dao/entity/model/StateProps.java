package app.resumebuilder.dao.entity.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * state_props table
 */


@Data
@Entity
@Table(name = "state_props")
public class StateProps {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @OneToMany
    @JoinColumn(name = "t_block_element_id")
    private Set<T_BlockElement> activeElements;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateProps that = (StateProps) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        int hashCode = 17;
        hashCode = 31 * hashCode + id;
        return hashCode;
    }
}
