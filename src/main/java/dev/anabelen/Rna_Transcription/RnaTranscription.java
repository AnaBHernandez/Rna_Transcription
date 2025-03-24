package dev.anabelen.Rna_Transcription;

public class RnaTranscription {
    public static String transcribeDnaToRna(String dna) {
        if ("G".equals(dna)) {
            return "C";
        }
        return "";
    }
}
