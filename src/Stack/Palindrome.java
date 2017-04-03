/**
 * Faça um algoritmo que deve receber do usuario
 * uma letra ou um número natural por vez. Caso o
 * usuário digite # o programa interrompe a entrada
 * de dados para calcular a resposta final.
 * Usando apenas pilha e tipos de dados primitivos,
 * o programa deve iniciar se a sequência de letras
 * forma um palíndromo, assim como a sequência de
 * números.
 *
 * @author Anna Gabriela
 */
package Stack;

import java.util.Scanner;
import java.util.Stack;

public class Palindrome {

    public void separateStack(Stack<Character> stack) throws EmptyStackException {
        Stack<Character> stackNumber = new Stack<>();
        Stack<Character> stackLetter = new Stack<>();

        while (!stack.isEmpty()) {
            if (Character.isDigit(stack.peek())) {
                stackNumber.push(stack.pop());
            } else {
                stackLetter.push(stack.pop());
            }
        }

        if (stackNumber.isEmpty()) {
            isPalindromeOfLetters(stackLetter);
        } else if (stackLetter.isEmpty()) {
            isPalindromeOfNumbers(stackNumber);
        } else if (!(stackNumber.isEmpty() && stackLetter.isEmpty())) {
            isPalindromeOfLetters(stackLetter);
            isPalindromeOfNumbers(stackNumber);
        } else {
            throw new EmptyStackException();
        }
    }

    private void isPalindromeOfLetters(Stack<Character> stackLetter) {
        Stack newStack = new Stack();

        if (stackLetter.size() % 2 == 0) {
            for (int i = 0; i <= stackLetter.size() / 2; i++) {
                newStack.push(stackLetter.pop());
            }

        } else {
            for (int i = 0; i < stackLetter.size() / 2; i++) {
                newStack.push(stackLetter.pop());
            }
            stackLetter.pop();
        }

        if (stackLetter.equals(newStack)) {
            System.out.println("It's a palindrome of letters.");
        } else {
            System.out.println("It's not a palindrome of letters.");
        }

    }

    private void isPalindromeOfNumbers(Stack<Character> stackNumber) {
        Stack newStack = new Stack();

        if (stackNumber.size() % 2 == 0) {
            for (int i = 0; i <= stackNumber.size() / 2; i++) {
                newStack.push(stackNumber.pop());
            }

        } else {
            for (int i = 0; i < stackNumber.size() / 2; i++) {
                newStack.push(stackNumber.pop());
            }
            stackNumber.pop();
        }

        if (stackNumber.equals(newStack)) {
            System.out.println("It's a palindrome of numbers.");
        } else {
            System.out.println("It's not a palindrome of numbers.");
        }
    }

    public static void main(String[] args) throws EmptyStackException {
        Scanner scan = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        Palindrome palindrome = new Palindrome();
        char symbol = 0;

        while (symbol != '#') {
            System.out.println("Choose a number or letter (Press # to get the results):");
            symbol = scan.next().charAt(0);

            if (symbol != '#') {
                stack.push(symbol);
            }
        }
        palindrome.separateStack(stack);
    }

}
