public class MyQueue<T>{
    private MyLinkedList<T> list = new MyLinkedList<>();
    public T enqueue(T item){
        list.addLast(item);
        return item;
    }
    public T dequeue(){
        T item = peek();
        list.removeFirst();
        return item;
    }

    private T peek() {
        return list.getFirst();
    }
    public int size(){
        return list.size();
    }
}
