package com.ac.collection;

/**
 * Description:
 * <p>
 * Created by aochong on 2019/9/25
 *
 * @author aochong
 * @version 1.0
 */
class ListNode<T> {
    private T data;

    private ListNode next;

    public ListNode(T data){
        this.data = data;
    }

    public void setNext(ListNode next){
        this.next = next;
    }

    public ListNode getNext(){
        return next;
    }

    public T getData(){
        return data;
    }
}

/**
 * 双向链表中的一个节点
 */
class DoublyListNode{
    private Object data;
    private DoublyListNode prev;
    private DoublyListNode next;

    public DoublyListNode(Object data){
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public DoublyListNode getPrev() {
        return prev;
    }

    public void setPrev(DoublyListNode prev) {
        this.prev = prev;
    }

    public DoublyListNode getNext() {
        return next;
    }

    public void setNext(DoublyListNode next) {
        this.next = next;
    }
}
/**
 * @author aochong
 */
public class TestLinkedList {
    public static void main(String[] args) {
        ListNode firstNode = new ListNode(5);
        ListNode secondNode = new ListNode(12);
        ListNode thirdNode = new ListNode(9);
        ListNode forthNode = new ListNode(23);

        firstNode.setNext(secondNode);
        secondNode.setNext(thirdNode);
        thirdNode.setNext(forthNode);

        // insertNode(firstNode,12,new ListNode(65));
        removeNode(firstNode,5);

        printLinkedList(firstNode);

        // 构建一个双向链表
        DoublyListNode first = new DoublyListNode(5);
        DoublyListNode second = new DoublyListNode(16);
        DoublyListNode third = new DoublyListNode(89);
        DoublyListNode forth = new DoublyListNode(51);

        first.setNext(second);
        second.setPrev(first);
        second.setNext(third);
        third.setPrev(second);
        third.setNext(forth);
        forth.setPrev(third);
        forth.setNext(null);

    }

    /**
     * 打印链表中所有的节点
     * @param head 链表头节点
     */
    public static void printLinkedList(ListNode head) {
        ListNode currentNode = head;
        if(currentNode==null){
            return;
        }
        while(currentNode!=null){
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNext();
        }
    }

    /**
     * 向节点中指定元素后面插入一个新的节点
     * @param head 头节点
     * @param value 指定元素
     * @param addNode 插入的新节点
     */
    public static void insertNode(ListNode head,int value, ListNode addNode){
        ListNode selectedNode = head;
        while(selectedNode!=null){
            // 链表中找到了这个元素
            if(selectedNode.getData().equals(value)){
                break;
            }
            // 遍历下一个节点
            selectedNode = selectedNode.getNext();
        }
        // 判断是否在链表中找到指定的元素
        if(selectedNode!=null){
            // 新节点的下一个节点与当前节点的下一个节点进行连接
            addNode.setNext(selectedNode.getNext());
            // 当前节点的下一个节点为新插入的节点
            selectedNode.setNext(addNode);
        }else{
            // 没有找到指定元素
            throw new RuntimeException("链表中不存在这个节点！");
        }
    }

    /**
     * 删除链表中指定的元素
     * @param head 链表头节点
     * @param value 要删除的节点
     */
    public static void removeNode(ListNode head,Object value){
        ListNode selectedNode = head;
        ListNode previousNode = null;
        while(selectedNode!=null){
            if(selectedNode.getData().equals(value)){
                break;
            }
            previousNode = selectedNode;
            selectedNode = selectedNode.getNext();
        }
        // 当前节点没有上一个节点(说明要删除的是第一个节点)
        if(previousNode==null){
            // 头节点 = 当前节点的下一个节点
            head = new ListNode(selectedNode.getNext().getData());
            // 设置头节点的后面的节点
            head.setNext(selectedNode.getNext().getNext());
            // 当前节点有上一个节点(说明要删除的不是第一个节点)
        }else{
            if(selectedNode!=null){
                // 将当前节点的下一个节点连接上上一个节点
                previousNode.setNext(selectedNode.getNext());
                // 将当前删除节点下一个节点断开(使其成为垃圾被回收)
                selectedNode.setNext(null);
            }else{
                throw new RuntimeException("链表中不存在这个节点！");
            }
        }
    }
}
