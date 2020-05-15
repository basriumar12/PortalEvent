package com.basbas.portalevent.network;

import com.basbas.portalevent.model.ResponseData;

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
    Call<ResponseData>userLogin(@Field("username") String usermame,
                                @Field("password") String password);
}
