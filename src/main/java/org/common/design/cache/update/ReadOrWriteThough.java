package org.common.design.cache.update;

import org.common.design.cache.update.database.operate.DatabaseOperation;
import org.common.design.cache.update.database.operate.MockDatabaseOperation;

import java.util.HashMap;
import java.util.Map;

/**
 * read and write mode
 * @author cartoon
 * @date 2022/5/9 20:43
 */
public class ReadOrWriteThough<T, K> implements CacheUpdate<T, K>{

    private DatabaseOperation<T, K> databaseOperation;

    private Map<K, T> map;

    @Override
    public T getData(K key) {
        //if cache has data, return
        if(map.containsKey(key)){
            return map.get(key);
        }
        //get data from database and write to cache
        T data = databaseOperation.getData(key);
        map.put(key, data);
        return data;
    }

    @Override
    public boolean updateData(K key, T data) {
        map.put(key, data);
        return databaseOperation.updateData(key, data);
    }

    @Override
    public boolean addData(K key, T data) {
        map.put(key, data);
        return databaseOperation.addData(key, data);
    }

    @Override
    public boolean removeData(K key) {
        map.remove(key);
        return databaseOperation.removeData(key);
    }

    public ReadOrWriteThough() {
        databaseOperation = new MockDatabaseOperation<>();
        map = new HashMap<>();
    }
}
