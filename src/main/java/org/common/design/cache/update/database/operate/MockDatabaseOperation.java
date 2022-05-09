package org.common.design.cache.update.database.operate;

import java.util.Random;

/**
 * simulate database operation by sleep thread
 * @author cartoon
 * @date 2022/5/9 17:44
 */
public class MockDatabaseOperation<T, K> implements DatabaseOperation<T, K>{

    private Random random = new Random();

    @Override
    public T getData(K key) {
        threadSleep();
        return null;
    }

    @Override
    public boolean updateData(K key, T data) {
        threadSleep();
        return true;
    }

    @Override
    public boolean addData(K key, T data) {
        threadSleep();
        return true;
    }

    @Override
    public boolean removeData(K key) {
        threadSleep();
        return true;
    }

    private void threadSleep(){
        try {
            Thread.sleep(random.nextInt(5) * 1000);
        } catch (Exception e){

        }
    }
}
