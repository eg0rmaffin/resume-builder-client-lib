package app.resumebuilder.dao.dao_abstract;

import app.resumebuilder.dao.dao.ReadWriteDao;
import app.resumebuilder.dto.ITemporaryCvDataSlicePropsDTO;

import java.util.List;

/**
 * Интерфейс ITemporaryCvDataSliceProps DAO
 * Принимает/возвращает тип DTO
 */

public interface ITemporaryCvDataSlicePropsDao extends ReadWriteDao<Integer, ITemporaryCvDataSlicePropsDTO> {
    void save(ITemporaryCvDataSlicePropsDTO dto);
    void update(ITemporaryCvDataSlicePropsDTO dto);
    void deleteById(Integer id);
    ITemporaryCvDataSlicePropsDTO findById(Integer id);
    List<ITemporaryCvDataSlicePropsDTO> findAll();
}
