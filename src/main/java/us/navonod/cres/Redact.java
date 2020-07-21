package us.navonod.cres;

import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Redact {
    @GetMapping("/redact")
    public String redact(@RequestParam MultiValueMap<String, String> querystring) {
        String original = querystring.get("original").get(0);
        List<String> badWords = querystring.get("badWord");
        List<String> words = new ArrayList<>(Arrays.asList(original.split(" ")));
        for (int i = 0; i < words.size(); i++) {

            if (badWords.contains(words.get(i))) {
                StringBuilder asterisks = new StringBuilder("");
                for (int k = 0; k < words.get(i).length(); k++) {
                    asterisks.append("*");
                }
                words.set(i, asterisks.toString());
            }
        }
        return String.join(" ", words);
    }
}
