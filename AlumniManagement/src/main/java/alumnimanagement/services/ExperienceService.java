package alumnimanagement.services;

import alumnimanagement.dto.ExperienceDto;

import java.util.List;

public interface ExperienceService {

    public List<ExperienceDto> getAll();

    public void create(ExperienceDto experienceDto);

    public void update(ExperienceDto experienceDto, long id);

    public void delete(long id);
}
