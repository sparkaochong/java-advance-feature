package com.ac.collection.hashtable;

import java.util.HashMap;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/10/9
 *
 * @author aochong
 * @version 1.0
 */
public class TestHashMap {
    public static void main(String[] args) {
        // 创建一个散列表实例对象
        // key 是 String 类型，value 也是 String 类型
        // 散列表对应的数组的初始长度是 10
        // 触发自动扩容的元素的个数：0.75 * 10 = 7
        HashMap<String,String> map = new HashMap<>(1);

        System.out.println(hash("CTO") % 10);

        // 将数据 put 到 HashMap 中
        // 当 map 中的键值对的个数达到了7个，就会自动扩容
        // 扩容后的数组的长度是 10 * 2 = 20
        // 将数据 put 到 HashMap 中
        map.put("CTO", "tech"); // hash("CTO") % 20 = 11
        map.put("baidu", "search"); // hash("baidu") % 20 = 9
        map.put("qq", "social"); // hash("qq") % 20 = 16
        map.put("jd", "bus"); // hash("jd") % 20 = 6
        map.put("ali", "b2b"); // hash("ali") % 20 = 11
        map.put("yd", "note"); // hash("yd") % 20 = 11
        map.put("zx", "network"); // hash("zx") % 20 = 2

        // 当 map 中的元素个数 大于 (0.75 * 10 = 7) 的时候，会自动扩容到 2 * 10 = 20的大小
        map.put("gs", "bigdata"); // hash("gs") % 20 = 8
        map.put("qiyi", "video"); // hash("qiyi") % 20 = 12
        map.put("wx", "wechat");  // hash("wx") % 20 = 9
        map.put("hw", "huawei");  // hash("hw") % 20 = 3
        map.put("wy", "wangyi");  // hash("wy") % 20 = 10

        // 自动扩容做了两件事情：
        // 1. 将数组的长度扩容至原数组的2倍
        // 2. 重新计算每一个元素存储的位置，重新计算 hash 值 % 新的数组的长度
        System.out.println(map);
        System.out.println(map.size());

        // 通过 key 从 hashMap 中拿到对应的 value
        String value = map.get("baidu");
        System.out.println(value);
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }
}
