package alumnimanagement.services.impl;

import alumnimanagement.dto.EducationDto;
import alumnimanagement.entity.Education;
import alumnimanagement.repo.EducationRepo;
import alumnimanagement.services.EducationService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class EducationServiceImpl implements EducationService {

    private final EducationRepo educationRepo;
    private final ModelMapper modelMapper;
    @Override
    public List<EducationDto> getAll() {
        return educationRepo.findAll().stream().map(education -> modelMapper.map(education, EducationDto.class)).toList();
    }

    @Override
    public void create(EducationDto educationDto) {
        educationRepo.save(modelMapper.map(educationDto, Education.class));
    }

    @Override
    public void update(EducationDto educationDto, long id) {
        Education education=modelMapper.map(educationDto,Education.class);
        education.setId(id);
        educationRepo.save(education);

    }

    @Override
    public void delete(long id) {
        educationRepo.findById(id).ifPresent(education -> education.setDeleted(true));
    }
}
