class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>(){
        	public int compare(int[] a, int[] b){
        		if(a[0] == b[0]){
        			return a[1] - b[1];
        		}
        		return b[0] - a[0];
        	}
        });
        List<int[]> temp = new ArrayList<int[]>();
        for(int i = 0; i < people.length; ++i){
        	temp.add(people[i][1], new int[]{people[i][0], people[i][1]});
        }
        int[][] reslut = new int[people.length][2];
        for(int i = 0; i < people.length; ++i){
        	reslut[i][0] = temp.get(i)[0];
        	reslut[i][1] = temp.get(i)[1];
        }
        return reslut;
    }
}