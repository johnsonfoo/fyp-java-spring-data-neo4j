package com.ntu.fyp.sdn6.dao;

import com.ntu.fyp.sdn6.model.Fqn;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

@NoRepositoryBean
public interface FqnBaseRepository<T extends Fqn> extends Repository<T, Long> {

  T findByName(@Param("name") String name);

  List<T> findByContainedFqnsContainedFqnName(@Param("name") String name);

  List<T> findByReferencedFqnsReferencedFqnName(@Param("name") String name);

  List<T> findByInsertedFqnsInsertedFqnName(@Param("name") String name);

  List<T> findByUpdatedFqnsUpdatedFqnName(@Param("name") String name);

  List<T> findByDeletedFqnsDeletedFqnName(@Param("name") String name);

}
