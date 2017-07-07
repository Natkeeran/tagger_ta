/****** Automatic Tagger details **************

 Author 		:Dhinakaran .T
 Client 		:RCILTS
 Modify Date    :25.09.2002
 Anna University
 Copyright (c) 2002

/*************
The Automatic Tagger for Tamil uses heuristically dictated rules to find out nouns, verbs, adjectives, adverb and post positions. In Tamil it is necessary to check out for appropriate morphemes in words to classify them. Tamil is a free word order language, the only constraint being that generally, sentences are verb terminating . In some cases a one step look ahead with sensing of verbs is necessary to tag words. The steps in tagging include the deduction of some classes of words, removal of clitic, which form parts of words, deduction of nouns and verbs without look ahead and with look ahead and, finally deduction of adjective and adverbs. **********************/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;
import java.sql.*;

/************** The Automatic Tagger for Tamil uses heuristically dictated rules to find the nouns, verbs, adjectives, adverb and post positions. In Tamil it is necessary to check for appropriate morphemes in the words to classify them. Tamil is a free word order language, with the only constraint being that normally sentences are verb terminating. In some cases a one step look ahead with sensing of verbs is necessary to help the tagging. The steps in tagging include the deduction of some classes of words, removal of clitic, which form parts of words, deduction of nouns and verbs without look ahead and with look ahead and, finally deduction of adjective and adverbs.*****************/

public class Tagger extends JFrame
{
		// initialize the font property here used Tab-Anna Font
		Font font=new Font("TAB-Anna",Font.BOLD,18);

/************** create interface using Swing component*********/

		//top panel of the screen includes select and tag button  and select label
		JPanel jp_top = new JPanel();

		//center panel of the screen  includes Textarea
		JPanel jp_center = new JPanel();

		// bottom panel of the screen includes exit and clear button
		JPanel jp_bottom = new JPanel();

/************* This Checktoken class could be used to parse the file
        into single token and process some operations *********/
		static Checktoken checktoken=new Checktoken();

		//File Label  identify file name
		JLabel jlb_select_file = new JLabel("«è£ð¢¹/File:");

		// Totcount Label identify Total number of count in the file
		JLabel jlb_totcount=new JLabel();

        // count Label identify no. of token tagged in the file
        JLabel jlb_count=new JLabel();

        // percount Label identify the no of untagged token in the file
        JLabel jlb_percount=new JLabel();

		// ScrollPane  used in textarea
		JScrollPane jsp_workspace;

		//select button is used to select particular file
		JButton jb_browse = new JButton("«îó¢ï¢ªî´/Select File");

		// ok button is used to confirm the file
		JButton jb_ok = new JButton("ºù¢ ð£ó¢¬õ/");

		//tag button is used to tagged the particular file
		JButton jb_tag = new JButton("°ø¤ò¤´/Tag");

		//exit button is used to exit the entire setup
		JButton jb_exit = new JButton("ªõ÷¤«òÁ/Exit");

		//new button used to clear the textarea content
		JButton jb_new =new JButton("Üö¤/Clear");

		//Textfield used to display the input file name
		JTextField jtf_filename = new JTextField("",20);

		//File chooser used to select the particular file
		JFileChooser jfc_filename = new JFileChooser(".");

		//Textarea used to display the content of the input and output files
		static JTextArea textarea = new JTextArea( 20,49);

		// Read the specified file using this class

		static FileInputStream fileinputstream;

/*************** Byte method is used to do some byte operations
				  ie.. endswith,isequal,startswith******************/
		static ByteMeth1 bytemeth;

		//This string used in StringTokenizer method
		static String string="";

		// Instance of Stringtokenizer class.It is used to parse the file into tokens
		static StringTokenizer stringtoken;

		// next token used to store the next token
		static String nexttoken=" ";

		//static String dbasestring=null;

		//count1 is used to tagged token into the file
		static int count1=0;

		//Create the database statement
		//static Statement statment;

		//create the database connection in further use
		//static Connection connection;

		//Resultset is used to store the records and also retrieval the data from database
		//static ResultSet resultset;

		// count identify the no of token in the file
		static int count=0;

		//static String str[]=null;

		//Secondtoken idenify the Secondtoken and used to check all methods(ie check adverb,adjective..)
		static byte[] SecondToken=null;

