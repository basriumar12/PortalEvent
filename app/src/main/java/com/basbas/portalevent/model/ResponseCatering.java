package com.basbas.portalevent.model;

public class ResponseCatering {
    private String ketersediaan;

    private String url_foto;

    private String harga;

    private String id_jenis;

    private String id_lapak;

    private String nama_lapak;

    private String id_mitra;

    private String detail;

    public String getKetersediaan ()
    {
        return ketersediaan;
    }

    public void setKetersediaan (String ketersediaan)
    {
        this.ketersediaan = ketersediaan;
    }

    public String getUrl_foto ()
    {
        return url_foto;
    }

    public void setUrl_foto (String url_foto)
    {
        this.url_foto = url_foto;
    }

    public String getHarga ()
    {
        return harga;
    }

    public void setHarga (String harga)
    {
        this.harga = harga;
    }

    public String getId_jenis ()
    {
        return id_jenis;
    }

    public void setId_jenis (String id_jenis)
    {
        this.id_jenis = id_jenis;
    }

    public String getId_lapak ()
    {
        return id_lapak;
    }

    public void setId_lapak (String id_lapak){
        this.id_lapak = id_lapak;
    }

    public String getNama_lapak ()
    {
        return nama_lapak;
    }

    public void setNama_lapak (String nama_lapak)
    {
        this.nama_lapak = nama_lapak;
    }

    public String getId_mitra ()
    {
        return id_mitra;
    }

    public void setId_mitra (String id_mitra)
    {
        this.id_mitra = id_mitra;
    }

    public String getDetail ()
    {
        return detail;
    }

    public void setDetail (String detail)
    {
        this.detail = detail;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [ketersediaan = "+ketersediaan+", url_foto = "+url_foto+", harga = "+harga+", id_jenis = "+id_jenis+", id_lapak = "+id_lapak+", nama_lapak = "+nama_lapak+", id_mitra = "+id_mitra+", detail = "+detail+"]";
    }
}
