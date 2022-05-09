package org.common.design.cache.update;

import org.common.design.cache.update.database.operate.DatabaseOperation;
import org.common.design.cache.update.database.operate.MockDatabaseOperation;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * write behind mode
 * @author cartoon
 * @date 2022/5/9 21:24
 */
public class WriteBehind<T, K> implements CacheUpdate<T, K> {

    private Map<K, T> map;

    private DatabaseOperation<T, K> databaseOperation;

    private ThreadPoolExecutor threadPoolExecutor;

    @Override
    public T getData(K key) {
        if(map.containsKey(key)){
            return map.get(key);
        }
        T data = databaseOperation.getData(key);
        map.put(key, data);
        return data;
    }

    @Override
    public boolean updateData(K key, T data) {
        map.put(key, data);
        threadPoolExecutor.execute(() -> databaseOperation.updateData(key, data));
        return true;
    }

    @Override
    public boolean addData(K key, T data) {
        map.put(key, data);
        threadPoolExecutor.execute(() -> databaseOperation.addData(key, data));
        return true;
    }

    @Override
    public boolean removeData(K key) {
        map.remove(key);
        threadPoolExecutor.execute(() -> databaseOperation.removeData(key));
        return true;
    }

    public WriteBehind() {
        map = new HashMap<>();
        databaseOperation = new MockDatabaseOperation<>();
        threadPoolExecutor = new ThreadPoolExecutor(5, 10, 1000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000), new ThreadPoolExecutor.CallerRunsPolicy());
    }

}
