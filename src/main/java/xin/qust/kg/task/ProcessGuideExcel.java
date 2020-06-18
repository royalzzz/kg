package xin.qust.kg.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xin.qust.kg.domain.mysql.HiddenDangerCheckItem;
import xin.qust.kg.domain.mysql.HiddenDangerCheckType;
import xin.qust.kg.repository.mysql.HiddenDangerCheckItemRepository;
import xin.qust.kg.repository.mysql.HiddenDangerCheckTypeRepository;

import java.util.List;
import java.util.Optional;

import static xin.qust.kg.utils.CsvUtil.readCsvFile;
@Component
public class ProcessGuideExcel {

    @Autowired
    private HiddenDangerCheckTypeRepository hiddenDangerCheckTypeRepository;

    @Autowired
    private HiddenDangerCheckItemRepository hiddenDangerCheckItemRepository;


    public void proccess(){
        List<String> rows = readCsvFile("/Users/royal/Desktop/dangercheck.csv", 0);
        long i = 0;
        long typeId = 0;
        for (String row : rows) {
            if (row.split(",")[0].equals("序号") || row.split(",")[0].equals("\uFEFF序号") || row.split(",")[0].equals("类别")) {
                System.out.println("NO:" + i);
                i++;
            }
            else {
                try {
                    Integer.parseInt(row.split(",")[0]);
                    Optional<HiddenDangerCheckType> hiddenDangerCheckType = hiddenDangerCheckTypeRepository.findById(typeId);
                    if (hiddenDangerCheckType.isPresent()) {
                        System.out.println("" + hiddenDangerCheckType.get());
                        HiddenDangerCheckItem hiddenDangerCheckItem = new HiddenDangerCheckItem();
                        hiddenDangerCheckItem.setCheckId(hiddenDangerCheckType.get().getCheckId());
                        hiddenDangerCheckItem.setCheckTypeId(hiddenDangerCheckType.get().getId());
                        hiddenDangerCheckItem.setCheckItemName(row.replace("," ,""));
                        hiddenDangerCheckItemRepository.save(hiddenDangerCheckItem);
                    }
                }
                catch (Exception e) {
                    typeId++;
                }
            }
        }
    }
}
