package alumnimanagement.controller;

import alumnimanagement.dto.DropdownDto;
import alumnimanagement.dto.ReportList;
import alumnimanagement.dto.StudentDTO;
import alumnimanagement.entity.Address;
import alumnimanagement.entity.Department;
import alumnimanagement.entity.Student;
import alumnimanagement.entity.job.JobAdvertisement;
import alumnimanagement.services.JobService;
import alumnimanagement.services.StudentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/reports")
@AllArgsConstructor
@CrossOrigin
public class ReportController {

    StudentService studentService;
    JobService jobService;
    ModelMapper modelMapper;

    @GetMapping("/state")
    public List<DropdownDto> state() {
        List<DropdownDto> list = new ArrayList<>();
        List<StudentDTO> students=studentService.findAll();
        for(StudentDTO s: students){
            DropdownDto dto=new DropdownDto();
            dto.setTitle(s.getAddress().getState());
            list.add(dto);
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    @GetMapping("/city")
    public List<DropdownDto> city() {
        List<DropdownDto> list = new ArrayList<>();
        List<StudentDTO> students=studentService.findAll();
        for(StudentDTO s: students){
            DropdownDto dto=new DropdownDto();
            dto.setTitle(s.getAddress().getCity());
            list.add(dto);
        }
        return list.stream().distinct().collect(Collectors.toList());
    }

    @GetMapping("/major")
    public List<DropdownDto> major() {
        List<DropdownDto> list = new ArrayList<>();
        List<StudentDTO> students=studentService.findAll();
        for(StudentDTO s: students){
            DropdownDto dto= new DropdownDto();
            dto.setTitle(s.getMajor().getDepartmentName());
            list.add(dto);
        }

        return list.stream().distinct().collect(Collectors.toList());
    }

    @GetMapping("/studentName")
    public List<DropdownDto> studentName() {
        List<DropdownDto> list = new ArrayList<>();
        List<StudentDTO> students=studentService.findAll();
        for(StudentDTO s: students){
            DropdownDto dto= modelMapper.map(s,DropdownDto.class);
            dto.setTitle(s.getFirstName()+" "+s.getLastName());
            list.add(dto);

        }
        return list;
    }

    @GetMapping("/studentId")
    public List<DropdownDto> studentId() {
        List<DropdownDto> list = new ArrayList<>();
        List<StudentDTO> students=studentService.findAll();
        for(StudentDTO s: students){
            DropdownDto dto= modelMapper.map(s,DropdownDto.class);
            dto.setTitle(s.getId()+"");
            list.add(dto);
        }
        return list;
    }

    @GetMapping("/companyName")
    public List<DropdownDto> companyName() {
        List<DropdownDto> list = new ArrayList<>();
        List<String> ad=jobService.findAllCompany();
        for(String s: ad){
            DropdownDto dto= modelMapper.map(s,DropdownDto.class);
            dto.setTitle(s);
            list.add(dto);
        }
        return list;
    }

    @GetMapping("/studentByState")
    public List<ReportList> studentByState() {
        List<ReportList> list = studentService.StudentByState();
        return list;
    }
    @GetMapping("/jobByState")
    public List<ReportList> jobByState() {
        List<ReportList> list = jobService.JobByState();
        return list;
    }

    @GetMapping("/studentByCity/{stateName}")
    public List<ReportList> findByStatesCity(@PathVariable String stateName ){
        return studentService.findByStateCity(stateName);
    }

}
