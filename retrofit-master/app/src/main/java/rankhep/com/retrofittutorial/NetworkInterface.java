package rankhep.com.retrofittutorial;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

interface NetworkInterface {


    @GET("/query")
    Call<Data> GETData(@Query("text") String text);

    @POST("/query")
    @FormUrlEncoded
    Call<Data> POSTData(@Field("text") String text);




}
