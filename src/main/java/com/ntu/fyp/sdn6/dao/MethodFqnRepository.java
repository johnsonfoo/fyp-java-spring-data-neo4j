package com.ntu.fyp.sdn6.dao;

import com.ntu.fyp.sdn6.model.MethodFqn;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MethodFqnRepository extends FqnBaseRepository<MethodFqn> {

  List<MethodFqn> findByCalledMethodFqnsCalledMethodFqnName(@Param("name") String name);

}
