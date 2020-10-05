package model;

public class Produto {

    private String descricao;
    private int estoque;
    private boolean ativo;
    private double venda;
    private double custo;

    public Produto(String descricao, int estoque, boolean ativo, double venda, double custo) {
        this.descricao = descricao;
        this.estoque = estoque;
        this.ativo = ativo;
        this.venda = venda;
        this.custo = custo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public double getVenda() {
        return venda;
    }

    public void setVenda(double venda) {
        this.venda = venda;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    @Override
    public String toString() {
        String ret = (isAtivo()) ? "[ATIVO] - " : "[FORA DE LINHA] - ";

        return ret + "[Item: " + getDescricao() + " ] - " +
                    "[Estoque: " + getEstoque() + " ] - " +
                    "[Custo: " + getCusto() + " ] - " +
                    "[Preço de Venda: " + getVenda() + " ]";
    }
}
