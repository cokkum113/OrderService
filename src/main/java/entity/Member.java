package entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MEMBER")
@Getter
@Setter
@org.hibernate.annotations.DynamicUpdate
public class Member {
    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "NAME")
    private String userName;

    private Integer age;


}
