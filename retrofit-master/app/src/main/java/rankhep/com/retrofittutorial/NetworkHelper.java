package rankhep.com.retrofittutorial;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkHelper {
    final static String url = "http://aws.soylatte.kr";
    final static int port = 5000;
    //         http://aws.soylatte.kr:5000

    private static Retrofit retrofit;

    public static NetworkInterface getInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(url + ":" + port)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(NetworkInterface.class);
    }

}
