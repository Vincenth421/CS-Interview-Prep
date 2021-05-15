/***
* Mostly problems from Leetcode since I use Java for Leetcode.
***/
class JavaAlgs{

     /** Array Algorithms **/

     //Find 2 numbers in num that sum to given target.
     public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];

        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(target - nums[i] == nums[j]){
                    solution[0] = i;
                    solution[1] = j;
                }
            }
        }

        return solution;
    }

    public List<List<Integer>> threeSum(int[] nums) {
         List<List<Integer>> res = new ArrayList<>();
         Arrays.sort(nums);

         for (int i = 0; i < nums.length - 2; i++)
         {
              if (i > 0 && nums[i] == nums[i - 1])
              {
                   // skip same result
                   continue;
              }

              int j = i + 1;
              int k = nums.length - 1;
              int target = -nums[i];

              while (j < k)
              {
                   if (nums[j] + nums[k] == target)
                   {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));

                        j++;
                        k--;
                        while (j < k && nums[j] == nums[j - 1]) j++;  // skip same result
                        while (j < k && nums[k] == nums[k + 1]) k--;  // skip same result

                   } else if (nums[j] + nums[k] > target) {
                        k--;
                   } else {
                        j++;
                   }
              }
         }
         return res;
    }

    //Returns the k most frequent elements in array nums.
    public int[] topKFrequent(int[] nums, int k) {
        // O(1) time
        if (k == nums.length) {
            return nums;
        }

        // 1. build hash map : character and how often it appears
        // O(N) time
        Map<Integer, Integer> count = new HashMap();
        for (int n: nums) {
          count.put(n, count.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        Queue<Integer> heap = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: count.keySet()) {
          heap.add(n);
          if (heap.size() > k) heap.poll();
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    /** Tree Algorithms **/

    //Find the max depth of a tree.
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /** String Algorithms **/

    //Given String, find length of longest substring without repeating characters.
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //Given a standard keypad with letters, generate all possible strings given a string of digits.
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.length() == 0) return res;

        String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if(digits.length() == 1)
        {
            String letters = map[Character.getNumericValue(digits.charAt(0))];
            for(int i = 0; i < letters.length(); i++)
            {
                res.add(letters.charAt(i) + "");
            }

            return res;
        }

        List<String> rest = letterCombinations(digits.substring(1));
        int num = Character.getNumericValue(digits.charAt(0));
        String letters = map[num];

        for(int i = 0; i < letters.length(); i++)
        {
            for(int k = 0; k < rest.size(); k++)
            {
                String temp = letters.charAt(i) + rest.get(k);
                res.add(temp);
            }

        }
        return res;

    }

    /**Linked List Algorithms **/

    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
         if(l1 == null) return l2;
         if(l2 == null) return l1;
         if(l1.val < l2.val){
              l1.next = mergeTwoLists(l1.next, l2);
              return l1;
         } else{
              l2.next = mergeTwoLists(l1, l2.next);
              return l2;
         }
    }

    //recursive
    public ListNode reverseListRec(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode newHeadNode = reverseList(head.next);

        // change references for middle chain
        head.next.next = head;
        head.next = null;

        // send back new head node in every recursion
        return newHeadNode;
    }

    //iterative
    public ListNode reverse(ListNode head)
    {
         ListNode prev = null;
         while (head != null) {
              ListNode next = head.next;
              head.next = prev;
              prev = head;
              head = next;
         }
         return prev;
    }


    /** Dynamic Programming **/

    //Find longest palindrome in String s using DP.
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0) return s;
        int n=s.length();
        //substring(i,j) is panlidrome
        boolean[][] dp=new boolean[n][n];
        String res = null;
        //[j, i]
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(s.charAt(i)==s.charAt(j) && (i-j<2 ||dp[j+1][i-1])){
                    dp[j][i]=true;
                    if(res==null||i-j+1>res.length()){
                      res=s.substring(j,i+1);
                    }
                }
            }
        }
        return res;
    }

    //Maximum sum subarray
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = Math.max(A[i] + dp[i - 1] , A[i]);
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    //Find how many ways to climb n steps given you can only climb 1 or 2 at a time.
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }

    /** Other Useful Algorithms **/

    //Method to find square root of x
    public int mySqrt(int x) {
        long r = x;

        while (r*r > x)
        {
            r = (r + x/r) / 2;
        }

        return (int) r;
    }

    //Common basic question
    public List<String> fizzBuzz(int n) {
        String add = "";
        List<String> arr = new ArrayList<>();

        for(int i = 1; i < n + 1; i++)
        {
            if(i % 3 == 0) add += "Fizz";
            if(i % 5 == 0) add += "Buzz";
            if(add.equals("")) add += i + "";
            arr.add(add);
            add = "";

        }

        return arr;
    }
}
