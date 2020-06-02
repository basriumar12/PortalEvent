package com.basbas.portalevent.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Awesome Pojo Generator
 */
public class ResponseKeranjang {
    @SerializedName("ket_lapak")
    @Expose
    private String ket_lapak;
    @SerializedName("id_keranjang")
    @Expose
    private String id_keranjang;
    @SerializedName("id_lapak")
    @Expose
    private String id_lapak;
    @SerializedName("jml")
    @Expose
    private String jml;
    @SerializedName("id_transaksi")
    @Expose
    private String id_transaksi;
    @SerializedName("tgl_pakai")
    @Expose
    private String tgl_pakai;
    @SerializedName("tampil_keranjang")
    @Expose
    private String tampil_keranjang;
    @SerializedName("id_pembeli")
    @Expose
    private String id_pembeli;

    public void setKet_lapak(String ket_lapak) {
        this.ket_lapak = ket_lapak;
    }

    public String getKet_lapak() {
        return ket_lapak;
    }

    public void setId_keranjang(String id_keranjang) {
        this.id_keranjang = id_keranjang;
    }

    public String getId_keranjang() {
        return id_keranjang;
    }

    public void setId_lapak(String id_lapak) {
        this.id_lapak = id_lapak;
    }

    public String getId_lapak() {
        return id_lapak;
    }

    public void setJml(String jml) {
        this.jml = jml;
    }

    public String getJml() {
        return jml;
    }

    public void setId_transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getId_transaksi() {
        return id_transaksi;
    }

    public void setTgl_pakai(String tgl_pakai) {
        this.tgl_pakai = tgl_pakai;
    }

    public String getTgl_pakai() {
        return tgl_pakai;
    }

    public void setTampil_keranjang(String tampil_keranjang) {
        this.tampil_keranjang = tampil_keranjang;
    }

    public String getTampil_keranjang() {
        return tampil_keranjang;
    }

    public void setId_pembeli(String id_pembeli) {
        this.id_pembeli = id_pembeli;
    }

    public String getId_pembeli() {
        return id_pembeli;
    }
}