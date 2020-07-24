package suporte;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Generator {
    public static String dataHoraParaArquivo(){
        Timestamp timestampAtual = new Timestamp(System.currentTimeMillis());
        return new SimpleDateFormat("yyyyMMddhhmmss").format(timestampAtual);
    }
}
