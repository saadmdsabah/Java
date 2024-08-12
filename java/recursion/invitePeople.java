public class invitePeople {


    public static int invitePeopleP(int n){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        int nm1 = invitePeopleP(n-1);
        int nm2 = (n-1)*invitePeopleP(n-2);
        return nm1 + nm2;
    }
    public static void main(String[] args) {
        System.out.println(invitePeopleP(4));
    }
}
