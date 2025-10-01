package dev.anabelen.Rna_Transcription.controller;

import dev.anabelen.Rna_Transcription.dto.TranscriptionRequest;
import dev.anabelen.Rna_Transcription.dto.TranscriptionResponse;
import dev.anabelen.Rna_Transcription.service.TranscriptionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/transcription")
@CrossOrigin(origins = "*")
public class TranscriptionController {
    
    @Autowired
    private TranscriptionService transcriptionService;
    
    @PostMapping("/transcribe")
    public ResponseEntity<TranscriptionResponse> transcribeDnaToRna(@Valid @RequestBody TranscriptionRequest request) {
        try {
            TranscriptionResponse response = transcriptionService.transcribeDnaToRna(request);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            TranscriptionResponse errorResponse = new TranscriptionResponse(
                request.getDnaSequence(),
                null,
                "Error: " + e.getMessage()
            );
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    
    @GetMapping("/transcribe/{dnaSequence}")
    public ResponseEntity<TranscriptionResponse> transcribeDnaToRnaSimple(@PathVariable String dnaSequence) {
        try {
            String rnaSequence = transcriptionService.transcribeDnaToRna(dnaSequence);
            TranscriptionResponse response = new TranscriptionResponse(
                dnaSequence,
                rnaSequence,
                "Transcripción completada exitosamente"
            );
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            TranscriptionResponse errorResponse = new TranscriptionResponse(
                dnaSequence,
                null,
                "Error: " + e.getMessage()
            );
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }
    
    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("RNA Transcription API is running");
    }
}
