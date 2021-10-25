/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi1.antesdofim;

import java.util.Scanner;

/**
 *
 * @author rodrigocarvalho
 */
public class MainAntesDoFim {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
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
                    break;
                case 3:
                    System.out.println("Autor: Rodrigo B. Carvalho");
                    break;
                case 4: 
                    System.out.println("Você saiu da aplicação. Até mais...");
                    gameOn = false;
                    break;
            }
        }
    }
}
