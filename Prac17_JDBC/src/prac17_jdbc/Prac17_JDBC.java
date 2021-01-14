
package prac17_jdbc; 

public class Prac17_JDBC {

    public static void main(String[] args) {
        ReadFileWriteSer read = new ReadFileWriteSer();
        ReadSerWriteFile write = new ReadSerWriteFile();
        
        read.open();
        read.process();
        read.close();
        
        write.open();
        write.process();
        write.close();
        
    }       //end main()
    
}       //end class
