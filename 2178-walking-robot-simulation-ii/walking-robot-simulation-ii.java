class Robot {

    int w, h;
    int x, y;          // current position
    int dir;           // 0=East, 1=North, 2=West, 3=South
    
    String[] dirs = {"East", "North", "West", "South"};
    
    public Robot(int width, int height) {
        this.w = width;
        this.h = height;
        x = 0;
        y = 0;
        dir = 0; // East
    }
    
    public void step(int num) {
        int cycle = 2 * (w + h) - 4;
        num %= cycle;
        
        // Special case: full cycle
        if (num == 0) num = cycle;
        
        while (num > 0) {
            if (dir == 0) { // East
                int move = Math.min(num, w - 1 - x);
                x += move;
                num -= move;
                if (move == 0) dir = 1; // turn North
            }
            else if (dir == 1) { // North
                int move = Math.min(num, h - 1 - y);
                y += move;
                num -= move;
                if (move == 0) dir = 2; // turn West
            }
            else if (dir == 2) { // West
                int move = Math.min(num, x);
                x -= move;
                num -= move;
                if (move == 0) dir = 3; // turn South
            }
            else { // South
                int move = Math.min(num, y);
                y -= move;
                num -= move;
                if (move == 0) dir = 0; // turn East
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return dirs[dir];
    }
}