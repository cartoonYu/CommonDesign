package org.common.design.cache.update;

import org.common.design.cache.update.factory.CacheUpdateEnum;
import org.common.design.cache.update.factory.CacheUpdateFactory;
import org.junit.jupiter.api.Test;

/**
 * @author cartoon
 * @date 2022/5/18 19:56
 */
public class ReadOrWriteThoughClientTest {

    private final CacheUpdateFactory<Integer, Integer> factory = CacheUpdateFactory.getInstance();

    private final CacheUpdate<Integer, Integer> readOrWriteThough = factory.getObject(CacheUpdateEnum.READ_WRITE_THOUGH);

    @Test
    public void getData(){
        System.out.printf("read or write though, get data: %d%n", readOrWriteThough.getData(10));
    }

    @Test
    public void updateData(){
        System.out.printf("read or write though, get data: %b%n", readOrWriteThough.updateData(10, 20));
    }

    @Test
    public void addData(){
        System.out.printf("read or write though, get data: %b%n", readOrWriteThough.addData(10, 10));
    }

    @Test
    public void removeData(){
        System.out.printf("read or write though, get data: %b%n", readOrWriteThough.removeData(10));
    }
}
