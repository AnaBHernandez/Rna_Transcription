package dev.anabelen.Rna_Transcription.service;

import dev.anabelen.Rna_Transcription.dto.TranscriptionRequest;
import dev.anabelen.Rna_Transcription.dto.TranscriptionResponse;
import dev.anabelen.Rna_Transcription.RnaTranscription;
import org.springframework.stereotype.Service;

@Service
public class TranscriptionService {
    
    public TranscriptionResponse transcribeDnaToRna(TranscriptionRequest request) {
        String dnaSequence = request.getDnaSequence().toUpperCase();
        String rnaSequence = RnaTranscription.transcribeDnaToRna(dnaSequence);
        
        return new TranscriptionResponse(
            dnaSequence,
            rnaSequence,
            "Transcripción completada exitosamente"
        );
    }
    
    public String transcribeDnaToRna(String dna) {
        return RnaTranscription.transcribeDnaToRna(dna);
    }
}
