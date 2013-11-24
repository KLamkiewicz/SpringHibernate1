package com.example.shdemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "jednorozec.getAll", query = "Select j from Jednorozec j"),
	@NamedQuery(name = "jednorozec.byId", query = "Select j from Jednorozec j where j.id = :id")
})
public class Jednorozec {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String imieJednorozca;
    private int rokUrodzeniaJednorozca;
    private int wagaJednorozca;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getImieJednorozca() {
		return imieJednorozca;
	}
	public void setImieJednorozca(String imieJednorozca) {
		this.imieJednorozca = imieJednorozca;
	}
	public int getRokUrodzeniaJednorozca() {
		return rokUrodzeniaJednorozca;
	}
	public void setRokUrodzeniaJednorozca(int rokUrodzeniaJednorozca) {
		this.rokUrodzeniaJednorozca = rokUrodzeniaJednorozca;
	}
	public int getWagaJednorozca() {
		return wagaJednorozca;
	}
	public void setWagaJednorozca(int wagaJednorozca) {
		this.wagaJednorozca = wagaJednorozca;
	}
    
}
