package xin.qust.kg.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.io.Serializable;
import java.util.Set;

@NodeEntity
public class Chemical implements Serializable {

    @Id
    private String cas;

    private String chineseName;

    private String englishName;

    private String chemicalFormula;

    private Set<String> aliasName;

    private Double molecularWeight;

    private String density;

    private String meltingPoint;

    private String boilingPoint;

    private String flashPoint;

    private String waterSolubility;

    private String tension;

    private Set<String> riskCodes;

    private Set<String> safeCodes;

    @Relationship(type = "CONTAIN", direction = Relationship.UNDIRECTED)
    @JsonIgnore
    private Set<DangerCharacter> dangerCharacters;

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    public String getChemicalFormula() {
        return chemicalFormula;
    }

    public void setChemicalFormula(String chemicalFormula) {
        this.chemicalFormula = chemicalFormula;
    }

    public Set<String> getAliasName() {
        return aliasName;
    }

    public void setAliasName(Set<String> aliasName) {
        this.aliasName = aliasName;
    }

    public Double getMolecularWeight() {
        return molecularWeight;
    }

    public void setMolecularWeight(Double molecularWeight) {
        this.molecularWeight = molecularWeight;
    }

    public String getDensity() {
        return density;
    }

    public void setDensity(String density) {
        this.density = density;
    }

    public String getMeltingPoint() {
        return meltingPoint;
    }

    public void setMeltingPoint(String meltingPoint) {
        this.meltingPoint = meltingPoint;
    }

    public String getBoilingPoint() {
        return boilingPoint;
    }

    public void setBoilingPoint(String boilingPoint) {
        this.boilingPoint = boilingPoint;
    }

    public String getFlashPoint() {
        return flashPoint;
    }

    public void setFlashPoint(String flashPoint) {
        this.flashPoint = flashPoint;
    }

    public String getWaterSolubility() {
        return waterSolubility;
    }

    public void setWaterSolubility(String waterSolubility) {
        this.waterSolubility = waterSolubility;
    }

    public String getTension() {
        return tension;
    }

    public void setTension(String tension) {
        this.tension = tension;
    }

    public Set<String> getRiskCodes() {
        return riskCodes;
    }

    public void setRiskCodes(Set<String> riskCodes) {
        this.riskCodes = riskCodes;
    }

    public Set<String> getSafeCodes() {
        return safeCodes;
    }

    public void setSafeCodes(Set<String> safeCodes) {
        this.safeCodes = safeCodes;
    }

    public Set<DangerCharacter> getDangerCharacters() {
        return dangerCharacters;
    }

    public void setDangerCharacters(Set<DangerCharacter> dangerCharacters) {
        this.dangerCharacters = dangerCharacters;
    }

    @Override
    public String toString() {
        return "Chemical{" +
                "cas='" + cas + '\'' +
                ", chineseName='" + chineseName + '\'' +
                ", englishName='" + englishName + '\'' +
                ", chemicalFormula='" + chemicalFormula + '\'' +
                ", aliasName=" + aliasName +
                ", molecularWeight=" + molecularWeight +
                ", density='" + density + '\'' +
                ", meltingPoint='" + meltingPoint + '\'' +
                ", boilingPoint='" + boilingPoint + '\'' +
                ", flashPoint='" + flashPoint + '\'' +
                ", waterSolubility='" + waterSolubility + '\'' +
                ", tension='" + tension + '\'' +
                ", riskCodes=" + riskCodes +
                ", safeCodes=" + safeCodes +
                '}';
    }
}
