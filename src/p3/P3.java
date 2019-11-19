package p3;

public class P3 {

    public static void main(String[] args) {   
        // TODO code application logic hereFindCommon ob = new FindCommon(); 
        String res;
        String param = "";
        int [] vec1;
        int [] vec2;
        int [] vec3;
        long ms;
        for (String arg : args)param += arg + ",";
        int pos = 0;
        if (-1 != param.indexOf("-s")) System.out.println("Funciona");
        if( -1 != (pos = param.indexOf("-f")) || -1 != param.indexOf("-r")){
            if(-1 != (pos = param.indexOf("-f"))){
                int pos2 = param.indexOf("," + pos+3);
                int pos3 = param.indexOf("," + pos2+1);
                int pos4 = param.indexOf("," + pos3+1);
                vec1 = VectLoader.loadVectFile(param.substring(pos+3,pos2));
                vec2 = VectLoader.loadVectFile(param.substring(pos2+1,pos3));
                vec3 = VectLoader.loadVectFile(param.substring(pos3+1,pos4));
            }else{
                vec1 = new GenRandomArray().generateSorted(200000,0,100000);
                vec2 = new GenRandomArray().generateSorted(200000,0,100000);
                vec3 = new GenRandomArray().generateSorted(200000,0,100000);
            }
            long msInit = System.currentTimeMillis();
            res = FindCommon.findCommon(vec1,vec2,vec3);
            ms = System.currentTimeMillis() - msInit;
            if(-1 != param.indexOf("-di")){
                System.out.print("\n[");
                for (int w : vec1) {
                    System.out.print(w+ ",");
                }
                System.out.print("]");
                System.out.print("\n[");
                for (int w : vec2) {
                    System.out.print(w + ",");
                }
                System.out.print("]");
                System.out.print("\n[");
                for (int w : vec3) {
                    System.out.print(w + ",");
                }
                System.out.println("]");
               
            }
            if( -1 != param.indexOf("-do")) System.out.println("Common elements are " + res);
            if(-1 != param.indexOf("-dt"))System.out.println("Time: " + ms + " ms.");
            VectSaver.saveVectFile("D:\\Documentos\\NetBeansProjects\\vec1file.txt", vec1);
            VectSaver.saveVectFile("D:\\Documentos\\NetBeansProjects\\vec2file.txt", vec2);
            VectSaver.saveVectFile("D:\\Documentos\\NetBeansProjects\\vec3file.txt", vec3);
        } else {
            System.out.println("ERROR");            
        }
    }     
}