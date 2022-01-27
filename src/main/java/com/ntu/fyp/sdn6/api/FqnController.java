package com.ntu.fyp.sdn6.api;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.ntu.fyp.sdn6.model.Fqn;
import com.ntu.fyp.sdn6.service.FqnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v0/fqns")
@Tag(name = "fqn")
class FqnController {

  private final FqnService fqnService;

  @Autowired
  public FqnController(FqnService fqnService) {
    this.fqnService = fqnService;
  }

  @GetMapping(path = "/search")
  public Fqn getFqn(@RequestParam("name") String name) {
    return fqnService.findByName(name);
  }

  @GetMapping(path = "/contains/search")
  public List<Fqn> getContainedFqn(@RequestParam("name") String name) {
    return fqnService.findByContainedName(name);
  }

  @GetMapping(path = "/references/search")
  public List<Fqn> getReferencedFqn(@RequestParam("name") String name) {
    return fqnService.findByReferencedName(name);
  }

  @GetMapping(path = "/inserts/search")
  public List<Fqn> getInsertedFqn(@RequestParam("name") String name) {
    return fqnService.findByInsertedName(name);
  }

  @GetMapping(path = "/updates/search")
  public List<Fqn> getUpdatedFqn(@RequestParam("name") String name) {
    return fqnService.findByUpdatedName(name);
  }

  @GetMapping(path = "/deletes/search")
  public List<Fqn> getDeletedFqn(@RequestParam("name") String name) {
    return fqnService.findByDeletedName(name);
  }
}
