package foodfacts.harbaoui.com.foodfacts.data.source.remote;

import foodfacts.harbaoui.com.foodfacts.application.App;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by amine on 2/1/18.
 */

public class ApiClient {

    private static Retrofit foodFactsApi = null;
    private static String BASE_URL = "https://world.openfoodfacts.org";

    public static Retrofit getApiClient() {
        int cacheSize = 10 * 1024 * 1024; // 10 MB
        Cache cache = new Cache(App.getInstance().getCacheDir(), cacheSize);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(cache)
                .build();


        if (foodFactsApi==null) {
            foodFactsApi = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return foodFactsApi;
    }
}
