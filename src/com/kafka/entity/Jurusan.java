package com.kafka.entity;
// Generated May 5, 2019 2:37:27 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Jurusan generated by hbm2java
 */
@Entity
@Table(name="jurusan"
    ,catalog="dbsistemakademik"
)
public class Jurusan  implements java.io.Serializable {


     private int idjurusan;
     private String namaJurusan;
     private Set<Mahasiswa> mahasiswas = new HashSet<Mahasiswa>(0);

    public Jurusan() {
    }

	
    public Jurusan(int idjurusan) {
        this.idjurusan = idjurusan;
    }
    public Jurusan(int idjurusan, String namaJurusan, Set<Mahasiswa> mahasiswas) {
       this.idjurusan = idjurusan;
       this.namaJurusan = namaJurusan;
       this.mahasiswas = mahasiswas;
    }
   
     @Id 

    
    @Column(name="IDJurusan", unique=true, nullable=false)
    public int getIdjurusan() {
        return this.idjurusan;
    }
    
    public void setIdjurusan(int idjurusan) {
        this.idjurusan = idjurusan;
    }

    
    @Column(name="NamaJurusan", length=45)
    public String getNamaJurusan() {
        return this.namaJurusan;
    }
    
    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="jurusan")
    public Set<Mahasiswa> getMahasiswas() {
        return this.mahasiswas;
    }
    
    public void setMahasiswas(Set<Mahasiswa> mahasiswas) {
        this.mahasiswas = mahasiswas;
    }




}


