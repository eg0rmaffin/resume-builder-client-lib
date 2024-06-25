package app.resumebuilder.dao.dao_abstract;

import app.resumebuilder.dao.dao.ReadWriteDao;
import app.resumebuilder.dto.RoleDTO;

import java.util.List;

/**
 * Интерфейс RoleData DAO
 * Принимает/возвращает тип DTO
 */

public interface RoleDataDao extends ReadWriteDao<Integer, RoleDTO> {
    void save(RoleDTO role);
    void update(RoleDTO role);
    void deleteById(Integer id);
    RoleDTO findById(Integer id);
    List<RoleDTO> findAll();
}
