/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.data.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author henrique
 */
@Entity
@Table(name = "rota")
@XmlRootElement 
@NamedQueries({ 
    @NamedQuery(name="Rota.findAll", query ="SELECT r FROM Rota r"), 
    @NamedQuery(name = "Rota.findByIdAeroporto", query = "SELECT r FROM Rota r WHERE r.origem.idaeroporto = :aeroportoorigem AND r.destino.idaeroporto = :aeroportodestino")
}) 
public class Rota implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.SEQUENCE) 
    @Column(name = "idrota")
    private int idrota;
    
    @ManyToOne
    @JoinColumn(name = "aeroportoorigem")
    private Aeroportos origem;
    
    @ManyToOne
    @JoinColumn(name = "aeroportodestino")
    private Aeroportos destino;
    
    @Column(name="datahora_partida")
    @Temporal(TemporalType.DATE)
    private Date datahora_partida;
    
    @Column(name="datahora_chegada")
    @Temporal(TemporalType.DATE)
    private Date datahora_chegada;
    
    @Column(name="frequencia")
    private double frequencia;
    
    @Column(name="duracao_voo")
    private double duracao_voo;
    
    @NotNull
    @Column(name="idPromocao")
    private int idPromocao;
    
    public Rota() { }

    public int getIdrota() {
        return idrota;
    }

    public Aeroportos getOrigem() {
        return origem;
    }

    public void setOrigem(Aeroportos origem) {
        this.origem = origem;
    }

    public Aeroportos getDestino() {
        return destino;
    }

    public void setDestino(Aeroportos destino) {
        this.destino = destino;
    }

    public Date getDatahora_partida() {
        return datahora_partida;
    }

    public void setDatahora_partida(Date datahora_partida) {
        this.datahora_partida = datahora_partida;
    }

    public Date getDatahora_chegada() {
        return datahora_chegada;
    }

    public void setDatahora_chegada(Date datahora_chegada) {
        this.datahora_chegada = datahora_chegada;
    }

    public double getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(double frequencia) {
        this.frequencia = frequencia;
    }

    public double getDuracao_voo() {
        return duracao_voo;
    }

    public void setDuracao_voo(double duracao_voo) {
        this.duracao_voo = duracao_voo;
    }

    public int getIdPromocao() {
        return idPromocao;
    }

    public void setIdPromocao(int idPromocao) {
        this.idPromocao = idPromocao;
    }
    
}