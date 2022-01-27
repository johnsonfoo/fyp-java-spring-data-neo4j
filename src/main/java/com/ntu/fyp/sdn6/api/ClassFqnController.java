package com.ntu.fyp.sdn6.api;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.ntu.fyp.sdn6.model.ClassFqn;
import com.ntu.fyp.sdn6.service.ClassFqnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v0/class-fqns")
@Tag(name = "class-fqn")
class ClassFqnController {

  private final ClassFqnService classFqnService;

  @Autowired
  ClassFqnController(ClassFqnService classFqnService) {
    this.classFqnService = classFqnService;
  }

  @GetMapping(path = "/inherits/search")
  List<ClassFqn> getInheritedFqn(@RequestParam("name") String name) {
    return classFqnService.findByInheritedName(name);
  }
}
