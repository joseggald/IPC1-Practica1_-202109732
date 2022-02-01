import java.util.Scanner;
public class PacMan {

    public static void main(String[] args) {

        String  edad[] = new String [100];
        String  nom[] = new String [100];
        String tabla[][] = new String [100][100];
        int userCont=0, fil, col, m, m2=0;
        int op, op2=0,n,n2, v1, v2, r1, r2,p1,p2,u2,u1;
        String x;
        Scanner leer=new Scanner(System.in);

        do{
            do{

                System.out.println("*********************");
                System.out.println("* 1. Jugar          *");
                System.out.println("* 2. Historial      *");
                System.out.println("* 3. Salir          *");
                System.out.println("*********************");
                op=leer.nextInt();

                if(op==1){
                    op2=0;

                    userCont=userCont+1;
                    System.out.println("Ingrese su NOMBRE: ");
                    nom[userCont]=leer.next();
                    System.out.println("Ingrese su EDAD: ");
                    edad[userCont]=leer.next();


                    System.out.println("Ingrese la dimension de la matriz (Su minimo es 8x8.).");
                    do {
                        System.out.println("Filas:");
                        fil=leer.nextInt();
                        System.out.println("Columnas:");
                        col=leer.nextInt();
                        if(fil<8 || col<8) {
                            System.out.println("No cumple las normas del programa porfavor reingrese las filas y columnas.");
                        }
                    }while(fil<8 || col<8);
                    m=fil/2;
                    m2=m+1;

                    for(int j=1; j<=fil; j++) {
                        for(int k=1; k<=col; k++) {

                            if(j==1) {
                                tabla[j][k]="*";

                            }
                            if(j==fil) {
                                tabla[j][k]="*";

                            }
                            if(k==1 && j<m && j>1 && j<fil){
                                tabla[j][k]="*";

                            }
                            if(k==col && j<m && j>1 && j<fil){
                                tabla[j][k]="*";

                            }
                            if(k==1 && j>m2 && j>1 && j<fil){
                                tabla[j][k]="*";

                            }
                            if(k==col && j>m2 && j>1 && j<fil){
                                tabla[j][k]="*";

                            }
                            if(j==m && k==1 || j==m && k==col){
                                tabla[j][k]=" ";

                            }
                            if(j==m2 && k==1 || j==m2 && k==col){
                                tabla[j][k]=" ";

                            }
                            if(j>1 && k>1 && k<col && j<fil){
                                tabla[j][k]=" ";

                            }
                            n = (int) (Math.random() * (fil-1) + 2);
                            n2= (int) (Math.random() * (col-1) + 2);

                            if(j==n && j>1 && j<fil && k!=m && k!=m2 || j==n+1 && j>1 && j<fil && k!=m && k!=m2){
                                tabla[j][k]="*";

                            }
                            if(k==n2 && j>1 && j<fil && k!=m && k!=m2 || k==n2+1 && j>1 && j<fil && k!=m && k!=m2 ){
                                tabla[j][k]="*";

                            }
                        }
                    }

                    v1 = (int) (Math.random() * (6) + 3);
                    v2 = (int) (Math.random() * (6) + 3);
                    tabla[v1][v2]="V";
                    if(fil<=12 && col<=12){
                        r1 = (int) (Math.random()*(fil-2) + 2);
                        r2 = (int) (Math.random() * (col-2) + 2);
                        tabla[r1][r2]="$";
                        p1 = (int) (Math.random() * (fil-2) + 2);
                        p2 = (int) (Math.random() * (col-2) + 2);
                        tabla[p1][p2]="@";
                        u1 = (int) (Math.random() * (fil-2) + 2);
                        u2 = (int) (Math.random() * (col-2) + 2);
                        tabla[u1][u2]="#";
                    }
                    if(fil>=12 && col>=12 && fil<=25 && col<= 25){
                        for(int i=1; i<=2; i++){
                            r1 = (int) (Math.random()*(fil-2) + 2);
                            r2 = (int) (Math.random() * (col-2) + 2);
                            tabla[r1][r2]="$";
                            p1 = (int) (Math.random() * (fil-2) + 2);
                            p2 = (int) (Math.random() * (col-2) + 2);
                            tabla[p1][p2]="@";
                            u1 = (int) (Math.random() * (fil-2) + 2);
                            u2 = (int) (Math.random() * (col-2) + 2);
                            tabla[u1][u2]="#";
                        }

                    }
                    if(fil>=25 && col>=25 && fil<=52 && col<= 52){
                        for(int i=1; i<=4; i++){
                            r1 = (int) (Math.random() * (fil-2) + 2);
                            r2 = (int) (Math.random() * (col-2) + 2);
                            tabla[r1][r2]="$";
                            p1 = (int) (Math.random() * (fil-2) + 2);
                            p2 = (int) (Math.random() * (col-2) + 2);
                            tabla[p1][p2]="@";
                            u1 = (int) (Math.random() * (fil-2) + 2);
                            u2 = (int) (Math.random() * (col-2) + 2);
                            tabla[u1][u2]="#";
                        }

                    }

                    for(int j=1; j<=fil; j++) {
                        for(int k=1; k<=col; k++) {

                            System.out.print(tabla[j][k]);

                        }
                        System.out.println();
                    }


                }
                if(op==2){

                    if(userCont==0){
                        System.out.println("Sin historial.");
                    }else{
                        System.out.println("*** HISTORIAL ***");
                        for(int i=1; i<=userCont; i++) {
                            System.out.println("Nombre: " + nom[i]);
                            System.out.println("Edad: " + edad[i]);
                            System.out.println("*****************");
                        }
                    }
                    do{
                        System.out.println("Desea regresar al menu? Oprima 1.");
                        op2=leer.nextInt();
                    }while(op2<1 || op2>1);

                }
            }
            while(op2==1);

            if(op==3){
                System.exit(0);
            }
            if(op<1 || op>3){
                System.out.println("Ingrese la opcion valida.");
            }

        }while(op<1 || op>3);

    }
}


