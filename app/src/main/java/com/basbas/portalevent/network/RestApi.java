package com.basbas.portalevent.network;

import com.basbas.portalevent.model.ResponseCategories;
import com.basbas.portalevent.model.ResponseData;
import com.basbas.portalevent.model.ResponseKeranjang;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {


    @FormUrlEncoded
    @POST("user_register.php")
    Call<ResponseData> userRegister(@Field("nama_user") String namaUser,
                                    @Field("username_user") String userName,
                                    @Field("pass_user") String password,
                                    @Field("alamat") String alamat,
                                    @Field("no_telp") String noTelp
    );


    @FormUrlEncoded
    @POST("user_login.php")
    Call<ResponseData> userLogin(@Field("username") String userName,
                                 @Field("password") String password
    );


    @FormUrlEncoded
    @POST("get_barang.php")
    Call<ArrayList<ResponseCategories>> getBarangCategories(

            @Field("id_jenis") String idJenis


    );

    @FormUrlEncoded
    @POST("get_keranjang.php")
    Call<ArrayList<ResponseKeranjang>> getKeranjang(
            @Field("id_pembeli") String idPembeli


    );

    @FormUrlEncoded
    @POST("post_keranjang.php")
    Call<ResponseData> postKeranjang(
            @Field("id_pembeli") String idPembeli,
            @Field("id_lapak") String idLapak,
            @Field("tgl_pakai") String tanggalPakai,
            @Field("ket_lapak") String keteranganLapak,
            @Field("jml") String jumlah,
            @Field("tampil_keranjang") String tampilKeranjang
    );

}
