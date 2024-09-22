package Stacks;

import java.util.LinkedList;
import java.util.Scanner;

public class StackMain {

    public static void main(String[] args) throws StackException {
        LinkedList list = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt(); 
        CustomStack stack = new CustomStack(q);
        
        while (q-- > 0) {
            int op = sc.nextInt(); 
            switch (op) {
                case 1 -> {
                    int data = sc.nextInt();
                    stack.push(data);
                }
                case 2 -> {
                    System.out.println(stack.pop());
                }
                case 3 -> {
                    System.out.println(stack.peek());
                }
                case 4 -> {
                    System.out.println(stack.isEmpty());
                }
                case 5 -> {
                    System.out.println(stack.size());
                }
                default -> throw new AssertionError("Invalid operation");
            }
        }
        sc.close();
    }

    static class CustomStack {
        protected int[] data;
        private static final int DEFAULT_SIZE = 10;
        private int size = 0;
        private int ptr = -1;

        public CustomStack() {
            this(DEFAULT_SIZE);
        }

        public CustomStack(int size) {
            this.data = new int[size];
        }

        public boolean push(int item) throws StackException {
            if (isFull()) {
                throw new StackException("Stack is full");
            }
            data[++ptr] = item;
            size++;
            return true;
        }

        public int pop() throws StackException {
            if (isEmpty()) {
                throw new StackException("Stack is empty");
            }
            size--;
            return data[ptr--];
        }

        public int peek() throws StackException {
            if (isEmpty()) {
                throw new StackException("Stack is empty");
            }
            return data[ptr];
        }

        private boolean isFull() {
            return ptr == data.length - 1;
        }

        private boolean isEmpty() {
            return ptr == -1;
        }

        public int size() {
            return size;
        }
    }

    static class StackException extends Exception {
        public StackException(String message) {
            super(message);
        }
    }
}