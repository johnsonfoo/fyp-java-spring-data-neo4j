package com.ntu.fyp.sdn6.api;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.ntu.fyp.sdn6.service.ClassFqnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v0/class-fqn")
@Tag(name = "class-fqn")
class ClassFqnController {

  private final ClassFqnService classFqnService;

  @Autowired
  ClassFqnController(ClassFqnService classFqnService) {
    this.classFqnService = classFqnService;
  }
}
