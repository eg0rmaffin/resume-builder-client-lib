package app.resumebuilder.dao.dao_impl;

import app.resumebuilder.dao.dao_abstract.PersonalDataTypeDao;
import app.resumebuilder.dao.entity.dto.PersonalDataTypeDTO;
import app.resumebuilder.dao.entity.model.PersonalDataType;
import app.resumebuilder.dao.mapper.DataConverter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс PersonalDataTypeDaoImp
 * Наследован от конкретного интерфейса dao_abstract
 * Дополнительно содержит метод findByMail для секьюрити
 * Принимает/возвращает тип DTO
 * Внутри работает с model классами,
 * конвертируя их в DTO для удобной работы
 */

@Repository
@Transactional
public class PersonalDataTypeDaoImp implements PersonalDataTypeDao {
    private final String DELETE = "delete from PersonalDataType where id = :id";
    private final String ID = "id";
    private final String SELECT = "from PersonalDataType";
    private final String SELECT_BY_MAIL = "select from PersonalDataType where mail = :mail";
    private final String MAIL = "mail";

    @PersistenceContext
    private EntityManager entityManager;

    private DataConverter dataConverter;

    @Autowired
    public PersonalDataTypeDaoImp(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public void save(PersonalDataTypeDTO personalDataTypeDTO) {
        entityManager.persist(dataConverter.convertToModel(
                personalDataTypeDTO,
                PersonalDataType.class
        ));
    }

    @Override
    public void update(PersonalDataTypeDTO personalDataTypeDTO) {
        entityManager.merge(dataConverter.convertToModel(
                personalDataTypeDTO,
                PersonalDataType.class
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
    public PersonalDataTypeDTO findById(Integer id) {
        return dataConverter.convertToDTO(
                entityManager.find(PersonalDataType.class, id),
                PersonalDataTypeDTO.class
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonalDataTypeDTO> findAll() {
        return entityManager.createQuery(SELECT, PersonalDataType.class)
                .getResultList()
                .stream()
                .map(e -> dataConverter.convertToDTO(
                        e, PersonalDataTypeDTO.class
                ))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PersonalDataTypeDTO findByMail(String mail) {
        return dataConverter.convertToDTO(
                (PersonalDataType) entityManager.createQuery(SELECT_BY_MAIL)
                        .setParameter(MAIL, mail)
                        .getSingleResult(),
                PersonalDataTypeDTO.class
        );
    }

    @Override
    public void saveImage(PersonalDataTypeDTO personalDataTypeDTO, File file) {
        PersonalDataType entity = dataConverter.convertToModel(
                personalDataTypeDTO,
                PersonalDataType.class
        );
        entity.setImage(file);
        entityManager.merge(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public File getImage(PersonalDataTypeDTO personalDataTypeDTO) {
        return entityManager.find(PersonalDataType.class, personalDataTypeDTO.getId()).getImage();
    }

    @Override
    public void updateImage(PersonalDataTypeDTO personalDataTypeDTO, File file) {
        PersonalDataType entity = dataConverter.convertToModel(
                personalDataTypeDTO,
                PersonalDataType.class
        );
        entity.setImage(file);
        entityManager.merge(entity);
    }

    @Override
    public void deleteImage(PersonalDataTypeDTO personalDataTypeDTO) {
        PersonalDataType entity = entityManager.find(PersonalDataType.class, personalDataTypeDTO.getId());
        entity.setImage(null);
        entityManager.merge(entity);
    }
}
