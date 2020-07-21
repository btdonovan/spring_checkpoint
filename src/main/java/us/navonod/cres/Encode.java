package us.navonod.cres;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class Encode {
    @PostMapping("/encode")
    public String encode(
            @RequestParam(value="message") String message,
            @RequestParam(value="key") String key
    ) {
        if (key.length() != 26) {
            return "Invalid key";
        }
        char[] alpha = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] keyl = key.toCharArray();
        HashMap<Character, Character> charMap = new HashMap<>();
        for (var i = 0; i < alpha.length; i++) {
            charMap.put(alpha[i], keyl[i]);
        }
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < message.length(); i++) {
            char c = message.charAt(i);
            if (c == ' ') {
                result.append(c);
            } else {
                result.append(charMap.get(c));
            }
        }
        return result.toString();
    }

}
