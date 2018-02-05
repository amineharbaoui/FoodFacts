package foodfacts.harbaoui.com.foodfacts.data;

/**
 * Created by amine on 2/4/18.
 */

public class NutrientFactsItem {

    private String factName;
    private String factValueG;
    private String factValueS;

    public NutrientFactsItem() {}

    public NutrientFactsItem(String factName, String factValueG, String factValueS) {
        this.factName = factName;
        this.factValueG = factValueG;
        this.factValueS = factValueS;
    }

    public String getFactName() {
        return factName;
    }

    public void setFactName(String factName) {
        this.factName = factName;
    }

    public String getFactValueG() {
        return factValueG;
    }

    public void setFactValueG(String factValueG) {
        this.factValueG = factValueG;
    }

    public String getFactValueS() {
        return factValueS;
    }

    public void setFactValueS(String factValueS) {
        this.factValueS = factValueS;
    }

    @Override
    public String toString() {
        return "NutrientFactsItem{" +
                "factName='" + factName + '\'' +
                ", factValueG='" + factValueG + '\'' +
                ", factValueS='" + factValueS + '\'' +
                '}';
    }
}
