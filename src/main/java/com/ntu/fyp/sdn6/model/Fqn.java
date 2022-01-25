package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the Fqn node. Fqn nodes all have property name. Each Fqn node have the
 * relationships Contains, References, Inserts, Updates, Deletes.
 */
@Node("FQN")
public class Fqn {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @Relationship(type = "CONTAINS", direction = Relationship.Direction.OUTGOING)
  private List<Contains> containedFqns = new ArrayList<>();

  @Relationship(type = "REFERENCES", direction = Relationship.Direction.OUTGOING)
  private List<References> referencedFqns = new ArrayList<>();

  @Relationship(type = "INSERTS", direction = Relationship.Direction.OUTGOING)
  private List<Inserts> insertedFqns = new ArrayList<>();

  @Relationship(type = "UPDATES", direction = Relationship.Direction.OUTGOING)
  private List<Updates> updatedFqns = new ArrayList<>();

  @Relationship(type = "DELETES", direction = Relationship.Direction.OUTGOING)
  private List<Deletes> deletedFqns = new ArrayList<>();

  public Fqn(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<Contains> getContainedFqns() {
    return containedFqns;
  }

  public List<References> getReferencedFqns() {
    return referencedFqns;
  }

  public List<Inserts> getInsertedFqns() {
    return insertedFqns;
  }

  public List<Updates> getUpdatedFqns() {
    return updatedFqns;
  }

  public List<Deletes> getDeletedFqns() {
    return deletedFqns;
  }
}
