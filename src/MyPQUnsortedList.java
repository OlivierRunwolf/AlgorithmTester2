import java.util.Comparator;

public class MyPQUnsortedList<K, V> extends AbstractPriorityQueue<K, V> {

    private DoubleLinkedList<PQEntry<K, V>> list = new DoubleLinkedList<>();
    int size = 0;

    public MyPQUnsortedList() {
        super();
    }

    public MyPQUnsortedList(Comparator<K> comp) {
        super(comp);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        PQEntry<K, V> newEntry = new PQEntry<>(key, value);
        list.add(newEntry);
        size++;
        return newEntry;
    }


    public Entry<K, V> min() {
        try {
            DoubleLinkedList.Node<PQEntry<K, V>> temp = list.first().getNext();
            DoubleLinkedList.Node<PQEntry<K, V>> min = list.first().getNext();
            do {
                if ((int) temp.getElement().getKey() < (int) min.getElement().getKey()) {
                    min = temp;
                }
                temp = temp.getNext();
            } while (temp.getNext() != null);

            return min.getElement();
        } catch (NullPointerException e) {
            System.out.println("no elements added");
            return null;
        }

    }

    @Override
    public Entry<K, V> removeMin() {
        try {
            DoubleLinkedList.Node<PQEntry<K, V>> temp = list.first().getNext();
            Entry<K, V> min1 = min();
            DoubleLinkedList.Node<PQEntry<K, V>> min;
            do {
                if (temp.getElement() == min1) {
                    min = temp;
                    min.getPrev().setNext(min.getNext());
                    min.getNext().setPrev(min.getPrev());
                }
                temp = temp.getNext();
            } while (temp.getNext() != null);

            return min1;
        } catch (NullPointerException e) {
            System.out.println("no elements added");
            return null;
        }
    }

    public void display() {
        list.printList();
    }

}
