package org.common.design.cache.update.factory;

import org.common.design.cache.update.CacheAside;
import org.common.design.cache.update.CacheUpdate;
import org.common.design.cache.update.ReadOrWriteThough;
import org.common.design.cache.update.WriteBehind;

/**
 * @author cartoon
 * @date 2022/5/16 19:36
 */
public enum CacheUpdateEnum {
    
    CACHE_ASIDE("cache_aside", CacheAside.class),
    READ_WRITE_THOUGH("read_write_though", ReadOrWriteThough.class),
    WRITE_BEHIND("write_behind", WriteBehind.class);

    private String className;
    
    private Class<? extends CacheUpdate> classType;

    CacheUpdateEnum(String className, Class<? extends CacheUpdate> classType) {
        this.className = className;
        this.classType = classType;
    }

    public String getClassName() {
        return className;
    }

    public Class<?> getClassType() {
        return classType;
    }
}
