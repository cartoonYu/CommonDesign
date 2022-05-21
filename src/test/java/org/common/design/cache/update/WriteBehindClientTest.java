package org.common.design.cache.update;

import org.common.design.cache.update.factory.CacheUpdateEnum;
import org.common.design.cache.update.factory.CacheUpdateFactory;
import org.junit.jupiter.api.Test;

/**
 * @author cartoon
 * @date 2022/5/18 19:57
 */
public class WriteBehindClientTest {

    private final CacheUpdateFactory<Integer, Integer> factory = CacheUpdateFactory.getInstance();

    private final CacheUpdate<Integer, Integer> writeBehind = factory.getObject(CacheUpdateEnum.WRITE_BEHIND);

    @Test
    public void getData(){
        System.out.printf("write behind, get data: %d%n", writeBehind.getData(10));
    }

    @Test
    public void updateData(){
        System.out.printf("write behind, get data: %b%n", writeBehind.updateData(10, 20));
    }

    @Test
    public void addData(){
        System.out.printf("write behind, get data: %b%n", writeBehind.addData(10, 10));
    }

    @Test
    public void removeData(){
        System.out.printf("write behind, get data: %b%n", writeBehind.removeData(10));
    }
}
