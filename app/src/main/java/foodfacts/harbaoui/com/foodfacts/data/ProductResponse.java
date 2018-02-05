package foodfacts.harbaoui.com.foodfacts.data;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amine on 2/1/18.
 */

public class ProductResponse {

    @SerializedName("product")
    private Product product;
    @SerializedName("status_verbose")
    private String statusVerbose;
    @SerializedName("code")
    private String code;
    @SerializedName("status")
    private Integer status;



    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getStatusVerbose() {
        return statusVerbose;
    }

    public void setStatusVerbose(String statusVerbose) {
        this.statusVerbose = statusVerbose;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "product=" + product +
                ", statusVerbose='" + statusVerbose + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                '}';
    }
}
