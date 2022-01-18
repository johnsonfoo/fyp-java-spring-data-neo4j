package com.ntu.fyp.sdn6.dao;

import com.ntu.fyp.sdn6.model.MethodFQN;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MethodFQNRepository extends Neo4jRepository<MethodFQN, Long> {

  List<MethodFQN> findAll();

  List<MethodFQN> findByName(@Param("name") String name);

  List<MethodFQN> findByCalleesCalleeName(@Param("name") String name);
}
