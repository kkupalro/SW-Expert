import java.io.*;
import java.util.*;

class Solution {
	static int height = -1;
	static void search(Tree node, int ans){
		if (node!=null) 
		{
			if (node.l != null)
			{
				if(node.x < node.l.x)
				{
					search(node.l, ans + 1);
				}
			}
			if (node.r != null) 
			{
				if(node.x < node.r.x)
				{
					search(node.r, ans + 1);
				}
			}
			return;
		}
		// 기저 사례
		height = Math.max(height, ans + 1);
		return;
	}
	public int solution(Tree T) {
		if (T == null) return height;
		search(T, 0);
		return height;
	}
}
