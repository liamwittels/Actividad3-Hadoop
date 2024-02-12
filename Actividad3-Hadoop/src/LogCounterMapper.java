import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class LogCounterMapper extends Mapper<LongWritable, Text, Text, LongWritable> {
    private final static LongWritable one = new LongWritable(1);
    private Text word = new Text();

    public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        // Obtener la línea de texto
        String line = value.toString();

        // Dividir la línea en palabras
        String[] tokens = line.split("\\s+");

        // Verificar si la línea contiene [INFO], [SEVERE] o [WARN]
        if (tokens.length > 2 && tokens[1].equals("[INFO]")) {
            word.set("[INFO]");
            context.write(word, one);
        } else if (tokens.length > 2 && tokens[1].equals("[SEVERE]")) {
            word.set("[SEVERE]");
            context.write(word, one);
        } else if (tokens.length > 2 && tokens[1].equals("[WARN]")) {
            word.set("[WARN]");
            context.write(word, one);
        }
    }
}
