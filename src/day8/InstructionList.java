package day8;

import org.omg.IOP.CodecPackage.FormatMismatch;

import java.util.LinkedList;

public class InstructionList {

    Node start = null;
    int size = 0;

    InstructionList() {
    }

    public void add(String instruction) {
        if (start == null) {
            start = new Node(instruction);
        } else {
            Node current = start;
            while (current.hasNext()) {
                current = current.getNext();
            }
            current.setNext(new Node(instruction));
        }
        size++;
    }

    public void remove(int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            start = start.getNext();
        } else {
            Node current = start;
            while (index > 1) {
                current = current.getNext();
                index--;
            }
            current.setNext(current.getNext().hasNext() ? current.getNext().getNext() : null);
        }
    }

    private static class Node {

        private Node next = null;
        private final String operation;
        private final int command;

        Node(String instruction) {
            String[] args = instruction.split(" ");
            operation = args[0];
            command = Integer.parseInt(args[1]);
        }

        public boolean hasNext() {
            return next != null;
        }

        public void setNext(Node nextNode) {
            next = nextNode;
        }

        public Node getNext() {
            return next;
        }

        public String getOperation() {
            return operation;
        }

        public int getCommand() {
            return command;
        }
    }
}
