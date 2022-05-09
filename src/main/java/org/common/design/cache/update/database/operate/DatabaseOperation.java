package org.common.design.cache.update.database.operate;

/**
 * database operation
 * @author cartoon
 * @date 2022/5/9 17:45
 */
public interface DatabaseOperation<T, K> {

    T getData(K key);

    boolean updateData(K key, T data);

    boolean addData(K key, T data);

    boolean removeData(K key);
}
