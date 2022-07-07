package alumnimanagement.controller;

import alumnimanagement.dto.FacultyDTO;
import alumnimanagement.services.FacultyService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/faculties")
@CrossOrigin
public class FacultyController {
    private final FacultyService facultyService;

    @PostMapping
    public void createFaculty(@RequestBody FacultyDTO facultyDTO) {
        facultyService.create(facultyDTO);
    }

    @GetMapping
    public List<FacultyDTO> findAllFaculty() {
        return facultyService.findAll();
    }

    @PutMapping("/{id}")
    public void updateFaculty(@PathVariable long id, @RequestBody FacultyDTO facultyDTO) throws Exception {
        facultyService.update(id, facultyDTO);
    }

    @DeleteMapping("/{id}")
    public void removeFaculty(@PathVariable long id) {
        facultyService.remove(id);
    }
}
