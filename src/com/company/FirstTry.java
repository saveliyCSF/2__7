/*package com.company;

import java.lang.reflect.Array;

public class FirstTry {
    public static <T> int getSize(MyListNode<T> head) { // есть
        int count = 0;
        for (MyListNode<T> node = head; node != null; node = node.getNext()) {
            count++;
        }
        return count;
    }

    private static <T> T[] toArrayInner(MyListNode<T> head, T... dummy) {
        Class runtimeType = dummy.getClass().getComponentType();
        T[] result = (T[]) Array.newInstance(runtimeType, getSize(head));

        MyListNode<T> node = head;
        for (int i = 0; i < result.length; i++) {
            result[i] = node.getValue();
            node = node.getNext();
        }
        return result;
    }

    public static <T> MyListNode<T> getTail(MyListNode<T> head) {
        MyListNode<T> tail = head;
        for (MyListNode<T> node = head; node != null; node = node.getNext()) {
            tail = node;
        }
        return tail;
    }

    public static <T> MyListNode<T> NodeByIndex(MyListNode<T> head, int index) {
        MyListNode<T> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.getNext();
        }
        return node;
    }

    public static <T> MyListNode<T> addFirst(HeadContainer<T> container, T value) {
        container.setHead(new MyListNode<>(value, container.getHead()));
        return container.getHead();
    }


    public static <T> MyListNode<T> addLast(HeadContainer<T> container, T value) {
        MyListNode<T> head = container.getHead();
        if (head == null) {
            head = new MyListNode<>(value);
            container.setHead(head);
            return head;
        } else {
            return insertAfter(getTail(container.getHead()), value);
        }
    }

    public static <T> MyListNode<T> insert(HeadContainer<T> container, int index, T value) {
        if (index == 0) {
            return addFirst(container, value);
        } else {
            MyListNode<T> beforeNode = NodeByIndex(container.getHead(), index - 1);
            if (beforeNode == null) {
                return null;
            }
            return insertAfter(beforeNode, value);
        }
    }

    public static <T> boolean removeAt(HeadContainer<T> container, int index) {
        if (container.getHead() == null) {
            return false;
        }

        if (index == 0) {
            // удаляем первый элемент
            container.setHead(container.getHead().getNext());
            return true;
        } else {
            // удалаем не первый элемент
            MyListNode<T> beforeNode = NodeByIndex(container.getHead(), index - 1);
            if (beforeNode != null && beforeNode.getNext() != null) {
                beforeNode.setNext(beforeNode.getNext().getNext());
                return true;
            } else {
                return false;
            }
        }
    }

    public static <T> void clear(HeadContainer<T> container) {
        container.setHead(null);
    }
}
*/