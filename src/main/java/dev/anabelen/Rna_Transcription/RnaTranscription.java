package dev.anabelen.Rna_Transcription;

public class RnaTranscription {
    public static String transcribeDnaToRna(String dna) {
        switch (dna) {
            case "G": return "C";
            case "C": return "G";
            default: return "";
        }
    }
}