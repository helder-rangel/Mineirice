package br.com.helderrangel.pousadamineira;

public enum ServicosExtras {
    CAFE_COLONIAL("Café Colonial", 45.0),
    PASSEIO_GUIADO("Passeio Guiado", 100.0),
    TRASLADO("Traslado Aeroporto/Cidade", 150.0);

    private final String descricao;
    private final double valor;

    @Contract(pure = true)
    private ServicoTipo(String descricao, double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() { return descricao; }
    public double getValor() { return valor; }
}
