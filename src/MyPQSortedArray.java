import java.util.Arrays;
import java.util.Comparator;

public class MyPQSortedArray<K, V> extends AbstractPriorityQueue<K, V> {

    private Entry<K, V>[] list = new Entry[1];
    int size = 0;

    public MyPQSortedArray() {
        super();
    }

    public MyPQSortedArray(Comparator<K> comp) {
        super(comp);
    }


    //returns position of an enrtry having minimalkey
    private int findMin() {
        try {
            Entry<K, V> entry = list[0];
            int position = 0;
            if (!isEmpty()) {
                for (int i = 0; i < list.length; i++) {
                    if (list[i] != null) {
                        Entry<K, V> kvEntry = list[i];
                        if ((int) kvEntry.getKey() < (int) entry.getKey()) {
                            entry = kvEntry;
                            position = i;
                        }
                    }
                }
                //suppose to return i????
                return position;
            } else {
                return 0;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No elements added");
            return 0;
        }
    }

    public Entry<K, V> insert(K key, V value) throws IllegalArgumentException {
        //checkKey(key)
        if (checkIfFull()) {
            Entry<K, V>[] temp = list;
            list = new Entry[list.length * 2];

            for (int i = 0; i < temp.length; i++) {
                list[i] = temp[i];
            }
        }
        Entry<K, V> newEntry = new PQEntry<>(key, value);
        if (isEmpty()) {
            list[size] = newEntry;
            size++;
            return newEntry;
        } else {
            list[size] = newEntry;
            size++;
            int index = 0;
            for (int i = 0; i < size - 1; i++) {
                index = i;
                for (int j = i + 1; j < size; j++) {
                    if ((int) list[j].getKey() < (int) list[index].getKey()) {
                        index = j;
                    }
                }
                Entry<K, V> smaller = list[index];
                list[index] = list[i];
                list[i] = smaller;
            }
        }

        //sfhit to the right

        return newEntry;
    }


    public boolean checkIfFull() {
        //  boolean isFull=false;
        if (list[list.length - 1] != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }


    @Override
    public Entry<K, V> min() {
        if (list == null) {
            return null;
        }
        try {
            return list[findMin()];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("no elements added");
            return null;
        }

    }

    public void display() {
        for (int i = 0; i < list.length; i++) {
            //   Entry<K, V> kvEntry = list[i];
            if (list[i] == null) {
                System.out.print("_,");
            } else {
                System.out.print("[" + list[i].getKey() + "," + list[i].getValue() + "],");
            }
        }
        System.out.print(",     listenght:[" + list.length + "]         size:" + size);
    }

    @Override
    public Entry<K, V> removeMin() {
        if (list == null) {
            return null;
        }
        Entry<K, V> temp = list[findMin()];
        int toRemove = findMin();
        list[findMin()] = null;
        for (int i = toRemove; i < size; i++) {
            if ((i + 1) < list.length) {
                list[i] = list[i + 1];
                list[i + 1] = null;
            }
        }
        size--;
        if (size < (list.length / 4)) {
            Entry<K, V>[] temp1 = list;
            list = new Entry[list.length / 2];
            for (int i = 0; i < list.length; i++) {
                list[i] = temp1[i];
            }
        }
        return temp;
    }
}
