package dataStructure.queue;

/**
 * author {yhh1056}
 * Create by {2020/08/18}
 */
public class CircularQueue implements QueueInterface {
    private int size;
    private char[] items;
    private int front;
    private int rear;

    public CircularQueue(int size) {
        this.size = size;
        this.items = new char[size];
        this.front = 0;
        this.rear = 0;
    }

    @Override
    public boolean offer(char item) {
        if (isFull()) {
            System.out.println("full");
            return false;
        } else {
            rear = (++rear) % size;
            items[rear] = item;
            return true;
        }
    }

    @Override
    public boolean poll() {
        if (isEmpty()) {
            System.out.println("null");
            return false;
        } else {
            front = (++front) % size;
            return true;
        }
    }

    @Override
    public void peek() {
        System.out.println(items[(front + 1) % size]);
    }

    @Override
    public boolean isEmpty() {
        return rear == front;
    }

    @Override
    public boolean isFull() {
        return (rear + 1) % size == front;
    }

    //다양하게 로직 만들 수 있을 것 같음
    public void printQueue() {
        int f = front;

        while (f != rear) {
            f += 1;
            if (f == size) {
                System.out.print(items[0] + " ");
                f = 0;
            } else {
                System.out.print(items[f] + " ");
            }
        }
        System.out.println();
    }
}
