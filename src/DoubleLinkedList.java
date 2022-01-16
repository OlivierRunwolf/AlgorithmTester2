public class DoubleLinkedList<E> {

    static class Node<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        public Node(E e, Node<E> p, Node<E> n) {
            element = e;
            prev = p;
            next = n;
        }

        public E getElement() { return element; }

        public void setElement(E element) { this.element =  element; }

        public Node<E> getPrev() { return prev; }

        public Node<E> getNext() { return next; }

        public void setPrev(Node<E> prev) { this.prev = prev; }

        public void setNext(Node<E> next) { this.next = next; }
    }

    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    public DoubleLinkedList(){
        header = new Node<>(null,null,null);
        trailer = new Node<>(null,header,null);
        header.setNext(trailer);
    }

    public void add(E e){
        Node<E> newNode;
        if(isEmpty()){
            newNode = new Node<>(e,header,trailer);
            trailer.setPrev(newNode);
            header.setNext(newNode);
            size++;
           // trailer = new Node<>(null,newNode,null);
        }else{
            newNode = new Node<>(e,trailer.getPrev(),trailer);
            trailer.getPrev().setNext(newNode);
            trailer.setPrev(newNode);
            size++;
        }

    }

    public E min(){
        Node<E> temp = header.getNext();
        Node<E> min = header.getNext();
        while(temp.getNext() !=null){
            if((Integer) temp.getNext().getElement()< (Integer) min.getElement()){
                min = temp.getNext();
            }
            temp = temp.getNext();
        }
        return min.getElement();
    }

    public void printList(){
        Node<E> temp = header.getNext();
        while(temp.getNext() !=null){
            System.out.print(temp.getElement().toString()+",");
            temp = temp.getNext();
        }
    }
    public int size(){return size;}

    public boolean isEmpty(){return size==0;}

    public Node<E> first(){
        if(isEmpty()){
            return null;
        }
        return header;
    }

    public Node<E> last(){
        if(isEmpty()){
            return null;
        }
        return trailer;
    }
}
