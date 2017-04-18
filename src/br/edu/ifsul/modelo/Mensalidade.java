/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Paulo
 */
@Entity
@Table(name = "mensalidade")
public class Mensalidade implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_mensalidade", sequenceName = "seq_mensalidade_id",allocationSize = 1)
    @GeneratedValue(generator = "seq_mensalidade", strategy = GenerationType.SEQUENCE) 
    private Integer id;
    
    @NotNull(message = "O valor não pode ser nulo")
    @Min(value = 0, message = "O valor não pode ser negativo")
    @Column(name = "valor", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valor;
    
    @NotNull(message = "O valor do pagamento não pode ser nulo")
    @Min(value = 0, message = "O valor do pagamento não pode ser negativo")
    @Column(name = "valor_pagamento", nullable = false, columnDefinition = "numeric(12,2)")
    private Double valorPagamento;
    
    @Column(name = "data_pagamento")
    @Temporal(TemporalType.DATE)
    private Calendar dataPagamento;
    
    @NotNull(message = "O aluguel deve ser informado")
    @ManyToOne
    @JoinColumn(name = "aluguel_id", referencedColumnName = "id", nullable = false)
    private Aluguel aluguel;

    public Mensalidade() {
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
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    /**
     * @return the valorPagemento
     */
    public Double getValorPagamento() {
        return valorPagamento;
    }

    /**
     * @param valorPagemento the valorPagemento to set
     */
    public void setValorPagamento(Double valorPagemento) {
        this.valorPagamento = valorPagemento;
    }

    /**
     * @return the dataPagamento
     */
    public Calendar getDataPagamento() {
        return dataPagamento;
    }

    /**
     * @param dataPagamento the dataPagamento to set
     */
    public void setDataPagamento(Calendar dataPagamento) {
        this.dataPagamento = dataPagamento;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + Objects.hashCode(this.id);
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
        final Mensalidade other = (Mensalidade) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
 
    
}
