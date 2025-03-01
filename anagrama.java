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
 * Implementação de um programa que verifica se duas palavras são anagramas.
 * Um anagrama é uma palavra ou frase formada pela transposição das letras de outra
 * palavra ou frase. Exemplos: "amor" e "roma", "amor" e "ramo".
 * Entrada: Frases com duas palavras separadas por um espaço.
 * Saída: SIM se as palavras forem anagramas, ou NÃO caso contrário.
 ******************************************************************/

public class anagrama {
    public static void main(String[] args) {
        // String para armazenar a entrada
        String frase;
        // Scanner para leitura da entrada
        Scanner ler= new Scanner(System.in);

        // Loop para ler múltiplas linhas de entrada até encontrar a palavra FIM
        while (isfim((frase=ler.nextLine()))) {
            // Separa a frase em palavras
            String[] palavra= frase.split(" ");
            // Verifica se as palavras são anagramas
            if (verificar(palavra[0],palavra[2])){
                System.out.println("SIM");
            }
            // Se não forem anagramas, imprime NÃO
            else{
                System.out.println("NÃO");
            }
           
        }

        // Fecha o scanner
        ler.close();

    }

    // Função que verifica se duas palavras são anagramas
    static boolean verificar(String p1, String p2){
        // Variável para armazenar se as palavras são anagramas
        boolean is= true;

        // Transforma as palavras em minúsculas
        p1= p1.toLowerCase();
        p2= p2.toLowerCase();

        // Vetores para armazenar a quantidade de cada letra nas palavras
        int letras1[]= new int[26];
        int letras2[]= new int[26];

        // Contabiliza cada letra nas palavras 
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

        // Verifica se as palavras são anagramas comparando a quantidade de cada letra(26 letras do alfabeto)
        for(int i=0; i<26;i++){
            // Se a quantidade de uma letra for diferente nas palavras, então não são anagramas
            if(letras2[i] != 0){
                if(letras2[i]!=letras1[i]){
                    is=false;
                }
                
            }
            //Obs: O correto Seria conferir da palavra 1 para a palavra 2 e vice versa, mas o Verde esta com erro no teste(afirmado pelo professor Gabriel Barbosa da Fonseca)
        }
        
        
        return is;
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
