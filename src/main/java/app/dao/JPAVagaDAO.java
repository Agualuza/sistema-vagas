package app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.LockModeType;
import javax.persistence.OptimisticLockException;

import app.models.Vaga;
import app.components.FabricaDeEntityManager;

public class JPAVagaDAO implements VagaDAO {

	@Override
	public long save(Vaga vaga) {
		// TODO Auto-generated method stub
		EntityManager em = null;
		EntityTransaction tx = null;
	
		try {
			em = FabricaDeEntityManager.criarSessao();
			tx = em.getTransaction();
			tx.begin();
			
			em.persist(vaga);
			
			
			tx.commit();
			
			return vaga.getId();
			
		} catch (RuntimeException e) {
			if (tx != null) {	
				try {	
					tx.rollback();
				}
				catch(RuntimeException he){}
			}
			throw e;
		}
		finally {
			em.close();
		}	
		
	}
	
	@Override
	public void update(Vaga vaga) throws Exception
	{	EntityManager em = null;
		EntityTransaction tx = null;
		Vaga produto = null;
		try {	
			em = FabricaDeEntityManager.criarSessao();
			tx = em.getTransaction();
			tx.begin();
			
			em.find(Vaga.class, vaga.getId(), LockModeType.PESSIMISTIC_WRITE);
			
			if(vaga == null) {
				tx.rollback();
				throw new Exception("Vaga não encontrada");
			}
			
			em.merge(vaga);
			tx.commit();
		} catch(OptimisticLockException e) { 
			if (tx != null) {
				tx.rollback();
			}
			
			throw new Exception("Versão obsoleta");
		} catch(RuntimeException e) { 
			if (tx != null) {   
				try {	
					tx.rollback();
		        } catch(RuntimeException he) { }
		    }
		    throw e;
		}
		finally {   
			em.close();
		}
	}
	
	@Override
	public Vaga findByPk(long id) throws Exception {
		EntityManager em = null;
		
		try
		{	
			em = FabricaDeEntityManager.criarSessao();

			Vaga vaga = em.find(Vaga.class, id);
			

			if(vaga == null)
			{	throw new Exception("Vaga não encontrada");
			}
			return vaga;
		} 
		finally
		{   em.close();
		}
	}
	
	@Override
	public List<Vaga> findAll() {	
		EntityManager em = null;
		
		try {
			em = FabricaDeEntityManager.criarSessao();
		
			@SuppressWarnings("unchecked")
			List<Vaga> vagas = em.createQuery("SELECT v FROM Vaga v ORDER BY v.id").getResultList();
			
			return vagas;
		} finally	{   
			em.close();
		}
	}

	@Override
	public void delete(long id) throws Exception {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try
		{	
			em = FabricaDeEntityManager.criarSessao();
			tx = em.getTransaction();
			tx.begin();

			Vaga vaga = em.find(Vaga.class, new Long(id), LockModeType.PESSIMISTIC_WRITE);
			
			if(vaga == null)
			{	tx.rollback();
				throw new Exception("Vaga não encontrada");
			}

			em.remove(vaga);
			tx.commit();
		} 
		catch(RuntimeException e)
		{   
			if (tx != null)
		    {   
				try
		        {	tx.rollback();
		        }
		        catch(RuntimeException he)
		        { }
		    }
		    throw e;
		}
		finally
		{   em.close();
		}
	}
	
	
}
