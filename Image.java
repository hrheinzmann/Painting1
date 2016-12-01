public abstract class Image
{
    // ---------------------
    // Image attributes
    // ---------------------
    protected String magic;
    protected int width;
    protected int height;
    protected int depth;

    // Accessors: getMagic(), getWidth(), etc...

    // Modifiers: setMagic(string m), setWidth(int w), etc...

    // -------------------
    // abstract functions
    // -------------------
    public abstract void flip_horizontally();
    
   
}