package entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "department")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@org.hibernate.annotations.DynamicUpdate
public class Department {

    @Id
    @Column(name = "dept_name")
    private String deptName;

    @Column(name = "building")
    private String building;

    @Column(name = "budget")
    private Double budget;


}
