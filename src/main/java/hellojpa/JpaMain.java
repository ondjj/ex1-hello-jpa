package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 저장
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("helloB");
//            em.persist(member);

            // 조회
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember = " + findMember.getId());
//            System.out.println("findMember = " + findMember.getName());

            // 수정 -> JPA를 통해서 entity를 가져오면 jpa가 변경 요소를 체크 하고 업데이트 쿼리를 날린다.
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("HelloJAP");

            // 전체 조회
            List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .getResultList();
            for (Member member : result) {
                System.out.println("member = " + member.getName());
            }
            tx.commit();
        }catch (Exception e){
            tx.rollback();
        }finally {
            em.close();
        }
        emf.close();
    }
}
