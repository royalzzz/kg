package xin.qust.kg.repository.graph;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import xin.qust.kg.domain.grpah.DangerCharacter;

public interface DangerCharacterRepository extends Neo4jRepository<DangerCharacter, String> {
}
