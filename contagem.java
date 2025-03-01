import java.util.Scanner;// Importa a classe Scanner para leitura de dados

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
 * Implementação de um programa que conta o número de palavras em uma frase.
 * Entrada: Frases de até 1000 caracteres.
 * Saída: Número de palavras na frase.
 ******************************************************************/

public class contagem {
    public static void main(String[] args) {
        // Scanner para leitura da entrada
        Scanner ler =new Scanner(System.in);
        // String para armazenar a entrada
        String frase;

        // Loop para ler múltiplas linhas de entrada até encontrar a palavra FIM
        while (isfim((frase=ler.nextLine()))) {

            // Separa a frase em palavras e conta o número de palavras
            String[] palavras= frase.split(" ");

            // Imprime o número de palavras
            System.out.println(palavras.length);
        }

        // Fecha o scanner
        ler.close();

    }

    // Função que verifica se a entrada é a palavra FIM
    static boolean isfim(String frase){
        // Variável para armazenar se a entrada é FIM
        boolean fim= true;

        // Se a entrada for FIM, retorna false
        if(frase.equals("FIM")){
            fim= false;
        }
        // Retorna se a entrada é FIM
        return fim;
    }
}
