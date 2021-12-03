import entity.Department;
import entity.Member;
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
        Department department = new Department("Testtest33", "CS-101", 100000.00);
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

        em2.flush();
        et2.commit();

        Department lastFind = em2.createQuery("select d from Department d where d.deptName = 'Testtest22'", Department.class).getSingleResult();
        System.out.println(lastFind.getDeptName() + " " +
                lastFind.getBuilding()+ " "+
                lastFind.getBudget());


    }

    @Test
    @Transactional
    public void MemberTest()
    {
        String id = "1256";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch3");

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        et.begin();

        Member member1 = new Member();
        member1.setId(id);
        member1.setAge(12);
        member1.setUserName("혜수");

        Member member2 = new Member();
        member2.setUserName("루리");
        member2.setId(id);
        member2.setAge(18);

        System.out.println(member1);
        System.out.println(member2);

        em.persist(member1);
        Member find = em.find(Member.class, id);
        System.out.println(find+"######");
        member1.setAge(20);
        System.out.println(find.getAge());

        em.merge(member2);

        Member findMember1 = em.find(Member.class, id);

        System.out.println(member1);
        System.out.println(member2);
        System.out.println(findMember1);
        et.commit();

    }

}
