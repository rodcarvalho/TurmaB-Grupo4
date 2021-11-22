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

        while (mov != true) {
            System.out.println("1. Escolha a direção quer ir: ");
            System.out.println("     Norte");
            System.out.println("     Sul");
            System.out.println("     Leste");
            System.out.println("     Oeste");
            System.out.println("2. GPS");
            System.out.println("3. Relógio");
            direcao = input.next().charAt(0);

            while (direcao != 'N' && direcao != 'S' && direcao != 'L' && direcao != 'O' && direcao != 'G' && direcao != 'R') {
                System.out.println("Alternativa incorreta, digite novamente:");
                direcao = input.next().charAt(0);
            }

            switch (direcao) {
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
                    funcaoGPS(x, y);
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

        while (entrada != 'F' && entrada != 'A' && entrada != 'P' && entrada != 'E') {
            System.out.println("Alternativa inválida, digite novamente:");
            entrada = input.next().charAt(0);
        }

        switch (entrada) {
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

        if (distY > 0) {
            System.out.print(" está em " + distY + "Km para o sul");
        } else if (distY < 0) {
            System.out.print(" está em " + (-distY) + "Km para o norte");
        } else if (distY == 0) {
            System.out.print(" está em ");
        }

        if (distX != 0 && distY != 0) {
            System.out.print(" e ");
        }

        if (distX < 0) {
            System.out.println((-distX) + "Km para o oeste.");
        } else if (distX > 0) {
            System.out.println(distY + "Km para o leste");
        } else if (distX == 0) {
            System.out.println(".");
        }
    }

    // Função para ativar funções ou falas de acordo com a posição do jogador no mapa.
    static void funcaoMapa(int x, int y) {

        if (x == 5 && y == 16) {
            System.out.println("Família");
            rolarDado(5);
        } else if (x == 3 && y == 1) {
            System.out.println("Aeroporto");
        } else if (x == 18 && y == 1) {
            System.out.println("Estrada");
        } else if (x == 20 && y == 17) {
            System.out.println("Porto");
        }

    }

    static void funcaoRadio(int tempo) {
        switch (tempo) {
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
        if (numSorteado == 0) {
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

            } while (esco != 3);

        }
        return tempo;
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
            System.out.println("Você e Sua familia chegam ao Aeroporto \n Todos respiram fundo se achando a salvo, porem você percebe que sua mãe parece estranhamente preocupada! \n Você toca nas costas dela e percebe que ela está tremendo!"
                    + "\n 1. Está tudo bem com a Senhora?"
                    + "\n 2. Qual o problema, a Senhora parece um pouco preoupada? "
                    + "\n 3. Tudo bem com você mãe? é Algo que eu deva me preocupar?");

            char escoMae;

            escoMae = entrada.next().charAt(0);
            switch (escoMae) {
                case '1':
                    System.out.println("\n Está tudo bem com a Senhora?");
                    break;
                case '2':
                    System.out.println("\n Qual o problema, a Senhora parece um pouco preoupada?");
                    break;

                case '3':
                    System.out.println("\n Tudo bem com você mãe? é Algo que eu deva me preocupar?");
                    break;
                default:
                    System.out.println("Isso não é algo que você possa dizer para sua mãe! \n Escolha Opção Valida!");
                    escoMae = entrada.next().charAt(0);

            }

            System.out.println(" \n Mãe : Filho, não estou achando a Patricia! era ela que trabalhava aqui e nos ajudaria a entrar no avião!"
                    + "\n Você Procura a tal de Patricia ,Porem no meio daquele mar de gente é como achar uma Agulha em um palheiro \n Você pergunta para alguns funcionarios que falam que Patricia está em alguma das 5 salas do seu corredor!"
                    + "\n Procure e Ache Patricia e Cuidado com o tempo! ");

            char esco;
            do {

                esco = entrada.next().charAt(0);
                switch (esco) {
                    case '1':
                        System.out.println("Sala Principal! \n Você encontra um segurança que te diz que ela passou ali já faz muito tempo!");
                        break;
                    case '2':
                        System.out.println("Sala de Revista! \n Policial: Ela Accabou de Sair daqui não deve estar Longe!");

                        break;
                    case '3':
                        System.out.println("Sala de Entrada! \n É ISSO! você uma Senhora por volta de seus 70 anos parecendo diciplinar alguns adolescentes que estavam vestidos com a roupa de funcionarios do aeroporto! \n Você vai até ela e espera ela dispensar os garotos, ela percebe você e os dispensa rapidamente mas não sem antes soltar alguns 'INCOMPETENTES' \n ela respira fundo e vira com um sorriso no rosto \n Patricia : ó então era você, que bom que vocês chegaram venham, venham, vou colocar vocês no proximo Avião imediatamente!");
                        break;
                    case '4':
                        System.out.println("Sala de Embarque! \n Ela ainda não passou por aqui! se não me engano ela estava atras de alguns funcionarios dela! ");
                        break;
                    case '5':
                        System.out.println("Sala de Espera Idosa! \n Você entra na sala e Encontra uma Velhinha que parece conhece-la, porem quando você pergunta é quase coberto de coronhadas coma bengala \n e berros do tipo 'essa Velha maluca não vem aqui nunca' é, você não sabe bem quem é a maluca da Historia!");
                        break;

                    default:
                        System.out.println("Essa não é uma opção de sala!!");
                        tempo = tempo - 2;
                        break;
                }
                tempo = tempo + 2;

            } while (esco != '3');
            System.out.println("Chegando com Patricia na Hora de Embarcar, ela te da as instruções seguidas pelas suas passagens e de sua familia"
                    + "\n Patricia: Boa Viagem e vão com segurança! mande um beijo para sua mãe!!"
                    + "\n você percebe que ela parece meio melancolica e com lagrimas nos olhos, e no fim decide perguntar "
                    + "\n 1. Porque Você já não vem junto?"
                    + "\n 2. E você e sua Familião vão quando?"
                    + "\n 3. Você pretende sair quando?");
            char escoPat;
            escoPat = entrada.next().charAt(0);
            switch (escoPat) {
                case '1':
                    System.out.println("\n Porque Você já não vem junto?");
                    break;
                case '2':
                    System.out.println("\n E você e sua Familião vão quando?");
                    break;
                case '3':
                    System.out.println("\n Você pretende sair quando?");
                default:
                    System.out.println("\n Isso não é uma Pergunta para Patricia, faça uma Pergunta Valida!");
                    escoPat = entrada.next().charAt(0);
            }
            System.out.println(" \n Ela fica quieta alguns segunda e respira fundo colocando um sorriso no rosto \n "
                    + "Patricia: Eu ja Estou velha, o mundo é dos jovens! \n Ela se vira rapidamente e se embrenha na Multidão Sumindo e você rapidamente volta para onde seus pais estão! ");
            
            System.out.println("Você se Junta com seus pais e sua irmã, finalmente indo em direção ao avião , é até um pouco estranho embarcar sem malas \n 1. Embarcar no avião.");
            char embarq;
            embarq = entrada.next().charAt(0);
            switch(embarq){
                case '1':
                    System.out.println("\n Embarcando no avião!");
                    break;
                default:
                    System.out.println("Opção Invalida!");
                    embarq = entrada.next().charAt(0);
            }

            System.out.println("\n \n \n \n Você e seus pais conseguem finalmente entrar no avião! e você finalmente se sente Aliviado"
                    + "\n Mas no fim algo ainda te incomoda e você fala com sua mãe sobre patricia"
                    + "\n 1. Porque ela parecia tão triste? "
                    + "\n 2. Mãe, Porque ela ficou?");
            char escoRespMae;
            escoRespMae = entrada.next().charAt(0);
            switch (escoRespMae) {
                case '1':
                    System.out.println("\n Porque ela parecia tão triste? ");
                    break;
                case '2':
                    System.out.println("\n Mãe, Porque ela ficou?");
                default:
                    System.out.println("Opção Invalida!");
                    escoRespMae = entrada.next().charAt(0);
            }
            System.out.println("Sua mãe sorriso um pouco triste \n Mãe : O marido e o Filho de patricia estão internados na cidade, eles sofreram um grave acidente de carro mês passado e os dois estão em coma \n"
                    + "\n Duvido muito que consigam sair... sua mãe se escora no seu pai e parece dormir e você fica um pouco chocado mas no fim balança a cabeça em negação e luto \n Finalmente o avião levanta voo e depois de alguns segundos de voo no horrizonte você vê uma frota de navios saindo tambêm para o porto mais proximo \n Agora aliviado você finalmente consegue relaxar e dormir e rezar por aqueles que ainda estão correndo contra o tempo na cidade! \n \n \n  FIM ");

        }

        return tempo;
    }
    //Arvore
            public static int rolarDado1(int opcao) {
        Random gerador = new Random();
        int numSorteado = -1;
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
        if (numSorteado == 0) {
            numSorteado += 1;
        }
        System.out.println("O dado deu " + numSorteado);
        return numSorteado;
    }

    public static int arvore() {
        Scanner Input = new Scanner(System.in);
        char entrada;
        int numSorteado = 0;
        System.out.println("Droga uma Arvore! \n Você Desce do Carro e Observa que a arvore caiu devido a o temporal que caiu no dia passado! \n \n Jogue o dado e veja se sua força é o suficiente para levantar a arvore! \n  Caso seja maior que 15 o numero retirado conseguira Levantar a Arvore!");
        while (numSorteado < 15) {
            numSorteado = rolarDado(6);
            System.out.println("Sucesso, a Arvore foi Retirada, agora pode continuar o caminho até sua Familia!");
            if(numSorteado < 15){
            System.out.println("Digite 1 para continuar, 2 para Sair:       ");
            entrada = Input.next().charAt(0);
            if(entrada == '2')
                break;
            }
            
        }
        return numSorteado;
        
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

            switch (selectedOption) {
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

        while (finish != true) { //while somente para repetição.
            mov = funcaoMovimentacao(x, y, tempo);

            x = mov[0];
            y = mov[1];
            tempo = mov[2];

            funcaoMapa(x, y);
        }
    }
}
