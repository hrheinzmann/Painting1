import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class PPM extends Image
{
	Pixel[][] picture;

	//default constructor
	public PPM(){
		//picture = null;
		magic = "";
		width = 0;
		height = 0;
		depth = 0;
	}

	//modifying constructor
	public PPM(String file){
		try{

			File f = new File(file);
			Scanner sc = new Scanner(f);

			magic = sc.nextLine();
			String line = sc.nextLine();
			String[] dimension = line.split(" ");

			width = Integer.parseInt(dimension[0]);
			height = Integer.parseInt(dimension[1]);
			depth = Integer.parseInt(sc.nextLine());
			picture = new Pixel[height][width];

			for(int i = 0; i< height; i++){
				for(int j = 0; j < width; j++){
					int r = sc.nextInt();
					int g = sc.nextInt();
					int b = sc.nextInt();
					picture [i][j] = new Pixel(r,g,b);

				}
			}
		}

		catch(Exception ex){
			System.out.println(ex);
		}
	}

	public void negate_red()
	{
		for(int i = 0; i < height; i ++){
			for(int j = 0; j < width; j++){
				picture[i][j].r = 255- picture[i][j].r;
			}
		}
	}

	public void negate_green()
	{
		for(int i = 0; i < height; i ++){
			for(int j = 0; j < width; j++){
				picture[i][j].g = 255- picture[i][j].g;
			}
		}
	}

	public void negate_blue()
	{
		for(int i = 0; i < height; i ++){
			for(int j = 0; j < width; j++){
				picture[i][j].b = 255- picture[i][j].b;
			}
		}
	}

	public void flatten_red(){
		for(int i = 0; i < height; i ++){
			for (int j = 0; j < width; j++){
				picture[i][j].r = 0;
		}
	}
}

	public void flatten_green(){
		for(int i = 0; i < height; i ++){
			for (int j = 0; j < width; j++){
				picture[i][j].g = 0;
		}
	}
}

	public void flatten_blue(){
		for(int i = 0; i < height; i ++){
			for (int j = 0; j < width; j++){
				picture[i][j].b = 0;
		}
	}

}

	public void flip_horizontally(){
		Pixel hor [][] = new Pixel [picture.length][picture[0].length];

		for (int i = 0; i < height; i++){
			for (int j = 0; j > 0; j--){
				hor [i][width-1-j] = picture[i][j];
			}
		}
		picture = hor;
	}

	public void grey_scale(){
		for(int i = 0; i < height; i++){
			for(int j = 0; j< width; j ++){
				int total = picture[i][j].r + picture[i][j].g +picture[i][j].b;
				picture[i][j].r = total /3;
				picture[i][j].g = total /3;
				picture[i][j].b = total /3;
			}
		}
	}

	

	public Pixel [][] getPixels(){
		return this.picture;
	}

	public void print(String f) throws Exception{
		File file = new File(f);
		PrintWriter print = new PrintWriter(f);

		print.println(magic);
		print.println(width + " " + height);
		print.println(depth);

		for(int i = 0; i < picture.length; i ++){
			for(int j = 0; j<picture[i].length; j ++){
				print.print(picture[i][j] + " ");

			}
			print.println();
		}

		print.close();
	}

    public static void main(String[] args)
    {
		try{
    		Scanner sc = new Scanner(System.in);
    		System.out.println("Portable Pixmap (PPM) Image Editor!");
    		System.out.println("");
    		System.out.println("Enter name of image file: ");
    		String image = sc.nextLine();
    		System.out.println("Enter name of output file: ");
    		String output = sc.nextLine();
    		

       

        PPM ppm = new PPM (image);
        //ppm.flip_vertically ();
       // ppm.flip_horizontally();	
		//ppm.rotate_right_90();
		//ppm.negate_red();
		//ppm.negate_green();
		//ppm.negate_blue();
		//ppm.grey_scale();
		//ppm.flatten_blue();
		//ppm.flatten_green();
		//ppm.flatten_red();

		System.out.println("");
		System.out.println("Here are your choices: ");
		System.out.println("[1]  convert to greyscale [2]  flip horizontally");
		System.out.println("[3]  negative of red [4]  negative of green [5]  negative of blue");
		System.out.println("[6]  just the reds   [7]  just the greens   [8] just the blues");

		System.out.println("");

		System.out.print("Do you want [1]? (y/n) ");
		String ans = sc.nextLine();
		if(ans == "y"){
			ppm.grey_scale();
		}

		System.out.print("Do you want [2]? (y/n) ");
		ans = sc.nextLine();
		if(ans == "y"){
			ppm.flip_horizontally();
		}

		System.out.print("Do you want [3]? (y/n) ");
		ans = sc.nextLine();
		if(ans == "y"){
			ppm.negate_red();
		}

		System.out.print("Do you want [4]? (y/n) ");
		ans = sc.nextLine();
		if(ans == "y"){
			ppm.negate_green();
		}

		System.out.print("Do you want [5]? (y/n) ");
		ans = sc.nextLine();
		if(ans == "y"){
			ppm.negate_blue();
		}

		System.out.print("Do you want [6]? (y/n) ");
		ans = sc.nextLine();
		if(ans == "y"){
			ppm.flatten_green();
			ppm.flatten_blue();
		}

		System.out.print("Do you want [7]? (y/n) ");
		ans = sc.nextLine();
		if(ans == "y"){
			ppm.flatten_red();
			ppm.flatten_blue();
		}

		System.out.print("Do you want [8]? (y/n) ");
		ans = sc.nextLine();
		if(ans == "y"){
			ppm.flatten_green();
			ppm.flatten_red();
		}
		
		System.out.println("");

		System.out.print(output + " created.");
    }
    catch(Exception ex){
    	System.out.println(ex);
    }
    }
}