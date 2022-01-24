package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the MethodFQN node. MethodFQN nodes all have property name. Each MethodFQN
 * node inherits the relationships Contains, References, Inserts, Updates, Deletes from parent FQN
 * and have relationship Calls.
 */
@Node
public class MethodFQN extends FQN {

  @Relationship(type = "CALLS", direction = Relationship.Direction.OUTGOING)
  private List<Calls> callees = new ArrayList<>();

  public MethodFQN(String name) {
    super(name);
  }

  public List<Calls> getCallees() {
    return callees;
  }
}