		//FirstToken identify the FirstToken and used to check all methods(ie check adverb,adjective..)
		static byte[] FirstToken=null;

		//ThirdToken identify the ThirdToken and used to check all methods(ie check adverb,adjective..)
		static byte[] ThirdToken=null;

		//FourthToken identify the FourthToken and used to check all methods(ie check adverb,adjective..)
		static byte[] FourthToken=null;

		//Sublength identify the sublength of the particular token(ie First,Second .. ..Token)that is like as substring
		static byte sublength[]=null;

		//specifylength identify the specifylength of the particular token(ie First,Second .. ..Token)that is full length
		static byte specifylength[]=null;

		//addlength identify the addlength of the particular token(ie First,Second .. ..Token)that is adding length
		static byte addlength[]=null;

		//clitics
		static byte eey[]={8},eeey[]={24,8};

		//token identify to check the existent token from the check adverb ,checkfull item .method
		static boolean token=false;

		//token1 identify to check the existent token from the check adverb ,checkfull item .method
		static boolean token1=false;

		//token2 identify to check the existent token from the check adverb ,checkfull item .method
		static boolean token2=false;

		/*static int check=0;
		static int check1=0;
		static String currenttoken=" ";
		static String currenttoken1=" ";*/

/************** identify verb using fullstop *****************/

		static byte stop[]={0,46};

/************** Using clitics ****************************************/

		static byte a[]={1},e[]={3},u[]={5},ei[]={24},aaa[] ={2},oo[]={11},than[]={20,2,31},ada[]={1,18,2},adi[]={1,18,3},
		avathu[]={2,27,1,20,5},cuda[]={14,5,18,1},than1[]={20,2,31,0,46};

/************** Using Verb participle and some Adjective **************/

		static byte naattu[]={21,2,18,18,5},veettu[]={27,4,18,18,5},
		kandu[]={14,1,19,18,5},naattu1[]={31,2,18,18,5},nnk[]={15,14},eya[]={3,24,1},thal[]={20,1,26};

/************** Using numbers **********************************************/

		static byte a0[]={0,48},a1[]={0,49},a2[]={0,50},a3[]={0,51},a4[]={0,52},
		a5[]={0,53},a6[]={0,54},a7[]={0,55},a8[]={0,56},a9[]={0,57};

/************** Using Demonstrate pronoun ************************************/

		static byte entha[]={3,21,20,1},antha[]={1,21,20,1},yantha[]={7,21,20,1};

/************** Using numerals ***********************************************/

		static byte a01[]={0,73},a02[]={0,73,73},a03[]={0,73,73,73},a04[]={0,73,86},
		a05[]={0,86},a06[]={0,86,73},a07[]={0,86,73,73},a08[]={0,86,73,73,73},
		a09[]={0,73,88},a00[]={0,88};

/************** Using number form ********************************************/

		static byte oru[]={10,25,5},oor[]={11,25},eru[]={3,25,5},one[]={10,31,30,5},
		two[]={3,25,1,19,18,5},three[]={23,6,31,30,5},four[]={21,2,31,14,5},four1[]={31,2,31,14,5},
		five[]={9,21,20,5},five1[]={20,9,21,20,5},six[]={2,30,5},six1[]={20,2,30,5},//six2[]={23,2,30,5},
		seven[]={8,28,5},eight[]={7,18,18,5},six3[]={31,2,30,5},
		nine[]={10,31,22,1,20,5},ten[]={22,1,20,20,5},twenty[]={3,25,5,22,1,20,5},
		thirty[]={23,5,22,22,1,20,5},forty[]={21,2,30,22,1,20,5},fifty[]={9,23,22,1,20,5},
		sixty[]={1,30,5,22,1,20,5},seventy[]={7,28,5,22,1,20,5},eighty[]={7,19,22,1,20,5},
		ninety[]={20,10,19,19,6,30,5},hunrd[]={21,6,30,5},hunrd1[]={6,30,30,5},lagsh[]={26,1,18,16,1,23},
		thosn[]={2,24,3,25,1,23},crore[]={14,11,18,3},muthal[]={23,5,20,1,26},kadaisi[]={14,1,18,9,16,3};

/************* Using case marker using in verb ********************************/

