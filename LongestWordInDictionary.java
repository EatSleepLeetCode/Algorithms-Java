class LongestWordInDictionary 
{
    public String longestWord(String[] words) 
    {
        Set<String> buildSet = new HashSet<String>();
        String result = "";
        Arrays.sort(words);
        
        for (String str : words)
        {
            if (str.length() == 1 || buildSet.contains(str.substring(0, str.length() - 1)))
            {
                if (str.length() > result.length()) result = str;
                buildSet.add(str);
            }
        }
        return result;
    }
}
