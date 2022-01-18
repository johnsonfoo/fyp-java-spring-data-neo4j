package com.ntu.fyp.sdn6.api;

import io.swagger.v3.oas.annotations.tags.Tag;

import com.ntu.fyp.sdn6.model.MethodFQN;
import com.ntu.fyp.sdn6.service.MethodFQNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v0/method-fqn")
@Tag(name = "method-fqn")
class MethodFQNController {

  private final MethodFQNService methodFQNService;

  @Autowired
  MethodFQNController(MethodFQNService methodFQNService) {
    this.methodFQNService = methodFQNService;
  }

  @GetMapping(path = "/caller-name/{name}")
  List<MethodFQN> getCallees(@PathVariable("name") String callerName) {
    return methodFQNService.getCallees(callerName);
  }

  @GetMapping(path = "/callee-name/{name}")
  List<MethodFQN> getCallers(@PathVariable("name") String calleeName) {
    return methodFQNService.getCallers(calleeName);
  }

}