		static byte een[]={8,31},kaay[]={2,24},oom[]={11,23},aar[]={2,25},eer[]={4,25},thh[]={21},
		iirkal[]={4,25,14,1,29},ana[]={1,31,1}, atu[]={1,20,5},ellai[]={3,26,26,9},
		aarkal[]={2,25,14,1,29},eerkal[]={4,25,14,1,29},aan[]={2,31},aall[]={2,29},
		een1[]={8,31,0,46},kaay1[]={2,24,0,46},oom1[]={11,23,0,46},aar1[]={2,25,0,46},eer1[]={4,25,0,46},
		iirkal1[]={4,25,14,1,29,0,46},ana1[]={1,31,1,0,46}, atu1[]={1,20,5,0,46},ellai1[]={3,26,26,9,0,46},
		aarkal1[]={2,25,14,1,29,0,46},eerkal1[]={4,25,14,1,29,0,46},aan1[]={2,31,0,46},aall1[]={2,29,0,46};

/************* Using tense markers in verb	************************************/

		static byte yh[]={5,15},t1[]={20},n[]={31},tt[]={18},tr[]={30},th[]={20,21},p[]={22},v[]={27},tttt[]={18,18},
		pp[]={22,22},tp[]={18,22},rp[]={30,22},rr[]={30,30},nr[]={31,30},nnt[]={19,18},kkk[]={14,14},ttt[]={20,20},
		kindru[]={14,3,31,30},kru[]={14,3,30},kkru[]={14,14,3,30},kkindru[]={14,14,3,31,30};

/************* using Standalone words in verb ***********************************/

		static byte vendum[]={27,8,19,18,5,23},vendam[]={27,8,19,18,2,23},kudum[]={14,6,18,5,23},
		kutathu[]={14,6,18,2,20,5},thondrum[]={20,11,31,30,5,23},aathirkal[]={2,20,4,25,14,1,29},
		aatha[]={2,20,8},ungal[]={5,15,14,1,29},aammal[]={2,23,1,26},aathu[]={2,20,5},
    vendum1[]={27,8,19,18,5,23,0,46},vendam1[]={27,8,19,18,2,23,0,46},kudum1[]={14,6,18,5,23,0,46},
		kutathu1[]={14,6,18,2,20,5,0,46},thondrum1[]={20,11,31,30,5,23,0,46},aathirkal1[]={2,20,4,25,14,1,29,0,46},
		aatha1[]={2,20,8,0,46},ungal1[]={5,15,14,1,29,0,46},aammal1[]={2,23,1,26,0,46},aathu1[]={2,20,5,0,46},
		aavital[]={2,27,3,18,18,2,26};

/************** Using case markers in noun *************************************/

		static byte in[]={3,31},ppu[]={22,22,5},itam[]={3,18,1,23},ilunthu[]={3,26,3,25,5,21,20,5},
		udya[]={5,18,9,24,1},utan[]={5,18,1,31},kal[]={14,1,29},kal1[]={14,1,29,0,46},il[]={3,26},aal[]={2,26},
		aal1[]={2,26,0,46},ai[]={9},kku[]={14,14,5}, akku[]={1,14,14,5},erkku[]={30,14,5},ukku[]={5,14,14,5},
		eiumm[]={24,5,23},vvumm[]={27,5,23},thumm[]={20,5,23},pumm[]={22,5,23},kumm[]={14,5,23},rumm[]={30,5,23},
		umm[]={5,23},amm[]={1,23},amm1[]={1,23,0,46},ll[]={29},kk[]={14},l[]={26},cc[]={16},oodu[]={11,18,5},
		odu[]={10,18,5},ar[]={1,25},ar1[]={1,25,0,46},ukkaka[]={5,14,14,2,14,1},edamiruthu[]={3,18,1,23,3,25,5,21,20,5},
		al[]={1,29},an[]={1,31},al1[]={1,29,0,46},an1[]={1,31,0,46},ul[]={5,29},cchi[]={16,16,3},sss[]={32},ss[]={33},me[]={23,3},
		lee[]={26,3},mmpu[]={23,22,5},vayathu[]={27,1,24,1,20,5},vayathu1[]={27,1,24,1,20,5,0,46},tamil[]={20,1,23,3,28},
		kasu[]={14,2,16,5},manaivi[]={23,1,31,9,27,3},arivu[]={1,30,3,27,5},aanaal[]={2,31,2,26};

/*************** Using Standalone words in pronoun *******************************/

