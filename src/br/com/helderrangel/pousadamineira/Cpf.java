package br.com.helderrangel.pousadamineira;

public record Cpf(String valor) {

    public Cpf {
        if (valor == null || valor.isBlank()) {
            throw new IllegalArgumentException("CPF não pode ser nulo");
        }

        String apenasDigitos = valor.replaceAll("\\D", "");

        if (!isValido(apenasDigitos)) {
            throw new IllegalArgumentException("CPF inválido: " + valor);
        }
        valor = apenasDigitos;
    }

    public String formatado() {
        return valor.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public static boolean isValido(String cpf) {
        if (cpf.length() != 11 || cpf.chars().distinct().count() == 1) {
            return false;
        }
        // Cálculo do 1º dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += (cpf.charAt(i) - '0') * (10 - i);
        }
        int digito1 = 11 - (soma % 11);
        if (digito1 >= 10) {
            digito1 = 0;
        }

        if (digito1 != (cpf.charAt(9) - '0')) {
            return false;
        }
        // Cálculo do 2º dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += (cpf.charAt(i) - '0') * (11 - i);
        }
        int digito2 = 11 - (soma % 11);
        if (digito2 >= 10) digito2 = 0;

        return digito2 == (cpf.charAt(10) - '0');
    }
}
