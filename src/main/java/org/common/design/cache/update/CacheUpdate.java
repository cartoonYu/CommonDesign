package org.common.design.cache.update;

/**
 * update cache operation
 * @author cartoon
 * @date 2022/5/9 17:41
 */
public interface CacheUpdate<T, K> {

    T getData(K key);

    boolean updateData(K key, T data);

    boolean addData(K key, T data);

    boolean removeData(K key);

}
