/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.io.Serializable;
import java.sql.Time;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author lutfi
 */
@Entity
public class Masuk implements Serializable {

//    @OneToMany(mappedBy = "masuk")
//    private List<Absen> absen;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;
    @Column(name = "jam_masuk")
    private Time jam_masuk;
    @Column(name = "lattitude_masuk")
    private Float lattitude_masuk;
    @Column(name = "longitude_masuk")
    private Float longitude_masuk;
    @Column(name = "status")
    private Boolean status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Masuk)) {
            return false;
        }
        Masuk other = (Masuk) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Masuk[ id=" + id + " ]";
    }

//    /**
//     * @return the absen
//     */
//    public List<Absen> getAbsen() {
//        return absen;
//    }
//
//    /**
//     * @param absen the absen to set
//     */
//    public void setAbsen(List<Absen> absen) {
//        this.absen = absen;
//    }

    /**
     * @return the lattitude_masuk
     */
    public Float getLattitude_masuk() {
        return lattitude_masuk;
    }

    /**
     * @param lattitude_masuk the lattitude_masuk to set
     */
    public void setLattitude_masuk(Float lattitude_masuk) {
        this.lattitude_masuk = lattitude_masuk;
    }

    /**
     * @return the longitude_masuk
     */
    public Float getLongitude_masuk() {
        return longitude_masuk;
    }

    /**
     * @param longitude_masuk the longitude_masuk to set
     */
    public void setLongitude_masuk(Float longitude_masuk) {
        this.longitude_masuk = longitude_masuk;
    }

    /**
     * @return the status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * @return the jam_masuk
     */
    public Time getJam_masuk() {
        return jam_masuk;
    }

    /**
     * @param jam_masuk the jam_masuk to set
     */
    public void setJam_masuk(Time jam_masuk) {
        this.jam_masuk = jam_masuk;
    }
    
}
