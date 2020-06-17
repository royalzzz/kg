package xin.qust.kg.task;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import xin.qust.kg.domain.Chemical;
import xin.qust.kg.domain.DangerCharacter;
import xin.qust.kg.repository.ChemicalRepository;
import xin.qust.kg.repository.DangerCharacterRepository;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

import static xin.qust.kg.utils.CsvUtil.readCsvFile;
import static xin.qust.kg.utils.JsonUtil.readJsonFile;

@Component
public class ProcessChemicalTask {

    @Autowired
    private DangerCharacterRepository dangerCharacterRepository;


    private final ChemicalRepository chemicalRepository;

    public ProcessChemicalTask(ChemicalRepository chemicalRepository) {
        this.chemicalRepository = chemicalRepository;
    }

    private void saveChemicalToGraph() throws IOException {
        JSONObject chemicalsJson = readJsonFile("/Users/royal/Desktop/chemicals.json");
        JSONObject chemicalInfoJson = readJsonFile("/Users/royal/Desktop/chemical_info.json");

        JSONArray chemicals = chemicalsJson.getJSONArray("RECORDS");
        JSONArray chemicalInfos = chemicalInfoJson.getJSONArray("RECORDS");

        AtomicInteger number = new AtomicInteger(1);
        chemicalInfos.forEach(info -> {
            if (number.intValue() >= 19994) {
                JSONObject json = new JSONObject(info.toString());
                Chemical chemical = new Chemical();
                chemical.setCas(json.getString("cas"));

                String[] aliasCN = json.getString("alias_cn").split("; ");
                String[] aliasEN = json.getString("alias_en").split("; ");

                Set<String> alias = new HashSet<>();
                Collections.addAll(alias, aliasCN);
                Collections.addAll(alias, aliasEN);

                chemical.setAliasName(alias);

                chemical.setBoilingPoint(json.getString("boiling_point").replace("℃", "°C"));

                chemical.setDensity(json.getString("density").replace("℃", "°C"));

                chemical.setFlashPoint(json.getString("flash_point").replace("℃", "°C"));

                chemical.setMeltingPoint(json.getString("melting_point").replace("℃", "°C"));

                chemical.setMolecularWeight(getDouble(json.getString("molecular_weight")));

                chemical.setTension(json.getString("tension").replace("℃", "°C"));

                chemical.setWaterSolubility(json.getString("water_solubility").replace("℃", "°C"));

                String[] riskCodesStr = json.getString("risk_code").split(";");
                for (int i = 0; i < riskCodesStr.length; i++) {
                    if (riskCodesStr[i].startsWith(" ")) {
                        riskCodesStr[i] = riskCodesStr[i].substring(1);
                    }
                }

                Set<String> riskCodes = new HashSet<>();
                Collections.addAll(riskCodes, riskCodesStr);

                chemical.setRiskCodes(riskCodes);

                String[] safeCodesStr = json.getString("safe_code").split(";");
                for (int i = 0; i < safeCodesStr.length; i++) {
                    if (safeCodesStr[i].startsWith(" ")) {
                        safeCodesStr[i] = safeCodesStr[i].substring(1);
                    }
                }

                Set<String> safeCodes = new HashSet<>();
                Collections.addAll(safeCodes, safeCodesStr);

                chemical.setSafeCodes(safeCodes);

                chemicals.forEach(ch -> {
                    JSONObject c = new JSONObject(ch.toString());
                    if (c.getString("CAS").equals(chemical.getCas())) {
                        chemical.setChineseName(c.getString("name_cn"));
                        chemical.setEnglishName(c.getString("name_en"));
                        chemical.setChemicalFormula(c.getString("MF"));
                    }
                });
                System.out.print("\b\b\b\b\b" + number);
                // System.out.println("" + chemical.toString());
                chemicalRepository.save(chemical);
            }
            number.getAndIncrement();
        });

        System.out.println("\ndone");
    }

    private Double getDouble(String str) {
        try {
            return Double.valueOf(str);
        }
        catch (Exception e) {
            return null;
        }
    }

    void processDangerCharacter() {
        List<String> rows = readCsvFile("/Users/royal/Desktop/guide_cas.csv", 0);
        for (String row: rows) {
            String []cols = row.replace("\"", "").split(",");
            String cas = cols[1];
            String rown = row.replace("\"", "");
            String ids = rown.substring(rown.indexOf("[") + 1, rown.indexOf("]"));
            // System.out.println("cas:" + cas + " danger:" + ids);
            Optional<Chemical> chemical = chemicalRepository.findByCas(cas);
            chemical.ifPresent(value -> {
                System.out.println("--------------------" + value.getChineseName());
                System.out.println("+++++++++++++++++++=" + ids);
                String []wxs = ids.split(", ");
                // value.getDangerCharacters(). = new HashSet<>();
                for (String wx:wxs) {
                    Optional<DangerCharacter> dangerCharacter = dangerCharacterRepository.findById(DigestUtils.md5DigestAsHex(wx.getBytes()));
                    dangerCharacter.ifPresent(danger -> {
                        System.out.println("" + danger.getCharacterDescription());
                        value.getDangerCharacters().add(danger);
                    });
                }
                // value.setDangerCharacters(dangerCharacters);
                chemicalRepository.save(value);
            });
        }
    }
}
