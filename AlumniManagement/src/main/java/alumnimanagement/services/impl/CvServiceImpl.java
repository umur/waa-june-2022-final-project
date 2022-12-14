package alumnimanagement.services.impl;

import alumnimanagement.dto.CvDto;
import alumnimanagement.entity.Cv;
import alumnimanagement.repo.CvRepo;
import alumnimanagement.services.CvService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class CvServiceImpl implements CvService {

    private final ModelMapper modelMapper;
    private final CvRepo cvRepo;
    @Override
    public List<CvDto> getAll() {
        return cvRepo.findAll()
                .stream()
                .map(cv -> modelMapper
                        .map(cv,CvDto.class))
                .toList();
    }

    @Override
    public void create(CvDto cvDto) {
        cvRepo.save(modelMapper.map(cvDto, Cv.class));
    }

    @Override
    public void update(CvDto cvDto, long id) {
        Cv myCv= modelMapper.map(cvDto, Cv.class);
        myCv.setId(id);
        cvRepo.save(myCv);

    }

    @Override
    public void delete(long id) {
        cvRepo.deleteById(id);

    }
}
