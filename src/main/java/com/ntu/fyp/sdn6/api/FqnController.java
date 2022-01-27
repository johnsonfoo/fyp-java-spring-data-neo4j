package com.ntu.fyp.sdn6.api;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.ntu.fyp.sdn6.service.FqnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v0/fqn")
@Tag(name = "fqn")
class FqnController {

  private final FqnService fqnService;

  @Autowired
  FqnController(FqnService fqnService) {
    this.fqnService = fqnService;
  }
}
