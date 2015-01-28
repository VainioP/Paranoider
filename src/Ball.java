public class Ball {
    public int width;
    public int height;
    public int x;
    public int y;
    public int vx = 0;
    public int vy = 0;

    public void setCords(int w,int h){
        this.width = w;
        this.height = h;
        x = width/2;
        y = height-100;
    }
    public void startItUP(){
        if (vx*vy == 0){
            vx = 1;
            vy = -1;
        }
    }

    public void dvy(){
        this.vy = -this.vy;
    }

    public void ballupdater(){
        if (x+vx < -1 || x+vx >=  width-10){
            vx = -vx;
        }
        if (y+vy < -1){
            vy = -vy;
        }
        x += vx;
        y += vy;
    }
}
