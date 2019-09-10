package com.shopshopista.productoss.modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;


/**
 *
 * @author 
 */
@Entity
@Table(name="Categorias")
public class Categorias implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
   
    @Column(name="id_categoria", nullable=false)
        @OneToMany(mappedBy="id_categoria" ,cascade = CascadeType.ALL)
        private Long id_categoria;
    
    @Column(name="cat_nombre", length=50, nullable=false)
    @Id
    private String  cat_nombre;
    
    @Column(name="cat_codigo", length=50, nullable=false)
    private String cat_codigo;
    
    @Column(name="cat_activo", columnDefinition = "BOOLEAN DEFAULT 'true' ")
    private boolean cat_activo;
    
    public Categorias(){}

    public Categorias(Long id_categoria, String cat_nombre, String cat_codigo, boolean cat_activo) {
        this.id_categoria = id_categoria;
        this.cat_nombre = cat_nombre;
        this.cat_codigo = cat_codigo;
        this.cat_activo = cat_activo;
    }

    public Long getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(Long id_categoria) {
        this.id_categoria = id_categoria;
    }

    public String getCat_nombre() {
        return cat_nombre;
    }

    public void setCat_nombre(String cat_nombre) {
        this.cat_nombre = cat_nombre;
    }

    public String getCat_codigo() {
        return cat_codigo;
    }

    public void setCat_codigo(String cat_codigo) {
        this.cat_codigo = cat_codigo;
    }

    public boolean isCat_activo() {
        return cat_activo;
    }

    public void setCat_activo(boolean cat_activo) {
        this.cat_activo = cat_activo;
    }

    @Override
    public String toString() {
        return "Categorias{" + "id_categoria=" + id_categoria + ", cat_nombre=" + cat_nombre + ", cat_codigo=" + cat_codigo + ", cat_activo=" + cat_activo + '}';
    }
    


    
    
    
}
