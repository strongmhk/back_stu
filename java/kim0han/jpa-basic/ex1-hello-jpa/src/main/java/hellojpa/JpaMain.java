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

            Team team = new Team();
            team.setName("TeamA");
            em.persist(team); // 1차 캐시에 저장

            Member member = new Member();
            member.setUsername("member1");
            em.persist(member); // 1차 캐시에 저장

            team.addMember(member);




//            em.flush();
//            em.clear();

            Team findTeam = em.find(Team.class, team.getId()); // 메모리에 있는 1차 캐시에서 가져옴
            List<Member> members = findTeam.getMembers();

            System.out.println("=================");
            System.out.println("findTeam = " + findTeam);
            System.out.println("=================");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();



    }
}