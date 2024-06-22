package app.resumebuilder.dao.dao_abstract;

import app.resumebuilder.dao.dao.ReadWriteDao;
import app.resumebuilder.dao.entity.dto.HobbyDataTypeDTO;

import java.util.List;

/**
 * Интерфейс HobbyDataType DAO
 * Принимает/возвращает тип DTO
 */

public interface HobbyDataTypeDao extends ReadWriteDao<Integer, HobbyDataTypeDTO> {
    void save(HobbyDataTypeDTO dto);
    void update(HobbyDataTypeDTO dto);
    void deleteById(Integer id);
    HobbyDataTypeDTO findById(Integer id);
    List<HobbyDataTypeDTO> findAll();
}
