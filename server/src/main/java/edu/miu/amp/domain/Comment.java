package edu.miu.amp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor

@SQLDelete(sql = "UPDATE comment SET delete = true WHERE id=?")
@Where(clause = "delete = false")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String comment;

    // @Column(name = "is_delete")
    private Boolean deleted;

}
