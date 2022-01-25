package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * This class represents the INHERITS relationship. A INHERITS relationship is a directed edge from
 * a ClassFqn node to a ClassFqn node.
 */
@RelationshipProperties
public class Inherits {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private final ClassFqn inheritedClassFqn;

  public Inherits(ClassFqn inheritedClassFqn) {
    this.inheritedClassFqn = inheritedClassFqn;
  }

  public ClassFqn getInheritedClassFqn() {
    return inheritedClassFqn;
  }
}
