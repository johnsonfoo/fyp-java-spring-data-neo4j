package com.ntu.fyp.sdn6.api;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.ntu.fyp.sdn6.model.Fqn;
import com.ntu.fyp.sdn6.service.FqnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v0/fqns")
@Tag(name = "fqn")
class FqnController {

  private final FqnService fqnService;

  @Autowired
  FqnController(FqnService fqnService) {
    this.fqnService = fqnService;
  }

  @GetMapping(path = "/search")
  Fqn getFqn(@RequestParam("name") String name) {
    return fqnService.findByName(name);
  }
}
