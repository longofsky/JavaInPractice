package cd.litl.artOfConcurrency.util.HashModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Hash {

	public static String getServer()
    {
        // 重建一个Map，避免服务器的上下线导致的并发问题
        Map<String, Integer> serverMap = 
                new HashMap<String, Integer>();
        serverMap.putAll(IpMap.serverWeightMap);
        
        // 取得Ip地址List
        Set<String> keySet = serverMap.keySet();
        System.out.println(keySet);
        ArrayList<String> keyList = new ArrayList<String>();
        keyList.addAll(keySet);
        
        // 在Web应用中可通过HttpServlet的getRemoteIp方法获取
        String remoteIp = "127.0.0.1";
        String newIP = "192.168.1.109";
        int hashCode = remoteIp.hashCode();
        int hashCode1 = newIP.hashCode();
        System.out.println(hashCode+","+hashCode1);
        int serverListSize = keyList.size();
        int serverPos = hashCode % serverListSize;
        int serverPos1 = hashCode1 % serverListSize;
        System.out.println(serverPos+","+serverPos1);
        if(hashCode1 < 0){
        serverPos1 = Math.abs(serverPos1);
        }
        System.out.println(keyList.get(serverPos1));
        
        return keyList.get(serverPos);
    }
    
    public static void main(String args[]){
	    getServer();
//	    System.out.println(getServer());
    }
}
