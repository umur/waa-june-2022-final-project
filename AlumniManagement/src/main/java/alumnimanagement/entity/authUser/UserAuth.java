package alumnimanagement.entity.authUser;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Entity
    @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
    @DiscriminatorColumn(name = "Role")
    public class UserAuth {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(columnDefinition = "serial")
        private Long id;

        private String username;

        private String password;

        private boolean isActive;

        private String otp;

        private String image;

        @Column(insertable = false, updatable = false)
        private String Role;
    }

