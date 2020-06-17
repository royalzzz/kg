package xin.qust.kg.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import xin.qust.kg.domain.DangerCharacter;

public interface DangerCharacterRepository extends Neo4jRepository<DangerCharacter, String> {
}
