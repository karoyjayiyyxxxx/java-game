import java.util.*;
/**
 * 
 */

/**
 * @author admin
 *
 */
class playy //類別屬性變數
{
	String id;
}
class k0
{
	
	private static final int finalSquare = 25;  //final方法
	public static void S() {
		System.out.print("請選擇要玩的遊戲");
		System.out.print("(1)打彈珠(2)抽鬼牌(3)蛇梯子，請輸入數字:");
		Scanner sc = new Scanner(System.in,"Big5");
		int chosse = sc.nextInt();
		for (;;) 
		{
			if (chosse == 1) 
			{
				System.out.print("\n");
				ball();
			}
			if (chosse == 2) 
			{
				System.out.print("\n");
				card();
			} 
			else if (chosse == 3) 
			{
				System.out.print("\n");
				snake();
			}
		}
	}
	public static void b() {
		while(true)
		{
			System.out.println("END");
			break;
		}
	}
	public static void ball() {

		Scanner sc = new Scanner(System.in,"Big5");
		
outloop:for(;;) 
{
			System.out.print("目前有10顆彈珠，請輸入要投的彈珠數量?");
			int ten=10;     //設彈珠一開始有10顆
				 
	while(true)         //迴圈玩遊戲投彈珠
	{
		int i = sc.nextInt();              //投的數量
		System.out.print("請輸入1-5其中一個數字:");
		
		 int n = sc.nextInt();     //猜的數
		int guess1=(int)(Math.random()*4+1);
		
		if(guess1==n)
		{
			System.out.println("恭喜獲得了"+(n*i)+"顆彈珠,目前有"+(ten-i+(n*i))+"顆彈珠");
			System.out.print("請輸入要投的彈珠數量?");
			ten=ten-i+(n*i);
		}
		else
		{
			System.out.println("沒中,目前剩"+(ten-i)+"顆彈珠");
			if((ten-i)<=0)
			{
				System.out.println("遊戲結束");
				break;
			}
			System.out.print("請輸入要投的彈珠數量?");
			ten=ten-i;
		}
			
	}
		System.out.print("是否繼續遊戲?");
		String answer = sc.next();
		while (true) 
		{
			if (answer.equals("是")) 
			{
				System.out.println();
				continue outloop;
			}
			else if (answer.equals("否")) 
			{
				System.out.println();
				S();
			}
		}
		
      }	

	}

	

	public static void card() {
		Scanner sc = new Scanner(System.in,"Big5");
		
outloop:for(;;) {
			String []card;
			
			card=new String[15];
			
			card[0]="黑桃A";
			card[1]="黑桃1";
			card[2]="黑桃2";
			card[3]="黑桃3";
			card[4]="黑桃4";
			card[5]="黑桃5";
			card[6]="黑桃6";
			card[7]="黑桃7";
			card[8]="黑桃8";
			card[9]="黑桃9";
			card[10]="黑桃0";
			card[11]="黑桃J";
			card[12]="黑桃Q";
			card[13]="黑桃K";
			card[14]="鬼牌";
				
			int[]guess;
			guess=new int[15];
			for(int i=0;i<guess.length;i++)       //一排0-14的亂數
			{
				guess[i]=(int)(Math.random()*15);
				
				for(int j=0;j<i;)
				{
					if(guess[i]==guess[j])
					{
						
						guess[i]=(int)(Math.random()*15);
						j = 0;
					}
					else
					{
						j++;
					}
					
				}
				
				//System.out.print(guess[i]);
				//System.out.print('\t');
			}	
			//System.out.print('\n');
			
			
			while(true)       //迴圈抽鬼牌
			{
				System.out.print("請抽鬼牌是第幾張:(輸入1-15一個數字)");
				int num=sc.nextInt();
				
				if(guess[num-1]==14)
				{
					System.out.println("恭喜抽中了!"+card[guess[num-1]]);
					
					for(int o=0;o<=14;o++)
					{
						System.out.print("\t"+"第"+(o+1)+"張");
					}
					System.out.print("\n");
					for(int o=0;o<=14;o++)
					{
						System.out.print("\t"+card[guess[o]]);	
					}
							break;
					
				}
				else
				{
					System.out.println("抽錯喔!這是"+card[guess[num-1]]);
				}
				
			}
			System.out.print("\n");
			System.out.print("是否繼續遊戲?");
			String answer = sc.next();
			while (true) 
			{
				if (answer.equals("是"))
				{
					System.out.println();
					continue outloop;
				} 
				else if (answer.equals("否")) 
				{
					System.out.println();
					S();
				}
			}
			
		}
	}

	public static void snake() {
		
		Scanner sc = new Scanner(System.in,"Big5");
outloop:for(;;) {
		int[] board = new int[finalSquare + 1];

        for(int i = 0; i <= finalSquare; i++)
        {
            board[i] = 0;
        }

        //走到的格子要上樓梯或滑下蛇後，要前進或後退幾格
        board[3] = +8;
        board[6] = +11;
        board[9] = +9;
        board[10] = +2;

        board[14] = -10;
        board[19] = -11;
        board[22] = -2;
        board[24] = -8;


        int Number = 0;//擲出的點數
        int Number2 = 0;
        int step2 = 0; //走到第幾格
        int step = 0; //走到第幾格

        System.out.print("請玩家1設id:");
        playy play11= new playy();
         play11.id=sc.next();
       
        
        System.out.print("請玩家2設id:");
        
        playy play12= new playy();
        play12.id=sc.next();;
        
        while(step < finalSquare ||step2 < finalSquare)
        {
            //擲骰子
        	int Number1 = (int)(Math.random() * 6 + 1);
            
            System.out.print( play11.id+"擲骰子，請輸入0:");
            int play=sc.nextInt();
            System.out.print("擲出的點數: " + Number1 + ", ");
            step += Number1;

            if(step < board.length)
            {
                if(board[step] > 0)
                {
                    System.out.print("上樓梯, 爬上 " + board[step] + " 格, ");
                }
                else if(board[step] < 0)
                {
                    System.out.print("下蛇身, 滑下 " + board[step] + " 格, ");
                }
                step += board[step];
            }
            System.out.println("前進到第 " + step + " 格");
            
            Number2 = (int)(Math.random() * 6 + 1);
           
            System.out.print( play12.id+"擲骰子，請輸入0:");
            int play2=sc.nextInt();
            System.out.print("擲出的點數: " + Number2 + ", ");
            step2 += Number2;
            
            
            if(step2 < board.length)
            {
                if(board[step2] > 0)
                {
                    System.out.print("上樓梯, 爬上 " + board[step2] + " 格, ");
                }
                else if(board[step2] < 0)
                {
                    System.out.print("下蛇身, 滑下 " + board[step2] + " 格, ");
                }
                step2 += board[step2];
            }
            System.out.println("前進到第 " + step2 + " 格");
            
            if(step >= finalSquare ) 
            {
                System.out.println("結束");
                System.out.println("恭喜玩家1"+play11.id+"獲勝");
                break;
            }
            if(step2 >= finalSquare ) 
            {
                System.out.println("結束");
                System.out.println("恭喜玩家2"+play12.id+"獲勝");
                break;
            }
            
        }
        System.out.print("是否繼續遊戲?");
		String answer = sc.next();
		while (true) 
		{
			if (answer.equals("是"))
			{
				System.out.println();
				continue outloop;
			} 
			else if (answer.equals("否")) 
			{
				System.out.println();
				S();
			}
		}
}	
	 }
}
public class K14 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO 自動產生的方法 Stub
		
		k0.S();
	}

}
