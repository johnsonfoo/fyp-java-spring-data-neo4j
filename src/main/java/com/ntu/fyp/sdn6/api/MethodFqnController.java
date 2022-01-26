package com.ntu.fyp.sdn6.api;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.ntu.fyp.sdn6.model.MethodFqn;
import com.ntu.fyp.sdn6.service.MethodFqnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v0/method-fqn")
@Tag(name = "method-fqn")
class MethodFqnController {

  private final MethodFqnService methodFqnService;

  @Autowired
  MethodFqnController(MethodFqnService methodFqnService) {
    this.methodFqnService = methodFqnService;
  }

  @GetMapping(path = "/caller-name/{name}")
  MethodFqn getCallees(@PathVariable("name") String callerName) {
    return methodFqnService.getCallees(callerName);
  }

  @GetMapping(path = "/callee-name/{name}")
  List<MethodFqn> getCallers(@PathVariable("name") String calleeName) {
    return methodFqnService.getCallers(calleeName);
  }

}
