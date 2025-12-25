class Solution {

    public ArrayList<Integer> findPeakGrid(int[][] mat) {

        // code here

           ArrayList<Integer> li=new ArrayList<>();

        int i=0;

        int j=mat[0].length-1;

        while(i<mat.length&&j>=0)

        {

            int top=(i-1>=0)? mat[i-1][j]:Integer.MIN_VALUE;

            int bottom=(i+1<mat.length)? mat[i+1][j]:Integer.MIN_VALUE;

            int left= (j-1>=0)? mat[i][j-1]:Integer.MIN_VALUE;

            int right=(j+1<mat[0].length)? mat[i][j+1]:Integer.MIN_VALUE;

            

            if(mat[i][j]<top)

            {

                i=i-1;

            }

            else if(mat[i][j]<bottom)

            {

                i=i+1;

            }

            else if(mat[i][j]<left)

            {

                j=j-1;

            }

            else if(mat[i][j]<right)

            {

                j=j+1;

            }

            else

            {

                li.add(i);

                li.add(j);

                return li;

            }

        }

        return li;

    }

}
