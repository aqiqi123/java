import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileStudy {
    public static void main(String[] args){
        //先学习文件写入,用FileWriter和BufferedWriter
        //先创建一个文件，用File
        File file=new File("fileTest.txt");
        try{
            boolean isCreated=file.createNewFile();

            if(isCreated){
                System.out.println("文件创建成功");
            }else {
                System.out.println("文件已存在");
            }
        }catch(Exception e){
            //用Logger来显示异常，有很多好处
            Logger logger=Logger.getLogger(FileStudy.class.getName());
            logger.log(Level.SEVERE,"文件创建失败",e);

        }

        //下面开始学习文件的输入流和输出流
        //这个代码是try-with-resources语句,把我们打开的外部资源放到try后面，可以实现资源自动关闭的功能
        try(InputStream in= Files.newInputStream(file.toPath())){
            int data;
            while((data=in.read())!=-1){
                System.out.println((char)in.read());
            }
        }catch(IOException e){
            Logger logger=Logger.getLogger(FileStudy.class.getName());
            logger.log(Level.SEVERE,"无法读取文件",e);
        }


        //学Scanner类,用于获取用户输入
        Scanner scanner=new Scanner(System.in);

        //Next可以改为NextLine，前者不能得到带有空格的字符串，后者是返回输入回车前的所有字符
        if(scanner.hasNext()){
            String line=scanner.next();
            System.out.println(line);
        }
        scanner.close();


    }
}
