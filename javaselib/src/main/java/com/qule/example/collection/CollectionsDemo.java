package com.qule.example.collection;

import com.qule.example.model.Student;

import java.util.HashSet;

/**
 * @author qule
 * @version V1.0.0
 * @Description list,set,map的一些注意点总结
 * @date 2017-01-25 21:58
 */
public class CollectionsDemo {
    /**
     1.遍历删除问题
     遍历的时候要使用删除的话，直接使用集合引用进行删除操作会抛ConcurrentModificationException异常，
     需要使用集合的迭代器Iterator，调用Iterator的remove方法才行。
    2.遍历修改问题
     使用for-each是好修改的，

    3.是否可以可以添加null元素

     list,可以
     set,可以
     map，key和value都可以,


     set内部是使用map实现的，存放元素的使用，set的value将作为map的key,set引用作为map的value。

     HashMap的底层主要是基于数组和链表，线城不安全，要安全可以使用 Collections.synchronizedList

    4，关于安全不安全，
     ArrayList,HashMap,HashSet 都是不安全的。可以使用Collections中的方法转成安全类型的集合。
     synchronizedMap(map),synchronizedList(list),synchronizedSet(set);
     PS：内部其实是使用了 装饰模式：继承了该集合类,增强方法，重写操作的方法中使用了synchronized 调用被装饰对象的操作方法。


     这里只是粗略讲解一下主要注意点，具体底层怎么实现，还需要自己去看系统源码。
     */
    public static void main(String[] args) {

        testSetAdd();
    }

    /**
     * 测试Set添加hashCode相同元素时候，是覆盖还是新增
     */
    public static final void testSetAdd(){
        HashSet<Student> set = new HashSet<>();
        set.add(new Student("Jim",90));
        set.add(new Student("LiLei",99));
        set.add(new Student("Jim",90));

        System.out.println(set);

    }
}
