/* 
    Faça um algoritmo que recebe um
    número natural e imprime na tela
    cada um de seus algarismos linha
    por linha (usando pilha).
 */
package Stack;

public class MyStack implements TADStack {

    private int[] stack = new int[10];
    private int top = -1;

    @Override
    public void push(int number) {
        if (isFull()) {
            realloc();
        }
        top++;
        stack[top] = number;
    }

    @Override
    public int pop() {
        if (!isEmpty()) {
            int poppedNumber = stack[top];
            stack[top] = 0;
            top--;
            return poppedNumber;
        } else {
            return 0;
        }
    }

    @Override
    public int top() {
        return stack[top];
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return stack[0] == -1;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    private void realloc() {
        int[] doubleStack = new int[stack.length * 2];
        for (int i = 0; i <= doubleStack.length; i++) {
            doubleStack[i] = stack[i];
        }
        stack = doubleStack;
    }

    public static void main(String[] args) {
        MyStack func = new MyStack();
        //func.imprime(122);
        func.push(12);
        func.push(3);
        System.out.println(func.isEmpty() + "\n" + func.isFull() + "\n" + func.top());
        System.out.println(func.pop());
    }
}
