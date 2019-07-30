class Solution {
    public boolean isValid(String s) {
        if(s == null || s.length() == 0){
        	return true;
        }
        Stack<Character> myStack = new Stack<Character>();
        for(char temp : s.toCharArray()){
        	if(temp == '(' || temp == '{' || temp == '['){
        		myStack.push(temp);
        	}
        	else{
                if(myStack.empty()){
                    return false;
                }
        		char top = myStack.pop();
        		if((temp == ')' && top != '(') || (temp == '}' && top != '{') || (temp == ']' && top != '[')){
        			return false;
        		}
        	}
        }
        return myStack.empty();
    }
}