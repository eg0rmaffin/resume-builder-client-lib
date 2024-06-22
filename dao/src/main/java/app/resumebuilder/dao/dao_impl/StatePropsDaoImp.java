package app.resumebuilder.dao.dao_impl;

import app.resumebuilder.dao.dao_abstract.StatePropsDao;
import app.resumebuilder.dao.entity.dto.StatePropsDTO;
import app.resumebuilder.dao.entity.model.StateProps;
import app.resumebuilder.dao.mapper.DataConverter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс StatePropsDaoImp
 * Наследован от конкретного интерфейса dao_abstract
 * Принимает/возвращает тип DTO
 * Внутри работает с model классами,
 * конвертируя их в DTO для удобной работы
 */

@Repository
@Transactional
public class StatePropsDaoImp implements StatePropsDao {
    private final String DELETE = "delete from StateProps where id = :id";
    private final String ID = "id";
    private final String SELECT = "from StateProps";

    @PersistenceContext
    private EntityManager entityManager;

    private DataConverter dataConverter;

    @Autowired

    public StatePropsDaoImp(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public void save(StatePropsDTO statePropsDTO) {
        entityManager.persist(dataConverter.convertToModel(
                statePropsDTO,
                StateProps.class
        ));
    }

    @Override
    public void update(StatePropsDTO statePropsDTO) {
        entityManager.merge(dataConverter.convertToModel(
                statePropsDTO,
                StateProps.class
        ));
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.createQuery(DELETE)
                .setParameter(ID, id)
                .executeUpdate();
    }

    @Override
    @Transactional(readOnly = true)
    public StatePropsDTO findById(Integer id) {
        return dataConverter.convertToDTO(
                entityManager.find(StateProps.class, id),
                StatePropsDTO.class
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<StatePropsDTO> findAll() {
        return entityManager.createQuery(SELECT, StateProps.class)
                .getResultList()
                .stream()
                .map(e -> dataConverter.convertToDTO(
                        e, StatePropsDTO.class
                ))
                .collect(Collectors.toList());
    }
}
