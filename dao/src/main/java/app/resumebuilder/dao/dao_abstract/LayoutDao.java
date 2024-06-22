package app.resumebuilder.dao.dao_abstract;

import app.resumebuilder.dao.dao.ReadWriteDao;
import app.resumebuilder.dao.entity.dto.LayoutDTO;

import java.util.List;

/**
 * Интерфейс Layout DAO
 * Принимает/возвращает тип DTO
 */

public interface LayoutDao extends ReadWriteDao<Integer, LayoutDTO> {
    void save(LayoutDTO layoutDTO);
    void update(LayoutDTO layoutDTO);
    void deleteById(Integer id);
    LayoutDTO findById(Integer id);
    List<LayoutDTO> findAll();
}
