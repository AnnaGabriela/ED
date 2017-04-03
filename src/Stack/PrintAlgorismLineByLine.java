/*
 * Faça um algoritmo que recebe um número
 * natural e imprime na tela cada um de 
 * seus algorismos por linha.
 * 
 * Obs: não deve ser recursivo. Também
 * não pode usar Strings ou vetores, 
 * deve ser usado pilha.
 * 
 * @author Anna Gabriela
*/

package Stack;

import java.util.Stack;

public class PrintAlgorismLineByLine {

    Stack stack = new Stack();

    public void print(int number) {
        while (number > 10) {
            int remainder = number % 10;
            number = number / 10;
            stack.push(remainder);
        }
        stack.push(number);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        PrintAlgorismLineByLine ex = new PrintAlgorismLineByLine();
        ex.print(122);
    }
}
