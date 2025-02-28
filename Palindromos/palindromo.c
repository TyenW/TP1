/******************************************************************
 * Universidade: Pontificia Universidade Catolica de Minas Gerais
 * Curso: Ciencia da Computacao
 * Disciplina: Algoritmos e Estruturas de Dados II
 * Professor: Daniel de Oliveira Capanema e Gabriel Barbosa da Fonseca
 * Autor: Pedro Guimarães Alves Freitas 
 * Matricula: 804517
 * Data: 27/02/2025
 * Linguagem: C
 * Descrição: 
 * Implementação de um programa que verifica se uma frase é um palíndromo.
 * Um palíndromo é uma palavra, frase ou número que é igual ao original
 * quando lido de trás para frente. Exemplos: "ovo", "arara", "Ame o poema".
 * Entrada: Frases de até 1000 caracteres.
 * Saída: SIM se a frase for um palíndromo, ou NAO caso contrário.
 ******************************************************************/

#include <stdio.h>
#include <string.h>  // Adicionado para usar strlen e strcspn
#include <stdbool.h> // Adicionado para usar o tipo bool

int main() {
    char frase[1000];
    bool palindromo;
    
    // Loop para ler múltiplas linhas de entrada
    while (fgets(frase, sizeof(frase), stdin)) {
        // Remove o caractere de nova linha
        frase[strcspn(frase, "\n")] = 0;
        
        // Se a linha estiver vazia, sai do loop
        if (strlen(frase) == 0) {
            break;
        }
        
        palindromo = true;
        
        int len = strlen(frase);
        
        // Verifica se a frase é um palíndromo
        for (int i = 0; i < len / 2; i++) {
            if (frase[i] != frase[len - 1 - i]) {
                palindromo = false;
                i = len;  // Sai do loop
            }
        }
        
        // Imprime o resultado
        if (palindromo) {
            printf("SIM\n");
        } else {
            printf("NAO\n");
        }
    }
    
    return 0;
}
