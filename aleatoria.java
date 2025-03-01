import java.util.Scanner; // Importa a classe Scanner para leitura de dados
import java.util.Random; // Importa a classe Random para gerar números aleatórios

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

        //Scanner para leitura da entrada
        Scanner ler =new Scanner(System.in);
        //Gerador de números aleatórios
        Random gerador= new Random();
        //Semente para gerar números aleatórios
        gerador.setSeed(4);
        //String para armazenar a entrada
        String frase;
        

        //Loop para ler múltiplas linhas de entrada até encontrar a palavra FIM
        while (isfim(frase=ler.nextLine())) {

            //Vetor para armazenar a frase com as letras substituídas
            char[] frasef=new char[frase.length()];
            //Gera duas letras aleatórias
            char letra1=(char)('a' + (Math.abs(gerador.nextInt()) % 26));
            char letra2=(char)('a' + (Math.abs(gerador.nextInt()) % 26));

            //Loop para substituir as letras aleatórias
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
                //Se for um caractere especial, mantém o caractere
                else{
                    frasef[i]='\uFFFD';
                }
            }
            //Imprime a frase com as letras substituídas
            System.out.println(new String(frasef));
        }
        //Fecha o scanner
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
