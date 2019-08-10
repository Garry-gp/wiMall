package com.example.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的容器
 * @param <T>
 */
public class ResultSet<T> {
    private final Map<String,T> source= new HashMap<>();

    public T get(String key){
        return source.get(key);
    }
    public T get(Object key){
        return source.get(key);
    }

    public void put(String str,T value){
        source.put(str,value);
    }

    public Integer size(){
        return source.size();
    }
}
