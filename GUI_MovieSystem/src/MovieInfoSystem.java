import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.util.Vector;
import java.util.function.Consumer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;
// import ����
public class MovieInfoSystem  extends JFrame  implements ActionListener, ListSelectionListener, ItemListener
{
	JPanel panelInput, panelList,panelInfo;				
	JFileChooser fc; 
	//------------------------------------------------------------------------------
	private JMenuBar mb;						//�޴���
	private JMenu mFile, mHelp;					//�޴�
	JMenuItem miOpen, miSave, miInfo;			// �޴�������
	JPanel subPInput [], subPList[], subPInfo[], holder[];	//���̾ƿ� ������ ���� panel��
	
	//panelInput�� ���� ������-------------------------------------------------------------	
	JTextField tfTitle, tfDirector, tfCast,tfHour,tfMin,tfPoster;	//�� �ʵ忡 ���� ����
	JFormattedTextField tfDate; 									//���˶����� ���
	ImageIcon iPoster;												//�����͸� ǥ���ϱ� ���ؼ� ���
	JButton bttnCall,bttnAdd,bttnCancel;							//�ҷ����� , �߰� , ���
	JRadioButton rbAge[]; 											//�������� ������ư
	JComboBox gCombo;												//�帣 ���� �޺��ڽ� 
	JTextArea taSynop,taOpinion; 									//�ó�ý� , ������
	JScrollPane synScroll,opiScroll;								//�ó�ý�, ������ ���� ��ũ��
	//panelList�� ���� ������----------------------------------------------------------------
	JComboBox sCombo;												//�˻� ��� �޺��ڽ�
	JTextField tfSearch; 											//�˻�â �ؽ�Ʈ �ʵ�
	JButton bttnSearch,bttnFix , bttnDel; 							//�˻�, ����, ���� ��ư
	JList sList; 													//����� ��� ����Ʈ
	DefaultListModel sModel ;										//����Ʈ��  Default��
	JScrollPane scroll;												//����Ʈ�� �� ��ũ��
	//panelInfo�� ���� ������----------------------------------------------------------------
	JLabel poster;													//������ �� ��
	JTextArea taDetail;												//�󼼳���
	JScrollPane scroll2;											//�󼼳��� ��ũ��
	//------------------------------------------------------------------------------
	private Vector<Movie> collection; 					//db
	Movie m,tmp; 		int index; 		String tag; 		//colletion�� �ӽ� ������				
	// 	GUI ������Ʈ�� ���� ��� ������ ����

	public MovieInfoSystem() throws Exception{
		setTitle("��ȭ ���� �ý���");
		setSize(980, 680);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);
		setResizable(false);
//-----------------------------------------------------------------------------------------		
			
		collection = new Vector<Movie>(); 				// collection �� �����ϴ�. 
		fc = new JFileChooser();		 				//������ �ޱ� ���� ���
		//------------------------------------------------------------------------------
		// ����� ȭ�鿡 ������Ʈ�� �����Ͽ� ��ġ
		// �� ������Ʈ ������ �ʿ��� ������ ���
		//------------------------------------------------------------------------------		
		mb = new JMenuBar();							//�޴���
		mFile= new JMenu("����");						//�޴�
		mHelp = new JMenu("����");
		mb.add(mFile);  mb.add(mHelp); 
		
		miOpen = new JMenuItem("�ҷ�����");				//�޴� ������
		miOpen.addActionListener(this);
		miSave = new JMenuItem("�����ϱ�");
		miSave.addActionListener(this);
		miInfo = new JMenuItem("����");
		miInfo.addActionListener(this);
		
