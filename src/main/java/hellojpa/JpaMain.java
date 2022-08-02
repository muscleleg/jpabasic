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
//            //비영속
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA2");
//
//            //영속
//            System.out.println("before");
//            em.persist(member);
//            System.out.println("after");
//
//            //조회용 sql이 안나가면 1차캐시에서 데이터를 찾는다는 것이 증명됨
//            Member findMember = em.find(Member.class, 101L);
//
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());
//-------------------------------동일성 보장--------------------------------------------------------
            //findMember1에서 쿼리가 한번 나가고
            //findMember2에서는 캐시때문에 커리가 나가면 안됨
//            Member findMember1 = em.find(Member.class, 101L);
//            Member findMember2 = em.find(Member.class, 101L);
//            System.out.println("result : "+(findMember1==findMember2));
//            tx.commit();
            //----------------쓰기기지연---------------------------
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("======================");
//            tx.commit();
            //--------------플러시----------
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush();
//            System.out.println("===================");
//            tx.commit();
            //--------------준영속----------준영속이 되어 셀렉트만되고 업데이트쿼리는 안나감
            Member member = em.find(Member.class, 1L);
            member.setName("test");
//            em.detach(member); //하나만 없앰
            em.clear();//모두 없앰
            Member member2 = em.find(Member.class, 1L);//영속성 캔택스트에서 제거했기때문에 여기서도 select문이 나감
            System.out.println("===================");
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
