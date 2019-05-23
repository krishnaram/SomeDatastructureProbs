
public class Nishant {

	public static void main(String[] args) {
		char[][] array = new char [4][4];
		String str = "mississippi";
		array = prepareArray(array, str);
		String searshString = "pp";
		int count = findSubstring(array, searshString);
		System.out.println("Left right repetition is :"+count);
	}
	
	public static char[][] prepareArray(char[][] array ,String str){
		int len = 0;
		if(str !=null && str.length() >=1) {
			for(int i =0;i<array.length;i++) {
				for(int j =0;j<array[i].length;j++) {
					if(str.length() >= len+1) {
					array[i][j] = str.charAt(len);
					len++;
					}
					else {
						len = 0;
						array[i][j] = str.charAt(len);
						len++;
					}
				}
			}
		}
		return array;
	}

	public static int findSubstring(char[][] array ,String str){
		int count =0;
		if(str !=null && str.length() >=1) {
			for(int i =0;i<array.length;i++) {
				for(int j =0;j<array[i].length;j++) {
					if(array[i][j] == str.charAt(0)) {
						if(str.length()>1) {
							if(searchLeftRight(array, str, 1, i, j+1)) {
								count++;
							}
						}
						else {
							count++;
						}
						
					}
				}
			}
		}
		return count;
	}
	
	public static boolean searchLeftRight(char[][] array,String str,int initial,int i, int j) {
		if(i>array.length-1 || j>array[i].length-1) {
			return false;
		}
		if((initial == str.length()-1) 
				&& str.charAt(initial) == array[i][j]) {
			return true;
		}
		else if((initial <= str.length()-1) &&  str.charAt(initial) == array[i][j]){
			return searchLeftRight(array,str,initial+1,i,j+1);
		}
		
		return false;
	}
}
