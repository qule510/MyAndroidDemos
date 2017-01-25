package com.qule.example.collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author qule
 * @version V1.0.0
 * @Description: 遍历set集合demo
 * @date 2017-01-25 15:30
 */
public class SetTraverseDemo {

    public static void main(String[] args) {

        Set<String> set = getHashSet();
        /**
         * 方式1，增强for循环
         */
        for (String value : set) {
            System.out.println(value);
        }
        /**
         * 方式2，使用迭代器Iterator
         */
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            System.out.println(value);
        }

        /**
         * 方式3，使用for和迭代器Iterator，和方式2一样，写法不一样而已
         */
        for (Iterator<String> iterator2 = set.iterator(); iterator2.hasNext(); ) {
            String value = iterator.next();
            System.out.println(value);
        }


    }

    /**
     * 生成一个Set<String>，用于遍历
     *
     * @return 生成的Set<String>
     */
    public static Set<String> getHashSet() {
        HashSet<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        return set;
    }
    //        PS：
    //        set可以添加null元素，不能添加重复的元素，当add(Object)的时候，如果set不存在和Object的hashCode一样的元素就直接add.
    //        如果存在就会调用equals方法比较两个元素,如果返回true,就当作相同元素，否则当作不同元素，添加元素到集合。具体验证可以参考本案例的Collections


}
