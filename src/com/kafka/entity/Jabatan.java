package com.kafka.entity;
// Generated Apr 20, 2019 10:10:57 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Jabatan generated by hbm2java
 */
@Entity
@Table(name="jabatan"
    ,catalog="dbsistemakademik"
    , uniqueConstraints = @UniqueConstraint(columnNames="NamaJabatan") 
)
public class Jabatan  implements java.io.Serializable {


     private Integer idjabatan;
     private String namaJabatan;
     private Set<Account> accounts = new HashSet<Account>(0);

    public Jabatan() {
    }

	
    public Jabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
    }
    public Jabatan(String namaJabatan, Set<Account> accounts) {
       this.namaJabatan = namaJabatan;
       this.accounts = accounts;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDJabatan", unique=true, nullable=false)
    public Integer getIdjabatan() {
        return this.idjabatan;
    }
    
    public void setIdjabatan(Integer idjabatan) {
        this.idjabatan = idjabatan;
    }

    
    @Column(name="NamaJabatan", unique=true, nullable=false, length=45)
    public String getNamaJabatan() {
        return this.namaJabatan;
    }
    
    public void setNamaJabatan(String namaJabatan) {
        this.namaJabatan = namaJabatan;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="jabatan")
    public Set<Account> getAccounts() {
        return this.accounts;
    }
    
    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }




}


