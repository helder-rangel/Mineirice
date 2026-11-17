package br.com.helderrangel.pousadamineira;

import java.time.LocalDate;

public class Hospede extends Pessoa {
    double avaliacaoComunidade;

    public Hospede() {
        super();
    }

    public Hospede(Long id, String cpf, String nome, LocalDate dataNascimento, String telefone, String email, double avaliacaoComunidade) {
        super(id, cpf, nome, dataNascimento, telefone, email);
        this.avaliacaoComunidade = avaliacaoComunidade;

    }

    public double getAvaliacaoComunidade() {
        return avaliacaoComunidade;
    }

    public void setAvaliacaoComunidade(double avaliacaoComunidade) {
        this.avaliacaoComunidade = avaliacaoComunidade;
    }
}
