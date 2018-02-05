package foodfacts.harbaoui.com.foodfacts.historyproductdetail;

import foodfacts.harbaoui.com.foodfacts.data.HistoryProduct;
import foodfacts.harbaoui.com.foodfacts.data.Product;

/**
 * Created by amine on 2/1/18.
 */

public interface HistoryProductDetailContract {

    interface View {

        void onGetProductSuccess(Product product);

        void onGetProductFailure(String msg);

    }

    interface Presenter {

        void getProduct(String barcode);
    }

    interface Interactor {

        void getProductFromCache(String barcode);

    }

    interface onGetProductListener {

        void onGetProductSuccess(Product product);

        void onGetProductFailure(String msg);
    }
}
