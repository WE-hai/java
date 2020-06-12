package 数组中出现了一次的数字;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Test {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            //这块不是很懂，使用nextInt接收个数时，还未输入具体数字 nextLine后面的代码也会执行
            String s=sc.nextLine();
            String s1=sc.nextLine();
            String[]  ss=s1.split(" ");
            Map<String,Integer> mm=new HashMap<String,Integer>();
            for(int i=0;i<ss.length;i++){
                //偶数最终将不在map中
                if(mm.containsKey(ss[i])){
                    mm.remove(ss[i]);
                }else{
                    mm.put(ss[i],1);
                }
            }
            Set<Map.Entry<String,Integer>> es=mm.entrySet();
            int [] arr=new int[2];
            for(Map.Entry<String,Integer>  en:es){
                if(arr[0]==0){
                    arr[0]=Integer.parseInt(en.getKey());
                }else{
                    arr[1]=Integer.parseInt(en.getKey());
                }
            }
            if(arr[0]>arr[1]){
                arr[0]=arr[0]^arr[1];
                arr[1]=arr[0]^arr[1];
                arr[0]=arr[0]^arr[1];
            }
            System.out.println(arr[0]+" "+arr[1]);
        }

    }
}
