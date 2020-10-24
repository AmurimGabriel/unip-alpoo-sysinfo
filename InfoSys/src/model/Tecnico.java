package model;

import dao.TecnicoDAO;

public class Tecnico {

    private int codigo;
    private String nome;
    private double salario;
    private double valorHora;

    public Tecnico() {
    }

    public Tecnico(String nome, double salario, double valorHora) {
        setNome(nome);
        setSalario(salario);
        setValorHora(valorHora);

        gravar();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "codigo=" + codigo +
                ", nome='" + nome + '\'' +
                ", salario=" + salario +
                ", valorHora=" + valorHora +
                '}';
    }

    public void gravar() {
        int codigo = new TecnicoDAO().create(this);

        if (codigo > 0)
            setCodigo(codigo);
    }
}
