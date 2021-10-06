    
import java.io.IOException;
import java.util.Scanner;

public class Menu {
        
  //  public Menu(){
  //  }
    

    public int menuInteracao(Treinador treinadorUm, Treinador treinadorDois, Monstro listaMonstro) throws InterruptedException, IOException {
        Treinador verificaEscolha = new Treinador();
        Scanner leitura = new Scanner(System.in);
        int navegacaoMenu = 0;

        System.out.printf("\n");
        System.out.println("\t>>> Monster Game <<<");

        System.out.printf("\n");
        do {
            System.out.println("\t1- Jogar partida arcade");
            System.out.println("\t2- Exibir regras do jogo");
            System.out.println("\t3- Sair");
            System.out.println("\tRESPOSTA: ");

            navegacaoMenu = leitura.nextInt();

            switch (navegacaoMenu) {

                case 1:                   
                    verificaEscolha.escolhaMonstro(treinadorUm, listaMonstro);
                    verificaEscolha.escolhaMonstro(treinadorDois, listaMonstro);
                    break;
                case 2:
                    System.out.println("                   Regras do jogo                        \n");
                    System.out.println("1- Cada jogador deverá escolher 3 montros para a batalha;\n");
                    System.out.println("2- Os dois jogadores podem selecionar os mesmos montros; \n");
                    System.out.println("3- Um jogador não poderá escolher o mesmo monstro mais     ");
                    System.out.println("    de uma vez;                                          \n");
                    System.out.println("4- A batalha deve ser efetuada em turnos: onde o jogador   ");
                    System.out.println("    1 escolhe sua ação, depois disso o jogador 2 escolhe   ");
                    System.out.println("    sua ação e por fim as duas ações são executadas        ");
                    System.out.println("    conforme as regras de prioridade;                    \n"); 
                    System.out.println("5- Prioridades de desempate para quem vai atacar primeiro: ");
                    System.out.println("    Monstros com maior velocidade atacam primeiro;       \n");
                    System.out.println("6- O jogador 2 não tem desvantagem por ser 2;            \n");
                    System.out.println("Pressione a tecla enter para continuar...                  ");
                    System.in.read();//https://www.guj.com.br/t/como-faco-pra-pausar-a-execucao/32986/6
                    //Thread.sleep(500);//https://www.javatpoint.com/sleep()-method


                    break;

                case 3:
                    System.out.println("Até a próxima jogador!");
                    break;
                default:

                    System.out.println("Opcao não encontrada, digite novamente\n");

                    break;
            }
        } while (navegacaoMenu != 1 && navegacaoMenu != 2 && navegacaoMenu != 3);
        return navegacaoMenu;
    }
}
