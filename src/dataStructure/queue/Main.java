package dataStructure.queue;

public class Main {
    public static void main(String[] args) {
        //선형큐 생성
        LinearQueue linearQueue = new LinearQueue(5);
        linearQueue.offer('K');
        linearQueue.peek();
        linearQueue.offer('Q');
        linearQueue.offer('H');
        linearQueue.poll();
        linearQueue.offer('A');
        linearQueue.offer('B');
        linearQueue.printQueue();
    }
}


