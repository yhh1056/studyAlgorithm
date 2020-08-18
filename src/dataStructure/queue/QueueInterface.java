package dataStructure.queue;

/**
 * author {yhh1056}
 * Create by {2020/08/18}
 */
public interface QueueInterface {
    boolean offer(char item);

    boolean poll();

    void peek();

    boolean isEmpty();

    boolean isFull();
}
