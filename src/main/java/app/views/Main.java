package app.views;

import java.awt.Color;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import app.dao.*;
import app.models.Vaga;

public class Main {  
  public static void main(String[] args) {  
    final JFrame f=new JFrame();//creating instance of JFrame  
    f.setResizable(false);
    JButton b=new JButton("Adicionar Vaga");//creating instance of JButton
    JButton b2=new JButton("Listar Vagas");//creating instance of JButton  
    b.setBounds(40,100,140, 40);//x axis, y axis, width, height  
    b2.setBounds(220,100,140, 40);//x axis, y axis, width, height          
    
    f.add(b);//adding button in JFrame  
    f.add(b2);//adding button in JFrame 
    
    b2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            eventoLista(evt, f);
        }
    });
    
    b.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
        	formEvt(evt, null, f);
        }
    });
              
    f.setSize(400,500);//400 width and 500 height  
    f.setLocationRelativeTo(null);
    f.setLayout(null);//using no layout managers  
    f.setVisible(true);//making the frame visible  
  }  
  
  private static void eventoLista(java.awt.event.ActionEvent evt, final JFrame f) {//GEN-FIRST:event_eventoLista
	  try {
		  	final JFrame j=new JFrame();//creating instance of JFrame
		  	f.setVisible(false);
		  	
		  	j.setSize(400,500);
		  	j.setLocationRelativeTo(null);
		    j.setLayout(null);
		  	j.setVisible(true);
		  	j.setResizable(false);
		  	
		  	VagaDAO VagaDAO = objetoDAO.getDAO(VagaDAO.class);
		  	String[] columnNames = {
		  							"Cod",
		  							"Nome",
				                    "Descrição",
				                    "Empresa",
				                    "Salário",
				                    "Status"
				                    };
		  	
		  	
			List<Vaga> vs = VagaDAO.findAll();			
			
			final JTable table = new javax.swing.JTable();
			table.setModel(new javax.swing.table.DefaultTableModel(
		            new Object [][] {

		            },
		            columnNames
	        ));
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(50,40,300, 300);
			table.setFillsViewportHeight(false);
			
			final DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			
			for (Vaga item : vs) {
				tableModel.addRow(new Object[]{
						item.getId(),
						item.getNome(),
						item.getDescricao(),
						item.getEmpresa(),
						item.getMaskedSalario(),
						item.getStatusFormatado()
						
				});
			  
			}
			
			JLabel searchLabel = new JLabel("Código: ");
			final JTextField searchInput = new JTextField();
			
			searchLabel.setBounds(153,340,100, 40);
			searchInput.setBounds(150,370,100, 40);
			
			scrollPane.setViewportView(table);
			j.add(scrollPane);
			j.add(searchLabel);
			j.add(searchInput);
			
			JButton btn1 = new JButton();
			JButton btn2 = new JButton();
			JButton btn3 = new JButton();
			JButton btn4 = new JButton();
			
			btn1.setText("Pesquisar");
			btn2.setText("Editar");
			btn3.setText("Voltar");
			btn4.setText("Excluir");
			
			btn1.setBounds(50,370,100, 40);
			btn2.setBounds(250,370,100, 40);
			btn3.setBounds(70,420,100, 40);
			btn4.setBounds(230,420,100, 40);
			
			btn1.setBackground(Color.decode("#29b5e8"));
			btn2.setBackground(Color.decode("#2dc07c"));
			btn4.setBackground(Color.decode("#c02d2e"));
			btn3.setBackground(Color.decode("#fafafa"));
			btn1.setOpaque(true);
			btn2.setOpaque(true);
			btn3.setOpaque(true);
			btn4.setOpaque(true);
			
			btn1.setBorderPainted(false);
			btn2.setBorderPainted(false);
			btn3.setBorderPainted(false);
			btn4.setBorderPainted(false);
			
			j.add(btn1);
			j.add(btn2);
			j.add(btn3);
			j.add(btn4);
			
			btn1.addActionListener(new java.awt.event.ActionListener() {
		        public void actionPerformed(java.awt.event.ActionEvent evt) {
		        	searchOne(evt, tableModel, searchInput);
		        }
		    });
			
			btn2.addActionListener(new java.awt.event.ActionListener() {
		        public void actionPerformed(java.awt.event.ActionEvent evt) {
		        	formEvt(evt, searchInput.getText(), j);
		        }
		    });
			
			btn4.addActionListener(new java.awt.event.ActionListener() {
		        public void actionPerformed(java.awt.event.ActionEvent evt) {
		        	deleteEvt(evt, tableModel, searchInput);
		        }
		    });
			
			btn3.addActionListener(new java.awt.event.ActionListener() {
		        public void actionPerformed(java.awt.event.ActionEvent evt) {
		        	back(evt, f, j);
		        }
		    });
			
			System.out.println(vs.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
  
  }
  
  private static void back(java.awt.event.ActionEvent evt, JFrame f, JFrame j) {//GEN-FIRST:event_back
	  System.out.println("back.to.main");
	  f.setVisible(true);
	  j.setVisible(false);
  }
  
  private static void searchOne(java.awt.event.ActionEvent evt, DefaultTableModel t, JTextField input) {//GEN-FIRST:event_searchOne
	  t.setRowCount(0);
	  VagaDAO VagaDAO = objetoDAO.getDAO(VagaDAO.class);
	  String valor = input.getText();
	  try {
		if(valor.isEmpty()) {
			List<Vaga> vs = VagaDAO.findAll();
			for (Vaga item : vs) {
				t.addRow(new Object[]{
						item.getId(),
						item.getNome(),
						item.getDescricao(),
						item.getEmpresa(),
						item.getMaskedSalario(),
						item.getStatusFormatado()
						
				});
			  
			}
		} else {
			Vaga item = VagaDAO.findByPk(Integer.parseInt(valor));
			t.addRow(new Object[]{
					item.getId(),
					item.getNome(),
					item.getDescricao(),
					item.getEmpresa(),
					item.getMaskedSalario(),
					item.getStatusFormatado()
					
			});
		}
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  private static void deleteEvt(java.awt.event.ActionEvent evt, DefaultTableModel t, JTextField input) {//GEN-FIRST:event_deleteEvt
	  t.setRowCount(0);
	  VagaDAO VagaDAO = objetoDAO.getDAO(VagaDAO.class);
	  String valor = input.getText();
	  try {
		VagaDAO.delete(Integer.parseInt(valor));
		List<Vaga> vs = VagaDAO.findAll();
		for (Vaga item : vs) {
			t.addRow(new Object[]{
					item.getId(),
					item.getNome(),
					item.getDescricao(),
					item.getEmpresa(),
					item.getMaskedSalario(),
					item.getStatusFormatado()
					
			});
		}
	} catch (NumberFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  private static void formEvt(java.awt.event.ActionEvent evt, String value, final JFrame f) {//GEN-FIRST:event_formEvt
	  	final JFrame j=new JFrame();//creating instance of JFrame
	  	f.setVisible(false);
	  	
	  	j.setSize(400,500);
	  	j.setLocationRelativeTo(null);
	    j.setLayout(null);
	  	j.setVisible(true);
	  	j.setResizable(false);
	  	
	  	VagaDAO VagaDAO = objetoDAO.getDAO(VagaDAO.class);
	  	JLabel l1 = new JLabel();
	  	JLabel l2 = new JLabel();
	  	JLabel l3 = new JLabel();
	  	JLabel l4 = new JLabel();
	  	
	  	l1.setText("Nome");
	  	l2.setText("Descrição");
	  	l3.setText("Empresa");
	  	l4.setText("Salário");
	  	
	  	final JTextField t1 = new JTextField();
	  	final JTextField t2 = new JTextField();
	  	final JTextField t3 = new JTextField();
	  	final JTextField t4 = new JTextField();
	  	
	  	JButton b1 = new JButton();
	  	
	  	l1.setBounds(180, 50, 100, 40);
	  	l2.setBounds(165, 120, 100, 40);
	  	l3.setBounds(170, 190, 100, 40);
	  	l4.setBounds(180, 260, 100, 40);

	  	
	  	t1.setBounds(150, 90, 100, 40);
	  	t2.setBounds(150, 160, 100, 40);
	  	t3.setBounds(150, 230, 100, 40);
	  	t4.setBounds(150, 300, 100, 40);

	  	
	  	b1.setText("Salvar");
	  	b1.setBackground(Color.decode("#2dc07c"));
	  	b1.setBounds(150, 350, 100, 40);
	  	b1.setOpaque(true);
	  	b1.setBorderPainted(false);
	  	
	  	j.add(l1);
	  	j.add(t1);
	  	j.add(l2);
	  	j.add(t2);
	  	j.add(l3);
	  	j.add(t3);
	  	j.add(l4);
	  	j.add(t4);
	  	j.add(b1);
	  	
	  	 boolean updating = false;
	  	 Vaga v = new Vaga();
	  	
	  	if(value != null) {
	  		updating = true;
	  		try {
				v = VagaDAO.findByPk(Integer.parseInt(value));
				t1.setText(v.getNome());
				t2.setText(v.getDescricao());
				t3.setText(v.getEmpresa());
				t4.setText(Float.toString(v.getSalario()));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  	}
	  	
	  	final boolean updt = updating;
	  	final Vaga finalV = v;
	  	
	  	b1.addActionListener(new java.awt.event.ActionListener() {
	        public void actionPerformed(java.awt.event.ActionEvent evt) {
	        	saveOrUpdate(evt, f, j, finalV, t1, t2, t3, t4, updt);
	        }
	    });
	  	
  
  }
  
  private static void saveOrUpdate(java.awt.event.ActionEvent evt, JFrame j,  JFrame jj, Vaga v, JTextField t1, JTextField t2, JTextField t3, JTextField t4, boolean updating) {//GEN-FIRST:saveOrUpdate
	  VagaDAO VagaDAO = objetoDAO.getDAO(VagaDAO.class);
	  j.setVisible(false);
	  
	  if(updating) {
		  try {
		  	v.setNome(t1.getText());
		  	v.setDescricao(t2.getText());
		  	v.setEmpresa(t3.getText());
	  		float salario = Float.parseFloat(t4.getText());
	  		v.setSalario(salario);
		  		
			VagaDAO.update(v);
			j.setVisible(true);
	  		jj.setVisible(false);
	  		final JLabel l = new JLabel();
	  		l.setText("Editado com sucesso!");
	  		l.setForeground(Color.blue);
	  		l.setBounds(140, 0, 200, 40);
	  		j.add(l);
	  		eventoLista(evt, j);
			new java.util.Timer().schedule( 
			        new java.util.TimerTask() {
			            @Override
			            public void run() {
			               l.setVisible(false);
			            }
			        }, 
			        3000 
			);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  } else {
		  try {
			  	Vaga newV = new Vaga();
			  	newV.setNome(t1.getText());
			  	newV.setDescricao(t2.getText());
			  	newV.setEmpresa(t3.getText());
		  		float salario = Float.parseFloat(t4.getText());
		  		newV.setSalario(salario);
		  		
		  		j.setVisible(true);
		  		jj.setVisible(false);
		  		final JLabel l = new JLabel();
		  		l.setText("Salvo com sucesso!");
		  		l.setForeground(Color.green);
		  		l.setBounds(140, 0, 200, 40);
		  		j.add(l);
				VagaDAO.save(newV);
				new java.util.Timer().schedule( 
				        new java.util.TimerTask() {
				            @Override
				            public void run() {
				               l.setVisible(false);
				            }
				        }, 
				        3000 
				);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	 
  }
  
}  