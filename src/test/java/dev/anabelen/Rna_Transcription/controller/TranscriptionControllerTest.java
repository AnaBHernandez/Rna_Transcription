package dev.anabelen.Rna_Transcription.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.anabelen.Rna_Transcription.dto.TranscriptionRequest;
import dev.anabelen.Rna_Transcription.service.TranscriptionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TranscriptionController.class)
public class TranscriptionControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockBean
    private TranscriptionService transcriptionService;
    
    @Autowired
    private ObjectMapper objectMapper;
    
    @Test
    public void testTranscribeDnaToRnaPost() throws Exception {
        TranscriptionRequest request = new TranscriptionRequest("GCTA");
        
        when(transcriptionService.transcribeDnaToRna(any(TranscriptionRequest.class)))
            .thenReturn(new dev.anabelen.Rna_Transcription.dto.TranscriptionResponse("GCTA", "CGAU", "Transcripción completada exitosamente"));
        
        mockMvc.perform(post("/api/transcription/transcribe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dnaSequence").value("GCTA"))
                .andExpect(jsonPath("$.rnaSequence").value("CGAU"))
                .andExpect(jsonPath("$.message").value("Transcripción completada exitosamente"));
    }
    
    @Test
    public void testTranscribeDnaToRnaGet() throws Exception {
        when(transcriptionService.transcribeDnaToRna("GCTA"))
            .thenReturn("CGAU");
        
        mockMvc.perform(get("/api/transcription/transcribe/GCTA"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.dnaSequence").value("GCTA"))
                .andExpect(jsonPath("$.rnaSequence").value("CGAU"));
    }
    
    @Test
    public void testHealthEndpoint() throws Exception {
        mockMvc.perform(get("/api/transcription/health"))
                .andExpect(status().isOk())
                .andExpect(content().string("RNA Transcription API is running"));
    }
    
    @Test
    public void testInvalidDnaSequence() throws Exception {
        TranscriptionRequest request = new TranscriptionRequest("INVALID");
        
        mockMvc.perform(post("/api/transcription/transcribe")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}
