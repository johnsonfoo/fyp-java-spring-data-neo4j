package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * This class represents the CALLS relationship. A CALLS relationship is a directed edge from a
 * MethodFqn node to a MethodFqn node with property version.
 */
@RelationshipProperties
public class Calls {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private final MethodFqn calledMethodFqn;

  private final String version;

  public Calls(MethodFqn calledMethodFqn, String version) {
    this.calledMethodFqn = calledMethodFqn;
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public MethodFqn getCalledMethodFqn() {
    return calledMethodFqn;
  }
}
