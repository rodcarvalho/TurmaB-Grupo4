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
    
    //Carro 1,2,3
       public static int carroQuebrado1(int tempo) {
        try (Scanner entrada = new Scanner(System.in)) {
            String escolhaStr;
            System.out.println("CLANK, CLACK, CLACK, CLACK, PUUUUuuuuuffff \n O Carro deu Algum Problema! \n Você desce do carro corendo para ver qual o problema \n Oh não é a Correira que saiu fora do lugar!!! \n Decida qual das 9 caixas caixa contem os itens Necessários para Consertar seu carro! \n ");

            char esco;
            do {
                esco = entrada.next().charAt(0);

                switch (esco) {
                    case '1':
                        System.out.println("Martelo! \n Morno!!");
                        break;
                    case '2':
                        System.out.println("Chave de Fenda \n Quente!");
                        break;
                    case '3':
                        System.out.println("Pedra Rachada  \n Pegando Fogo!");
                        break;
                    case '4':
                        System.out.println("Correia Nova e Manual \n Sabia que estava por aqui! ");
                        break;
                    case '5':
                        System.out.println("Chave de Boca \n Pegando Fogo!");
                        break;
                    case '6':
                        System.out.println("Massarico \n Quente!");
                        break;
                    case '7':
                        System.out.println("Brinquedo da sua Irmãzinha \n Morno!!");
                        break;
                    case '8':
                        System.out.println("Furadeira! \n Frio!!");
                        break;
                    case '9':
                        System.out.println("Pé de Cabra \n Frio!!");
                        break;

                    default:
                        System.out.println("Puts essa Ferramenta não está por aqui!");
                        tempo = tempo - 2;
                        break;
                }
                tempo = tempo + 2;
            } while (esco != 4);
        }
        return tempo;
    }
    //2
           public static int carroQuebrado2(int tempo) {
        try (Scanner entrada = new Scanner(System.in)) {
            String escolha2Str;
            System.out.println("CLANK, CLACK, CLACK, CLACK, PUUUUuuuuuffff \n O Carro deu Algum Problema! \n Você desce do carro correndo para ver qual o problema \n     Droga! você não sabe qual o Problema se ao menos seu pai estivesse aqui ele poderia te ajudar!! \n  Procure e veja qual o Problema do carro, dentre os 9 lugares que você acha que pode estar da direita até a esqueda do carro!!! ");

            char esco;
            do {
                
                esco = entrada.next().charAt(0);
                switch (esco) {
                    case 1:
                        System.out.println("Sem os Pistões!!  \n Para Direita!!");
                        break;
                    case 2:
                        System.out.println("Problemas na Bateria?? \n Para Direita!!");

                        break;
                    case 3:
                        System.out.println("Ventuinha parada \n É ISSO!");
                        break;
                    case 4:
                        System.out.println("Sem escapamento! \n Para Esquerda!! ");
                        break;
                    case 5:
                        System.out.println("Chave presa no capo! \n Para Esquerda!!");
                        break;
                    case 6:
                        System.out.println("Ventuianha quebrada \n Para Esquerda!!");
                        break;
                    case 7:
                        System.out.println("Falta de Agua no Sistema! \n Para Esquerda!!");
                        break;
                    case 8:
                        System.out.println("Pedra no Motor!! \n Para Esquerda!!");
                        break;
                    case 9:
                        System.out.println("Pneu \n Para Esquerda!!");
                        break;
                    
                    default:
                        System.out.println("Essa não é uma opção de Problema!");
                        tempo = tempo - 2;
                        break;
                }
                tempo = tempo + 2;
    
            }while (esco != 3);
            

        }return tempo;
    }
    //3
               public static int carroQuebrado3(int tempo) {
        try (Scanner entrada = new Scanner(System.in)) {
            String escolha3Str;
            System.out.println("CLANK, CLACK, CLACK, CLACK, PUUUUuuuuuffff \n O Carro deu Algum Problema! \n Você desce do carro correndo para ver qual o problema \n     Algo ficou preso na Roda!! \n  Descubra oque é dentre as 9 Possibilidades! ");
            char esco;
            do {
                esco = entrada.next().charAt(0);

                switch (esco) {
                    case 1:
                        System.out.println("Pedra  \n Gelado!!");
                        break;
                    case 2:
                        System.out.println("Gelo? \n Frio!!");

                        break;
                    case 3:
                        System.out.println("Pedaço de Ferro \n Frio!!");
                        break;
                    case 4:
                        System.out.println("Uma sacola? \n Quente!! ");
                        break;
                    case 5:
                        System.out.println("Faca \n Pegando Fogo!!");
                        break;
                    case 6:
                        System.out.println("Brinquedo de Criança \n Meu deus! Que bom que eu achei, tadinha da criança que perdeu");
                        break;
                    case 7:
                        System.out.println("Madeira quebrada \n Pegando Fogo!!");
                        break;
                    case 8:
                        System.out.println("Escapamento quebrado de outros carros?! \n Quente");
                        break;
                    case 9:
                        System.out.println("Borracha  \n Frio!!");
                        break;

                    default:
                        System.out.println("Isso com certeza não está no Pneu!");
                        tempo = tempo - 2;
                        break;
                }
                tempo = tempo + 2;
            } while (esco != 6);

        }
        return tempo;
    }
    
    //Carro Familia
                    public static int carroQuebradoFamilia1(int tempo) {
        try (Scanner entrada = new Scanner(System.in)) {
            String escolhaStr;
            System.out.println("CLANK, CLACK, CLACK, CLACK, PUUUUuuuuuffff \n O Carro deu Algum Problema! \n Você e seu Pai descem do carro correndo para ver qual o problema \n Oh não é a Correira que saiu fora do lugar!!! \n Decida qual das 9 caixas caixa contem os itens Necessários para Consertar seu carro! \n Mas espere, 4 delas pertemcem a Sua mãe, isso deixa o Trabalho bem mais facil!! \n Decida entre as 5 caixas restantes ");

            char esco;
            do {
                esco = entrada.next().charAt(0);

                switch (esco) {
                    case '1':
                        System.out.println("Martelo! \n Morno!!");
                        break;
                    case '2':
                        System.out.println("Chave de Fenda \n Quente!");
                        break;
                    case '3':
                        System.out.println("Pedra Rachada  \n Pegando Fogo!");
                        break;
                    case '4':
                        System.out.println("Correia Nova e Manual \n Sabia que estava por aqui! ");
                        break;
                    case '5':
                        System.out.println("Chave de Boca \n Pegando Fogo!");
                        break;
 
                    default:
                        System.out.println("Puts essa Ferramenta não está por aqui!");
                        tempo = tempo - 2;
                        break;
                }
                tempo = tempo + 2;
            } while (esco != 4);
        }
        return tempo;
    }
    // 2
                        public static int carroQuebradoFamilia2(int tempo) {
        try (Scanner entrada = new Scanner(System.in)) {
            String escolha2Str;
            System.out.println("CLANK, CLACK, CLACK, CLACK, PUUUUuuuuuffff \n O Carro deu Algum Problema! \n Você desce do carro correndo para ver qual o problema \n     Droga! você não sabe qual o Problema !! \n  Procure e veja qual o Problema do carro, dentre os 9 lugares que você acha que pode estar da direita a esqueda do carro!!! \n Espere! seu api tem certeza de que não existem alguns dos problemas que você estava procurando, Isso diminui sua contagem para apenas 5 problemas!! \n Procure dentre os 5 problemas! ");

            char esco;
            do {

                esco = entrada.next().charAt(0);
                switch (esco) {
                    case 1:
                        System.out.println("Sem os Pistões!!  \n Para Direita!!");
                        break;
                    case 2:
                        System.out.println("Problemas na Bateria?? \n Para Direita!!");

                        break;
                    case 3:
                        System.out.println("Ventuinha parada \n É ISSO!");
                        break;
                    case 4:
                        System.out.println("Sem escapamento! \n Para Esquerda!! ");
                        break;
                    case 5:
                        System.out.println("Chave presa no capo! \n Para Esquerda!!");
                        break;

                    default:
                        System.out.println("Essa não é uma opção de Problema!");
                        tempo = tempo - 2;
                        break;
                }
                tempo = tempo + 2;

            } while (esco != 3);

        }
        return tempo;
    }
    // 3
                            public static int carroQuebradoFamilia3(int tempo) {
        try (Scanner entrada = new Scanner(System.in)) {
            String escolha3Str;
            System.out.println("CLANK, CLACK, CLACK, CLACK, PUUUUuuuuuffff \n O Carro deu Algum Problema! \n Você desce do carro correndo para ver qual o problema \n     Algo ficou preso na Roda!! \n  Descubra oque é dentre as 9 Possibilidades! \n ESPERE sua Irmãzinha disse que viu o tamanho do Objeto, isso Diminui o seu leque de possibilidade para apenas 6! \n Faça a Escolha dentre os 6 objetos que podem estar presos na Roda do Carro! ");
            char esco;
            do {
                esco = entrada.next().charAt(0);

                switch (esco) {
                    case 1:
                        System.out.println("Pedra  \n Gelado!!");
                        break;
                    case 2:
                        System.out.println("Gelo? \n Frio Literalmente!!");

                        break;
                    case 3:
                        System.out.println("Pedaço de Ferro \n Frio!!");
                        break;
                    case 4:
                        System.out.println("Uma sacola? \n Quente!! ");
                        break;
                    case 5:
                        System.out.println("Faca \n Pegando Fogo!!");
                        break;
                    case 6:
                        System.out.println(" Boneca!! \n Só podia ser né!! Bem que ela reconheceu!");
                    default:
                        System.out.println("Isso com certeza não está no Pneu!");
                        tempo = tempo - 2;
                        break;
                }
                tempo = tempo + 2;
            } while (esco != 6);

        }
        return tempo;
    }
    //Avião
             public static int saidaAvião(int tempo) {
        try (Scanner entrada = new Scanner(System.in)) {
            String escolha2Str;
            System.out.println("Você e Sua familia chegam ao Aeroporto   \n Todos respiram fundo se achando a salvo, porem você percebe que sua mãe parece estranhamente preocupada!"
                    + " \n onde está a Aeromoça que era a amiga de sua mae que ajudaria eles a entrar no Avião com prioridade??! \n \n Ache a Aeromoça dentro da Aerea em que vocês estão que consistem em 5 salas diferentes!  ");

            char esco;
            do {

                esco = entrada.next().charAt(0);
                switch (esco){
                    case 1:
                        System.out.println("Sala Principal!  \n Para Cima!!");
                        break;
                    case 2:
                        System.out.println("Banheiros! \n Para Cima!");

                        break;
                    case 3:
                        System.out.println("Sala de Entrada! \n É ISSO!");
                        break;
                    case 4:
                        System.out.println("Sala de Embarque Idoso! \n Para Baixo! ");
                        break;
                    case 5:
                        System.out.println("Sala de Espera!  \n Para Baixo!");
                        break;

                    default:
                        System.out.println("Essa não é uma opção de Problema!");
                        tempo = tempo - 2;
                        break;
                }
                tempo = tempo + 2;

            } while (esco != 3);

        }
        return tempo;
    }

    // Main
    public static void main(String[] args) {
        int selectedOption;
        boolean gameOn = true;
        int numSorteado = rolarDado(6);
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
                    System.out.println("         Enrico Bispo Santos");
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
