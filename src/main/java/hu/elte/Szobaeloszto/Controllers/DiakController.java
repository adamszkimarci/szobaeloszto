package hu.elte.Szobaeloszto.Controllers;

import hu.elte.Szobaeloszto.Entities.Diak;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.Szobaeloszto.Repositories.DiakRepository;
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
@RequestMapping("diakok")
public class DiakController {

    @Autowired
    private DiakRepository diakokRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Diak>> getAll() {
        return ResponseEntity.ok(diakokRepository.findAll());
    }

    @GetMapping("/{iD}")
    public ResponseEntity<Diak> get(@PathVariable Integer iD) {
        Optional<Diak> diak = diakokRepository.findById(iD);
        if (!diak.isPresent()) {
            ResponseEntity.notFound();
        }

        return ResponseEntity.ok(diak.get());
    }

    @PostMapping("")
    public ResponseEntity<Diak> post(@RequestBody Diak diak) {
        Diak newDiak = diakokRepository.save(diak);
        return ResponseEntity.ok(newDiak);
    }

    @DeleteMapping("/{iD}")
    public ResponseEntity delete(@PathVariable Integer iD) {
        Optional<Diak> diak = diakokRepository.findById(iD);
        if (!diak.isPresent()) {
            ResponseEntity.notFound();
        }

        diakokRepository.delete(diak.get());

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{iD}")
    public ResponseEntity<Diak> put(@PathVariable Integer iD, @RequestBody Diak diak) {
        Optional<Diak> oldDiak = diakokRepository.findById(iD);
        if (!oldDiak.isPresent()) {
            ResponseEntity.notFound();
        }

        diak.setID(iD);
        return ResponseEntity.ok(diakokRepository.save(diak));
    }
}
