package app;

import app.models.Vaga;

import java.util.List;

import app.dao.*;

import app.views.Main;

public class App {

	 public static void main(String[] args) {
	     
		 Main.main(args);
		 return;
//		 Vaga v1 = new Vaga();
//	     
//	     v1.setNome("Designer");
//	     v1.setAtivo(true);
//	     v1.setDescricao("UX/UI");
//	     v1.setEmpresa("iFood");
//	     v1.setSalario(5000);
//	     v1.setStatus('A');
//	     
//	     VagaDAO VagaDAO = objetoDAO.getDAO(VagaDAO.class);
//	     VagaDAO.save(v1);
//	     
//	     try {
//			Vaga v2 = VagaDAO.findByPk(2);
//			System.out.println(v2.getEmpresa());
//			System.out.println(v2.toString());
//			v2.setEmpresa("Zoop Pagamentos");
//			v2.setDescricao("Programador backend em python");
//			v2.setNome("Programador Backend");
//			v2.setSalario(8000);
//			
//			
//			VagaDAO.update(v2);
//			System.out.println(v2.getEmpresa());
//			System.out.println(v2.toString());
//			
//			
//			List<Vaga> vs = VagaDAO.findAll();
//			System.out.println(vs.toString());
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	     
	    
//		 System.out.println(v1.getNome());

	    }
	    
}
