package hu.elte.Szobaeloszto.Controllers;

import hu.elte.Szobaeloszto.Entities.Szoba;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.Szobaeloszto.Repositories.SzobaRepository;
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
@RequestMapping("szobak")
public class SzobaController {

    @Autowired
    private SzobaRepository szobaRepository;
    
    @GetMapping("")
    public ResponseEntity<Iterable<Szoba>> getAll() {
        return ResponseEntity.ok(szobaRepository.findAll());
    }

    @GetMapping(value = "/{iD}")
    public ResponseEntity<Szoba> get(@PathVariable Integer iD) {
        Optional<Szoba> szoba = szobaRepository.findById(iD);
        if (!szoba.isPresent()) {
            ResponseEntity.notFound();
        }

        return ResponseEntity.ok(szoba.get());
    }  

    @PostMapping("")
    public ResponseEntity<Szoba> post(@RequestBody Szoba szoba) {
        Szoba newSzoba = szobaRepository.save(szoba);
        return ResponseEntity.ok(newSzoba);
    }

    @DeleteMapping("/{iD}")
    public ResponseEntity delete(@PathVariable Integer iD) {
        Optional<Szoba> szoba = szobaRepository.findById(iD);
        if (!szoba.isPresent()) {
            ResponseEntity.notFound();
        }

        szobaRepository.delete(szoba.get());

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{iD}")
    public ResponseEntity<Szoba> put(@PathVariable Integer iD, @RequestBody Szoba szoba) {
        Optional<Szoba> oldSzoba = szobaRepository.findById(iD);
        if (!oldSzoba.isPresent()) {
            ResponseEntity.notFound();
        }

        szoba.setID(iD);
        return ResponseEntity.ok(szobaRepository.save(szoba));
    }

}
