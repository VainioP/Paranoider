public class Pad {
    public int y;
    public int x;
    public int width;
    public int height;
    public int vx = 0;


    public void setStart(int w, int h){
        width = w;
        height = h;
        this.x = width/2-43;
        this.y = height-20;
    }
    public void padupdater(){
        x += vx;
        if (x<=-1){
            x-=vx;
        }
        if (x>=width-84){
            x-=vx;
        }
    }
}
