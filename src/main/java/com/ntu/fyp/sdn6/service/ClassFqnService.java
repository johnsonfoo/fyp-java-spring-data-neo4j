package com.ntu.fyp.sdn6.service;

import com.ntu.fyp.sdn6.dao.ClassFqnRepository;
import com.ntu.fyp.sdn6.model.ClassFqn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassFqnService {

  private final ClassFqnRepository classFqnRepository;

  @Autowired
  public ClassFqnService(ClassFqnRepository classFqnRepository) {
    this.classFqnRepository = classFqnRepository;
  }

  public ClassFqn findByName(String name) {
    return classFqnRepository.findByName(name);
  }

  public List<ClassFqn> findByInheritedName(String name) {
    return classFqnRepository.findByInheritedClassFqnsInheritedClassFqnName(name);
  }
}
