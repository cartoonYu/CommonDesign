package org.common.design.demo.cache.update;

import org.common.design.cache.update.CacheUpdate;
import org.common.design.cache.update.factory.CacheUpdateEnum;
import org.common.design.cache.update.factory.CacheUpdateFactory;

/**
 * @author cartoon
 * @date 2022/5/17 18:09
 */
public class ReadOrWriteThoughClient<T, K> implements CacheUpdateClient<T, K>{

    private CacheUpdateFactory<T, K> factory = CacheUpdateFactory.getInstance();

    private CacheUpdate<T, K> cacheUpdate;

    @Override
    public T getData(K key) {
        return cacheUpdate.getData(key);
    }

    @Override
    public boolean updateData(K key, T data) {
        return cacheUpdate.updateData(key, data);
    }

    @Override
    public boolean addData(K key, T data) {
        return cacheUpdate.addData(key, data);
    }

    @Override
    public boolean removeData(K key) {
        return cacheUpdate.removeData(key);
    }

    public ReadOrWriteThoughClient() {
        cacheUpdate = factory.getObject(CacheUpdateEnum.READ_WRITE_THOUGH);
    }
}
