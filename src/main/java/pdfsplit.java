import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;
//PDF_SPLITTER
public class pdfsplit {

	public static void main(String[] args)throws IOException {
		//TO SPLIT THE PDF IN A SPECIFIED RANGE use the splitter setStart and EndPage methods 
		File oldfile = new File("C:\\Users\\vinay\\Downloads\\MM.pdf");
		PDDocument document  = PDDocument.load(oldfile);
		File newFileDest = new File("D:\\New folder\\");
		newFileDest.mkdirs();
		Splitter splitter  = new Splitter();
		splitter.setStartPage(4);
		splitter.setEndPage(14);
		List<PDDocument> splitPages = splitter.split(document);
		int num = 1;
		PDDocument newDoc = new PDDocument();
		for(PDDocument mydoc : splitPages)
		{
			/*mydoc.save("D:\\New folder\\"+num+".pdf");
			num++;
			mydoc.close();*/
			
			newDoc.addPage(mydoc.getPage(0));
		}
		newDoc.save(newFileDest+"//split.pdf");
		newDoc.close();
		System.out.println("SPLIT DONE SUCCESSFULLY");
		
		}

	}

