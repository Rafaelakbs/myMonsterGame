public class AtaqueCarregado extends Ataque{
    private int energia;
    
    private Efeito efeito;
	
    AtaqueCarregado(String nome,TipoElemento tipo, int dano, int energia, Efeito efeito){
        super(nome, tipo, dano);
        this.energia = energia;
        this.efeito = efeito;
    }

    public int getEnergia(){
        return this.energia;
    }
    public void setEnergia(int energia){
        this.energia = energia;

    }
    public Efeito getEfeito(){
        return this.efeito;
    }
    
    
}
