import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestAQR {

    public static void main(String[] args) throws IOException {
        System.out.println(new Account().sum(1, 2));
        System.out.println(new Account().sum(1.0f, 2.0f));

        RandomAccessFile accessFile = new RandomAccessFile("abc", "r");

        long size = 1024 * 1024;
        long t = size;
        byte[] readBuffer = new byte[1024 * 1024];
        while (t < accessFile.length()) {
            accessFile.read(readBuffer);
            accessFile.seek(size);
            t += size;
        }

    }

    public void calculate(){
        toStringLamba().apply(new Integer(1));
        IntStream.range(0,10).mapToObj(k-> toStringLamba().apply(new Integer(k))).collect(Collectors.toList());
    }

    public Function<Integer, String> toStringLamba() {
        return (t) -> {
            return t.toString();
        };


    }


}

class Counter {
    int count;

    synchronized int increment() {
        return ++count;
    }

}


class Account {
    private int accountNo;
    private int customerName;

//    Account(int accountNo,int customerName){
//        this.accountNo=accountNo;
//        this.customerName=customerName;
//    }

    public int getAccountNo() {
        return accountNo;
    }

    public int getAccountNo(String a) {
        return accountNo;
    }

    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public int getCustomerName() {
        return customerName;
    }

    public void setCustomerName(int customerName) {
        this.customerName = customerName;
    }

    // abstract int deposit();
    // abstract int deduct();


}


