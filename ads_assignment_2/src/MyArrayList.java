import org.w3c.dom.Node;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private T[] arr;

    public MyArrayList(){
        arr = (T[]) new Object[DEFAULT_CAPACITY];
    }
    private void increaseCapacity(){
        T[] new_arr = (T[]) new Object[arr.length * 2];
        for(int i = 0; i < size; i++){
            new_arr[i] = arr[i];
        }
        arr = new_arr;
    }
    @Override
    public void add(T item){
        if(size == arr.length) {
            increaseCapacity();
        }
        arr[size++] = item;
    }
    @Override
    public void addFirst(T item){
        if(size == arr.length){
            increaseCapacity();
        }
        for(int i = size; i > 0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = item;
        size++;
    }
    @Override
    public void addLast(T item) {
        if (size == arr.length) {
            increaseCapacity();
        }
        arr[size] = item;
        size++;
    }
    @Override
    public void remove(int index){
        for(int i = index; i < size - 1; i++){
            arr[i] = arr[i+1];
        }
        arr[size - 1] = null;
        size--;
    }
    @Override
    public void removeFirst(){
        for(int i = 1; i < size; i++){
            arr[i-1] = arr[i];
        }
        arr[--size] = null;
    }
    @Override
    public void removeLast(){
        arr[--size] = null;
    }
    @Override
    public T get(int index){
        return (T) arr[index];
    }
    @Override
    public T getFirst(){
        return (T) arr[0];
    }
    @Override
    public T getLast(){
        return (T) arr[size - 1];
    }
    @Override
    public void clear(){
        for(int i = 0; i < size; i++){
            arr[i] = null;
        }
        size = 0;
    }
    @Override
    public Object[] toArray(){
        Object[] new_arr = new Object[size];
        for(int i = 0; i < size; i++){
            new_arr[i] = arr[i];
        }
        return new_arr;
    }
    @Override
    public Iterator<T> iterator(){
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public T next() {
                return (T) arr[index++];
            }
        };
    }
    @Override
    public Object set(int index, T item){
        return arr[index] = item;
    }

    @Override
    public void add(int index, T item) {
        if(size == arr.length){
            increaseCapacity();
        }
        for(int i = size; i > index; i--){
            arr[i] = arr[i-1];
        }
        arr[index] = item;
        size++;
    }

    @Override
    public boolean exists(Object object){
        for(int i = 0; i < size; i++){
            if(arr[i] == null && object == null){
                return true;
            } else if (arr[i] != null && arr[i].equals(object)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void sort(){
        T temp;
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size - 1; j++){
                if(((Comparable<T>) arr[j]).compareTo(arr[j+1]) > 0){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    @Override
    public int indexOf(Object object){
        if(object == null){
            for(int i = 0; i < size; i++){
                if(arr[i] == null){
                    return i;
                }
            }
        }
        else {
            for(int i = 0; i < size; i++){
                if(object.equals(arr[i])){
                    return i;
                }
            }
        }
        return -1;
    }
    @Override
    public int lastindexOf(Object object){
        if(object == null){
            for(int i = size - 1; i >= 0; i--){
                if(arr[i] == null){
                    return i;
                }
            }
        }
        else {
            for(int i = size - 1; i >= 0; i--){
                if(object.equals(arr[i])){
                    return i;
                }
            }
        }
        return -1;
    }
    @Override
    public int size(){
        return size;
    }
}
