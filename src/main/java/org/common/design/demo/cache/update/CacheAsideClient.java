package org.common.design.demo.cache.update;

import org.common.design.cache.update.CacheUpdate;
import org.common.design.cache.update.factory.CacheUpdateEnum;
import org.common.design.cache.update.factory.CacheUpdateFactory;
import org.common.design.cache.update.database.operate.DatabaseOperation;
import org.common.design.cache.update.database.operate.MockDatabaseOperation;

import java.util.Objects;

/**
 * @author cartoon
 * @date 2022/5/16 19:02
 */
public class CacheAsideClient<T, K> implements CacheUpdateClient<T, K>{

    public CacheUpdateFactory<T, K> factory = CacheUpdateFactory.getInstance();

    private CacheUpdate<T, K> cacheUpdate;

    private DatabaseOperation<T, K> databaseOperation;

    @Override
    public T getData(K key){
        //get data from cache
        T dataFromCache = cacheUpdate.getData(key);
        //if cache haven't, get from database and put to cache
        if(Objects.nonNull(dataFromCache)){
            return dataFromCache;
        }
        T dataFromDatabase = databaseOperation.getData(key);
        cacheUpdate.addData(key, dataFromDatabase);
        return dataFromDatabase;
    }

    @Override
    public boolean updateData(K key, T data){
        //update data to database
        boolean updateToDatabaseRes = databaseOperation.updateData(key, data);
        if(updateToDatabaseRes){
            //invalid cache data
            return cacheUpdate.removeData(key);
        }
        return false;
    }

    @Override
    public boolean addData(K key, T data){
        //add data to database
        return databaseOperation.addData(key, data);
    }

    @Override
    public boolean removeData(K key){
        //remove from database
        boolean removeFromDatabaseRes = databaseOperation.removeData(key);
        if(removeFromDatabaseRes){
            //invalid cache data
            return cacheUpdate.removeData(key);
        }
        return false;
    }

    public CacheAsideClient() {
        cacheUpdate = factory.getObject(CacheUpdateEnum.CACHE_ASIDE);
        databaseOperation = (DatabaseOperation<T, K>) new MockDatabaseOperation<T>();
    }
}
