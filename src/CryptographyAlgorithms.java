import java.util.*;
import java.util.concurrent.TimeUnit;
import java.math.BigInteger;
import java.lang.Math;
import java.math.*;



public class BotticelliKatherineProject3 {


    public boolean isPrime(BigInteger p){
        boolean prime;
        prime = p.isProbablePrime(100);
        return prime; 

    }
    public void isGenerator(BigInteger p, int g){
        BigInteger q = p.subtract(BigInteger.ONE);
        
        
        BigInteger q2 = q.divide(BigInteger.valueOf(2));

        boolean prime = isPrime(q2);

        if(prime == false) {
            System.out.println( "q = (p-1)/2 is not prime. ");
        } else {
            System.out.println("0x" + q2.toString(16));
            BigInteger gen = BigInteger.valueOf(g);
            BigInteger generate = gen.modPow(q2, p);
            System.out.println( "0x" + generate.toString(16));
        }
    }
    public BigInteger publicKey(BigInteger g, BigInteger a, BigInteger p){
        BigInteger key = g.modPow(a, p);
        return key;
    }

    public void shareSecret(BigInteger p, BigInteger a, BigInteger b, int g){
        BigInteger gen = BigInteger.valueOf(g);
        BigInteger aKey = publicKey(gen, a, p);
        BigInteger bKey = publicKey(gen, b, p);
        BigInteger aSecret = bKey.modPow(a, p);
        BigInteger bSecret = aKey.modPow(b, p);
        System.out.println( "Alices Shared secret: \n0x" + aSecret.toString(16) + "\nBobs Shared Secret: \n0x" + bSecret.toString(16) );

    }


    
    public void testDH(){
        String p = "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AAAC42DAD33170D04507A33A85521ABDF1CBA64ECFB850458DBEF0A8AEA71575D060C7DB3970F85A6E1E4C7ABF5AE8CDB0933D71E8C94E04A25619DCEE3D2261AD2EE6BF12FFA06D98A0864D87602733EC86A64521F2B18177B200CBBE117577A615D6C770988C0BAD946E208E24FA074E5AB3143DB5BFCE0FD108E4B82D120A92108011A723C12A787E6D788719A10BDBA5B2699C327186AF4E23C1A946834B6150BDA2583E9CA2AD44CE8DBBBC2DB04DE8EF92E8EFC141FBECAA6287C59474E6BC05D99B2964FA090C3A2233BA186515BE7ED1F612970CEE2D7AFB81BDD762170481CD0069127D5B05AA993B4EA988D8FDDC186FFB7DC90A6C08F4DF435C934063199FFFFFFFFFFFFFFFF";
        BigInteger test = new BigInteger(p, 16);
        
        boolean prime = isPrime(test);
        System.out.println( "0x" + test.toString(16)  + "\nIs this a prime number? \n" + prime);
        int g1 = 2;
        int g2 = 22;
        System.out.println( "0x" + test.toString(16)  + "\nIs " + g1 + " a generator? \n " );
        isGenerator(test, g1);
        System.out.println( "0x" + test.toString(16)  + "\nIs " + g2 + " a generator? \n ");
        isGenerator(test, g2);
        String alice = "954637821";
        BigInteger a = new BigInteger(alice, 16);
        String bob = "107965234";
        BigInteger b = new BigInteger(bob, 10);
        shareSecret(test, a, b, g1);

        
    }

