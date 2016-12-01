import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class PGM extends Image
{
	Pixel[][] picture;

	//default constructor
	public PGM(){
		magic = "";
		width = 0;
		height = 0;
		depth = 0;
	}

	//modifying constructor
	public PGM(String file){
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
					picture[i][j] = sc.nextInt();

				}
			}
		}

		catch(Exception ex){
			System.out.println(ex);
		}
	}

	public void flip_vertically(){
		int vert [][] = new int [picture.length][picture[0].length];

		for(int i = height-1; i>0; i--){
			for(int j = 0; j < width; j++){
				vert[height-i-1][j] = picture [i][j];
			}
		}
		picture = vert;
	}

	public void flip_horizontally(){
		int hor [][] = new int [picture.length][picture[0].length];

		for (int i = 0; i < height; i++){
			for (int j = 0; j > 0; j--){
				hor [i][width-1-j] = picture[i][j];
			}
		}
		picture = hor;
	}

	public void rotate_right_90(){
		int rotate[][] = new int [picture[0].length][picture.length];

		for(int i = 0; i<width; i++){
			int [] holder = new int [height];
			for (int j = height - 1; j>= 0; j--){
				holder[height-1-j] += picture[j][i];
			}
			rotate[i] = holder;
		}
		picture = rotate;
		width = picture[0].length;
		height = picture.length;
	}

	public int [][] getPixels(){
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
        System.out.println("Enter a PGM file name to read: ");
        String file = sc.nextLine();

        PGM pgm = new PGM (file);
        pgm.flip_vertically ();
        //pgm.flip_horizontally();	
		//pgm.rotate_right_90();

		pgm.print("out.pgm");
    }
    catch(Exception ex){
    	System.out.println(ex);
    }
    }
}