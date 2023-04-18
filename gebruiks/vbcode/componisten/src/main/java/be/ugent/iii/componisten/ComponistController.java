package be.ugent.iii.componisten;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController


public class ComponistController {

    private final ComponistData componistData = new ComponistData();
    private final Map<String, Componist> componisten = componistData.getComponists();

    @GetMapping("/vulaan")
    public List<Componist> zoekComponisten(@RequestParam("letters") String zoekString) {
        return zoek(zoekString);
    }

    @GetMapping("/toon")
    public Componist toonComponist(@RequestParam("id") String id) {
        return componisten.get(id);
    }

    @GetMapping("/componist")
    public Componist zoekComponist(@RequestParam("naam") String zoekString) {
        return zoekEerste(zoekString);
    }


    @PostMapping("/componist")
    public Componist zoekComponistPost(@RequestBody String zoekString) {
       return zoekEerste(zoekString.substring(zoekString.indexOf('=')+1));
    }

    private Componist zoekEerste(String zoekString) {
        List<Componist> resultaat = zoek(zoekString);
        if (resultaat.size() > 0) {
            return resultaat.get(0);
        } else {
            return null;
        }
    }

    private List<Componist> zoek(@RequestParam("naam") String zoekString) {
        List<Componist> resultaat = new ArrayList<>();// bevat mogelijke componisten

        if (zoekString != null) {
            zoekString = zoekString.trim().toLowerCase();

            // check if user sent empty string
            if (!zoekString.equals("")) {
                for (Componist componist : componisten.values()) {
                    if ( // zoekString matches first name
                            componist.getFirstName().toLowerCase()
                                    .startsWith(zoekString)
                                    || // zoekString matches last name
                                    componist.getLastName().toLowerCase()
                                            .startsWith(zoekString)
                                    || // zoekString matches full name
                                    componist.getFirstName().toLowerCase()
                                            .concat(" ").concat(componist.getLastName()
                                            .toLowerCase()).startsWith(zoekString)) {
                        resultaat.add(componist);
                    }
                }

            }
        }
        return resultaat;
    }
}
