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
 * @author Kaio
 */
public class MainAntesDoFim {   
            
    static int[] funcaoMovimentacao(int x, int y, int tempo){ //Função para movimentação do jogador no "mapa".
        Scanner input = new Scanner(System.in);
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
    
    
    static void funcaoGPS(int x, int y){ //função onde mostra a quantidade de casas necessarias para o jogador chegar em um determinado ponto
        Scanner input = new Scanner(System.in);
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
    
    
    static void funcaoMapa(int x, int y){ //função para ativar funções ou falas de acordo com a posição do jogador no mapa.
        
        if(x == 5 && y == 16 ){
            System.out.println("Família");
        }else if(x == 3 && y == 1){
            System.out.println("Aeroporto");
        }else if(x == 18 && y == 1){
            System.out.println("Estrada");
        }else if(x == 20 && y == 17){
            System.out.println("Porto");
        }
    
    }
   
    
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
