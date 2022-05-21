package org.common.design.cache.update;

import org.common.design.cache.update.factory.CacheUpdateEnum;
import org.common.design.cache.update.factory.CacheUpdateFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author cartoon
 * @date 2022/5/18 19:35
 */
@DisplayName("cache aside client test")
public class CacheAsideClientTest {

    private CacheUpdateFactory<Integer, Integer> factory = CacheUpdateFactory.getInstance();

    private CacheUpdate<Integer, Integer> cacheAside = factory.getObject(CacheUpdateEnum.CACHE_ASIDE);

    @Test
    public void getData(){
        System.out.printf("cache aside, get data: %d%n", cacheAside.getData(10));
    }

    @Test
    public void updateData(){
        System.out.printf("cache aside, get data: %b%n", cacheAside.updateData(10, 20));
    }

    @Test
    public void addData(){
        System.out.printf("cache aside, get data: %b%n", cacheAside.addData(10, 10));
    }

    @Test
    public void removeData(){
        System.out.printf("cache aside, get data: %b%n", cacheAside.removeData(10));
    }
}
