package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("============");

            em.persist(member1); // 1,51
            em.persist(member2); // MEM -> DB 호출X
            em.persist(member3); // MEM -> DB 호출X

            System.out.println("member1.id = " + member1.getId());
            System.out.println("member2.id = " + member2.getId());
            System.out.println("member3.id = " + member3.getId());

            System.out.println("============");

            //DB SEQ = 1  | 1
            //DB SEQ = 51 | 2
            //DB SEQ = 51 | 3


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();



    }
}