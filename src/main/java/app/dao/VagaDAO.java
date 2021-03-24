package app.dao;

import java.util.List;

import app.models.Vaga;

public interface VagaDAO {
	long save(Vaga vaga);
	
	void update(Vaga vaga)
		throws Exception; 
		
	void delete(long id) 
		throws Exception; 
		
	Vaga findByPk(long id) 
		throws Exception; 
		
	List<Vaga> findAll();
}
