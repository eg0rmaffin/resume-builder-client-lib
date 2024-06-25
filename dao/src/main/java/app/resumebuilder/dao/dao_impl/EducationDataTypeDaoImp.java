package app.resumebuilder.dao.dao_impl;

import app.resumebuilder.dao.dao_abstract.EducationDataTypeDao;
import app.resumebuilder.dao.mapper.DataConverter;
import app.resumebuilder.dto.EducationDataTypeDTO;
import app.resumebuilder.eurekaclientmodel.model.EducationDataType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс AvatarDataTypeDaoImp
 * Наследован от конкретного интерфейса dao_abstract
 * Принимает/возвращает тип DTO
 * Внутри работает с model классами,
 * конвертируя их в DTO для удобной работы
 */

@Repository
@Transactional
public class EducationDataTypeDaoImp implements EducationDataTypeDao {
    private final String DELETE = "DELETE FROM EducationDataType WHERE id = :id";
    private final String ID = "id";
    private final String SELECT = "from EducationDataType";

    @PersistenceContext
    private EntityManager entityManager;

    private DataConverter dataConverter;

    @Autowired
    public EducationDataTypeDaoImp(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public void save(EducationDataTypeDTO educationDataTypeDTO) {
        entityManager.persist(dataConverter.convertToModel(
                educationDataTypeDTO,
                EducationDataType.class
        ));
    }

    @Override
    public void update(EducationDataTypeDTO educationDataTypeDTO) {
        entityManager.merge(dataConverter.convertToModel(
                educationDataTypeDTO,
                EducationDataType.class
        ));
    }

    @Override
    public void deleteById(Integer id) {
        entityManager.createQuery(DELETE)
                .setParameter(ID, id)
                .executeUpdate();
    }

    @Override
    public EducationDataTypeDTO findById(Integer id) {
        return dataConverter.convertToDTO(
                entityManager.find(EducationDataType.class, id),
                EducationDataTypeDTO.class
        );
    }

    @Override
    public List<EducationDataTypeDTO> findAll() {
        return entityManager.createQuery(SELECT, EducationDataType.class)
                .getResultList()
                .stream()
                .map(e -> dataConverter.convertToDTO(
                        e, EducationDataTypeDTO.class
                ))
                .collect(Collectors.toList());
    }
}
