package hellojpa;

import javax.persistence.*;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
//            생성
//            Member member = new Member();
//            member.setId(1L);
//            member.setName("HelloA");
//            em.persist(member);
//            tx.commit();

            //조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//            tx.commit();

            //제거
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);
//            tx.commit();

//            //수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJPA");
//            tx.commit();

            //전부 조회
//            List<Member> result = em.createQuery("select m from Member as m", Member.class).getResultList();
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }
            //일부만 조회
//            List<String> result = em.createQuery("select m.name from Member as m", String.class).getResultList();
//            for (String member : result) {
//                System.out.println("member.name = " + member);
//            }

            //-------------------------------------------------------
            //비영속
            Member member = new Member();
            member.setId(100L);
            member.setName("HelloJPA2");

            //영속
            System.out.println("before");
            em.persist(member);
            System.out.println("after");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
