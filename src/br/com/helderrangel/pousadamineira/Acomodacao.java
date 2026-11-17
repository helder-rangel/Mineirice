package br.com.helderrangel.pousadamineira;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Acomodacao {
    private Long id;
    private String titulo;
    private String descricao;
    private AcomodacaoTipo tipo;
    private String[] comodidades;
    private double[] descontos;
    private int capacidade;
    private double valorDiaria;
    double[] avaliacao;


    public Acomodacao(){}

    public Acomodacao(Long id, String titulo, String descricao, AcomodacaoTipo tipo, String[] comodidades, double[] descontos, int capacidade, double valorDiaria, double[] avaliacao){
        setId(id);
        setDescricao(descricao);
        setTipo(tipo);
        setComodidades(comodidades);
        setDescontos(descontos);
        setCapacidade(capacidade);
        setValorDiaria(valorDiaria);
        setAvaliacao(avaliacao);
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public AcomodacaoTipo getTipo() {
        return tipo;
    }

    public String[] getComodidades() {
        return comodidades;
    }

    public double[] getDescontos() {
        return descontos;
    }


    public int getCapacidade() {
        return capacidade;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public double[] getAvaliacao() {
        return avaliacao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setComodidades(String[] comodidades) {
        this.comodidades = comodidades;
    }

    public void setDescontos(double[] descontos) {
        this.descontos = descontos;
    }

    public void setTipo(AcomodacaoTipo tipo) {
        this.tipo = tipo;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public void setAvaliacao(double[] avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Acomodacao that = (Acomodacao) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Acomodacao{" +
                "id=" + id +
                ", tipo=" + tipo +
                ", capacidade=" + capacidade +
                ", valorDiaria=" + valorDiaria +
                ", avaliacao=" + Arrays.toString(avaliacao) +
                '}';
    }
}
