package com.ac.collection.hashtable;

/**
 * Description:
 * <散列表>
 * Created by aochong on 2019/10/9
 *
 * @author aochong
 * @version 1.0
 */
public class KeyValueMap<K,V> {

    static final int DEFAULT_LENGTH = 10;

    /**
     * 链表的节点
     */
    class EntryNode<K,V>{
        K key;
        V value;
        EntryNode next;

        public EntryNode(K key,V value){
            this.key = key;
            this.value = value;
        }

    }

    private EntryNode<K,V>[] entryNodes;

    public KeyValueMap(){
        entryNodes = new EntryNode[DEFAULT_LENGTH];
    }

    public KeyValueMap(int length){
        entryNodes = new EntryNode[length];
    }

    /**
     * 根据 key 拿到对应的value
     * @param key
     * @return
     */
    public V get(K key){
        // 计算 hash 值
        int hash = hash(key);
        // 拿到对应下标的链表头节点
        EntryNode<K,V> head = entryNodes[hash];
        if(head==null){
            return null;
        }else{
            EntryNode<K,V> curr = head;
            // 循环遍历链表的每一个节点，对比key 相等的话，表示找到了，直接返回true
            while(curr!=null){
                if(curr.key.equals(key)){
                    return curr.value;
                }
                curr = curr.next;
            }
            return null;
        }
    }

    /**
     * 将 key-value 数据放到散列表中 students 中
     * @param key
     * @param value
     */
    public void put(K key, V value){
        // 创建一个节点
        EntryNode<K,V> node = new EntryNode(key,value);
        // 计算 key 的 hash 值
        int hash = hash(key);
        // 拿到对应列表的头
        EntryNode<K,V> head = entryNodes[hash];
        if(head == null){
            // 直接将需要插入的节点作为头节点
            entryNodes[hash] = node;
        }else{
            // 找到链表的尾节点
            EntryNode<K,V> last = head;
            EntryNode<K,V> curr = head.next;
            while(curr!=null){
                last = curr;
                curr = curr.next;
            }
            // 将需要插入的数据插入到最后节点的 next
            last.next = node;
        }
    }

    /**
     * 散列函数
     * @param key
     * @return 对应数组的下标
     */
    public int hash(K key){
        int index = key.hashCode();
        /*String lastTwoChars = key.substring(key.length()-2);
        // 转成 int 类型
        int index = Integer.valueOf(lastTwoChars);*/
        // 取模，保证计算出来的 hash 值不会超过数组的长度
        return index % entryNodes.length;
    }
}
