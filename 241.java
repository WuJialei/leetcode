class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        int len = input.length();
        for(int i = 0; i < len; ++i){
        	if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
        		List<Integer> left = diffWaysToCompute(input.substring(0, i));
        		List<Integer> right = diffWaysToCompute(input.substring(i+1));
        		for(Integer a : left){
        			for(Integer b : right){
        				switch (input.charAt(i)){
        					case '+':
        						res.add(a+b);
        						break;
        					case '-':
        						res.add(a-b);
        						break;
        					case '*':
        						res.add(a*b);
        						break;
        				}
        			}
        		}
        	}
        }
        if(res.size() == 0){
        	res.add(Integer.valueOf(input));
        }
        return res;
    }
}