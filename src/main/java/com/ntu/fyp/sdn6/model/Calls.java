package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * This class represents the CALLS relationship. A CALLS relationship is a directed edge from a
 * MethodFQN caller node to a MethodFQN callee node with property version.
 */
@RelationshipProperties
public class Calls {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private final MethodFQN callee;

  private final String version;

  public Calls(MethodFQN callee, String version) {
    this.callee = callee;
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public MethodFQN getCallee() {
    return callee;
  }
}