    public void testElGamal(){
        String p = "FFFFFFFFFFFFFFFFC90FDAA22168C234C4C6628B80DC1CD129024E088A67CC74020BBEA63B139B22514A08798E3404DDEF9519B3CD3A431B302B0A6DF25F14374FE1356D6D51C245E485B576625E7EC6F44C42E9A637ED6B0BFF5CB6F406B7EDEE386BFB5A899FA5AE9F24117C4B1FE649286651ECE45B3DC2007CB8A163BF0598DA48361C55D39A69163FA8FD24CF5F83655D23DCA3AD961C62F356208552BB9ED529077096966D670C354E4ABC9804F1746C08CA18217C32905E462E36CE3BE39E772C180E86039B2783A2EC07A28FB5C55DF06F4C52C9DE2BCBF6955817183995497CEA956AE515D2261898FA051015728E5A8AAAC42DAD33170D04507A33A85521ABDF1CBA64ECFB850458DBEF0A8AEA71575D060C7DB3970F85A6E1E4C7ABF5AE8CDB0933D71E8C94E04A25619DCEE3D2261AD2EE6BF12FFA06D98A0864D87602733EC86A64521F2B18177B200CBBE117577A615D6C770988C0BAD946E208E24FA074E5AB3143DB5BFCE0FD108E4B82D120A93AD2CAFFFFFFFFFFFFFFFF";
        BigInteger test = new BigInteger(p, 16);
        boolean prime = isPrime(test);
        System.out.println( "0x" + test.toString(16)  + "\nIs this a prime number? \n" + prime);
        int g1 = 2;
        int g2 = 31;
        System.out.println( "0x" + test.toString(16)  + "\nIs " + g1 + " a generator? \n " );
        isGenerator(test, g1);
        System.out.println( "0x" + test.toString(16)  + "\nIs " + g2 + " a generator? \n ");
        isGenerator(test, g2);
        String privateA = "f9e8d7c6b5a43210";
        BigInteger a = new BigInteger(privateA, 16);
        BigInteger gen = BigInteger.valueOf(g2);
        BigInteger publicA = publicKey(gen, a, test);
        
        System.out.println( "Alice's public key is : \n0x" + publicA.toString(16) );
        String random = "1234567890";
        BigInteger k = new BigInteger(random, 16);
        BigInteger c1 = gen.modPow(k, test);
        BigInteger m = BigInteger.valueOf(10);
       
        BigInteger Mh = publicA.modPow(k, test);
        BigInteger c2 = Mh.multiply(m);                                                                                        
        System.out.println( "message = 10 is encrypted ad : \n(0x" + c1.toString(16) + ", 0x" +  c2.toString(16) + ")");
        BigInteger K = c1.modPow(a, test);
        BigInteger invK = K.modInverse(test);
        BigInteger decrypt = c2.multiply(invK);
        BigInteger decrypted = decrypt.mod(test);
        System.out.println( "Alice decrypts 0x" + c1.toString(16) + "\nPlaintext:\n0x" +  decrypted.toString(16) );
    }

    public int modExp (int a, int b, int n) {
		int base = a;
        int exponent = b;
        int square1 = 1;
        
        while (exponent > 0) {
            int mod = exponent % 2; // checks exponent is 1 or 0 for binary conversion. saves remainder. 
            exponent = exponent / 2; // saves quoteint. 
            
                if (mod == 1 ) {
                    long squareLong1 = square1 * base;
                    square1 = (int)(squareLong1 % n);
                    
                }
                long squareLong = base * base;
                
                base = (int)(squareLong % n);

            
        }
        return square1;
	}

