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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author Paulo
 */
@Entity
@Table(name = "recurso")
public class Recurso implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_recurso", sequenceName = "seq_recurso_id",
            allocationSize = 1)
    @GeneratedValue(generator = "seq_recurso", strategy = GenerationType.SEQUENCE)
    private Integer id;
    @Column(name = "descricao", columnDefinition = "text")
    private String descricao;

    @ManyToMany
    @JoinTable(name = "tem",
            joinColumns
            = @JoinColumn(name = "recurso", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "condominio", referencedColumnName = "id", nullable = false))
    private List<Condominio> tem = new ArrayList<>();

    public Recurso() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
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
        final Recurso other = (Recurso) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    /**
     * @return the tem
     */
    public List<Condominio> getTem() {
        return tem;
    }

    /**
     * @param tem the tem to set
     */
    public void setTem(List<Condominio> tem) {
        this.tem = tem;
    }

}
