class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
    	/*
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len1 = nums1.length;
        int len2 = nums2.length;
        int i = 0, j = 0;
        List<Integer> ret = new ArrayList<>();
        while(i < len1 && j < len2) {
        	if (nums1[i] == nums2[j]) {
        		ret.add(nums1[i]);
        		++i;
        		++j;
        	}else if (nums1[i] < nums2[j]) {
        		++i;
        	} else {
        		++j;
        	}
        }
        int[] result = new int[ret.size()];
        for(int k = 0; k < ret.size(); ++k) {
        	result[k] = ret.get(k);
        }
        return result;
        */
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num : nums1) {
        	if (map1.containsKey(num)) {
        		map1.put(num, map1.get(num) + 1);
        	} else {
        		map1.put(num, 1);
        	}
        }

        for (int num : nums2) {
        	if (map2.containsKey(num)) {
        		map2.put(num, map2.get(num) + 1);
        	} else {
        		map2.put(num, 1);
        	}
        }

		List<Integer> ret = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map1.entrySet()) {
        	if (map2.containsKey(entry.getKey())) {
        		int cnt = Math.min(entry.getValue(), map2.get(entry.getKey()));
        		while(cnt > 0) {
        			ret.add(entry.getKey());
        			--cnt;
        		}
        	}
        }

        int[] result = new int[ret.size()];
        for(int k = 0; k < ret.size(); ++k) {
        	result[k] = ret.get(k);
        }
        return result;

    }
}