    public BigInteger[] privateKey(BigInteger k, BigInteger[] G, BigInteger a, BigInteger p){
    
        BigInteger three = BigInteger.valueOf(3);
        BigInteger two = BigInteger.valueOf(2);
        BigInteger[] key = new BigInteger[]{BigInteger.ZERO, BigInteger.ZERO};
        int i = k.bitLength() - 1;
        while (i >= 0){ 
            
            BigInteger top = key[0].multiply(key[0]);
            BigInteger next = three.multiply(top);
            BigInteger next2 = next.add(a);
            BigInteger next3 = next2.mod(p);
            BigInteger bottom = two.multiply(key[1]);
            BigInteger deno = bottom.mod(p);
            BigInteger inverse = deno;
            if (deno == BigInteger.ZERO){
                inverse = BigInteger.ZERO;

            } else {
                inverse = deno.modInverse(p);
            }
            BigInteger sigma = (next3.multiply(inverse)).mod(p);
            BigInteger xR = sigma.multiply(sigma);
            xR = xR.subtract(key[0]);
            xR = xR.subtract(key[0]);
            BigInteger x1 = xR.mod(p);
            BigInteger yR = key[0].subtract(xR);
            yR = sigma.multiply(yR);
            yR = yR.subtract(key[1]);
            BigInteger y1 = yR.mod(p);
            key[0] = x1;
            key[1] = y1;
            
            if((x1 == BigInteger.ZERO && y1 == BigInteger.ZERO) ) { 
                key[0]= G[0];
                key[1] = G[1];
                
            }
            else if (k.testBit(i)){
                top = key[1].subtract(G[1]);
                next = top.mod(p);
                next2 = key[0].subtract(G[0]);
                next3 = next2.mod(p);
                
                bottom = next3.modInverse(p);
                sigma = next.multiply(bottom);
                sigma = sigma.mod(p);
                xR = sigma.multiply(sigma);
                xR = xR.subtract(key[0]);
                xR = xR.subtract(G[0]);
                BigInteger x = xR.mod(p);
                yR = key[0].subtract(xR);
                yR = sigma.multiply(yR);
                yR = yR.subtract(key[1]);
                BigInteger y = yR.mod(p);
                
                key[0] = x;
                key[1] = y;
                
            


            }
            i = i - 1;

        }
        return key;
    }
    public BigInteger jacobi(BigInteger a, BigInteger n){
        BigInteger TWO = BigInteger.valueOf(2);
        if ((n == TWO || n == BigInteger.ONE ) && a != BigInteger.ZERO) {
            return BigInteger.ONE;
            
        }
        if (a.equals(BigInteger.ZERO)){
            return BigInteger.ZERO;
        }
        if (a.equals(BigInteger.ONE)){
            return BigInteger.ONE;
        }
        BigInteger s = BigInteger.ONE;
        if (a.mod(TWO).equals(BigInteger.ZERO)){
            a = a.divide(BigInteger.valueOf(2));
            if(a.equals(BigInteger.ONE)){
                return s;
            }
        } else {
            if (n.mod(BigInteger.valueOf(8)).equals(BigInteger.ONE) ||n.mod(BigInteger.valueOf(8)).equals(BigInteger.valueOf(7))) {
                s = BigInteger.ONE;
            } else if (n.mod(BigInteger.valueOf(8)).equals(BigInteger.valueOf(3)) || n.mod(BigInteger.valueOf(8)).equals(BigInteger.valueOf(5))){
                s = BigInteger.ONE;
            }
        
        if (n.mod(BigInteger.valueOf(4)).equals(BigInteger.valueOf(3)) && a.mod(BigInteger.valueOf(4)).equals(BigInteger.valueOf(3))){
                s = s.negate();
            }
        }
        BigInteger n1 = n.mod(a);
        
        if (a.equals(BigInteger.ONE)){
            return s;
        } else {
            return ((jacobi(n1, a)));
        }
    }
    public BigInteger[] mapped(BigInteger m, int padding, BigInteger k, BigInteger a, BigInteger p, BigInteger b) {
        
        String z1 =  m.toString(2);
        for (int i = 0; i < padding; i++){
            z1 = z1 + "0";
        }
        
        
        BigInteger z = new BigInteger(z1, 2);
        
        BigInteger y = z.pow(3);
        BigInteger y2 = z.multiply(a);
        BigInteger y3 = y.add(y2);
        BigInteger y4 = y3.add(b);
        BigInteger n = y4.mod(p);
        
        
        while (jacobi(n,p) != BigInteger.ONE){
            n = n.add(BigInteger.ONE);
        
            
        }
        BigInteger exponent = p.add(BigInteger.ONE);
        exponent = exponent.divide(BigInteger.valueOf(4));
        
        BigInteger pm = n.modPow(exponent, p);
    
        BigInteger[] Pm = new BigInteger[]{z, pm};
        
        return Pm;

    }

    public BigInteger[] encryption(BigInteger k, BigInteger m, BigInteger[] key, BigInteger[] pm, BigInteger a, BigInteger p, BigInteger[] G){
        
        BigInteger[] Cm1 = privateKey(k, G, a, p);
        
        BigInteger[] Ua = privateKey(k, key, a, p);
        
        
        
        BigInteger x = Ua[1].subtract(pm[1]);
        
        BigInteger y = Ua[0].subtract(pm[0]);
        
        x = x.mod(p);
        
        y = y.mod(p);
        y = y.modInverse(p);
        
        BigInteger total = x.multiply(y);
    
        total = total.mod(p);
        
        BigInteger newX = total.multiply(total);
        
        newX = newX.subtract(pm[0]);
        
        newX = newX.subtract(Ua[0]);
        
        newX = newX.mod(p);

        
        BigInteger newY = pm[0].subtract(newX);
        newY = total.multiply(newY);
        newY = newY.subtract(pm[1]);
        newY = newY.mod(p);

        BigInteger[] cipher = new BigInteger[4];
        
        cipher[0] = Cm1[0];
        cipher[1] = Cm1[1];
        cipher[2] = newX;
        cipher[3] = newY;

        return cipher;

    }

    public BigInteger decrypt(BigInteger a, BigInteger b, BigInteger p, BigInteger[] G, BigInteger[] Cm1, BigInteger[] Cm2, BigInteger k, int pad) {
        
        BigInteger[] Y = privateKey(k, Cm1, a, p);
        
        BigInteger y2 = Y[1].negate();
        y2 = y2.mod(p);
        Y[1] = y2;
        
        BigInteger[] map = new BigInteger[2];
        if ((Cm2[0].equals(Y[0])) && (Cm2[1].equals(Y[1]))){
            map = privateKey(BigInteger.valueOf(2), Y, a, p);
            


        } else {
            BigInteger top = Cm2[1].subtract(Y[1]);
            
            BigInteger next = top.mod(p);
            BigInteger next2 = Cm2[0].subtract(Y[0]);
            
            BigInteger next3 = next2.mod(p);
            
            BigInteger bottom = next3.modInverse(p);
            BigInteger sigma = next.multiply(bottom);
            
            sigma = sigma.mod(p);
            BigInteger xR = sigma.multiply(sigma);
            xR = xR.subtract(Cm2[0]);
            
            xR = xR.subtract(Y[0]);
            
            BigInteger x = xR.mod(p);
            
            BigInteger yR = Y[0].subtract(xR);
            yR = sigma.multiply(yR);
            yR = yR.subtract(Y[1]);
            BigInteger y = yR.mod(p);
                
            map[0] = x;
            map[1] = y;
            

        }
        
        String z1 =  map[0].toString(2);
        
        int amount = z1.length() - pad;
        
        z1 = z1.substring(0, amount);
        
        BigInteger decrypt = new BigInteger(z1, 2);
    
        return decrypt;
    }




