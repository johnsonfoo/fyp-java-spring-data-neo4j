package com.ntu.fyp.sdn6.dao;

import com.ntu.fyp.sdn6.model.MethodFqn;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MethodFqnRepository extends Neo4jRepository<MethodFqn, Long> {

  List<MethodFqn> findAll();

  List<MethodFqn> findByName(@Param("name") String name);

  List<MethodFqn> findByCalleesCalleeName(@Param("name") String name);
}
