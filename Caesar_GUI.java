import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
 
/*	Encrypts	and Decrypts text	using	the Caesar Cihper	algorithm.
 *	@author Invisible	Computer, JTN
 *	@Modification:	Emily	Lopez
 */
public class Caesar_GUI extends JFrame implements ActionListener {
 
		  private static final long serialVersionUID	= 1L;
		  private static String	alphabet	= " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		  private JTextField	shiftFactor;
		  private JTextArea inputTA;
		  private JTextArea outputTA;
 
 
		  /* @param	args */
		  public	static void	main(String[] args)
		  {
				new Caesar_GUI().setVisible(true);
		  }
		 
		  public	void encryptText() throws InterruptedException
		  {
				//Create	a HashMap
				//A hash	map takes keys	and values,	which	are both	Characters	in	this case.
				HashMap<Character, Character>	alphaMap	=	new HashMap<Character, Character>();
				int shift;
				int nI = 0;
				//Get	the text	from	the app and	store	it	in	a String	variable.
				String textNum	=	this.shiftFactor.getText();
				
				//Check	to	see if a	"Shift Factor"	value	was entered.
				//If	there	wasn't, set	shift	to	zero,
				//Otherwise	parse	the input value to an integer	so	we	can use	it.
				if(!textNum.equals(""))
				{
					if(Integer.parseInt(textNum)%53 < 27)
               {
                  shift	= Integer.parseInt(textNum)%63;
               }
               else
               {
                  shift = 0;
               }
				}
				else
				{
					shift	= 0;
				}
			   
            //Map every letter of the	alphabet	to	another letter	in	the alphabet, shifted by x	places.
			   for(int i=0; i<alphabet.length(); i++)
            {
					if((i >=1) && (i <= 26))
               {
                   if(shift + i < 27)
                   {
                     alphaMap.put(alphabet.charAt(i),alphabet.charAt((i+shift)%63));
                   }
                   else
                   {
                     nI = (i + shift) - 26;
                     alphaMap.put(alphabet.charAt(i),alphabet.charAt((nI%63)));
                   }
               }
               else if((i > 26) && (i  <= 52))
               {
                  if(shift + i <= 52)
                  {
                     alphaMap.put(alphabet.charAt(i),	alphabet.charAt((i+shift)%63));
                  }
                  else
                  {
                     nI = ((shift + i) - 26);
                     alphaMap.put(alphabet.charAt(i),alphabet.charAt((nI%63)));
                   }  
                }
   			   else if(i > 52 && i <= 62)
               {
                  if(shift + i <= 62)
                  {
                     alphaMap.put(alphabet.charAt(i),	alphabet.charAt((i+shift)%63));
                  }
                  else if((shift + i > 62) && (shift  + i <= 72)) 
                  {
                     nI =(shift + i) - 10;
                     alphaMap.put(alphabet.charAt(i),alphabet.charAt((nI%63)));
                  }
                   else if((shift + i > 72) && (shift  + i <= 82))
                  {
                     nI =(shift + i) - 20;
                     alphaMap.put(alphabet.charAt(i), alphabet.charAt((nI%63))); 
                  }
                  else
                  {
                     nI =(shift + i) - 30;
                     alphaMap.put(alphabet.charAt(i),alphabet.charAt((nI%63)));
                  }
                               
               }
               else
               {
                   alphaMap.put(alphabet.charAt(i),alphabet.charAt((i)));
               }
            }   
          
            
					 
           
            //Get input text	
			   String inputText	= inputTA.getText();
				String outputText =	"";
				
            //Go	to	each letter	and switch it with it's	shifted counterpart
				for(int	j=0; j<inputText.length();	j++)
            {
					outputText = outputText.concat(alphaMap.get(inputText.charAt(j)).toString());
				   
            }
				//Output the encrypted	text
				outputTA.setText(outputText);
		  }
		 
