package app.resumebuilder.dao.dao_impl;

import app.resumebuilder.dao.dao_abstract.ExperienceDataTypeDao;
import app.resumebuilder.dao.entity.dto.ExperienceDataTypeDTO;
import app.resumebuilder.dao.entity.model.ExperienceDataType;
import app.resumebuilder.dao.mapper.DataConverter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс ExperienceDataTypeDaoImp
 * Наследован от конкретного интерфейса dao_abstract
 * Принимает/возвращает тип DTO
 * Внутри работает с model классами,
 * конвертируя их в DTO для удобной работы
 */

@Repository
@Transactional
public class ExperienceDataTypeDaoImp implements ExperienceDataTypeDao {
    private final String DELETE = "delete from ExperienceDataType where id = :id";
    private final String ID = "id";
    private final String SELECT = "from ExperienceDataType";

    @PersistenceContext
    private EntityManager entityManager;

    private DataConverter dataConverter;

    @Autowired
    public ExperienceDataTypeDaoImp(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public void save(ExperienceDataTypeDTO experienceDataTypeDTO) {
        entityManager.persist(dataConverter.convertToModel(
                experienceDataTypeDTO,
                ExperienceDataType.class
        ));
    }

    @Override
    public void update(ExperienceDataTypeDTO experienceDataTypeDTO) {
        entityManager.merge(dataConverter.convertToModel(
                experienceDataTypeDTO,
                ExperienceDataType.class
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
    public ExperienceDataTypeDTO findById(Integer id) {
        return dataConverter.convertToDTO(
                entityManager.find(ExperienceDataType.class, id),
                ExperienceDataTypeDTO.class
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<ExperienceDataTypeDTO> findAll() {
        return entityManager.createQuery(SELECT, ExperienceDataType.class)
                .getResultList()
                .stream()
                .map(e -> dataConverter.convertToDTO(
                        e, ExperienceDataTypeDTO.class
                ))
                .collect(Collectors.toList());
    }
}
