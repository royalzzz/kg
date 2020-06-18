package xin.qust.kg.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.kg.domain.mysql.HiddenDangerCheck;

public interface HiddenDangerCheckRepository extends JpaRepository<HiddenDangerCheck, Long> {
}
