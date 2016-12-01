
public class Pixel{
	
	int r;
	int g;
	int b;

	//default constructor
	public Pixel(){
		r = 0;
		g = 0;
		b = 0;
	}
	//modifying constructor
	public Pixel(int r, int g, int b){
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public int getR(){
		return r;

	}

	public int getG(){
		return g;
	}

	public int getB(){
		return b;
	}

	//mutators
	public void setR(int r){
		this.r = r;
	}

	public void setG(int g){
		this.g = g;
	}

	public void setB(int b){
		this.b = b;
	}

	public void print(){
		System.out.print(r + " " + g + " " + b);
	}

	


}




