package br.com.helderrangel.pousadamineira;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.time.Period;
import java.util.regex.Pattern;

public abstract class Pessoa {
    private Long id;
    private String cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
    private String email;


    public Pessoa(){}
    public Pessoa(Long id, String cpf, String nome, LocalDate dataNascimento, String telefone, String email) {
        setId(id);
        setCpf(cpf);
        setNome(nome);
        setDataNascimento(dataNascimento);
        setTelefone(telefone);
        setEmail(email);
    }

    public final boolean isMaiorDeIdade(){
        return getIdade() >= 18;
    }

    public Long  getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public final int getIdade() {
        if(this.dataNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento não informada");
        }
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public final void setCpf(String cpf) {
        if(cpf == null) {
            throw new IllegalArgumentException("CPF não pode ser nulo");
        }
        String cpfLimpo = cpf.replaceAll("\\D", "");

        if(!isCpfValido(cpfLimpo)) {
            this.cpf = cpfLimpo;
        }


    }

    private boolean isCpfValido(String cpf) {
        // Exige 11 dígitos e rejeita sequências iguais (ex.: 00000000000, 11111111111)
        if(cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Cálculo do 1º dígito verificador
            int soma = 0;
            for (int i = 0; i < 9; i++) {
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }
            int resto = 11 - (soma % 11);
            int digito1 = (resto >= 10) ? 0 : resto;

            // Cálculo do 2º dígito verificador
            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }
            resto = 11 - (soma % 11);
            int digito2 = (resto >= 10) ? 0 : resto;

            return (digito1 == (cpf.charAt(9) - '0')) && (digito2 == (cpf.charAt(10) - '0'));
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public String getCpfFormatado() {
        if (this.cpf == null || this.cpf.length() != 11) {
            return this.cpf;
        }
        return this.cpf.replaceFirst("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfFormatado() {
        if(this.cpf
    }

    public final void setDataNascimento(LocalDate dataNascimento) {
        if(dataNascimento.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Data de nascimento não pode ser futura.");
        }
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public final void setEmail(String email) {
        if(email == null || !EMAIL_PATTERN.matcher(email.trim()).matches()) {
            throw new IllegalArgumentException("E-mail inválido: " + email);
        }
        this.email = email.trim().toLowerCase();
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id='" + id + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return id != null && Objects.equals(id, pessoa.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
