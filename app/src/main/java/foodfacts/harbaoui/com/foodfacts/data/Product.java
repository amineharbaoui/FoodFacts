package foodfacts.harbaoui.com.foodfacts.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by amine on 2/1/18.
 */

public class Product implements Parcelable {

    /** Product characteristics */
    @SerializedName("code")
    private String barcode;

    @SerializedName("product_name")
    private String productName;

    @SerializedName("generic_name")
    private String genericName;

    @SerializedName("quantity")
    private String quantity;

    @SerializedName("packaging_tags")
    private List<String> packagingTags = null;

    @SerializedName("brands_tags")
    private List<String> brandsTags = null;

    @SerializedName("categories_tags")
    private List<String> categoriesTags = null;

    @SerializedName("labels_tags")
    private List<String> labelsTags = null;

    @SerializedName("manufacturing_places_tags")
    private List<String> manufacturingPlacesTags = null;

    @SerializedName("link")
    private String link;

    @SerializedName("countries_tags")
    private List<String> countriesTags = null;


    @SerializedName("image_thumb_url")
    private String imageThumbUrl;

    @SerializedName("image_url")
    private String imageUrl;

    /** Ingredients */

    @SerializedName("ingredients_tags")
    private List<String> ingredientsTags = null;

    @SerializedName("additives_tags")
    private List<String> additivesTags = null;

    @SerializedName("traces_tags")
    private List<String> tracesTags;

    @SerializedName("allergens_tags")
    private List<String> allergensTags = null;

    @SerializedName("image_ingredients_url")
    private String imageIngredientsUrl;

    /** Nutrition facts */

    @SerializedName("nutrition_grades")
    private String nutritionGrades;

    @SerializedName("nutriments")
    private Nutriments nutriments;

    @SerializedName("nutrient_levels")
    private NutrientLevels nutrientLevels;

    @SerializedName("image_nutrition_url")
    private String imageNutritionUrl;

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public List<String> getPackagingTags() {
        return packagingTags;
    }

    public void setPackagingTags(List<String> packagingTags) {
        this.packagingTags = packagingTags;
    }

    public List<String> getBrandsTags() {
        return brandsTags;
    }

    public void setBrandsTags(List<String> brandsTags) {
        this.brandsTags = brandsTags;
    }

    public List<String> getCategoriesTags() {
        return categoriesTags;
    }

    public void setCategoriesTags(List<String> categoriesTags) {
        this.categoriesTags = categoriesTags;
    }

    public List<String> getLabelsTags() {
        return labelsTags;
    }

    public void setLabelsTags(List<String> labelsTags) {
        this.labelsTags = labelsTags;
    }

    public List<String> getManufacturingPlacesTags() {
        return manufacturingPlacesTags;
    }

