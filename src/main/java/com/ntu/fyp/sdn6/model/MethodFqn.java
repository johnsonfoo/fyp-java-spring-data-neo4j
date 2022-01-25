package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the MethodFqn node. MethodFqn nodes all have property name. Each MethodFqn
 * node inherits the relationships Contains, References, Inserts, Updates, Deletes from parent Fqn
 * and have relationship Calls.
 */
@Node("MethodFQN")
public class MethodFqn extends Fqn {

  @Relationship(type = "CALLS", direction = Relationship.Direction.OUTGOING)
  private List<Calls> callees = new ArrayList<>();

  public MethodFqn(String name) {
    super(name);
  }

  public List<Calls> getCallees() {
    return callees;
  }
}
