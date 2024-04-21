public interface MyList<T> extends Iterable<T> {
    void add(T item);
    Object set(int index, T item);
    void add(int index, T item);
    void addFirst(T item);
    void addLast(T item);
    T get(int index);
    T getFirst();
    T getLast();
    void remove(int index);
    void removeFirst();
    void removeLast();
    void sort();
    int indexOf(Object object);
    int lastindexOf(Object object);
    boolean exists(Object object);
    public Object[] toArray();
    void clear();
    int size();
}
