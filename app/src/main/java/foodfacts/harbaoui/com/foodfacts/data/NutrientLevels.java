package foodfacts.harbaoui.com.foodfacts.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amine on 2/4/18.
 */

public class NutrientLevels implements Parcelable {

    @SerializedName("fat")
    private String fat;
    @SerializedName("sugars")
    private String sugar;
    @SerializedName("saturated-fat")
    private String saturatedFat;
    @SerializedName("salt")
    private String salt;

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getSugar() {
        return sugar;
    }

    public void setSugar(String sugar) {
        this.sugar = sugar;
    }

    public String getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(String saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.fat);
        dest.writeString(this.sugar);
        dest.writeString(this.saturatedFat);
        dest.writeString(this.salt);
    }

    public NutrientLevels() {
    }

    protected NutrientLevels(Parcel in) {
        this.fat = in.readString();
        this.sugar = in.readString();
        this.saturatedFat = in.readString();
        this.salt = in.readString();
    }

    public static final Parcelable.Creator<NutrientLevels> CREATOR = new Parcelable.Creator<NutrientLevels>() {
        @Override
        public NutrientLevels createFromParcel(Parcel source) {
            return new NutrientLevels(source);
        }

        @Override
        public NutrientLevels[] newArray(int size) {
            return new NutrientLevels[size];
        }
    };

    @Override
    public String toString() {
        return "NutrientLevels{" +
                "fat='" + fat + '\'' +
                ", sugar='" + sugar + '\'' +
                ", saturatedFat='" + saturatedFat + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
