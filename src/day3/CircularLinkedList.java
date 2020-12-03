package day3;

import java.util.LinkedList;

public class CircularLinkedList<E> {
    private Node<E> first = null;

    CircularLinkedList() {
    }

    public Node<E> getStart() {
        return first;
    }

    public void add(E value) {
        if (first == null) {
            first = new Node<E>(value);
            first.setNext(first);
            first.setPrevious(first);
        } else if (first.getNext() == first) {
            Node<E> newNode = new Node<E>(value) {{
                setPrevious(first);
                setNext(first);
            }};
            first.setPrevious(newNode);
            first.setNext(newNode);
        } else {
            Node<E> newNode = new Node<E>(value) {{
                setPrevious(first.getPrevious());
                setNext(first);
            }};
            first.getPrevious().setNext(newNode);
            first.setPrevious(newNode);
        }
    }


    public E get(int index) throws Exception {
        if (first == null || index < 0) throw new IndexOutOfBoundsException();
        else if (index == 0) return first.getValue();

        int current = 1;
        Node<E> curNode = first.getNext();
        while (current < index){
            curNode = curNode.getNext();
            current++;
        }
        return curNode.getValue();

    }
}
