package foodfacts.harbaoui.com.foodfacts.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by amine on 2/1/18.
 */

public class Nutriments implements Parcelable {

    @SerializedName("salt")
    @Expose
    private String salt;
    @SerializedName("proteins_unit")
    @Expose
    private String proteinsUnit;
    @SerializedName("fat")
    @Expose
    private String fat;
    @SerializedName("saturated-fat_100g")
    @Expose
    private String saturatedFat100g;
    @SerializedName("sugars")
    @Expose
    private String sugars;
    @SerializedName("fat_100g")
    @Expose
    private String fat100g;
    @SerializedName("saturated-fat_value")
    @Expose
    private String saturatedFatValue;
    @SerializedName("fat_unit")
    @Expose
    private String fatUnit;
    @SerializedName("proteins_100g")
    @Expose
    private String proteins100g;
    @SerializedName("salt_value")
    @Expose
    private String saltValue;
    @SerializedName("fiber_value")
    @Expose
    private String fiberValue;
    @SerializedName("proteins")
    @Expose
    private String proteins;
    @SerializedName("proteins_value")
    @Expose
    private String proteinsValue;
    @SerializedName("salt_unit")
    @Expose
    private String saltUnit;
    @SerializedName("energy_value")
    @Expose
    private String energyValue;
    @SerializedName("energy_100g")
    @Expose
    private String energy100g;
    @SerializedName("sodium_serving")
    @Expose
    private String sodiumServing;
    @SerializedName("nutrition-score-fr")
    @Expose
    private String nutritionScoreFr;
    @SerializedName("salt_serving")
    @Expose
    private String saltServing;
    @SerializedName("fiber_unit")
    @Expose
    private String fiberUnit;
    @SerializedName("sodium_100g")
    @Expose
    private String sodium100g;
    @SerializedName("carbohydrates_serving")
    @Expose
    private String carbohydratesServing;
    @SerializedName("nutrition-score-fr_100g")
    @Expose
    private String nutritionScoreFr100g;
    @SerializedName("carbohydrates_value")
    @Expose
    private String carbohydratesValue;
    @SerializedName("nutrition-score-uk")
    @Expose
    private String nutritionScoreUk;
    @SerializedName("energy_unit")
    @Expose
    private String energyUnit;
    @SerializedName("carbohydrates_100g")
    @Expose
    private String carbohydrates100g;
    @SerializedName("nutrition-score-uk_100g")
    @Expose
    private String nutritionScoreUk100g;
    @SerializedName("energy")
    @Expose
    private String energy;
    @SerializedName("fiber")
    @Expose
    private String fiber;
    @SerializedName("carbohydrates_unit")
    @Expose
    private String carbohydratesUnit;
    @SerializedName("sugars_serving")
    @Expose
    private String sugarsServing;
    @SerializedName("energy_serving")
    @Expose
    private String energyServing;
    @SerializedName("sugars_100g")
    @Expose
    private String sugars100g;
    @SerializedName("sodium")
    @Expose
    private String sodium;
    @SerializedName("saturated-fat_serving")
    @Expose
    private String saturatedFatServing;
    @SerializedName("fat_value")
    @Expose
    private String fatValue;
    @SerializedName("fat_serving")
    @Expose
    private String fatServing;
    @SerializedName("fiber_serving")
    @Expose
    private String fiberServing;
    @SerializedName("carbohydrates")
    @Expose
    private String carbohydrates;
    @SerializedName("salt_100g")
    @Expose
    private String salt100g;
    @SerializedName("sugars_value")
    @Expose
    private String sugarsValue;
    @SerializedName("sugars_unit")
    @Expose
    private String sugarsUnit;
    @SerializedName("proteins_serving")
    @Expose
    private String proteinsServing;
    @SerializedName("fiber_100g")
    @Expose
    private String fiber100g;
    @SerializedName("saturated-fat_unit")
    @Expose
    private String saturatedFatUnit;
    @SerializedName("saturated-fat")
    @Expose
    private String saturatedFat;

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getProteinsUnit() {
        return proteinsUnit;
    }

    public void setProteinsUnit(String proteinsUnit) {
        this.proteinsUnit = proteinsUnit;
    }

    public String getFat() {
        return fat;
    }

    public void setFat(String fat) {
        this.fat = fat;
    }

    public String getSaturatedFat100g() {
        return saturatedFat100g;
    }

    public void setSaturatedFat100g(String saturatedFat100g) {
        this.saturatedFat100g = saturatedFat100g;
    }

    public String getSugars() {
        return sugars;
    }

    public void setSugars(String sugars) {
        this.sugars = sugars;
    }

    public String getFat100g() {
        return fat100g;
    }

    public void setFat100g(String fat100g) {
        this.fat100g = fat100g;
    }

