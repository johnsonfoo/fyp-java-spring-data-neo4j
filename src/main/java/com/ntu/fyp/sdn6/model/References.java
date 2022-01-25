package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

/**
 * This class represents the REFERENCES relationship. A REFERENCES relationship is a directed edge
 * from a Fqn node to a Fqn node with property version.
 */
@RelationshipProperties
public class References {

  @Id
  @GeneratedValue
  private Long id;

  @TargetNode
  private final Fqn referencedFqn;

  private final String version;

  public References(Fqn referencedFqn, String version) {
    this.referencedFqn = referencedFqn;
    this.version = version;
  }

  public String getVersion() {
    return version;
  }

  public Fqn getReferencedFQN() {
    return referencedFqn;
  }
}
