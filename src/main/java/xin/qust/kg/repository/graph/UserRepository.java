package xin.qust.kg.repository.graph;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;
import xin.qust.kg.domain.grpah.User;

@Repository
public interface UserRepository extends Neo4jRepository<User, String> {
}
