package com.ntu.fyp.sdn6.service;

import com.ntu.fyp.sdn6.dao.FqnRepository;
import com.ntu.fyp.sdn6.model.Fqn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FqnService {

  private final FqnRepository fqnRepository;

  @Autowired
  public FqnService(FqnRepository fqnRepository) {
    this.fqnRepository = fqnRepository;
  }

  public Fqn findByName(String name) {
    return fqnRepository.findByName(name);
  }

  public List<Fqn> findByContainedName(String name) {
    return fqnRepository.findByContainedFqnsContainedFqnName(name);
  }

  public List<Fqn> findByReferencedName(String name) {
    return fqnRepository.findByReferencedFqnsReferencedFqnName(name);
  }

  public List<Fqn> findByInsertedName(String name) {
    return fqnRepository.findByInsertedFqnsInsertedFqnName(name);
  }

  public List<Fqn> findByUpdatedName(String name) {
    return fqnRepository.findByUpdatedFqnsUpdatedFqnName(name);
  }
}
