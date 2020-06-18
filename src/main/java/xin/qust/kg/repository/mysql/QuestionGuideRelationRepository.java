package xin.qust.kg.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.kg.domain.mysql.QuestionGuideRelation;

public interface QuestionGuideRelationRepository extends JpaRepository<QuestionGuideRelation, Long> {
}
