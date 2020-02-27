import java.util.PriorityQueue;

public class PriortyQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(9);
        pq.offer(2);
        pq.offer(10);
        pq.offer(15);
        pq.offer(3);
        pq.offer(1);
        pq.offer(7);
        pq.offer(23);
        pq.offer(89);
        while(!pq.isEmpty()){
            System.out.print(pq.poll() + " ");
        }
    }

}
