public enum Efeito {
    INCENDIADO(0,"INCENDIADO","A CRIATURA ALVO ENTRA EM CHAMAS POR 1-4 ROUNDS, RECEBE 1-5 DE DANO EM CADA UM DOS ROUNDS.",50),
    ENVENENADO(1,"ENVENENADO","A CRIATURA ALVO ESTA ENVENENADA POR 1-3 ROUNDS, RECEBE 3-8 DE DANO EM CADA UM DOS ROUNDS.",65),
    ATORDOADO(2,"ATORDOADO"," A CRIATURA ALVO ESTÁ MUITO CONFUSA, ELA TEM 50% DE CHANCE DE NAO CONSEGUIR ATACAR, ESSE EFEITO DURA 1-3 ROUNDS.",60),
    DORMINDO(3,"DORMINDO"," A CRIATURA ALVO NÃO PODE ATACAR POR 3-5 ROUNDS(O EFEITO NAO TERMINA MESMO QUE O MONSTRO RETORNE A BOLSA)",85),
    NULO(4,"NULO","",100);
    public int id;
    public String nome;
    public String descricao;
    public double chanceAcontecer;

    private Efeito(int id,String nome,String descricao,double chanceAcontecer) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.chanceAcontecer = chanceAcontecer;
    }
    public String getNome(){
        return this.nome;
    }
}
