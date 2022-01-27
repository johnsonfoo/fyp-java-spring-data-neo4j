package com.ntu.fyp.sdn6.service;

import com.ntu.fyp.sdn6.dao.MethodFqnRepository;
import com.ntu.fyp.sdn6.model.MethodFqn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MethodFqnService {

  private final MethodFqnRepository methodFqnRepository;

  @Autowired
  public MethodFqnService(MethodFqnRepository methodFqnRepository) {
    this.methodFqnRepository = methodFqnRepository;
  }

  public MethodFqn getCallees(String name) {
    return methodFqnRepository.findByName(name);
  }

  public List<MethodFqn> getCallers(String name) {
    return methodFqnRepository.findByCalledMethodFqnsCalledMethodFqnName(name);
  }
}
