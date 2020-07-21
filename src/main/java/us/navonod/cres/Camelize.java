package us.navonod.cres;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Camelize {
    @GetMapping("/camelize")
    public String camelize(
            @RequestParam(value="original") String original,
            @RequestParam(value="initialCap", defaultValue="false") String initialCap
    ) {
        String[] words = original.split("_");
        StringBuilder result = new StringBuilder("");
//        result.append(initialCap instanceof String);
        for (int i = 0; i < words.length; i++) {
            if (!initialCap.equals("true") && i == 0) {
                result.append(words[i]);
                continue;
            } else {
                result.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase());
            }
        }
        return result.toString();
    }
}