    public String getSaturatedFatValue() {
        return saturatedFatValue;
    }

    public void setSaturatedFatValue(String saturatedFatValue) {
        this.saturatedFatValue = saturatedFatValue;
    }

    public String getFatUnit() {
        return fatUnit;
    }

    public void setFatUnit(String fatUnit) {
        this.fatUnit = fatUnit;
    }

    public String getProteins100g() {
        return proteins100g;
    }

    public void setProteins100g(String proteins100g) {
        this.proteins100g = proteins100g;
    }

    public String getSaltValue() {
        return saltValue;
    }

    public void setSaltValue(String saltValue) {
        this.saltValue = saltValue;
    }

    public String getFiberValue() {
        return fiberValue;
    }

    public void setFiberValue(String fiberValue) {
        this.fiberValue = fiberValue;
    }

    public String getProteins() {
        return proteins;
    }

    public void setProteins(String proteins) {
        this.proteins = proteins;
    }

    public String getProteinsValue() {
        return proteinsValue;
    }

    public void setProteinsValue(String proteinsValue) {
        this.proteinsValue = proteinsValue;
    }

    public String getSaltUnit() {
        return saltUnit;
    }

    public void setSaltUnit(String saltUnit) {
        this.saltUnit = saltUnit;
    }

    public String getEnergyValue() {
        return energyValue;
    }

    public void setEnergyValue(String energyValue) {
        this.energyValue = energyValue;
    }

    public String getEnergy100g() {
        return energy100g;
    }

    public void setEnergy100g(String energy100g) {
        this.energy100g = energy100g;
    }

    public String getSodiumServing() {
        return sodiumServing;
    }

    public void setSodiumServing(String sodiumServing) {
        this.sodiumServing = sodiumServing;
    }

    public String getNutritionScoreFr() {
        return nutritionScoreFr;
    }

    public void setNutritionScoreFr(String nutritionScoreFr) {
        this.nutritionScoreFr = nutritionScoreFr;
    }

    public String getSaltServing() {
        return saltServing;
    }

    public void setSaltServing(String saltServing) {
        this.saltServing = saltServing;
    }

    public String getFiberUnit() {
        return fiberUnit;
    }

    public void setFiberUnit(String fiberUnit) {
        this.fiberUnit = fiberUnit;
    }

    public String getSodium100g() {
        return sodium100g;
    }

    public void setSodium100g(String sodium100g) {
        this.sodium100g = sodium100g;
    }

    public String getCarbohydratesServing() {
        return carbohydratesServing;
    }

    public void setCarbohydratesServing(String carbohydratesServing) {
        this.carbohydratesServing = carbohydratesServing;
    }

    public String getNutritionScoreFr100g() {
        return nutritionScoreFr100g;
    }

    public void setNutritionScoreFr100g(String nutritionScoreFr100g) {
        this.nutritionScoreFr100g = nutritionScoreFr100g;
    }

    public String getCarbohydratesValue() {
        return carbohydratesValue;
    }

    public void setCarbohydratesValue(String carbohydratesValue) {
        this.carbohydratesValue = carbohydratesValue;
    }

    public String getNutritionScoreUk() {
        return nutritionScoreUk;
    }

    public void setNutritionScoreUk(String nutritionScoreUk) {
        this.nutritionScoreUk = nutritionScoreUk;
    }

    public String getEnergyUnit() {
        return energyUnit;
    }

    public void setEnergyUnit(String energyUnit) {
        this.energyUnit = energyUnit;
    }

    public String getCarbohydrates100g() {
        return carbohydrates100g;
    }

    public void setCarbohydrates100g(String carbohydrates100g) {
        this.carbohydrates100g = carbohydrates100g;
    }

    public String getNutritionScoreUk100g() {
        return nutritionScoreUk100g;
    }

