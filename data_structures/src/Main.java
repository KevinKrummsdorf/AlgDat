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

        System.out.println("\n");

        BoundedStack<Integer> boundedStack = new BoundedStack<Integer>(5);
        boundedStack.push(1).push(2).push(3).push(4).push(5);

        System.out.println("BoundedStack elements are:");
        while (!boundedStack.isEmpty()) {
            System.out.print(boundedStack.top()+" ");
            boundedStack.pop();
        }

        System.out.println("\n");

        BoundedQueue<Integer> boundedQueue = new BoundedQueue<Integer>(5);
        boundedQueue.enqueue(1).enqueue(2).enqueue(3).enqueue(4).enqueue(5);

        System.out.println("BoundedQueue elements are:");
        while (!boundedQueue.isEmpty()) {
            System.out.print(boundedQueue.front()+" ");
            boundedQueue.dequeue();
        }
    }
}
