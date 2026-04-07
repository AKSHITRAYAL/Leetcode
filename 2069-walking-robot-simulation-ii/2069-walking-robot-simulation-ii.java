import java.util.*;

class Robot {

    List<int[]> cells;
    int count;
    int perimeter;

    public Robot(int width, int height) {
        cells = new ArrayList<>();
        count = 0;

        // Special case: single cell
        if (width == 1 && height == 1) {
            cells.add(new int[]{0, 0, 3}); // South
            perimeter = 1;
            return;
        }

        // Bottom row (East)
        for (int i = 0; i < width; i++) {
            cells.add(new int[]{i, 0, 0});
        }

        // Right column (North)
        for (int i = 1; i < height; i++) {
            cells.add(new int[]{width - 1, i, 1});
        }

        // Top row (West)
        for (int i = width - 2; i >= 0; i--) {
            cells.add(new int[]{i, height - 1, 2});
        }

        // Left column (South)
        for (int i = height - 2; i > 0; i--) {
            cells.add(new int[]{0, i, 3});
        }

        perimeter = cells.size();
    }
    
    public void step(int num) {
        count += num;
    }
    
    public int[] getPos() {
        int index = count % perimeter;
        return new int[]{cells.get(index)[0], cells.get(index)[1]};
    }
    
    public String getDir() {
        int index = count % perimeter;

        // Special case: if no movement but stepped at least once
        if (count > 0 && index == 0) {
            return "South";
        }

        int dir = cells.get(index)[2];

        if (dir == 0) return "East";
        if (dir == 1) return "North";
        if (dir == 2) return "West";
        return "South";
    }
}