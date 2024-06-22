package app.resumebuilder.dao.dao_impl;

import app.resumebuilder.dao.dao_abstract.T_SectionElementPropsDao;
import app.resumebuilder.dao.entity.dto.T_SectionElementPropsDTO;
import app.resumebuilder.dao.entity.model.T_SectionElementProps;
import app.resumebuilder.dao.mapper.DataConverter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс T_SectionElementPropsDaoImp
 * Наследован от конкретного интерфейса dao_abstract
 * Принимает/возвращает тип DTO
 * Внутри работает с model классами,
 * конвертируя их в DTO для удобной работы
 */

@Repository
@Transactional
public class T_SectionElementPropsDaoImp implements T_SectionElementPropsDao {
    private final String DELETE = "delete from T_SectionElementProps where id = :id";
    private final String ID = "id";
    private final String SELECT = "from T_SectionElementProps";

    @PersistenceContext
    private EntityManager entityManager;

    private DataConverter dataConverter;

    @Autowired
    public T_SectionElementPropsDaoImp(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public void save(T_SectionElementPropsDTO dto) {
        entityManager.persist(dataConverter.convertToModel(
                dto, T_SectionElementProps.class
        ));
    }

    @Override
    public void update(T_SectionElementPropsDTO dto) {
        entityManager.merge(dataConverter.convertToModel(
                dto, T_SectionElementProps.class
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
    public T_SectionElementPropsDTO findById(Integer id) {
        return dataConverter.convertToDTO(
                entityManager.find(T_SectionElementProps.class, id),
                T_SectionElementPropsDTO.class
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<T_SectionElementPropsDTO> findAll() {
        return entityManager.createQuery(SELECT, T_SectionElementProps.class)
                .getResultList()
                .stream()
                .map(e -> dataConverter.convertToDTO(
                        e, T_SectionElementPropsDTO.class
                ))
                .collect(Collectors.toList());
    }
}
