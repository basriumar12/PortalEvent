package com.basbas.portalevent.network;

import com.basbas.portalevent.model.ResponseCategories;
import com.basbas.portalevent.model.ResponseData;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestApi {


    @FormUrlEncoded
    @POST("user_register.php")
    Call<ResponseData>userRegister(@Field("nama_user") String namaUser,
                                  @Field("username_user") String userName,
                                  @Field("pass_user") String password,
                                  @Field("alamat") String alamat,
                                  @Field("no_telp") String noTelp


                                  );


    @FormUrlEncoded
    @POST("user_login.php")
    Call<ResponseData>userLogin(@Field("username") String userName,
                                @Field("password") String password
    );

    @FormUrlEncoded
    @POST("get_barang.php/id_jenis=jenis-0001")
    Call<ResponseData>getBarang001(@Field("id_pelapak") String idPelapak,
                                  @Field("id_mitra") String idMitra,
                                  @Field("id_jenis") String namaPelapak,
                                  @Field("detail") String idJenis,
                                  @Field("ketersediaan") String detail,
                                  @Field("harga") String harga,
                                  @Field("foto") String foto

    );
    @FormUrlEncoded
    @POST("get_barang.php")
    Call<ArrayList<ResponseCategories>>getBarangCategories(

            @Field("id_jenis") String idJenis


    );


}
