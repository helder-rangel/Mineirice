package br.com.helderrangel.pousadamineira;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class Acomodacao {
    private int comodo;
    private String titulo;
    protected String descricao;
    private AcomodacaoTipo tipo;
    private String[] comodidades;
    private double[] descontos;
    private int capacidade;
    private double valorDiaria;
    private double[] avaliacao;


    public Acomodacao(int comodo, String titulo, String descricao, AcomodacaoTipo tipo, String[] comodidades, int capacidade, double valorDiaria, double[] avaliacao){
        setcomodo(comodo);
        setTitulo(titulo);
        setDescricao(descricao);
        setTipo(tipo);
        setComodidades(comodidades);
        setCapacidade(capacidade);
        setValorDiaria(valorDiaria);
        setAvaliacao(avaliacao);
    }

    public Acomodacao(int comodo, String titulo, String descricao, AcomodacaoTipo tipo, String[] comodidades, double[] descontos, int capacidade, double valorDiaria, double[] avaliacao){
        setcomodo(comodo);
        setTitulo(titulo);
        setDescricao(descricao);
        setTipo(tipo);
        setComodidades(comodidades);
        setDescontos(descontos);
        setCapacidade(capacidade);
        setValorDiaria(valorDiaria);
        setAvaliacao(avaliacao);
    }

    public int getcomodo() {
        return comodo;
    }

    public void setcomodo(int comodo) {
        this.comodo = comodo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public AcomodacaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(AcomodacaoTipo tipo) {
        this.tipo = tipo;
    }

    public String[] getComodidades() {
        return comodidades;
    }

    public void setComodidades(String[] comodidades) {
        this.comodidades = comodidades;
    }

    public double[] getDescontos() {
        return descontos;
    }

    public void setDescontos(double[] descontos) {
        this.descontos = descontos;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        if (capacidade < 1) {
            throw new IllegalArgumentException("A pacidade deve ser de pelo mennos 1 pessoa.");
        }
        this.capacidade = capacidade;
    }


    public int getVagasAcompanhantes(){
        return Math.max(0, this.capacidade -1);
    }

    public boolean comportaTotalPessoas(int totalPessoas) {
        return totalPessoas > 0 && totalPessoas <= this.capacidade;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public double[] getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(double[] avaliacao) {
        this.avaliacao = avaliacao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Acomodacao that = (Acomodacao) o;
        return Objects.equals(comodo, that.comodo);
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(comodo);
    }

    @Override
    public String toString() {
        return "Acomodacao{" +
                "comodo=" + comodo +
                ", tipo=" + tipo +
                ", capacidade=" + capacidade +
                ", valorDiaria=" + valorDiaria +
                ", avaliacao=" + Arrays.toString(avaliacao) +
                '}';
    }
}
