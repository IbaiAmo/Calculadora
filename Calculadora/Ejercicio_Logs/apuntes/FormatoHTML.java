package apuntes;

import java.util.ArrayList;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class FormatoHTML extends Formatter {

	@Override
	public String format(LogRecord record) {
		
		String [] datos = record.getMessage().split(",");
		
		return "<tr>\n "
				+ "<td>"+datos[0]+"</td>\n "
				+ "<td>"+datos[1]+"</td>\n "
				+ "<td>"+datos[2]+"</td>\n"
				+ "<td>"+datos[3]+"</td>\n"
				+ "</tr>";
	}
	@Override
    public String getHead(Handler h) {
        return "<HTML>\n"+ "<head>\n" + "<link rel=\"stylesheet\" href=\"estilos.css\">\n" + "</head>\n" + "<BODY>\n" + 
    "<table>\n <tr> \n <th>Operacion</th>\n <th>Operando1</th> \n <th>Operando2</th> \n <th>Resultado</th>\n </tr>\n";
    }
	@Override
    public String getTail(Handler h) {
        return "</table>\n" + "</BODY>\n" + "</HTML>\n";
    }
}
