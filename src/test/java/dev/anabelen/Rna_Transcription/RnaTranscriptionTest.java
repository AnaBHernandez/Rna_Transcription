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
    assertEquals("G", RnaTranscription.transcribeDnaToRna("C"));
    }
    @Test
    public void testTranscribeDnaToRnaThymine() {   
    assertEquals("A", RnaTranscription.transcribeDnaToRna("T"));
    }
    @Test
    public void testTranscribeDnaToRnaAdenine() {
    assertEquals("U", RnaTranscription.transcribeDnaToRna("A"));
    }
    @Test
    public void testTranscribeDnaToRnaSequence() {    
    assertEquals("CGAU", RnaTranscription.transcribeDnaToRna("GCTA"));
    }
}
