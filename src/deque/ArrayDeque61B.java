package deque;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private int size;
    private int indexF;
    private int indexL;
    private T[] arr;
    private final int startSize = 8;

    public ArrayDeque61B() {
        arr = (T[]) new Object[startSize];
        indexF = 0;
        indexL = 1;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        if (size == arr.length) {
            resUp();
        }
        arr[indexF] = x;
        indexF = Math.floorMod(indexF - 1, arr.length);
        size++;
    }

    @Override
    public void addLast(T x) {
        if (size == arr.length) {
            resUp();
        }
        arr[indexL] = x;
        indexL = Math.floorMod(indexL + 1, arr.length);
        size++;
    }

    @Override
    public List<T> toList() {
        if (size == 0) {
            return new ArrayList<>();
        }
        List<T> returnList = new ArrayList<>();
        for (int i = indexF + 1; i <= (indexF + size); i++) {
            int index = Math.floorMod(i, arr.length);
            returnList.add(arr[index]);
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
        indexF = Math.floorMod(indexF + 1, arr.length);
        T remove = arr[indexF];
        arr[indexF] = null;
        size--;
        if (size == 0) {
            indexF = 0;
            indexL = 1;
        }
        if (size <= arr.length / 4 && arr.length / 4 > startSize) {
            resDown();
        }
        return remove;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        indexL = Math.floorMod(indexL - 1, arr.length);
        T remove = arr[indexL];
        arr[indexL] = null;
        size--;
        if (size == 0) {
            indexF = 0;
            indexL = 1;
        }
        if (size <= arr.length / 4 && arr.length / 4 > startSize) {
            resDown();
        }
        return remove;
    }

    @Override
    public T get(int index) {
        if (index >= arr.length || index < 0) {
            return null;
        }
        int i = Math.floorMod(indexF + 1 + index, arr.length);
        return arr[i];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }

    public void resUp() {
        T[] resArr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < size; i++) {
            resArr[i] = arr[Math.floorMod(indexF + 1 + i, arr.length)];
        }
        arr = resArr;
        indexF = arr.length - 1;
        indexL = size;
    }

    public void resDown() {
        T[] resArr = (T[]) new Object[arr.length / 4];
        for (int i = 0; i < size; i++) {
            resArr[i] = arr[Math.floorMod(indexF + 1 + i, arr.length)];
        }
        arr = resArr;
        indexF = arr.length - 1;
        indexL = size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDeque61BIterator();
    }

    private class ArrayDeque61BIterator implements Iterator<T> {
        private int pos;
        public ArrayDeque61BIterator() {
            pos = 0;
        }

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public T next() {
            T returnItem = arr[Math.floorMod(indexF + 1 + pos, arr.length)];
            pos++;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
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
        if (other instanceof LinkedListDeque61B otherSet) {
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
