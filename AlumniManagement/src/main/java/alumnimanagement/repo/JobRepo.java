package alumnimanagement.repo;

import alumnimanagement.entity.job.JobAdvertisement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobRepo extends JpaRepository<JobAdvertisement, Integer> {
    List<JobAdvertisement> findTop10ByOrderByPublishDateDesc();
    List<JobAdvertisement> findAllByStudentId(Long id);
    long countByStudentId(Long id);
    @Query("SELECT A.state as title, count(S.id) as id FROM Address A JOIN  JobAdvertisement S ON S.address.id = A.id group by A.state")
    List<Object[]> JobByState();
    @Query("SELECT distinct(A.companyName) from JobAdvertisement  A order by A.companyName desc")
    List<String> findAllByCompanyNames();

    List<JobAdvertisement> findAllByStudentId(long id);

    @Query("select J.jobTag as jobtag from JobAdvertisement J  WHERE J.jobTag is not null")
    List<String> findByTags();

    //@Query("select A.state,j.jobTag from Address A left join JobAdvertisement j on j.address.id = A.id where j.jobTag is not null")

    List<JobAdvertisement> findJobAdvertisementsByAddressStateContaining(String state);
}