    public void setManufacturingPlacesTags(List<String> manufacturingPlacesTags) {
        this.manufacturingPlacesTags = manufacturingPlacesTags;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<String> getCountriesTags() {
        return countriesTags;
    }

    public void setCountriesTags(List<String> countriesTags) {
        this.countriesTags = countriesTags;
    }

    public String getImageThumbUrl() {
        return imageThumbUrl;
    }

    public void setImageThumbUrl(String imageThumbUrl) {
        this.imageThumbUrl = imageThumbUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<String> getIngredientsTags() {
        return ingredientsTags;
    }

    public void setIngredientsTags(List<String> ingredientsTags) {
        this.ingredientsTags = ingredientsTags;
    }

    public List<String> getAdditivesTags() {
        return additivesTags;
    }

    public void setAdditivesTags(List<String> additivesTags) {
        this.additivesTags = additivesTags;
    }

    public List<String> getTracesTags() {
        return tracesTags;
    }

    public void setTracesTags(List<String> tracesTags) {
        this.tracesTags = tracesTags;
    }

    public List<String> getAllergensTags() {
        return allergensTags;
    }

    public void setAllergensTags(List<String> allergensTags) {
        this.allergensTags = allergensTags;
    }

    public String getImageIngredientsUrl() {
        return imageIngredientsUrl;
    }

    public void setImageIngredientsUrl(String imageIngredientsUrl) {
        this.imageIngredientsUrl = imageIngredientsUrl;
    }

    public String getNutritionGrades() {
        return nutritionGrades;
    }

    public void setNutritionGrades(String nutritionGrades) {
        this.nutritionGrades = nutritionGrades;
    }

    public Nutriments getNutriments() {
        return nutriments;
    }

    public void setNutriments(Nutriments nutriments) {
        this.nutriments = nutriments;
    }

    public NutrientLevels getNutrientLevels() {
        return nutrientLevels;
    }

    public void setNutrientLevels(NutrientLevels nutrientLevels) {
        this.nutrientLevels = nutrientLevels;
    }

    public String getImageNutritionUrl() {
        return imageNutritionUrl;
    }

    public void setImageNutritionUrl(String imageNutritionUrl) {
        this.imageNutritionUrl = imageNutritionUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName+  '\'' + '\n'+
                "genericName='" + genericName + '\'' + '\n'+
                ", quantity='" + quantity + '\'' +'\n'+
                ", packagingTags=" + packagingTags +'\n'+
                ", brandsTags=" + brandsTags +'\n'+
                ", categoriesTags=" + categoriesTags +'\n'+
                ", labelsTags=" + labelsTags +'\n'+
                ", manufacturingPlacesTags=" + manufacturingPlacesTags +'\n'+
                ", link='" + link + '\'' +'\n'+
                ", countriesTags=" + countriesTags +'\n'+
                ", ingredientsTags=" + ingredientsTags +'\n'+
                ", additivesTags=" + additivesTags +'\n'+
                ", allergensTags=" + allergensTags +'\n'+
                ", nutritionGrades='" + nutritionGrades + '\'' +'\n'+
                ", nutriments=" + nutriments +'\n'+
                '}';
    }


    public Product() {
    }


    public String getPackagingString() {
        String s = packagingTags.toString();
        s = filterString(s);
        return s.substring(1, s.length() - 1);
    }

    public String getBrandsString() {
        String s = brandsTags.toString();
        s = filterString(s);
        return s.substring(1, s.length() - 1);
    }

    public String getCategoriesString() {
        String s = categoriesTags.toString();
        s = filterString(s);
        return s.substring(1, s.length() - 1);
    }

    public String getLabelsString() {
        String s = labelsTags.toString();
        s = filterString(s);
        return s.substring(1, s.length() - 1);
    }

    public String getManufacturingPlacesTagsString() {
        String s = manufacturingPlacesTags.toString();
        s = filterString(s);
        return s.substring(1, s.length() - 1);
    }

    public String getCountriesString() {
        String s = countriesTags.toString();
        s = filterString(s);
        return s.substring(1, s.length() - 1);
    }


    public String getIngredientsTagsString() {
        String s = ingredientsTags.toString();
        s = filterString(s);
        return s.substring(1,s.length()-1);
    }

    public String getAdditivesTagsString() {
        String s = additivesTags.toString();
        s = filterString(s);
        return s.substring(1,s.length()-1);
    }

    public String getAllergensTagsString() {
        String s = allergensTags.toString();
        s = filterString(s);
        return s.substring(1,s.length()-1);
    }

    public String getTracesTagsString() {
        String s = tracesTags.toString();
        s = filterString(s);
        return s.substring(1,s.length()-1);
    }

    private String filterString(String s) {
        return s.replaceAll("(en:|fr:|-)"," ");
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.barcode);
        dest.writeString(this.productName);
        dest.writeString(this.genericName);
        dest.writeString(this.quantity);
        dest.writeStringList(this.packagingTags);
        dest.writeStringList(this.brandsTags);
        dest.writeStringList(this.categoriesTags);
        dest.writeStringList(this.labelsTags);
        dest.writeStringList(this.manufacturingPlacesTags);
        dest.writeString(this.link);
        dest.writeStringList(this.countriesTags);
        dest.writeString(this.imageThumbUrl);
        dest.writeString(this.imageUrl);
        dest.writeStringList(this.ingredientsTags);
        dest.writeStringList(this.additivesTags);
        dest.writeStringList(this.tracesTags);
        dest.writeStringList(this.allergensTags);
        dest.writeString(this.imageIngredientsUrl);
        dest.writeString(this.nutritionGrades);
        dest.writeParcelable(this.nutriments, flags);
        dest.writeParcelable(this.nutrientLevels, flags);
        dest.writeString(this.imageNutritionUrl);
    }

    protected Product(Parcel in) {
        this.barcode = in.readString();
        this.productName = in.readString();
        this.genericName = in.readString();
        this.quantity = in.readString();
        this.packagingTags = in.createStringArrayList();
        this.brandsTags = in.createStringArrayList();
        this.categoriesTags = in.createStringArrayList();
        this.labelsTags = in.createStringArrayList();
        this.manufacturingPlacesTags = in.createStringArrayList();
        this.link = in.readString();
        this.countriesTags = in.createStringArrayList();
        this.imageThumbUrl = in.readString();
        this.imageUrl = in.readString();
        this.ingredientsTags = in.createStringArrayList();
        this.additivesTags = in.createStringArrayList();
        this.tracesTags = in.createStringArrayList();
        this.allergensTags = in.createStringArrayList();
        this.imageIngredientsUrl = in.readString();
        this.nutritionGrades = in.readString();
        this.nutriments = in.readParcelable(Nutriments.class.getClassLoader());
        this.nutrientLevels = in.readParcelable(NutrientLevels.class.getClassLoader());
        this.imageNutritionUrl = in.readString();
    }

    public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel source) {
            return new Product(source);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };
}


