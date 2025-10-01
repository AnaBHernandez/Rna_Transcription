package dev.anabelen.Rna_Transcription.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public class TranscriptionRequest {
    
    @NotBlank(message = "La secuencia de ADN no puede estar vacía")
    @Pattern(regexp = "^[GCTA]+$", message = "La secuencia debe contener solo nucleótidos válidos (G, C, T, A)")
    private String dnaSequence;
    
    public TranscriptionRequest() {}
    
    public TranscriptionRequest(String dnaSequence) {
        this.dnaSequence = dnaSequence;
    }
    
    public String getDnaSequence() {
        return dnaSequence;
    }
    
    public void setDnaSequence(String dnaSequence) {
        this.dnaSequence = dnaSequence;
    }
}
