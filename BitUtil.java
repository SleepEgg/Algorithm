package com.Algorithm;

public class BitUtil {

    public static String StringToBytes(String source){
        int weishu =source.length()%16==0?source.length()/16:
                source.length()/16+1;
        //111111111  9
        String strResult="";
        for(int j=0;j<weishu;j++){
            char result = 0;
            String tempSource = "";
            if(j!=weishu-1){
                tempSource = source.substring(source.length()-16*(j+1),source.length()-16*(j+1)+16);
            }else{
                tempSource = source.substring(0,source.length()-16*j);
            }
            for(int i=0;i<tempSource.length();i++){
                char temp =(char)(tempSource.charAt(tempSource.length()-1-i)-48);
                temp = (char)(temp<<i);
                result =(char)(result+temp);
            }
            strResult =result+strResult;

        }
        return strResult;

    }
    public static int getValueByPos(String source,int pos){
        int index = (pos%16==0?pos/16:(pos/16+1))-1;
        char ctemp = source.charAt(source.length()-index-1);

        int num = 1<<(pos-1)%16;
        int result = (ctemp&num)>>((pos-1)%16);
        return result;
    }

}
