import org.w3c.dom.Node;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    static class Node<T>{
        T item;
        Node<T> next;
        Node(T element, Node<T> next){
            this.item = element;
            this.next = next;
        }
    }
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    @Override
    public void add(T item) {
        Node<T> new_node = new Node<>(item, null);
        if(head == null){
            head = tail = new_node;
        }
        else{
            tail.next = new_node;
            tail = new_node;
        }
        size++;
    }

    @Override
    public Object set(int index, T item) {
        Node<T> cursor = head;
        for(int i = 0; i < index; i++){
            cursor = cursor.next;
        }
        T res = cursor.item;
        cursor.item = item;
        return res;
    }

    @Override
    public void add(int index, T item) {
        if(index == 0){
            addFirst(item);
        }
        else if(index == size){
            addLast(item);
        }
        else{
            Node<T> current = head;
            for(int i = 0; i < index; i++){
                current = current.next;
            }
            Node<T> new_node = new Node<>(item, current.next);
            current.next = new_node;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        Node<T> new_node = new Node<>(item, null);
        if(head == null){
            head = new_node;
            return;
        }
        new_node.next = head;
        head = new_node;
    }

    @Override
    public void addLast(T item) {
        Node<T> new_node = new Node<>(item, null);
        if(head == null){
            head = new_node;
            return;
        }
        Node<T> cursor = head;
        while(cursor.next != null){
            cursor = cursor.next;
        }
        cursor.next = new_node;
    }

    @Override
    public T get(int index) {
        Node<T> cusror = head;
        for(int i = 0; i < index; i++){
            cusror = cusror.next;
        }
        return cusror.item;
    }

    @Override
    public T getFirst() {
        return head.item;
    }

    @Override
    public T getLast() {
        return tail.item;
    }

    @Override
    public void remove(int index) {
        if(index == 0){
            removeFirst();
            return;
        }
        if(index == size - 1){
            removeLast();
            return;
        }
        Node<T> cursor = head;
        for(int i = 0; i < index-1; i++){
            cursor = cursor.next;
        }
        cursor.next = cursor.next.next;
        size--;
    }

    @Override
    public void removeFirst() {
        head = head.next;
    }

    @Override
    public void removeLast() {
        if(size == 1){
            head = tail = null;
            size--;
            return;
        }
        Node<T> cursor = head;
        while(cursor.next != tail){
            cursor = cursor.next;
        }
        cursor.next = null;
        tail = cursor;
        size--;
    }

    @Override
    public void sort() {
        if(head == null || head.next == null){
            return;
        }
        for(int i = 0; i < size; i++){
            Node<T> cursor = head;
            for(int j = 0; j < size - 1; j++){
                Comparable<T> cursorComp = (Comparable<T>) cursor.item;
                if(cursorComp.compareTo(cursor.next.item) > 0){
                    T temp = cursor.item;
                    cursor.item = cursor.next.item;
                    cursor.next.item = temp;
                }
                cursor = cursor.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        Node<T> cursor = head;
        for(int i = 0; cursor != null; i++, cursor = cursor.next){
            if(object == cursor.item){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastindexOf(Object object) {
        Node<T> cursor = head;
        int lastIndex = -1;
        for(int i = 0; cursor != null; i++, cursor = cursor.next){
            if(object == cursor.item){
                lastIndex = i;
            }
        }
        return lastIndex;
    }

    @Override
    public boolean exists(Object object) {
        Node<T> cursor = head;
        while(cursor != null){
            if(object == null && cursor.item == null){
                return true;
            } else if (object != null && object.equals(cursor.item)) {
                return true;
            }
            cursor = cursor.next;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        Node<T> cursor = head;
        while(cursor != null){
            arr[i++] = cursor.item;
            cursor = cursor.next;
        }
        return arr;
    }

    @Override
    public void clear() {
        head = tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T nextItem = current.item;
                current = current.next;
                return nextItem;
            }
        };
    }
}
