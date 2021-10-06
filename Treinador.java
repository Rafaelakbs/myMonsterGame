import java.util.Scanner;

public class Treinador {
	private String nome;
	private Monstro monstro;
	private int monstroAtualId; // indice da lista de monstros do treinador
	private boolean correu;
	private boolean derrotado;
	

	public Treinador() {

		this.correu = false;
		this.derrotado = false;
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// Métodos relacionados aos monstros do treinador
	public Monstro getMonstro() {
		return this.monstro;
	}

	public void setMonstro(Monstro monstro) {
		this.monstro = monstro;
		this.monstroAtualId = 0;
	}

	public int getMonstroAtualId() {
		return this.monstroAtualId;
	}
	public boolean getCorreu(){
		return this.correu;
	}
	public boolean getDerrotado(){
		return this.derrotado;
	}

	
	public int mudaMonstroAtual() {
			if (!imprimeMonstro())
				
				return 0;
			int erro = 0;
			int i = 0;
			int retorno = 0;
			if(temMonstroVivo()){
			do {
				erro = 0;
				
				System.out.println("Escolhe monstro da lista     -> Para voltar use a tecla 8");
				Scanner sc = new Scanner(System.in);
				 i = sc.nextInt();
	
				if(i!=8){
					if (i >= 3 || i < 0) {
						System.out.println("Escolha invalida");
						erro = 1;
					}
					if (monstro.getVida(i) <= 0) {
						System.out.println("Monstro Derrotado [" + this.monstro.getNome(i) + "]");
						erro = 1;
					}
				
				System.out.println("Monstro escolhido :" + this.monstro.getNome(i));
				this.monstroAtualId = i;
				retorno = 0;
				}
			
		} while (erro != 0);
		if (i==8) {
			retorno = 1;
		}
		}
		return retorno;
		}
		
		public void mudaMonstroAtualSemVolta() {
			if (!imprimeMonstro())
				return;
			int erro = 0;
			int i = 0;
			
			if(temMonstroVivo()){
			do {
				erro = 0;
				System.out.println("Escolhe monstro da lista   ");
				Scanner sc = new Scanner(System.in);
				 i = sc.nextInt();
				
					if (i >= 3 || i < 0) {
						System.out.println("Escolha invalida");
						erro = 1;
					}
					if (monstro.getVida(i) <= 0) {
						System.out.println("Monstro Derrotado [" + this.monstro.getNome(i) + "]");
						erro = 1;
					}
				
				System.out.println("Monstro escolhido :" + this.monstro.getNome(i));
				this.monstroAtualId = i;
				
				
		} while (erro != 0);
		
		}
		
		}

	public boolean temMonstroVivo() {
		boolean tem = false;
		for (int i = 0; i < 3; i++) {
			if (this.getMonstro().getVida(i) > 0)
				tem = true;
		}
		if(tem==false)this.derrotado=true;

		return tem;
	}

	public boolean imprimeMonstro() {
		if (!temMonstroVivo())
			return false;

		for (int i = 0; i < 3; i++) {
			if (this.monstroAtualId == i)
				continue;

			this.monstro.imprimeByIndice(i);
		}

		return true;
	}
	public void diminuiEnergia(){
		
		
		this.getMonstro().setAtaqueCarregadoEnergia(this.getMonstroAtualId(), this.getMonstro().getAtaqueCarregadoEnergia(this.getMonstroAtualId())-1);
	}
	public boolean diminuiVida(double dano) throws InterruptedException {
		boolean morreu = false;
		this.getMonstro().setVida(this.getMonstroAtualId(), this.getMonstro().getVida(this.getMonstroAtualId()) - dano);
		System.out.println("Dano causado: "+Math.round(dano));
		Thread.sleep(1000);
		if (this.getMonstro().getVida(this.getMonstroAtualId()) <= 0) {
			System.out.println(this.getMonstro().getNome(this.getMonstroAtualId())+ " foi desmaiado.Escolha outro para substitui-lo:");
			mudaMonstroAtualSemVolta();
			morreu = true;
		}
		return morreu;
	}

	public void escolhaMonstro(Treinador treinador, Monstro listaMonstro) throws InterruptedException {
        int i = 0;
        int escolhaMonstro = 0;
        int error = 0;
        int errorRepetePrimeiraEscolha = 0;
        String nomeTreinador;
        Monstro escolhaTreinador = new Monstro();

        Scanner sc = new Scanner(System.in);
        for ( i = 0; i < 50; ++i) System.out.println();
        System.out.println("Digite seu nome de treinador!!");
        nomeTreinador = sc.next();
        treinador.setNome(nomeTreinador);
        for ( i = 0; i < 50; ++i) System.out.println();
        System.out.println(">>> Atenção treinador "+nomeTreinador+". Faça suas escolhas! <<<");

        for (int j = 0; j < 3; j++) {

            do {
                errorRepetePrimeiraEscolha = 0;

                do {
                    error = 0;
                    listaMonstro.imprime();
                    System.out.println("Faça sua " + (j + 1) + "ª escolha\n");
                    System.out.println("RESPOSTA: ");

                    escolhaMonstro = sc.nextInt();

                    if(escolhaMonstro<0||escolhaMonstro>=listaMonstro.getPos()){
                        System.out.println("Monstro inválido.");
                        Thread.sleep(1000);
                        for ( i = 0; i < 50; ++i) System.out.println();
                        error=1;
                    }

                } while (error == 1);

                if (j == 0) {
                    escolhaTreinador.add(listaMonstro.getId(escolhaMonstro), listaMonstro.getNome(escolhaMonstro),
                            listaMonstro.getTipo(escolhaMonstro), listaMonstro.getTipoSecundario(escolhaMonstro),
                            listaMonstro.getVida(escolhaMonstro), listaMonstro.getForca(escolhaMonstro),
                            listaMonstro.getDefesa(escolhaMonstro), listaMonstro.getVelocidade(escolhaMonstro),
                            listaMonstro.getAtaque(escolhaMonstro, 0), listaMonstro.getAtaque(escolhaMonstro, 1),
                            listaMonstro.getAtaque(escolhaMonstro, 2), listaMonstro.getAtaqueCarregado(escolhaMonstro));

                } else if (j == 1) {
                    if (escolhaMonstro == escolhaTreinador.getId(0)) {
                        System.out.println("\nVocê já selecionou esse monstro\nSelecione novamente, por favor\n");
                        Thread.sleep(1000);
                        for ( i = 0; i < 50; ++i){System.out.println();};
                        

                        errorRepetePrimeiraEscolha = 1;
                    } else {
                        escolhaTreinador.add(listaMonstro.getId(escolhaMonstro), listaMonstro.getNome(escolhaMonstro),
                                listaMonstro.getTipo(escolhaMonstro), listaMonstro.getTipoSecundario(escolhaMonstro),
                                listaMonstro.getVida(escolhaMonstro), listaMonstro.getForca(escolhaMonstro),
                                listaMonstro.getDefesa(escolhaMonstro), listaMonstro.getVelocidade(escolhaMonstro),
                                listaMonstro.getAtaque(escolhaMonstro, 0), listaMonstro.getAtaque(escolhaMonstro, 1),
                                listaMonstro.getAtaque(escolhaMonstro, 2),
                                listaMonstro.getAtaqueCarregado(escolhaMonstro));
                    }
                } else if (j == 2) {
                    if (escolhaMonstro == escolhaTreinador.getId(0) || escolhaMonstro == escolhaTreinador.getId(1)) {
                        System.out.println("\nVocê já selecionou esse monstro\nSelecione novamente, por favor\n");
                        Thread.sleep(1000);
                        for ( i = 0; i < 50; ++i) System.out.println();

                        errorRepetePrimeiraEscolha = 1;
                    } else {
                        escolhaTreinador.add(listaMonstro.getId(escolhaMonstro), listaMonstro.getNome(escolhaMonstro),
                                listaMonstro.getTipo(escolhaMonstro), listaMonstro.getTipoSecundario(escolhaMonstro),
                                listaMonstro.getVida(escolhaMonstro), listaMonstro.getForca(escolhaMonstro),
                                listaMonstro.getDefesa(escolhaMonstro), listaMonstro.getVelocidade(escolhaMonstro),
                                listaMonstro.getAtaque(escolhaMonstro, 0), listaMonstro.getAtaque(escolhaMonstro, 1),
                                listaMonstro.getAtaque(escolhaMonstro, 2),
                                listaMonstro.getAtaqueCarregado(escolhaMonstro));
                    }
                }
            } while (errorRepetePrimeiraEscolha == 1);

        }

        escolhaTreinador.imprime();
        treinador.setMonstro(escolhaTreinador);
        Thread.sleep(1500);
        for ( i = 0; i < 50; ++i) System.out.println();
        //sc.close();
        
    }


	// Métodos relacionados a fuga ou derrota do treinador

	public void corre() {

		this.correu = true;
	}

	public boolean ativo() {
		return !this.correu && !this.derrotado ? true : false;
	}

	public void ataques() {

		System.out.println("\n");

		System.out.println(
				"|------------------------------------------------------------------------------------------------------------|");
		System.out.printf(String.format("%5s %-22s %-7s %-9s %5s %4s %-22s %-7s %-9s %11s", "|1 - ",
				this.getMonstro().getAtaque(this.getMonstroAtualId(), 0).getNome(), " Tipo: ",
				this.getMonstro().getAtaque(this.getMonstroAtualId(), 0).getTipo().getTipo(), "  |  ", "2 - ",
				this.getMonstro().getAtaque(this.getMonstroAtualId(), 1).getNome(), " Tipo: ",
				this.getMonstro().getAtaque(this.getMonstroAtualId(), 1).getTipo().getTipo(), "|"));
		System.out.printf("\n");
		System.out.printf(String.format("%5s %-22s %-7s %-9s %5s %4s %-22s %-7s %-9s %6s %2d %1s", "|3 - ",
				this.getMonstro().getAtaque(this.getMonstroAtualId(), 2).getNome(), " Tipo: ",
				this.getMonstro().getAtaque(this.getMonstroAtualId(), 2).getTipo().getTipo(), "  |  ", "4 - ",
				this.getMonstro().getAtaqueCarregado(this.getMonstroAtualId()).getNome(), " Tipo: ",
				this.getMonstro().getAtaqueCarregado(this.getMonstroAtualId()).getTipo().getTipo(), " PP: ",
				this.getMonstro().getAtaqueCarregadoEnergia(this.getMonstroAtualId()), "|"));
		System.out.println(
				"\n|------------------------------------------------------------------------------------------------------------|");

	}
}
