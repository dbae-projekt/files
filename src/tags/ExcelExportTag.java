package tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ExcelExportTag  extends SimpleTagSupport {

	public void doTag() {
		
		JspWriter out = getJspContext().getOut();
		
		try {
			out.println("<script type=\"text/javascript\" src=\"jquery.min.js\"></script>\r\n" + 
					"<script type=\"text/javascript\" src=\"jquery.table2excel.js\"></script>\r\n" + 
					"	<script>\r\n" + 
					"	\r\n" + 
					"	/* Getestet in Opera, FireFox und Google Chrome, in Internet Explorer funktioniert es leider nicht.\r\n" + 
					"	*/\r\n" + 
					"	\r\n" + 
					"		function exportTableToExcel(tableID, filename = '') {\r\n" +
					"   		var downloadLink;\r\n" + 
					"    		var dataType = 'application/vnd.ms-excel';\r\n" + 
					"    		var tableSelect = document.getElementById(tableID);\r\n" + 
					"    		var tableHTML = tableSelect.outerHTML.replace(/ /g, '%20');\r\n" + 
					"    \r\n" + 
					"    		// Dateinamen angeben\r\n" + 
					"    		filename = filename?filename+'.xls':'excel_data.xls';\r\n" + 
					"    \r\n" + 
					"    		//Download-Link erzeugen\r\n" + 
					"    		downloadLink = document.createElement(\"a\");\r\n" + 
					"    \r\n" + 
					"    		//Download-Link Postfix dran\r\n" + 
					"    		document.body.appendChild(downloadLink);\r\n" + 
					"    \r\n" + 
					"    		if(navigator.msSaveOrOpenBlob){\r\n" + 
					"        		var blob = new Blob(['\\ufeff', tableHTML], {\r\n" + 
					"            		type: dataType\r\n" + 
					"        		});\r\n" + 
					"        		navigator.msSaveOrOpenBlob( blob, filename);\r\n" + 
					"    		} else {\r\n" + 
					"        		//Download-Link zur gewünschten Daten\r\n" + 
					"        		downloadLink.href = 'data:' + dataType + ', ' + tableHTML;\r\n" + 
					"    \r\n" + 
					"        		//Setten vom File-Name\r\n" + 
					"       			downloadLink.download = filename;\r\n" + 
					"        \r\n" + 
					"        		//funktion getriggert durch Button\r\n" + 
					"        		downloadLink.click();\r\n" +
					"    		}\r\n" + 
					"		}\r\n" + 
					"	</script>");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