        static byte en []={7,31},un []={5,31},thn []={20,1,31},nm []={21,1,23},nangal []={21,2,15,14,1,29},
		neengal []={21,4,15,14,1,29},avai []={1,27,9},avaigal []={1,27,9,14,1,29},avargal []={1,27,1,25,14,1,29},
		evai []={3,27,9},evaigal []={3,27,1,14,1,29},evargal []={3,27,1,25,14,1,29},engal []={7,15,14,1,29},
		thm []={20,1,23},em []={7,23},avan[]={1,27,1,31},evan[]={3,27,1,31},avar[]={1,27,1,25},evar[]={3,27,1,25},
		athu[]={1,20,5},aval[]={1,27,1,29},ethu[]={3,20,5},nee[]={21,4},neever[]={21,4,27,4,25},nam[]={21,2,23},nan[]={21,2,31},
		yathu[]={7,20,5},yavan[]={7,27,1,31},yavar[]={7,27,1,25},tham[]={20,2,23};

/************** Using Standalone words in Postposition *************************/

     	static byte mathiri []={23,2,20,3,25,3},oty[]={10,18,18,3},kurithu[]={14,5,30,3,20,20,5},
		kondu[]={14,10,19,18,5}, cutri[]={16,5,30,30,3},thavirthu[]={20,1,27,3,25,20,20,5},
		thandi[]={20,2,19,18,3}, patri[]={22,1,30,30,3},parthu[]={22,2,25,20,20,5},
		vithu[]={27,9,20,20,5},noki[]={21,11,14,14,3},thavira[]={20,1,27,3,25,1},
		oliya[]={10,28,3,24,1},pola[]={22,11,26,1},vita[]={27,3,18,1},vitu[]={27,3,18,18,5},
		pol[]={22,11,26};

		static byte aka[]={2,14,1},appothu[]={1,22,22,11,20,5},appoluthu[]={1,22,22,10,28,5,20,5},
		eppothu[]={3,22,22,11,20,5},eppoluthu[]={3,22,22,10,28,5,20,5},yavvalavu[]={7,27,27,1,29,1,27,5},
		evvalavu[]={3,27,27,1,29,1,27,5};

		static byte appola[]={1,22,22,2,26,8},uula[]={5,29,29,8},kilakka[]={14,3,28,1,14,14,8},
		kila[]={14,4,28,8},tharkka[]={20,7,30,14,14,8},pina[]={22,3,31,8},
		piraka[]={22,3,30,1,14,8},muna[]={23,5,31,8},mala[]={23,8,26,8},markka[]={23,8,30,14,8},
		vatakka[]={27,1,18,1,14,14,8},athira[]={7,20,3,25,8},kurukka[]={14,5,30,5,14,14,8},
		valiya[]={27,7,29,3,24,8},etaya[]={3,18,9,24,8},natuva[]={21,1,18,5,27,8};

		static byte mun[]={23,5,31},mal[]={23,8,26},markku[]={23,8,30,14,5},vatakku[]={27,1,18,1,14,14,5},
		athir[]={7,20,3,25},kurukku[]={14,5,30,5,14,14,5},vali[]={27,7,29,3},etai[]={3,18,9},
		etayal[]={3,18,9,24,3,26},natu[]={21,1,18,5},natuvil[]={21,1,18,5,27,3,26},
		pinthi[]={22,3,21,20,3},munthi[]={23,5,21,20,3},uul[]={5,29},appol[]={1,22,22,2,26},
		kilakku[]={14,3,28,1,14,14,5},kil[]={14,3,28},tharkku[]={20,7,30,14,14,5},
		pin[]={22,3,31},piraku[]={22,3,30,1,14,5},valiyal[]={27,7,29,3,24,3,26};

		static byte mulam[]={23,6,26,1,23},varai[]={27,1,4,9},andai[]={1,19,18,9},aruku[]={1,25,5,14,8},
		aatan[]={2,18,2,31},kitta[]={14,3,18,18,1},kilza[]={14,4,28,1},pakkam[]={22,1,14,14,1,23},
		padi[]={22,1,18,3},illamal[]={3,26,26,2,23,1,26},allamal[]={1,26,26,2,23,1,26},varu[]={27,2,30,5};

/*************** Using Standalone words in adjective *****************************/

