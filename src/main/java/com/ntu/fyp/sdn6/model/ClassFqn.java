package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.Node;

/**
 * This class represents the ClassFqn node. ClassFqn nodes all have property name. Each ClassFqn
 * node inherits the relationships Contains, References, Inserts, Updates, Deletes from parent Fqn
 * and have relationship Inherits.
 */
@Node("ClassFQN")
public class ClassFqn extends Fqn {

  boolean isAbstract;

  boolean isTest;

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
}
