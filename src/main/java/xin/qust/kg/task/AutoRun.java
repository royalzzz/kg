package xin.qust.kg.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import xin.qust.kg.domain.grpah.Chemical;
import xin.qust.kg.domain.grpah.DangerCharacter;
import xin.qust.kg.domain.mysql.HiddenDangerCheck;
import xin.qust.kg.domain.mysql.HiddenDangerCheckItem;
import xin.qust.kg.domain.mysql.HiddenDangerCheckType;
import xin.qust.kg.repository.graph.ChemicalRepository;
import xin.qust.kg.repository.graph.DangerCharacterRepository;
import xin.qust.kg.repository.graph.EquipmentCatalogRepository;
import xin.qust.kg.repository.graph.EquipmentRepository;
import xin.qust.kg.repository.mysql.HiddenDangerCheckItemRepository;
import xin.qust.kg.repository.mysql.HiddenDangerCheckTypeRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static xin.qust.kg.utils.CsvUtil.readCsvFile;
import static xin.qust.kg.utils.WorkUtil.readWord;

@Component
public class AutoRun implements CommandLineRunner {

    @Autowired
    private EquipmentRepository equipmentRepository;

    @Autowired
    private EquipmentCatalogRepository equipmentCatalogRepository;

    @Autowired
    private DangerCharacterRepository dangerCharacterRepository;

    @Autowired
    private ChemicalRepository chemicalRepository;


    @Override
    public void run(String... args) throws Exception {

    }


}
