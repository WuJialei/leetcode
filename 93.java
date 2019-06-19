class Solution {

	private List<String> res = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {
        if(s == null || s.length() == 0){
        	return res;
        }
        if(s.length() < 4 || s.length() > 12){
        	return res;
        }
        dfs(s, 0, "");
        return res;
    }

    public void dfs(String pattern, int cnt, String path){
    	if(cnt == 4 || pattern.length() == 0){
    		if(cnt == 4 && pattern.length() == 0){
    			res.add(path);
    			return;
    		}    		
    	}
    	for(int t = 0; t < 3 && t < pattern.length(); ++t){
			if(t != 0 && pattern.charAt(0) == '0'){
				return;
			}
			String temp = pattern.substring(0, t+1);
			if(Integer.valueOf(temp) <= 255){
				String curPath = path.length()==0 ? temp : path + "." + temp;
				dfs(pattern.substring(t+1), cnt+1, curPath);
			}
    	}
    	return;
    }

}