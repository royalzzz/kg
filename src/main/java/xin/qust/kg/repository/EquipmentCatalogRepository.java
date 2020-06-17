package xin.qust.kg.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import xin.qust.kg.domain.EquipmentCatalog;

import java.util.Optional;

public interface EquipmentCatalogRepository extends Neo4jRepository<EquipmentCatalog, String> {

    public Optional<EquipmentCatalog> findByCatalogName(String catalogName);
}
