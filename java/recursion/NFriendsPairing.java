public class NFriendsPairing {
    public static int pairingFriends(int n){
        if(n == 1 || n == 2){
            return n;
        }
        return pairingFriends(n-1) + (n-1)*pairingFriends(n-2);
    }
    public static void main(String[] args) {
        System.out.println(pairingFriends(4));
    }
}
