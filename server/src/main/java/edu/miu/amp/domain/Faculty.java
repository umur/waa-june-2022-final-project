package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE faculty SET is_delete = true WHERE id=?")
@Where(clause = "is_delete = false")
public class Faculty extends User {
    @Id
    private Integer id;

    @ManyToOne
    private Department department;

    @OneToMany
    @JoinColumn(name = "faculty_id")
    private List<Comment> commentList;

    @Column(name = "is_delete")
    private boolean delete;


}
