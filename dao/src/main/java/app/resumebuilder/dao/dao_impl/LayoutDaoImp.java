package app.resumebuilder.dao.dao_impl;

import app.resumebuilder.dao.dao_abstract.LayoutDao;
import app.resumebuilder.dao.mapper.DataConverter;
import app.resumebuilder.dto.LayoutDTO;
import app.resumebuilder.eurekaclientmodel.model.Layout;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс LayoutDaoImp
 * Наследован от конкретного интерфейса dao_abstract
 * Принимает/возвращает тип DTO
 * Внутри работает с model классами,
 * конвертируя их в DTO для удобной работы
 */

@Repository
@Transactional
public class LayoutDaoImp implements LayoutDao {
    private final String DELETE = "delete from Layout where id = :id";
    private final String ID = "id";
    private final String SELECT = "from Layout";

    @PersistenceContext
    private EntityManager entityManager;

    private DataConverter dataConverter;

    @Autowired
    public LayoutDaoImp(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public void save(LayoutDTO layoutDTO) {
        entityManager.persist(dataConverter.convertToModel(
                layoutDTO,
                Layout.class
        ));
    }

    @Override
    public void update(LayoutDTO layoutDTO) {
        entityManager.merge(dataConverter.convertToModel(
                layoutDTO,
                Layout.class
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
    public LayoutDTO findById(Integer id) {
        return dataConverter.convertToDTO(
                entityManager.find(Layout.class, id),
                LayoutDTO.class
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<LayoutDTO> findAll() {
        return entityManager.createQuery(SELECT, LayoutDTO.class)
                .getResultList()
                .stream()
                .map(e -> dataConverter.convertToDTO(
                        e, LayoutDTO.class
                ))
                .collect(Collectors.toList());
    }
}
