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
        
            System.out.println("Digite o número da opção desejada para usar o comando");
            selectedOption = input.next().charAt(0);
            
            switch(selectedOption) {
                case '1':
                    System.out.println("Digite o número da opção desejada para usar o comando");
                    break;
                case '2':
                    System.out.println("Jogo em andamento");
                    gameOn = true;
                    return gameOn;
                case '3':
                    System.out.println("Autores: Rodrigo B. Carvalho");
                    System.out.println("         Kaio Silva de Sena");
                    System.out.println("         Enrico Bispo Santos");
                    break;
                case '4': 
                    System.out.println("Você saiu da aplicação. Até mais...");
                    gameOn = false;
                    return gameOn;     
            }
        }
        return  gameOn;
    }
    
    // Função para movimentação do jogador no "mapa".
    static int[] funcaoMovimentacao(int x, int y, int tempo) { 
        char opcao;
        boolean mov = false, gameOn = true;
        int[] retornoMov = new int[4];
        int contGame, penalidadeTempo = 5;
        
        while(mov != true && gameOn != false){
            System.out.println("1. Escolher a direção para ir. ");
            System.out.println("2. Olhar o GPS.");
            System.out.println("3. Olhar o relógio.");
            System.out.println("4. Ouvir Rádio.");
            System.out.println("5. Voltar ao menu.");
            opcao = input.next().charAt(0);
            
            switch(opcao){
                case '1':
                    System.out.println("1. Norte");
                    System.out.println("2. Sul");
                    System.out.println("3. Leste");
                    System.out.println("4. Oeste");
                    char opcao2;
                    opcao2 = input.next().charAt(0);
                        
                    while(opcao2 != '1' && opcao2 != '2' && opcao2 != '3' && opcao2 != '4'){
                        System.out.println("Alternativa inválida, digite novamente:");
                        opcao2 = input.next().charAt(0);
                    }
                        
                    switch(opcao2){
                        case '1':
                            if(y == 1){
                                    System.out.println("Você está no limite.");
                            }else{
                                y = y - 1;
                                mov = true;
                            }   
                            break;
                                
                        case '2':
                            if(y == 10){
                                System.out.println("Você está no limite.");
                            }else{
                                y = y + 1;
                                mov = true;
                            }
                            break;
                                
                        case '3':
                            if(x == 10){
                                System.out.println("Você está no limite.");
                            }else{
                                x = x + 1;
                                mov = true;
                            }
                            break;
                            
                        case '4':
                            if(x == 1){
                                System.out.println("Você está no limite.");
                            }else{
                                x = x - 1;
                                mov = true;
                            }
                            break;
                    }
                    break;
                        
                case '2':
                    funcaoGPS(x,y);
                    break;
                        
                case '3':
                    funcaoRelogio(tempo);
                    break;
                    
                case '4':
                    funcaoRadio(tempo);
                    break;
                    
                case '5':
                    gameOn = mainMenu();
                    break;
                    
                default:
                    System.out.println("Alternativa inválida, digite novamente:");
                    opcao = input.next().charAt(0);   
            }    
        }   
        
        if(gameOn){
            contGame = 1;
        }else{
            contGame = 0;
        }
        
        tempo = tempo + penalidadeTempo;
        retornoMov[0] = x;
        retornoMov[1] = y;
        retornoMov[2] = tempo;
        retornoMov[3] = contGame;
        
        return retornoMov;
    }
        
    // Função onde mostra a quantidade de casas necessarias para o jogador chegar em um determinado ponto
    static void funcaoGPS(int x, int y) { 

        int distX = 0, distY = 0, 
            familiaX = 4, familiaY = 7,
            aeroportoX = 2, aeroportoY = 1,
            portoX = 10, portoY = 9,
            estradaX = 1, estradaY = 9;
        
        System.out.print("Você está na Rua " + x + " com a Rua ");
        switch(y){
            case 1:
                System.out.println("Abacaxi.");
                break;
            case 2:
                System.out.println("Banana.");
                break;
            case 3:
                System.out.println("Caju.");
                break;
            case 4:
                System.out.println("Damasco.");
                break;
            case 5:
                System.out.println("Embaúba.");
                break;
            case 6:
                System.out.println("Framboesa.");
                break;
            case 7:
                System.out.println("Goiaba.");
                break;
            case 8:
                System.out.println("Heisteria.");
                break;
            case 9:
                System.out.println("Imbu.");
                break;
            case 10:
                System.out.println("Jabuticaba.");
                break;
        }
        
        System.out.println("Opções GPS:");
        System.out.println("1. Familía");
        System.out.println("2. Aeroporto");
        System.out.println("3. Porto");
        System.out.println("4. Estrada");
        
        char entrada = input.next().charAt(0);
        boolean controle = false;
        
        while(controle != true) {
            switch(entrada){
                case '1':
                    distX = familiaX - x;
                    distY = familiaY - y;
                    System.out.print("A casa dos pais");
                    controle = true;
                    break;
                case '2':
                    distX = aeroportoX - x;
                    distY = aeroportoY - y;
                    System.out.print("O aeroporto");
                    controle = true;
                    break;
                case '3':
                    distX = portoX - x;
                    distY = portoY - y;
                    System.out.print("O porto");
                    controle = true;
                    break;
                case '4':
                    distX = estradaX - x;
                    distY = estradaY - y;
                    System.out.print("A estrada");
                    controle = true;
                    break;
                default:
                    System.out.println("Alternativa inválida, digite novamente:");
                    entrada = input.next().charAt(0);      
            }
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
    static void funcaoMapa(int x, int y, boolean gameOn) { 
        int  chanceCarro, aleatorioCarro = 1,
        familiaX = 4, familiaY = 7,
        aeroportoX = 2, aeroportoY = 1,
        portoX = 10, portoY = 9,
        estradaX = 1, estradaY = 9;
        
        if(x == familiaX && y == familiaY ){
            System.out.println("Família");
        }else if(x == aeroportoX && y == aeroportoY){
            System.out.println("Aeroporto");
        }else if(x == estradaX && y == estradaY){
            System.out.println("Estrada");
        }else if(x == portoX && y == portoY){
            System.out.println("Porto");
        }
        
        chanceCarro = rolarDado(20);
        if(chanceCarro == 20){
            aleatorioCarro = rolarDado(3);
        
            switch(aleatorioCarro){
                case 1:
                System.out.println("Problema Carro 1");
                break;
                case 2:
                System.out.println("Problema Carro 2");
                break;
                case 3:
                System.out.println("Problema Carro 3");
                break;
            }
        }else
            System.out.println("Carro Não Quebrou");
    }
    
    // Função para ativar falas devido ao tempo.\
    static void funcaoRadio(int tempo) {
        if(tempo >= 0 && tempo < 5 ){
            System.out.println("(Rádio) Autoridades aconselham a evacuação imediata da cidade.");
        }else if(tempo >= 5 && tempo < 10 ){
            System.out.println("(Rádio) Autoridades estão sendo realocadas para lidar com a crise, mais informações serão repassadas em breve.");
        }else if(tempo >= 10 && tempo < 15 ){
            System.out.println("(Rádio) As forças armadas incentivam que a população procure a forma mais rapida de evacuação possível nesse momento.");
        }else if(tempo >= 15 && tempo < 20 ){
            System.out.println("(Rádio) Alerta! Busquem seus familiares e se desloquem para algum dos pontos de fuga imediatamente!");
        }else if(tempo >= 20 && tempo < 25){
            System.out.println("(Rádio) Atenção, autoridades pedem que as ruas que fazem cruzamento com as avenidas A e C sejam evitadas devido um acidente.");
        }else if(tempo >= 25 && tempo < 30){
            System.out.println("(Rádio) Por favor, se desloquem de forma rápida, porem com segurança até os pontos de evacuação.");
        }else if(tempo >= 30 && tempo < 35){
            System.out.println("(Rádio) Engarrafamentos devem ser evitados para a eficiência da evacuação, para isso, as ruas 7 e 5 devem ser evitadas!");     
        }else if(tempo >= 35 && tempo < 40){
            
        }
            
    }
    
    // Função para mostrar o horário no jogo.
    static void funcaoRelogio(int tempo){
        int horario = 600, horarioTotal ,hora, min;
        horarioTotal = horario + tempo;
        
        if(horarioTotal > 59){
            hora = horarioTotal / 60;
            min = horarioTotal % 60;
        }else{
            hora = 0;
            min = horarioTotal;
        }
        
        if(hora >= 10 && min >= 10){
            System.out.println("São " + hora + ":" + min);
        }else if(hora < 10 && min >= 10){
            System.out.println("São 0" + hora +":" + min);
        }else if(hora < 10 && min < 10){
            System.out.println("São 0" + hora + ":0" + min);
        }else if(hora >= 10 && min < 10){
            System.out.println("São " + hora + ":0" +min);
        }
            
    }
    
    // Função para rolar dado com n lados
    public static int rolarDado(int opcao) {
        Random gerador = new Random();
        int numSorteado = gerador.nextInt(opcao) + 1;
        return numSorteado;
    }
    
    // Função Historia Intro
    static void intro() {
        boolean introOn = true;
        int fraseNum = 0;
        char resposta;
        char comando;
        
        System.out.println("\nVocê está voltando da sua hora de almoço no trabalho. "
                + "Senta-se na sua mesa de trabalho e olha hora.");
        
        while(introOn) {
            System.out.println("\n Digite o número da opção desejada para usar o comando");
            System.out.println("1. para usar o comando PRÓXIMO para proseguir a história");
            System.out.println("2. para usar o comando VOLTAR para voltar a história");
            System.out.println("3. para usar o comando AJUDA para ver instruções do jogo");
            System.out.println("4. para usar o comando RELÓGIO para ver as horas");
            comando = input.next().charAt(0);
            switch (comando) {
                case '1':
                    fraseNum++;
                    break;
                case '2':
                    fraseNum--;
                    break;
                case '3':
                    System.out.println("\n Digite o número da opção desejada para usar o comando");
                    System.out.println("1. para usar o comando PRÓXIMO para proseguir a história");
                    System.out.println("2. para usar o comando VOLTAR para voltar a história");
                    System.out.println("3. para usar o comando AJUDA para ver instruções do jogo");
                    System.out.println("4. para usar o comando RELÓGIO para ver as horas");
                    break;
                case '4':
                    funcaoRelogio(0);
                    break;
                case '5':
                    funcaoGPS(8, 4);
                    break;
                default: 
                    System.out.println("Comando inválido");
                    break;
            }
            if (fraseNum <= 0) {
                fraseNum = 1;
            }
            switch (fraseNum) {
                case 1:
                    System.out.println("\nVocê pega o celular, entra numa rede social e vê um "
                    + "\nvídeo com algum membro do alto escalão do governo esbravejando"
                    + "\n ofensas contra um outro país que há tempos tem uma disputa "
                    + "\ncom um país aliado.");
                    break;
                    
                case 2:
                    System.out.println("\nVOCÊ - Meu Deus! Esses caras só sabem falar besteira. "
                    + "\nIsso ainda vai custar caro ao país.");
                    break;
                    
                case 3:
                    System.out.println("\nDescendo mais o feed você começa a ver um, dois, três"
                    + "\n vídeos iguais do que parece ser uma embarcação militar pegando fogo. ");
                    break;
                case 4:
                    System.out.println("\nApesar de ser uma notícia um tanto quanto preocupante,"
                     + "\n você continua rolando a página social abaixo e \"ignorando\" "
                    + "\naquele vídeo, afinal, quase todos os dias há alguma polêmica envolvendo"
                    + "\n política e essa deve ser apenas mais uma.");
                    break;
                case 5:
                    System.out.println("\nAo rolar as informações na tela do celular,"
                            + "\n você percebe que aquela notícia está em todos os"
                            + "\n cantos, em todas as páginas. Todos estão falando"
                            + "\n sobre isso. Assim que você decide voltar ao vídeo"
                            + "\n para assistir com mais atenção:");
                    break;
                case 6:
                    System.out.println("\nVÍDEO - É real! A Marinha acaba de confirmar o"
                            + "\n naufrágio da embarcação F41 - \"Defensora\". "
                            + "\nAinda não se sabe quem foi o autor do ataque, mas"
                            + "\n especula-se que tenha sido uma resposta do país"
                            + "\n ****** em resposta aos constantes ataques difamatórios"
                            + "\n por parte de membros do Governo Federal, e de disputas"
                            + "\n políticas. [Segue o vídeo da embarcação em chamas ].");
                    break;
                case 7:
                    System.out.println("\nNaquele momento de choque em que você "
                            + "\nestá paralisado tentando ainda entender o que estava"
                            + "\n acontecendo, o seu celular toca…");
                    System.out.println("CELULAR TOCANDO - Trimmmm...trimmmm...");
                    break;
                case 8:
                    System.out.println("MÃE - Alô? Filho?? Ai meu Deus! Precisamos sair daqui ");
                    System.out.println("MÃE- Meu Deus! Meu Deus! Eu to tremendo. Precisamos sair daqui! Você viu as notícias?");
                    System.out.println("Digite o número da sua resposta");
                    System.out.println("1. Sim. Ainda estou tentando entender o que está acontecendo.");
                    System.out.println("2. Não. Me conta o que aconteceu?");
                    resposta = input.next().charAt(0);
                        switch (resposta) {
                            case '1':
                                System.out.println("VOCÊ - Sim. Por que você está tão nervosa?.");
                                break;
                            case '2':
                                System.out.println("VOCÊ - Não. Me conta o que aconteceu?");
                                break;
                            default: 
                                System.out.println("Opção inválida. Seleção automática");
                                System.out.println("VOCÊ - Não. Me conta o que aconteceu?");
                        }
                    break;
                case 9:
                    System.out.println("MÃE - COMO ASSIM? Eles vão jogar uma bomba na cidade em 2 horas!! Precisamos sair daqui. Pelo amor de Deus, venha nos buscar!!");
                    System.out.println("Digite o número da sua resposta");
                    System.out.println("1. Do que você está falando?");
                    System.out.println("2. Ta bom! Fiquem prontos! Daqui a pouco chego ai.");
                    resposta = input.next().charAt(0);
                        switch (resposta) {
                            case '1':
                                System.out.println("VOCÊ - Do que você está falando?!");
                                break;
                            case '2':
                                System.out.println("VOCÊ - Ta bom! Fiquem prontos! Daqui a pouco chego ai.");
                                break;
                            default: 
                                System.out.println("Opção inválida. Seleção automática");
                                System.out.println("VOCÊ - Ta bom! Fiquem pronto2s! Daqui a pouco chego ai.");
                        }
                    break;
                case 10:
                    System.out.println("Tu... Tu.... Tu...");
                    System.out.println("VOCÊ - Alô? ALÔ? MÃE?");
                    System.out.println("VOCÊ - Porcaria de celular! Preciso correr para casa");
                    System.out.println("Use o GPS para ver a localização da sua família e vá até ela");
                    introOn = false;
                    break;
                default:
                    System.out.println("Comando inválido");
                    break;
            }
        }
    }
    
    // Porto
    static boolean porto(int tempo) {
        boolean portoOn = true;
        int fraseNum = 0;
        char resposta;
        char comando;
        int tempoGasto = tempo;
        
        System.out.println("VOCÊ - Finalmente chegamos no Porto. Precisamos entrar numa das balsas ou num navio.");
        System.out.println("PAI - Graças a DEUS! Filha ajude sua mãe. Vamos filho, vamos rápido. Precisamos encontrar o Nestor o mais rápido possível.");
        System.out.println("PAI - Minha queridas, fiquem aqui. Não saim daqui em hipótese alguma!");

        while(portoOn) {
            System.out.println("\nDigite o número da opção desejada para usar o comando");
            System.out.println("1. para usar o comando PRÓXIMO para proseguir a história");
            System.out.println("2. para usar o comando VOLTAR para voltar a história");
   
            comando = input.next().charAt(0);
            switch (comando) {
                case '1':
                    fraseNum++;
                    break;
                case '2':
                    fraseNum--;
                    break;
                default: 
                    System.out.println("Comando inválido");
                    break;
            }
            
            switch (fraseNum) {
                case 1:
                    System.out.println("PAI - Nessa loucura provavelmente ele deve estar em uma das docas.");
                    System.out.println("VOCÊ - Não sei se vamos conseguir encontrar uma pessoa nesse pandemônio."
                            + "Isso aqui tá parecendo um formigueiro.");
                    break;
                    
                case 2:
                    boolean barcoDoNestor = false;
                    System.out.println("PAI - Vamos! Procure por um velho grisalho com um chapéu de capitão.");
                    
                    while (!barcoDoNestor) {
                        
                        System.out.println("Digite o número da opção desejada para usar o comando");
                        System.out.println("1. Olhar doca 21");
                        System.out.println("2. Olhar doca 22");
                        System.out.println("3. Olhar doca 23");
                        comando = input.next().charAt(0);
                        
                        switch (comando) {
                            case '1': 
                                System.out.println("\nVocês andam de forma apressada até a doca 21"
                                        + "\nnela é possível ver um grande navio cargueiro abarrotado de pessoas."
                                        + "\nUm capitão tenta organizar a fila e grita para que a as pessoas matenham a calma.");
                                System.out.println("PAI - Aquele não é o Nestor vamos sair daqui. Esse navio não cabe mais ninguém.");
                                System.out.println("\n\n VOCÊ - Vamos olhar outro lugar.");
                                tempoGasto =+ 10;
                                break;
                            case '2':
                                System.out.println("\nAo chegarem na doca 22 vocês avistam um grande navio da marinha. "
                                        + "\nNesse ponto a existem muito policiais e soldados."
                                        + "\nÉ possível ver o cordão de isolamento feito de policiais e escudos."
                                        + "\nAtrás deles, você reconhece alguns políticos e também percebem pessoas muito bem vestidas.");
                                
                                System.out.println("Digite o número da opção desejada para usar o comando");
                                System.out.println("1. Tentar avançar o bloqueio");
                                System.out.println("2. Sair da doca");
                                comando = input.next().charAt(0);
                                if (comando == '1') {
                                    System.out.println("VOCÊ - Ei me deixem passar!! Deixem minha família passar!!");
                                    System.out.println("O policial a sua frente te dá um empurrão com o escudo e arma um golde cassetete. "
                                            + "\nVocê desvia sendo  atingido de leve no ombro direito.");
                                    System.out.println("VOCÊ - Nos deixem passar!! ISSO É CULPA DE VOCÊS!");
                                    System.out.println("PAI - Filho você está bem? Essa corja não vai nos ajudar. Vamos embora");
                                } else {
                                    System.out.println("PAI - Filho vamos embora. Esses vermes não vão nos ajudar. O Nestor não é militar.");
                                    System.out.println("Vocês dois vão em direção a próxima doca escolhida.");
                                }
                                tempoGasto =+ 12;
                                break;
                            case '3':
                                System.out.println("Você e seu pai se deparam com uma embarcação não muito grande. "
                                        + "\nalgumas pessoas parecem tentar negociar uma forma de embarcar com alguns homens que parece trabalhar naquela embarcação."
                                        + "\nAlgumas entram em desespero ao receber uma resposta negativa sobre o embarque e são prontametne enchotadas");
                                System.out.println("PAI - Ali! Achamos! Fique aqui vou falar com ele.");
                                System.out.println("Seu pai abre passagem até um senhor com um chapéu de capitão extremamente velho."
                                        + "\nos dois dão um aperto de mão firme. Seu pai conversa com o capitão."
                                        + "\nA conversa parece ficar um pouco tensa e você se aproxima.");
                                System.out.println("NESTOR - Eu não consigo garantir os lugares por muito tempo. Logo vamos partir");
                                System.out.println("PAI - Tudo bem, tudo bem. Te devo essa. Vamos filhos, precisamos buscar sua mãe e irmã.");
                                System.out.println("VOCÊ - O que aconteceu? Deu certo?");
                                System.out.println("PAI - Sim! Vamos logo. Corre.");
                                barcoDoNestor = true;
                                tempoGasto =+ 15;
                                break;
                            default:
                                break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Vocês voltam correndo para onde deixaram sua mãe e irmã esperando."
                            + "\nO porto está ainda mais cheio e as pessoas parecem mais aflitas. A hora"
                            + "\n do ataque se aproxíma e o desespero parece aumentar no semblante de cada um.");
                    System.out.println("VOCÊ - VAMOS MÃE!! CONSEGUIMOS!! CORRE!");
                    System.out.println("PAI - Peguem suas coisas, vamos rápido.");
                    System.out.println("MÃE - Amém!! Corre!");
                    System.out.println("Vocês vão apressados na direção da doca onde está o barco do Nestor."
                            + "\nAlgumas pessoas esbarram em vocês e vice versa mas vocês seguem em frente");
                    
                    if (tempoGasto <= 150) {
                        System.out.println("\n\n Chegando na doca, Nestor abre caminho para vocês. A embarcação "
                            + "está apinhada de gente. Algumas, como vocês, carregam alguns poucos pertences.");
                        System.out.println("A tripulação embarca e o navio começa a zarpar. Alguns pessoas "
                                + "\ndesesperadas tentam embarcar se pendurando. Nem todas conseguem se segurar");
                        System.out.println("Olhando para o porto ainda é possível ver muitas pessoas e outras"
                                + "\nembarcações saindo.");
                        System.out.println("...");
                        
                        System.out.println("Alguns minutos depois, a uma boa distancia do porto, vocês escutam"
                                + "\nbarulhos de caças. Olhando pra cima é possivel ver um rastro branco."
                                + "\nPouco tempo depois uma onda de choque seguida de um barulho terrível"
                                + "\nalcança vocês. Ao longe é possível ver uma enorme coluna de fumaça subir.");
                        System.out.println("                               ________________\n" +
"                          ____/ (  (    )   )  \\___\n" +
"                         /( (  (  )   _    ))  )   )\\\n" +
"                       ((     (   )(    )  )   (   )  )\n" +
"                     ((/  ( _(   )   (   _) ) (  () )  )\n" +
"                    ( (  ( (_)   ((    (   )  .((_ ) .  )_\n" +
"                   ( (  )    (      (  )    )   ) . ) (   )\n" +
"                  (  (   (  (   ) (  _  ( _) ).  ) . ) ) ( )\n" +
"                  ( (  (   ) (  )   (  ))     ) _)(   )  )  )\n" +
"                 ( (  ( \\ ) (    (_  ( ) ( )  )   ) )  )) ( )\n" +
"                  (  (   (  (   (_ ( ) ( _    )  ) (  )  )   )\n" +
"                 ( (  ( (  (  )     (_  )  ) )  _)   ) _( ( )\n" +
"                  ((  (   )(    (     _    )   _) _(_ (  (_ )\n" +
"                   (_((__(_(__(( ( ( |  ) ) ) )_))__))_)___)\n" +
"                   ((__)        \\\\||lll|l||///          \\_))\n" +
"                            (   /(/ (  )  ) )\\   )\n" +
"                          (    ( ( ( | | ) ) )\\   )\n" +
"                           (   /(| / ( )) ) ) )) )\n" +
"                         (     ( ((((_(|)_)))))     )\n" +
"                          (      ||\\(|(|)|/||     )\n" +
"                        (        |(||(||)||||        )\n" +
"                          (     //|/l|||)|\\\\ \\     )\n" +
"                        (/ / //  /|//||||\\\\  \\ \\  \\ _)\n" +
"-------------------------------------------------------------------------------");
                        System.out.println("Parabéns, você e sua família escaparam.");
                        System.out.println("Mas esse foi o começo do fim!");
                    } else {
                        System.out.println("Enquanto vocês vão apressado em direção a doca 23. Vocês "
                                + "\nescutam o barulho do que parece ser vários caças militares.");
                        System.out.println("Alguns segundos depois, um clarão avança na direção do porto.");
                        System.out.println("                               ________________\n" +
"                          ____/ (  (    )   )  \\___\n" +
"                         /( (  (  )   _    ))  )   )\\\n" +
"                       ((     (   )(    )  )   (   )  )\n" +
"                     ((/  ( _(   )   (   _) ) (  () )  )\n" +
"                    ( (  ( (_)   ((    (   )  .((_ ) .  )_\n" +
"                   ( (  )    (      (  )    )   ) . ) (   )\n" +
"                  (  (   (  (   ) (  _  ( _) ).  ) . ) ) ( )\n" +
"                  ( (  (   ) (  )   (  ))     ) _)(   )  )  )\n" +
"                 ( (  ( \\ ) (    (_  ( ) ( )  )   ) )  )) ( )\n" +
"                  (  (   (  (   (_ ( ) ( _    )  ) (  )  )   )\n" +
"                 ( (  ( (  (  )     (_  )  ) )  _)   ) _( ( )\n" +
"                  ((  (   )(    (     _    )   _) _(_ (  (_ )\n" +
"                   (_((__(_(__(( ( ( |  ) ) ) )_))__))_)___)\n" +
"                   ((__)        \\\\||lll|l||///          \\_))\n" +
"                            (   /(/ (  )  ) )\\   )\n" +
"                          (    ( ( ( | | ) ) )\\   )\n" +
"                           (   /(| / ( )) ) ) )) )\n" +
"                         (     ( ((((_(|)_)))))     )\n" +
"                          (      ||\\(|(|)|/||     )\n" +
"                        (        |(||(||)||||        )\n" +
"                          (     //|/l|||)|\\\\ \\     )\n" +
"                        (/ / //  /|//||||\\\\  \\ \\  \\ _)\n" +
"-------------------------------------------------------------------------------");
                        System.out.println("Você e sua família não conseguiram escapar a tempo.");
                        System.out.println("O fim do mundo acabou de começar.");
                    }
                    
                }          
            } 
        return portoOn = false;
    } 
        
        
    // Main
    public static void main(String[] args) {
        boolean gameOn = mainMenu();

        // Movimentação
        int[] mov;
        int x = 8, y = 4, tempo = 0;
        
        if(gameOn) {
            intro();
        }

        while(gameOn != false){ // while somente para repetição.
            mov = funcaoMovimentacao(x,y,tempo);
            
            x = mov[0];
            y = mov[1];
            tempo = mov[2];
            
            if(mov[3] == 0){
                gameOn = false;
            }else if (mov[3] == 1)
                gameOn = true;
            
            if(gameOn)
                funcaoMapa(x,y, gameOn);
        }
    }

}
