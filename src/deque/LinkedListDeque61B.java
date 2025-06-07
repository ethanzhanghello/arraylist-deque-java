package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private class Node {
        private T x;
        private Node p;
        private Node n;
        private Node(T x, Node p, Node n) {
            this.x = x;
            this.p = p;
            this.n = n;
        }
    }

    private Node sentinal;
    private int size;

    public LinkedListDeque61B() {
        sentinal = new Node(null, null, null);
        sentinal.p = sentinal;
        sentinal.n = sentinal;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        sentinal.n = new Node(x, sentinal, sentinal.n);
        sentinal.n.n.p = sentinal.n;
        size++;
    }

    @Override
    public void addLast(T x) {
        sentinal.p = new Node(x, sentinal.p, sentinal);
        sentinal.p.p.n = sentinal.p;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node curr = sentinal.n;
        for (int i = 1; i <= size; i++) {
            returnList.add(curr.x);
            curr = curr.n;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node removed = sentinal.n;
        sentinal.n = sentinal.n.n;
        sentinal.n.p = sentinal;
        size--;
        return removed.x;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node removed = sentinal.p;
        sentinal.p = sentinal.p.p;
        sentinal.p.n = sentinal;
        size--;
        return removed.x;
    }

    @Override
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int i = 0;
        Node curr = sentinal.n;
        while (i < index) {
            curr = curr.n;
            i++;
        }
        return curr.x;
    }

    @Override
    public T getRecursive(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        Node n = sentinal.n;
        return getRecursiveHelper(index, 0, n);
    }

    public T getRecursiveHelper(int index, int curr, Node n) {
        if (index == curr) {
            return n.x;
        }
        return getRecursiveHelper(index, curr + 1, n.n);
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDeque61BIterator();
    }

    private class LinkedListDeque61BIterator implements Iterator<T> {
        private int pos;
        public LinkedListDeque61BIterator() {
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public T next() {
            Node curr = sentinal.n;
            int i = 0;
            while (i < pos) {
                curr = curr.n;
                i++;
            }
            pos++;
            return curr.x;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof LinkedListDeque61B otherSet) {
            if (this.size != otherSet.size) {
                return false;
            }
            int i = 0;
            for (T x : this) {
                if (!otherSet.get(i).equals(x)) {
                    return false;
                }
                i++;
            }
            return true;
        }
        if (other instanceof ArrayDeque61B otherSet) {
            if (this.size() != otherSet.size()) {
                return false;
            }
            int i = 0;
            for (T x : this) {
                if (!otherSet.get(i).equals(x)) {
                    return false;
                }
                i++;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return toList().toString();
    }
}
