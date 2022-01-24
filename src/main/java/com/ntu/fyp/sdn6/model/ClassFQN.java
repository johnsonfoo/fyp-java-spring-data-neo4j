package com.ntu.fyp.sdn6.model;

import org.springframework.data.neo4j.core.schema.Node;

/**
 * This class represents the ClassFQN node. ClassFQN nodes all have property name. Each ClassFQN
 * node inherits the relationships Contains, References, Inserts, Updates, Deletes from parent FQN
 * and have relationship Inherits.
 */
@Node
public class ClassFQN extends FQN {

  boolean isAbstract;

  boolean isTest;

  public ClassFQN(String name, boolean isAbstract, boolean isTest) {
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
