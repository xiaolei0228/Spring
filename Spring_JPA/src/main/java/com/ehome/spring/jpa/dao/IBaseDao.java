package com.ehome.spring.jpa.dao;

import com.ehome.spring.jpa.module.BaseEntity;

/**
 * Created by xiaolei on 2015-01-19 22:24
 */
public interface IBaseDao<Entity> {

    /**
     * 保存
     *
     * @param entity 实体对象
     *
     * @return 保存后的对象
     */
    Entity save(Entity entity);

    /**
     * 批量保存
     *
     * @param entities 对象集合
     *
     * @return 保存后的对象集合
     */
    Iterable<Entity> saveInBatch(Iterable<Entity> entities);

    /**
     * 更新
     *
     * @param entity 实体对象
     *
     * @return 更新后的对象
     */
    Entity update(Entity entity);

    /**
     * 批量更新
     *
     * @param entities 对象集合
     *
     * @return 更新后的对象
     */
    Iterable<Entity> updateInBatch(Iterable<Entity> entities);


}
