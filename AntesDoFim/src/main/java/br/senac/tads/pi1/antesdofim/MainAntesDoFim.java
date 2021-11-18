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
 * @author Enrico
 */
public class MainAntesDoFim {   
     
    // Variáveis Globais
    static Scanner input = new Scanner(System.in);
    
    // Main Menu
    static boolean mainMenu() {
        char selectedOption;
        boolean gameOn = true;
        
        while (gameOn) {
            System.out.println("##### --- MENU INICIAL --- #####");
            System.out.println(" 1. Instruções");
            System.out.println(" 2. Jogar");
            System.out.println(" 3. Créditos");
            System.out.println(" 4. Sair");
        
            System.out.println("Digite o número da opção desejada: ");
            selectedOption = input.next().charAt(0);
            
            switch(selectedOption) {
                case '1':
                    System.out.println("SELECIONOU >>>>> Instruções");
                    break;
                case '2':
                    System.out.println("SELECIONOU >>>>> Jogar");
                    return gameOn = true;
                case '3':
                    System.out.println("Autores: Rodrigo B. Carvalho");
                    System.out.println("         Kaio Silva de Sena");
                    System.out.println("         Enrico Bispo Santos");
                    break;
                case '4': 
                    System.out.println("Você saiu da aplicação. Até mais...");
                    return gameOn = false;
            }
        }
        return gameOn;
    }
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
    
    // Função Historia Intro
    static void intro() {
        boolean introOn = true;
        int fraseNum = 0;
        char comando = 'a';
        
        System.out.println("Digite \"próximo\" para proseguir a história");
        System.out.println("Digite \"voltar\" para voltar a história");
        System.out.println("Digite \"ajuda\" ver comandos");
        
        System.out.println("\n \n Você está voltando da sua hora de almoço no trabalho. "
                + "Senta-se na sua mesa de trabalho e olha hora.");
        
        // Instruções para chamar a função relógio
        
        System.out.println("- Ainda tenho alguns minutos antes de voltar ao trabalho. Vou ver alguns memes no celular.");
        
        while(introOn) {
            comando = input.next().charAt(0);
            switch (comando) {
                case 'p':
                    fraseNum++;
                    break;
                case 'v':
                    fraseNum--;
                    break;
                case 'a':
                    System.out.println("Digite \"próximo\" para proseguir a história");
                    System.out.println("Digite \"voltar\" para voltar a história");
                    System.out.println("Digite \"ajuda\" ver comandos");
                    break;
            }
            
            switch (fraseNum) {
                case 1:
                    System.out.println("Você pega o celular, entra numa rede social e vê um "
                    + "vídeo com algum membro do alto escalão do governo esbravejando"
                    + " ofensas contra um outro país que há tempos tem uma disputa "
                    + "com um país aliado.");
                    break;
                    
                case 2:
                    System.out.println("- Meu Deus! Esses caras só sabem falar besteira. "
                    + "Isso ainda vai custar caro ao país.");
                    break;
                    
                case 3:
                    System.out.println("Descendo mais o feed você começa a ver um, dois, três"
                    + " vídeos iguais do que parece ser uma embarcação militar pegando fogo. ");
                    break;
                case 4:
                    System.out.println("Apesar de ser uma notícia um tanto quanto preocupante,"
                     + " você continua rolando a página social abaixo e \"ignorando\" "
                    + "aquele vídeo, afinal, quase todos os dias há alguma polêmica envolvendo"
                    + " política e essa deve ser apenas mais uma.");
                    introOn = false;
                    break;
            }
        }
    }
    // Main
    public static void main(String[] args) {
        
        mainMenu();
        intro();
        
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
