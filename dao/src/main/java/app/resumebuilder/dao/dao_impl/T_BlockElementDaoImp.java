package app.resumebuilder.dao.dao_impl;

import app.resumebuilder.dao.dao_abstract.T_BlockElementDao;
import app.resumebuilder.dao.entity.dto.T_BlockElementDTO;
import app.resumebuilder.dao.entity.model.T_BlockElement;
import app.resumebuilder.dao.mapper.DataConverter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс T_BlockElementDaoImp
 * Наследован от конкретного интерфейса dao_abstract
 * Принимает/возвращает тип DTO
 * Внутри работает с model классами,
 * конвертируя их в DTO для удобной работы
 */

@Repository
@Transactional
public class T_BlockElementDaoImp implements T_BlockElementDao {
    private final String DELETE = "delete from T_BlockElement where id = :id";
    private final String ID = "id";
    private final String SELECT = "from T_BlockElement";

    @PersistenceContext
    private EntityManager entityManager;

    private DataConverter dataConverter;

    @Autowired
    public T_BlockElementDaoImp(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public void save(T_BlockElementDTO dto) {
        entityManager.persist(dataConverter.convertToModel(
                dto,
                T_BlockElement.class
        ));
    }

    @Override
    public void update(T_BlockElementDTO dto) {
        entityManager.merge(dataConverter.convertToModel(
                dto,
                T_BlockElement.class
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
    public T_BlockElementDTO findById(Integer id) {
        return dataConverter.convertToDTO(
                entityManager.find(T_BlockElement.class, id),
                T_BlockElementDTO.class
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<T_BlockElementDTO> findAll() {
        return entityManager.createQuery(SELECT, T_BlockElement.class)
                .getResultList()
                .stream()
                .map(e -> dataConverter.convertToDTO(
                        e, T_BlockElementDTO.class
                ))
                .collect(Collectors.toList());
    }
}
