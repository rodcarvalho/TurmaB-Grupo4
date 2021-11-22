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
            System.out.println("  1. Instruções");
            System.out.println("  2. Jogar");
            System.out.println("  3. Créditos");
            System.out.println("  4. Sair");

            System.out.println("Digite o número da opção desejada para usar o comando");
            selectedOption = input.next().charAt(0);

            switch (selectedOption) {
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
        return gameOn;
    }

    // Função para movimentação do jogador no "mapa".
    static int[] funcaoMovimentacao(int x, int y, int tempo) {
        char opcao;
        boolean mov = false, gameOn = true;
        int[] retornoMov = new int[4];
        int contGame, penalidadeTempo = 5;

        while (mov != true && gameOn != false) {
            System.out.println("Opções:");
            System.out.println("  1. Escolher a direção para ir. ");
            System.out.println("  2. Olhar o GPS.");
            System.out.println("  3. Olhar o relógio.");
            System.out.println("  4. Ouvir Rádio.");
            System.out.println("  5. Voltar ao menu.");
            opcao = input.next().charAt(0);

            switch (opcao) {
                case '1':
                    System.out.println("Direções:");
                    System.out.println("  1. Norte");
                    System.out.println("  2. Sul");
                    System.out.println("  3. Leste");
                    System.out.println("  4. Oeste");
                    char opcao2;
                    opcao2 = input.next().charAt(0);

                    while (opcao2 != '1' && opcao2 != '2' && opcao2 != '3' && opcao2 != '4') {
                        System.out.println("Alternativa inválida, digite novamente:");
                        opcao2 = input.next().charAt(0);
                    }

                    switch (opcao2) {
                        case '1':
                            if (y == 1) {
                                System.out.println("Você está no limite.");
                            } else {
                                y = y - 1;
                                mov = true;
                            }
                            break;

                        case '2':
                            if (y == 10) {
                                System.out.println("Você está no limite.");
                            } else {
                                y = y + 1;
                                mov = true;
                            }
                            break;

                        case '3':
                            if (x == 10) {
                                System.out.println("Você está no limite.");
                            } else {
                                x = x + 1;
                                mov = true;
                            }
                            break;

                        case '4':
                            if (x == 1) {
                                System.out.println("Você está no limite.");
                            } else {
                                x = x - 1;
                                mov = true;
                            }
                            break;
                    }
                    break;

                case '2':
                    funcaoGPS(x, y);
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

        if (gameOn) {
            contGame = 1;
        } else {
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
        int distX = 0 , distY = 0;

        System.out.print("Você está na Rua " + x + " com a Rua ");
        switch (y) {
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
        System.out.println("  1. Familía");
        System.out.println("  2. Aeroporto");
        System.out.println("  3. Porto");
        System.out.println("  4. Estrada");

        char entrada = input.next().charAt(0);
        boolean controle = false;

        while (controle != true) {
            switch (entrada) {
                case '1':
                    distX = 4 - x;
                    distY = 7 - y;
                    System.out.print("A casa dos pais");
                    controle = true;
                    break;
                case '2':
                    distX = 2 - x;
                    distY = 1 - y;
                    System.out.print("O aeroporto");
                    controle = true;
                    break;
                case '3':
                    distX = 10 - x;
                    distY = 9 - y;
                    System.out.print("O porto");
                    controle = true;
                    break;
                case '4':
                    distX = 1 - x;
                    distY = 9 - y;
                    System.out.print("A estrada");
                    controle = true;
                    break;
                default:
                    System.out.println("Alternativa inválida, digite novamente:");
                    entrada = input.next().charAt(0);
            }
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
            System.out.println(distX + "Km para o leste");

        } else if (distX == 0) {
            System.out.println(".");

        }
    }

    // Função para ativar funções ou falas de acordo com a posição do jogador no mapa.
    static int[] funcaoMapa(int x, int y, int tempo, boolean gameOn, boolean familia) {
        char entrada;
        int chanceCarro, aleatorioCarro = 1,
                familiaX = 4, familiaY = 7,
                aeroportoX = 2, aeroportoY = 1,
                portoX = 10, portoY = 9,
                estradaX = 1, estradaY = 9;
        int[] retornoMapa = new int[3];

        if (x == familiaX && y == familiaY && familia == false) {
            familia();
            familia = true;

        } else if (x == aeroportoX && y == aeroportoY && familia == true) {
            gameOn = saidaAviao(tempo);

        } else if (x == aeroportoX && y == aeroportoY && familia == false) {
            System.out.println("MÃE - FILHO CADÊ VOCÊ?? ESTAMOS FICANDO SEM TEMPO.");
            System.out.println("  1. Já estou indo.");
            System.out.println("  2. Me perdi mãe, estou indo.");
            entrada = input.next().charAt(0);
            switch (entrada) {
                case '1':
                case '2':
                    System.out.println("MÃE - OK filho, estamos te esperando.");
                default:
                    System.out.println("Opção inválida, digite novamente:");
                    entrada = input.next().charAt(0);
            }

        } else if (x == estradaX && y == estradaY && familia == true) {
            System.out.println("PAI - Parece que a estrada está bloqueada filho, vamos tentar outro lugar. Podemos ir para o porto falar com o Nestor.");
            System.out.println("MÃE - A Patrícia tá lá na Aeroporto, ela pode arrumar umas passagens para nós.");
            System.out.println("  1. Vamos para o porto.");
            System.out.println("  2. Vamos para o aeroporto.");
            entrada = input.next().charAt(0);
            switch (entrada) {
                case '1':
                    System.out.println("MÃE - Tá bom");
                    break;
                case '2':
                    System.out.println("PAI - OK, vou avisar o Nestor. ");
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente:");
                    entrada = input.next().charAt(0);
            }

        } else if (x == estradaX && y == estradaY && familia == false) {
            System.out.println("Parece que a estrada está bloqueada.");

        } else if (x == portoX && y == portoY && familia == true) {
            gameOn = porto(tempo);
            
        } else if (x == portoX && y == portoY && familia == false) {
            System.out.println("MÃE - FILHO CADÊ VOCÊ?? ESTAMOS FICANDO SEM TEMPO.");
            System.out.println("  1. Já estou indo.");
            System.out.println("  2. Me perdi mãe, estou indo.");
            entrada = input.next().charAt(0);
            switch (entrada) {
                case '1':
                case '2':
                    System.out.println("MÃE - OK filho, estamos te esperando.");
                default:
                    System.out.println("Opção inválida, digite novamente:");
                    entrada = input.next().charAt(0);
            }

        } else if ((x == 8 && y == 9) || (x == 7 && y == 7) || (x == 2 && y == 5) || (x == 4 && y == 3) || (x == 2 && y == 8)) {
            tempo = arvore(tempo, familia);

        } else if (x == 2 && y == 6 && familia == true) {
            System.out.println("PAI - Acho que o aeroporto fica na Rua Caju filho.");
            System.out.println("  1. Acho que estamos na rua certa.");
            System.out.println("  2. OK, vou tentar ir para o leste assim que possivel");
            entrada = input.next().charAt(0);
            switch (entrada) {
                case '1':
                    System.out.println("PAI - Estranho, me lembro de ir pela Caju.");
                    System.out.println("MÃE - Eu acho que é nessa mesmo.");
                    break;
                case '2':
                    System.out.println("MÃE - Eu acho que é nessa mesmo.");
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente:");
                    entrada = input.next().charAt(0);
            }
        }else if(x == 3 && y == 4 && familia == true){
            System.out.println("PAI - Acho que o aeroporto fica na Rua Banana mesmo.");
            System.out.println("MÃE - Eu falei.");
        }else if (x == 7 && y == 7){
            System.out.println("Você vê um acidente terrivel. Um carro está pegando fogo na calçada e outro entrou em uma das lojas.");
            if(familia)
                System.out.println("MÃE - Meu Deus, que horror! Fecha o olho filha.");
        }else if( x == 4 && y == 9 && familia == true) {
            System.out.println("MÃE - Não é nessa rua a Mercearia do seu Zé?");
            System.out.println("PAI - É sim, será se ele está bem?");
            System.out.println("MÃE - Espero que sim.");
        }else if(x == 6 && y == 8 && familia == true){
            System.out.println("MÃE - Essa é a escola da tua irmã.");
            System.out.println("IRMÃ - Mãe, será se a tia Regina tá bem?");
            System.out.println("MÃE - Deus queira que sim minha filha.");
        }else if(x == 8 && y == 10 && familia == true) {
            System.out.println("PAI - Nestor mora aqui.");
            System.out.println("MÃE - E a família dele? Estão no porto?");
            System.out.println("PAI - Acho que sim.");
        }else if (x == 1 && y == 1 && familia == true) {
            System.out.println("MÃE - Estamos proximos já, filha acorde.");
            System.out.println("PAI - Chega mais perto e estaciona em qualquer lugar filho.");
            System.out.println("MÃE - Vou avisar a Patricia.");
        }else if (x == 2 && y == 2 && familia == true) {
            System.out.println("MÃE - Estamos proximos já, filha acorde.");
            System.out.println("PAI - Chega mais perto e estaciona em qualquer lugar filho.");
            System.out.println("MÃE - Vou avisar a Patricia.");
        }else if (x == 3 && y == 1 && familia == true) {
            System.out.println("MÃE - Estamos proximos já, falei que o Aeroporto era na rua Banana.");
            System.out.println("PAI - Chega mais perto e estaciona em qualquer lugar filho.");
            System.out.println("MÃE - Vou avisar a Patricia.");
        }else if (x == 10 && y == 8 && familia == true) {
            System.out.println("PAI - Estamos chegando, vou tentar avisar ao Nestor. ");
            System.out.println("MÃE - Tá bom, vamos rápido.");
        }else if (x == 9 && y == 9 && familia == true) {
            System.out.println("PAI - Estamos chegando, vou tentar avisar ao Nestor. ");
            System.out.println("MÃE - Tá bom, vamos rápido.");
        }else if (x == 10 && y == 10 && familia == true) {
            System.out.println("PAI - Estamos chegando, vou tentar avisar ao Nestor. ");
            System.out.println("MÃE - Tá bom, vamos rápido.");
        }else if (x == 1 && y == 4 && familia == true) {
            System.out.println("MÃE - A Padaria da Joana fica por aqui.");
            System.out.println("PAI - Espero que estejam bem.");
            System.out.println("MÃE - Também espero.");
        }

        chanceCarro = rolarDado(20);
        if (gameOn) {
            if (chanceCarro >= 19) {
                if (familia) {
                    aleatorioCarro = rolarDado(3);
                    switch (aleatorioCarro) {
                        case 1:
                            tempo = carroQuebradoFamilia1(tempo);
                            break;
                        case 2:
                            tempo = carroQuebradoFamilia2(tempo);
                            break;
                        case 3:
                            tempo = carroQuebradoFamilia3(tempo);
                            break;
                    }
                } else {
                    aleatorioCarro = rolarDado(3);
                    switch (aleatorioCarro) {
                        case 1:
                            tempo = carroQuebrado1(tempo);
                            break;
                        case 2:
                            tempo = carroQuebrado2(tempo);
                            break;
                        case 3:
                            tempo = carroQuebrado3(tempo);
                            break;
                    }
                }
            }
        }
        retornoMapa[0] = tempo;

        if (gameOn) {
            retornoMapa[1] = 1;
        } else {
            retornoMapa[1] = 0;
        }

        if (familia) {
            retornoMapa[2] = 1;
        } else {
            retornoMapa[2] = 0;
        }

        return retornoMapa;
    }

    // Função para ativar falas devido ao tempo.\
    static void funcaoRadio(int tempo) {
        if (tempo >= 0 && tempo < 5) {
            System.out.println("(Rádio) ** ALERTA ** Autoridades aconselham a evacuação imediata da cidade.");
        } else if (tempo >= 5 && tempo < 10) {
            System.out.println("(Rádio) Autoridades estão sendo realocadas para lidar com a crise, mais informações serão repassadas em breve.");
        } else if (tempo >= 10 && tempo < 15) {
            System.out.println("(Rádio) As forças armadas incentivam que a população procure a forma mais rapida de evacuação possível nesse momento.");
        } else if (tempo >= 15 && tempo < 20) {
            System.out.println("(Rádio) Alerta! Busquem seus familiares e se desloquem para algum dos pontos de fuga imediatamente!");
        } else if (tempo >= 20 && tempo < 25) {
            System.out.println("(Rádio) Atenção, autoridades pedem que as ruas que fazem cruzamento com as avenidas A e C sejam evitadas devido um acidente.");
        } else if (tempo >= 25 && tempo < 30) {
            System.out.println("(Rádio) Por favor, se desloquem de forma rápida, porem com segurança até os pontos de evacuação.");
        } else if (tempo >= 30 && tempo < 35) {
            System.out.println("(Rádio) Engarrafamentos devem ser evitados para a eficiência da evacuação, para isso, as ruas 7 e 5 devem ser evitadas!");
        } else if (tempo >= 35 && tempo < 40) {
            System.out.println("(Rádio) Rua 6 e Avenida B estão sendo ultilizadas para evacuação de hospitais e postos de saúde, favor evita-las.");
        } else if ( tempo >= 40 && tempo < 45) {
            System.out.println("(Rádio) Semáforo no cruzamento da rua 2 com a avenida A quebrou por um pequeno acidente. \nA polícia rodoviária está a caminho para o funcionamento da evacuação.");
        } else if ( tempo >= 45 && tempo < 50) {
            System.out.println("(Rádio) Rua 7 permanece engarrafada e deve ser evitada para rápida fuga. ");
        } else if ( tempo >= 50 && tempo < 55) {
            System.out.println("(Rádio) Os postos de fuga estão funcionando há toda velocidade possivel, se encaminhe para o posto mais proximo!");
        } else if ( tempo >= 60 && tempo < 65) {
            System.out.println("(Rádio) Autoridades permanecem encaminhando ônibus em caso de problemas na evacuação, que devem ser usados em últimos casos.");
        } else if ( tempo >= 70 && tempo < 75) {
            System.out.println("(Rádio) Por favor, rastreem seus familiares ou os tenha consigo nos postos de fuga.");
        } else if ( tempo >= 80 && tempo < 85) {
            System.out.println("(Rádio) Passageiros da rua 7 devem deixar seus veículos e se dirigirem para a avenida E, 3 ônibus estão prontos para seguirem aos postos de evacuação.");
        }else if ( tempo >= 85 && tempo < 90) {
            System.out.println("(Rádio) Um acidente ocorreu na avenida C e os bombeiros já foram acionados. Sigam em segurança!");
        }else if ( tempo >= 95 && tempo < 100) {
            System.out.println("(Rádio) As estações de rádio comunicadoras estão agora sendo evacuadas. Finalizamos nossas transmissões.");
        }else if ( tempo >= 100 && tempo < 105) {
            System.out.println("(Rádio) ** ALERTA ** Autoridades aconselham a evacuação imediata da cidade.");
        }
    }

    // Função para mostrar o horário no jogo.
    static void funcaoRelogio(int tempo) {
        int horario = 600, horarioTotal, hora, min;
        horarioTotal = horario + tempo;

        if (horarioTotal > 59) {
            hora = horarioTotal / 60;
            min = horarioTotal % 60;
        } else {
            hora = 0;
            min = horarioTotal;
        }

        if (hora >= 10 && min >= 10) {
            System.out.println("São " + hora + ":" + min);
        } else if (hora < 10 && min >= 10) {
            System.out.println("São 0" + hora + ":" + min);
        } else if (hora < 10 && min < 10) {
            System.out.println("São 0" + hora + ":0" + min);
        } else if (hora >= 10 && min < 10) {
            System.out.println("São " + hora + ":0" + min);
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

        while (introOn) {
            System.out.println("\nDigite o número da opção desejada para usar o comando");
            System.out.println("  1. para usar o comando PRÓXIMO para proseguir a história");
            System.out.println("  2. para usar o comando VOLTAR para voltar a história");
            System.out.println("  3. para usar o comando AJUDA para ver instruções do jogo");
            System.out.println("  4. para usar o comando RELÓGIO para ver as horas");
            comando = input.next().charAt(0);
            switch (comando) {
                case '1':
                    fraseNum++;
                    break;
                case '2':
                    fraseNum--;
                    break;
                case '3':
                    System.out.println("\nDigite o número da opção desejada para usar o comando");
                    System.out.println("  1. para usar o comando PRÓXIMO para proseguir a história");
                    System.out.println("  2. para usar o comando VOLTAR para voltar a história");
                    System.out.println("  3. para usar o comando AJUDA para ver instruções do jogo");
                    System.out.println("  4. para usar o comando RELÓGIO para ver as horas");
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
                    System.out.println("  1. Sim. Ainda estou tentando entender o que está acontecendo.");
                    System.out.println("  2. Não. Me conta o que aconteceu?");
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
                    System.out.println("  1. Do que você está falando?");
                    System.out.println("  2. Ta bom! Fiquem prontos! Daqui a pouco chego ai.");
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


    static void familia() {
        char entrada;
        System.out.println("Você chega na casa dos seus pais. \nSeus pais estão esperando já na frente.");
        System.out.println("MÃE - FILHO!! Que caos filho.");
        System.out.println("PAI - Você está bem fiho?");
        System.out.println("1. Estou bem pai.");
        System.out.println("2. Vamos conseguir.");
        entrada = input.next().charAt(0);
        switch (entrada) {
            case '1':
                System.out.println("PAI - Vamos nos apressar.");
                break;
            case '2':
                System.out.println("PAI - Beba essa água, vamos.");
                break;
            default:
                System.out.println("Opção Inválida, digite novamente:");
                entrada = input.next().charAt(0); 
        }
        System.out.println("MÃE - Falei com a Patricia, aquela da igreja, sabe? Ela trabalha no aeroporto "
                       + "\n      Ela disse que consegue passagens para nós. ");
        System.out.println("PAI - O Nestor falou que está comandando um dos navios do porto, podemos ir com ele.");
        System.out.println("1. Vamos tentar o aeroporto.");
        System.out.println("2. Vamos para o porto.");
        entrada = input.next().charAt(0);
        switch (entrada) {
            case '1':
                System.out.println("PAI - Tá, mas qualquer imprevisto vamos tentar o porto.");
                break;
            case '2':
                System.out.println("MÃE - OK, Vamos para lá mas o aeroporto continua sendo uma opção.");
                break;
            default:
                System.out.println("Opção Inválida, digite novamente:");
                entrada = input.next().charAt(0); 
        }
        System.out.println("MÃE - Sua irmã está dormindo no meio disso tudo, dá pra acreditar?");
        System.out.println("PAI - Vamos logo, entrem no carro.");
    }   

    // Função CarroQuebrado1
    public static int carroQuebrado1(int tempo) {
        System.out.println("CLANK, CLACK, CLACK, CLACK, PUUUUuuuuuffff \nO Carro deu Algum Problema! \nVocê desce do carro corendo para ver qual o problema \nOh não é a Correira que saiu fora do lugar!!! \nDecida qual das 9 caixas caixa contem os itens Necessários para Consertar seu carro! \n");
        char esco;
        do {
            esco = input.next().charAt(0);

            switch (esco) {
                case '1':
                    System.out.println("Martelo! \nMorno!!");
                    break;
                case '2':
                    System.out.println("Chave de Fenda \nQuente!");
                    break;
                case '3':
                    System.out.println("Pedra Rachada  \nPegando Fogo!");
                    break;
                case '4':
                    System.out.println("Correia Nova e Manual \nSabia que estava por aqui! ");
                    break;
                case '5':
                    System.out.println("Chave de Boca \nPegando Fogo!");
                    break;
                case '6':
                    System.out.println("Massarico \nQuente!");
                    break;
                case '7':
                    System.out.println("Brinquedo da sua Irmãzinha \nMorno!!");
                    break;
                case '8':
                    System.out.println("Furadeira! \nFrio!!");
                    break;
                case '9':
                    System.out.println("Pé de Cabra \nFrio!!");
                    break;

                default:
                    System.out.println("Puts essa Ferramenta não está por aqui!");
                    tempo = tempo - 2;
                    break;
            }
            tempo = tempo + 2;
        } while (esco != '4');
        return tempo;
    }

    //2
    public static int carroQuebrado2(int tempo) {
        System.out.println("CLANK, CLACK, CLACK, CLACK, PUUUUuuuuuffff \nO Carro deu Algum Problema! \nVocê desce do carro correndo para ver qual o problema \nDroga! você não sabe qual o Problema se ao menos seu pai estivesse aqui ele poderia te ajudar!! \nProcure e veja qual o Problema do carro, dentre os 9 lugares que você acha que pode estar da direita até a esqueda do carro!!! ");
        char esco;
        do {

            esco = input.next().charAt(0);
            switch (esco) {
                case '1':
                    System.out.println("Sem os Pistões!!  \nPara Direita!!");
                    break;
                case '2':
                    System.out.println("Problemas na Bateria?? \nPara Direita!!");

                    break;
                case '3':
                    System.out.println("Ventuinha parada \nÉ ISSO!");
                    break;
                case '4':
                    System.out.println("Sem escapamento! \nPara Esquerda!! ");
                    break;
                case '5':
                    System.out.println("Chave presa no capo! \nPara Esquerda!!");
                    break;
                case '6':
                    System.out.println("Ventuianha quebrada \nPara Esquerda!!");
                    break;
                case '7':
                    System.out.println("Falta de Agua no Sistema! \nPara Esquerda!!");
                    break;
                case '8':
                    System.out.println("Pedra no Motor!! \nPara Esquerda!!");
                    break;
                case '9':
                    System.out.println("Pneu \nPara Esquerda!!");
                    break;

                default:
                    System.out.println("Essa não é uma opção de Problema!");
                    tempo = tempo - 2;
                    break;
            }
            tempo = tempo + 2;

        } while (esco != '3');

        return tempo;
    }

    //3
    public static int carroQuebrado3(int tempo) {
        System.out.println("CLANK, CLACK, CLACK, CLACK, PUUUUuuuuuffff \nO Carro deu Algum Problema! \nVocê desce do carro correndo para ver qual o problema \nAlgo ficou preso na Roda!! \nDescubra oque é dentre as 9 Possibilidades! ");
        char esco;
        do {
            esco = input.next().charAt(0);

            switch (esco) {
                case '1':
                    System.out.println("Pedra  \n Gelado!!");
                    break;
                case '2':
                    System.out.println("Gelo? \n Frio!!");

                    break;
                case '3':
                    System.out.println("Pedaço de Ferro \n Frio!!");
                    break;
                case '4':
                    System.out.println("Uma sacola? \n Quente!! ");
                    break;
                case '5':
                    System.out.println("Faca \n Pegando Fogo!!");
                    break;
                case '6':
                    System.out.println("Brinquedo de Criança \n Meu deus! Que bom que eu achei, tadinha da criança que perdeu");
                    break;
                case '7':
                    System.out.println("Madeira quebrada \n Pegando Fogo!!");
                    break;
                case '8':
                    System.out.println("Escapamento quebrado de outros carros?! \n Quente");
                    break;
                case '9':
                    System.out.println("Borracha  \n Frio!!");
                    break;

                default:
                    System.out.println("Isso com certeza não está no Pneu!");
                    tempo = tempo - 2;
                    break;
            }
            tempo = tempo + 2;
        } while (esco != '6');

        return tempo;
    }

    //Carro Familia
    public static int carroQuebradoFamilia1(int tempo) {
        System.out.println("CLANK, CLACK, CLACK, CLACK, PUUUUuuuuuffff \nO Carro deu Algum Problema! \nVocê e seu Pai descem do carro correndo para ver qual o problema \nOh não é a Correira que saiu fora do lugar!!! \nDecida qual das 9 caixas caixa contem os itens Necessários para Consertar seu carro! \nMas espere, 4 delas pertemcem a Sua mãe, isso deixa o Trabalho bem mais facil!! \nDecida entre as 5 caixas restantes ");

        char esco;
        do {
            esco = input.next().charAt(0);

            switch (esco) {
                case '1':
                    System.out.println("Martelo! \nMorno!!");
                    break;
                case '2':
                    System.out.println("Chave de Fenda \nQuente!");
                    break;
                case '3':
                    System.out.println("Pedra Rachada  \nPegando Fogo!");
                    break;
                case '4':
                    System.out.println("Correia Nova e Manual \nSabia que estava por aqui! ");
                    break;
                case '5':
                    System.out.println("Chave de Boca \nPegando Fogo!");
                    break;

                default:
                    System.out.println("Puts essa Ferramenta não está por aqui!");
                    tempo = tempo - 2;
                    break;
            }
            tempo = tempo + 2;
        } while (esco != '4');
        return tempo;
    }

    // 2
    public static int carroQuebradoFamilia2(int tempo) {
        System.out.println("CLANK, CLACK, CLACK, CLACK, PUUUUuuuuuffff \nO Carro deu Algum Problema! \nVocê desce do carro correndo para ver qual o problema \nDroga! você não sabe qual o Problema !! \nProcure e veja qual o Problema do carro, dentre os 9 lugares que você acha que pode estar da direita a esqueda do carro!!! \nEspere! seu api tem certeza de que não existem alguns dos problemas que você estava procurando, Isso diminui sua contagem para apenas 5 problemas!! \nProcure dentre os 5 problemas! ");

        char esco;
        do {

            esco = input.next().charAt(0);
            switch (esco) {
                case '1':
                    System.out.println("Sem os Pistões!!  \nPara Direita!!");
                    break;
                case '2':
                    System.out.println("Problemas na Bateria?? \nPara Direita!!");

                    break;
                case '3':
                    System.out.println("Ventuinha parada \nÉ ISSO!");
                    break;
                case '4':
                    System.out.println("Sem escapamento! \nPara Esquerda!! ");
                    break;
                case '5':
                    System.out.println("Chave presa no capo! \nPara Esquerda!!");
                    break;

                default:
                    System.out.println("Essa não é uma opção de Problema!");
                    tempo = tempo - 2;
                    break;
            }
            tempo = tempo + 2;

        } while (esco != '3');

        return tempo;
    }

    // 3
    public static int carroQuebradoFamilia3(int tempo) {
        System.out.println("CLANK, CLACK, CLACK, CLACK, PUUUUuuuuuffff \nO Carro deu Algum Problema! \nVocê desce do carro correndo para ver qual o problema \nAlgo ficou preso na Roda!! \nDescubra oque é dentre as 9 Possibilidades! \nESPERE sua Irmãzinha disse que viu o tamanho do Objeto, isso Diminui o seu leque de possibilidade para apenas 6! \nFaça a Escolha dentre os 6 objetos que podem estar presos na Roda do Carro! ");
        char esco;
        do {
            esco = input.next().charAt(0);

            switch (esco) {
                case '1':
                    System.out.println("Pedra  \nGelado!!");
                    break;
                case '2':
                    System.out.println("Gelo? \nFrio Literalmente!!");

                    break;
                case '3':
                    System.out.println("Pedaço de Ferro \nFrio!!");
                    break;
                case '4':
                    System.out.println("Uma sacola? \nQuente!! ");
                    break;
                case '5':
                    System.out.println("Faca \nPegando Fogo!!");
                    break;
                case '6':
                    System.out.println("Boneca!! \nSó podia ser né!! Bem que ela reconheceu!");
                default:
                    System.out.println("Isso com certeza não está no Pneu!");
                    tempo = tempo - 2;
                    break;
            }
            tempo = tempo + 2;
        } while (esco != '6');

        return tempo;
    }

    // Avião
    public static boolean saidaAviao(int tempo) {
        boolean gameOn = true;
        System.out.println("Você e Sua familia chegam ao Aeroporto \nTodos respiram fundo se achando a salvo, porem você percebe que sua mãe parece estranhamente preocupada! \nVocê toca nas costas dela e percebe que ela está tremendo!"
                + "\n  1. Está tudo bem com a Senhora?"
                + "\n  2. Qual o problema, a Senhora parece um pouco preoupada? "
                + "\n  3. Tudo bem com você mãe? é Algo que eu deva me preocupar?");

        char escoMae;

        escoMae = input.next().charAt(0);
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
                escoMae = input.next().charAt(0);
        }

        System.out.println(" \n MÃE - Filho, não estou achando a Patricia! era ela que trabalhava aqui e nos ajudaria a entrar no avião!"
                + "\nVocê Procura a tal de Patricia ,Porem no meio daquele mar de gente é como achar uma Agulha em um palheiro \nVocê pergunta para alguns funcionarios que falam que Patricia está em alguma das 5 salas do seu corredor!"
                + "\nProcure e Ache Patricia e Cuidado com o tempo! ");

        char esco;
        do {
            esco = input.next().charAt(0);
            switch (esco) {
                case '1':
                    System.out.println(" Sala Principal! \n Você encontra um segurança que te diz que ela passou ali já faz muito tempo!");
                    break;
                case '2':
                    System.out.println(" Sala de Revista! \n Policial: Ela Accabou de Sair daqui não deve estar Longe!");

                    break;
                case '3':
                    System.out.println(" Sala de Entrada! \n É ISSO! você uma Senhora por volta de seus 70 anos parecendo diciplinar alguns adolescentes que estavam vestidos com a roupa de funcionarios do aeroporto! \n Você vai até ela e espera ela dispensar os garotos, ela percebe você e os dispensa rapidamente mas não sem antes soltar alguns 'INCOMPETENTES' \n ela respira fundo e vira com um sorriso no rosto \n Patricia : ó então era você, que bom que vocês chegaram venham, venham, vou colocar vocês no proximo Avião imediatamente!");
                    break;
                case '4':
                    System.out.println(" Sala de Embarque! \n Ela ainda não passou por aqui! se não me engano ela estava atras de alguns funcionarios dela! ");
                    break;
                case '5':
                    System.out.println(" Sala de Espera Idosa! \n Você entra na sala e Encontra uma Velhinha que parece conhece-la, porem quando você pergunta é quase coberto de coronhadas coma bengala \n e berros do tipo 'essa Velha maluca não vem aqui nunca' é, você não sabe bem quem é a maluca da Historia!");
                    break;

                default:
                    System.out.println("Essa não é uma opção de sala!!");
                    tempo = tempo - 2;
                    break;
            }
            tempo = tempo + 2;
        } while (esco != '3');

        System.out.println("Chegando com Patricia na Hora de Embarcar, ela te da as instruções seguidas pelas suas passagens e de sua familia"
                + "\nPatricia: Boa Viagem e vão com segurança! mande um beijo para sua mãe!!"
                + "\nVocê percebe que ela parece meio melancolica e com lagrimas nos olhos, e no fim decide perguntar "
                + "\n  1. Porque Você já não vem junto?"
                + "\n  2. E você e sua Familião vão quando?"
                + "\n  3. Você pretende sair quando?");
        char escoPat;
        escoPat = input.next().charAt(0);
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
                escoPat = input.next().charAt(0);
        }
        System.out.println(" \nEla fica quieta alguns segunda e respira fundo colocando um sorriso no rosto \n"
                + "Patricia: Eu ja Estou velha, o mundo é dos jovens! \nEla se vira rapidamente e se embrenha na Multidão Sumindo e você rapidamente volta para onde seus pais estão! ");

        System.out.println("Você se Junta com seus pais e sua irmã, finalmente indo em direção ao avião , é até um pouco estranho embarcar sem malas \n  1. Embarcar no avião.");
        char embarq;
        embarq = input.next().charAt(0);
        switch (embarq) {
            case '1':
                System.out.println("\n Embarcando no avião!");
                break;
            default:
                System.out.println("Opção Invalida!");
                embarq = input.next().charAt(0);
        }

        System.out.println("\n \n \n \n Você e seus pais conseguem finalmente entram no avião! E você finalmente se sente Aliviado"
                + "\nMas no fim algo ainda te incomoda e você fala com sua mãe sobre patricia"
                + "\n  1. Porque ela parecia tão triste? "
                + "\n  2. Mãe, Porque ela ficou?");
        char escoRespMae;
        escoRespMae = input.next().charAt(0);
        switch (escoRespMae) {
            case '1':
                System.out.println("\n Porque ela parecia tão triste? ");
                break;
            case '2':
                System.out.println("\n Mãe, Porque ela ficou?");
            default:
                System.out.println("Opção Invalida!");
                escoRespMae = input.next().charAt(0);
        }
        System.out.println("MÃE - O marido e o Filho de patricia estão internados na cidade, eles sofreram um grave acidente de carro mês passado e os dois estão em coma \n"
                + "\nMÃE - Duvido muito que consigam sair... sua mãe se escora no seu pai e parece dormir e você fica um pouco chocado mas no fim balança a cabeça em negação e luto \nFinalmente o avião levanta voo e depois de alguns segundos de voo no horrizonte você vê uma frota de navios saindo tambêm para o porto mais proximo \nAgora aliviado você finalmente consegue relaxar e dormir e rezar por aqueles que ainda estão correndo contra o tempo na cidade! \n \n \n");
        
        if(tempo > 150){
            System.out.println("O avião decola porém não há tempo para fugir. Um forte estrondo surge e atinge o avião. ");
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
        }else{
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
            System.out.println("O avião decola e você consegue ver pela janela a explosão, felizmente você e sua família estão a salvo.");
            
        }
        gameOn = false;
        return gameOn;
    }

    // Arvore
    public static int arvore(int tempo, boolean familia) {
        char entrada;
        int numSorteado = 0;
        int forca;

        if (familia) {
            forca = 12;
        } else {
            forca = 15;
        }

        System.out.println("Droga uma Arvore! \nVocê Desce do Carro e Observa que a arvore caiu devido ao temporal que caiu no dia passado! \n \nJogue o dado e veja se sua força é o suficiente para levantar a arvore! \nCaso seja maior que " + forca + " o numero retirado conseguira Levantar a Arvore!");
        while (numSorteado < forca) {
            System.out.println("1. para jogar o dado.");
            System.out.println("2. para dar a volta.");
            entrada = input.next().charAt(0);
            switch (entrada) {
                case '1':
                    numSorteado = rolarDado(20);
                    System.out.println("O dado deu " + numSorteado);
                    break;
                case '2':
                    System.out.println("Você dá a volta por uma rua adjacente, levando em torno de 10 min. ");
                    tempo = tempo + 10;
                    numSorteado = 20;
                    break;
                default:
                    System.out.println("Opção inválida, digite novamente:");
                    entrada = input.next().charAt(0);
            }

            if (numSorteado >= forca) {
                System.out.println("Você passou, agora pode continuar o caminho.");
            } else if (numSorteado < forca) {
                tempo = tempo + 2;
            }
        }
        return tempo;
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
                        portoOn = false;
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
                        portoOn = false;
                    }
                    
                }          
            } 
        return portoOn = false;
    } 
        
        

    // Main
    public static void main(String[] args) {
        boolean gameOn = mainMenu();
        boolean familia = false;
        // Movimentação
        int[] mov, mapa;
        int x = 8, y = 4, tempo = 0;

        if (gameOn) {
            intro();
        }

        while (gameOn != false) { // while somente para repetição.
            mov = funcaoMovimentacao(x, y, tempo);

            x = mov[0];
            y = mov[1];
            tempo = mov[2];

            if (mov[3] == 0) {
                gameOn = false;
            } else if (mov[3] == 1) {
                gameOn = true;
            }
            System.out.println(x);
            System.out.println(y);
            if (gameOn) {
                mapa = funcaoMapa(x, y, tempo, gameOn, familia);
                tempo = mapa[0];

                if (mapa[1] == 0) {
                    gameOn = false;
                }

                if (mapa[2] == 1) {
                    familia = true;
                } else if (mapa[2] == 0) {
                    familia = false;
                }
            }
            if(gameOn){
                if(tempo >= 150){
                    System.out.println("Você ouve barulhos de sirene. Sente um calafrio");
                    System.out.println("MÃE - Está acontecendo?");
                    System.out.println("PAI - Me abracem. Vai ficar tudo bem.");
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
                    gameOn = false;

                }
            }
        }
    }

}
