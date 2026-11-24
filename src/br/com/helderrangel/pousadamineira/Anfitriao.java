package br.com.helderrangel.pousadamineira;

import java.time.LocalDate;

public class Anfitriao extends Pessoa{
    double avaliacaoHospede;

    public Anfitriao(){}

    public Anfitriao(int id, Cpf cpf, String nome, LocalDate dataNascimento, String telefone, String email, double avaliacaoHospede){
        super(id, cpf, nome, dataNascimento, telefone, email);
        this.avaliacaoHospede = avaliacaoHospede;
    }

    public double getAvaliacaoHospede() {
        return avaliacaoHospede;
    }

    public void setAvaliacaoHospede(double avaliacaoHospede) {
        if (avaliacaoHospede < 0 || avaliacaoHospede > 5.0) {
            throw new IllegalArgumentException("Avaliação deve ser um valor positivo entre 0.0 e 5.0");
        }
        this.avaliacaoHospede = avaliacaoHospede;
    }
}
