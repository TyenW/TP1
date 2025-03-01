import java.util.Scanner;  // Importa a classe Scanner para leitura de dados

/******************************************************************
 * Universidade: Pontificia Universidade Catolica de Minas Gerais
 * Curso: Ciencia da Computacao
 * Disciplina: Algoritmos e Estruturas de Dados II
 * Professor: Daniel de Oliveira Capanema e Gabriel Barbosa da Fonseca
 * Autor: Pedro Guimarães Alves Freitas 
 * Matricula: 804517
 * Data: 28/02/2025
 * Linguagem: Java
 * Descrição: 
 * Implementação de um programa que verifica se uma frase contém 
 * somente vogais, somente consoantes, se é um número inteiro ou/e 
 * número real.
 * Entrada: Frases de até 1000 caracteres.
 * Saída: SIM ou NAO para cada uma das verificações.
 ******************************************************************/

public class is {
    public static void main(String[] args) {
        // Scanner para leitura da entrada
        Scanner ler =new Scanner(System.in);   
        // String para armazenar a entrada
        String frase;
        // Variáveis para armazenar os resultados das verificações 
        boolean x1,x2,x3,x4;
        
        // Loop para ler múltiplas linhas de entrada até encontrar a palavra FIM
        while (isfim(frase=ler.nextLine())) {
            // Inicializa as variáveis
            x1=x2=x3=x4=false;
             
            // Chama a função que verifica se a frase contém somente vogais, consoantes, número inteiro ou número real
            verifica(frase,x1,x2,x3,x4);


        }
        // Fecha o scanner
        ler.close();    

    }

    //Função que chama as funções de verificação e exibe o resultado
    static void verifica(String frase,boolean x1, boolean x2, boolean x3, boolean x4){
        // Verifica se a frase contém somente vogais
        x1=cnfvogal(frase);

        //verifica se a frase contém somente consoantes
        x2=cnfconsoante(frase,x1);
        
        //verifica se a frase é um número inteiro
        x3=cnfnumeroint(frase, x1, x2);

        //verifica se a frase é um número real
        x4=cnfnumeroreal(frase, x1, x2, x3);
       
        // Exibe o resultado
        exibir(x1,x2,x3,x4);

    }

    // Função que verifica se é um número real ou não
    static boolean cnfnumeroreal(String frase, boolean x1, boolean x2, boolean x3){
        // Se o número é inteiro, então é um número real
        if(x3==true){
            return true;
        }
        // Se a frase contém somente vogais ou consoantes, não é um número real
        if (x1==true || x2==true){
            return false;
            
        }

        // Inicializa a variável que armazena se é um número real
        boolean x4=true;
        int pont=0;
        int virgula=0;

        // Loop para verificar se a frase é um número real
        for(int i=0;i<frase.length();i++){
            // Verifica se a frase contém vírgula ou ponto
            if(frase.charAt(i)== ','){
                virgula++;
            }
            else if(frase.charAt(i)== '.'){
                pont++;
            }
            // Verifica se a frase contém caracteres diferentes de números e vírgula ou ponto, se sim, não é um número real
            else if(frase.charAt(i)!='0' && frase.charAt(i)!='1' && frase.charAt(i)!='2' && frase.charAt(i)!='3' && frase.charAt(i)!='4' && frase.charAt(i)!='5' && frase.charAt(i)!='6' && frase.charAt(i)!='7' && frase.charAt(i)!='8' && frase.charAt(i)!='9'){
                return false;
                
            }
           
        }
       // Se a frase contém mais de uma vírgula ou ponto, não é um número real
        if (pont>=2 || virgula>=2){
            x4=false;
            
    }
    

    return x4;
}

    // Função que verifica se a frase contém somente vogais
    static boolean cnfvogal(String frase){

        // Inicializa a variável que armazena se a frase contém somente vogais
        boolean x1=true;

        // Loop para verificar se a frase contém somente vogais
        for(int i=0;i<frase.length();i++){
            // Verifica se a frase contém caracteres diferentes de vogais, se sim, não é somente vogal
            if(frase.charAt(i)!='a' && frase.charAt(i)!='e' && frase.charAt(i)!='i' && frase.charAt(i)!='o' && frase.charAt(i)!='u'){
                x1=false;
            }
        }

        return x1;
    }
  
    // Função que verifica se a frase contém somente consoantes
    static boolean cnfconsoante(String frase, boolean x1){
        // Se a frase contém somente vogais, não é somente consoante
        if(x1==true){
            return false;
        }
        // Inicializa a variável que armazena se a frase contém somente consoantes
        boolean x2=true;

        // Loop para verificar se a frase contém somente consoantes
        for(int i=0;i<frase.length();i++){
            // Verifica se a frase contém caracteres diferentes de consoantes, se sim, não é somente consoante
            if(frase.charAt(i)!='b' && frase.charAt(i)!='c' && frase.charAt(i)!='d' && frase.charAt(i)!='f' && frase.charAt(i)!='g' && frase.charAt(i)!='h' && frase.charAt(i)!='j' && frase.charAt(i)!='k' && frase.charAt(i)!='l' && frase.charAt(i)!='m' && frase.charAt(i)!='n' && frase.charAt(i)!='p' && frase.charAt(i)!='q' && frase.charAt(i)!='r' && frase.charAt(i)!='s' && frase.charAt(i)!='t' && frase.charAt(i)!='v' && frase.charAt(i)!='w' && frase.charAt(i)!='x' && frase.charAt(i)!='y' && frase.charAt(i)!='z'){
                x2=false;
            }
        }
        return x2;
    }
   
    // Função que verifica se é um número inteiro ou não
    static boolean cnfnumeroint(String frase, boolean x1, boolean x2){
        // Se a frase contém somente vogais ou consoantes, não é um número inteiro
        if (x1==true || x2==true){
            return false;
            
        }

       // Inicializa a variável que armazena se é um número inteiro
        boolean x3=true;
        int pont=0;
        int virgula=0;

        // Loop para verificar se a frase é um número inteiro
        for(int i=0;i<frase.length();i++){
            // Verifica se a frase contém vírgula ou ponto
            if(frase.charAt(i)== ','){
                virgula++;
            }
            else if(frase.charAt(i)== '.'){
                pont++;
            }
            // Verifica se a frase contém caracteres diferentes de números e vírgula ou ponto, se sim, não é um número inteiro
            else if(frase.charAt(i)!='0' && frase.charAt(i)!='1' && frase.charAt(i)!='2' && frase.charAt(i)!='3' && frase.charAt(i)!='4' && frase.charAt(i)!='5' && frase.charAt(i)!='6' && frase.charAt(i)!='7' && frase.charAt(i)!='8' && frase.charAt(i)!='9'){
                return false;
            }
           
        }
        // Se a frase contém mais de uma vírgula ou ponto, não é um número inteiro
        if (pont!=0 || virgula!=0){
            x3=false;
    }
    return x3;
}
    // Função que exibe o resultado
    static void exibir(boolean x1, boolean x2, boolean x3, boolean x4){
        // Exibe o resultado
        if(x1){
            System.out.print("SIM ");
        }
        else{
            System.out.print("NAO ");
        }
        if(x2){
            System.out.print("SIM ");
        }
        else{
            System.out.print("NAO ");
        }
        if(x3){
            System.out.print("SIM ");
        }
        else{
            System.out.print("NAO ");
        }
        if(x4){
            System.out.println("SIM");
        }
        else{
            System.out.println("NAO");
        }
        
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
