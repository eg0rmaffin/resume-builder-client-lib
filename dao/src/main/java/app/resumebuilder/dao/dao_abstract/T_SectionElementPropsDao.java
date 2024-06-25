package app.resumebuilder.dao.dao_abstract;

import app.resumebuilder.dao.dao.ReadWriteDao;
import app.resumebuilder.dto.T_SectionElementPropsDTO;

import java.util.List;

/**
 * Интерфейс T_SectionElementProps DAO
 * Принимает/возвращает тип DTO
 */

public interface T_SectionElementPropsDao extends ReadWriteDao<Integer, T_SectionElementPropsDTO> {
    void save(T_SectionElementPropsDTO dto);
    void update(T_SectionElementPropsDTO dto);
    void deleteById(Integer id);
    T_SectionElementPropsDTO findById(Integer id);
    List<T_SectionElementPropsDTO> findAll();
}
