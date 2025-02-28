import java.util.Scanner;

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
        Scanner ler =new Scanner(System.in);   
        String frase;
        boolean x1,x2,x3,x4;
        
        while (isfim(frase=ler.nextLine())) {
            x1=x2=x3=x4=false;
             
            verifica(frase,x1,x2,x3,x4);


        }
        ler.close();    

    }
    static void verifica(String frase,boolean x1, boolean x2, boolean x3, boolean x4){
        x1=cnfvogal(frase);
        x2=cnfconsoante(frase,x1);
        x3=cnfnumeroint(frase, x1, x2);
        x4=cnfnumeroreal(frase, x1, x2, x3);
       
        
        exibir(x1,x2,x3,x4);

    }
    static boolean cnfnumeroreal(String frase, boolean x1, boolean x2, boolean x3){
        if(x3==true){
            return true;
        }
        if (x1==true || x2==true){
            return false;
            
        }
        boolean x4=true;
        int pont=0;
        int virgula=0;
        for(int i=0;i<frase.length();i++){
            if(frase.charAt(i)== ','){
                virgula++;
            }
            else if(frase.charAt(i)== '.'){
                pont++;
            }
            else if(frase.charAt(i)!='0' && frase.charAt(i)!='1' && frase.charAt(i)!='2' && frase.charAt(i)!='3' && frase.charAt(i)!='4' && frase.charAt(i)!='5' && frase.charAt(i)!='6' && frase.charAt(i)!='7' && frase.charAt(i)!='8' && frase.charAt(i)!='9'){
                return false;
                
            }
           
        }
       
        if (pont>=2 || virgula>=2){
            x4=false;
            
    }
    

    return x4;
}

    static boolean cnfvogal(String frase){
        boolean x1=true;
        for(int i=0;i<frase.length();i++){
            if(frase.charAt(i)!='a' && frase.charAt(i)!='e' && frase.charAt(i)!='i' && frase.charAt(i)!='o' && frase.charAt(i)!='u'){
                x1=false;
            }
        }

        return x1;
    }
    static boolean cnfconsoante(String frase, boolean x1){
        if(x1==true){
            return false;
        }
        boolean x2=true;
        for(int i=0;i<frase.length();i++){
            if(frase.charAt(i)!='b' && frase.charAt(i)!='c' && frase.charAt(i)!='d' && frase.charAt(i)!='f' && frase.charAt(i)!='g' && frase.charAt(i)!='h' && frase.charAt(i)!='j' && frase.charAt(i)!='k' && frase.charAt(i)!='l' && frase.charAt(i)!='m' && frase.charAt(i)!='n' && frase.charAt(i)!='p' && frase.charAt(i)!='q' && frase.charAt(i)!='r' && frase.charAt(i)!='s' && frase.charAt(i)!='t' && frase.charAt(i)!='v' && frase.charAt(i)!='w' && frase.charAt(i)!='x' && frase.charAt(i)!='y' && frase.charAt(i)!='z'){
                x2=false;
            }
        }
        return x2;
    }
    static boolean cnfnumeroint(String frase, boolean x1, boolean x2){
        if (x1==true || x2==true){
            return false;
            
        }
       
        boolean x3=true;
        int pont=0;
        int virgula=0;
        for(int i=0;i<frase.length();i++){
            if(frase.charAt(i)== ','){
                virgula++;
            }
            else if(frase.charAt(i)== '.'){
                pont++;
            }
            else if(frase.charAt(i)!='0' && frase.charAt(i)!='1' && frase.charAt(i)!='2' && frase.charAt(i)!='3' && frase.charAt(i)!='4' && frase.charAt(i)!='5' && frase.charAt(i)!='6' && frase.charAt(i)!='7' && frase.charAt(i)!='8' && frase.charAt(i)!='9'){
                return false;
            }
           
        }
        if (pont!=0 || virgula!=0){
            x3=false;
    }
    return x3;
}

    static void exibir(boolean x1, boolean x2, boolean x3, boolean x4){
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

    static boolean isfim(String frase){
        boolean fim= true;

        if(frase.equals("FIM")){
            fim= false;
        }
        return fim;
    }

}
