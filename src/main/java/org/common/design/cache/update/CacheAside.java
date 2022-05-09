package org.common.design.cache.update;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * cache aside mode
 * @author cartoon
 * @date 2022/5/9 17:42
 */
public class CacheAside<T, K> implements CacheUpdate<T, K>{

    private Map<K, T> map;

    @Override
    public T getData(K key) {
        //if cache has data, return
        return map.get(key);
    }

    @Override
    public boolean updateData(K key, T data) {
        map.remove(key, data);
        return true;
    }

    @Override
    public boolean addData(K key, T data) {
        return Objects.nonNull(map.put(key, data));
    }

    @Override
    public boolean removeData(K key) {
        map.remove(key);
        return true;
    }

    public CacheAside() {
        map = new HashMap<>();
    }
}
