package org.common.design.cache.update.factory;

import org.common.design.cache.update.CacheUpdate;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author cartoon
 * @date 2022/5/16 19:36
 */
public class CacheUpdateFactory<T, K> {

    private static final CacheUpdateFactory INSTANCE = new CacheUpdateFactory();

    private ConcurrentHashMap<String, CacheUpdate<T, K>> objectMap;

    public CacheUpdate<T, K> getObject(CacheUpdateEnum cacheUpdateEnum){
        CacheUpdate<T, K> realObject = objectMap.get(cacheUpdateEnum.getClassName());

        if(Objects.nonNull(realObject)){
            return realObject;
        }
        try {
            realObject = (CacheUpdate<T, K>) cacheUpdateEnum.getClassType().getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        objectMap.put(cacheUpdateEnum.getClassName(), realObject);
        return realObject;
    }

    public static <T, K> CacheUpdateFactory getInstance(){
        return INSTANCE;
    }

    public CacheUpdateFactory() {
        objectMap = new ConcurrentHashMap<>(CacheUpdateEnum.values().length);
    }
}
