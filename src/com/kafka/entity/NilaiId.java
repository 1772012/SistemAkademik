package com.kafka.entity;
// Generated May 5, 2019 2:37:27 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * NilaiId generated by hbm2java
 */
@Embeddable
public class NilaiId  implements java.io.Serializable {


     private int idnilai;
     private String mataKuliahKodeMataKuliah;

    public NilaiId() {
    }

    public NilaiId(int idnilai, String mataKuliahKodeMataKuliah) {
       this.idnilai = idnilai;
       this.mataKuliahKodeMataKuliah = mataKuliahKodeMataKuliah;
    }
   


    @Column(name="IDNilai", unique=true, nullable=false)
    public int getIdnilai() {
        return this.idnilai;
    }
    
    public void setIdnilai(int idnilai) {
        this.idnilai = idnilai;
    }


    @Column(name="MataKuliah_KodeMataKuliah", nullable=false, length=5)
    public String getMataKuliahKodeMataKuliah() {
        return this.mataKuliahKodeMataKuliah;
    }
    
    public void setMataKuliahKodeMataKuliah(String mataKuliahKodeMataKuliah) {
        this.mataKuliahKodeMataKuliah = mataKuliahKodeMataKuliah;
    }


   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof NilaiId) ) return false;
		 NilaiId castOther = ( NilaiId ) other; 
         
		 return (this.getIdnilai()==castOther.getIdnilai())
 && ( (this.getMataKuliahKodeMataKuliah()==castOther.getMataKuliahKodeMataKuliah()) || ( this.getMataKuliahKodeMataKuliah()!=null && castOther.getMataKuliahKodeMataKuliah()!=null && this.getMataKuliahKodeMataKuliah().equals(castOther.getMataKuliahKodeMataKuliah()) ) );
   }
   
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getIdnilai();
         result = 37 * result + ( getMataKuliahKodeMataKuliah() == null ? 0 : this.getMataKuliahKodeMataKuliah().hashCode() );
         return result;
   }   


}

