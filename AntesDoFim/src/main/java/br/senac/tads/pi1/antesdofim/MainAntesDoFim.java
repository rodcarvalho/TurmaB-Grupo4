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
 * @author Kaio
 */
public class MainAntesDoFim {   
     
    // Variáveis Globais
    static Scanner input = new Scanner(System.in);
    
    // Função para movimentação do jogador no "mapa".
    static int[] funcaoMovimentacao(int x, int y, int tempo) { 
 
        char direcao;
        boolean mov = false;
        int[] retornoMov = new int[3];
        int penalidadeTempo = 5;
        
        while(mov != true){
            System.out.println("1. Escolha a direção quer ir: ");
            System.out.println("     Norte");
            System.out.println("     Sul");
            System.out.println("     Leste");
            System.out.println("     Oeste");
            System.out.println("2. GPS");
            System.out.println("3. Relógio");
            direcao = input.next().charAt(0);
        
            while(direcao != 'N' && direcao != 'S' && direcao != 'L' && direcao != 'O' && direcao!='G' && direcao!= 'R'){
                System.out.println("Alternativa incorreta, digite novamente:");
                direcao = input.next().charAt(0);
            }
        
            switch(direcao){
                case 'N':
                    y = y - 1;
                    tempo = tempo + penalidadeTempo;
                    mov = true;
                    break;
                case 'S':
                    y = y + 1;
                    tempo = tempo + penalidadeTempo;
                    mov = true;
                    break;
                case 'L':
                    x = x + 1;
                    tempo = tempo + penalidadeTempo;
                    mov = true;
                    break;
                case 'O':
                    x = x - 1;
                    tempo = tempo + penalidadeTempo;
                    mov = true;
                    break;
                case 'G':
                    funcaoGPS(x,y);
                    break;
                case 'R':
                    System.out.println("Relógio");
                    break;
            }      
        }  
        
        retornoMov[0] = x;
        retornoMov[1] = y;
        retornoMov[2] = tempo;
        return retornoMov;
    }
    
    // Função onde mostra a quantidade de casas necessarias para o jogador chegar em um determinado ponto
    static void funcaoGPS(int x, int y) { 
        
        int distX = 0, distY = 0, 
            familiaX = 5, familiaY = 16,
            aeroportoX = 3, aeroportoY = 1,
            portoX = 20, portoY = 17,
            estradaX = 18, estradaY = 1;
        
        System.out.println("Opções GPS:");
        System.out.println("   Familía");
        System.out.println("   Aeroporto");
        System.out.println("   Porto");
        System.out.println("   Estrada");
        
        char entrada = input.next().charAt(0);
        
        while(entrada != 'F' && entrada != 'A' && entrada != 'P' && entrada != 'E'){
            System.out.println("Alternativa inválida, digite novamente:");
            entrada = input.next().charAt(0);        
        }
        
        switch(entrada){
            case 'F':
                distX = familiaX - x;
                distY = familiaY - y;
                System.out.print("A casa dos pais");
                break;
            case 'A':
                distX = aeroportoX - x;
                distY = aeroportoY - y;
                System.out.print("O aeroporto"); 
                break;
            case 'P':
                distX = portoX - x;
                distY = portoY - y;
                System.out.print("O porto");
                break;
            case 'E':
                distX = estradaX - x;
                distY = estradaY - y;
                System.out.print("A estrada");
                break;
        }
        
        if(distY > 0){
            System.out.print(" está em " + distY + "Km para o sul");
        }else if (distY < 0){
            System.out.print(" está em " + (-distY) + "Km para o norte");
        }else if (distY == 0){
            System.out.print(" está em ");  
        }
        
        if(distX != 0 && distY != 0)
            System.out.print(" e ");
        
        if(distX < 0){
            System.out.println( (-distX) + "Km para o oeste.");
        }else if (distX > 0){
            System.out.println( distY + "Km para o leste");
        }else if (distX == 0){
            System.out.println(".");
        }               
    }
    
    // Função para ativar funções ou falas de acordo com a posição do jogador no mapa.
    static void funcaoMapa(int x, int y) { 
        
        if(x == 5 && y == 16 ){
            System.out.println("Família");
            rolarDado(5);
        }else if(x == 3 && y == 1){
            System.out.println("Aeroporto");
        }else if(x == 18 && y == 1){
            System.out.println("Estrada");
        }else if(x == 20 && y == 17){
            System.out.println("Porto");
        }
  
    }
    
    static void funcaoRadio(int tempo) {
        switch(tempo){
            case 0:
                System.out.println("Rádio: Autoridades aconselham a evacuação imediata da cidade.");
                break;
            case 5:
                System.out.println("");
                break;
            case 10:
                System.out.println("");
                break;
            case 15:
                System.out.println("");
                break;
            case 20:
                System.out.println("");
                break;
            case 25:
                System.out.println("");
                break;
            case 30:
                System.out.println("");
                break;
            case 40:
                System.out.println("");
                break;
        }
            
    }
    
    // Função para rolar dado com n lados
    public static int rolarDado(int opcao) {
        Random gerador = new Random();
        int numSorteado = -1;
        /*
        System.out.println("Escolha qual dado você quer rolar.");
        System.out.println("Caso o valor seja inválido, será rolado o dado de menor valor!");
        System.out.println("1. D4 = Dado de 4 lados");
        System.out.println("2. D6 = Dado de 6 lados");
        System.out.println("3. D8 = Dado de 8 lados");
        System.out.println("4. D10 = Dado de 10 lados");
        System.out.println("5. D12 = Dado de 12 lados");
        System.out.println("6. D20 = Dado de 20 lados");
        */
        
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
    
    // Main
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
        
        //Movimentação
        int[] mov;
        int x = 10, y = 10, tempo = 0;
        boolean finish = false;
        
        while(finish != true){ //while somente para repetição.
            mov = funcaoMovimentacao(x,y,tempo);
            
            x = mov[0];
            y = mov[1];
            tempo = mov[2];
            
            funcaoMapa(x,y);
        }
    }
}
