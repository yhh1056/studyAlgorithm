package dataStructure.queue;

import java.util.NoSuchElementException;

/**
 * author {yhh1056}
 * Create by {2020/08/18}
 */

public class LinearQueue implements QueueInterface {

    private int front = 0; // 저장된 원소 중 첫번쨰 원소
    private int rear = -1; // 저장된 원소 중 마지막 원소
    private int size;
    private final char[] items;

    public LinearQueue(int size) {
        this.size = size;
        this.items = new char[size];
    }

    public void add(char item) throws Exception {
        if (isFull()) {
            throw new Exception();
        } else {
            items[++rear] = item;
        }
    }

    @Override
    public boolean offer(char item) {
        if (isFull()) {
            System.out.println("full");
            return false;
        } else {
            items[++rear] = item;
            return true;
        }
    }

    /**
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    void remove() throws NoSuchElementException {
        if (isEmpty()) {
            System.out.println("is empty");
            throw new NoSuchElementException();
        } else {
            ++front;
        }
    }

    /**
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public boolean poll() {
        if (isEmpty()) {
            System.out.println("full");
            return false;
        } else {
            ++front;
            return true;
        }
    }

    /**
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    void element() throws NoSuchElementException {
        if (isEmpty()) {
            System.out.println("is empty");
            throw new NoSuchElementException();
        } else {
            System.out.println(items[front]);
        }
    }

    /**
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public void peek() {
        if (isEmpty()) {
            System.out.println("null");

        } else {
            System.out.println(items[front]);
        }
    }

    /**
     * front부터 rear까지의 인덱스를 출력
     */
    void printQueue() {
        if (isEmpty()) {
            System.out.println("null");
        } else {
            System.out.println("front : " + front);
            System.out.println("rear : " + rear);
            for (int i = front; i <= rear; i++) {
                System.out.print(items[i] + " ");
            }
            System.out.println();
        }
    }

    @Override
    public boolean isEmpty() {
        return front == rear - 1;
    }

    @Override
    public boolean isFull() {
        return rear == this.size - 1;
    }
}

