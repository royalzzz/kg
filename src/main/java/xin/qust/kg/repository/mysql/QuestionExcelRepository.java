package xin.qust.kg.repository.mysql;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xin.qust.kg.domain.mysql.QuestionExcel;

import java.util.Optional;

public interface QuestionExcelRepository extends JpaRepository<QuestionExcel,Long> {

    @Query(value="select * from question_excel where isTagged = ?1 order by RAND() limit 1", nativeQuery=true)
    Optional<QuestionExcel> findByIsTaggedOrderByRand(Boolean tagged);

    int countAllByIsTagged(Boolean tagged);
}
