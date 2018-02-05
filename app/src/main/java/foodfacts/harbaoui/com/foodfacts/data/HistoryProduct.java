package foodfacts.harbaoui.com.foodfacts.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Keep;

/**
 * Created by amine on 2/5/18.
 */

@Entity
public class HistoryProduct {

    @Id
    private String barcode;
    private String title;
    private String urlImage;


    @Generated(hash = 209307096)
    public HistoryProduct(String barcode, String title, String urlImage) {
        this.barcode = barcode;
        this.title = title;
        this.urlImage = urlImage;
    }

    @Generated(hash = 1674709907)
    public HistoryProduct() {
    }
    

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    @Override
    public String toString() {
        return "HistoryProduct{" +
                "barcode='" + barcode + '\'' +
                ", title='" + title + '\'' +
                ", urlImage='" + urlImage + '\'' +
                '}';
    }
}
