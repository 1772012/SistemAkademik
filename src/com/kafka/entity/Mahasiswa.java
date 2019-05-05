package com.kafka.entity;
// Generated May 5, 2019 2:37:27 PM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Mahasiswa generated by hbm2java
 */
@Entity
@Table(name = "mahasiswa",
         catalog = "dbsistemakademik"
)
public class Mahasiswa implements java.io.Serializable {

    private String nrpmahasiswa;
    private Dosen dosen;
    private Jurusan jurusan;
    private String namaDepanMahasiswa;
    private String namaBelakang;
    private Double ipk;
    private String emailMahasiswa;
    private Set<Nilai> nilais = new HashSet<Nilai>(0);
    private Set<Jadwalkelas> jadwalkelases = new HashSet<Jadwalkelas>(0);
    private Set<Wisuda> wisudas = new HashSet<Wisuda>(0);

    public Mahasiswa() {
    }

    public Mahasiswa(String nrpmahasiswa, Dosen dosen, Jurusan jurusan) {
        this.nrpmahasiswa = nrpmahasiswa;
        this.dosen = dosen;
        this.jurusan = jurusan;
    }

    public Mahasiswa(String nrpmahasiswa, Dosen dosen, Jurusan jurusan,
            String namaDepanMahasiswa, String namaBelakang, Double ipk,
            String emailMahasiswa, Set<Nilai> nilais,
            Set<Jadwalkelas> jadwalkelases, Set<Wisuda> wisudas) {
        this.nrpmahasiswa = nrpmahasiswa;
        this.dosen = dosen;
        this.jurusan = jurusan;
        this.namaDepanMahasiswa = namaDepanMahasiswa;
        this.namaBelakang = namaBelakang;
        this.ipk = ipk;
        this.emailMahasiswa = emailMahasiswa;
        this.nilais = nilais;
        this.jadwalkelases = jadwalkelases;
        this.wisudas = wisudas;
    }

    @Id

    @Column(name = "NRPMahasiswa", unique = true, nullable = false, length = 7)
    public String getNrpmahasiswa() {
        return this.nrpmahasiswa;
    }

    public void setNrpmahasiswa(String nrpmahasiswa) {
        this.nrpmahasiswa = nrpmahasiswa;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Dosen_NIKDosen", nullable = false)
    public Dosen getDosen() {
        return this.dosen;
    }

    public void setDosen(Dosen dosen) {
        this.dosen = dosen;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Jurusan_IDJurusan", nullable = false)
    public Jurusan getJurusan() {
        return this.jurusan;
    }

    public void setJurusan(Jurusan jurusan) {
        this.jurusan = jurusan;
    }

    @Column(name = "NamaDepanMahasiswa", length = 60)
    public String getNamaDepanMahasiswa() {
        return this.namaDepanMahasiswa;
    }

    public void setNamaDepanMahasiswa(String namaDepanMahasiswa) {
        this.namaDepanMahasiswa = namaDepanMahasiswa;
    }

    @Column(name = "NamaBelakang", length = 60)
    public String getNamaBelakang() {
        return this.namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    @Column(name = "IPK", precision = 22, scale = 0)
    public Double getIpk() {
        return this.ipk;
    }

    public void setIpk(Double ipk) {
        this.ipk = ipk;
    }

    @Column(name = "EmailMahasiswa", length = 60)
    public String getEmailMahasiswa() {
        return this.emailMahasiswa;
    }

    public void setEmailMahasiswa(String emailMahasiswa) {
        this.emailMahasiswa = emailMahasiswa;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mahasiswa")
    public Set<Nilai> getNilais() {
        return this.nilais;
    }

    public void setNilais(Set<Nilai> nilais) {
        this.nilais = nilais;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mahasiswa")
    public Set<Jadwalkelas> getJadwalkelases() {
        return this.jadwalkelases;
    }

    public void setJadwalkelases(Set<Jadwalkelas> jadwalkelases) {
        this.jadwalkelases = jadwalkelases;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "mahasiswa")
    public Set<Wisuda> getWisudas() {
        return this.wisudas;
    }

    public void setWisudas(Set<Wisuda> wisudas) {
        this.wisudas = wisudas;
    }

    @Override
    public String toString() {
        return this.nrpmahasiswa;
    }

}