		static byte aana[]={2,31,1},yaliya[]={7,29,3,24,1},uyartha[]={5,24,1,25,21,20,1},thalntha[]={20,2,28,21,20,1},
		sumar[]={16,5,23,2,25},arakuraiya[]={8,30,1,14,5,30,9,24,1},arathala[]={8,30,1,20,20,2,28,1},
		pondra[]={22,11,31,30,1},yalla[]={7,26,26,2},perum[]={22,7,25,5,23},miga[]={23,3,14,1},chinna[]={16,3,31,31,1},
		chiru[]={16,3,30,5},peru[]={22,7,30,5},puthu[]={22,5,20,5},ondrum[]={10,31,30,5,23},mekka[]={23,3,14,14,1};
		static byte palya[]={22,1,28,9,24,1},puthiya[]={22,5,20,3,24,1},alakya[]={1,28,1,14,3,24,1},
		parya[]={22,7,25,3,24,1},chirya[]={16,3,30,3,24,1}, natiya[]={21,7,18,3,24,1},
		palyathu[]={22,1,28,9,24,1,20,5},puthiyathu[]={22,5,20,3,24,1,20,5},alakyathu[]={1,28,1,14,3,24,1,20,5},
		paryathu[]={22,7,25,3,24,1,20,5},chiryathu[]={16,3,30,3,24,1,20,5}, natiyathu[]={21,7,18,3,24,1,20,5},
		inniyathu[]={3,31,3,24,1,20,5},inniya[]={3,31,3,24,1},cila[]={16,3,26,1},pala[]={22,1,26,1},aay[]={2,24},
		aay1[]={2,24,0,46},oonki[]={11,15,14,3},oonkiya[]={11,15,14,3,24,1},oonkiyathu[]={11,15,14,3,24,1,20,5};

/*************** Using Standalone words in adverb *********************************/

		static byte adikadi[]={1,18,3,14,14,1,18,3},enimel[]={3,31,3,23,8,26},ennum[]={3,31,31,5,23},
		marupadium[]={23,1,30,5,22,1,18,3,24,5,23},meendum[]={23,4,19,18,5,23},meela[]={23,7,26,26,1},
        udana[]={5,18,1,31,8};

/*************** Using week in noun part *****************************************/

		static byte thingal[]={20,3,15,14,1,29},chavvai[]={16,7,27,27,2,24},puthan[]={22,5,20,1,31},
		viyazhan[]={27,3,24,2,28,1,31},velli[]={27,7,29,29,3},shani[]={16,1,31,3},
		nayaru[]={17,2,24,3,30,5},varam[]={27,2,25,1,23},matham[]={23,2,20,1,23},aandu[]={2,19,18,5};

/*************** Using month in noun part ****************************************/

		static byte vaikasi[]={27,9,14,2,16,3},aani[]={2,31,3},aadi[]={2,18,3},aavani[]={2,27,1,19,3},
		puratasi[]={22,5,25,1,18,18,2,16,3},aypasi[]={9,22,22,1,16,3},margali[]={23,2,25,14,1,28,3},
		masi[]={23,2,16,3},panguni[]={22,1,15,14,5,31,3},jan[]={34,1,31,1,27,1,25,3},
		feb[]={22,3,22,25,1,27,1,25,3},mar[]={23,2,25,16},apr[]={8,22,25,1,26},
		may[]={23,8},jun[]={34,6,31},aug[]={2,14,1,32,18},sep[]={16,7,22,18,1,23,22,1,25},
		oct[]={1,14,18,11,22,1,25},nov[]={21,1,27,1,23,22,1,25},dec[]={18,3,16,1,23,22,1,25};

/*************** Using colors in Adjective part ***********************************/

		static byte yellow[]={23,1,17,16,3,29},black[]={14,1,25,5,22,22,5},paluppu[]={22,1,28,5,22,22,5},
		green[]={22,1,16,16,9},red[]={16,3,14,1,22,22,5},red1[]={16,3,27,1,22,22,5},blue[]={21,4,26,1,23},
		white[]={27,7,29,29,9},white1[]={27,7,19,23,9},vilat[]={6,20,2},orange[]={2,25,1,17,16,5},
		kavi[]={14,2,27,3},gray[]={16,2,23,22,1,26};

/*************** Using end pattern search in Adverb*********************************/