		mFile.add(miOpen);								//��� : �޴� ������->�޴�
		mFile.add(miSave);
		mHelp.add(miInfo);
		this.setJMenuBar(mb);							//�޴���->������
//-----------------------------------------------------------------------------------------
		JPanel top = new JPanel();						//������ ���� ������
		add(top,"North");										
		top.add(new JLabel("<<��ȭ�����ý���>>"),"Center");	//�߾ӿ� ������
//-----------------------------------------------------------------------------------------
		panelInput=new JPanel();						//�Է��ǳ�
		panelInput.setLayout(new BorderLayout());		//��ġ ����
		Border inputBorder = BorderFactory.createTitledBorder("��ȭ���� �Է�");
		panelInput.setBorder(inputBorder);
		panelInput.setPreferredSize(new Dimension(300,400));
		
		// panelInput�� ũ�� 3����Ѵ� : west,center,south
		holder = new JPanel[3]; 
		for(int i=0;i<3;i++) {
			holder[i]= new JPanel();
			holder[i].setLayout(new BoxLayout(holder[i],BoxLayout.Y_AXIS));
			}
		panelInput.add(holder[0],BorderLayout.LINE_START);//��ġ
		panelInput.add(holder[1],BorderLayout.CENTER);
		panelInput.add(holder[2],BorderLayout.SOUTH);
	
		subPInput = new JPanel [19]; 					//�� �پ� �����Ѵ�.
		for(int i=0;i<8;i++){ 
			subPInput[i+11]= new JPanel();
			subPInput[i]= new JPanel();
			holder[1].add(subPInput[i]);				// CENTER �ǳڿ� ���δ�.
			holder[0].add(subPInput[i+11]);				// WEST �ǳڿ� ���δ�.
		}

		for(int i=8;i<11;i++){
			subPInput[i]= new JPanel();
			holder[2].add(subPInput[i]);				// SOUTH �ǳڿ� ���δ�.
		}
		
		tfTitle = new JTextField(20);					//����
		tfTitle.addActionListener(this);
		subPInput [0].add(tfTitle);						//CENTER�� ���δ�.
		subPInput [11].add(new JLabel("����"));			// WEST �ǳڿ� ���δ�.
	
		tfDirector = new JTextField(20);				//����
		tfDirector.addActionListener(this);
		subPInput [1].add(tfDirector);					//CENTER�� ���δ�.
		subPInput [12].add(new JLabel("����"));			// WEST �ǳڿ� ���δ�.
		
		tfCast = new JTextField(20);					//���
		tfCast.addActionListener(this);
		subPInput [2].add(tfCast);						//CENTER�� ���δ�.
		subPInput [13].add(new JLabel("��� "));			// WEST �ǳڿ� ���δ�.
		
		String[] genre = {"�׼�","�ڹ̵�","����","���","�̽��͸�","����","SF"};
		gCombo = new JComboBox(genre);					//�帣
		gCombo.setPreferredSize(new Dimension(227,20));	//���� ������
		subPInput[3].add(gCombo);						//CENTER�� ���δ�.
		subPInput[14].add(new JLabel("�帣"));			// WEST �ǳڿ� ���δ�.
		
		MaskFormatter mf = new MaskFormatter("####.##.##");	//������ �����
		mf.setPlaceholderCharacter('_');				//������ _
		tfDate=new JFormattedTextField(mf);				//������ ���δ�.			
		tfDate.addActionListener(this);
		tfDate.setPreferredSize(new Dimension(227,20));	//���� ������ ����
		subPInput[4].add(tfDate);						//CENTER�� ���δ�.
		subPInput[15].add(new JLabel("������"));			// WEST �ǳڿ� ���δ�.
					
