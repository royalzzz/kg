package xin.qust.kg.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.kg.domain.mysql.HiddenDangerCheckItem;
import xin.qust.kg.domain.mysql.HiddenDangerCheckType;
import xin.qust.kg.repository.mysql.HiddenDangerCheckItemRepository;
import xin.qust.kg.repository.mysql.HiddenDangerCheckTypeRepository;

import java.util.List;

@RestController
@RequestMapping("hiddenDangerCheck")
public class HiddenDangerCheckApi {

    @Autowired
    HiddenDangerCheckTypeRepository hiddenDangerCheckTypeRepository;

    @Autowired
    HiddenDangerCheckItemRepository hiddenDangerCheckItemRepository;


    @RequestMapping("getHiddenDangerCheckType")
    public List<HiddenDangerCheckType> getHiddenDangerCheckType(Long checkId) {
        return hiddenDangerCheckTypeRepository.findByCheckId(checkId);
    }

    @RequestMapping("getHiddenDangerCheckItem")
    public List<HiddenDangerCheckItem> getHiddenDangerCheckItem(Long checkTypeId) {
        return hiddenDangerCheckItemRepository.findByCheckTypeId(checkTypeId);
    }
}
