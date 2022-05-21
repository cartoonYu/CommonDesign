package org.common.design.demo.cache.update;

/**
 * @author cartoon
 * @date 2022/5/17 18:14
 */
public interface CacheUpdateClient<T, K> {

    T getData(K key);

    boolean updateData(K key, T data);

    boolean addData(K key, T data);

    boolean removeData(K key);

}
