/**
 * 
 */
package assignment4;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import assignment4.ReadFileToString;
/**
 * @author Pooja
 *
 */
public class FileSelecter {

	/**
	 * @param args
	 * @return 
	 */
	public static String fsDialog() {
		// TODO Auto-generated method stub
		final JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(
		                "TEXT FILES", "txt");
		        fc.setFileFilter(filter);
		        int returnVal = fc.showOpenDialog(null);
		        if(returnVal == JFileChooser.APPROVE_OPTION) {
		            System.out.println("You've selected: " + fc.getSelectedFile().getName());
		        }
		        String file_path=fc.getSelectedFile().getAbsolutePath();
		       String s= ReadFileToString.readingFile(file_path);
		return s;
				
	}

}
