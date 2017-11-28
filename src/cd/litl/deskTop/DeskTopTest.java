package cd.litl.deskTop;

import java.awt.Desktop;  
import java.io.File;  
import java.net.URI;  
  
  
  
public class DeskTopTest {  
      
    private static Desktop desktop;  
  
    //ʹ��Ĭ�ϵ����������ҳ  
    public static void browse(){  
        if (Desktop.isDesktopSupported()) {  
            desktop = Desktop.getDesktop();  
            try {  
                //URIָ����ҳ�ĵ�ַ  
                desktop.browse(new URI("http://blog.csdn.net/dlutbrucezhang?viewmode=contents"));  
            } catch (Exception e) {  
                // TODO: handle exception  
                e.printStackTrace();  
            }  
        }  
    }  
      
    //�༭�ļ�  
    public static void edit(){  
        if (Desktop.isDesktopSupported()) {  
            desktop = Desktop.getDesktop();  
            try {  
                desktop.edit(new File("C:\\test\\deskTop.txt"));  
            } catch (Exception e) {  
                // TODO: handle exception  
                e.printStackTrace();  
            }  
        }  
    }  
      
    //���ļ������ͱ༭�ļ��Ĺ������ƣ������ܿ����ļ�����ʾ  
    public static void open() {  
        if (Desktop.isDesktopSupported()) {  
            desktop = Desktop.getDesktop();  
            try {  
                desktop.open(new File("C:\\test\\deskTop.txt"));  
            } catch (Exception e) {  
                // TODO: handle exception  
                e.printStackTrace();  
            }  
        }  
    }  
      
    //��ӡָ�����ļ�  
    public static void print() {  
        if (Desktop.isDesktopSupported()) {  
            desktop = Desktop.getDesktop();  
            try {  
                desktop.print(new File("C:\\test\\deskTop.txt"));  
            } catch (Exception e) {  
                // TODO: handle exception  
                e.printStackTrace();  
            }  
        }  
    }  
      
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
  
//        browse();  
//        edit();  
        open();  
//        print();  
    }  
  
}
