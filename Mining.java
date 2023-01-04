// mining exe
import java.util.Date;

public class Block{
    public String hash;
    public String previousHash;
    private long timestamp;
    private int nonce;


    public Block(String data,String previousHash){
        this.data = data;
        this.previousHash = previousHash;
        this.timestamp = new Date().getTime();

        this.hash = calculateHash();
    }

    public String calculateHash() {
        String calculateHash =Stringutil.applySha256(previousHash +long.toString(timestamp) + Integer.toString(nonce)+ data);
        return calculateHash;
    }

    public void mineBlock(int difficulty){
        String target = new String (new char[difficulty]).replace('\0'.'0');
        while(!hash.substring(0, difficulty).equals(target)){
            nonce++;
            hash =calculateHash();
        }
    
        System.out.println("Mined :" + hash);
    }

}
