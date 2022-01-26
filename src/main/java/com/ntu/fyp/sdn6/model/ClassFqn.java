package com.ntu.fyp.sdn6.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the ClassFqn node. ClassFqn nodes all have property name. Each ClassFqn
 * node inherits the relationships Contains, References, Inserts, Updates, Deletes from parent Fqn
 * and have relationship Inherits.
 */
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "name")
@Node("ClassFQN")
public class ClassFqn extends Fqn {

  boolean isAbstract;

  boolean isTest;

  @Relationship(type = "INHERITS", direction = Relationship.Direction.OUTGOING)
  private List<Inherits> inheritedFqns = new ArrayList<>();

  public ClassFqn(String name, boolean isAbstract, boolean isTest) {
    super(name);
    this.isAbstract = isAbstract;
    this.isTest = isTest;
  }

  public boolean isAbstract() {
    return isAbstract;
  }

  public boolean isTest() {
    return isTest;
  }

  public List<Inherits> getInheritedFqns() {
    return inheritedFqns;
  }
}
