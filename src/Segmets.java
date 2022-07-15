public class Segmets {

    static int maximizeCuts(int l,int x)
    {
        if(l == 0){
            return 0;
        }
        else if(l < 0){
            return -1;
        }

        return maximizeCuts(l-x,x)+1;
    }
    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}