		static byte enku[]={3,15,14,5},aanku[]={1,15,14,5},yanru[]={7,31,30,5},aanru[]={1,31,30,5},
		netru[]={21,8,30,30,5},entru[]={3,31,30,5},nalai[]={21,2,29,9},yanku[]={7,15,14,5};

/************** Default constructor ******************************************************/

		public Tagger( )
		{
			//Using borderLayout is used to set and add the component to nourth,south,east and west side
			getContentPane().setLayout(new BorderLayout());

			//adding select label to top panel
			jp_top.add(jlb_select_file);

			//setting select label to tab-Anna font
			jlb_select_file.setFont(font);

			//Add the file name in to the top panel
			jp_top.add(jtf_filename);

/************ Select the particular file name using this operation ******************/

			ActionListener borwseListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					//the String value set to null
					string="";
					//textarea set to null
					textarea.setText("");
					setFileChooserLAndF(jfc_filename);
					//File name set in to Tab-Anna font
					setLanguage(jfc_filename);
					//open file dialog
					int option = jfc_filename.showOpenDialog(Tagger.this);
					//get action from file chooser
					if(option == JFileChooser.APPROVE_OPTION)
					{
						jtf_filename.setText(jfc_filename.getSelectedFile().toString());
					}
					try
					{
						//the String value set as null
						string="";

						//textarea set to null
						textarea.setText("");

						///Select the particular file name and get the  file name
						fileinputstream=new FileInputStream(jfc_filename.getSelectedFile());

						//Check file is available or not
						while(fileinputstream.available()!=0)
						{
							//Read the file from input stream object
							int finputstream=fileinputstream.read();

							//convert into string
							string=string+(char)finputstream;
						}
						//append the string to textarea
						textarea.append(string);

						//set the Tab-Anna to Teatarea
						textarea.setFont(font);
					}
					catch(Exception e)
					{
						//Catch the Exception here
						System.out.println("excep" +e);
					}
				}
			};
			//Add the Add button
			jb_browse.addActionListener(borwseListener);

			//Set background color
			jb_browse.setBackground(new Color(159,165,170));//123,149,117));

			//Set the Tab-Anna font
			jb_browse.setFont(font);

			//Add the add button in Top panel
			jp_top.add(jb_browse);

/**************** Tag the selected file using this Operation****************/

			ActionListener tagListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					//textarea set to null
					if(!string.equals("") || string!="")
					textarea.setText(" ");
					else
					string=textarea.getText();

					textarea.setText(" ");
/****************** Call the checktoken method and it is used to parse the String in to token  ***************************/
					checktoken.checktoken(string);

					//Get the content of the textarea in notepad variable
					/*String notepad=textarea.getText();
					try
					{
					//Write the Output file using outputstream class
					FileOutputStream out=new FileOutputStream("d:\\temp.txt");
					for(int i=0;i<notepad.length();i++)
					{
						//write the output file
					 	out.write(notepad.charAt(i));
					}
					}
					catch(Exception e)
					{
					//	System.out.println(e);
					}*/


					//Total no of token in the file
			        jlb_totcount = new JLabel("ªñ£î¢î õ££¢î¢¬îè÷¢/Total words:" + count);

			        //Percentage of the Tagged token
					jlb_percount = new JLabel(" êîõ¤è¤îñ¢/Percentage:" +
						(double)(Tagger.count1*100/Tagger.count)+"%");

					//Tagged words in the file
			        jlb_count = new JLabel(" ð°î¢î õ££¢î¢¬îè÷¢/tagged words:" + count1);

					//set foreground color into the total count
    			    jlb_totcount.setForeground(Color.orange);

    			    //set foreground color in to the count
                    jlb_count.setForeground(Color.orange);

                     //set foreground color in to the percount
		            jlb_percount.setForeground(Color.orange);

					//In panel used to Grid bag layout manager this used to display the total,percentage and tagged words
		            JPanel p = new JPanel(new GridLayout(3,1,20,20));

		            //set background color of the panel
		            p.setBackground(null);//(new Color(62,91,87));

					//add total count in to the panel
					p.add(jlb_totcount);

					//add count in to the panel
					p.add(jlb_count);

					//add per count in to the panel
					p.add(jlb_percount);

					//This all count add to bottom panel
					jp_bottom.add(p);

					//tot count set tab-Anna Font
					jlb_totcount.setFont(font);

					//count set it as tab-Anna Font
			        jlb_count.setFont(font);

				    //percount set it as tab-Anna Font
			        jlb_percount.setFont(font);

				}
			};
			//Add the tag button
			jb_tag.addActionListener(tagListener);

			//Set background color
			jb_tag.setBackground(new Color(159,165,170));//123,149,117));

			//Set the Tab-Anna font
			jb_tag.setFont(font);

			//Add the tag button in Top panel
			jp_top.add(jb_tag);

			//In textarea set line wrap to reason of display problem
			textarea.setLineWrap(true);
			textarea.setWrapStyleWord(true);

			// Using scroll pane in textwindow and used vertical scroll pane (not horizontal)
			jsp_workspace = new JScrollPane(textarea,ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

			//textarea add  up to the center pane
			jp_center.add(jsp_workspace);

			//set Tab-Anna font to the textarea
			textarea.setFont(font);

/************** Exit setup used to come out of the whole window **********/

			ActionListener exitListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					//This System class used to exit method and it closes whole operations
					System.exit(0);
				}
			};
			//Add the exit button
			jb_exit.addActionListener(exitListener);

			//Set background color
		    jb_exit.setBackground(new Color(159,165,170));//123,149,117));

		   //add the exit button to bottom pane
            jp_bottom.add(jb_exit);

             //Set the Tab-Anna font
			jb_exit.setFont(font);

