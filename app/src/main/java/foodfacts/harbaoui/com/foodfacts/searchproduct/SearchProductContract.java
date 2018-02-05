package foodfacts.harbaoui.com.foodfacts.searchproduct;

import foodfacts.harbaoui.com.foodfacts.data.HistoryProduct;
import foodfacts.harbaoui.com.foodfacts.data.Product;

/**
 * Created by amine on 2/1/18.
 */

public interface SearchProductContract {

    interface View {

        void onGetProductSuccess(Product product);

        void onGetProductFailure(String msg);

        void onSaveHistoryProductSuccess(HistoryProduct historyProduct);

        void onSaveHistoryProductFailure(String msg);

    }

    interface Presenter {

        void getProduct(String barcode);

        void saveHistoryProduct(HistoryProduct historyProduct);
    }

    interface Interactor {

        void getProductFromApi(String barcode);

        void saveHistoryProductToDb(HistoryProduct historyProduct);


    }

    interface onGetProductListener {

        void onGetProductSuccess(Product product);

        void onGetProductFailure(String msg);

        void onSaveHistoryProductSuccess(HistoryProduct historyProduct);

        void onSaveHistoryProductFailure(String msg);
    }
}
