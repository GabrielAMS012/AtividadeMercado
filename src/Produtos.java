import java.math.BigDecimal;
import java.util.Objects;

public class Produtos extends ListaProdutos {

    String nome, resposta;
    BigDecimal valor;
    Integer qntd;


    public Produtos(String nome) {
        this.nome = nome;
        this.valor = BigDecimal.ZERO;
    }

    public Produtos() {
    }

    public Produtos(String nome, BigDecimal valor, Integer qntd) {
        this.nome = nome;
        this.valor = valor;
        this.qntd = qntd;
    }

    public void criaLista(){
        this.criaListaNome();
        this.criaListaPreco();
        this.criaListaQntd();
    }

    public void cadProd(){
        this.cadastraProd();
        this.adicionaProd(n,x,y);
    }

    public void consultaProd() {
        while (true) {
            try {
                this.pergunta();
                this.mostraProd(nm);
                break;
            } catch (Exception e) {
                System.out.println("\nO produto não existe\n");
            }
        }
    }


    public void op() {
        this.criaLista();
        do {
            do {
                System.out.println("Qual operação você gostaria de fazer?\n1.Consulta\n2.Cadastro\n3.Encerrar operação");
                this.setResposta(scanner.nextLine());
            } while (this.getResposta().equals("1") && this.getResposta().equals("2") && this.getResposta().equals("3"));

            if (this.getResposta().equals("1")) {
                this.consultaProd();
            } else if (this.getResposta().equals("2")) {
                this.cadProd();
            }
        }while(!this.getResposta().equals("3"));
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQntd() {
        return qntd;
    }

    public void setQtd(Integer qntd) {
        this.qntd = qntd;
    }
}
