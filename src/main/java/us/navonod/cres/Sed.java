package us.navonod.cres;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sed {
    @PostMapping("/s/{find}/{replacement}")
    public String sed(
        @PathVariable(value="find") String find,
        @PathVariable(value="replacement") String replacement,
        @RequestBody String body
    ) {

        return body.replace(find, replacement);
    }
}
