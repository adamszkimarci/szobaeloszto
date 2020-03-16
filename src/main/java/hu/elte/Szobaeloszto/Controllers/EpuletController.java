package hu.elte.szobabeoszto.Controllers;

import hu.elte.Szobaeloszto.Entities.Epulet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import hu.elte.Szobaeloszto.Repositories.EpuletRepository;
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
@RequestMapping("epuletek")
public class EpuletController {

    @Autowired
    private EpuletRepository epuletRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Epulet>> getAll() {
        return ResponseEntity.ok(epuletRepository.findAll());
    }

    @GetMapping("/{iD}")
    public ResponseEntity<Epulet> get(@PathVariable Integer iD) {
        Optional<Epulet> epulet = epuletRepository.findById(iD);
        if (!epulet.isPresent()) {
            ResponseEntity.notFound();
        }

        return ResponseEntity.ok(epulet.get());
    }

    @PostMapping("")
    public ResponseEntity<Epulet> post(@RequestBody Epulet epulet) {
        Epulet newEpulet = epuletRepository.save(epulet);
        return ResponseEntity.ok(newEpulet);
    }

    @DeleteMapping("/{iD}")
    public ResponseEntity delete(@PathVariable Integer iD) {
        Optional<Epulet> epulet = epuletRepository.findById(iD);
        if (!epulet.isPresent()) {
            ResponseEntity.notFound();
        }

        epuletRepository.delete(epulet.get());

        return ResponseEntity.ok().build();
    }

    @PutMapping("/{iD}")
    public ResponseEntity<Epulet> put(@PathVariable Integer iD, @RequestBody Epulet epulet) {
        Optional<Epulet> oldEpulet = epuletRepository.findById(iD);
        if (!oldEpulet.isPresent()) {
            ResponseEntity.notFound();
        }

        epulet.setID(iD);
        return ResponseEntity.ok(epuletRepository.save(epulet));
    }

}