    public void setNutritionScoreUk100g(String nutritionScoreUk100g) {
        this.nutritionScoreUk100g = nutritionScoreUk100g;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getFiber() {
        return fiber;
    }

    public void setFiber(String fiber) {
        this.fiber = fiber;
    }

    public String getCarbohydratesUnit() {
        return carbohydratesUnit;
    }

    public void setCarbohydratesUnit(String carbohydratesUnit) {
        this.carbohydratesUnit = carbohydratesUnit;
    }

    public String getSugarsServing() {
        return sugarsServing;
    }

    public void setSugarsServing(String sugarsServing) {
        this.sugarsServing = sugarsServing;
    }

    public String getEnergyServing() {
        return energyServing;
    }

    public void setEnergyServing(String energyServing) {
        this.energyServing = energyServing;
    }

    public String getSugars100g() {
        return sugars100g;
    }

    public void setSugars100g(String sugars100g) {
        this.sugars100g = sugars100g;
    }

    public String getSodium() {
        return sodium;
    }

    public void setSodium(String sodium) {
        this.sodium = sodium;
    }

    public String getSaturatedFatServing() {
        return saturatedFatServing;
    }

    public void setSaturatedFatServing(String saturatedFatServing) {
        this.saturatedFatServing = saturatedFatServing;
    }

    public String getFatValue() {
        return fatValue;
    }

    public void setFatValue(String fatValue) {
        this.fatValue = fatValue;
    }

    public String getFatServing() {
        return fatServing;
    }

    public void setFatServing(String fatServing) {
        this.fatServing = fatServing;
    }

    public String getFiberServing() {
        return fiberServing;
    }

    public void setFiberServing(String fiberServing) {
        this.fiberServing = fiberServing;
    }

    public String getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(String carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public String getSalt100g() {
        return salt100g;
    }

    public void setSalt100g(String salt100g) {
        this.salt100g = salt100g;
    }

    public String getSugarsValue() {
        return sugarsValue;
    }

    public void setSugarsValue(String sugarsValue) {
        this.sugarsValue = sugarsValue;
    }

    public String getSugarsUnit() {
        return sugarsUnit;
    }

    public void setSugarsUnit(String sugarsUnit) {
        this.sugarsUnit = sugarsUnit;
    }

    public String getProteinsServing() {
        return proteinsServing;
    }

    public void setProteinsServing(String proteinsServing) {
        this.proteinsServing = proteinsServing;
    }

    public String getFiber100g() {
        return fiber100g;
    }

    public void setFiber100g(String fiber100g) {
        this.fiber100g = fiber100g;
    }

    public String getSaturatedFatUnit() {
        return saturatedFatUnit;
    }

    public void setSaturatedFatUnit(String saturatedFatUnit) {
        this.saturatedFatUnit = saturatedFatUnit;
    }

    public String getSaturatedFat() {
        return saturatedFat;
    }

    public void setSaturatedFat(String saturatedFat) {
        this.saturatedFat = saturatedFat;
    }

    @Override
    public String toString() {
        return "Nutriments{" +
                "salt=" + salt +
                ", proteinsUnit='" + proteinsUnit + '\'' + '\n'+
                ", fat=" + fat +'\n'+
                ", saturatedFat100g=" + saturatedFat100g +'\n'+
                ", sugars=" + sugars +'\n'+
                ", fat100g=" + fat100g +'\n'+
                ", saturatedFatValue='" + saturatedFatValue + '\'' +'\n'+
                ", fatUnit='" + fatUnit + '\'' +'\n'+
                ", proteins100g=" + proteins100g +'\n'+
                ", saltValue='" + saltValue + '\'' +'\n'+
                ", fiberValue='" + fiberValue + '\'' +'\n'+
                ", proteins=" + proteins +'\n'+
                ", proteinsValue='" + proteinsValue + '\'' +'\n'+
                ", saltUnit='" + saltUnit + '\'' +'\n'+
                ", energyValue='" + energyValue + '\'' +'\n'+
                ", energy100g='" + energy100g + '\'' +'\n'+
                ", sodiumServing=" + sodiumServing +'\n'+
                ", nutritionScoreFr='" + nutritionScoreFr + '\'' +'\n'+
                ", saltServing=" + saltServing +'\n'+
                ", fiberUnit='" + fiberUnit + '\'' +'\n'+
                ", sodium100g=" + sodium100g +'\n'+
                ", carbohydratesServing=" + carbohydratesServing +'\n'+
                ", nutritionScoreFr100g='" + nutritionScoreFr100g + '\'' +'\n'+
                ", carbohydratesValue='" + carbohydratesValue + '\'' +'\n'+
                ", nutritionScoreUk='" + nutritionScoreUk + '\'' +'\n'+
                ", energyUnit='" + energyUnit + '\'' +'\n'+
                ", carbohydrates100g=" + carbohydrates100g +'\n'+
                ", nutritionScoreUk100g='" + nutritionScoreUk100g + '\'' +'\n'+
                ", energy='" + energy + '\'' +'\n'+
                ", fiber=" + fiber +'\n'+
                ", carbohydratesUnit='" + carbohydratesUnit + '\'' +'\n'+
                ", sugarsServing=" + sugarsServing +'\n'+
                ", energyServing='" + energyServing + '\'' +'\n'+
                ", sugars100g=" + sugars100g +'\n'+
                ", sodium=" + sodium +'\n'+
                ", saturatedFatServing=" + saturatedFatServing +'\n'+
                ", fatValue='" + fatValue + '\'' +'\n'+
                ", fatServing=" + fatServing +'\n'+
                ", fiberServing=" + fiberServing +'\n'+
                ", carbohydrates=" + carbohydrates +'\n'+
                ", salt100g=" + salt100g +'\n'+
                ", sugarsValue='" + sugarsValue + '\'' +'\n'+
                ", sugarsUnit='" + sugarsUnit + '\'' +'\n'+
                ", proteinsServing=" + proteinsServing +'\n'+
                ", fiber100g=" + fiber100g +'\n'+
                ", saturatedFatUnit='" + saturatedFatUnit + '\'' +'\n'+
                ", saturatedFat=" + saturatedFat +'\n'+
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.salt);
        dest.writeString(this.proteinsUnit);
        dest.writeString(this.fat);
        dest.writeString(this.saturatedFat100g);
        dest.writeString(this.sugars);
        dest.writeString(this.fat100g);
        dest.writeString(this.saturatedFatValue);
        dest.writeString(this.fatUnit);
        dest.writeString(this.proteins100g);
        dest.writeString(this.saltValue);
        dest.writeString(this.fiberValue);
        dest.writeString(this.proteins);
        dest.writeString(this.proteinsValue);
        dest.writeString(this.saltUnit);
        dest.writeString(this.energyValue);
        dest.writeString(this.energy100g);
        dest.writeString(this.sodiumServing);
        dest.writeString(this.nutritionScoreFr);
        dest.writeString(this.saltServing);
        dest.writeString(this.fiberUnit);
        dest.writeString(this.sodium100g);
        dest.writeString(this.carbohydratesServing);
        dest.writeString(this.nutritionScoreFr100g);
        dest.writeString(this.carbohydratesValue);
        dest.writeString(this.nutritionScoreUk);
        dest.writeString(this.energyUnit);
        dest.writeString(this.carbohydrates100g);
        dest.writeString(this.nutritionScoreUk100g);
        dest.writeString(this.energy);
        dest.writeString(this.fiber);
        dest.writeString(this.carbohydratesUnit);
        dest.writeString(this.sugarsServing);
        dest.writeString(this.energyServing);
        dest.writeString(this.sugars100g);
        dest.writeString(this.sodium);
        dest.writeString(this.saturatedFatServing);
        dest.writeString(this.fatValue);
        dest.writeString(this.fatServing);
        dest.writeString(this.fiberServing);
        dest.writeString(this.carbohydrates);
        dest.writeString(this.salt100g);
        dest.writeString(this.sugarsValue);
        dest.writeString(this.sugarsUnit);
        dest.writeString(this.proteinsServing);
        dest.writeString(this.fiber100g);
        dest.writeString(this.saturatedFatUnit);
        dest.writeString(this.saturatedFat);
    }

    public Nutriments() {
    }

    protected Nutriments(Parcel in) {
        this.salt = in.readString();
        this.proteinsUnit = in.readString();
        this.fat = in.readString();
        this.saturatedFat100g = in.readString();
        this.sugars = in.readString();
        this.fat100g = in.readString();
        this.saturatedFatValue = in.readString();
        this.fatUnit = in.readString();
        this.proteins100g = in.readString();
        this.saltValue = in.readString();
        this.fiberValue = in.readString();
        this.proteins = in.readString();
        this.proteinsValue = in.readString();
        this.saltUnit = in.readString();
        this.energyValue = in.readString();
        this.energy100g = in.readString();
        this.sodiumServing = in.readString();
        this.nutritionScoreFr = in.readString();
        this.saltServing = in.readString();
        this.fiberUnit = in.readString();
        this.sodium100g = in.readString();
        this.carbohydratesServing = in.readString();
        this.nutritionScoreFr100g = in.readString();
        this.carbohydratesValue = in.readString();
        this.nutritionScoreUk = in.readString();
        this.energyUnit = in.readString();
        this.carbohydrates100g = in.readString();
        this.nutritionScoreUk100g = in.readString();
        this.energy = in.readString();
        this.fiber = in.readString();
        this.carbohydratesUnit = in.readString();
        this.sugarsServing = in.readString();
        this.energyServing = in.readString();
        this.sugars100g = in.readString();
        this.sodium = in.readString();
        this.saturatedFatServing = in.readString();
        this.fatValue = in.readString();
        this.fatServing = in.readString();
        this.fiberServing = in.readString();
        this.carbohydrates = in.readString();
        this.salt100g = in.readString();
        this.sugarsValue = in.readString();
        this.sugarsUnit = in.readString();
        this.proteinsServing = in.readString();
        this.fiber100g = in.readString();
        this.saturatedFatUnit = in.readString();
        this.saturatedFat = in.readString();
    }

    public static final Parcelable.Creator<Nutriments> CREATOR = new Parcelable.Creator<Nutriments>() {
        @Override
        public Nutriments createFromParcel(Parcel source) {
            return new Nutriments(source);
        }

        @Override
        public Nutriments[] newArray(int size) {
            return new Nutriments[size];
        }
    };
}