package alumnimanagement.services.impl;

import alumnimanagement.dto.EducationDto;
import alumnimanagement.repo.EducationRepo;
import alumnimanagement.services.EducationService;
import lombok.AllArgsConstructor;

import java.util.List;
@AllArgsConstructor
public class EducationServiceImpl implements EducationService {

    private final EducationRepo educationRepo;
    @Override
    public List<EducationDto> getAll() {
        return null;
    }

    @Override
    public void create(EducationDto educationDto) {

    }

    @Override
    public void update(EducationDto educationDto, long id) {

    }

    @Override
    public void delete(long id) {

    }
}
