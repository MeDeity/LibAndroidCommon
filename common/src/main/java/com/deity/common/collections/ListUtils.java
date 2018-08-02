package com.deity.common.collections;

import java.util.List;

/**
 * 集合类公共方法
 * Create by fengwenhua at 2018/8/2
 **/
@SuppressWarnings("unused")
public class ListUtils {

    /**
     * 判断集合类是否为空（check collections is empty)
     * @param list the collections to be check
     * @param <T>  泛型
     * @return   is collections empty
     */
    public static  <T> boolean isEmpty(List<T> list){
        return (null!=list&&list.size()>0);
    }
}
