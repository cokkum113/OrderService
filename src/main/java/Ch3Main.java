import entity.Member;

import javax.persistence.*;
import java.util.List;

public class Ch3Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ch3");

    public static void main(String[] args) {
        Member member = createMember("memberB", "회원1", 19);

        member.setUserName("회원명 변경");

        mergeMember(member);
    }

    static Member createMember(String id, String userName, int age) {
        EntityManager em1 = emf.createEntityManager();
        EntityTransaction tx1 = em1.getTransaction();
        tx1.begin();

        Member member = new Member();
        member.setId(id);
        member.setUserName(userName);
        member.setAge(age);

        em1.persist(member);
        tx1.commit();

        em1.close();

        return member;
    }

    static void mergeMember(Member member){
        EntityManager em2 = emf.createEntityManager();
        EntityTransaction tx2 = em2.getTransaction();

        tx2.begin();
        Member mergeMember = em2.merge(member);
        tx2.commit();

        System.out.println("member = " + member.getUserName());

        System.out.println("mergeMember = " + mergeMember.getUserName());

        System.out.println("em2 contains member = " + em2.contains(member));

        System.out.println("em2 contains mergeMember = " + em2.contains(mergeMember));

        em2.close();
    }
}
