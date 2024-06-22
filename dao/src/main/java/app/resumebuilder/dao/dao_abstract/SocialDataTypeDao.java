package app.resumebuilder.dao.dao_abstract;

import app.resumebuilder.dao.dao.ReadWriteDao;
import app.resumebuilder.dao.entity.dto.SocialDataTypeDTO;

import java.io.File;
import java.util.List;

/**
 * Интерфейс SocialDataType DAO
 * Принимает/возвращает тип DTO
 */

public interface SocialDataTypeDao extends ReadWriteDao<Integer, SocialDataTypeDTO> {
    void save(SocialDataTypeDTO socialDataType);
    void update(SocialDataTypeDTO socialDataType);
    void deleteById(Integer id);
    SocialDataTypeDTO findById(Integer id);
    List<SocialDataTypeDTO> findAll();

    File getImageFile(SocialDataTypeDTO socialDataType);
    void saveImage(SocialDataTypeDTO socialDataType, File imageFile);
    void updateImage(SocialDataTypeDTO socialDataType, File imageFile);
    void deleteImage(SocialDataTypeDTO socialDataType);
}
