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
 * Implementação de um programa que criptografa uma frase utilizando o
 * ciframento de César. O ciframento de César é uma técnica de criptografia
 * que consiste em substituir cada letra do texto original por outra letra
 * que se encontra um número fixo de posições à frente no alfabeto.
 * Entrada: Frases de até 1000 caracteres.
 * Saída: Frase criptografada.
 ******************************************************************/

public class cesar {

    public static void main(String[] args) {
        Scanner ler =new Scanner(System.in);
        String frase;
        while (isfim(frase=ler.nextLine())) {
            frase=encrypt(frase);
            System.out.println(frase);
        }   
        ler.close();
    }

    static String encrypt(String frase){
        char[] cesar= new char[frase.length()];

        for(int i=0; i<frase.length(); i++){
            if( frase.charAt(i)!='\uFFFD'){
            cesar[i]=(char) (frase.charAt(i)+3);
                }
                else{
                    cesar[i]='\uFFFD';
                }
        }

        return new String(cesar);
    }
    static boolean isfim(String frase){
        boolean fim= true;

        if(frase.equals("FIM")){
            fim= false;
        }
        return fim;
    }
}