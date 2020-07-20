package com.basbas.portalevent.ui.keranjang.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
/**
 * Awesome Pojo Generator
 * */
public class DataKeranjang {
  @SerializedName("id_keranjang")
  @Expose
  private Integer id_keranjang;
  @SerializedName("keterangan")
  @Expose
  private String keterangan;
  @SerializedName("harga")
  @Expose
  private Integer harga;
  @SerializedName("foto")
  @Expose
  private String foto;
  @SerializedName("id_lapak")
  @Expose
  private String id_lapak;
  @SerializedName("nama_lapak")
  @Expose
  private String nama_lapak;
  @SerializedName("jml")
  @Expose
  private Integer jml;
  @SerializedName("tgl")
  @Expose
  private String tgl;
  public void setId_keranjang(Integer id_keranjang){
   this.id_keranjang=id_keranjang;
  }
  public Integer getId_keranjang(){
   return id_keranjang;
  }
  public void setKeterangan(String keterangan){
   this.keterangan=keterangan;
  }
  public String getKeterangan(){
   return keterangan;
  }
  public void setHarga(Integer harga){
   this.harga=harga;
  }
  public Integer getHarga(){
   return harga;
  }
  public void setFoto(String foto){
   this.foto=foto;
  }
  public String getFoto(){
   return foto;
  }
  public void setId_lapak(String id_lapak){
   this.id_lapak=id_lapak;
  }
  public String getId_lapak(){
   return id_lapak;
  }
  public void setNama_lapak(String nama_lapak){
   this.nama_lapak=nama_lapak;
  }
  public String getNama_lapak(){
   return nama_lapak;
  }
  public void setJml(Integer jml){
   this.jml=jml;
  }
  public Integer getJml(){
   return jml;
  }
  public void setTgl(String tgl){
   this.tgl=tgl;
  }
  public String getTgl(){
   return tgl;
  }
}