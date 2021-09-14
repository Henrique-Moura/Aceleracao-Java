package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Player {
    private Long id;

    private Long idTime;

    private String nome;

    private LocalDate dataNascimento;

    private Integer nivelHabilidade;

    private BigDecimal salario;

    private Boolean capitao = false;

    public Player(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
        setId(id);
        setIdTime(idTime);
        setNome(nome);
        setDataNascimento(dataNascimento);
        setNivelHabilidade(nivelHabilidade);
        setSalario(salario);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTime() {
        return idTime;
    }

    public void setIdTime(Long idTime) {
        this.idTime = idTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getNivelHabilidade() {
        return nivelHabilidade;
    }

    public void setNivelHabilidade(Integer nivelHabilidade) {
        this.nivelHabilidade = nivelHabilidade;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setCapitao(Boolean capitao) {
        this.capitao = capitao;
    }

    public Boolean getCapitao() {
        return this.capitao;
    }

    public int compareToId (Player playerId) {
        return this.id.compareTo(playerId.getId());
    }
}
