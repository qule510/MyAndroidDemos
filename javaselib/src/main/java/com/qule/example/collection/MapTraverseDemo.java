package com.qule.example.collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author qule
 * @version V1.0.0
 * @Description 遍历Map集合demo
 * @date 2017-01-25 21:23
 * 一般都使用Iterator遍历或者for-each遍历
 */
public class MapTraverseDemo {

    public static void main(String[] args) {
        HashMap<String, String> map = getHashMap();

        /**
         * 方式1，使用for-each。
         */
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

        /**
         *方式2，使用Iterator遍历（使用泛型）
         */
        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

        /**
         *方式3，使用Iterator遍历（不使用泛型）
         */
        Iterator iterator1 = map.entrySet().iterator();
        while (iterator1.hasNext()) {
            Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator1.next();
            System.out.println("key:" + entry.getKey() + ",value:" + entry.getValue());
        }

        /**
         * 方式4，通过键遍历（效率低）
         */
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("key:" + key + ",value:" + value);
        }

        /**
         * 方式5，只需要key集合或者value集合时候使用
         */
        for (String key : map.keySet()) {
            System.out.println("key:" + key);
        }

        for (String value : map.values()) {
            System.out.println("value:" + value);
        }

    }

    /**
     * 生成一个HashMap<String, String>，用于遍历
     *
     * @return HashMap<String, String>
     */
    public static HashMap<String, String> getHashMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "a_value");
        map.put("b", "b_value");
        map.put("c", "c_value");
        return map;
    }

}
