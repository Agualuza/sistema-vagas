package app.models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import app.components.Util;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.Version;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;


/**
 *
 * @author iagoagualuza
 */
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="vaga")
public class Vaga {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
    private long id;
	@Column(name="NOME")
    private String nome;
	@Column(name="DESCRICAO")
    private String descricao;
	@Column(name="EMPRESA")
    private String empresa;
	@Column(name="SALARIO")
    private float salario;
	@Column(name="DATA_PUBLICACAO")
    private Date dataPublicacao;
	@Column(name="ATIVO")
    private boolean ativo;
	@Column(name="DATA_FIM")
    private Date dataFim;
	@Column(name="STATUS")
    private char status;
	
	@Version
	private int versao;
	
	public Vaga() {
		
	}
	
	public int getVersao() {
		return versao;
	}

	public void setVersao(int versao) {
		this.versao = versao;
	}
	
    public long getId() {
        return id;
    }

    @SuppressWarnings("unused")
	private void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Date getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
    @Transient
    //Se der erro retirar o transient
    public String getMaskedSalario() {
    	return Util.applyMoneyMask(this.salario);
    }
    
    @Transient
    //Se der erro retirar o transient
    public String getStatusFormatado() {
    	if (this.status == 'C') {
    		return "Cancelado";
    	} else if (this.status == 'P') {
    		return "Preenchido";
    	} else if (this.status == 'F') {
    		return "Fechado";
    	} else {
    		return "Aberto";
    	}
    }
   
    
}
