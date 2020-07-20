package com.basbas.portalevent.ui.keranjang.model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
/**
 * Awesome Pojo Generator
 * */
public class ResponseKeranjangNew{
  @SerializedName("pesan")
  @Expose
  private String pesan;
  @SerializedName("data")
  @Expose
  private List<DataKeranjang> data;
  @SerializedName("sukses")
  @Expose
  private Boolean sukses;
  public void setPesan(String pesan){
   this.pesan=pesan;
  }
  public String getPesan(){
   return pesan;
  }
  public void setData(List<DataKeranjang> data){
   this.data=data;
  }
  public List<DataKeranjang> getData(){
   return data;
  }
  public void setSukses(Boolean sukses){
   this.sukses=sukses;
  }
  public Boolean getSukses(){
   return sukses;
  }
}