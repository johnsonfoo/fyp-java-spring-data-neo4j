package com.ntu.fyp.sdn6.dao;

import com.ntu.fyp.sdn6.model.ClassFqn;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClassFqnRepository extends FqnBaseRepository<ClassFqn> {

  List<ClassFqn> findByInheritedClassFqnsInheritedClassFqnName(@Param("name") String name);

}
