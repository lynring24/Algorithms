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
// import 파일
public class MovieInfoSystem  extends JFrame  implements ActionListener, ListSelectionListener, ItemListener
{
	JPanel panelInput, panelList,panelInfo;				
	JFileChooser fc; 
	//------------------------------------------------------------------------------
	private JMenuBar mb;						//메뉴바
	private JMenu mFile, mHelp;					//메뉴
	JMenuItem miOpen, miSave, miInfo;			// 메뉴아이템
	JPanel subPInput [], subPList[], subPInfo[], holder[];	//레이아웃 때문에 만든 panel들
	
	//panelInput에 들어가는 변수들-------------------------------------------------------------	
	JTextField tfTitle, tfDirector, tfCast,tfHour,tfMin,tfPoster;	//각 필드에 들어가는 값들
	JFormattedTextField tfDate; 									//포맷때문에 사용
	ImageIcon iPoster;												//포스터를 표시하기 위해서 사용
	JButton bttnCall,bttnAdd,bttnCancel;							//불러오기 , 추가 , 취소
	JRadioButton rbAge[]; 											//관람나이 라디오버튼
	JComboBox gCombo;												//장르 선택 콤보박스 
	JTextArea taSynop,taOpinion; 									//시놉시스 , 감상평
	JScrollPane synScroll,opiScroll;								//시놉시스, 감상평에 박을 스크롤
	//panelList에 들어가는 변수들----------------------------------------------------------------
	JComboBox sCombo;												//검색 모드 콤보박스
	JTextField tfSearch; 											//검색창 텍스트 필드
	JButton bttnSearch,bttnFix , bttnDel; 							//검색, 수정, 삭제 버튼
	JList sList; 													//목록의 띄울 리스트
	DefaultListModel sModel ;										//리스트의  Default모델
	JScrollPane scroll;												//리스트에 들어갈 스크롤
	//panelInfo에 들어가는 변수들----------------------------------------------------------------
	JLabel poster;													//포스터 용 라벨
	JTextArea taDetail;												//상세내역
	JScrollPane scroll2;											//상세내역 스크롤
	//------------------------------------------------------------------------------
	private Vector<Movie> collection; 					//db
	Movie m,tmp; 		int index; 		String tag; 		//colletion용 임시 변수들				
	// 	GUI 컴포넌트를 위한 멤버 변수들 선언

