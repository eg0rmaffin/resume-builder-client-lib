package app.resumebuilder.dao.dao_impl;

import app.resumebuilder.dao.dao_abstract.ITemporaryCvDataSlicePropsDao;
import app.resumebuilder.dao.entity.dto.ITemporaryCvDataSlicePropsDTO;
import app.resumebuilder.dao.entity.model.ITemporaryCvDataSliceProps;
import app.resumebuilder.dao.mapper.DataConverter;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс ITemporaryCvDataSlicePropsDaoImp
 * Наследован от конкретного интерфейса dao_abstract
 * Принимает/возвращает тип DTO
 * Внутри работает с model классами,
 * конвертируя их в DTO для удобной работы
 */

@Repository
@Transactional
public class ITemporaryCvDataSlicePropsDaoImp implements ITemporaryCvDataSlicePropsDao {
    private final String DELETE = "delete from ITemporaryCvDataSliceProps where id = :id";
    private final String ID = "id";
    private final String SELECT = "from ITemporaryCvDataSliceProps";

    @PersistenceContext
    private EntityManager entityManager;

    private DataConverter dataConverter;

    @Autowired
    public ITemporaryCvDataSlicePropsDaoImp(DataConverter dataConverter) {
        this.dataConverter = dataConverter;
    }

    @Override
    public void save(ITemporaryCvDataSlicePropsDTO dto) {
        entityManager.persist(dataConverter.convertToModel(
                dto,
                ITemporaryCvDataSliceProps.class
        ));
    }

    @Override
    public void update(ITemporaryCvDataSlicePropsDTO dto) {
        entityManager.merge(dataConverter.convertToModel(
                dto,
                ITemporaryCvDataSliceProps.class
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
    public ITemporaryCvDataSlicePropsDTO findById(Integer id) {
        return dataConverter.convertToDTO(
                entityManager.find(ITemporaryCvDataSliceProps.class, id),
                ITemporaryCvDataSlicePropsDTO.class
        );
    }

    @Override
    @Transactional(readOnly = true)
    public List<ITemporaryCvDataSlicePropsDTO> findAll() {
        return entityManager.createQuery(SELECT, ITemporaryCvDataSliceProps.class)
                .getResultList()
                .stream()
                .map(e -> dataConverter.convertToDTO(
                        e, ITemporaryCvDataSlicePropsDTO.class
                ))
                .collect(Collectors.toList());
    }
}
