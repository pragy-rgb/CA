package com.example.patient;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
 
import com.example.patient.controller.PatientController;
import com.example.patient.entity.Patient;
import com.example.patient.repository.PatientRepository;
import com.example.patient.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
 

@WebMvcTest(PatientController.class)
public class PatientControllerTest {

      @MockBean
      private PatientRepository patientRepository;

      @MockBean
      private PatientService patientService;
 
      @Autowired
      private MockMvc mockMvc;
 
      @Autowired
      private ObjectMapper objectMapper;
 
      @Test
      void shouldCreateDoctor() throws Exception {
        Patient patient=new Patient("Pragya Kumari", "Dr.Rahul");
 
        mockMvc.perform(post("/patients/").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(patient)))
            .andExpect(status().isOk())
            .andDo(print());
      }
 
      @Test
      void shouldReturnDoctor() throws Exception {
        int id=9;
        String name="Mona";
        Patient patient=new Patient("Pragya Kumari", "Dr.Rahul");
 
       //hen(patientRepository.findById(id).thenReturn(Optional.of(patient).get()));
        //en(doctorRepository.findById(id)).thenReturn(Optional.of(doctor));
        mockMvc.perform(get("/doctors/get/{id}", id)).andExpect(status().isOk())
            /*.andExpect(jsonPath("$.id").value(id))
            .andExpect(jsonPath("$.name").value(name))
            .andExpect(jsonPath("$.gender").value(doctor.getGender()))
            .andExpect(jsonPath("$.specialist").value(doctor.getSpecialist()))
            .andExpect(jsonPath("$.numberOfPatients").value(doctor.getNumberOfPatients()))
            .andExpect(jsonPath("$.age").value(doctor.getAge()))
            .andExpect(status().isOk())*/
            .andDo(print());
      }
 
  
 
}