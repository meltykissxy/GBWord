import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.Random;

public class GBWordMaker {

    public static void main(String[] args) throws IOException, InterruptedException {
        Random random = new Random();
        FileSystem fileSystem = FileSystem.get(URI.create("hdfs://hadoop100:9820"), new Configuration(), "atguigu");
        BufferedOutputStream fos = new BufferedOutputStream(fileSystem.create(new Path("/flowbeanInput/lrn1.txt")));
        for (int i = 0; i < 100000000; i++) {
            fos.write(String.valueOf(random.nextInt(9999)).getBytes());
            fos.write('\t');
            fos.write(String.valueOf(random.nextInt(99)).getBytes());
            fos.write('\t');
            fos.write(String.valueOf(random.nextInt(9)).getBytes());
            fos.write('\n');
        }

        fos.close();
    }

}