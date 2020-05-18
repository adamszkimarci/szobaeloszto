package hu.elte.Szobaeloszto.Controllers;

import hu.elte.Szobaeloszto.Entities.Beosztas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.Szobaeloszto.Repositories.BeosztasRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/beosztas")
public class BeosztasController {

    @Autowired
    private BeosztasRepository beosztasRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Beosztas>> getAll() {
        return ResponseEntity.ok(beosztasRepository.findAll());
    }
    
    @PostMapping("")
    public ResponseEntity<Beosztas> post(@RequestBody Beosztas beoszt) {
        Beosztas newBeoszt = beosztasRepository.save(beoszt);
        return ResponseEntity.ok(newBeoszt);
    }
    
    @GetMapping(value = "/mybeoszt/{neptunkod}")
    public ResponseEntity<Object> getGenre(@PathVariable String neptunkod) {
        List<Beosztas> beoszt = beosztasRepository.findByNeptunKod(neptunkod);
        if (!beoszt.isEmpty()) {
            ResponseEntity.notFound();
        }

        return new ResponseEntity<Object>(beoszt, HttpStatus.OK);
    }   

    @DeleteMapping("/mybeoszt/{neptunkod}")
    public ResponseEntity delete(@PathVariable String neptunkod) {
        List<Beosztas> beoszt = beosztasRepository.findByNeptunKod(neptunkod);
        if (!beoszt.isEmpty()) {
            ResponseEntity.notFound();
        }

        beosztasRepository.delete(beoszt.get(0));

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
