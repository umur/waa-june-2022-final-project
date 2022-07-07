package alumnimanagement.services;

import alumnimanagement.dto.EducationDto;

import java.util.List;

public interface EducationService {
    public List<EducationDto> getAll();

    public void create(EducationDto educationDto);

    public void update(EducationDto educationDto, long id);

    public void delete(long id);
}
