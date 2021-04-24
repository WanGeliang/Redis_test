package com.atguigu.sparsearray;

import java.io.*;

/**
 * @author 万葛亮
 * @Date 2020 06 01 22:03
 */
public class SparseArray {
    public static void main(String[] args) {
        //
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][5] = 2;
        System.out.println("原始的二维数组···");
        for (int[] row : chessArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println("sum =" + sum);

        //创建稀疏数组
        int[][] spareArray = new int[sum + 1][3];
        //给稀疏数组赋值
        spareArray[0][0] = chessArray.length;
        spareArray[0][1] = chessArray[0].length;
        spareArray[0][2] = sum;
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    count++;
                    spareArray[count][0] = i;
                    spareArray[count][1] = j;
                    spareArray[count][2] = chessArray[i][j];
                }
            }
        }
        System.out.println("稀疏数组···");
//       saveToDeskop(spareArray);
//        writeFromToDeskop();
//        try {
//            int[][] ints = readFromDes();
//            System.out.println(ints.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        for (int[] row : spareArray) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
//        System.out.println(spareArray.length);
        //转成原始数组
        int[][] chessArr = new int[spareArray[0][0]][spareArray[0][1]];
        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可
        for (int i = 1; i < spareArray.length; i++) {
            chessArr[spareArray[i][0]][spareArray[i][1]] = spareArray[i][2];
        }
        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }


    /********************调用方法存储和读写***********************************/

    public static void saveToDeskop(int[][] sparseArr) {
        OutputStream out = null;
        PrintWriter printWriter = null;
        String src = "C:\\Users\\WGL\\Desktop\\sparse.txt";
        try {
            out = new FileOutputStream(new File(src));
            printWriter = new PrintWriter(out);
            for (int i = 0; i < sparseArr.length; i++) {
                printWriter.println(sparseArr[i][0] + " " + sparseArr[i][1] + " " + sparseArr[i][2]);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (null != printWriter) {
                printWriter.close();
            }
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }

    //file目标文件
    private static int[][] readFromDes() throws IOException {
        Reader reader = null;
        BufferedReader bufferedReader = null;
        File file= new File("C:\\Users\\WGL\\Desktop\\sparse.txt") ;
        int[][] result = new int[0][];
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            bufferedReader = new BufferedReader(reader);
            String data;
            String arrData = "";
            while ((data = bufferedReader.readLine()) != null) {
                arrData += data + "|";
            }
            String[] strings = arrData.split("\\|");
            String[] v = strings[0].split(",");
            result = new int[Integer.valueOf(v[0]).intValue()][Integer.valueOf(v[1]).intValue()];
            for (int i = 1; i < strings.length; i++) {
                String[] vv = strings[i].split(",");
                result[Integer.valueOf(vv[0]).intValue()][Integer.valueOf(vv[1]).intValue()] = Integer.valueOf(vv[2]).intValue();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } finally {
            if (null != bufferedReader) {
                bufferedReader.close();
            }
            if (null != reader) {
                reader.close();
            }
        }
        return result;
    }


    public static void writeFromToDeskop (){
        File file= new File("C:\\Users\\WGL\\Desktop\\sparse.txt");

        int[][] result=new int[0][];
        FileReader fr = null;
        try {
            fr=new FileReader(file);
            char[] cbuf = new char[5];
            int len;
            while((len = fr.read(cbuf)) != -1){

                //正确的写法
    //                for(int i = 0;i < len;i++){
    //                    System.out.print(cbuf[i]);
    //                }

                String str = new String(cbuf,0,len);
//                String[] strings = str.split(" ");
//                for (int i = 0; i < strings.length; i++) {
//                    int a= Integer.parseInt(strings[i]);
//
//                }
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