/************** Clear  old windows Using this method *********************/
   	        ActionListener newListener = new ActionListener()
			{
				public void actionPerformed(ActionEvent ev)
				{
					//set string as null
				   	string="";

				   	//initially total count is set it as zero
					count=0;

					//tagged token is null
					count1=0;

					//set textarea as null
					textarea.setText("");

					//set totcount is null
					jlb_totcount.setText("");

					//set count is null
					jlb_count.setText("");

					//set percount is null
					jlb_percount.setText("");

					//set filename is null
					jtf_filename.setText("");
				}
			};
			//Add the new button
			jb_new.addActionListener(newListener);

			//Set background color
		    jb_new.setBackground(new Color(159,165,170));//123,149,117));

		    //add the new button to bottom pane
	        jp_bottom.add(jb_new);

	        //Set the Tab-Anna font
			jb_new.setFont(font);

			//in Swing add the component must used to define getContentPane here using border layout and add the component to specify location
			getContentPane().add(jp_top,BorderLayout.NORTH);
			getContentPane().add(jp_center,BorderLayout.CENTER);
			getContentPane().add(jp_bottom,BorderLayout.SOUTH);

			//setting the size of the frame
			setSize(800,580);

		    bytemeth=new ByteMeth1();

		   //set the Foreground for textarea
			textarea.setForeground(Color.black);

			//set the Foreground for select file label
			jlb_select_file.setForeground(Color.orange);

            //set the Background for textarea
            textarea.setBackground(new Color(159,165,170));

			//set the Background for select file label
			jtf_filename.setBackground(new Color(159,165,170));

			//set font the filename
			jtf_filename.setFont(font);

			//in top panel set Background color
			jp_top.setBackground(new Color(29,45,64));//62,91,87));

			//in center panel set Background color
			jp_center.setBackground(new Color(29,45,64));//62,91,87));

			//in bottom panel set Background color
			jp_bottom.setBackground(new Color(29,45,64));
			try
			{
/***************** create the database connection *****************************/
				//loading the Jdbc driver
				 //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

				 //Create the connection
				 //connection= DriverManager.getConnection("jdbc:odbc:gendata");

				 //create the connection
				 //statment=  connection.createStatement();

				 //Store the value from database to resultset object
				 //Tagger.resultset=Tagger.statment.executeQuery("select * from auxilary");

				 //Using Arraylist class add the resultset value to array
				 ArrayList al=new	ArrayList();
				 /*while(Tagger.resultset.next())
				 {
					 //result variable to store resultset value
					String result=Tagger.resultset.getString("aux");
					//adding resultset value to arraylist abject
					al.add(result);
				 }

				 /*** get the string size ***
//			 str=new String[al.size()];
				//variable i is used to for loop operation
				 int i;
				// int j;
				 for(i=0;i<al.size()-1;i++)
				 {
//					str[i]=(String)al.get(i);
				 }*/
        	 }
			 catch(Exception e)
		     {
			   System.out.println("sql"+e);
			 }
			 // using windowClosing event used to  close the frame
			 addWindowListener(new WindowAdapter()
             {
             	public void windowClosing(WindowEvent e)
   	      	    {
            	  System.exit(1);
                }
             });
  		}
		public static String Text(String s)
		{
			textarea.setText(" ");
			String notepad="";
			try
			{
				fileinputstream=new FileInputStream(s);
				while(fileinputstream.available()!=0)
				{
					int finputstream=fileinputstream.read();
					string=string+(char)finputstream;
				}
			}
			catch(Exception e)
			{
			}
		return string;
		}

		public static String Tagg(String s)
		{
			textarea.setText(" ");
			String notepad="";
			checktoken.checktoken(string);
			notepad=textarea.getText();
			return notepad;
}


