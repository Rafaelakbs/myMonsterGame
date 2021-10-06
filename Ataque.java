public class Ataque {
    private String nome;
    private TipoElemento tipo;
	private double dano;
   
   
	public Ataque(String nome,TipoElemento tipo, double dano){
		this.nome = nome;
        this.tipo = tipo;
		this.dano = dano;
      
	}
	public String getNome(){
		return nome;
    }
    public TipoElemento getTipo(){
        return tipo;
    }
    public double getDano(){
        return dano;
    }
   
}