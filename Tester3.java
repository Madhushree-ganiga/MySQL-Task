
import java.util.Scanner;

public class Tester3 {
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		
		MarketDetailsDAO dao=new MarketDetailsDAOImpl();
		MarketDetailsDTO dto=new MarketDetailsDTO();
		String ans;
		do {
			System.out.println("Enter Your choice");
			System.out.println("1. save");
			System.out.println("2. Update noOfShops by Name");
			System.out.println("3. get all");
			System.out.println("4. delete by name");
			int ch=sc.nextInt();
			if(ch==1) {
				sc.nextLine();
				System.out.println("enter id");
				int id=sc.nextInt();
				sc.nextLine();
				System.out.println("enter name");
				String name=sc.nextLine();
				System.out.println("enter location");
				String location=sc.nextLine();
				System.out.println("enter no of shops");
				int noOfShops=sc.nextInt();
				
				dto.setId(id);
				dto.setName(name);
				dto.setLocation(location);
				dto.setNoOfshop(noOfShops);
				
			boolean check=dao.save(dto);
			if(check)
				System.out.println("data saved");
			else
				System.out.println("data not saved");
			}
			
			else if(ch==2)
			{
				sc.nextLine();
				System.out.println("enter market name to update");
				String name=sc.nextLine();
				System.out.println("enter new no of shops");
				int noOfShops=sc.nextInt();
				
				dto.setName(name);
				dto.setNoOfshop(noOfShops);
				
				boolean check=dao.update(dto);
				if(check)
					System.out.println("updated");
				else
					System.out.println("not updated");
			}
			
			else if(ch==3)
			{
				boolean check=dao.getAll(dto);
			}
			
			else if(ch==4)
			{
				sc.nextLine();
				System.out.println("enter name to delete");
				String name=sc.nextLine();
				boolean check=dao.deleteByName(dto);
				if(check)
					System.out.println("deleted");
				else
					System.out.println("not deleted");
			}
			
			sc.nextLine();
			System.out.println("do u want to continue");
			ans=sc.nextLine();
			}while(ans.equals("yes"));
				
		}
	
	}


