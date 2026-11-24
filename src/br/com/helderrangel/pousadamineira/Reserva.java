package br.com.helderrangel.pousadamineira;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Objects;

public class Reserva {
    private static int contadorId = 1;
    private int id;
    private Hospede hospedeLider;
    private Hospede[] acompanhantes;
    private int quantidadeAcompanhantes;
    private Acomodacao acomodacao;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private boolean ativa;
    private BigDecimal valorTotalPago = BigDecimal.ZERO;
    private ServicosTipos[] servicosConsumidos;
    private int quantidadeServicos;

    public Reserva(Hospede hospedeLider, Hospede[] acompanhantesIniciais, Acomodacao acomodacao, LocalDate dataEntrada, LocalDate dataSaida) {
        this(hospedeLider, acomodacao, dataEntrada, dataSaida); // vem do outro construtor abaixo

        if (acompanhantesIniciais != null) {
            for (Hospede acompanhante : acompanhantesIniciais) {
                if (acompanhante != null) {
                    adicionarAcompanhante(acompanhante);
                }
            }
        }
    }

    public Reserva(Hospede hospedeLider, Acomodacao acomodacao, LocalDate dataEntrada, LocalDate dataSaida) {
        setHospedeLider(hospedeLider);
        setAcomodacao(acomodacao);

        int vagasAcompanhantes = Math.max(0, acomodacao.getCapacidade() - 1);
        this.acompanhantes = new Hospede[vagasAcompanhantes];
        this.quantidadeAcompanhantes = 0;

        setDataEntrada(dataEntrada);
        setDataSaida(dataSaida);

        this.ativa = true;
        this.valorTotalPago = BigDecimal.ZERO;
        this.servicosConsumidos = new ServicosTipos[50];
        this.quantidadeServicos = 0;
        this.id = Reserva.contadorId++;
    }

    public void adicionarAcompanhante(Hospede acompanhante) {
        if (!ativa) {
            throw new IllegalArgumentException("Não é possível adicionar acompanhantes em uma reserva inativa.");
        }
        if (acompanhante == null) {
            throw new IllegalArgumentException("O acompanhante não pode ser nulo.");
        }
        if (quantidadeAcompanhantes >= acompanhantes.length) {
            throw new IllegalStateException("Capacidade máxima de acompanhantes atingida.");
        }
        this.acompanhantes[this.quantidadeAcompanhantes++] = acompanhante;
    }

    public void adicionarServico(ServicosTipos servico) {
        if (ativa && servico != null && quantidadeServicos < servicosConsumidos.length) {
            this.servicosConsumidos[quantidadeServicos] = servico;
            this.quantidadeServicos++;
        }
    }

    public BigDecimal fecharConta() {
        BigDecimal valorDiaria = BigDecimal.valueOf(acomodacao.getTipo().getValorDiaria());
        BigDecimal valorDiarias = valorDiaria.multiply(BigDecimal.valueOf(getQtdDiarias()));
        this.valorTotalPago = valorDiarias.add(getSubtotalServicos());
        this.ativa = false;
        return this.valorTotalPago;
    }

    public long getQtdDiarias() {
        long dias = ChronoUnit.DAYS.between(dataEntrada, dataSaida);
        return Math.max(1, dias);
    }

    public BigDecimal getSubtotalServicos() {
        BigDecimal total = BigDecimal.ZERO;
        for (int i = 0; i < quantidadeServicos; i++) {
            total = total.add(BigDecimal.valueOf(servicosConsumidos[i].getValor()));
        }
        return total;
    }

    public Hospede getHospedeLider() {
        return hospedeLider;
    }

    public void setHospedeLider(Hospede hospedeLider) {
        if (hospedeLider == null) {
            throw new IllegalArgumentException("O nome do hospede líder deve ser informado");
        }
        this.hospedeLider = hospedeLider;
    }

    public Acomodacao getAcomodacao() {
        return acomodacao;
    }

    public void setAcomodacao(Acomodacao acomodacao) {
        if (acomodacao == null) {
            throw new IllegalArgumentException("A acomodação deve ser informada.");
        }
        if (acompanhantes != null && quantidadeAcompanhantes > acomodacao.getCapacidade() - 1) {
            throw new IllegalArgumentException("A nova acomodação não comporta os acompanhantes já cadastrados.");
        }
        this.acomodacao = acomodacao;
        if (acompanhantes != null) {
            this.acompanhantes = Arrays.copyOf(this.acompanhantes, Math.max(0, acomodacao.getCapacidade() - 1));
        }
    }

    public void setDataEntrada(LocalDate dataEntrada) {
        if ( dataEntrada == null){
            throw new IllegalArgumentException("A data deve ser informada");
        }
        if (dataSaida != null && !dataEntrada.isBefore(dataSaida)) {
            throw new IllegalArgumentException(" A data de entrada deve ser inferior a data de saída");
        }
        this.dataEntrada = dataEntrada;
    }

    public void setDataSaida(LocalDate dataSaida) {
        if (dataSaida == null) {
            throw new IllegalArgumentException("A data deve ser informada.");
        }
        if(dataEntrada != null && !dataSaida.isAfter(dataEntrada)) {
            throw new IllegalArgumentException("A data de saida deve ser posterior a data de entrada");
        }
        this.dataSaida = dataSaida;
    }


    public Hospede[] getAcompanhantes() {

        return Arrays.copyOf(this.acompanhantes, this.quantidadeAcompanhantes);
    }

    public int getQuantidadeAcompanhantes() {
        return quantidadeAcompanhantes;
    }

    public ServicosTipos[] getServicosConsumidos() {

        return Arrays.copyOf(this.servicosConsumidos, this.quantidadeServicos);
    }

    public void cancelar() {
        this.ativa = false;
    }

    public int getId() {
        return id;
    }

    public BigDecimal getValorTotalPago() {
        return valorTotalPago;
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

    public int getQuantidadeServicos() {
        return quantidadeServicos;
    }


    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", hospedeLider=" + hospedeLider +
                ", acompanhantes=" + Arrays.toString(Arrays.copyOf(acompanhantes, quantidadeAcompanhantes)) +
                ", quantidadeAcompanhantes=" + quantidadeAcompanhantes +
                ", acomodacao=" + acomodacao +
                ", dataEntrada=" + dataEntrada +
                ", dataSaida=" + dataSaida +
                ", ativa=" + ativa +
                ", valorTotalPago=" + valorTotalPago +
                ", servicosConsumidos=" + Arrays.toString(Arrays.copyOf(servicosConsumidos, quantidadeServicos)) +
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
        return Integer.hashCode(id);
    }
}