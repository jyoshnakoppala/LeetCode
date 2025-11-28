class Solution {
    HashMap<Character, String> map=new HashMap<>();
    public List<String> letterCombinations(String digits) {

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> newseq=new ArrayList<>();
        recur(digits, 0, "", newseq);
        return newseq;
    }
    public void recur(String digits, int index, String cur, List<String> newseq)
    {
        if(index==digits.length())
        {
            newseq.add(cur);
            return;
        }
        String curalpha=map.get(digits.charAt(index));
        for(int i=0;i<curalpha.length();i++)
        {
            cur+=curalpha.charAt(i);  
            recur(digits, index+1, cur, newseq);
            cur=cur.substring(0, cur.length()-1);
        }

    }
}