		rbAge = new JRadioButton[4];					//���� ��� : ���� ��ư
		ButtonGroup bg = new ButtonGroup();				//������ư �׷���
		String sAge [] ={"��ü","12��", "15��","û��"};
		rbAge[0]=new JRadioButton(sAge[0],true);  		//"��ü"�� �ʱ�ȭ�Ѵ�.
		bg.add(rbAge[0]);
		subPInput[5].add(rbAge[0]);
		for(int i=1;i<4;i++){
			rbAge[i]=new JRadioButton(sAge[i]);			//����
			bg.add(rbAge[i]);							//�׷쿡 �ִ´�.
			subPInput[5].add(rbAge[i]);					//CENTER�� ���δ�.
		}
		Border hBorder = BorderFactory.createLineBorder(Color.gray); //���
		subPInput[5].setBorder(hBorder);				//��踦 �����
		subPInput[16].add(new JLabel("��ü���"));		// WEST �ǳڿ� ���δ�.			
		
		subPInput[6].setBorder(hBorder);				//��踦 �����.
		tfHour = new JTextField(5);						//�ð�
		tfHour.addActionListener(this);
		subPInput[6].add(tfHour);					
		subPInput[6].add(new JLabel("�ð�"));
		tfMin = new JTextField(5);						//��
		tfMin.addActionListener(this);
		subPInput[6].add(tfMin);
		subPInput[6].add(new JLabel("��"));				
		subPInput[17].add(new JLabel("�󿵽ð�"));		// WEST �ǳڿ� ���δ�.
		
		tfPoster = new JTextField(11);					//������ ���
		tfPoster.setEditable(false);					//��ΰ���� ������ ,��ĥ�� X	
		bttnCall = new JButton("�ҷ�����");
		bttnCall.addActionListener(this);
		subPInput[7].add(tfPoster);						//CENTER�� ���δ�.			
		subPInput[7].add(bttnCall); 					//CENTER�� ���δ�.
		subPInput[18].add(new JLabel("������")); 			//WEST�ǳڿ� ���δ�.
		
		Border synBorder = BorderFactory.createTitledBorder("�ó�ý�"); 	     
		subPInput[8].setBorder(synBorder);		
		taSynop  = new JTextArea(4,25);					//�ó�ý� ĭ	
		synScroll = new JScrollPane(taSynop);	
		subPInput[8].add(synScroll); 					// CENTER�� ���δ�.			
		
		Border opiBorder = BorderFactory.createTitledBorder("������");		
		subPInput[9].setBorder(opiBorder);
		taOpinion = new JTextArea(4,25);				//������ ĭ
		opiScroll = new JScrollPane(taOpinion);				
		subPInput[9].add(opiScroll); 					// CENTER�� ���δ�.	
		
		//�߰� ��� ��ư�� CENTER�� �Բ� ���δ�.
		bttnAdd = new JButton("�߰�");			bttnCancel= new JButton("���");
		bttnAdd.addActionListener(this);		bttnCancel.addActionListener(this);
		subPInput [10].add(bttnAdd);			subPInput [10].add(bttnCancel);
		
		add(panelInput,BorderLayout.LINE_START);

//-----------------------------------------------------------------------------------------		
		panelList =new JPanel();						//����Ʈ �ǳ�
		subPList = new JPanel[3];						//3���
		for(int i=0;i<3;i++)
			panelList.add(subPList[i]= new JPanel());	
		
		Border SearchBorder = BorderFactory.createTitledBorder("��ȭ ���� �˻�");
		subPList[0].setBorder(SearchBorder);													
		String[] searchModel = {"��ü","����","����","�帣"};//�˻��� panel
		sCombo = new JComboBox(searchModel);
		subPList[0].add(sCombo);
		tfSearch = new JTextField(20);
		subPList[0].add(tfSearch);
		bttnSearch = new JButton("�˻�");
		bttnSearch.addActionListener(this);
		subPList[0].add(bttnSearch);
		
