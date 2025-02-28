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
 * Implementação de um programa que verifica se duas palavras são anagramas.
 * Um anagrama é uma palavra ou frase formada pela transposição das letras de outra
 * palavra ou frase. Exemplos: "amor" e "roma", "amor" e "ramo".
 * Entrada: Frases com duas palavras separadas por um espaço.
 * Saída: SIM se as palavras forem anagramas, ou NÃO caso contrário.
 ******************************************************************/

public class anagrama {
    public static void main(String[] args) {
        String frase;
        Scanner ler= new Scanner(System.in);
        while (isfim((frase=ler.nextLine()))) {
            String[] palavra= frase.split(" ");
            if (verificar(palavra[0],palavra[2])){
                System.out.println("SIM");
            }
            else{
                System.out.println("NÃO");
            }
           
        }

    }

    static boolean verificar(String p1, String p2){
        boolean is= true;
        p1= p1.toLowerCase();
        p2= p2.toLowerCase();
        int letras1[]= new int[26];
        int letras2[]= new int[26];
        for(int i=0; i<26;i++){
                for(int z=0; z<p1.length();z++){
                    if(p1.charAt(z)==(97+i)){
                        letras1[i]++;
                    }
                }
                for(int z=0; z<p2.length();z++){
                    if(p2.charAt(z)==(97+i)){
                        letras2[i]++;
                    }
                }
        }
        for(int i=0; i<26;i++){
            if(letras2[i] != 0){
                if(letras2[i]!=letras1[i]){
                    is=false;
                }
                
            }
        }
        
        
        return is;
    }
    static boolean isfim(String frase){
        boolean fim= true;

        if(frase.equals("FIM")){
            fim= false;
        }
        return fim;
    }
}
