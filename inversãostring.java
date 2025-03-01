import java.util.Scanner; // Importa a classe Scanner para leitura de dados

/******************************************************************
 * Universidade: Pontificia Universidade Catolica de Minas Gerais
 * Curso: Ciencia da Computacao
 * Disciplina: Algoritmos e Estruturas de Dados II
 * Professor: Daniel de Oliveira Capanema e Gabriel Barbosa da Fonseca
 * Autor: Pedro Guimarães Alves Freitas 
 * Matricula: 804517
 * Data: 01/03/2025
 * Linguagem: Java
 * Descrição: 
 * Implementação de um programa que inverte uma frase.
 * Entrada: Frases de até 1000 caracteres.
 * Saída: Frase invertida.
 ******************************************************************/

public class inversãostring {

    public static void main(String[] args) {
        // Scanner para leitura da entrada
        Scanner ler =new Scanner(System.in);

        // String para armazenar a entrada
        String frase;

        while (isfim((frase=ler.nextLine()))) {
            // Chama a função que inverte a frase
            frase=inverter(frase);

            // Imprime a frase invertida
            System.out.println(frase);
            
        }
        // Fecha o scanner
        ler.close();
    }

    // Função que inverte a frase
    static String inverter(String frase){
        // Vetor para armazenar a frase invertida
        char[] invertida= new char[frase.length()];

        // Loop para inverter a frase
        for(int i=0; i<frase.length(); i++){
            // Armazena o caractere na posição i do vetor invertido
            invertida[i]=frase.charAt(frase.length()-1-i);
        }

        // Retorna a frase invertida
        return new String(invertida);
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