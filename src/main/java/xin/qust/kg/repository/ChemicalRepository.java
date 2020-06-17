package xin.qust.kg.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import xin.qust.kg.domain.Chemical;

import java.util.Optional;

public interface ChemicalRepository extends Neo4jRepository<Chemical, String> {

    Optional<Chemical> findByCas(String cas);
}
