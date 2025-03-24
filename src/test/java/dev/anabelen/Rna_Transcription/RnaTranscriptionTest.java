package dev.anabelen.rna_transcripcion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RnaTranscriptionTest {
    @Test
    public void testTranscribeDnaToRnaSingleNucleotide() {
        assertEquals("C", RnaTranscription.transcribeDnaToRna("G"));
    }
}
