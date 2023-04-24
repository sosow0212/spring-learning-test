package nextstep.helloworld.mvc.handler;

import nextstep.helloworld.mvc.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/return-value")
public class ReturnValueController {

    @ResponseBody
    @GetMapping("/message")
    public String string() {
        return "message";
    }

    @ResponseBody
    @GetMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public User responseBodyForUser() {
        return new User("name", "email");
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> responseEntity(@PathVariable Long id) {
        return ResponseEntity.ok(new User("name", "email"));
    }

    @GetMapping("/members")
    public ResponseEntity<Object> responseEntityFor400() {
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/thymeleaf")
    public String thymeleaf() {
        return "sample";
    }
}
