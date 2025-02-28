import java.util.*;

/******************************************************************
 * Universidade: Pontificia Universidade Catolica de Minas Gerais
 * Curso: Ciencia da Computacao
 * Disciplina: Algoritmos e Estruturas de Dados II
 * Autor: Pedro Guimarães Alves Freitas 
 * Matricula: 804517
 * Data: 27/02/2025
 * Linguagem: Java
 * Descrição: 
 * Implementação de um programa que conta o número de palavras em uma frase.
 * Entrada: Frases de até 1000 caracteres.
 * Saída: Número de palavras na frase.
 ******************************************************************/

public class contagem {
    public static void main(String[] args) {
        Scanner ler =new Scanner(System.in);
        String frase;
        while (isfim((frase=ler.nextLine()))) {
            String[] palavras= frase.split(" ");
            System.out.println(palavras.length);
        }


    }
    static boolean isfim(String frase){
        boolean fim= true;

        if(frase.equals("FIM")){
            fim= false;
        }
        return fim;
    }
}
