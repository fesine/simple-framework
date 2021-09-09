package com.fesine;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 类描述
 * @author: fesine
 * @createTime:2021/9/9
 * @update:修改内容
 * @author: fesine
 * @updateTime:2021/9/9
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        List<String> page1 = page(1, 2, list);
        List<String> page2= page(2, 2, list);
        List<String> page3 = page(3, 2, list);
        List<String> page4 = page(4, 2, list);
        System.out.println();
    }

    private static List<String> page(int page, int pageSize, List<String> list) {
        List<String> subList = new ArrayList<>();
        int size = list.size();
        int from = (page - 1) * pageSize;
        if (from < size) {
            int to = from + pageSize;
            to = Math.min(to, size);
            subList = list.subList(from, to);
        }
        return subList;
    }
}
