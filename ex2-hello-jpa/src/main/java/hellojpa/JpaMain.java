package hellojpa;

import java.util.List;

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
			
			//팀 저장
			Team team = new Team();
			team.setName("TeamA");
			em.persist(team);
			
			//멤버저장
			Member member = new Member();
			member.setUsername("member1");
			member.setTeam(team);	//단방향 연관관계 설정, 참조 저장
			em.persist(member);
			
			em.flush();
			em.clear();
			//select 쿼리 보기 위하여 테스트로 영속성 컨텍스트 비워준다.
			
			//조회
			Member findMember = em.find(Member.class, member.getId());
			Team findTeam = findMember.getTeam();
			System.out.println("findTeam = " + findTeam.getName());
			
			tx.commit();
			
		}catch(Exception e) {
			tx.rollback();
		}finally {
			//트랜잭션이 종료되었으므로 엔티티 매니저도 닫아줌
			em.close();
		}
		
		//애플리케이션 종료시
		emf.close();
	}
}
