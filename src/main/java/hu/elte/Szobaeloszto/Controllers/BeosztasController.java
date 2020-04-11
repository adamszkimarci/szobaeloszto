package hu.elte.Szobaeloszto.Controllers;

import hu.elte.Szobaeloszto.Entities.Beosztas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.Szobaeloszto.Repositories.BeosztasRepository;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin
@RestController
@RequestMapping("beosztas")
public class BeosztasController {

    @Autowired
    private BeosztasRepository beosztasRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Beosztas>> getAll() {
        return ResponseEntity.ok(beosztasRepository.findAll());
    }

    @PutMapping("")
    public ResponseEntity<Beosztas> post(@RequestBody Beosztas beoszt) {
        Beosztas newBeoszt = beosztasRepository.save(beoszt);
        return ResponseEntity.ok(newBeoszt);
    }

    @DeleteMapping("/{iD}")
    public ResponseEntity delete(@PathVariable Integer iD) {
        Optional<Beosztas> beoszt = beosztasRepository.findById(iD);
        if (!beoszt.isPresent()) {
            ResponseEntity.notFound();
        }

        beosztasRepository.delete(beoszt.get());

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{iD}")
    public ResponseEntity<Beosztas> put(@PathVariable Integer iD, @RequestBody Beosztas beoszt) {
        Optional<Beosztas> oldBeoszt = beosztasRepository.findById(iD);
        if (!oldBeoszt.isPresent()) {
            ResponseEntity.notFound();
        }

        beoszt.setID(iD);
        return ResponseEntity.ok(beosztasRepository.save(beoszt));
    }

}
