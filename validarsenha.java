import java.io.PrintStream;// Importa a classe PrintStream para impressão de dados
import java.util.Scanner; // Importa a classe Scanner para leitura de dados
import java.io.UnsupportedEncodingException; // Importa a classe UnsupportedEncodingException para tratamento de exceções

public class validarsenha {
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        try {
            System.setOut(new PrintStream(System.out, true, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String senha;
        while (isfim((senha = ler.nextLine()))) {
            if (validar(senha)) {
                System.out.println("SIM");
            } else {
                MyIO.println("NÃO");
            }
        }
        ler.close();
    }
    
    // Função que verifica se a senha é válida, contendo ao menos 8 caracteres, uma letra minúscula, uma letra maiúscula e um caractere especial
    static boolean validar(String senha) {
        // Variáveis para armazenar se a senha é válida
        boolean x1, x2, x3, x4, x5;
        boolean valido = false;
        // Inicializa as variáveis
        x1 = x2 = x3 = x4 = x5 = false;

        // Verifica se a senha tem ao menos 8 caracteres
        if (senha.length() >= 8) {
            x1 = true;
        }
        // Chama as funções que verificam se a senha contém ao menos uma letra minúscula, maiúscula e um caractere especial
        x2 = maiusculo(senha);
        x3 = minuscula(senha);
        x4 = especial(senha);
        x5= hasNumber(senha);
         // Verifica se a senha é válida
        if (x1 == true && x2 == true && x3 == true && x4 == true && x5 == true) {
            valido = true;
        }
        // Retorna se a senha é válida

    
        return valido;
    }

    // Função que verifica se a senha contém ao menos um número
    static boolean hasNumber(String senha) {
        // Loop para verificar se a senha contém ao menos um número
        for (int i = 0; i < senha.length(); i++) {
            // Utiliza a tabela ASCII para verificar se o caractere é um número,
            // com valores de 48 a 57
            if (senha.charAt(i) >= 48 && senha.charAt(i) <= 57) {
                return true;
            }
        }
        // Se não contém ao menos um número, retorna false
        return false;
    }

    // Função que verifica se a senha contém um caractere especial
    static boolean especial(String senha) {
        // Loop para verificar se a senha contém um caractere especial
        for (int i = 0; i < senha.length(); i++) {
            char c = senha.charAt(i);
            // Verifica se o caractere é um caractere especial utilizando a tabela ASCII
            if ((c >= 33 && c <= 47) || (c >= 58 && c <= 64) || (c >= 91 && c <= 96) || (c >= 123 && c <= 126)) {
                return true;
            }
        }
        // Se não contém ao menos um caractere especial, retorna false
        return false;
    }

    // Função que verifica se a senha contém ao menos uma letra minúscula
    static boolean minuscula(String senha) {
        // Loop para verificar se a senha contém ao menos uma letra minúscula
        for (int i = 0; i < senha.length(); i++) {
            // Utiliza a tabela ASCII para verificar se o caractere é uma letra minúscula,
            // com valores de 97 a 122
            if (senha.charAt(i) >= 97 && senha.charAt(i) <= 122) {
                return true;
            }
        }
        // Se não contém ao menos uma letra minúscula, retorna false
        return false;
    }

    // Função que verifica se a senha contém ao menos uma letra maiúscula
    static boolean maiusculo(String senha) {

        // Loop para verificar se a senha contém ao menos uma letra maiúscula
        for (int i = 0; i < senha.length(); i++) {
            // Utiliza a tabela ASCII para verificar se o caractere é uma letra maiúscula,
            // com valores de 65 a 90
            if (senha.charAt(i) >= 65 && senha.charAt(i) <= 90) {
                return true;
            }
        }
        // Se não contém ao menos uma letra maiúscula, retorna false
        return false;

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
