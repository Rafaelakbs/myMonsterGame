
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class App {

	public static void main(String[] args) throws InterruptedException, IOException {
		int escolhaAtaque;
		int turno = 1;
		int escolha = 0;
		double modificadorDano;
		boolean vezTreinadorUm = true;
		double danoTreinadorUm = 0;
		double danoTreinadorDois = 0;
		int escolhaAtaqueTreinadorUm = 0;
		int escolhaAtaqueTreinadorDois = 0;
		int navegacaoMenu;
		int trocouUm = 0;
		int trocouDois = 0;
		int acabou = 0;
		int volta = 0;
		String nomeAtaqueUm;
		String nomeAtaqueDois;

		Random aleatorio = new Random();
		Scanner leitura = new Scanner(System.in);
		Treinador treinadorUm = new Treinador();
		Treinador treinadorDois = new Treinador();
		Monstro listaMonstro = new Monstro();
		TipoElemento comparaVantagem = new TipoElemento();
		Menu menuInteracao = new Menu();
		Combate combate = new Combate();
		Treinador vencedor = new Treinador();

		TipoElemento agua = new TipoElemento(1, "AGUA");
		TipoElemento fogo = new TipoElemento(2, "FOGO");
		TipoElemento terra = new TipoElemento(3, "TERRA");
		TipoElemento lutador = new TipoElemento(4, "LUTADOR");
		TipoElemento sombrio = new TipoElemento(5, "SOMBRIO");
		TipoElemento fantasma = new TipoElemento(6, "FANTASMA");
		TipoElemento dragao = new TipoElemento(7, "DRAGAO");
		TipoElemento fada = new TipoElemento(8, "FADA");
		TipoElemento planta = new TipoElemento(9, "PLANTA");
		TipoElemento psiquico = new TipoElemento(10, "PSIQUICO");
		TipoElemento normal = new TipoElemento(11, "NORMAL");
		TipoElemento pedra = new TipoElemento(12, "PEDRA");
		TipoElemento nulo = new TipoElemento(13, "");

		Ataque rajadaDeFogo = new Ataque("Rajada de Fogo", fogo, 5);
		Ataque esguichoDeAgua = new Ataque("Esguicho de Agua", agua, 4.5);
		Ataque tiroVenenoso = new Ataque("Tiro Venenoso", planta, 4.5);
		Ataque asasCortantes = new Ataque("Asas Cortantes", dragao, 5);
		Ataque raioPsiquico = new Ataque("Raio Psiquico", psiquico, 6);
		Ataque cantoMagico = new Ataque("Canto Magico", fada, 4);
		Ataque rosnado = new Ataque("Rosnado", sombrio, 6);
		Ataque garraFantasmagorica = new Ataque("Garra Fantasmagorica", fantasma, 4);
		Ataque voadora = new Ataque("Voadora", lutador, 7);
		Ataque arremecoDePedra = new Ataque("Arremaço de Pedra", pedra, 4);
		Ataque tapaDeLama = new Ataque("Tapa de Lama", terra, 6);
		Ataque ataqueMalandro = new Ataque("Ataque Malandro", normal, 4);
		Ataque mordida = new Ataque("Mordida", normal, 6);

		AtaqueCarregado erupcaoDeFogo = new AtaqueCarregado("Erupção de Fogo", fogo, 12, 3, Efeito.INCENDIADO);
		AtaqueCarregado alagamento = new AtaqueCarregado("Alagamento", agua, 9, 5, Efeito.NULO);
		AtaqueCarregado sementesVenenosas = new AtaqueCarregado("Sementes Venenosas", planta, 10, 4, Efeito.ENVENENADO);
		AtaqueCarregado pulsoDoDragao = new AtaqueCarregado("Pulso do Dragao", dragao, 12, 4, Efeito.NULO);
		AtaqueCarregado confusaoMental = new AtaqueCarregado("Confusao Mental", psiquico, 5, 4, Efeito.ATORDOADO);
		AtaqueCarregado bonsSonhos = new AtaqueCarregado("Bons Sonhos", fada, 0, 3, Efeito.DORMINDO);
		AtaqueCarregado escuridao = new AtaqueCarregado("Escuridao", sombrio, 8, 5, Efeito.NULO);
		AtaqueCarregado bolaSombria = new AtaqueCarregado("Bola Sombria", fantasma, 15, 2, Efeito.NULO);
		AtaqueCarregado antonioNunes = new AtaqueCarregado("Antonio Nunes", lutador, 12, 2, Efeito.NULO);
		AtaqueCarregado desmoronamento = new AtaqueCarregado("Desmoronamento", pedra, 8, 4, Efeito.NULO);
		AtaqueCarregado terremoto = new AtaqueCarregado("Terremoto", terra, 10, 4, Efeito.NULO);
		AtaqueCarregado barrigada = new AtaqueCarregado("Barrigada", normal, 10, 3, Efeito.ATORDOADO);
		AtaqueCarregado hiperFeixe = new AtaqueCarregado("Hiper Feixe", normal, 17, 1, Efeito.NULO);

		/*
		 * listaMonstrosNew.add(new MonstroNew(0, "Boitata", fogo, nulo, 50,30, 10, 10,
		 * rajadaDeFogo, rosnado, mordida, erupcaoDeFogo)); listaMonstrosNew.add(new
		 * MonstroNew(1, "Cuca", dragao, psiquico, 1, 1, 1, 1, asasCortantes,
		 * raioPsiquico, tapaDeLama, pulsoDoDragao));
		 * 
		 * for(MonstroNew m : listaMonstrosNew){ m.imprime(); }
		 * listaMonstrosNew.get(0).imprime();
		 */

		listaMonstro.add(0, "Boitata", fogo, nulo, 30, 35, 15, 20, rajadaDeFogo, rosnado, mordida, erupcaoDeFogo);
		listaMonstro.add(1, "Cuca", dragao, psiquico, 20, 20, 35, 25, asasCortantes, raioPsiquico, tapaDeLama,
				pulsoDoDragao);
		listaMonstro.add(2, "Boto", agua, fada, 20, 30, 30, 20, esguichoDeAgua, mordida, cantoMagico, bonsSonhos);
		listaMonstro.add(3, "Cabra Cabriola", sombrio, nulo, 30, 40, 10, 20, mordida, ataqueMalandro, rosnado,
				escuridao);
		listaMonstro.add(4, "Chibamba", planta, nulo, 20, 30, 15, 35, voadora, ataqueMalandro, tiroVenenoso,
				sementesVenenosas);
		listaMonstro.add(5, "Corpo Seco", fantasma, nulo, 35, 15, 15, 35, garraFantasmagorica, mordida, rosnado,
				bolaSombria);
		listaMonstro.add(6, "Curupira", lutador, nulo, 40, 25, 20, 15, rajadaDeFogo, voadora, ataqueMalandro,
				antonioNunes);
		listaMonstro.add(7, "Encantados", planta, fada, 25, 15, 35, 25, tiroVenenoso, cantoMagico, raioPsiquico,
				hiperFeixe);
		listaMonstro.add(8, "Gorjala", pedra, nulo, 40, 38,15,7, arremecoDePedra, rosnado, ataqueMalandro,
				desmoronamento);
		listaMonstro.add(9, "Homem do Saco", normal, nulo, 25, 25, 10, 40, ataqueMalandro, mordida, voadora, barrigada);
		listaMonstro.add(10, "Iara", agua, fada, 35, 15, 20, 30, esguichoDeAgua, cantoMagico, mordida, alagamento);
		listaMonstro.add(11, "Labatut", terra, nulo, 35, 10, 40, 15, tapaDeLama, arremecoDePedra, ataqueMalandro,
				terremoto);
		listaMonstro.add(12, "Lobisomem", sombrio, nulo, 25, 35, 5, 35, rosnado, mordida, garraFantasmagorica,
				escuridao);
		listaMonstro.add(13, "Loura do Banheiro", fantasma, nulo, 25, 25, 10, 40, raioPsiquico, garraFantasmagorica,
				ataqueMalandro, bolaSombria);
		listaMonstro.add(14, "Mula sem Cabeça", fogo, nulo, 30, 30, 20, 20, rajadaDeFogo, voadora, ataqueMalandro,
				erupcaoDeFogo);
		listaMonstro.add(15, "Negrinho do Pastoreio", fada, nulo, 35, 10, 35, 20, cantoMagico, raioPsiquico,
				ataqueMalandro, bonsSonhos);
		listaMonstro.add(16, "Saci", lutador, nulo, 30, 30, 20, 20, ataqueMalandro, voadora, raioPsiquico,
				antonioNunes);
		listaMonstro.add(17, "Alma de Gato", fogo, sombrio, 20, 50, 15, 15, rajadaDeFogo, rosnado, mordida, escuridao);

		do {
			navegacaoMenu = menuInteracao.menuInteracao(treinadorUm, treinadorDois, listaMonstro);
			if (navegacaoMenu == 1) {
				System.out.println("\n\n                       >>>> Que o combate comece <<<<");

				do {
					
					do{
						volta=0;
					if (vezTreinadorUm)
						escolha = combate.combateMenu(treinadorUm, treinadorDois, turno);
					else
						escolha = combate.combateMenu(treinadorDois, treinadorUm, turno);

					switch (escolha) {
						case 1:
							for (int i = 0; i < 50; ++i)
								System.out.println();// https://qastack.com.br/programming/2979383/java-clear-the-console#:~:text=Tudo%20o%20que%20esse%20c%C3%B3digo,cls%22%20seguido%20da%20tecla%20Enter.
							if (vezTreinadorUm) {
								do {
									combate.imprimeCombateMenu(treinadorUm, treinadorDois, turno);
									treinadorUm.ataques();
									if (treinadorUm.getMonstro().getSobEfeitoRoundTermina(treinadorUm.getMonstroAtualId())>turno){
										treinadorUm.getMonstro().setSobEfeito(treinadorUm.getMonstroAtualId(), false);
										System.out.println("Seu monstro está dormindo e não pôde atacar ZZZzzz");
										System.out.println("Retornando ao menu...");
										Thread.sleep(1000);
										escolhaAtaque=8;
									}else{
									System.out.println("Escolha um ataque:      -> Para voltar use a tecla 8");
									escolhaAtaque = leitura.nextInt();
									}
									if(escolhaAtaque==8){
										System.out.println("Retornando");
										Thread.sleep(1000);
										volta = 1;
										break;

									}
								} while (escolhaAtaque < 1 || escolhaAtaque > 4);
								if(volta!=1){
								if (escolhaAtaque != 4) {
									modificadorDano = treinadorUm.getMonstro().getAtaque(treinadorUm.getMonstroAtualId(), escolhaAtaque-1).getDano();

								} else {
									modificadorDano = treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId()).getDano();
									System.out.println(modificadorDano);

									treinadorUm.diminuiEnergia();
								}
								danoTreinadorUm = combate.calculaAtaque(treinadorUm, treinadorDois, modificadorDano);
								escolhaAtaqueTreinadorUm = escolhaAtaque;
							}
							} else {
								do {
									combate.imprimeCombateMenu(treinadorDois, treinadorUm, turno);
									treinadorDois.ataques();	
									if (treinadorDois.getMonstro().getSobEfeitoRoundTermina(treinadorDois.getMonstroAtualId())>turno){
										treinadorDois.getMonstro().setSobEfeito(treinadorDois.getMonstroAtualId(), false);
										System.out.println("Seu monstro está dormindo e não pôde atacar ZZZzzz");
										System.out.println("Retornando ao menu...");
										Thread.sleep(1000);
										escolhaAtaque=8;
									}else{
										System.out.println("Escolha um ataque:      -> Para voltar use a tecla 8");
										escolhaAtaque = leitura.nextInt();
									}							
									
									if(escolhaAtaque==8){
										System.out.println("Retornando");
										Thread.sleep(1000);
										volta=1;
										break;

									}
									if (escolhaAtaque < 1 || escolhaAtaque > 4) {
										System.out.println("Esse ataque não existe...");
									}

									if (treinadorDois.getMonstro()
											.getAtaqueCarregadoEnergia(treinadorDois.getMonstroAtualId()) < 1
											&& escolhaAtaque == 4) {
										System.out.println("Ataque carregado sem energia. Use outro ataque.");
										Thread.sleep(1000);
										escolhaAtaque = 5;

									}
								} while (escolhaAtaque < 1 || escolhaAtaque > 4);
								if(volta==0){
								if (escolhaAtaque != 4) {
									modificadorDano = treinadorDois.getMonstro().getAtaque(treinadorDois.getMonstroAtualId(), escolhaAtaque-1).getDano();
								} else {
									modificadorDano = treinadorDois.getMonstro().getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getDano();
									treinadorDois.diminuiEnergia();

								}
								danoTreinadorDois = combate.calculaAtaque(treinadorDois, treinadorUm, modificadorDano);
								escolhaAtaqueTreinadorDois = escolhaAtaque;
								}
							}
							break;
						case 2:
						System.out.println("A bolsa está vazia.\nPressione enter para voltar...");
						System.in.read();
						volta=1;
							break;
						case 3:
							if (vezTreinadorUm) {

								combate.imprimeCombateMenu(treinadorUm, treinadorDois, turno);
								volta = treinadorUm.mudaMonstroAtual();
								trocouUm = 1;
							} else {
								combate.imprimeCombateMenu(treinadorDois, treinadorUm, turno);
								volta = treinadorDois.mudaMonstroAtual();
								trocouDois = 1;
							}
							break;
						case 4:
							if (vezTreinadorUm) {
								treinadorUm.corre();
							} else {
								treinadorDois.corre();
							}
							break;
						default:
							break;
						}
					}while(volta!=0);
					
					if (vezTreinadorUm) {
						vezTreinadorUm = false;
					} else {
						
						if (escolhaAtaqueTreinadorUm != 4) {
							danoTreinadorUm = danoTreinadorUm
									* comparaVantagem.vantagem(
											treinadorUm.getMonstro()
													.getAtaque(treinadorUm.getMonstroAtualId(),
															escolhaAtaqueTreinadorUm - 1)
													.getTipo().getTipo(),
											treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId())
													.getTipo())
									* comparaVantagem.vantagem(
											treinadorUm.getMonstro()
													.getAtaque(treinadorUm.getMonstroAtualId(),
															escolhaAtaqueTreinadorUm - 1)
													.getTipo().getTipo(),
											treinadorDois.getMonstro()
													.getTipoSecundario(treinadorDois.getMonstroAtualId()).getTipo());
							nomeAtaqueUm = treinadorUm.getMonstro()
									.getAtaque(treinadorUm.getMonstroAtualId(), escolhaAtaqueTreinadorUm - 1).getNome();
						
						} else {
							danoTreinadorUm = danoTreinadorUm
									* comparaVantagem.vantagem(
											treinadorUm
													.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId())
													.getTipo().getTipo(),
											treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId())
													.getTipo())
									* comparaVantagem.vantagem(
											treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId())
													.getTipo().getTipo(),
											treinadorDois.getMonstro()
													.getTipoSecundario(treinadorDois.getMonstroAtualId()).getTipo());
							nomeAtaqueUm = treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId())
									.getNome();

									if (treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId()).getEfeito().getNome().equals("DORMINDO")) {
										int sorteia = aleatorio.nextInt(100) + 1;
									
										if (sorteia<=85){
											System.out.println("O monstro inimigo esta dormindo...ZZzzz");
											treinadorDois.getMonstro().setSobEfeito(treinadorDois.getMonstroAtualId(), true);
											treinadorDois.getMonstro().setSobEfeitoRoundTermina(treinadorDois.getMonstroAtualId(), turno+3);
										}

										
									
						}
						}

						if (escolhaAtaqueTreinadorDois != 4) {
							danoTreinadorDois = danoTreinadorDois
									* comparaVantagem.vantagem(
											treinadorDois.getMonstro()
													.getAtaque(treinadorDois.getMonstroAtualId(),
															escolhaAtaqueTreinadorDois - 1)
													.getTipo().getTipo(),
											treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo())
									* comparaVantagem.vantagem(
											treinadorDois.getMonstro()
													.getAtaque(treinadorDois.getMonstroAtualId(),
															escolhaAtaqueTreinadorDois - 1)
													.getTipo().getTipo(),
											treinadorUm.getMonstro().getTipoSecundario(treinadorUm.getMonstroAtualId())
													.getTipo());
							nomeAtaqueDois = treinadorDois.getMonstro()
									.getAtaque(treinadorDois.getMonstroAtualId(), escolhaAtaqueTreinadorDois - 1)
									.getNome();
						} else {
							danoTreinadorDois = danoTreinadorDois
									* comparaVantagem
											.vantagem(
													treinadorDois.getMonstro()
															.getAtaqueCarregado(treinadorDois.getMonstroAtualId())
															.getTipo().getTipo(),
													treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId())
															.getTipo())
									* comparaVantagem.vantagem(treinadorDois.getMonstro()
											.getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getTipo().getTipo(),
											treinadorUm.getMonstro().getTipoSecundario(treinadorUm.getMonstroAtualId())
													.getTipo());
							nomeAtaqueDois = treinadorDois.getMonstro()
									.getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getNome();
										
									if (treinadorDois.getMonstro().getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getEfeito().getNome().equals("DORMINDO")) {
										int sorteia = aleatorio.nextInt(100) + 1;

										if (sorteia<=50){
											System.out.println("O monstro inimigo esta dormindo...ZZzzz");
											Thread.sleep(1000);
											treinadorUm.getMonstro().setSobEfeito(treinadorUm.getMonstroAtualId(), true);
											treinadorUm.getMonstro().setSobEfeitoRoundTermina(treinadorUm.getMonstroAtualId(), turno+3);
										}else{
											System.out.println("Seu monstro errou o golpe...");
											Thread.sleep(1000);
										}

										
									}
						}
						
						//atacar
						if(treinadorDois.getMonstro().getSobEfeito(treinadorDois.getMonstroAtualId())==true){
							System.out.println("Seu monstro está dormindo e não pôde atacar ZZZzzz");
							trocouDois=1;
						}
						if(treinadorUm.getMonstro().getSobEfeito(treinadorUm.getMonstroAtualId())==true){
							System.out.println("Seu monstro está dormindo e não pôde atacar ZZZzzz");
							trocouUm=1;
						}

						if (trocouUm == 0 && trocouDois == 0) {

							if (treinadorUm.getMonstro().getVelocidade(treinadorUm.getMonstroAtualId()) > treinadorDois.getMonstro().getVelocidade(treinadorDois.getMonstroAtualId())) {
								
								System.out.println(treinadorUm.getMonstro().getNome(treinadorUm.getMonstroAtualId())+ " usou " + nomeAtaqueUm);
								if(escolhaAtaqueTreinadorUm!=4)comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaque(treinadorUm.getMonstroAtualId(),escolhaAtaqueTreinadorUm - 1).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
								else comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId()).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
								
								Thread.sleep(1500);

								if (!treinadorDois.diminuiVida(danoTreinadorUm)) {
									System.out.println(treinadorDois.getMonstro().getNome(treinadorDois.getMonstroAtualId())+ " usou " + nomeAtaqueDois);

									if(escolhaAtaqueTreinadorDois!=4)comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaque(treinadorDois.getMonstroAtualId(),escolhaAtaqueTreinadorDois - 1).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());				
									else comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());

									treinadorUm.diminuiVida(danoTreinadorDois);
									Thread.sleep(1500);
								}
							} else if (treinadorUm.getMonstro().getVelocidade(treinadorUm.getMonstroAtualId()) < treinadorDois.getMonstro().getVelocidade(treinadorDois.getMonstroAtualId())) {
								System.out.println(treinadorDois.getMonstro().getNome(treinadorDois.getMonstroAtualId())+ " usou " + nomeAtaqueDois);
								if(escolhaAtaqueTreinadorDois!=4)comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaque(treinadorDois.getMonstroAtualId(),escolhaAtaqueTreinadorDois - 1).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());				
								else comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());

								Thread.sleep(1500);
								if (!treinadorUm.diminuiVida(danoTreinadorDois)) {
									System.out.println(treinadorUm.getMonstro().getNome(treinadorUm.getMonstroAtualId())+ " usou " + nomeAtaqueUm);
									if(escolhaAtaqueTreinadorUm!=4)comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaque(treinadorUm.getMonstroAtualId(),escolhaAtaqueTreinadorUm - 1).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
									else comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId()).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
								
									treinadorDois.diminuiVida(danoTreinadorUm);
									Thread.sleep(1500);
								}

							} else {
								if (treinadorUm.getMonstro().getForca(treinadorUm.getMonstroAtualId()) > treinadorDois.getMonstro().getForca(treinadorDois.getMonstroAtualId())) {
									System.out.println(treinadorUm.getMonstro().getNome(treinadorUm.getMonstroAtualId())+ " usou " + nomeAtaqueUm);
									if(escolhaAtaqueTreinadorUm!=4)comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaque(treinadorUm.getMonstroAtualId(),escolhaAtaqueTreinadorUm - 1).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
									else comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId()).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
								
									Thread.sleep(1500);
									if (!treinadorDois.diminuiVida(danoTreinadorUm)) {
										System.out.println(treinadorDois.getMonstro().getNome(treinadorDois.getMonstroAtualId())+ " usou " + nomeAtaqueDois);

										if(escolhaAtaqueTreinadorDois!=4)comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaque(treinadorDois.getMonstroAtualId(),escolhaAtaqueTreinadorDois - 1).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());				
										else comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());

										treinadorUm.diminuiVida(danoTreinadorDois);
										Thread.sleep(1500);
									}
								} else if (treinadorUm.getMonstro().getForca(treinadorUm.getMonstroAtualId()) < treinadorDois.getMonstro().getForca(treinadorDois.getMonstroAtualId())) {
									System.out.println(treinadorDois.getMonstro().getNome(treinadorDois.getMonstroAtualId())+ " usou " + nomeAtaqueDois);
									if(escolhaAtaqueTreinadorDois!=4)comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaque(treinadorDois.getMonstroAtualId(),escolhaAtaqueTreinadorDois - 1).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());			
									else comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());

									Thread.sleep(1500);
									if (!treinadorUm.diminuiVida(danoTreinadorDois)) {
										System.out.println(treinadorUm.getMonstro().getNome(treinadorUm.getMonstroAtualId())+ " usou " + nomeAtaqueUm);
										if(escolhaAtaqueTreinadorUm!=4)comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaque(treinadorUm.getMonstroAtualId(),escolhaAtaqueTreinadorUm - 1).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
										else comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId()).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
								
										treinadorDois.diminuiVida(danoTreinadorUm);
										Thread.sleep(1500);
									}
								} else {
									if (treinadorUm.getMonstro().getDefesa(treinadorUm.getMonstroAtualId()) > treinadorDois.getMonstro().getDefesa(treinadorDois.getMonstroAtualId())) {
										System.out.println(treinadorUm.getMonstro().getNome(treinadorUm.getMonstroAtualId())+ " usou " + nomeAtaqueUm);
										if(escolhaAtaqueTreinadorUm!=4)comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaque(treinadorUm.getMonstroAtualId(),escolhaAtaqueTreinadorUm - 1).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
										else comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId()).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
								
										Thread.sleep(1500);
										if (!treinadorDois.diminuiVida(danoTreinadorUm)) {
											System.out.println(treinadorDois.getMonstro().getNome(treinadorDois.getMonstroAtualId()) + " usou " + nomeAtaqueDois);
											if(escolhaAtaqueTreinadorDois!=4)comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaque(treinadorDois.getMonstroAtualId(),escolhaAtaqueTreinadorDois - 1).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());				
											else comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());

											treinadorUm.diminuiVida(danoTreinadorDois);
											Thread.sleep(1500);
										}
									} else if (treinadorUm.getMonstro().getDefesa(treinadorUm.getMonstroAtualId()) < treinadorDois.getMonstro().getDefesa(treinadorDois.getMonstroAtualId())) {
										System.out.println(treinadorDois.getMonstro().getNome(treinadorDois.getMonstroAtualId())+ " usou " + nomeAtaqueDois);
										if(escolhaAtaqueTreinadorDois!=4)comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaque(treinadorDois.getMonstroAtualId(),escolhaAtaqueTreinadorDois - 1).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());				
										else comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());

										Thread.sleep(1500);
										if (!treinadorUm.diminuiVida(danoTreinadorDois)) {
											System.out.println(treinadorUm.getMonstro().getNome(treinadorUm.getMonstroAtualId())+ " usou " + nomeAtaqueUm);
											if(escolhaAtaqueTreinadorUm!=4)comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaque(treinadorUm.getMonstroAtualId(),escolhaAtaqueTreinadorUm - 1).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
											else comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId()).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
								
											Thread.sleep(1500);
											treinadorDois.diminuiVida(danoTreinadorUm);
										}
									} else {
										int valor = aleatorio.nextInt(2) + 1;
										if (valor == 1) {
											System.out.println(treinadorUm.getMonstro().getNome(treinadorUm.getMonstroAtualId())+ " usou " + nomeAtaqueUm);
											if(escolhaAtaqueTreinadorUm!=4)comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaque(treinadorUm.getMonstroAtualId(),escolhaAtaqueTreinadorUm - 1).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
											else comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId()).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
								
											Thread.sleep(1500);
											if (!treinadorDois.diminuiVida(danoTreinadorUm)) {
												System.out.println(treinadorDois.getMonstro().getNome(treinadorDois.getMonstroAtualId()) + " usou " + nomeAtaqueDois);
												if(escolhaAtaqueTreinadorDois!=4)comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaque(treinadorDois.getMonstroAtualId(),escolhaAtaqueTreinadorDois - 1).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());				
												else comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());

												treinadorUm.diminuiVida(danoTreinadorDois);
												Thread.sleep(1500);
											}
										} else {
											System.out.println(treinadorDois.getMonstro().getNome(treinadorDois.getMonstroAtualId()) + " usou " + nomeAtaqueDois);
											if(escolhaAtaqueTreinadorDois!=4)comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaque(treinadorDois.getMonstroAtualId(),escolhaAtaqueTreinadorDois - 1).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());				
											else comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());

											Thread.sleep(1500);
											if (!treinadorUm.diminuiVida(danoTreinadorDois)) {
												System.out.println(treinadorUm.getMonstro().getNome(treinadorUm.getMonstroAtualId()) + " usou " + nomeAtaqueUm);treinadorDois.diminuiVida(danoTreinadorUm);
												if(escolhaAtaqueTreinadorUm!=4)comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaque(treinadorUm.getMonstroAtualId(),escolhaAtaqueTreinadorUm - 1).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
												else comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId()).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
								
												Thread.sleep(1500);
											}
										}
									}
								}

							}
						} else if (trocouUm == 0 && trocouDois == 1) {
							System.out.println(treinadorUm.getMonstro().getNome(treinadorUm.getMonstroAtualId())+ " usou " + nomeAtaqueUm);
							if(escolhaAtaqueTreinadorUm!=4)comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaque(treinadorUm.getMonstroAtualId(),escolhaAtaqueTreinadorUm - 1).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
							else comparaVantagem.imprimeVantagem(treinadorUm.getMonstro().getAtaqueCarregado(treinadorUm.getMonstroAtualId()).getTipo().getTipo(),treinadorDois.getMonstro().getTipo(treinadorDois.getMonstroAtualId()).getTipo());
								
							treinadorDois.diminuiVida(danoTreinadorUm);
						} else {
							System.out.println(treinadorDois.getMonstro().getNome(treinadorDois.getMonstroAtualId())+ " usou " + nomeAtaqueDois);
							if(escolhaAtaqueTreinadorDois!=4)comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaque(treinadorDois.getMonstroAtualId(),escolhaAtaqueTreinadorDois - 1).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());				
							else comparaVantagem.imprimeVantagem(treinadorDois.getMonstro().getAtaqueCarregado(treinadorDois.getMonstroAtualId()).getTipo().getTipo(),treinadorUm.getMonstro().getTipo(treinadorUm.getMonstroAtualId()).getTipo());

							treinadorUm.diminuiVida(danoTreinadorDois);
						}
						vezTreinadorUm = true;
						turno++;
						trocouUm = 0;
						trocouDois = 0;

					}
					if (treinadorDois.getCorreu() == true) {
						vencedor = treinadorUm;
						acabou = 1;
					}

					if (treinadorDois.getDerrotado() == true) {
						vencedor = treinadorUm;
						acabou = 1;
					}

					if (treinadorUm.getCorreu() == true) {
						vencedor = treinadorDois;
						acabou = 1;
					}

					if (treinadorUm.getDerrotado() == true) {
						vencedor = treinadorDois;
						acabou = 1;
					}

				} while (acabou == 0);
				System.out.println("\n\nParabéns treinador " + vencedor.getNome()
						+ " você foi o grande vencedor!! \nEssa é sua equipe da vitória ---> ");
				vencedor.getMonstro().imprime();
				System.out.println(" Sua equipe teve um desempenho excelente!\nAperte enter para voltar ao menu: ");
				System.in.read();
			}
		}while (navegacaoMenu != 3);

		leitura.close();
	}
}