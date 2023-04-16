public class ArrayFrontBackCappedList<T> implements FrontBackCappedList<T> {

    private T[] list;
    private int numberOfElements;
    private int maxSize;

    public ArrayFrontBackCappedList(int maxSize) {
        this.maxSize = maxSize;
        list = (T[]) new Object[maxSize];
        numberOfElements = 0;
        
        // 3 Lines in Constructor for Part One.
        Object[] objs = {2, 4, 6, 8, 9, null, null, null, null, null};
        this.list = (T[]) objs;
        this.numberOfElements = 5;
    }

    public String toString() {
        String output = "Size: " + numberOfElements + "/" + maxSize + "\nElements: [";
        if (numberOfElements == 0) {
            output += "]";
        } else {
            for (int i = 0; i < numberOfElements - 1; i++) {
                output += list[i] + ", ";
            }
            output += list[numberOfElements - 1] + "]";
        }
        return output;
    }

    public boolean isEmpty() {
        return numberOfElements == 0;
    }

    public boolean isFull() {
        return numberOfElements == maxSize;
    }

    public int size() {
        return numberOfElements;
    }

    public T getEntry(int position) {
        if (position >= 0 && position < numberOfElements) {
            return list[position];
        }
        return null;
    }

    public void clear() {
        list = (T[]) new Object[maxSize];
        numberOfElements = 0;
    }

    public boolean addBack(T newEntry) {
        if (isFull()) {
            return false;
        }
        list[numberOfElements] = newEntry;
        numberOfElements++;
        return true;
    }

    public boolean addFront(T newEntry) {
        if (isFull()) {
            return false;
        }
        for (int i = numberOfElements - 1; i >= 0; i--) {
            list[i + 1] = list[i];
        }
        list[0] = newEntry;
        numberOfElements++;
        return true;
    }

    public T removeFront() {
        if (isEmpty()) {
            return null;
        }
        T front = list[0];
        for (int i = 1; i < numberOfElements; i++) {
            list[i - 1] = list[i];
        }
        numberOfElements--;
        return front;
    }

    public T removeBack() {
        if (isEmpty()) {
            return null;
        }
        T back = list[numberOfElements - 1];
        list[numberOfElements - 1] = null;
        numberOfElements--;
        return back;
    }

    public boolean contains(T anEntry) {
        for (int i = 0; i < numberOfElements; i++) {
            if (list[i].equals(anEntry)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(T anEntry) {
        for (int i = 0; i < numberOfElements; i++) {
            if (list[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T anEntry) {
        for (int i = numberOfElements - 1; i >= 0; i--) {
            if (list[i].equals(anEntry)) {
                return i;
            }
        }
        return -1;
    }

    public void addAll(T[] elements) {
        for (T element : elements) {
            if (!addBack(element)) {
                break;
            }
        }
    }

}
