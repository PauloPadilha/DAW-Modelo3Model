/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Paulo
 */
@Entity
@Table(name = "condominio")
public class Condominio implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_condominio", sequenceName = "seq_condominio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_condominio", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Length(max = 50, message = "O nome não pode ter mais que {max} caracteres")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não dever ser em branco")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @Length(max = 50, message = "O endereço não pode ter mais que {max} caracteres")
    @NotNull(message = "O endereço deve ser informado")
    @NotBlank(message = "O endereço não dever ser em branco")
    @Column(name = "endereco", length = 50, nullable = false)
    private String endereco;
    @NotNull(message = "O numero deve ser informado")
    @NotBlank(message = "O numero não dever ser em branco")
    @Column(name = "numero", length = 30)
    private String numero;
    @Length(max = 9, message = "O cep não pode ter mais que {max} caracteres")
    @NotNull(message = "O cep deve ser informado")
    @NotBlank(message = "O cep não dever ser em branco")
    @Column(name = "cep", length = 50, nullable = false)
    private String cep;
    @ManyToMany
    @JoinTable(name = "tem",
            joinColumns = 
            @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = 
            @JoinColumn(name = "recurso", referencedColumnName = "id", nullable = false))    
    private List<Recurso> tem = new ArrayList<>();
    
    @OneToMany(mappedBy = "condominio")
    private List<UnidadeCondominial> unidadeCondominial = new ArrayList<>();

    public Condominio() {
    }
    
    

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the numero
     */
    public String getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
    }

    /**
     * @return the tem
     */
    public List<Recurso> getTem() {
        return tem;
    }

    /**
     * @param tem the tem to set
     */
    public void setTem(List<Recurso> tem) {
        this.tem = tem;
    }

    /**
     * @return the unidadeCondominial
     */
    public List<UnidadeCondominial> getUnidadeCondominial() {
        return unidadeCondominial;
    }

    /**
     * @param unidadeCondominial the unidadeCondominial to set
     */
    public void setUnidadeCondominial(List<UnidadeCondominial> unidadeCondominial) {
        this.unidadeCondominial = unidadeCondominial;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Condominio other = (Condominio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
}