		Border ListBorder = BorderFactory.createTitledBorder("��ȭ ���");
		subPList[1].setBorder(ListBorder);							
		sModel = new DefaultListModel();				//��� panel
		sList = new JList(sModel);
		scroll= new JScrollPane(sList);					//��ũ��
		scroll.setPreferredSize(new Dimension(370,440));		
		sList.addListSelectionListener(this);
		sList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		subPList[1].add(scroll);
		//��ư panel	����   ����  ��ư													
		bttnFix = new JButton("����");  	 bttnDel = new JButton("����");
		bttnFix.addActionListener(this); bttnDel.addActionListener(this);
		subPList[2].add(bttnFix); 		 subPList[2].add(bttnDel);
		add(panelList,BorderLayout.CENTER);
//-----------------------------------------------------------------------------------------
		panelInfo = new JPanel();						//���ĳ�
		panelInfo.setLayout(new GridLayout(2,1));		//�̵��
		add(panelInfo,BorderLayout.LINE_END);	 
		subPInfo = new JPanel[2];
		panelInfo.add(subPInfo[0]= new JPanel());
		panelInfo.add(subPInfo[1]= new JPanel());
		Border infoBorder = BorderFactory.createTitledBorder("��ȭ ����");
		panelInfo.setBorder(infoBorder);
		// photo Panel
		poster = new JLabel();							//������ ĭ
		poster.setIcon(null);							//�ʱ�ȭ
		poster.setText("");	
		subPInfo[0].add(poster);
		panelInfo.setPreferredSize(new Dimension(300,200));
		// ������  ��� panel
		taDetail = new JTextArea(14,24);				//����ĭ
		taDetail.setEditable(false);					//����ڰ� �Է� ���Ѵ�.
		scroll2 = new JScrollPane(taDetail,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		subPInfo[1].add(scroll2);
		
	}
	
