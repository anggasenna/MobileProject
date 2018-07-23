/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.model;

import java.io.Serializable;
import java.sql.Time;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author lutfi
 */
@Entity
public class MasukTambahan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_masuk_tambahan", unique = true, nullable = false)
    private Long id_masuk_tambahan;
    @Column(name = "jam_masuk_tambahan")
    private Time jam_masuk_tambahan;
    @Column(name = "latitude_masuk_tambahan")
    private Float latitude_masuk_tambahan;
    @Column(name = "longitude_masuk_tambahan")
    private Float longitude_masuk_tambahan;
    @ManyToOne
    private Absen absen;

    public Long getId() {
        return id_masuk_tambahan;
    }

    public void setId(Long id_masuk_tambahan) {
        this.id_masuk_tambahan = id_masuk_tambahan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id_masuk_tambahan != null ? id_masuk_tambahan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MasukTambahan)) {
            return false;
        }
        MasukTambahan other = (MasukTambahan) object;
        if ((this.id_masuk_tambahan == null && other.id_masuk_tambahan != null) || (this.id_masuk_tambahan != null && !this.id_masuk_tambahan.equals(other.id_masuk_tambahan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.MasukTambahan[ id=" + id_masuk_tambahan + " ]";
    }

    /**
     * @return the jam_masuk_tambahan
     */
    public Time getJam_masuk_tambahan() {
        return jam_masuk_tambahan;
    }

    /**
     * @param jam_masuk_tambahan the jam_masuk_tambahan to set
     */
    public void setJam_masuk_tambahan(Time jam_masuk_tambahan) {
        this.jam_masuk_tambahan = jam_masuk_tambahan;
    }

    /**
     * @return the latitude_masuk_tambahan
     */
    public Float getLatitude_masuk_tambahan() {
        return latitude_masuk_tambahan;
    }

    /**
     * @param latitude_masuk_tambahan the latitude_masuk_tambahan to set
     */
    public void setLatitude_masuk_tambahan(Float latitude_masuk_tambahan) {
        this.latitude_masuk_tambahan = latitude_masuk_tambahan;
    }

    /**
     * @return the longitude_masuk_tambahan
     */
    public Float getLongitude_masuk_tambahan() {
        return longitude_masuk_tambahan;
    }

    /**
     * @param longitude_masuk_tambahan the longitude_masuk_tambahan to set
     */
    public void setLongitude_masuk_tambahan(Float longitude_masuk_tambahan) {
        this.longitude_masuk_tambahan = longitude_masuk_tambahan;
    }

    /**
     * @return the absen
     */
    public Absen getAbsen() {
        return absen;
    }

    /**
     * @param absen the absen to set
     */
    public void setAbsen(Absen absen) {
        this.absen = absen;
    }
    
}
