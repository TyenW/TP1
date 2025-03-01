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
 * Implementação de um programa que criptografa uma frase utilizando o
 * ciframento de César. O ciframento de César é uma técnica de criptografia
 * que consiste em substituir cada letra do texto original por outra letra
 * que se encontra um número fixo de posições à frente no alfabeto.
 * Entrada: Frases de até 1000 caracteres.
 * Saída: Frase criptografada.
 ******************************************************************/

public class cesar {

    public static void main(String[] args) {
        // Scanner para leitura da entrada
        Scanner ler =new Scanner(System.in);
        // String para armazenar a entrada
        String frase;

        //  Loop para ler múltiplas linhas de entrada até encontrar a palavra FIM
        while (isfim(frase=ler.nextLine())) {
            // Chama a função que criptografa a frase
            frase=encrypt(frase);

            // Imprime a frase criptografada
            System.out.println(frase);
        }   
        // Fecha o scanner
        ler.close();
    }

    // Função que criptografa uma frase utilizando o ciframento de César
    static String encrypt(String frase){

        // Vetor para armazenar a frase criptografada
        char[] cesar= new char[frase.length()];

        // Loop para criptografar a frase utilizando o ciframento de César 
        for(int i=0; i<frase.length(); i++){
            // Verifica se o caractere é um caractere especial
            if( frase.charAt(i)!='\uFFFD'){
                // Criptografa o caractere
            cesar[i]=(char) (frase.charAt(i)+3);
                }
                // Se for um caractere especial, mantém o caractere
                else{
                    cesar[i]='\uFFFD';
                }
        }



        // System.out.println(cesar);
        return new String(cesar);
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