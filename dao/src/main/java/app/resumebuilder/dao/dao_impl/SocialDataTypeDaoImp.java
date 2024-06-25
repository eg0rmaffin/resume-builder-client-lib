package app.resumebuilder.dao.dao_impl;

import app.resumebuilder.dao.dao_abstract.SocialDataTypeDao;
import app.resumebuilder.dao.mapper.DataConverter;
import app.resumebuilder.dto.SocialDataTypeDTO;
import app.resumebuilder.eurekaclientmodel.model.SocialDataType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс SocialDataTypeDaoImp
 * Наследован от конкретного интерфейса dao_abstract
 * Принимает/возвращает тип DTO
 * Внутри работает с model классами,
 * конвертируя их в DTO для удобной работы
 */

@Repository
@Transactional
public class SocialDataTypeDaoImp implements SocialDataTypeDao {
    private final String DELETE = "delete from SocialDataType where id = :id";
    private final String ID = "id";
    private final String SELECT = "from SocialDataType";

    @PersistenceContext
    private EntityManager entityManager;

    private DataConverter dataConverter;

    @Autowired
    public SocialDataTypeDaoImp(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public void save(SocialDataTypeDTO socialDataType) {
        entityManager.persist(dataConverter.convertToModel(
                socialDataType,
                SocialDataType.class
        ));
    }

    @Override
    public void update(SocialDataTypeDTO socialDataType) {
        entityManager.merge(dataConverter.convertToModel(
                socialDataType,
                SocialDataType.class
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
    public SocialDataTypeDTO findById(Integer id) {
        return dataConverter.convertToDTO(
                entityManager.find(SocialDataType.class, id),
                SocialDataTypeDTO.class
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<SocialDataTypeDTO> findAll() {
        return entityManager.createQuery(SELECT, SocialDataTypeDTO.class)
                .getResultList()
                .stream()
                .map(e -> dataConverter.convertToDTO(
                        e, SocialDataTypeDTO.class
                ))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public File getImageFile(SocialDataTypeDTO socialDataType) {
        return entityManager.find(SocialDataType.class, socialDataType.getId()).getImageFile();
    }

    @Override
    public void saveImage(SocialDataTypeDTO socialDataType, File imageFile) {
        SocialDataType entity = entityManager.find(SocialDataType.class, socialDataType.getId());
        entity.setImageFile(imageFile);
        entityManager.merge(entity);
    }

    @Override
    public void updateImage(SocialDataTypeDTO socialDataType, File imageFile) {
        SocialDataType entity = entityManager.find(SocialDataType.class, socialDataType.getId());
        entity.setImageFile(imageFile);
        entityManager.merge(entity);
    }

    @Override
    public void deleteImage(SocialDataTypeDTO socialDataType) {
        SocialDataType entity = entityManager.find(SocialDataType.class, socialDataType.getId());
        entity.setImageFile(null);
        entityManager.merge(entity);
    }
}
