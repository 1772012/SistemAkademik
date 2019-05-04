package com.kafka.entity;
// Generated May 3, 2019 5:38:29 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Jadwalkelas generated by hbm2java
 */
@Entity
@Table(name="jadwalkelas"
    ,catalog="dbsistemakademik"
)
public class Jadwalkelas  implements java.io.Serializable {


     private Integer idjadwalKelas;
     private Dosen dosen;
     private Mahasiswa mahasiswa;
     private Matakuliah matakuliah;
     private String tahunAjaranJadwalKelas;
     private Integer semesterJadwalKelas;
     private String kelasJadwalKelas;
     private String waktuJadwalKelas;
     private String ruangJadwalKelas;

    public Jadwalkelas() {
    }

	
    public Jadwalkelas(Dosen dosen, Mahasiswa mahasiswa, Matakuliah matakuliah) {
        this.dosen = dosen;
        this.mahasiswa = mahasiswa;
        this.matakuliah = matakuliah;
    }
    public Jadwalkelas(Dosen dosen, Mahasiswa mahasiswa, Matakuliah matakuliah, String tahunAjaranJadwalKelas, Integer semesterJadwalKelas, String kelasJadwalKelas, String waktuJadwalKelas, String ruangJadwalKelas) {
       this.dosen = dosen;
       this.mahasiswa = mahasiswa;
       this.matakuliah = matakuliah;
       this.tahunAjaranJadwalKelas = tahunAjaranJadwalKelas;
       this.semesterJadwalKelas = semesterJadwalKelas;
       this.kelasJadwalKelas = kelasJadwalKelas;
       this.waktuJadwalKelas = waktuJadwalKelas;
       this.ruangJadwalKelas = ruangJadwalKelas;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="IDJadwalKelas", unique=true, nullable=false)
    public Integer getIdjadwalKelas() {
        return this.idjadwalKelas;
    }
    
    public void setIdjadwalKelas(Integer idjadwalKelas) {
        this.idjadwalKelas = idjadwalKelas;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Dosen_NIKDosen", nullable=false)
    public Dosen getDosen() {
        return this.dosen;
    }
    
    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Mahasiswa_NRPMahasiswa", nullable=false)
    public Mahasiswa getMahasiswa() {
        return this.mahasiswa;
    }
    
    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MataKuliah_KodeMataKuliah", nullable=false)
    public Matakuliah getMatakuliah() {
        return this.matakuliah;
    }
    
    public void setMatakuliah(Matakuliah matakuliah) {
        this.matakuliah = matakuliah;
    }

    
    @Column(name="TahunAjaranJadwalKelas", length=9)
    public String getTahunAjaranJadwalKelas() {
        return this.tahunAjaranJadwalKelas;
    }
    
    public void setTahunAjaranJadwalKelas(String tahunAjaranJadwalKelas) {
        this.tahunAjaranJadwalKelas = tahunAjaranJadwalKelas;
    }

    
    @Column(name="SemesterJadwalKelas")
    public Integer getSemesterJadwalKelas() {
        return this.semesterJadwalKelas;
    }
    
    public void setSemesterJadwalKelas(Integer semesterJadwalKelas) {
        this.semesterJadwalKelas = semesterJadwalKelas;
    }

    
    @Column(name="KelasJadwalKelas", length=1)
    public String getKelasJadwalKelas() {
        return this.kelasJadwalKelas;
    }
    
    public void setKelasJadwalKelas(String kelasJadwalKelas) {
        this.kelasJadwalKelas = kelasJadwalKelas;
    }

    
    @Column(name="WaktuJadwalKelas", length=40)
    public String getWaktuJadwalKelas() {
        return this.waktuJadwalKelas;
    }
    
    public void setWaktuJadwalKelas(String waktuJadwalKelas) {
        this.waktuJadwalKelas = waktuJadwalKelas;
    }

    
    @Column(name="RuangJadwalKelas", length=20)
    public String getRuangJadwalKelas() {
        return this.ruangJadwalKelas;
    }
    
    public void setRuangJadwalKelas(String ruangJadwalKelas) {
        this.ruangJadwalKelas = ruangJadwalKelas;
    }




}


