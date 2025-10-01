package dev.anabelen.Rna_Transcription.service;

import dev.anabelen.Rna_Transcription.dto.TranscriptionRequest;
import dev.anabelen.Rna_Transcription.dto.TranscriptionResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TranscriptionServiceTest {
    
    @Autowired
    private TranscriptionService transcriptionService;
    
    @Test
    public void testTranscribeDnaToRnaWithRequest() {
        TranscriptionRequest request = new TranscriptionRequest("GCTA");
        TranscriptionResponse response = transcriptionService.transcribeDnaToRna(request);
        
        assertEquals("GCTA", response.getDnaSequence());
        assertEquals("CGAU", response.getRnaSequence());
        assertEquals("Transcripción completada exitosamente", response.getMessage());
    }
    
    @Test
    public void testTranscribeDnaToRnaWithString() {
        String result = transcriptionService.transcribeDnaToRna("GCTA");
        assertEquals("CGAU", result);
    }
    
    @Test
    public void testTranscribeDnaToRnaWithLowerCase() {
        TranscriptionRequest request = new TranscriptionRequest("gcta");
        TranscriptionResponse response = transcriptionService.transcribeDnaToRna(request);
        
        assertEquals("GCTA", response.getDnaSequence());
        assertEquals("CGAU", response.getRnaSequence());
    }
    
    @Test
    public void testTranscribeDnaToRnaWithInvalidNucleotide() {
        assertThrows(IllegalArgumentException.class, () -> {
            transcriptionService.transcribeDnaToRna("INVALID");
        });
    }
}
