package br.com.helderrangel.pousadamineira;

import java.time.LocalDate;

public class Hospede extends Pessoa {
    private double avaliacaoAcomodacao;

    public Hospede(int id, Cpf cpf, String nome, LocalDate dataNascimento, String telefone, String email, double avaliacaoAcomodacao) {
        super(id, cpf, nome, dataNascimento, telefone, email);
        setAvaliacaoAcomodacao(avaliacaoAcomodacao);
    }

    public double getAvaliacaoComunidade() {
        return this.avaliacaoAcomodacao;
    }

    public final void setAvaliacaoAcomodacao(double avaliacaoAcomodacao) {
        if (avaliacaoAcomodacao < 0 || avaliacaoAcomodacao > 5.0) {
            throw new IllegalArgumentException("Avaliação deve ser um valor positivo entre 0.0 e 5.0");
        }

        this.avaliacaoAcomodacao = avaliacaoAcomodacao;
    }
}