	//------------------------------------------------------------------------------
	// ������ �������̽��� ���� �� �޼ҵ� ����
	// � �̺�Ʈ�� �߻��ߴ����� ���� ������ ����� �����Ѵ�.
	//------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();	
		if(source == miOpen){ 								//���� ���� ���� OPEN
			int rv = fc.showOpenDialog(this);				//��ư ���� ��ȯ �޴´�
			if(rv==JFileChooser.APPROVE_OPTION){			//"����"
				File file = fc.getSelectedFile();
				ObjectInputStream ois;
				collection.clear();							//db�� ����.
				sModel.clear();								//����Ʈ�� ����.
				try{ 							
					ois= new ObjectInputStream(new FileInputStream(file));
					while((tmp=(Movie)ois.readObject())!=null){//���� �̳����� �ʾҴٸ�
						collection.add(tmp);				// collection�� ����
						sModel.addElement(tmp.title);		//����Ʈ���� �̸� �־��ش�.
						}
					sList.setSelectedIndex(0);				//����Ʈ�� �ε����� 0����
					ois.close();							//�ݴ´�
				}
				catch(EOFException eof){}					//���� ó��
				catch(IOException | ClassNotFoundException e1){
					e1.printStackTrace();
				}
			}
		}
		else if(source == miSave){							//���� ���� ���̺� SAVE
			int rv = fc.showSaveDialog(this);				//������ ��ư �� ��ȯ
			if(rv==JFileChooser.APPROVE_OPTION){			//"����"
				File file = fc.getSelectedFile();			//������ ����
				ObjectOutputStream oos;
				try{ 
					oos= new ObjectOutputStream(new FileOutputStream(file));
					for(int i=0;i<collection.size();i++)
						oos.writeObject((Movie)collection.get(i)); //db�� �ִ� �� ����
					oos.close();
					}
				catch(IOException e1){							//����ó��
					e1.printStackTrace();
				}
			}
		}
		else if(e.getSource() == miInfo){
			//�ý��� ���� ���̾�α׸� ȭ�鿡 ����.
			JOptionPane.showMessageDialog(miInfo,"��ȭ���� �ý���  v1.0�Դϴ�");
		}
		else if(source ==bttnAdd){ 					//panelInput�� "�߰�"�� "�����Ϸ�" ��ư ó��
			if(e.getActionCommand()=="�߰�"){	 	// bttnAdd�� �ؽ�Ʈ�� "�߰�"�� �ٲ�� ����
				//����� �Է����κ��� ���� ���� �о�ͼ� ��Ͽ� �߰� 
				//���ÿ� collection���� Movie ��ü �����ؼ� �߰� 
				String title; 					String director;	 String cast; 
				String genre; 					String releaseDate;  String reviews;
				String grade;int runtime; 		String photo; 		 String synopsis;
			try{	 
				//���� ����� �ԷµǾ�����
				title=tfTitle.getText();		director=tfDirector.getText();
				cast = tfCast.getText();	
				
				releaseDate=tfDate.getText();
				synopsis=taSynop.getText();		photo=tfPoster.getText();
				reviews=taOpinion.getText();
				genre= (String) gCombo.getSelectedItem(); 
				runtime=(Integer.parseInt(tfHour.getText())*60 + Integer.parseInt(tfMin.getText()));

				if(rbAge[0].isSelected())		//���õ� ������ư ���� ����
						grade = "��ü";
				else if(rbAge[1].isSelected())
						grade = "12��";
				else if(rbAge[2].isSelected())
						grade = "15��";
				else 
						grade = "û��";
			
				sModel.addElement(title);
				Movie m = new Movie(title,  director,  cast,  genre, releaseDate, 
						grade,runtime, photo, synopsis, reviews);
				collection.addElement(m);  				//db�� ������ m�� �߰��Ѵ�
											
			}catch (Exception ex){ // �Է°��� �ùٸ��� �ʴٸ�
				JOptionPane.showMessageDialog(null,"�ùٸ� �Է��� �ƴմϴ�.");
			}
			//panelInput �ؽ�Ʈ �ʵ� �ʱ�ȭ
				tfDirector.setText(""); 	tfCast.setText("");
				tfHour.setText("");			tfMin.setText("");
				tfPoster.setText("");		tfTitle.setText(""); 
				taSynop.setText("");		taOpinion.setText("");
				tfDate.setText("");
				rbAge[0].setSelected(true);
				for(int i=1;i<4;i++) 
					rbAge[1].setSelected(false);
				gCombo.setSelectedIndex(0);
				}
			
			if(e.getActionCommand()=="�����Ϸ�"){ 	
				// bttnAdd�� �ؽ�Ʈ�� "�����Ϸ�"	
				// ����ڰ� �ٲ� ������ �ٽ� m�� ������ �Ŀ� db�� �����Ѵ�.
				m.title=tfTitle.getText();		m.director=tfDirector.getText();
				m.cast = tfCast.getText(); 		m.photo=tfPoster.getText();
				m.genre= (String) gCombo.getSelectedItem();
				m.releaseDate=tfDate.getText();	m.reviews=taOpinion.getText(); 	
				m.synopsis=taSynop.getText();
				if(rbAge[0].isSelected())
						m.grade = "��ü";
				else if(rbAge[1].isSelected())
						m.grade = "12��";
				else if(rbAge[2].isSelected())
						m.grade = "15��";
				else 
					m.grade = "û��";
			
				sModel.setElementAt(m.title,index); 	 //������  ��� ����Ʈ ������Ʈ
				collection.setElementAt(m, index);  	 // ������ db ����Ʈ ������Ʈ
				taDetail.setText(m.toString()); 		 // �� ���ϵ� ������Ʈ
				bttnAdd.setText("�߰�");					 // ��ư�� �ٽ� "�߰�"������ �ٲ۴�.
			
				//�ؽ�Ʈ �ʵ� �� ��ư���� �ʱ�ȭ�Ѵ�
				tfDirector.setText(""); 	tfCast.setText("");
				tfHour.setText("");			tfMin.setText("");
				tfPoster.setText("");		tfTitle.setText(""); 
				taSynop.setText("");		taOpinion.setText("");
				tfDate.setText("");
				rbAge[0].setSelected(true); 			// ù��° ������ư�� �Ѱ�, 
				for(int i=1;i<4;i++) rbAge[1].setSelected(false); //�������� ���д�.
				gCombo.setSelectedIndex(0);
				}
			}
			else if(source ==bttnCall){ 						// "�ҷ�����" ��ư�� ��������
				int returnVal = fc.showOpenDialog(this);	 	//���̾�α��� ����, ���� ��ư ���� �޴´�
				if(returnVal== JFileChooser.APPROVE_OPTION){	// ���� "Ȯ��" �������� 
					File poster = fc.getSelectedFile(); 		// ������ ���� ���� ���� ��ü�� �����
					tfPoster.setText(poster.getPath()); 		// �ؽ�Ʈ �ʵ忡 ��θ� �����ش�.
					iPoster=new ImageIcon(tfPoster.getText());  // ��θ� ����� ���̹̾������� �����. 
					}
				}
			else if(source == bttnCancel){ 
					// "���" ��ư�� ������ ��, �� ��ư��� �ؽ�Ʈ �ʵ���� �ʱ�ȭ�Ѵ�.
				tfDirector.setText(""); tfCast.setText("");
				tfHour.setText("");		tfMin.setText("");
				tfPoster.setText("");	tfTitle.setText(""); 
				taSynop.setText("");	taOpinion.setText("");
				tfDate.setText("");
				rbAge[0].setSelected(true);
				for(int i=1;i<4;i++) 
					rbAge[1].setSelected(false);
				if(rbAge[0].isSelected()) 
					rbAge[0].setSelected(false); 
				else if(rbAge[1].isSelected())
					rbAge[1].setSelected(false);
				else if(rbAge[2].isSelected())
					rbAge[2].setSelected(false);
				else 
					rbAge[3].setSelected(false);
				gCombo.setSelectedIndex(0);
				}
			else if(source == bttnFix){ 
				if(sModel.size()!=0){ // ����� ����� ���� ���� ��쿡 
				//"����"��ư�� ��������,  bttnAdd�� �ؽ�Ʈ�� "�����Ϸ�"�� �ٲٰ�
				bttnAdd.setText("�����Ϸ�"); 
				m=collection.get(index);  
					//db���� ���� ���� �ٽ� ȭ�鿡 ��� ���༭ ����ڰ� ��ĥ�� �ְ� ����
					// �Ʒ��� panelInput�� m�� ���� �������� ����� ����ڷ� �Ͽ��� ��ĥ �� �ְ� �Ѵ�. 
				tfTitle.setText(m.title);          tfDirector.setText(m.director); 
				tfCast.setText(m.cast);            tfHour.setText(""+(m.runtime/60)); 
				tfMin.setText(""+(m.runtime%60));  tfPoster.setText(m.photo);
				tfDate.setText(m.releaseDate);     gCombo.setSelectedItem(m.genre);
				taSynop.setText(m.synopsis);       taOpinion.setText(m.reviews);
				if(m.grade.equals("��ü"))
					{rbAge[0].setSelected(true);}
				else if(m.grade.equals("12��"))
					{rbAge[1].setSelected(true);}
				else if(m.grade.equals("15��"))
					{rbAge[2].setSelected(true);}
				else 
					{rbAge[3].setSelected(true);}
				}
			}
			else if(source == bttnSearch){						//"�˻� "��ư�� ������ ��
				String search =tfSearch.getText(); 				//ã�� �ܾ�
				String type = (String)sCombo.getSelectedItem(); // �˻� ���
				if(!search.equals("")){  						//ã�� �ܾ ���� ���
					sModel.clear(); 							//�ѹ� �߾� ����Ʈ�� ���� ���ְ�
					if(type.equals("����")){   		  	   	    //��尡 "����"�� ���
						for(Movie temp:collection){				//db ��ü�� ���鼭�˻���� ��ġ�Ѵٸ�  sList�� �߰�
							if(temp.title.equals(search))
								sModel.addElement(temp.title); 
						}
					}
					else if(type.equals("����")){ 				//��尡 "����"�� ���
						for(Movie temp:collection){  			//���� ����
							if(temp.director.equals(search))	// sList�� �߰�
								sModel.addElement(temp.title);
						}
					}
					else if(type.equals("�帣")){				//��尡 "�帣"�� ���
						for(Movie temp:collection){				//���� ����
							if(temp.genre.equals(search))		// sList�� �߰�
								sModel.addElement(temp.title);
						}
					}
					else{ 	//��尡 "��ü"�� ���, �ϳ��� ������ ����Ʈ �߰��Ѵ�.
						for(Movie temp:collection){		
							if(temp.title.equals(search)||temp.director.equals(search)||temp.genre.equals(search))// sList�� �߰�
								sModel.addElement(temp.title);
							}
						}		
					}
				else{  							   // �ʵ忡 �ƹ��͵� ���� "�˻�"�� ��������
					sModel.clear();				   //�ϴ� ���� ����Ʈ�� �ѹ� ġ���
					for(Movie temp:collection)     //db�� �ִ� ��� �����͸� ����Ʈ�Ѵ�.
						sModel.addElement(temp.title);
					}	
			}//(source == bttnSearch){}�ݱ�
			else if(source == bttnDel){				//"����"��ưList���� ����� collection������ ������ �Ѵ�.
				if(sModel.size()!=0){
				if(index!=-1){ 						// ���ؽ��� -1�� �ƴ� ������ 
					collection.remove(index); 		//db���� ���õ� �׸��� �����,
					sModel.removeElement(tag);		// ����Ʈ �ǳڿ����� �����.
					poster.setIcon(null); 			//�����Ͷ��� �ʱ�ȭ�ϰ�
					taDetail.setText("");			// �󼼼��� �ʱ�ȭ�Ѵ�.
					sList.setSelectedIndex(collection.size()-1); 		// ����Ʈ �ǳ��� �����ε����� 0���� �ʱ�ȭ�Ѵ�.
				}
				}
			}
		
	}
