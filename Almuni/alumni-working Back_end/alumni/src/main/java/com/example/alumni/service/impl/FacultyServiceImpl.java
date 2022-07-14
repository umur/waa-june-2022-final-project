package com.example.alumni.service.impl;



import com.example.alumni.dto.FacultyDto;
import com.example.alumni.entity.Faculty;
import com.example.alumni.repository.IFacultyRepository;
import com.example.alumni.service.IFacultyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
@Transactional
public class FacultyServiceImpl implements IFacultyService {

    @Autowired
    private IFacultyRepository facultyRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<FacultyDto> addFaculty(Faculty faculty) {

        var newFaculty= modelMapper.map(faculty, Faculty.class);
        facultyRepo.save(faculty);

        return ResponseEntity.ok(modelMapper.map(faculty,FacultyDto.class));
    }

    @Override
    public ResponseEntity<List<FacultyDto>> getAllFaculty() {

        List<FacultyDto> facultyDtos=new ArrayList<>();
        var  list =facultyRepo.findAll();

        for(Faculty faculty:list){
            facultyDtos.add(modelMapper.map(faculty,FacultyDto.class));

        }
        return ResponseEntity.ok(facultyDtos);
    }

    @Override
    public ResponseEntity<FacultyDto> getFacultyById(Long id) {

        var faculty=facultyRepo.findById(id).orElse(null);
        var facultyDto=modelMapper.map(faculty,FacultyDto.class);

        return ResponseEntity.ok(facultyDto);
    }

    @Override
    public String deleteById(Long id) {

        String faculty="null";

        if(facultyRepo.findById(id).isPresent()){
            facultyRepo.deleteById(id);
            faculty= "deleted";
        }
        else{
            faculty="no faculty with this id ="+id;
        }
        return faculty;

    }

    @Override
    public ResponseEntity<FacultyDto> updateFaculty(Faculty faculty, Long id) {

        if(facultyRepo.findById(id).isPresent()){
            facultyRepo.save(faculty);
            var updateFaculty=modelMapper.map(faculty,FacultyDto.class);
            return ResponseEntity.ok(updateFaculty);
        }
        else{
            throw new RuntimeException("faculty with this id"+id+"is not found");
        }

    }

    @Override
    public Faculty findByEmail(String email) {
        var facultyByEmail = facultyRepo.findByEmail(email);
        return facultyByEmail;
    }
}
