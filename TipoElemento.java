public class TipoElemento {

    private int valor;
    private String tipo;

    public TipoElemento() {

    }

    public TipoElemento(int valor, String tipo) {
        this.valor = valor;
        this.tipo = tipo;
    }

    public String getTipo() {
        return this.tipo;
    }

    public double vantagem(String tipoAtaque, String tipoDefesa) {
        double valorVantagem = 1;

        switch (tipoAtaque) {
            case "AGUA":
                if (tipoDefesa.equals("FOGO"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("TERRA"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("PEDRA"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("PLANTA"))
                    valorVantagem = 0.5;
                else
                    valorVantagem = 1;
                break;
            case "FOGO":
                if (tipoDefesa.equals("PLANTA"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("TERRA"))
                    valorVantagem = 0.5;
                if (tipoDefesa.equals("PEDRA"))
                    valorVantagem = 0.5;
                if (tipoDefesa.equals("AGUA"))
                    valorVantagem = 0.5;
                else
                    valorVantagem = 1;
                break;
            case "TERRA":
                if (tipoDefesa.equals("FOGO"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("PEDRA"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("AGUA"))
                    valorVantagem = 0.5;
                if (tipoDefesa.equals("PLANTA"))
                    valorVantagem = 0.5;
                else
                    valorVantagem = 1;
                break;
            case "LUTADOR":
                if (tipoDefesa.equals("NORMAL"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("PEDRA"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("SOMBRIO"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("FADA"))
                    valorVantagem = 0.5;
                if (tipoDefesa.equals("PSIQUICO"))
                    valorVantagem = 0.5;
                if (tipoDefesa.equals("DRAGAO"))
                    valorVantagem = 0.5;
                else
                    valorVantagem = 1;
                break;
            case "SOMBRIO":
                if (tipoDefesa.equals("FANTASMA"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("PSIQUICO"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("FADA"))
                    valorVantagem = 0.5;
                if (tipoDefesa.equals("LUTADOR"))
                    valorVantagem = 0.5;
                else
                    valorVantagem = 1;
                break;
            case "FANTASMA":
                if (tipoDefesa.equals("FANTASMA"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("PSIQUICO"))
                    valorVantagem = 2;
              
                if (tipoDefesa.equals("SOMBRIO"))
                    valorVantagem = 0.5;
                else
                    valorVantagem = 1;
                break;
            case "DRAGAO":
                if (tipoDefesa.equals("DRAGAO"))
                    valorVantagem = 2;
             
                if (tipoDefesa.equals("FADA"))
                    valorVantagem = 0.5;
                else
                    valorVantagem = 1;
                break;
            case "FADA":
                if (tipoDefesa.equals("DRAGAO"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("LUTADOR"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("SOMBRIO"))
                    valorVantagem = 2;
                else
                    valorVantagem = 1;
                break;
            case "PLANTA":
                if (tipoDefesa.equals("AGUA"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("PEDRA"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("NORMAL"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("FOGO"))
                    valorVantagem = 0.5;
                if (tipoDefesa.equals("DRAGAO"))
                    valorVantagem = 0.5;
                else
                    valorVantagem = 1;
                break;
            case "PSIQUICO":
                if (tipoDefesa.equals("LUTADOR"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("SOMBRIO"))
                    valorVantagem = 0.5;
                if (tipoDefesa.equals("PSIQUICO"))
                    valorVantagem = 0.5;
                else
                    valorVantagem = 1;
                break;
            case "NORMAL":
                if (tipoDefesa.equals("LUTADOR"))
                    valorVantagem = 0.5;
                else
                    valorVantagem = 1;
                break;
            case "PEDRA":
                if (tipoDefesa.equals("FOGO"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("DRAGAO"))
                    valorVantagem = 2;
                if (tipoDefesa.equals("AGUA"))
                    valorVantagem = 0.5;
                if (tipoDefesa.equals("LUTADOR"))
                    valorVantagem = 0.5;
                if (tipoDefesa.equals("PLANTA"))
                    valorVantagem = 0.5;
                if (tipoDefesa.equals("TERRA"))
                    valorVantagem = 0.5;
                else
                    valorVantagem = 1;
                break;

            default:
                valorVantagem = 1;
                break;
        }

        return valorVantagem;
    }

    public void imprimeVantagem(String tipoAtaque, String tipoDefesa) throws InterruptedException {
       

        switch (tipoAtaque) {
            case "AGUA":
                if (tipoDefesa.equals("FOGO")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);

                }
                if (tipoDefesa.equals("TERRA")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);

                }
                if (tipoDefesa.equals("PEDRA")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);

                }
                if (tipoDefesa.equals("PLANTA")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);

                }

                break;
            case "FOGO":
                if (tipoDefesa.equals("PLANTA")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("TERRA")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("PEDRA")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("AGUA")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }

                break;
            case "TERRA":
                if (tipoDefesa.equals("FOGO")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("PEDRA")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("AGUA")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("PLANTA")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }

                break;
            case "LUTADOR":
                if (tipoDefesa.equals("NORMAL")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("PEDRA")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("SOMBRIO")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("FADA")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("PSIQUICO")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("DRAGAO")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }

                break;
            case "SOMBRIO":
                if (tipoDefesa.equals("FANTASMA")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("PSIQUICO")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("FADA")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("LUTADOR")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }

                break;
            case "FANTASMA":
                if (tipoDefesa.equals("FANTASMA")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("PSIQUICO")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
               
                if (tipoDefesa.equals("SOMBRIO")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }

                break;
            case "DRAGAO":
                if (tipoDefesa.equals("DRAGAO")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("FADA")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }

                break;
            case "FADA":
                if (tipoDefesa.equals("DRAGAO")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("LUTADOR")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("SOMBRIO")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }

                break;
            case "PLANTA":
                if (tipoDefesa.equals("AGUA")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("PEDRA")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("NORMAL")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("FOGO")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("DRAGAO")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }

                break;
            case "PSIQUICO":
                if (tipoDefesa.equals("LUTADOR")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("SOMBRIO")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("PSIQUICO")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }

                break;
            case "NORMAL":
                if (tipoDefesa.equals("LUTADOR")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }

                break;
            case "PEDRA":
                if (tipoDefesa.equals("FOGO")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("DRAGAO")) {
                    System.out.println("O GOLPE FOI SUPER EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("AGUA")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("LUTADOR")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("PLANTA")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }
                if (tipoDefesa.equals("TERRA")) {
                    System.out.println("O GOLPE NÃO FOI MUITO EFETIVO");
                    Thread.sleep(1000);
                }

                break;

            default:

                break;
        }
    }

}
