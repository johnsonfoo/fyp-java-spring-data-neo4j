package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * This class represents the MethodFQN node. MethodFQN nodes all have property name. Each MethodFQN
 * caller node CALLS 0 or more MethodFQN callee nodes.
 */
@Node
public class MethodFQN {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  @Relationship(type = "CALLS", direction = Relationship.Direction.OUTGOING)
  private List<Calls> callees = new ArrayList<>();

  public MethodFQN(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public List<Calls> getCallees() {
    return callees;
  }
}
