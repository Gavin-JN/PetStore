package persistence;

import java.io.*;

public class logWriter {
    public void Writer(String log)
    {
        File file= new File("D:\\IDPJ\\StoreWebProject\\log.txt");

        FileWriter fw=null;
        try{
            if(!file.exists())
            {
                file.createNewFile();
            }
            fw = new FileWriter(file,true);
            fw.write(log);
            fw.flush();
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void addNum()
    {
        File file= new File("D:\\IDPJ\\StoreWebProject\\totalLook.txt");
        FileWriter fw=null;
        FileReader fr=null;
        try{
            if(!file.exists())
            {
                file.createNewFile();
            }
            fr=new FileReader(file);
            BufferedReader br=new BufferedReader(fr);
            String line=br.readLine();
                if(line==null||line.equals(""))
                {
                    fw.write("0");
                    fw.flush();
                    fw.close();
                    fr.close();
                    return;
                }
                int num = Integer.parseInt(line);
                num++;
                fw=new FileWriter(file);
                line = String.valueOf(num);
                fw.write(line);
                fw.flush();
                fw.close();
                fr.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
