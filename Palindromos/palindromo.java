package Palindromos;
import java.util.*;

/******************************************************************
 * Universidade: Pontificia Universidade Catolica de Minas Gerais
 * Curso: Ciencia da Computacao
 * Disciplina: Algoritmos e Estruturas de Dados II
 * Professor: Daniel de Oliveira Capanema e Gabriel Barbosa da Fonseca
 * Autor: Pedro Guimarães Alves Freitas 
 * Matricula: 804517
 * Data: 27/02/2025
 * Linguagem: Java
 * Descrição: 
 * Implementação de um programa que verifica se uma frase é um palíndromo.
 * Um palíndromo é uma palavra, frase ou número que é igual ao original
 * quando lido de trás para frente. Exemplos: "ovo", "arara", "Ame o poema".
 * Entrada: Frases de até 1000 caracteres.
 * Saída: SIM se a frase for um palíndromo, ou NAO caso contrário.
 ******************************************************************/

public class palindromo {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        String frase;
        boolean palindromo;

        // Loop para ler múltiplas linhas de entrada
        while (ler.hasNextLine()) {
            frase = ler.nextLine();
            
            // Se a linha estiver vazia, sai do loop
            if (frase.isEmpty()) {
                break;
            }

            palindromo = true;

            // Verifica se a frase é um palíndromo
            for (int i = 0; i < (frase.length() / 2); i++) {
                if (frase.charAt(i) != frase.charAt(frase.length() - 1 - i)) {
                    palindromo = false;
                    break;  // Sai do loop
                }
            }

            // Imprime o resultado
            if (palindromo) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }
    }
}