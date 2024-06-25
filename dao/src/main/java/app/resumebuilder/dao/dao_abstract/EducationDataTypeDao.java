package app.resumebuilder.dao.dao_abstract;

import app.resumebuilder.dao.dao.ReadWriteDao;
import app.resumebuilder.dto.EducationDataTypeDTO;

import java.util.List;

/**
 * Интерфейс EducationDataType DAO
 * Принимает/возвращает тип DTO
 */

public interface EducationDataTypeDao extends ReadWriteDao<Integer, EducationDataTypeDTO> {
    void save(EducationDataTypeDTO educationDataTypeDTO);
    void update(EducationDataTypeDTO educationDataTypeDTO);
    void deleteById(Integer id);
    EducationDataTypeDTO findById(Integer id);
    List<EducationDataTypeDTO> findAll();
}