/**********************Convert the Dialog box form English to Tamil*********************************/

//This method used to create our own interface
private void setFileChooserLAndF(JFileChooser fc)
{
	//to get how many component available in the Dialog Box
  	for(int i=0; i < fc.getComponentCount();i++)
   		if (fc.getComponent(i) instanceof JPanel)
		{
			//set the panel from get component
    		setPanelLAndF((JPanel)fc.getComponent(i));
		}
}
//convert button,label and combobox from English to Tamil
private void setPanelLAndF(JPanel jp)
{
	//get the all component from dialog box
  	for(int j=0; j < jp.getComponentCount();j++)
  	{
   		Component bo = jp.getComponent(j);
   		if (bo instanceof JPanel)
   			 setPanelLAndF((JPanel)bo);
   		if (bo instanceof JButton)
   		{
   	   		JButton b = ((JButton)bo);
   	   		//set the Tab-Anna font
    		b.setFont(font);
   		}
   		else if (bo instanceof JLabel)
   		{
   			 JLabel l = ((JLabel)bo);
   			 //set the Tab-Anna font
    		 l.setFont(font);
   		}
   		else if(bo instanceof JComboBox)
   		{
		    JComboBox c = ((JComboBox)bo);
		    //set the Tab-Anna font
		    c.setFont(font);
  		}
	  }
}
//convert to button text from English to Tamil
public void setLanguage(JFileChooser fc)
{
	//set the Tab-Anna font
	fc.setFont(font);
	//get the all component from dialog box
	for(int i=0; i < fc.getComponentCount();i++)
		if (fc.getComponent(i) instanceof JPanel)
			setJFCButtonText((JPanel)fc.getComponent(i));
}

private void setJFCButtonText(JPanel jp)
{
	for(int j=0; j < jp.getComponentCount();j++)
	{
		Component bo = jp.getComponent(j);
		if (bo instanceof JPanel)
			setJFCButtonText((JPanel)bo);
		if (bo instanceof JButton)
		{
			JButton b = (JButton)bo;
			if(b.getText() != null)
			{
				if(b.getText().equals("Open"))
					b.setText("î¤ø/Open");
				if(b.getText().equals("Save"))
					b.setText("«êñ¤/Save");
				if (b.getText().equals("Cancel"))
					b.setText("ï¦è¢°/Cancel");
			}
		}
		else if (bo instanceof JLabel)
		{
			JLabel l = ((JLabel)bo);
			if(l.getDisplayedMnemonic() == 73)
				l.setText("«îó¢ï¢ªî´/Select");
			else if(l.getDisplayedMnemonic() == 78)
				l.setText("«è£ð¢ð¤ù¢ ªðòó¢/Select name");
			else if(l.getDisplayedMnemonic() == 84)
				l.setText("«è£ð¢ð¤ù¢ õ¬è/Select type");
		}
	}
}
/************* main method **************************************************/

		public static void main(String args[])
		{
		   Tagger tag = new Tagger();
		  // tag.Tagg("E:\\Dhina\\current items\\tagger\\Sample.txt");
		   //to set title
		   tag.setTitle("Automatic Tagger");
		   //to set Background color
		   tag.setBackground(new Color(62,91,87));
		   Toolkit tk = Toolkit.getDefaultToolkit();
		   //to set logo
		   Image img = tk.getImage("logo.gif");
		   tag.setIconImage(img);
		   tag.setSize(900,600);
		   /*** show the frame window.***/
		   tag.show();
		}
}

