public class PrimeArray3_7 {
    public static void main(String[] args) {
        int[] numbers = {27, 84, 6, 59, 42, 91, 15, 73};
        int primeCount = countPrimes(numbers);
        System.out.println("Numbers of prime numbers in the array: "+primeCount);
    }
    public static boolean isPrime(int num){
        if(num <= 1){
            return false;
        }
        for(int i = 2; i <= Math.sqrt(num); i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
    public static int countPrimes(int[] arr){
        int count = 0;
        System.out.print("Prime numbers in the array are: ");
        for(int numbers : arr){
            if(isPrime(numbers)){
                System.out.print(numbers+" ");
                count++;
            }
        }
        System.out.println();
        return count;
    }
}
