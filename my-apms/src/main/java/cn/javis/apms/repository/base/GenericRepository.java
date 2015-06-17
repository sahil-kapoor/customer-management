package cn.javis.apms.repository.base;

public interface GenericRepository<E, P> {
    E find(P primaryKey);

    void create(E entity);

    void update(E entity);

    void delete(E entity);

}
