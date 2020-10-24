package model;

import dao.ProdutoDAO;

public class Produto {

    private int codigo;
    private String descricao;
    private int estoque;
    private boolean ativo;
    private double venda;
    private double custo;

    public Produto(String descricao, int estoque, boolean ativo, double venda, double custo) {
        setDescricao(descricao);
        setEstoque(estoque);
        setAtivo(ativo);
        setVenda(venda);
        setCusto(custo);

        gravar();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
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

    public void gravar() {
        int codigo = new ProdutoDAO().create(this);

        if (codigo > 0)
            setCodigo(codigo);
    }
}
