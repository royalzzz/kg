package xin.qust.kg.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import xin.qust.kg.domain.Equipment;

public interface EquipmentRepository extends Neo4jRepository<Equipment, String> {
}
