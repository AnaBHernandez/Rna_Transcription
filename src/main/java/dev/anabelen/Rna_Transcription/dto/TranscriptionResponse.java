package dev.anabelen.Rna_Transcription.dto;

public class TranscriptionResponse {
    private String dnaSequence;
    private String rnaSequence;
    private String message;
    
    public TranscriptionResponse() {}
    
    public TranscriptionResponse(String dnaSequence, String rnaSequence, String message) {
        this.dnaSequence = dnaSequence;
        this.rnaSequence = rnaSequence;
        this.message = message;
    }
    
    public String getDnaSequence() {
        return dnaSequence;
    }
    
    public void setDnaSequence(String dnaSequence) {
        this.dnaSequence = dnaSequence;
    }
    
    public String getRnaSequence() {
        return rnaSequence;
    }
    
    public void setRnaSequence(String rnaSequence) {
        this.rnaSequence = rnaSequence;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
