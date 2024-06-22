package app.resumebuilder.dao.dao_abstract;

import app.resumebuilder.dao.dao.ReadWriteDao;
import app.resumebuilder.dao.entity.dto.ExperienceDataTypeDTO;

import java.util.List;

/**
 * Интерфейс ExperienceDataType DAO
 * Принимает/возвращает тип DTO
 */

public interface ExperienceDataTypeDao extends ReadWriteDao<Integer, ExperienceDataTypeDTO> {
    void save(ExperienceDataTypeDTO experienceDataTypeDTO);
    void update(ExperienceDataTypeDTO experienceDataTypeDTO);
    void deleteById(Integer id);
    ExperienceDataTypeDTO findById(Integer id);
    List<ExperienceDataTypeDTO> findAll();
}
