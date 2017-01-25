package com.qule.example.collection;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * @author qule
 * @version V1.0.0
 * @Description 遍历List集合demo
 * @date 2017-01-25 15:13
 */
public class ListTraverseDemo {


    public static void main(String[] args) {

        ArrayList<String> list = getArrayList();
        /**
         * 方式一，使用for循环
         */
        for (int i = 0, len = list.size(); i < len; i++) {
            String s = list.get(i);
            System.out.println(s);
        }

        /**
         * 方式二，使用增强for循环
         */
        for (String s : list) {
            System.out.println(s);
        }

        /**
         * 方式三，使用for和Iterator
         */

        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
            String value = iterator.next();

            System.out.println(value);
        }

        /**
         * 方式四，使用while和Iterator（效率和方式3一样）
         */
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }

//        PS：
//        以上就是List遍历的4种方式。个人认为对于android来说，数据量都不会很大，效率都差不多，自己哪个方便就用哪种。
//        理论上，方式1是最快的，但是需要考虑并发问题。而如果要进行删除操作，就只能用iterator。
//        for和foreach遍历时候使用删除回抛异常ConcurrentModificationException。删除只能使用Iterator的remove方法。
//        foreach 和for：foreach 只能从头到尾，不可以从后面开始遍历。foreach遍历的时候不能给迭代变量赋值(可以给迭代变量里面的内容)，比如你不可以修改User引用，可以通过该引用修改User内部数据。

    }


    /**
     * 生成一个ArrayList，用于遍历
     *
     * @return 生成的ArrayList
     */
    public static ArrayList<String> getArrayList() {
        ArrayList<String> list = new ArrayList<>();

        list.add("aa");
        list.add("bb");
        list.add("cc");
        list.add("dd");

        return list;
    }
}
