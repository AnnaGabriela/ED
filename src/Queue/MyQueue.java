package Queue;

public class MyQueue {
    
    
    public static void reverse (DynamicQueue queue) {
        int size = queue.size();
        DynamicQueue newQueue = new DynamicQueue();
        
        while(newQueue.size() != size) {
            newQueue.enqueue(queue.dequeue());
        }
        
        for(int i=0; queue.size() != size; i++) {
            if (i == size-1) {
                queue.enqueue(newQueue.dequeue());
                i = 0;
            } newQueue.enqueue(newQueue.dequeue());
        } 
        System.out.println(queue);
    }
    
    public static void main(String[] args) {
        DynamicQueue ola = new DynamicQueue();
        ola.enqueue(2);
        ola.enqueue(42);
        ola.enqueue(1);
        reverse(ola);
    }
}
