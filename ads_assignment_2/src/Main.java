public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> linkedList = new MyLinkedList<>();
        MyArrayList<String> arrayList = new MyArrayList<>();
        linkedList.add("Guitar");
        linkedList.add(1,"Piano");
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println("After adding elements: " + (linkedList.get(i)));
        }
        linkedList.addFirst("Bass");
        System.out.println("After adding first element: " + (linkedList.get(0)));
        linkedList.addLast("Kalimba");
        System.out.println("After adding last element: " + (linkedList.get(linkedList.size())));

        System.out.println("Getting first element: "  + linkedList.getFirst());
        System.out.println("Getting last element: " + linkedList.getLast());
        linkedList.removeFirst();
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println("After deleting first element: " + (linkedList.get(i)));
        }
        linkedList.removeLast();
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println("After deleting last element: " + (linkedList.get(i)));
        }
        linkedList.sort();
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println("After sorting: " + (linkedList.get(i)));
        }
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println("Getting index of object: " + (linkedList.indexOf("Piano")));
        }
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println("Getting last index of object: " + (linkedList.indexOf("Ukulele")));
        }
        if(linkedList.exists("Bass")){
            System.out.println("Object exists");
        }
        else {
            System.out.println("Object does not exists");
        }
        linkedList.clear();
        for(int i = 0; i < linkedList.size(); i++){
            System.out.println("After clearing: " + (linkedList.get(i)));
        }

        arrayList.add("Guitar");
        arrayList.add(1,"Piano");
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println("After adding elements: " + (arrayList.get(i)));
        }
        arrayList.addFirst("Bass");
        System.out.println("After adding first element: " + (arrayList.get(0)));
        arrayList.addLast("Kalimba");
        System.out.println("After adding last element: " + (arrayList.get(arrayList.size())));

        System.out.println("Getting first element: "  + arrayList.getFirst());
        System.out.println("Getting last element: " + arrayList.getLast());
        arrayList.removeFirst();
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println("After deleting first element: " + (arrayList.get(i)));
        }
        arrayList.removeLast();
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println("After deleting last element: " + (arrayList.get(i)));
        }
        arrayList.sort();
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println("After sorting: " + (arrayList.get(i)));
        }
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println("Getting index of object: " + (arrayList.indexOf("Piano")));
        }
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println("Getting last index of object: " + (arrayList.indexOf("Ukulele")));
        }
        if(arrayList.exists("Bass")){
            System.out.println("Object exists");
        }
        else {
            System.out.println("Object does not exists");
        }
        arrayList.clear();
        for(int i = 0; i < arrayList.size(); i++){
            System.out.println("After clearing: " + (arrayList.get(i)));
        }
    }
}