package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * This class represents the Fqn node. Fqn nodes all have property name. Each Fqn node have the
 * relationships Contains, References, Inserts, Updates, Deletes.
 */
@Node
public class Fqn {

  @Id
  @GeneratedValue
  private Long id;

  private String name;

  public Fqn(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