//------------------------------------------------------------------------------
	public int getIndex(String title){ //������ ������ db���� �ε����� ã�Ƽ� �����ش�.
		int i;
		try{
			for(i=0;i<collection.size();i++){
				if(title.equals(collection.get(i).title))//Ÿ��Ʋ�� ������
					break;
			}
		}catch(NullPointerException npe){ 				// ����
			i = -1;
		}
		if(i==collection.size()) i=-1;			//���� ���� ���� -1�� �Ҵ��Ѵ�.
		return i; // ������
	}
//------------------------------------------------------------------------------
//���õ� �ε����� �ش�Ǵ� ��ȭ ������ textArea ���� ����Ѵ�.
//------------------------------------------------------------------------------
	public void valueChanged(ListSelectionEvent event){
		tag=(String)sList.getSelectedValue(); //����Ʈ �ǳڿ��� ���õ� ��ȭ ����
		index=getIndex(tag);				
		
		if (index !=-1){
			m = collection.get(index); 				// ���õ� ��ȭ�� db���� ����´�.
			ImageIcon temp=new ImageIcon(m.photo);	//�������̹����� ��θ� ���ؼ� �����
			poster.setIcon(temp); 					//��ȭ�����͸� ȭ�鿡 ����.
			taDetail.setText(m.toString());			// �󼼼��� ����.
		}
	}	
	//------------------------------------------------------------------------------
	//������ �޺��ڽ����� �����ϸ� �ش� ���� ȭ�鿡 ǥ�� (�� �ص� �ȴٰ� �ϼ̴�)
	//------------------------------------------------------------------------------
	public void itemStateChanged(ItemEvent e) { 
		// TODO Auto-generated method stub	
	}

	public static void main(String[] args) throws Exception {
		 new MovieInfoSystem();
	}
}