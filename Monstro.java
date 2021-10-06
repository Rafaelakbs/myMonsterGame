public class Monstro {
    private int[] id;
    private String[] nome;
    private TipoElemento[] tipo;
    private TipoElemento[] tipoSecundario;
    private double[] vida;
    private double[] forca;
    private double[] defesa;
    private double[] velocidade;
    private Ataque[][] ataques;
    private AtaqueCarregado[] ataqueCarregado;
    private int[] ataqueCarregadoEnergia;
    private double[] vidaMax;
    private int pos = 0;
    private int limiteMonstro = 18;
    private boolean[] sobEfeito;
    private int[] sobEfeitoRoundTermina;

    public Monstro() {
        this.id = new int[this.limiteMonstro];
        this.nome = new String[this.limiteMonstro];
        this.tipo = new TipoElemento[this.limiteMonstro];
        this.tipoSecundario = new TipoElemento[this.limiteMonstro];
        this.vida = new double[this.limiteMonstro];
        this.forca = new double[this.limiteMonstro];
        this.defesa = new double[this.limiteMonstro];
        this.velocidade = new double[this.limiteMonstro];
        this.ataques = new Ataque[this.limiteMonstro][3];
        this.vidaMax = new double[this.limiteMonstro];
        this.ataqueCarregado = new AtaqueCarregado[this.limiteMonstro];
        this.ataqueCarregadoEnergia = new int[this.limiteMonstro];
        this.sobEfeito = new boolean[this.limiteMonstro];
        this.sobEfeitoRoundTermina = new int[this.limiteMonstro];
        this.sobEfeito[this.pos] = false;
        this.sobEfeitoRoundTermina[this.pos]=0;

    }

    public void add(int id, String nome, TipoElemento tipo, TipoElemento tipoSecundario, double vida, double forca,
            double defesa, double velocidade, Ataque ataqueZero, Ataque ataqueUm, Ataque ataqueDois,
            AtaqueCarregado ataqueCarregado) {
        this.id[this.pos] = id;
        this.nome[this.pos] = nome;
        this.tipo[this.pos] = tipo;
        this.tipoSecundario[this.pos] = tipoSecundario;
        this.vida[this.pos] = vida;
        this.forca[this.pos] = forca;
        this.defesa[this.pos] = defesa;
        this.velocidade[this.pos] = velocidade;
        this.ataques[this.pos][0] = ataqueZero;
        this.ataques[this.pos][1] = ataqueUm;
        this.ataques[this.pos][2] = ataqueDois;
        this.vidaMax[this.pos] = vida;
        this.ataqueCarregado[this.pos] = ataqueCarregado;
        this.ataqueCarregadoEnergia[this.pos] = ataqueCarregado.getEnergia();
        this.pos++;
    }
    public boolean getSobEfeito(int i){
        return this.sobEfeito[i];
    }
    public void setSobEfeito(int i,boolean op){
        this.sobEfeito[i] = op;
    }

    public int getSobEfeitoRoundTermina(int i){
        return this.sobEfeitoRoundTermina[i];
    }
    public void setSobEfeitoRoundTermina(int i, int round){
        this.sobEfeitoRoundTermina[i]=round;
    }
    public int getId(int i) {
        return this.id[i];
    }

    public String getNome(int i) {
        return this.nome[i];
    }

    public TipoElemento getTipo(int i) {
        return this.tipo[i];
    }

    public TipoElemento getTipoSecundario(int i) {
        return this.tipoSecundario[i];
    }

    public double getForca(int i) {
        return this.forca[i];
    }

    public double getDefesa(int i) {
        return this.defesa[i];
    }

    public double getVelocidade(int i) {
        return this.velocidade[i];
    }

    // Métodos relacionados ao estado do pokémon
    public double getVida(int i) {
        return this.vida[i];
    }

    public double getVidaMax(int i) {
        return this.vidaMax[i];
    }

    public int getPos() {
        return this.pos;
    }

    // Métodos relacionados aos ataques do pokémon
    public Ataque getAtaque(int i, int num) {
        return this.ataques[i][num];
    }

    public AtaqueCarregado getAtaqueCarregado(int i) {
        return this.ataqueCarregado[i];
    }

    public int getAtaqueCarregadoEnergia(int i){
        return this.ataqueCarregadoEnergia[i];
    }
    public void setAtaqueCarregadoEnergia(int i, int energia){
        this.ataqueCarregadoEnergia[i]=energia;
    }

    public Ataque[] getListaAtk(int i) {
        return this.ataques[i];
    }

    public double getDanoAtual(int i, int num) {
        return this.ataques[i][num].getDano();
    }

    public void imprimeAtaques(int i) {
        System.out.println("1 - " + this.ataques[i][0].getNome() + "\t2 - " + this.ataques[i][1].getNome() + "3 - "
                + this.ataques[i][2].getNome() + "\t4 - " + this.ataqueCarregado[i].getNome());

    }

    public void imprime() {
        System.out.println(String.format("%3s  %1s  %13s %7s %1s %12s %5s","ID","|","Nome","","|","Tipo","")+
        "\n-----|------------------------|----------------------");
        
        for (int i = 0; i < this.pos; i++) {
            
            
            System.out.printf(String.format("%3s  %1s  %-21s %1s %8s ", this.id[i], "|", this.nome[i],"|",this.tipo[i].getTipo()));
            if(this.tipoSecundario[i].getTipo().equals("")==false){
                System.out.printf(String.format("%-1s %-9s ", "/",this.tipoSecundario[i].getTipo()));  
            }
            System.out.printf("\n");
        }
        
    }

    public void imprimeByIndice(int i) {
        System.out.println(String.format("%3s  %1s  %21s %1s %2s %1s %10s %1s %-10s", i, "|", this.nome[i],"|",this.vida[i],"|",this.tipo[i].getTipo(),"/",this.tipoSecundario[i].getTipo()));
    }

    public void setVida(int indice, double novaVida) {
        if( novaVida <= 0.0 )
            novaVida = 0.0;
        
        this.vida[indice] = novaVida;
    }
    
}


