class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map=new HashMap<>();
        HashMap<String, Character> reverseMap = new HashMap<>();

        String[] words=s.split(" ");
        if(pattern.length()!=words.length) return false;
        for(int i=0;i<words.length;i++)
        {
            if(!map.containsKey(pattern.charAt(i)))
            map.put(pattern.charAt(i), words[i]);
            else
            {
                if(!map.get(pattern.charAt(i)).equals(words[i]))
                return false;
            }

            if(!reverseMap.containsKey(words[i]))
            reverseMap.put(words[i], pattern.charAt(i));
            else
            {
                if(!reverseMap.get(words[i]).equals(pattern.charAt(i)))
                return false;
            }
        }
        return true;
    }
}