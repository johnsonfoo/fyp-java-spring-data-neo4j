package com.ntu.fyp.sdn6.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the MethodFqn node. MethodFqn nodes all have property name. Each MethodFqn
 * node inherits the relationships Contains, References, Inserts, Updates, Deletes from parent Fqn
 * and have relationship Calls.
 */
@JsonIdentityInfo(
    generator = ObjectIdGenerators.PropertyGenerator.class,
    property = "name")
@Node("MethodFQN")
public class MethodFqn extends Fqn {

  @Relationship(type = "CALLS", direction = Relationship.Direction.OUTGOING)
  private List<Calls> calledMethodFqns = new ArrayList<>();

  public MethodFqn(String name) {
    super(name);
  }

  public List<Calls> getCalledMethodFqns() {
    return calledMethodFqns;
  }
}
