package xin.qust.kg.repository.graph;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import xin.qust.kg.domain.grpah.Chemical;

import java.util.Optional;

public interface ChemicalRepository extends Neo4jRepository<Chemical, String> {

    Optional<Chemical> findByCas(String cas);
}
