/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.antesdofim;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author rodrigocarvalho
 */
public class MainAntesDoFim {
    
    static Scanner input = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    
    public static int rolarDado() {
        Random gerador = new Random();
        int opcao = 0;
        int numSorteado = -1;
        System.out.println("Escolha qual dado você quer rolar.");
        System.out.println("Caso o valor seja inválido, será rolado o dado de menor valor!");
        System.out.println("1. D4 = Dado de 4 lados");
        System.out.println("2. D6 = Dado de 6 lados");
        System.out.println("3. D8 = Dado de 8 lados");
        System.out.println("4. D10 = Dado de 10 lados");
        System.out.println("5. D12 = Dado de 12 lados");
        System.out.println("6. D20 = Dado de 20 lados");
        
        switch (opcao) {
            case 1: 
                numSorteado = gerador.nextInt(5);
                break;
            case 2: 
                numSorteado = gerador.nextInt(7);
                break;
            case 3: 
                numSorteado = gerador.nextInt(9);
                break;
            case 4: 
                numSorteado = gerador.nextInt(11);
                break;
            case 5: 
                numSorteado = gerador.nextInt(13);
                break;
            case 6: 
                numSorteado = gerador.nextInt(21);
                break;
            default:
                numSorteado = gerador.nextInt(5);
                break;
        }
        if(numSorteado == 0) {
            numSorteado += 1;
        }
        System.out.println("O dado deu " + numSorteado);
        return numSorteado;
    }
    
    public static void main(String[] args) {
        int selectedOption;
        boolean gameOn = true;
        
        while (gameOn) {
            System.out.println("##### --- MENU INICIAL --- #####");
            System.out.println(" 1. Instruções");
            System.out.println(" 2. Jogar");
            System.out.println(" 3. Créditos");
            System.out.println(" 4. Sair");
        
            System.out.println("Digite o número da opção desejada: ");
            selectedOption = input.nextInt();
            
            switch(selectedOption) {
                case 1:
                    System.out.println("SELECIONOU >>>>> Instruções");
                    break;
                case 2:
                    System.out.println("SELECIONOU >>>>> Jogar");
                    rolarDado();
                    break;
                case 3:
                    System.out.println("Autores: Rodrigo B. Carvalho");
                    System.out.println("         Kaio Silva de Sena");
                    break;
                case 4: 
                    System.out.println("Você saiu da aplicação. Até mais...");
                    gameOn = false;
                    break;
            }
        }
    }
}
