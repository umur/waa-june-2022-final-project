package alumnimanagement.services;

import alumnimanagement.dto.CvDto;

import java.util.List;

public interface CvService {

    public List<CvDto> getAll();

    public void create(CvDto cvDto);

    public void update(CvDto cvDto, long id);

    public void delete(long id);
}
