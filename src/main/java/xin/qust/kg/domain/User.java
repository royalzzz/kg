package xin.qust.kg.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.id.UuidStrategy;

import java.math.BigDecimal;
import java.util.Set;

@NodeEntity
public class User {

    @Id
    @GeneratedValue(strategy = UuidStrategy.class)
    private String id;

    private String name;

    private String gender;

    private Set<String> nickName;

    private Double weight;

    @Relationship(type = "FRIEND", direction = Relationship.UNDIRECTED)
    @JsonIgnore
    private Set<User> friends;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getFriends() {
        return friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Set<String> getNickName() {
        return nickName;
    }

    public void setNickName(Set<String> nickName) {
        this.nickName = nickName;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
}
