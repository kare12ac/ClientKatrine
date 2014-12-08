package Logic;
 
public class encryption {
        public byte[] decrypt(byte[] b)
        {
 
                Byte ff = (byte) 3.1470;
 
                for(int i = 0 ; i<b.length ; i++)
                {
                        b[i] = (byte)(b[i]^ff);
                }
 
                byte[] encrypted = b;
                System.out.println(encrypted);
                return encrypted;
        }
 
}