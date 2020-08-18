package dataStructure.queue;

public class Main {
    public static void main(String[] args) {
        System.out.println("선형큐");
        LinearQueue linearQueue = new LinearQueue(5);
        linearQueue.offer('K');
        linearQueue.peek();
        linearQueue.offer('Q');
        linearQueue.offer('H');
        linearQueue.poll();
        linearQueue.offer('A');
        linearQueue.offer('B');
        linearQueue.printQueue();

        System.out.println("원형큐");
        CircularQueue circularQueue = new CircularQueue(4);
        circularQueue.offer('K');
        circularQueue.offer('Q');
        circularQueue.offer('H');
        circularQueue.poll();
        circularQueue.poll();
        circularQueue.offer('B');
        circularQueue.offer('C');
        circularQueue.printQueue();
    }
}


