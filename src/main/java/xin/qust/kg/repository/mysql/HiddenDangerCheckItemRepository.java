package xin.qust.kg.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.kg.domain.mysql.HiddenDangerCheckItem;

public interface HiddenDangerCheckItemRepository extends JpaRepository<HiddenDangerCheckItem, Long> {
}
