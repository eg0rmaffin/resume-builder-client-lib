package app.resumebuilder.dao.dao_abstract;

import app.resumebuilder.dao.dao.ReadWriteDao;
import app.resumebuilder.dao.entity.dto.T_BlockElementDTO;

import java.util.List;

/**
 * Интерфейс T_BlockElement DAO
 * Принимает/возвращает тип DTO
 */

public interface T_BlockElementDao extends ReadWriteDao<Integer, T_BlockElementDTO> {
    void save(T_BlockElementDTO dto);
    void update(T_BlockElementDTO dto);
    void deleteById(Integer id);
    T_BlockElementDTO findById(Integer id);
    List<T_BlockElementDTO> findAll();
}
