public class maxArea {

    public static void main(String[] args) {

        int[] a = new int[]{1, 8,6,2,5,4,8,3,7};
        System.out.println(maxArea(a));

    }


    public static int maxArea(int[] height) {


        if (height.length == 0 || height.length == 1){
            return 0;
        }

        if (height.length == 2){
            return Math.min(height[0], height[1]);
        }

        int result = 0;
        for (int i = 0; i < height.length; i++){
            for (int j = i + 1; j < height.length; j++){
                result = Math.max((j - i) * Math.min(height[i], height[j]), result);
            }
        }


        return result;
    }
}