    public void testECC(){
        
        BigInteger a = BigInteger.valueOf(0);
        BigInteger b = BigInteger.valueOf(7);
        String moudulous = "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEFFFFFC2F";
        BigInteger p = new BigInteger(moudulous, 16);
        String Gx = "79BE667EF9DCBBAC55A06295CE870B07029BFCDB2DCE28D959F2815B16F81798";
        String Gy = "483ada7726a3c4655da4fbfc0e1108a8fd17b448a68554199c47d08ffb10d4b8";
        BigInteger x = new BigInteger(Gx, 16);
        BigInteger y = new BigInteger(Gy, 16);
        BigInteger[] G = {x, y};
        //String nk = "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFEBAAEDCE6AF48A03BBFD25E8CD0364141";
        BigInteger privateKey = new BigInteger("f9e8d7c6b5a43210", 16);
        BigInteger[] key = privateKey(privateKey, G, a, p);
        System.out.println("Alice's public key is: 0x" + key[0].toString(16) + ", 0x" + key[1].toString(16));

        
        /** 
        BigInteger a = BigInteger.valueOf(9);
        BigInteger p = BigInteger.valueOf(23);
        BigInteger x = BigInteger.valueOf(16);
        BigInteger y = BigInteger.valueOf(5);
        BigInteger[] G = new BigInteger[]{x,y};
        BigInteger privateKey = BigInteger.valueOf(10);
        BigInteger k = new BigInteger("2");
        BigInteger b = BigInteger.valueOf(17);
        BigInteger m = new BigInteger("3");
        BigInteger[] key = privateKey(privateKey, G, a, p);
        */
        BigInteger m = new BigInteger("12");
        BigInteger k = new BigInteger("1234567890", 16);
        int padding = 20;
        BigInteger[] pm = mapped(m, padding, k, a, p, b);
        
        System.out.println("Bob maps " + m.toString(16) + " to point: 0x" + pm[0].toString(16) + ", 0x" + pm[1].toString(16));
        int bitS = p.bitCount()*1000;
        
        BigInteger[] cipher = encryption(k, m, key, pm, a, p, G);
        
        System.out.println("Bob encrypts message " + m.toString(16) + " to ciphertext: (0x" + cipher[0].toString(16) + ", 0x" + cipher[1].toString(16) + "), (0x" + cipher[2].toString(16) + ", 0x" + cipher[3].toString(16) + ")");
        long starting = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            cipher = encryption(k, m, key, pm, a, p, G);
        }
        long ending = System.nanoTime();
        long elapse = ending - starting;
        double speed = (elapse / 1000000000.0);
        speed = bitS / speed;
        speed = speed /1000;
        
        System.out.println("Total time for 1000 encryptions: " + elapse + " seconds\nTotal speed in kbps: " + speed);
        //System.out.println(cipher[0].toString() + " " + cipher[1].toString() + " " + cipher[2].toString() + " " + cipher[3].toString());
        BigInteger[] Cm1 = {cipher[0], cipher[1]};
        BigInteger[] Cm2 = {cipher[2], cipher[3]};

        BigInteger decrypt = decrypt(a, b, p, G, Cm1, Cm2, privateKey, padding);

        System.out.println("Alice decrypts Bobs message to: 0x" + decrypt.toString(16));
        long start = System.nanoTime();
        for(int i = 0; i < 1; i++){
            decrypt = decrypt(a, b, p, G, Cm1, Cm2, privateKey, padding);
        }
        long end = System.nanoTime();
        elapse = end - start;
        speed = (elapse / 1000000000.0);
        speed = bitS / speed;
        speed = speed /1000;
        

        System.out.println("Total time for 1000 decryption: " + elapse + " seconds\nTotal speed in kbps: "+ speed);


    }

    public static void main (String[] args) {
        BotticelliKatherineProject3 proj = new BotticelliKatherineProject3();

    
        proj.testDH();
        proj.testElGamal();
        proj.testECC();
    }
}

