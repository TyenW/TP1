import java.util.Scanner; // Importa a classe Scanner para leitura de dados

//ver com o gabriel erro na questão!


/******************************************************************
 * Universidade: PUC Minas
 * Curso: Ciencia da Computacao
 * Disciplina: AED II
 * Professor: Daniel Capanema e Gabriel Fonseca
 * Autor: Pedro Freitas
 * Matricula: 804517
 * Data: 01/03/2025
 * Linguagem: Java
 * Descrição:
 * Crie um método iterativo que recebe uma string como parâmetro e
 * escreva uma linha de saída com o comprimento da substring mais
 * longa sem repetição. Por exemplo, se a entrada for abcabcbb, a
 * saída deve ser 3 (correspondendo à substring abc).
 *
 * Entrada: Frases de até 1000 caracteres.
 * Saída:
 ******************************************************************/

public class substring {

    public static void main(String[] args) {

        // Scanner para leitura da entrada
        Scanner ler = new Scanner(System.in);

        // String para armazenar a entrada
        String frase;

        // Loop para ler múltiplas linhas de entrada até encontrar a palavra FIM
        while (isfim(frase = ler.nextLine())) {
            System.out.println(verificador(frase));
        }
        // Fecha o scanner
        ler.close();

    }

    // Função que conta o tamanho da maior substring sem repetição
    static int verificador(String frase) {
        int n = frase.length();
        int res = 0; // Resultado
        int[] lastIndex = new int[256]; // Array para armazenar o último índice de cada caractere
        for (int i = 0; i < 256; i++) {
            lastIndex[i] = -1; // Inicializa todos os índices com -1
        }
        int i = 0; // Índice inicial da substring sem repetição

        // Loop para contar o tamanho da maior substring sem repetição
        for (int j = 0; j < n; j++) {
            i = Math.max(i, lastIndex[frase.charAt(j)] + 1);
            res = Math.max(res, j - i + 1);
            lastIndex[frase.charAt(j)] = j;
        }
        if (res>=frase.length()){
            return 0;
            
        }
        return res;
    }

    // Função que verifica se a entrada é a palavra FIM
    static boolean isfim(String frase) {
        // Variável para armazenar se a entrada é FIM
        boolean fim = true;

        // Se a entrada for FIM, retorna false
        if (frase.equals("FIM")) {
            fim = false;
        }
        // Retorna se a entrada é FIM
        return fim;
    }
}
