package edu.miu.amp.repository;

import edu.miu.amp.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Integer> {

    @Query("Select t from Tag t where " + "t.tagName like concat('%', :name, '%')")
    public List<Tag> searchTagsBy(String name);
}
