package swexpert.d3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q7675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        for(int z = 1; z <= tc; z++){
            sb.append('#').append(z).append(' ');

            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            while(true){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int result = 0;
xx:              while(st.hasMoreTokens()){
                    String line = st.nextToken();
                    int len = line.length();
                    int check = 0;
                    char t = line.charAt(len-1);
                    if(t=='.'|| t=='!'||t=='?') cnt++;

                    for(int i = 0; i < len; i++){
                        t = line.charAt(i);
                        if(t=='.'|| t=='!'||t=='?'){
                            if(check==3) result++;
                            sb.append(result).append(' ');
                            result = 0;
                            continue xx;
                        }else if(t>='A'&&t<='Z'){
                            if(check==0) {
                                check = 3;
                            }else{
                                check = 2;
                            }
                        }else if(t>='0'&&t<='9'){
                            check = 2;
                        }else{
                            if(check==1) check = 3;
                        }
                    }
                    if(check==3) result++;
                }// end of while(token)
                if(cnt==n) break;
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }// end of main
}// end of class
