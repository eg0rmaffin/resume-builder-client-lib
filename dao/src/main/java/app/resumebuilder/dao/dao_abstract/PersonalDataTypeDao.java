package app.resumebuilder.dao.dao_abstract;

import app.resumebuilder.dao.dao.ReadWriteDao;
import app.resumebuilder.dao.entity.dto.PersonalDataTypeDTO;

import java.io.File;
import java.util.List;

/**
 * Интерфейс PersonalDataType DAO
 * Принимает/возвращает тип DTO
 */

public interface PersonalDataTypeDao extends ReadWriteDao<Integer, PersonalDataTypeDTO> {
    void save(PersonalDataTypeDTO personalDataTypeDTO);
    void update(PersonalDataTypeDTO personalDataTypeDTO);
    void deleteById(Integer id);
    PersonalDataTypeDTO findById(Integer id);
    List<PersonalDataTypeDTO> findAll();

    PersonalDataTypeDTO findByMail(String mail);
    void saveImage(PersonalDataTypeDTO personalDataTypeDTO, File file);
    File getImage(PersonalDataTypeDTO personalDataTypeDTO);
    void updateImage(PersonalDataTypeDTO personalDataTypeDTO, File file);
    void deleteImage(PersonalDataTypeDTO personalDataTypeDTO);
}
