import java.util.Comparator;

public class MyMinHeap<T extends Comparable<T>> {
    private MyArrayList<T> heap;
    private Comparator<T> comp;

    public MyMinHeap(){
        this(null);
    }
    public MyMinHeap(Comparator<T> comp){
        this.heap = new MyArrayList<>();
        this.comp = comp;
    }
    public int size(){
        return heap.size();
    }
    public T getMin(){
        return heap.get(0);
    }
    public T extractMin(){
        T root = getMin();
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return root;
    }

    private void heapify(int index) {
        int left = leftChildOf(index);
        int right = rightChildOf(index);
        int min = index;

        if(left < heap.size() && compare(heap.get(left), heap.get(index)) < 0){
            min = left;
        }
        if(right < heap.size() && compare(heap.get(right), heap.get(min)) < 0){
            min = right;
        }
        if(min != index){
            T temp = heap.get(index);
            heap.set(index, heap.get(min));
            heap.set(min, temp);
            heapify(min);
        }
    }

    private void traverseUp(int index){
        while(index != 0 && compare(heap.get(index), heap.get(parentOf(index))) < 0){
            T temp = heap.get(index);
            heap.set(index, heap.get(parentOf(index)));
            heap.set(parentOf(index), temp);
            index = parentOf(index);
        }
    }

    private int parentOf(int index) {
        return (index - 1)/2;
    }
    private void insert(T item){
        heap.add(item);
        traverseUp(heap.size() - 1);
    }

    private int compare(T item1, T item2) {
        if(comp != null){
            return comp.compare(item1, item2);
        }
        else {
            return item1.compareTo(item2);
        }
    }

    private int rightChildOf(int index) {
        return 2*index + 2;
    }

    private int leftChildOf(int index) {
        return 2*index + 1;
    }

}
