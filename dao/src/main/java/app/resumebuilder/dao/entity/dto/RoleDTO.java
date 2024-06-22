package app.resumebuilder.dao.entity.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.modelmapper.internal.util.Assert;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public final class RoleDTO implements Serializable {

    private int id;

    private String roleName;

    public RoleDTO(int id, String roleName) {
        Assert.notNull(roleName, "Role Name cannot be null");
        Assert.notNull(id, "Role ID cannot be null");

        this.id = id;
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return roleName;
    }
}