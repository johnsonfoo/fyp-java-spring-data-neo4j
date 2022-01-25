package com.ntu.fyp.sdn6.service;

import com.ntu.fyp.sdn6.dao.MethodFQNRepository;
import com.ntu.fyp.sdn6.model.MethodFqn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodFQNService {

  private final MethodFQNRepository methodFQNRepository;

  @Autowired
  public MethodFQNService(MethodFQNRepository methodFQNRepository) {
    this.methodFQNRepository = methodFQNRepository;
  }

  public List<MethodFqn> getCallees(String name) {
    return methodFQNRepository.findByName(name);
  }

  public List<MethodFqn> getCallers(String name) {
    return methodFQNRepository.findByCalleesCalleeName(name);
  }
}
