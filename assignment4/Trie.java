/**
 * 
 */
package assignment4;

/**
 * @author Pooja
 *
 */
public class Trie {

	/**
	 * @param args
	 * 
	 * 			h o m e s i c k
	 * 			s			  e
	 	wordStart			wordEnd
	 		
	 		*/
	static final int alphabetSet = 26;
	
	static class Node{
		Node[] childNode = new Node[alphabetSet];
		boolean wordEnd;
		public Node() {
			// TODO Auto-generated constructor stub
			wordEnd=false;
			for (int i = 0; i < alphabetSet; i++) {
				childNode[i]=null;
			}
		}
	};
	
	static Node root;
	
	public static void wordInsert(String word){
		Node current=root;
		System.out.println("current node: "+current.toString());
		int size=word.length();	//size of word
		System.out.println("word size: "+size);
		int i;	// level of trie tree
		int index;	// paragraph no.
		for ( i = 0; i < size; i++) {
			i=word.charAt(i) - 'a';
			if(current.childNode[i]==null){
				current.childNode[i]= new Node();
			}
			current.wordEnd=true;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hi");
//		String  inputText="This will require the consumers to be savvier and impose some reins on the on-line buccaneers with deep pockets.\r\nData brokers have had an unrestricted field to exploit personal public and not so public data for private gain.";
		
		// Input keys (use only 'a' through 'z' and lower case) 
        String keys[] = {"the", "a", "there", "answer", "any", 
                         "by", "bye", "their"}; 
       
        String output[] = {"Not present in trie", "Present in trie"}; 
       
       
        root = new Node(); 
       
        // Construct trie 
        int i; 
        for (i = 0; i < keys.length ; i++) 
        	System.out.println(keys[i]);
            wordInsert(keys[i]); 
		
	}

}
