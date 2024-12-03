import Queue.*;
import Stack.*;

public class Main {
    public static void main(String[] args)  {
        
        QueueImpl<Integer> queue = new QueueImpl<Integer>();
        queue.enqueue(1).enqueue(2).enqueue(3).enqueue(4).enqueue(5);
        
        System.out.println("Queue elements are:");
        while (!queue.isEmpty()) {
            System.out.print(queue.front()+" ");
            queue.dequeue();
        }

        System.out.println("\n");

        StackImpl<Integer> stack = new StackImpl<Integer>();
        stack.push(1).push(2).push(3).push(4).push(5);

        System.out.println("Stack elements are:");
        while (!stack.isEmpty()) {
            System.out.print(stack.top()+" ");
            stack.pop();
        }
    }
}
