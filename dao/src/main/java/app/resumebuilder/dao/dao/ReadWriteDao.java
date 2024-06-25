package app.resumebuilder.dao.dao;

import java.util.List;

/**
 * DAO интерфейс для записи и чтеения
 * Расширяется конкретными интерфейсами в пакете dao_abstract
 * Реализуется классами в пакете dao_impl
 * @param <K> - тип ключа (например Long id)
 * @param <T> - тип объекта DTO
 */
public interface ReadWriteDao<K, T> {
    void save(T dto);
    void update(T dto);
    void deleteById(K id);
    T findById(K id);
    List<T> findAll();
}
