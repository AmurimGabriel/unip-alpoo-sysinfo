package model;

import dao.ClienteDAO;

public class Cliente {

    private int codigo;
    private String nome;
    private String cpf;
    private String fone;
    private String celular;
    private String email;

    public Cliente(String nome, String cpf, String fone, String celular, String email) {
        setNome(nome);
        setCpf(cpf);
        setFone(fone);
        setCelular(celular);
        setEmail(email);

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente..: [" + getNome() + "]\n" +
                "CPF......: [" + getCpf() + "]\n" +
                "TELEFONE.: [" + getFone() + "]\n" +
                "CELULAR..: [" + getCelular() + "]\n" +
                "EMAIL....: [" + getEmail() + "]\n";
    }

    public void gravar() {
        int codigo = new ClienteDAO().create(this);

        if (codigo > 0)
            setCodigo(codigo);
    }
}
