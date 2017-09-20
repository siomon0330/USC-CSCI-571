/**
 * Created by weichuanli on 4/4/17.
 */
public class ScoreTable {
    private final int TABLE_SIZE = 26;
    private final int UNICODE_OF_a = 97;
    public int[] table;
    public ScoreTable(){
        table = new int[TABLE_SIZE];
        for(int i = 0; i < TABLE_SIZE; i++){

            if(i + UNICODE_OF_a == 'd' || i + UNICODE_OF_a == 'g'){
                table[i] = 2;
            }else if(i + UNICODE_OF_a == 'b' || i + UNICODE_OF_a == 'c'|| i + UNICODE_OF_a == 'm' || i + UNICODE_OF_a == 'p' ){
                table[i] = 3;
            }else if(i + UNICODE_OF_a == 'f'||i + UNICODE_OF_a == 'h' || i + UNICODE_OF_a == 'v'|| i + UNICODE_OF_a == 'w' || i + UNICODE_OF_a == 'y'){
                table[i] = 4;
            }else if(i + UNICODE_OF_a == 'k'){
                table[i] = 5;
            }else if(i + UNICODE_OF_a == 'j' || i + UNICODE_OF_a == 'x'){
                table[i] = 8;
            }else if(i + UNICODE_OF_a == 'q' || i + UNICODE_OF_a == 'z'){
                table[i] = 10;
            }else{
                table[i] = 1;
            }
        }
    }

}
