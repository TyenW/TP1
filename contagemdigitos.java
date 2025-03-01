import java.util.Scanner; // Importa a classe Scanner para leitura de dados
import java.lang.Math; // Importa a classe Math para operações matemáticas

/******************************************************************
 * Universidade: Pontificia Universidade Catolica de Minas Gerais
 * Curso: Ciencia da Computacao
 * Disciplina: Algoritmos e Estruturas de Dados II
 * Professor: Daniel de Oliveira Capanema e Gabriel Barbosa da Fonseca
 * Autor: Pedro Guimarães Alves Freitas 
 * Matricula: 804517
 * Data: 1/03/2025
 * Linguagem: Java
 * Descrição: 
 * Soma cada digito de um número e imprime a soma.
 * Entrada: Números inteiros de até 1000 caracteres.
 * Saída: Soma dos dígitos do número.
 ******************************************************************/


public class contagemdigitos {
    public static void main(String[] args) {
        // Scanner para leitura da entrada
        Scanner ler = new Scanner(System.in);
        // String para armazenar a entrada
        String numero;
        
        // Loop para ler múltiplas linhas de entrada até encontrar a palavra FIM
        while (isfim(numero=ler.nextLine())) {
        // Converte a string para inteiro
        int num= Integer.parseInt(numero);
        // Chama a função contagem
        contagem(num, (numero.length()));
            
        }

        // Fecha o scanner
        ler.close();

    }
    
    // Função que soma cada digito de um número e imprime a soma
    static void contagem(int num, int digito){

        // Vetor para armazenar os dígitos do número
        int numeros[]= new int[digito+1];
        // Inicializa a soma
        numeros[digito]=0;

        // Loop para somar cada digito do número
        for(int i=digito-1; i>=0; i--){
            // Armazena o dígito na posição i do vetor
            numeros[i]=(int)(num/Math.pow(10, i));
            num= num-(numeros[i]*(int)Math.pow(10, i));
            // Soma o dígito ao total
            numeros[digito]+=numeros[i];

        }

    // Imprime a soma
       System.out.println(numeros[digito]);
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
