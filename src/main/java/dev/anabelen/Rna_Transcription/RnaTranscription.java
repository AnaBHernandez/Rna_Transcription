package dev.anabelen.Rna_Transcription;

public class RnaTranscription {
    public static String transcribeDnaToRna(String dna) {
        StringBuilder rna = new StringBuilder();
        for (char nucleotide : dna.toCharArray()) {
            switch (nucleotide) {
                case 'G': rna.append("C"); break;
                case 'C': rna.append("G"); break;
                case 'T': rna.append("A"); break;
                case 'A': rna.append("U"); break;
                default: throw new IllegalArgumentException("Nucleótido no válido: " + nucleotide);
            }
        }
        return rna.toString();
    }
}
