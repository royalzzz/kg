package xin.qust.kg.task;

import jdk.nashorn.internal.runtime.regexp.joni.constants.OPCode;
import org.apache.tomcat.util.buf.HexUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;
import xin.qust.kg.domain.Chemical;
import xin.qust.kg.domain.DangerCharacter;
import xin.qust.kg.domain.Equipment;
import xin.qust.kg.domain.EquipmentCatalog;
import xin.qust.kg.repository.ChemicalRepository;
import xin.qust.kg.repository.DangerCharacterRepository;
import xin.qust.kg.repository.EquipmentCatalogRepository;
import xin.qust.kg.repository.EquipmentRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static xin.qust.kg.utils.CsvUtil.readCsvFile;

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
