package xin.qust.kg.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.kg.domain.mysql.HiddenDangerCheckType;

import java.util.Optional;

public interface HiddenDangerCheckTypeRepository extends JpaRepository<HiddenDangerCheckType, Long> {

    Optional<HiddenDangerCheckType> findByCheckIdAndCheckTypeName(Long checkId, String checkTypeName);
}
