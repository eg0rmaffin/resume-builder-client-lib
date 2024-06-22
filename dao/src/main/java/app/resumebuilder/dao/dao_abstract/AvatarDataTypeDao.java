package app.resumebuilder.dao.dao_abstract;

import app.resumebuilder.dao.dao.ReadWriteDao;
import app.resumebuilder.dao.entity.dto.AvatarDataTypeDTO;

import java.util.List;

/**
 * Интерфейс AvatarDataType DAO
 * Принимает/возвращает тип DTO
 */

public interface AvatarDataTypeDao extends ReadWriteDao<Integer, AvatarDataTypeDTO> {
    void save(AvatarDataTypeDTO avatarDataTypeDTO);
    void update(AvatarDataTypeDTO avatarDataTypeDTO);
    void deleteById(Integer id);
    AvatarDataTypeDTO findById(Integer id);
    List<AvatarDataTypeDTO> findAll();
}
