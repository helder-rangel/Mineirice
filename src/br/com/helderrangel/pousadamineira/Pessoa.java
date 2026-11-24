package br.com.helderrangel.pousadamineira;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;
import java.time.Period;
import java.util.regex.Pattern;

public abstract class Pessoa implements Registro {
    private int id;
    private Cpf cpf;
    private String nome;
    private LocalDate dataNascimento;
    private String telefone;
    private static final Pattern EMAIL_PATTERN = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    );
    private String email;

    public Pessoa(int id, Cpf cpf, String nome, LocalDate dataNascimento, String telefone, String email) {
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

    public int  getId() {
        return id;
    }

    public Cpf getCpf() {
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

    public String getTelefoneFormatado() {
        if(this.telefone == null) {
            return "";
        }
        String ddd = this.telefone.substring(0, 2);

        if (this.telefone.length() == 11) {
            String parte1 = this.telefone.substring(2, 7);
            String parte2 = this.telefone.substring(7, 11);
            return String.format("(%s) %s-%s", ddd, parte1, parte2);
        }
        if (this.telefone.length() == 10) {
            String parte1 = this.telefone.substring(2, 6);
            String parte2 = this.telefone.substring(6, 10);
            return String.format("(%s) %s-%s", ddd, parte1, parte2);
        }
        return this.telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        if(id <= 0) {
            throw new IllegalArgumentException("Id deve ser um número positivo maior que zero.");
        }
        this.id = id;
    }

    public final void setCpf(Cpf cpf) {
        if(cpf == null) {
            throw new IllegalArgumentException("CPF não pode ser nulo");
        }

        this.cpf = cpf;
    }

    public void setNome(String nome) {
        if(nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome inválido");
        }
        this.nome = nome;
    }

    public final void setDataNascimento(LocalDate dataNascimento) {
        if(dataNascimento.isAfter(LocalDate.now())){
            throw new IllegalArgumentException("Data de nascimento não pode ser futura.");
        }
        this.dataNascimento = dataNascimento;
    }

    public void setTelefone(String telefone) {
        if(telefone == null || telefone.trim().isEmpty()) {
            throw new IllegalArgumentException("Número de telefone inválido");
        }
        //remove parênteses e traçcos
        String numeros = telefone.replaceAll("\\D", "");
        //evita sequencias repetidas
        if(numeros.matches("(\\d)\\1{9,10}")) {
            throw new IllegalArgumentException("Número de telefone inválido");
        }
        //valida DDD
        if(!numeros.matches("^[1-9]{2}(?:[2-5]\\d{7}|9[6-9]\\d{7})$")) {
            throw new IllegalArgumentException("Telefone inválido, Informe DDD + número válido.");
        }
        this.telefone = numeros;
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
        return id != 0 && id == pessoa.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}
