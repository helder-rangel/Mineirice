package br.com.helderrangel.pousadamineira;
public class PousadaService {
    private Hospede[] hospedes = new Hospede[100]
    private int qtdHospedes = 0;

    public Hospede buscarHospede(String cpf) {
        for (int i = 0; i < qtdHospedes; i++) {
            if (hospedes[i].getCpf().equals(cpf)) {
                return this.hospedes[i];
            }
        }
        return null;
    }


}