package alumnimanagement.services.impl;

import alumnimanagement.dto.DropdownDto;
import alumnimanagement.dto.ReportList;
import alumnimanagement.dto.StudentDTO;
import alumnimanagement.dto.StudentListDto;
import alumnimanagement.dto.UpdateCVDTO;
import alumnimanagement.entity.Address;
import alumnimanagement.entity.Student;
import alumnimanagement.repo.StudentRepo;
import alumnimanagement.services.StudentService;
import alumnimanagement.utility.Helper;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    private StudentRepo studentRepo;
    private ModelMapper modelMapper;

    @Override
    public void create(StudentDTO studentDTO) {
        studentRepo.save(modelMapper.map(studentDTO, Student.class));
    }

    @Override
    public void update(long id, StudentDTO studentDTO) throws Exception {
        Student student = studentRepo.findById(id).orElseThrow(() -> new Exception("Student id is invalid"));
        student.setAddress(modelMapper.map(studentDTO.getAddress(), Address.class));
        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setId(id);
        studentRepo.save(student);

    }

    @Override
    public List<StudentDTO> findAll() {
//        List<StudentDTO> studentDTOS = studentRepo.findAll().stream().map(student -> {
//            return modelMapper.map(student, StudentDTO.class);
//        }).toList();
//
//        return studentDTOS;

        List<StudentDTO> studentDTOS = studentRepo.findAll().stream().filter(student -> !(student.isDeleted())).map(student -> {
            return modelMapper.map(student, StudentDTO.class);
        }).toList();

        return studentDTOS;

    }

    @Override
    public Long totalStudents(String state, String city, String major, String studentName,long id) {
        Long count = studentRepo.count();
        if(id !=0 || !state.equals("''")||!city.equals("''")||!major.equals("''")||!studentName.equals("''")){
            return findByFilter(state,city,major,studentName,id).stream().count();
        }
        return count;
    }

    @Override
    public StudentDTO findStudentById(long id) {
        Student s = studentRepo.findById(id).get();
        return modelMapper.map(s, StudentDTO.class);
    }

    @Override
    public List<ReportList> StudentByState() {
        var result = studentRepo.StudentByState();
        List<ReportList> result2 = new ArrayList<>();
        for (Object[] d : result) {
            Long id = (Long) d[1];
            ReportList dto = new ReportList();
            dto.value = id;
            dto.name = (String) d[0];
            result2.add(dto);
        }
        return result2;
    }

    @Override
    public void updateStudentCV(long id, UpdateCVDTO updateCVDTO) {
        Student s = studentRepo.findById(id).get();
        s.setCvLink(updateCVDTO.getCvLink());
        s.setJobExperienceList(updateCVDTO.getJobExperienceList());

        System.out.println(s);
        studentRepo.save(s);
//        System.out.println(id + "   "+ updateCVDTO.toString());
    }

    @Override
    public List<ReportList> findByStateCity(String state) {

        var result = studentRepo.StudentByCity(state.toUpperCase());
        List<ReportList> result2 = new ArrayList<>();
        for(Object[] d : result)
        {
            Long id =(Long) d[1];
            ReportList dto = new ReportList();
            dto.value = id;
            dto.name = (String) d[0];
            result2.add(dto);
        }
        return result2;
    }


    @Override
    public List<StudentListDto> findAllByParam(int page, int size, String state, String city, String major, String studentName,long id) {
       if(id !=0 || !state.equals("''")||!city.equals("''")||!major.equals("''")||!studentName.equals("''")){
            return findByFilter(state,city,major,studentName,id).stream().skip(page*size).limit(5).toList();
       }
        Pageable pageable = PageRequest.of(page, size);
        List<Student> student = studentRepo.findAll(pageable).stream().toList();
        List<StudentListDto> studentListDtos = new ArrayList<>();
        for(Student r : student)
        {
            if(!r.isDeleted()) {
                StudentListDto dtp = new StudentListDto();
                dtp.setEmail(r.getEmail());
                dtp.setFirstName(r.getFirstName());
                dtp.setLastName(r.getLastName());
                dtp.setCity(r.getAddress().getCity());
                dtp.setState(r.getAddress().getState());
                dtp.setId(r.getId());
                studentListDtos.add(dtp);
            }
        }
        return studentListDtos;
    }

    public List<StudentListDto> findByFilter(String state, String city, String major, String studentName,long id)
    {
        List<Student> students=studentRepo.findAll().stream().toList();
        List<StudentListDto> dto=new ArrayList<>();

        for(Student s: students){
            String sName=s.getFirstName()+" "+s.getLastName();
            if(!s.isDeleted())
            {
                if(s.getId() == id
                    ||s.getAddress().getState().equals(state)
                    ||s.getAddress().getCity().equals(city)
                    ||s.getMajor().getDepartmentName().equals(major)
                    ||sName.toUpperCase().equals(studentName.toUpperCase()))
                {
                    StudentListDto dto1=modelMapper.map(s, StudentListDto.class);
                    dto1.setState(s.getAddress().getState());
                    dto1.setCity(s.getAddress().getCity());
                    dto.add(dto1);
                }
            }
        }
        return  dto;
    }
    @Override
    public void remove(long id) {
        Student target= studentRepo.findById(id).get();
        target.setDeleted(true);
    }
}
