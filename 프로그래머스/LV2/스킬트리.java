class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i = 0; i < skill_trees.length; i++)
        {
            boolean flag = true;
            int cur = 0;
            for(int j = 0; j < skill_trees[i].length(); j++)
            {
                char c = skill_trees[i].charAt(j);
                if(cur >= skill.length()) break;
                if(c == skill.charAt(cur))
                {
                    cur++;
                }
                else
                {
                    for(int k = cur+1; k < skill.length(); k++)
                    {
                        if(c == skill.charAt(k))
                        {
                            flag =  false;
                            break;
                        }
                    }   
                }
            }
            answer = flag?answer+1:answer;
        }
        return answer;
    }
}
