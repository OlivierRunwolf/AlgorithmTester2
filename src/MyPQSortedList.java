import java.util.Comparator;

public class MyPQSortedList<K, V> extends AbstractPriorityQueue<K, V> {

    private DoubleLinkedList<PQEntry<K, V>> list = new DoubleLinkedList<>();
    int size = 0;


    public MyPQSortedList() {
        super();
    }

    public MyPQSortedList(Comparator<K> comp) {
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
        if (size > 1) {
            bubbleSort();
        }
        return newEntry;
    }

    @Override
    public Entry<K, V> min() {
        try {
            return list.first().getNext().getElement();//no searching
        } catch (NullPointerException e) {
            System.out.println("no elements added");
            return null;
        }
    }

    @Override
    public Entry<K, V> removeMin() {
        try {
            Entry<K, V> temp = list.first().getElement();
            if (list.first().getElement() != null) {
                list.first().getNext().setPrev(null);
                list.first().setNext(list.first().getNext().getNext());
                size--;
                return temp;//no searching
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            System.out.println("no elements added");
            return null;
        }
    }

    public void bubbleSort() {
        DoubleLinkedList.Node<PQEntry<K, V>> current = null;
        DoubleLinkedList.Node<PQEntry<K, V>> temp = null;
        PQEntry<K, V> temp1;

        current = list.first().getNext();
        while (current.getNext() != null) {
            temp = current.getNext();
            while (temp.getElement() != null) {
                if ((int) current.getElement().getKey() > (int) temp.getElement().getKey()) {
                    temp1 = current.getElement();
                    current.setElement(temp.getElement());
                    temp.setElement(temp1);
                }

                temp = temp.getNext();
            }
            current = current.getNext();
        }
    }

    public void display() {
        list.printList();
    }
}
