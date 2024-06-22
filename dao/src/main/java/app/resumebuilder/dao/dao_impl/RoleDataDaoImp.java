package app.resumebuilder.dao.dao_impl;

import app.resumebuilder.dao.dao_abstract.RoleDataDao;
import app.resumebuilder.dao.entity.dto.RoleDTO;
import app.resumebuilder.dao.entity.model.RoleData;
import app.resumebuilder.dao.mapper.DataConverter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс RoleDataDaoImp
 * Наследован от конкретного интерфейса dao_abstract
 * Принимает/возвращает тип DTO
 * Внутри работает с model классами,
 * конвертируя их в DTO для удобной работы
 */

@Repository
@Transactional
public class RoleDataDaoImp implements RoleDataDao {
    private final String DELETE = "delete from RoleData where id = :id";
    private final String ID = "id";
    private final String SELECT = "from RoleData";

    @PersistenceContext
    private EntityManager entityManager;

    private DataConverter dataConverter;

    @Autowired
    public RoleDataDaoImp(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public void save(RoleDTO role) {
        entityManager.persist(dataConverter.convertToModel(
                role,
                RoleData.class
        ));
    }

    @Override
    public void update(RoleDTO role) {
        entityManager.merge(dataConverter.convertToModel(
                role,
                RoleData.class
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
    public RoleDTO findById(Integer id) {
        return dataConverter.convertToDTO(
                entityManager.find(RoleData.class, id),
                RoleDTO.class
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<RoleDTO> findAll() {
        return entityManager.createQuery(SELECT, RoleData.class)
                .getResultList()
                .stream()
                .map(e -> dataConverter.convertToDTO(
                        e, RoleDTO.class
                ))
                .collect(Collectors.toList());
    }
}
