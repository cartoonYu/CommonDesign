package org.common.design.cache.update.database.operate;

import java.util.Random;

/**
 * simulate database operation by sleep thread
 * @author cartoon
 * @date 2022/5/9 17:44
 */
public class MockDatabaseOperation<T> implements DatabaseOperation<T, T>{

    private Random random = new Random();

    @Override
    public T getData(T key) {
        threadSleep();
        return key;
    }

    @Override
    public boolean updateData(T key, T data) {
        threadSleep();
        return true;
    }

    @Override
    public boolean addData(T key, T data) {
        threadSleep();
        return true;
    }

    @Override
    public boolean removeData(T key) {
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
