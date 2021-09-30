package net.sudau.samples.jenkins.domain.endpoints;

import java.time.LocalDateTime;

import lombok.RequiredArgsConstructor;
import net.sudau.samples.jenkins.domain.dtos.MathParameter;
import net.sudau.samples.jenkins.domain.services.SomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/samples")
@RequiredArgsConstructor
public class SomeRestController {

    private final SomeService someService;

    @GetMapping ("/now")
    public ResponseEntity<LocalDateTime> now () {
        return ResponseEntity.ok(someService.now());
    }

    @PostMapping ("/calculate")
    public ResponseEntity<Double> calculate (
            @RequestBody
                    MathParameter params) {
        return ResponseEntity.ok(someService.calculate(params));
    }
}
