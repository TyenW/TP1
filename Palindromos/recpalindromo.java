package Palindromos; // Pacote ao qual o programa está associado
import java.util.Scanner; // Importa a classe Scanner para leitura de dados

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

public class recpalindromo {

    public static void main(String[] args) {
        // Scanner para leitura da entrada
        Scanner ler = new Scanner(System.in);
        String frase;

        // Loop para ler múltiplas linhas de entrada até encontrar uma linha vazia
        while (ler.hasNextLine()) {
            frase = ler.nextLine();
            
            // Se a linha estiver vazia, sai do loop
            if (frase.isEmpty()) {
                break;
            }

            // Verifica se a frase é um palíndromo usando o método recursivo
            if (isPalindromo(frase, 0, frase.length() - 1)) {
                System.out.println("SIM");
            } else {
                System.out.println("NAO");
            }
        }
        // Fecha o scanner
        ler.close();
    }

    // Método recursivo para verificar se uma frase é um palíndromo
    public static boolean isPalindromo(String frase, int inicio, int fim) {
        // Caso base: se os índices se cruzarem ou forem iguais, é um palíndromo
        if (inicio >= fim) {
            return true;
        }
        // Se os caracteres nas posições atuais não forem iguais, não é um palíndromo
        if (frase.charAt(inicio) != frase.charAt(fim)) {
            return false;
        }
        // Chamada recursiva para os próximos caracteres
        return isPalindromo(frase, inicio + 1, fim - 1);
    }
}