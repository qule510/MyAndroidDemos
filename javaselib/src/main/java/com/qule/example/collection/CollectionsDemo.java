package com.qule.example.collection;

import com.qule.example.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author qule
 * @version V1.0.0
 * @Description list, set, map的一些注意点总结，测试添加null元素。
 * @date 2017-01-25 21:58
 */
public class CollectionsDemo {
    /*
1. 遍历删除问题
遍历的时候要使用删除的话，直接使用集合引用进行删除操作会抛ConcurrentModificationException异常，
需要调用Iterator的remove方法才行。例子：{@link ListTraverseDemo#testTraverseRemove()}
2. 添加元素问题
set不能添加重复的元素（重复元素以hashCode和equals作为判断依据），当add(Object)的时候，如果set不存在和Object的hashCode一样的元素就直接add.
map 添加存在相同key的时候，其value会覆盖前面的value。
3. 是否可以添加null元素
list和set可以，map的key和value都可以,
PS:set内部是使用map实现的，存放元素的使用，set的value将作为map的key,set引用作为map的value。
4. 线城安全问题
ArrayList,HashMap,HashSet 都是不安全的。可以使用Collections中的方法转成安全类型的集合：
synchronizedMap(map),synchronizedList(list),synchronizedSet(set)。
PS：内部其实是使用了 装饰模式：继承了该集合类,增强方法，重写操作的方法中使用了synchronized 调用被装饰对象的操作方法。
这里只是粗略讲解一下主要注意点，具体底层怎么实现，还需要自己去看系统源码。
     */
    public static void main(String[] args) {

        testMapAdd();
        testSetAdd();
        testListAdd();
    }

    /**
     * 测试Set添加hashCode相同元素时候，是覆盖还是新增
     */
    public static final void testSetAdd() {
        HashSet<Student> set = new HashSet<>();
        set.add(new Student("Jim", 90));
        set.add(new Student("LiLei", 99));
        set.add(new Student("Jim", 90));
        set.add(null);
        System.out.println(set);
    }

    public static final void testMapAdd() {
        HashMap<String, Student> map = new HashMap<>();
        map.put("jim", new Student("jim", 90));
        map.put("jim", new Student("jim", 30));
        map.put(null, null);
        System.out.println(map);
    }

    public static final void testListAdd() {
        ArrayList<String> list = new ArrayList();
        list.add("aa");
        list.add(null);
        System.out.println(list);
    }


}
