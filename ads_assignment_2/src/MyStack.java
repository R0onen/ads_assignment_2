public class MyStack<T> {
    private MyArrayList<T> list = new MyArrayList<>();
    public T push(T item){
        list.add(item);
        return item;
    }
    public T pop(){
        T item = peek();
        list.removeFirst();
        return item;
    }

    private T peek() {
        return list.get(0);
    }
    public int size(){
        return list.size();
    }

}
