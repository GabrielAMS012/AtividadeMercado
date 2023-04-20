import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class ListaProdutos extends ClearBuffer{

    boolean result;
    int qntdProdAdd = 0, y;
    String nm, n;
    float x;
    Scanner scanner = new Scanner(System.in);
    List<Produtos> produtos = new ArrayList<>();

    public void mostraListaProd(){
        for (Produtos produto : produtos) {
            System.out.println("." + produto.getNome());
        }
    }
    public void criaListaQntd(){
        String qtd = ("2;1;4;2;7");
        List<String> qntdProdStr = Arrays.asList(qtd.split(";"));
        List<Integer> qntdProd = qntdProdStr.stream().map(Integer::new).collect(Collectors.toList());

        for (int i = 0; i < qntdProd.size(); i++) {
            produtos.get(i + getQntdProdAdd()).setQtd(qntdProd.get(i));
        }
    }

    public void criaListaNome() {

        String nomeProd = ("SHAMPOO;SODA;ARROZ;FEIJÃO;SABONETE");

        List<String> nomes = Arrays.asList(nomeProd.split(";"));

        nomes.forEach(nome -> {
            produtos.add(new Produtos(nome));
        });

    }
    public void criaListaPreco(){

        String precoProd = ("10.95;5.50;12.45;8.50;2.48");

        List<String> list = Arrays.asList(precoProd.split(";"));
        List<BigDecimal> precos = list.stream().map(BigDecimal::new).collect(Collectors.toList());

        for (int i = 0; i < precos.size(); i++) {
            produtos.get(i + getQntdProdAdd()).setValor(precos.get(i));
        }

    }

    public void pergunta() {

        System.out.println("Sobre qual produto você gostaria de obter as informações?");
        this.mostraListaProd();
        nm = scanner.nextLine().toUpperCase();

    }

    public void mostraProd(String nm){

        Produtos produto = produtos.stream()
                .filter(e -> e.getNome().equals(nm))
                .findFirst().get();
        if(produto.getQntd() > 0) {
            System.out.println("\n" + produto.getNome() + " está custando R$ " + produto.getValor() + "\nQuantidade em "
                    + "estoque: " + produto.getQntd() + "\n");
        }else{
            System.out.println("\n" + produto.getNome() + " está custando R$ " + produto.getValor() +
                    "\nProduto fora de estoque\n");
        }

    }

    public void verificaLista() {
        result = false;
        for (int i = 0; i < this.produtos.size(); i++) {
            if (produtos.get(i).getNome().equals(n)) {
                System.out.println("\nProduto já existe\n");
                result = true;
                break;
            }
        }
    }
    public void cadastraProd(){

        while(true) {
            try {
                do {
                    System.out.println("\nInsira o nome do produto");
                    n = scanner.nextLine().toUpperCase();
                    verificaLista();
                }while(result);
                break;
            } catch (Exception e) {
                clearBuffer(scanner);
                System.out.println("Nome inválido");
            }
        }

        while(true) {
            try {
                System.out.println("\nInsira o valor do produto");
                x = scanner.nextFloat();
                clearBuffer(scanner);
                break;
            } catch (Exception e) {
                clearBuffer(scanner);
                System.out.println("\nValor inválido\n");
            }
        }

        while(true){
            try{
                System.out.println("\nQual a quantidade no estoque?");
                y = scanner.nextInt();
                clearBuffer(scanner);
                break;
            }catch(Exception e){
                clearBuffer(scanner);
                System.out.println("\nValor inválido\n");
            }
        }
    }

    public void adicionaProd(String n, float x, int y){

        produtos.add(new Produtos(n, BigDecimal.valueOf(x).setScale(2, RoundingMode.HALF_EVEN), y));
        setQntdProdAdd(getQntdProdAdd() + 1);
        System.out.println("\nProduto adicionado\n");
    }

    public int getQntdProdAdd() {
        return qntdProdAdd;
    }

    public void setQntdProdAdd(int qntdProdAdd) {
        this.qntdProdAdd = qntdProdAdd;
    }
}