	public MovieInfoSystem() throws Exception{
		setTitle("영화 정보 시스템");
		setSize(980, 680);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setVisible(true);
		setResizable(false);
//-----------------------------------------------------------------------------------------		
			
		collection = new Vector<Movie>(); 				// collection 을 생성하다. 
		fc = new JFileChooser();		 				//파일을 받기 위해 사용
		//------------------------------------------------------------------------------
		// 사용자 화면에 컴포넌트들 구성하여 배치
		// 각 컴포넌트 구성시 필요한 리스너 등록
		//------------------------------------------------------------------------------		
		mb = new JMenuBar();							//메뉴바
		mFile= new JMenu("파일");						//메뉴
		mHelp = new JMenu("도움말");
		mb.add(mFile);  mb.add(mHelp); 
		
		miOpen = new JMenuItem("불러오기");				//메뉴 아이템
		miOpen.addActionListener(this);
		miSave = new JMenuItem("저장하기");
		miSave.addActionListener(this);
		miInfo = new JMenuItem("정보");
		miInfo.addActionListener(this);
		
		mFile.add(miOpen);								//등록 : 메뉴 아이템->메뉴
		mFile.add(miSave);
		mHelp.add(miInfo);
		this.setJMenuBar(mb);							//메뉴바->프레임
//-----------------------------------------------------------------------------------------
		JPanel top = new JPanel();						//제목을 위한 프레임
		add(top,"North");										
		top.add(new JLabel("<<영화관리시스템>>"),"Center");	//중앙에 오도록
//-----------------------------------------------------------------------------------------
		panelInput=new JPanel();						//입력판넬
		panelInput.setLayout(new BorderLayout());		//배치 설정
		Border inputBorder = BorderFactory.createTitledBorder("영화정보 입력");
		panelInput.setBorder(inputBorder);
		panelInput.setPreferredSize(new Dimension(300,400));
		
		// panelInput을 크게 3등분한다 : west,center,south
		holder = new JPanel[3]; 
		for(int i=0;i<3;i++) {
			holder[i]= new JPanel();
			holder[i].setLayout(new BoxLayout(holder[i],BoxLayout.Y_AXIS));
			}
		panelInput.add(holder[0],BorderLayout.LINE_START);//배치
		panelInput.add(holder[1],BorderLayout.CENTER);
		panelInput.add(holder[2],BorderLayout.SOUTH);
	
		subPInput = new JPanel [19]; 					//한 줄씩 분할한다.
		for(int i=0;i<8;i++){ 
			subPInput[i+11]= new JPanel();
			subPInput[i]= new JPanel();
			holder[1].add(subPInput[i]);				// CENTER 판넬에 붙인다.
			holder[0].add(subPInput[i+11]);				// WEST 판넬에 붙인다.
		}

		for(int i=8;i<11;i++){
			subPInput[i]= new JPanel();
			holder[2].add(subPInput[i]);				// SOUTH 판넬에 붙인다.
		}
		
		tfTitle = new JTextField(20);					//제목
		tfTitle.addActionListener(this);
		subPInput [0].add(tfTitle);						//CENTER에 붙인다.
		subPInput [11].add(new JLabel("제목"));			// WEST 판넬에 붙인다.
	
		tfDirector = new JTextField(20);				//감독
		tfDirector.addActionListener(this);
		subPInput [1].add(tfDirector);					//CENTER에 붙인다.
		subPInput [12].add(new JLabel("감독"));			// WEST 판넬에 붙인다.
		
		tfCast = new JTextField(20);					//배우
		tfCast.addActionListener(this);
		subPInput [2].add(tfCast);						//CENTER에 붙인다.
		subPInput [13].add(new JLabel("배우 "));			// WEST 판넬에 붙인다.
		
		String[] genre = {"액션","코미디","가족","멜로","미스터리","공포","SF"};
		gCombo = new JComboBox(genre);					//장르
		gCombo.setPreferredSize(new Dimension(227,20));	//상자 사이즈
		subPInput[3].add(gCombo);						//CENTER에 붙인다.
		subPInput[14].add(new JLabel("장르"));			// WEST 판넬에 붙인다.
		
		MaskFormatter mf = new MaskFormatter("####.##.##");	//포맷을 만든다
		mf.setPlaceholderCharacter('_');				//없으면 _
		tfDate=new JFormattedTextField(mf);				//포맷을 붙인다.			
		tfDate.addActionListener(this);
		tfDate.setPreferredSize(new Dimension(227,20));	//상자 사이즈 조절
		subPInput[4].add(tfDate);						//CENTER에 붙인다.
		subPInput[15].add(new JLabel("개봉일"));			// WEST 판넬에 붙인다.
					
		rbAge = new JRadioButton[4];					//관람 등급 : 라디오 버튼
		ButtonGroup bg = new ButtonGroup();				//라디오버튼 그룹핑
		String sAge [] ={"전체","12세", "15세","청불"};
		rbAge[0]=new JRadioButton(sAge[0],true);  		//"전체"로 초기화한다.
		bg.add(rbAge[0]);
		subPInput[5].add(rbAge[0]);
		for(int i=1;i<4;i++){
			rbAge[i]=new JRadioButton(sAge[i]);			//생성
			bg.add(rbAge[i]);							//그룹에 넣는다.
			subPInput[5].add(rbAge[i]);					//CENTER에 붙인다.
		}
		Border hBorder = BorderFactory.createLineBorder(Color.gray); //경계
		subPInput[5].setBorder(hBorder);				//경계를 만든다
		subPInput[16].add(new JLabel("전체등급"));		// WEST 판넬에 붙인다.			
		
		subPInput[6].setBorder(hBorder);				//경계를 만든다.
		tfHour = new JTextField(5);						//시간
		tfHour.addActionListener(this);
		subPInput[6].add(tfHour);					
		subPInput[6].add(new JLabel("시간"));
		tfMin = new JTextField(5);						//분
		tfMin.addActionListener(this);
		subPInput[6].add(tfMin);
		subPInput[6].add(new JLabel("분"));				
		subPInput[17].add(new JLabel("상영시간"));		// WEST 판넬에 붙인다.
		
		tfPoster = new JTextField(11);					//포스터 경로
		tfPoster.setEditable(false);					//경로결과만 보여줌 ,고칠수 X	
		bttnCall = new JButton("불러오기");
		bttnCall.addActionListener(this);
		subPInput[7].add(tfPoster);						//CENTER에 붙인다.			
		subPInput[7].add(bttnCall); 					//CENTER에 붙인다.
		subPInput[18].add(new JLabel("포스터")); 			//WEST판넬에 붙인다.
		
		Border synBorder = BorderFactory.createTitledBorder("시놉시스"); 	     
		subPInput[8].setBorder(synBorder);		
		taSynop  = new JTextArea(4,25);					//시놉시스 칸	
		synScroll = new JScrollPane(taSynop);	
		subPInput[8].add(synScroll); 					// CENTER에 붙인다.			
		
		Border opiBorder = BorderFactory.createTitledBorder("감상평");		
		subPInput[9].setBorder(opiBorder);
		taOpinion = new JTextArea(4,25);				//감상평 칸
		opiScroll = new JScrollPane(taOpinion);				
		subPInput[9].add(opiScroll); 					// CENTER에 붙인다.	
		
		//추가 취소 버튼들 CENTER에 함께 붙인다.
		bttnAdd = new JButton("추가");			bttnCancel= new JButton("취소");
		bttnAdd.addActionListener(this);		bttnCancel.addActionListener(this);
		subPInput [10].add(bttnAdd);			subPInput [10].add(bttnCancel);
		
		add(panelInput,BorderLayout.LINE_START);

//-----------------------------------------------------------------------------------------		
		panelList =new JPanel();						//리스트 판넬
		subPList = new JPanel[3];						//3등분
		for(int i=0;i<3;i++)
			panelList.add(subPList[i]= new JPanel());	
		
		Border SearchBorder = BorderFactory.createTitledBorder("영화 정보 검색");
		subPList[0].setBorder(SearchBorder);													
		String[] searchModel = {"전체","제목","감독","장르"};//검색용 panel
		sCombo = new JComboBox(searchModel);
		subPList[0].add(sCombo);
		tfSearch = new JTextField(20);
		subPList[0].add(tfSearch);
		bttnSearch = new JButton("검색");
		bttnSearch.addActionListener(this);
		subPList[0].add(bttnSearch);
		
		Border ListBorder = BorderFactory.createTitledBorder("영화 목록");
		subPList[1].setBorder(ListBorder);							
		sModel = new DefaultListModel();				//목록 panel
		sList = new JList(sModel);
		scroll= new JScrollPane(sList);					//스크롤
		scroll.setPreferredSize(new Dimension(370,440));		
		sList.addListSelectionListener(this);
		sList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		subPList[1].add(scroll);
		//버튼 panel	수정   삭제  버튼													
		bttnFix = new JButton("수정");  	 bttnDel = new JButton("삭제");
		bttnFix.addActionListener(this); bttnDel.addActionListener(this);
		subPList[2].add(bttnFix); 		 subPList[2].add(bttnDel);
		add(panelList,BorderLayout.CENTER);
//-----------------------------------------------------------------------------------------
		panelInfo = new JPanel();						//상세파넬
		panelInfo.setLayout(new GridLayout(2,1));		//이등분
		add(panelInfo,BorderLayout.LINE_END);	 
		subPInfo = new JPanel[2];
		panelInfo.add(subPInfo[0]= new JPanel());
		panelInfo.add(subPInfo[1]= new JPanel());
		Border infoBorder = BorderFactory.createTitledBorder("영화 정보");
		panelInfo.setBorder(infoBorder);
		// photo Panel
		poster = new JLabel();							//포스터 칸
		poster.setIcon(null);							//초기화
		poster.setText("");	
		subPInfo[0].add(poster);
		panelInfo.setPreferredSize(new Dimension(300,200));
		// 상세정보  담는 panel
		taDetail = new JTextArea(14,24);				//설명칸
		taDetail.setEditable(false);					//사용자가 입력 못한다.
		scroll2 = new JScrollPane(taDetail,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		subPInfo[1].add(scroll2);
		
	}
	
	//------------------------------------------------------------------------------
	// 리스너 인터페이스를 위한 각 메소드 구현
	// 어떤 이벤트가 발생했는지에 따라 각각의 기능을 수행한다.
	//------------------------------------------------------------------------------
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();	
		if(source == miOpen){ 								//파일 열기 오픈 OPEN
			int rv = fc.showOpenDialog(this);				//버튼 값을 반환 받는다
			if(rv==JFileChooser.APPROVE_OPTION){			//"열기"
				File file = fc.getSelectedFile();
				ObjectInputStream ois;
				collection.clear();							//db를 비운다.
				sModel.clear();								//리스트를 비운다.
				try{ 							
					ois= new ObjectInputStream(new FileInputStream(file));
					while((tmp=(Movie)ois.readObject())!=null){//파일 이끝나지 않았다면
						collection.add(tmp);				// collection에 저장
						sModel.addElement(tmp.title);		//리스트에도 이름 넣어준다.
						}
					sList.setSelectedIndex(0);				//리스트의 인덱스를 0으로
					ois.close();							//닫는다
				}
				catch(EOFException eof){}					//예외 처리
				catch(IOException | ClassNotFoundException e1){
					e1.printStackTrace();
				}
			}
		}
		else if(source == miSave){							//파일 저장 세이브 SAVE
			int rv = fc.showSaveDialog(this);				//선택한 버튼 값 반환
			if(rv==JFileChooser.APPROVE_OPTION){			//"저장"
				File file = fc.getSelectedFile();			//선택한 파일
				ObjectOutputStream oos;
				try{ 
					oos= new ObjectOutputStream(new FileOutputStream(file));
					for(int i=0;i<collection.size();i++)
						oos.writeObject((Movie)collection.get(i)); //db에 있는 값 저장
					oos.close();
					}
				catch(IOException e1){							//예외처리
					e1.printStackTrace();
				}
			}
		}
		else if(e.getSource() == miInfo){
			//시스템 정보 다이얼로그를 화면에 띄운다.
			JOptionPane.showMessageDialog(miInfo,"영화정보 시스템  v1.0입니다");
		}
		else if(source ==bttnAdd){ 					//panelInput의 "추가"겸 "수정완료" 버튼 처리
			if(e.getActionCommand()=="추가"){	 	// bttnAdd의 텍스트가 "추가"로 바꿨던 시점
				//사용자 입력으로부터 받은 값을 읽어와서 목록에 추가 
				//동시에 collection에도 Movie 객체 생성해서 추가 
				String title; 					String director;	 String cast; 
				String genre; 					String releaseDate;  String reviews;
				String grade;int runtime; 		String photo; 		 String synopsis;
			try{	 
				//값이 제대로 입력되었을때
				title=tfTitle.getText();		director=tfDirector.getText();
				cast = tfCast.getText();	
				
				releaseDate=tfDate.getText();
				synopsis=taSynop.getText();		photo=tfPoster.getText();
				reviews=taOpinion.getText();
				genre= (String) gCombo.getSelectedItem(); 
				runtime=(Integer.parseInt(tfHour.getText())*60 + Integer.parseInt(tfMin.getText()));

				if(rbAge[0].isSelected())		//선택된 라디오버튼 값을 저장
						grade = "전체";
				else if(rbAge[1].isSelected())
						grade = "12세";
				else if(rbAge[2].isSelected())
						grade = "15세";
				else 
						grade = "청불";
			
				sModel.addElement(title);
				Movie m = new Movie(title,  director,  cast,  genre, releaseDate, 
						grade,runtime, photo, synopsis, reviews);
				collection.addElement(m);  				//db에 생성된 m을 추가한다
											
			}catch (Exception ex){ // 입력값이 올바르지 않다면
				JOptionPane.showMessageDialog(null,"올바른 입력이 아닙니다.");
			}
			//panelInput 텍스트 필드 초기화
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
			
			if(e.getActionCommand()=="수정완료"){ 	
				// bttnAdd의 텍스트가 "수정완료"	
				// 사용자가 바꾼 값들을 다시 m에 저장한 후에 db에 저장한다.
				m.title=tfTitle.getText();		m.director=tfDirector.getText();
				m.cast = tfCast.getText(); 		m.photo=tfPoster.getText();
				m.genre= (String) gCombo.getSelectedItem();
				m.releaseDate=tfDate.getText();	m.reviews=taOpinion.getText(); 	
				m.synopsis=taSynop.getText();
				if(rbAge[0].isSelected())
						m.grade = "전체";
				else if(rbAge[1].isSelected())
						m.grade = "12세";
				else if(rbAge[2].isSelected())
						m.grade = "15세";
				else 
					m.grade = "청불";
			
				sModel.setElementAt(m.title,index); 	 //수정후  가운데 리스트 업데이트
				collection.setElementAt(m, index);  	 // 수정후 db 리스트 업데이트
				taDetail.setText(m.toString()); 		 // 상세 파일도 업데이트
				bttnAdd.setText("추가");					 // 버튼을 다시 "추가"용으로 바꾼다.
			
				//텍스트 필드 및 버튼들을 초기화한다
				tfDirector.setText(""); 	tfCast.setText("");
				tfHour.setText("");			tfMin.setText("");
				tfPoster.setText("");		tfTitle.setText(""); 
				taSynop.setText("");		taOpinion.setText("");
				tfDate.setText("");
				rbAge[0].setSelected(true); 			// 첫번째 라디오버튼은 켜고, 
				for(int i=1;i<4;i++) rbAge[1].setSelected(false); //나머지는 꺼둔다.
				gCombo.setSelectedIndex(0);
				}
			}
			else if(source ==bttnCall){ 						// "불러오기" 버튼이 눌렸을때
				int returnVal = fc.showOpenDialog(this);	 	//다이얼로그을 열고, 눌린 버튼 값을 받는다
				if(returnVal== JFileChooser.APPROVE_OPTION){	// 만약 "확인" 눌렸으면 
					File poster = fc.getSelectedFile(); 		// 파일을 열기 위해 파일 객체를 만들고
					tfPoster.setText(poster.getPath()); 		// 텍스트 필드에 경로를 보여준다.
					iPoster=new ImageIcon(tfPoster.getText());  // 경로를 사용해 아이미아이콘을 만든다. 
					}
				}
			else if(source == bttnCancel){ 
					// "취소" 버튼이 눌렸을 때, 각 버튼들과 텍스트 필드들을 초기화한다.
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
				if(sModel.size()!=0){ // 목록이 비워져 있지 않을 경우에 
				//"수정"버튼이 눌렸을때,  bttnAdd의 텍스트를 "수정완료"로 바꾸고
				bttnAdd.setText("수정완료"); 
				m=collection.get(index);  
					//db에서 받은 값을 다시 화면에 출력 해줘서 사용자가 고칠수 있게 유도
					// 아래는 panelInput에 m에 대한 정보들을 띄워서 사용자로 하여금 고칠 수 있게 한다. 
				tfTitle.setText(m.title);          tfDirector.setText(m.director); 
				tfCast.setText(m.cast);            tfHour.setText(""+(m.runtime/60)); 
				tfMin.setText(""+(m.runtime%60));  tfPoster.setText(m.photo);
				tfDate.setText(m.releaseDate);     gCombo.setSelectedItem(m.genre);
				taSynop.setText(m.synopsis);       taOpinion.setText(m.reviews);
				if(m.grade.equals("전체"))
					{rbAge[0].setSelected(true);}
				else if(m.grade.equals("12세"))
					{rbAge[1].setSelected(true);}
				else if(m.grade.equals("15세"))
					{rbAge[2].setSelected(true);}
				else 
					{rbAge[3].setSelected(true);}
				}
			}
			else if(source == bttnSearch){						//"검색 "버튼이 눌렸을 때
				String search =tfSearch.getText(); 				//찾을 단어
				String type = (String)sCombo.getSelectedItem(); // 검색 모드
				if(!search.equals("")){  						//찾을 단어가 있을 경우
					sModel.clear(); 							//한번 중앙 리스트를 정리 해주고
					if(type.equals("제목")){   		  	   	    //모드가 "제목"일 경우
						for(Movie temp:collection){				//db 전체를 돌면서검색어와 일치한다면  sList에 추가
							if(temp.title.equals(search))
								sModel.addElement(temp.title); 
						}
					}
					else if(type.equals("감독")){ 				//모드가 "감독"일 경우
						for(Movie temp:collection){  			//위와 동일
							if(temp.director.equals(search))	// sList에 추가
								sModel.addElement(temp.title);
						}
					}
					else if(type.equals("장르")){				//모드가 "장르"일 경우
						for(Movie temp:collection){				//위와 동일
							if(temp.genre.equals(search))		// sList에 추가
								sModel.addElement(temp.title);
						}
					}
					else{ 	//모드가 "전체"일 경우, 하나라도 같으면 리스트 추가한다.
						for(Movie temp:collection){		
							if(temp.title.equals(search)||temp.director.equals(search)||temp.genre.equals(search))// sList에 추가
								sModel.addElement(temp.title);
							}
						}		
					}
				else{  							   // 필드에 아무것도 없이 "검색"이 눌렸으면
					sModel.clear();				   //일단 현재 리스트를 한번 치우고
					for(Movie temp:collection)     //db에 있는 모든 데이터를 리스트한다.
						sModel.addElement(temp.title);
					}	
			}//(source == bttnSearch){}닫기
			else if(source == bttnDel){				//"삭제"버튼List에서 지우고 collection에서도 지워야 한다.
				if(sModel.size()!=0){
				if(index!=-1){ 						// 인텍스가 -1이 아닌 선에서 
					collection.remove(index); 		//db에서 선택된 항목을 지우고,
					sModel.removeElement(tag);		// 리스트 판넬에서도 지운다.
					poster.setIcon(null); 			//포스터라벨을 초기화하고
					taDetail.setText("");			// 상세설명도 초기화한다.
					sList.setSelectedIndex(collection.size()-1); 		// 리스트 판넬의 선택인덱스도 0으로 초기화한다.
				}
				}
			}
		
	}
//------------------------------------------------------------------------------
	public int getIndex(String title){ //제목을 받으면 db에서 인덱스를 찾아서 돌려준다.
		int i;
		try{
			for(i=0;i<collection.size();i++){
				if(title.equals(collection.get(i).title))//타이틀과 같으면
					break;
			}
		}catch(NullPointerException npe){ 				// 예외
			i = -1;
		}
		if(i==collection.size()) i=-1;			//값이 없을 경우는 -1을 할당한다.
		return i; // 나간다
	}
//------------------------------------------------------------------------------
//선택된 인덱스에 해당되는 영화 정보를 textArea 에서 출력한다.
//------------------------------------------------------------------------------
	public void valueChanged(ListSelectionEvent event){
		tag=(String)sList.getSelectedValue(); //리스트 판넬에서 선택된 영화 제목
		index=getIndex(tag);				
		
		if (index !=-1){
			m = collection.get(index); 				// 선택된 영화를 db에서 끌어온다.
			ImageIcon temp=new ImageIcon(m.photo);	//아이콘이미지를 경로를 통해서 만들고
			poster.setIcon(temp); 					//영화포스터를 화면에 띄운다.
			taDetail.setText(m.toString());			// 상세설명도 띄운다.
		}
	}	
	//------------------------------------------------------------------------------
	//별점을 콤보박스에서 선택하면 해당 별을 화면에 표시 (안 해도 된다고 하셨다)
	//------------------------------------------------------------------------------
	public void itemStateChanged(ItemEvent e) { 
		// TODO Auto-generated method stub	
	}

	public static void main(String[] args) throws Exception {
		 new MovieInfoSystem();
	}
}