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
 * Implementação de um programa que substitui duas letras aleatórias de uma frase.
 * Entrada: Frases de até 1000 caracteres.
 * Saída: Frase com duas letras aleatórias substituídas.
 ******************************************************************/


public class aleatoria {
    public static void main(String[] args) {
        Scanner ler =new Scanner(System.in);
        Random gerador= new Random();
        gerador.setSeed(4);
        String frase;
        
        while (isfim(frase=ler.nextLine())) {
            char[] frasef=new char[frase.length()];
            char letra1=(char)('a' + (Math.abs(gerador.nextInt()) % 26));
            char letra2=(char)('a' + (Math.abs(gerador.nextInt()) % 26));
            for(int i=0;i<frase.length();i++){
                if( frase.charAt(i)!='\uFFFD'){
                    if(frase.charAt(i)==letra1){
                        frasef[i]=letra2;
                    }
                    else if(frase.charAt(i)==letra2){
                        frasef[i]=letra1;
                    }
                    else{
                        frasef[i]=frase.charAt(i);
                    }
                }
                else{
                    frasef[i]='\uFFFD';
                }
            }
            System.out.println(new String(frasef));
        }

        ler.close();
    }
    static boolean isfim(String frase){
        boolean fim= true;

        if(frase.equals("FIM")){
            fim= false;
        }
        return fim;
    }
}
