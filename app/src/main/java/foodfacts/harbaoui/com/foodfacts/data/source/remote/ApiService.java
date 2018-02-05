package foodfacts.harbaoui.com.foodfacts.data.source.remote;

import foodfacts.harbaoui.com.foodfacts.data.ProductResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

/**
 * Created by amine on 2/1/18.
 */

public interface ApiService {

    @Headers("Cache-Control: max-age=640000, s-maxage=640000 , max-stale=2419200")
    @GET("/api/v0/product/{barcode}.json")
    Observable<ProductResponse> getProductByBarcode(@Path("barcode") String barcode);
}
