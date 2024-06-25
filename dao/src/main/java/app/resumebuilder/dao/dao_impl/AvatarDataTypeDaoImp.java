package app.resumebuilder.dao.dao_impl;

import app.resumebuilder.dao.dao_abstract.AvatarDataTypeDao;
import app.resumebuilder.dao.mapper.DataConverter;
import app.resumebuilder.dto.AvatarDataTypeDTO;
import app.resumebuilder.eurekaclientmodel.model.AvatarDataType;
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
public class AvatarDataTypeDaoImp implements AvatarDataTypeDao {
    private final String DELETE = "DELETE FROM AvatarDataType WHERE id = :id";
    private final String ID = "id";
    private final String SELECT = "from AvatarDataType";

    @PersistenceContext
    private EntityManager entityManager;

    private final DataConverter dataConverter;

    @Autowired
    public AvatarDataTypeDaoImp(
            DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public void save(AvatarDataTypeDTO avatarDataTypeDTO) {
        entityManager.persist(dataConverter.convertToModel(
                avatarDataTypeDTO,
                AvatarDataType.class
        ));
    }

    @Override
    public void update(AvatarDataTypeDTO avatarDataTypeDTO) {
        entityManager.merge(dataConverter.convertToModel(
                avatarDataTypeDTO,
                AvatarDataType.class
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
    public AvatarDataTypeDTO findById(Integer id) {
        return dataConverter.convertToDTO(
                entityManager.find(AvatarDataType.class, id),
                AvatarDataTypeDTO.class
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<AvatarDataTypeDTO> findAll() {
        return entityManager.createQuery(SELECT, AvatarDataTypeDTO.class)
                .getResultList()
                .stream()
                .map(e -> dataConverter.convertToDTO(
                        e, AvatarDataTypeDTO.class
                ))
                .collect(Collectors.toList());
    }
}
