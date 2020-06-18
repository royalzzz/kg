package xin.qust.kg.domain.grpah;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.id.UuidStrategy;

import java.io.Serializable;
import java.util.Set;

@NodeEntity
public class EquipmentCatalog implements Serializable {

    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String id;

    private String catalogName;

    private String workingPrinciple;

    @Relationship(type = "CONTAIN", direction = Relationship.UNDIRECTED)
    @JsonIgnore
    private Set<Equipment> containEquipments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getWorkingPrinciple() {
        return workingPrinciple;
    }

    public void setWorkingPrinciple(String workingPrinciple) {
        this.workingPrinciple = workingPrinciple;
    }

    public Set<Equipment> getContainEquipments() {
        return containEquipments;
    }

    public void setContainEquipments(Set<Equipment> containEquipments) {
        this.containEquipments = containEquipments;
    }
}
