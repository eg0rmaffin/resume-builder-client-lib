package app.resumebuilder.dao.dao_abstract;

import app.resumebuilder.dao.dao.ReadWriteDao;
import app.resumebuilder.dto.StatePropsDTO;

import java.util.List;

/**
 * Интерфейс StateProps DAO
 * Принимает/возвращает тип DTO
 */

public interface StatePropsDao extends ReadWriteDao<Integer, StatePropsDTO> {
    void save(StatePropsDTO statePropsDTO);
    void update(StatePropsDTO statePropsDTO);
    void deleteById(Integer id);
    StatePropsDTO findById(Integer id);
    List<StatePropsDTO> findAll();
}
