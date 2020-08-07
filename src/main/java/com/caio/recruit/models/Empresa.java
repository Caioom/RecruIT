package com.caio.recruit.models;

import com.caio.recruit.dtos.EmpresaDto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @OneToMany(mappedBy = "empresa")
    private List<Oportunidade> oportunidades;

    public Empresa() {}

    public Empresa(String nome) {
        this.nome = nome;
        this.oportunidades = new LinkedList<>();
    }

    public Empresa(EmpresaDto dto) {
        this.nome = dto.getNome();
        this.oportunidades = dto.getOportunidades();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Oportunidade> getOportunidades() {
        return new ArrayList<>(oportunidades);
    }

    public void setOportunidades(List<Oportunidade> oportunidades) {
        this.oportunidades = oportunidades;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empresa empresa = (Empresa) o;
        return Objects.equals(nome, empresa.nome) &&
                Objects.equals(oportunidades, empresa.oportunidades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, oportunidades);
    }
}
