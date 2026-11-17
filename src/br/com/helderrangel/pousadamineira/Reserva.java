package br.com.helderrangel.pousadamineira;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Reserva {
    private Long id;
    private Hospede[] hospede;
    private Acomodacao acomodacao;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private boolean ativa;
    private double valor;

    public Reserva() {}

    public Reserva(Long id, Hospede[] hospede, Acomodacao acomodacao, LocalDate dataEntrada, LocalDate dataSaida, boolean aiva, double valor) {
        setId(id);
        setHospede(hospede);
        setAcomodacao(acomodacao);
        setDataEntrada(dataEntrada);
        setDataSaida(dataSaida);
        setAtiva(aiva);
        setValor(valor);
    }

    public Long getId() {
        return id;
    }

    public Hospede[] getHospede() {
        return hospede;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public LocalDate getDataEntrada() {
        return dataEntrada;
    }

    public LocalDate getDataSaida() {
        return dataSaida;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public double getValor() {
        return valor;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setHospede(Hospede[] hospede) {
        this.hospede = hospede;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        this.acomodacao = acomodacao;
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", hospede=" + Arrays.toString(hospede) +
                ", acomodacao=" + acomodacao +
                ", dataEntrada=" + dataEntrada +
                ", dataSaida=" + dataSaida +
                ", ativa=" + ativa +
                ", valor=" + valor +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reserva reserva = (Reserva) o;
        return Objects.equals(id, reserva.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}