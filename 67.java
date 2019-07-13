class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        String result = "";
        int flag = 0;
        while(aLen > 0 && bLen > 0){
        	int cnt = 0;
        	if(a.charAt(aLen-1) == '1'){
        		++cnt;
        	}
        	if(b.charAt(bLen-1) == '1'){
        		++cnt;
        	}
        	if(flag == 1){
        		++cnt;
        	}
        	switch (cnt) {
        		case 0 :
        			result = "0" + result;
        			flag = 0;
        			break;
        		case 1 :
        			result = "1" + result;
        			flag = 0;
        			break;
        		case 2 :
        			result = "0" + result;
        			flag = 1;
        			break;
        		case 3 :
        			result = "1" + result;
        			flag = 1;
        			break;
        	}
        	--aLen;
        	--bLen;
        }
        while(aLen > 0){
        	if(flag == 1){
        		if(a.charAt(aLen-1) == '1'){
        			result = "0" + result;
        			flag = 1;
        		}
        		else{
        			result = "1" + result;
        			flag = 0;
        		}
        	}
        	else{
        		result = a.charAt(aLen-1) + result;
        	}
        	--aLen;
        }
        while(bLen > 0){
        	if(flag == 1){
        		if(b.charAt(bLen-1) == '1'){
        			result = "0" + result;
        			flag = 1;
        		}
        		else{
        			result = "1" + result;
        			flag = 0;
        		}
        	}
        	else{
        		result = b.charAt(bLen-1) + result;
        	}
        	--bLen;
        }
        if(flag == 1){
        	result = "1" + result;
        }
        return result;
    }
}