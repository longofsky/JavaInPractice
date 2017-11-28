package cd.litl.copyFolder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class CopyFolder
{
    
    //允许复制的文件类型
    public static String[]              filterFile = { ".java", ".xml", ".properties", ".class", ".js", ".jsp", ".png", ".jpg", ".jar", ".html", ".css", ".ftl"};
    
    private static long                 total      = 0;
    
    //源路径
    private static String               srcStr     = "C:\\D\\Workspaces\\MyProject\\SSVB";//\\WebContent\\WEB-INF\\classes
    
    //输出路径
    private static String               destStr    = "C:\\work\\升级包\\20170808升级包";
    
    private static String               initTime   = "";
    
    private static SimpleDateFormat     format     = new SimpleDateFormat("yyyy-MM-dd H-m-s");
    
    //设置只导出N分钟内的文件（单位毫秒）
    private static String               timeString = "2017-08-09 0-0-0";
    
    private static Date                 time       = null;
    
    private static Logger               logger     = Logger.getLogger(CopyFolder.class);
    
    private static Map<String, Boolean> filterName = new HashMap<String, Boolean>();
    //是否导出 src文件 true 导出、false 不导
    private static Boolean              flag_src   = false;
    
    public static void main(String[] args) throws Exception
    {
        time = format.parse(timeString);
        initTime = format.format(new Date());
        String answer = null;
        File src = new File(srcStr);
        destStr += "\\" + initTime + "\\";
        logger.info("destStr" + destStr);
        File des = new File(destStr);
        if ( !des.exists() )
        {
            des.mkdirs();
        }
        copyFolder(src, des, filterFile, initTime);
        
    }
    
    public static void copyByScanner() throws Exception
    {
        String initTime = "";
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入原文件夹：");
        String srcStr = scanner.next();
        System.out.println("输入目标文件夹：");
        String destStr = scanner.next();
        String answer = null;
        do
        {
            File src = new File(srcStr);
            File des = new File(destStr);
            copyFolder(src, des, filterFile, initTime);
            System.out.println("是否重新打包? y or n");
            answer = scanner.next();
        }
        while (answer.equalsIgnoreCase("Y"));
        scanner.close();
    }
    
    /** 
     * 
     * @param folder
     * @param filterFile 
     * @param status 
     * @throws Exception 
     */
    public static void copyFolder(File srcFolder, File destFolder, String[] filterFile, String initTime)
            throws Exception
    {
        String srcStrChild = srcFolder.getPath();
        String destStrChild = destFolder.getPath();
        
        //优先遍历 src
        String filePath = srcFolder.getPath();
        File srcFile = new File(filePath, "src");
        if ( srcFile.isDirectory() && filterName.size()<1 )
        {
            findUpdateFile(srcFile, filterFile, initTime);
        }
        
        File[] files = srcFolder.listFiles();
        for (File file : files)
        {
            if ( file.getPath().indexOf(".metadata") > -1 || file.getPath().indexOf(".svn") > -1
                    || file.getPath().indexOf(".settings") > -1 )
            {
                continue;
            }
            else if ( file.getPath().indexOf("maven") > -1 )
            {
                continue;
            }
            //判断是否是文件
            if ( file.isFile() )
            {
                //文件最后更新时间
                long updateTime = file.lastModified();
                
                //是否设置了过滤时间
                if ( null != initTime && !"".equals(initTime) )
                {
                    if ( updateTime - time.getTime() > 0 )
                    {
                        
                        String pathname = destFolder + File.separator + file.getName();
                        String fileName = file.getName().substring(0, file.getName().indexOf("."));
                        if( file.getName().indexOf(".xml")>-1 || file.getName().indexOf(".properties")>-1 || file.getName().indexOf(".class")>-1 ){
                            if ( filterName.size() < 1 || filterName.get(fileName) == null )
                            {
                                continue;
                            }
                        }
                        for (String suff : filterFile)
                        {
                            if ( pathname.endsWith(suff) )
                            {
                                File dest = new File(pathname);
                                File destPar = dest.getParentFile();
                                if ( !flag_src && file.getPath().indexOf("src") > -1 )
                                {
                                    continue;
                                }
                                if ( !destPar.exists() )
                                {
                                    destPar.mkdirs();
                                }
                                copyFile(file, dest);
                            }
                        }
                    }
                }
            }
            else if ( file.isDirectory() )
            {
                
                filePath = file.getPath();
                if(filterName.size()<1){
                    srcFile = null;
                    if ( filePath.indexOf("\\src") == filePath.length() - 4 )
                    {
                        srcFile = new File(filePath);
                    }
                    else
                    {
                        srcFile = new File(filePath, "src");
                    }
                    if ( srcFile.isDirectory() )
                    {
                        findUpdateFile(srcFile, filterFile, initTime);
                    }
                }
                /* 示例
                 * D:\develop\workspace\db_cms\WebRoot\WEB-INF\views
                 * \views
                 * E:\！1更新部署\2016-12-08 15-28-55\db_cms\WebRoot\WEB-INF\views
                 * */
                String filePathSub = filePath.replace(srcStrChild, "");
                String newFile = destStrChild + filePathSub;
                File fileChild = new File(newFile);
                //fileChild.mkdir();
                copyFolder(file, fileChild, filterFile, initTime);
            }
        }
    }
    
    public static void findUpdateFile(File srcFolder, String[] filterFile, String initTime)
    {
        
        String srcStrChild = srcFolder.getPath();
        File[] files = srcFolder.listFiles();
        for (File file : files)
        {
            if ( file.getPath().indexOf(".metadata") > -1 || file.getPath().indexOf(".svn") > -1
                    || file.getPath().indexOf(".settings") > -1 )
            {
                continue;
            }
            else if ( file.getPath().indexOf("maven") > -1 )
            {
                continue;
            }
            //判断是否是文件
            if ( file.isFile() )
            {
                //文件最后更新时间
                long updateTime = file.lastModified();
                
                //是否设置了过滤时间
                if ( null != initTime && !"".equals(initTime) )
                {
                    if ( updateTime - time.getTime() > 0 )
                    {
                        
                        String pathname = srcFolder + File.separator + file.getName();
                        
                        for (String suff : filterFile)
                        {
                            if ( pathname.endsWith(suff) )
                            {
                                File dest = new File(pathname);
                                File destPar = dest.getParentFile();
                                String fileName = file.getName().substring(0, file.getName().indexOf("."));
                                if ( file.getName().indexOf(".java") > -1
                                        || (file.getName().indexOf(".xml") > -1 && file.getPath().indexOf("src") > -1) )
                                {
                                    filterName.put(fileName, true);
                                    logger.info("size:" + filterName.size() + " \tadd: " + fileName);
                                }
                            }
                        }
                    }
                }
            }
            else if ( file.isDirectory() )
            {
                
                String filePath = file.getPath();
                String filePathSub = filePath.replace(srcStrChild, "");
                //fileChild.mkdir();
                findUpdateFile(file, filterFile, initTime);
            }
        }
    }
    
    /***
     * copy file
     * 
     * @param src
     * @param dest
     * @param status 
     * @throws IOException
     */
    private static void copyFile(File src, File dest) throws Exception
    {
        BufferedInputStream reader = null;
        BufferedOutputStream writer = null;
        try
        {
            reader = new BufferedInputStream(new FileInputStream(src));
            writer = new BufferedOutputStream(new FileOutputStream(dest));
            byte[] buff = new byte[reader.available()];
            while ((reader.read(buff)) != -1)
            {
                writer.write(buff);
            }
            total++;
            logger.info("copy:" + src + "\tsize:" + src.length());
            logger.info("to:" + dest + "\tsize:" + dest.length());
            logger.info("complate totoal:" + total);
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            writer.flush();
            writer.close();
            reader.close();
            
        }
    }
    
}
