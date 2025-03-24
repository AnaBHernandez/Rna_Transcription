package dev.anabelen.Rna_Transcription;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RnaTranscriptionTest {
    @Test
    public void testTranscribeDnaToRnaSingleNucleotide() {
        assertEquals("C", RnaTranscription.transcribeDnaToRna("G"));
    }
    @Test
public void testTranscribeDnaToRnaCytosine() {
    // Este test verifica que C se transcriba a G
    assertEquals("G", RnaTranscription.transcribeDnaToRna("C"));
}

}
