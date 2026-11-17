package br.com.helderrangel.pousadamineira;

import java.time.LocalDate;

public class Anfitriao extends Pessoa{
    double avaliacaoHospede;

    public Anfitriao(){}

    public Anfitriao(Long id, String cpf, String nome, LocalDate dataNascimento, String telefone, String email, double avaliacaoHospede){
        super(id, cpf, nome, dataNascimento, telefone, email);
        this.avaliacaoHospede = avaliacaoHospede;
    }

    public double getAvaliacaoHospede() {
        return avaliacaoHospede;
    }

    public void setAvaliacaoHospede(double avaliacaoHospede) {
        this.avaliacaoHospede = avaliacaoHospede;
    }
}