		  public	void decryptText() throws InterruptedException
        {
					 HashMap<Character, Character> alphaMap =	new HashMap<Character, Character>();
					 int shift;
                int nI = 0;
                
					 String textNum =	this.shiftFactor.getText();
					 if(!textNum.equals(""))
                {
								shift	= Integer.parseInt(textNum)%63;
					 }
					 else
                {
								shift	= 0;
					 }
					 
                for(int	i=0; i<alphabet.length(); i++){
					 {
					   if((i >=1) && (i <= 26))
                  {
                     if (shift + i <= 26)
                     {
                        alphaMap.put(alphabet.charAt((i+shift)%63), alphabet.charAt(i));
                     }
                     else
                     {
                        nI = shift + i - 26;
                        alphaMap.put(alphabet.charAt((nI%63)),alphabet.charAt(i));
                     }
                  }
                  else if((i > 26) && (i  <= 52))
                  {
                     if(shift + i <= 52)
                     {
                        alphaMap.put(alphabet.charAt((i+shift)%63), alphabet.charAt(i));
                     }
                     else
                     {                        
                        nI = ((shift + i) - 26);
                        alphaMap.put(alphabet.charAt((nI%63)), alphabet.charAt(i));
                     }  
                  }
   			      
                 else if(i > 52 && i <= 62)
                 {
                     int c = shift + i;
                     
                     if(c <= 62)
                     {
                        alphaMap.put(alphabet.charAt((i+shift)%63), alphabet.charAt(i));
                     }
                     else if((c > 62) && (c <= 72)) 
                     {
                        nI = c - 10;
                        alphaMap.put(alphabet.charAt((nI%63)), alphabet.charAt(i));
                     }
                     else if((c > 72) && (c <= 82))
                     {
                        nI = c - 20;
                        alphaMap.put(alphabet.charAt((nI%63)), alphabet.charAt(i)); 
                     }
                     else
                     {
                        nI = c - 30;
                        alphaMap.put(alphabet.charAt((nI%63)), alphabet.charAt(i));
                     }
                  
                  }
                  else
                  {
                     alphaMap.put(alphabet.charAt(i),alphabet.charAt((i)));
                  }
          
               
                 }
      }
                   
					 String inputText	= inputTA.getText();
					 String outputText =	"";
					 
                for(int	j=0; j<inputText.length();	j++)
                {
							outputText = outputText.concat(alphaMap.get(inputText.charAt(j)).toString());
					 }
					 outputTA.setText(outputText);
		  }
		 
		  public	Caesar_GUI(){
					 setTitle("Caesar Cipher");
				setVisible(true);
				setDefaultCloseOperation(3);
 
				Container content	= getContentPane();
				GridLayout layout	= new	GridLayout(3, 0, 0, 10);
				content.setLayout(layout);
 
				inputTA = new JTextArea("Insert the text to be encrypted/decrypted here, then press the appropriate button.", 12,	40);
				inputTA.setLineWrap(true);
				inputTA.setWrapStyleWord(true);
				inputTA.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));
				JScrollPane	scroller	= new	JScrollPane(inputTA);
				scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				content.add(scroller);
			  
				outputTA	= new	JTextArea("Output text.",12, 40);
				outputTA.setLineWrap(true);
				outputTA.setWrapStyleWord(true);
				outputTA.setBorder(BorderFactory.createEmptyBorder(4,	4,	4,	4));
				JScrollPane	scroller2 =	new JScrollPane(outputTA);
				scroller2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				content.add(scroller2);
			  
				JPanel box1	= new	JPanel();
				box1.setLayout(new FlowLayout());
				JButton decryptButton =	new JButton("Decrypt");
				JButton encryptButton =	new JButton("Encrypt");
				decryptButton.addActionListener(this);
				encryptButton.addActionListener(this);
				box1.add(decryptButton);
				box1.add(encryptButton);
				box1.add(new JLabel("Shift Factor (1-26)"));
				box1.add(this.shiftFactor = new JTextField(20));
				content.add(box1);
			  
				pack();
		  }
 
		  @Override
		  public	void actionPerformed(ActionEvent	e)	{
					 if(e.getActionCommand().equals("Encrypt")){
								try{
										  encryptText();
								}
								catch(InterruptedException	e1){
										  e1.printStackTrace();
								}
					 }
					 if (e.getActionCommand().equals("Decrypt"))
							 try {
								decryptText();
							 }	catch	(InterruptedException e1) {
								e1.printStackTrace();
							 }
		  }
}

