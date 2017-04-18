/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.ForeignKey;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Paulo
 */
@Entity
@Table(name = "locatario")
@Inheritance(strategy = InheritanceType.JOINED)
public class Locatario extends Pessoa implements Serializable{
    
    @NotNull(message = "A renda deve ser informado")
    @Column(name = "renda", nullable = false, columnDefinition = "numeric(12,2)")
    private Double renda;
    
    @Length(max = 50, message = "O local de trabalho não pode ter mais que {max} caracteres")
    @NotNull(message = "O local de trabalho deve ser informado")
    @NotBlank(message = "O endereço não dever ser em branco")
    @Column(name = "local_trabalho", length = 50, nullable = false)
    private String localTrabalho;
    
    @NotBlank(message = "O telefone de trabalho não dever ser em branco")
    @Column(name = "telefone_trabalho", length = 13, nullable = false)
    private String telefoneTrabalho;
    
    @NotNull(message = "O aluguel não pode ser nulo")
    @OneToMany
    @JoinColumn(name = "aluguel", referencedColumnName = "id", nullable = false)
    @ForeignKey(name = "fk_locatario_aluguel_id")
    private Aluguel aluguel;
            
    

    public Locatario() {
    }
    

    /**
     * @return the renda
     */
    public Double getRenda() {
        return renda;
    }

    /**
     * @param renda the renda to set
     */
    public void setRenda(Double renda) {
        this.renda = renda;
    }

    /**
     * @return the localTrabalho
     */
    public String getLocalTrabalho() {
        return localTrabalho;
    }

    /**
     * @param localTrabalho the localTrabalho to set
     */
    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    /**
     * @return the telefoneTrabalho
     */
    public String getTelefoneTrabalho() {
        return telefoneTrabalho;
    }

    /**
     * @param telefoneTrabalho the telefoneTrabalho to set
     */
    public void setTelefoneTrabalho(String telefoneTrabalho) {
        this.telefoneTrabalho = telefoneTrabalho;
    }

    /**
     * @return the aluguel
     */
    public Aluguel getAluguel() {
        return aluguel;
    }

    /**
     * @param aluguel the aluguel to set
     */
    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }


    
    
}
