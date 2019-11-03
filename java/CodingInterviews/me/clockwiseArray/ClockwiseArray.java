package clockwiseArray;

public class ClockwiseArray {

    public String doPrint(String[][] arr) {
        String completeString;
        StringBuilder sb = new StringBuilder();
        int maxColumnLength = 0, maxRowLength = 0;
        int minColumnLength = 0, minRowLength = 0;
        int curRow = 0, curCol = 0;;

        maxRowLength = arr.length;
        maxColumnLength = arr[0].length;

        if(null != (completeString = checkEdgeCases(arr))) {
            return completeString;
        }

        while(minColumnLength != maxColumnLength && maxRowLength != minRowLength) {
            //goRight
            while(curCol < maxColumnLength) {
                sb.append(arr[curRow][curCol++]);
            }
            minRowLength++;
            curRow = minRowLength;
            curCol = maxColumnLength - 1;

            //goDown
            while(curRow < maxRowLength) {
                sb.append(arr[curRow++][curCol]);
            }
            maxColumnLength--;
            curRow = maxRowLength - 1;
            curCol = maxColumnLength - 1;


            //goLeft
            while(curCol >= minColumnLength) {
                sb.append(arr[curRow][curCol--]);
            }
            maxRowLength--;
            curRow = maxRowLength - 1;
            curCol = minColumnLength;

            //goUp
            while(curRow >= minRowLength) {
                sb.append(arr[curRow--][curCol]);
            }
            minColumnLength++;
            curCol = minColumnLength;
            curRow = minRowLength;

            if(minRowLength > maxRowLength || minColumnLength > maxColumnLength) {
                break;
            }
        }

        return sb.toString();
    }

    public String checkEdgeCases(String[][] arr) {
        StringBuilder sb = new StringBuilder();
        int maxColumnLength = 0, maxRowLength = 0;
        maxRowLength = arr.length;
        maxColumnLength = arr[0].length;
        //Case for one row total. Just read and return
        if(maxRowLength == 1) {
            for(String c : arr[0]) {
                sb.append(c);
            }
            return sb.toString();
        }

        //Case for one column total. Just read and return
        if (maxColumnLength == 1) {
            for(int i = 0; i < arr.length; i++) {
                sb.append(arr[i][0]);
            }
            return sb.toString();
        }

        //If we hit here, then we had no edge cases
        return null;
    }

    // Use this to test things out for yourself
    public static void main(String[] args) {
        ClockwiseArray cp = new ClockwiseArray();
        String[][] arr = new String[][]{
                { "A","B" },
                { "D","C" }
        };
        System.out.println(cp.doPrint(arr));
    }
}
