import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Boolean> map1 = new HashMap<Integer, Boolean>();
        Map<Integer, Boolean> map2 = new HashMap<Integer, Boolean>();
        for (Integer i : nums1) {
        	map1.put(i, true);
        }
        
        for (Integer i : nums2) {
        	map2.put(i, true);
        }
        int[] ret = new int[Math.min(map1.keySet().size(), map2.keySet().size())];
        int cnt = 0;
        Set<Integer> keys = map1.keySet();
        for (Integer key : keys){
        	if (map2.containsKey(key)) {
        		ret[cnt++] = key;
        	}
        }
        int[] tmp = new int[cnt];
        for (int i = 0; i < cnt; i++) {
        	tmp[i] = ret[i];
        }
        return tmp;
    }
    
    public static String formatDate (Date d, String format) {
    	SimpleDateFormat sdf = new SimpleDateFormat(format);
    	return sdf.format(d);
    }
    
    public static void main (String[] args) {
    	Date currentDate = new Date();
    	int[] a = new int[] {1,2,2,23,23,4,345,65,7,42,789,2,89};
    	int[] b = new int[] {2,3,45,2,34,5,67,7,677,6,7678,8989,9,0,};
    	int[] result = intersection(a, b);
    	
    	System.out.println(formatDate(currentDate, "yyyy-MM-dd HH:mm:ss"));
    	try {
    		long start = System.currentTimeMillis();
    		for (int i = 0; i < Integer.MAX_VALUE; i++){
    			if (i == Integer.MAX_VALUE-1) {
    				for (int el : result) {
                		System.out.println(el);
                	}
    			}
    		}
    		long end = System.currentTimeMillis();
    		
    		System.out.println("Time ellapses " + (end - start));
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}