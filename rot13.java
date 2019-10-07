import java.util.*;
import java.io.*;

public class rot13{
    
    public static String encryption(String str){
        char[] ch = str.toCharArray();
        String s = "";
        for(int i=0;i<ch.length;i++){
            if(ch[i] >= 'A' && ch[i]<= 'Z'){
               char ch1 = (char)(((ch[i]-'A'+13)%26)+64);
               s+=ch1;
            }
            else if(ch[i] >= 'a' && ch[i] <= 'z'){
                char ch1 = (char)(((ch[i]-'a'+13)%26)+97);
                s+=ch1;
            }
            else if(ch[i] == ' '){
                s+=' ';
            }
            else{
                s+=ch[i];
            }
        }
        System.out.println(s);
        return s;
    }

    public static String decryption(String str){

        char[] ch = str.toCharArray();
        String s = "";
        for(int i=0;i<ch.length;i++){
            if(ch[i]>='A' && ch[i]<='Z'){
                char ch1 = (char)(((ch[i]-'A'-13)%26)+64);
                s+=ch1;
            }
            else if(ch[i]>='a' && ch[i]<='Z'){
                char ch1 = (char)(((ch[i]-'a'-13)%26)+97);
                s+=ch1;
            }
            else if(ch[i] == ' '){
                s+=' ';
            }
            else{
                s+=ch[i];
            }
        }
        System.out.println(s);
        return s;
    }

    public static boolean check(File file_to_read,File file_to_write){

        if(!file_to_write.exists()){
            file_to_write.createNewFile();
        }
        else{
            return true;
        }
        
        //Exception for wrong input
        if(!file_to_read.exists()){
            throw new Exception("Input file does not exists");
        }
        else{
            return true;
        }
    }

    public static void encrypt_read_write(File file_to_read,File file_to_write){
        String encrypted = "";
        BufferedReader br = new BufferedReader(new FileReader(file_to_read));
        String x;
        FileWriter fw = new FileWriter(file_to_write);
        while((x=br.readLine()) != null)
            encrypted += rot13.encryption(x) + "\n";
        fw.write(encrypted + "\n");
        fw.close();
    }

    public static void decrypt_read_write(File file_to_read,File file_to_write) {
        String decrypted = "";
        BufferedReader br = new BufferedReader(new FileReader(file_to_read));
        String x;
        FileWriter fw = new FileWriter(file_to_write);
        while((x=br.readLine()) != null)
            decrypted += rot13.decryption(x) + "\n";
        fw.write(encrypted + "\n");
        fw.close();
    }
    

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        String inputFile = args[0];
        String outputFile = args[1];
        String operation = args[2];
        File file_to_read = new File(inputFile);
        File file_to_write = new File(outputFile);
        
        if(check()){
            if(args.length() == 2){
                rot13.encrypt_read_write(file_to_read,file_to_write);
            }
            else if(args.length() == 3){
                if(opeartion == "encrypt"){
                    rot13.encrypt_read_write(file_to_read,file_to_write);
                }
                else{
                    rot13.decrypt_read_write(file_to_read,file_to_write);
                }
            }
        }
    }
    

}
