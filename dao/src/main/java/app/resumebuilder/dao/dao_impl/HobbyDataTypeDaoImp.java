package app.resumebuilder.dao.dao_impl;

import app.resumebuilder.dao.dao_abstract.HobbyDataTypeDao;
import app.resumebuilder.dao.entity.dto.HobbyDataTypeDTO;
import app.resumebuilder.dao.entity.model.HobbyDataType;
import app.resumebuilder.dao.mapper.DataConverter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс HobbyDataTypeDaoImp
 * Наследован от конкретного интерфейса dao_abstract
 * Принимает/возвращает тип DTO
 * Внутри работает с model классами,
 * конвертируя их в DTO для удобной работы
 */

@Repository
@Transactional
public class HobbyDataTypeDaoImp implements HobbyDataTypeDao {
    private final String DELETE = "delete from HobbyDataType where id = :id";
    private final String ID = "id";
    private final String SELECT = "from HobbyDataType";

    @PersistenceContext
    private EntityManager entityManager;

    private DataConverter dataConverter;

    @Autowired
    public HobbyDataTypeDaoImp(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public void save(HobbyDataTypeDTO dto) {
        entityManager.persist(dataConverter.convertToModel(
                dto,
                HobbyDataType.class
        ));
    }

    @Override
    public void update(HobbyDataTypeDTO dto) {
        entityManager.merge(dataConverter.convertToModel(
                dto,
                HobbyDataType.class
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
    public HobbyDataTypeDTO findById(Integer id) {
        return dataConverter.convertToDTO(
                entityManager.find(HobbyDataType.class, id),
                HobbyDataTypeDTO.class
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<HobbyDataTypeDTO> findAll() {
        return entityManager.createQuery(SELECT, HobbyDataType.class)
                .getResultList()
                .stream()
                .map(e -> dataConverter.convertToDTO(
                        e, HobbyDataTypeDTO.class
                ))
                .collect(Collectors.toList());
    }
}
