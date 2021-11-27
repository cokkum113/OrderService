import entity.Department;
import org.junit.jupiter.api.Test;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

public class Problem {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("test_db");


    @Test
    @Transactional
    public void problem1() {

        EntityManager em1 = emf.createEntityManager();
        EntityTransaction et = em1.getTransaction();
        et.begin();
        Department department = new Department("computerScience", "CS-101", 100000.00);
        em1.persist(department);
        et.commit();

    }

    @Test
    @Transactional
    public void problem2(){
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction et2 = em2.getTransaction();
        et2.begin();
        Department department = new Department("computerScience", "CS-101", 100000.00);
        em2.setFlushMode(FlushModeType.COMMIT);
        em2.persist(department);

        List<Department> departments = em2.createQuery("select d from Department d", Department.class).getResultList();
        for(Department depart : departments){
            System.out.println(depart);
        }

        Department findDepartment = em2.createQuery("select d from Department d where d.deptName = 'computerScience'", Department.class).getSingleResult();
        System.out.println(findDepartment.getDeptName() + " " +
                findDepartment.getBuilding()+ " "+
                findDepartment.getBudget());

    }


}
