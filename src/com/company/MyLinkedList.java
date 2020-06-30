package com.company;


public class MyLinkedList<T> {

    public class ListItem {
        private T value;
        private ListItem next;
        private ListItem previous;

        public ListItem(T value, ListItem next, ListItem previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }
    }

    private ListItem head = null;
    private ListItem tail = null;
    private int size = 0;

    private void checkEmpty() throws Exception {
        if (head == null) {
            throw new Exception("List is empty");
        }
    }

    public ListItem getFirst() {
        return head;
    }

    public ListItem getLast() {
        return tail;
    }

    public ListItem getNext(ListItem i) {
        return i.next;
    }

    public int getSize() {
        return size;
    }

    public T getValue(ListItem i) {
        return i.value;
    }


    public void addFirst(T value) {
        head = new ListItem(value, head, null);

        if (tail == null) {
            tail = head;
        }
        size++;
    }


    public void addLast(T value) {
        ListItem temp = new ListItem(value, null, tail);

        if (tail == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    public ListItem get(int index) throws Exception {
        if (index < 0 || index > size - 1) {
            throw new Exception("Incorrect index");
        }
        ListItem curr = head;
        while (index != 0) {
            curr = curr.next;
            index--;
        }
        return curr;

    /*
            for (ListItem curr = head; curr != null; curr = curr.next) {
                if (index == 0) {
                    return curr.value;
                }
                index--;
            }
            return null;
    */
    }


    public void addByIndex(T value, int index) throws Exception {
        ListItem element = new ListItem(value, null, null);
        if (index == 0) {
            addFirst(value);
            return;
        }

        ListItem curr = head;
        for (int i = 1; i < size; i++) {
            if (i == index) {
                ListItem tmp = curr.next;
                curr.next = element;
                element.previous = curr;
                element.next = tmp;
                tmp.previous = element;
            }
            curr = curr.next;
        }
        size++;
    }

    public void removeByIndex(int index) throws Exception {
        if (index == 0) {
            if (size == 1) {
                head = null;
                tail = null;
                size = 0;
                return;
            }
            head = head.next;
            head.previous = null;
            size--;
            return;
        }
        if (index == size - 1) {
            tail = tail.previous;
            tail.next = null;
            size--;
        }
        ListItem ptr = head.next;
        for (int i = 1; i < size; i++) {
            if (i == index) {
                ListItem p = ptr.previous;
                ListItem n = ptr.next;

                p.next = n;
                n.previous = p;
                size--;
                return;
            }
            ptr = ptr.next;
        }
    }


    public void removeFirst() throws Exception {
        checkEmpty();

        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
    }


    public void removeLast() throws Exception {
        checkEmpty();

        if (size == 1) {
            head = tail = null;
        } else {
            for (ListItem curr = head; ; curr = curr.next) {
                if (curr.next.next == null) {
                    tail = curr;
                    tail.next = null;
                    break;
                }
            }
        }
        size--;
    }

    public void clear() throws Exception {
        checkEmpty();
        ListItem curr = head;

        while (curr != tail) {
            curr = curr.next;
            curr.previous = null;
        }
        head = null;
        tail = null;
        size = 0;
    }

    public Object[] toArray() throws Exception {
        checkEmpty();

        Object[] newArray = new Object[getSize()];
        ListItem curr = head;

        for (int i = 0; i < getSize() - 1; i++) {
            newArray[i] = curr.value;
            curr = curr.next;
        }
        return newArray;
    }

    public String toString() {
        String code = "";
        ListItem curr = head;

        while (curr != tail.next) {
            code += curr.value + " ";
            curr = curr.next;
        }
        return code;
    }

    public String toStringFromTail() {
        String code = "";
        ListItem curr = tail;
        while (curr != head.previous) {
            code += curr.value + " ";
            curr = curr.previous;
        }
        return code;
    }

    public void reverse() {
        /*ListItem current = head;
        ListItem next;
        ListItem prev = null;


        while (current != null)
        {
            next  = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }
        current = head;
        head = tail;
        tail = current;

         */

        ListItem temp = head;
        head = tail;
        tail = temp;
        ListItem p = head;

        while(p != null)
        {
            temp = p.next;
            p.next = p.previous;
            p.previous = temp;
            p = p.next;
        }
    }


//    public int iterator() { // TODO: нужен ли?
//
//    }

}

