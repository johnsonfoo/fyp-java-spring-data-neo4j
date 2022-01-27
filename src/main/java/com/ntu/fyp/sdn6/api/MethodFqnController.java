package com.ntu.fyp.sdn6.api;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.ntu.fyp.sdn6.model.MethodFqn;
import com.ntu.fyp.sdn6.service.MethodFqnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v0/method-fqns")
@Tag(name = "method-fqn")
class MethodFqnController {

  private final MethodFqnService methodFqnService;

  @Autowired
  MethodFqnController(MethodFqnService methodFqnService) {
    this.methodFqnService = methodFqnService;
  }

  @GetMapping(path = "/calls/search")
  List<MethodFqn> getCalledFqn(@RequestParam("name") String name) {
    return methodFqnService.findByCalledName(name);
  }
}
