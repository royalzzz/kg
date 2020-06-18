package xin.qust.kg.repository.graph;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import xin.qust.kg.domain.grpah.Equipment;

public interface EquipmentRepository extends Neo4jRepository<Equipment, String> {
}
