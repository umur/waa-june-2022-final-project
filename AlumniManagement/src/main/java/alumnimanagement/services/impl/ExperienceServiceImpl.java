package alumnimanagement.services.impl;

import alumnimanagement.dto.ExperienceDto;
import alumnimanagement.entity.Experience;
import alumnimanagement.repo.ExperienceRepo;
import alumnimanagement.services.ExperienceService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ExperienceServiceImpl implements ExperienceService {
    private final ModelMapper modelMapper;
    private final ExperienceRepo experienceRepo;

    @Override
    public List<ExperienceDto> getAll() {
        return experienceRepo.findAll().stream().map(experience -> modelMapper.map(experience, ExperienceDto.class)).toList();
    }

    @Override
    public void create(ExperienceDto experienceDto) {
        experienceRepo.save(modelMapper.map(experienceDto, Experience.class));

    }

    @Override
    public void update(ExperienceDto experienceDto, long id) {
        Experience experience=modelMapper.map(experienceDto, Experience.class);
        experience.setId(id);
        experienceRepo.save(experience);
    }

    @Override
    public void delete(long id) {
        experienceRepo.deleteById(id);
    }
}
