
import java.util.Scanner;
public class PacMan {

    public static void main(String[] args) {

        //Matrices y vectores.
        String  edad[] = new String [100];
        String  nom[] = new String [100];
        String tabla[][] = new String [100][100];
        int punteo[] = new int[100];
        int movimientos[] = new int[100];

        //Variables a utilizar.
        int userCont=0, fil, col, m, m2=0, oc=0, cancelar=0;
        int op, op2=0,n,n2, v1, v2, r1, r2,p1,p2,u2,u1, fin=0,cn=0;
        String x, mov;
        int rep;

        //Leer.
        Scanner leer=new Scanner(System.in);


        do{
            do{

                //Menu Principal
                System.out.println("*********************");
                System.out.println("* 1. Jugar          *");
                System.out.println("* 2. Historial      *");
                System.out.println("* 3. Salir          *");
                System.out.println("*********************");
                op=leer.nextInt();

                if(op==1){
                    //Opción 1: Jugar
                    System.out.println("");
                    System.out.println(""); 
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    cancelar=0;

                    // Instrucciones.
                    do{
                        System.out.println("Los controles para jugar son los siguientes: ");
                        System.out.println("W = Arriba");
                        System.out.println("S = Abajo");
                        System.out.println("A = Izquierda");
                        System.out.println("D = Derecha");
                        System.out.println("Presione 1 si esta todo claro!");
                        oc=leer.nextInt();
                    }while (oc!=1);

                    op2=0;

                    //Registro de datos.
                    userCont=userCont+1;
                    System.out.println("Ingrese su NOMBRE: ");
                    nom[userCont]=leer.next();
                    System.out.println("Ingrese su EDAD: ");
                    edad[userCont]=leer.next();


                    //Dimension del tablero.
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

                    //Llenado de datos del Tablero.
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

                    if(fil<=100 && col<=100){
                        do {
                            rep=0;
                            r1 = (int) (Math.random() * (fil - 2) + 2);
                            r2 = (int) (Math.random() * (col - 2) + 2);
                            if (r1 != (m2) && r2!=2|| r1 != (m2) && r2!=(col-1) || r1 != (2) && r2!=2|| r1 != (m) && r2!=(col-1)) {
                                tabla[r1][r2] = "$";
                                rep=1;
                            }
                        }while(rep!=1);
                        do {
                            rep=0;
                            p1 = (int) (Math.random() * (fil-2) + 2);
                            p2 = (int) (Math.random() * (col-2) + 2);
                            if (p1 != (m2) && p2!=2|| p1 != (m2) && p2!=(col-1) || p1 != (m) && p2!=2|| p1 != (m) && p2!=(col-1)) {
                                tabla[p1][p2]="@";
                                rep=1;
                            }
                        }while(rep!=1);
                        do {
                            rep=0;
                            u1 = (int) (Math.random() * (fil-2) + 2);
                            u2 = (int) (Math.random() * (col-2) + 2);
                            if (u1 != (m2) && u2!=2|| u1 != (m2) && u2!=(col-1) || u1 != (m) && u2!=2|| u1 != (m) && u2!=(col-1)) {
                                tabla[u1][u2]="#";
                                rep=1;
                            }
                        }while(rep!=1);



                    }
                    tabla[m][1]=" ";
                    tabla[m2][1]=" ";
                    tabla[m][col]=" ";
                    tabla[m2][col]=" ";
                    tabla[m][2]=" ";
                    tabla[m2][2]=" ";
                    tabla[m][col-1]=" ";
                    tabla[m2][col-1]=" ";

                    punteo[userCont]=0;
                    movimientos[userCont]=0;
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");

                    //Impresion de Tablero.
                    for(int j=1; j<=fil; j++) {
                        for(int k=1; k<=col; k++) {
                            System.out.print(tabla[j][k]);
                        }
                        System.out.println();
                    }
                    punteo[userCont]=10;
                    System.out.println("Puntaje: " + punteo[userCont]);
                    System.out.println("Movimientos: " + movimientos[userCont]);


                    //Movimientos.
                    do{

                        mov=leer.next();
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");

                        if(mov.equals("W") || mov.equals("w")){
                            if(v1>1) {
                                v1 = v1 - 1;

                                if (tabla[v1][v2].equals("*")) {
                                    v1=v1+1;
                                    for (int j = 1; j <= fil; j++) {
                                        for (int k = 1; k <= col; k++) {
                                            System.out.print(tabla[j][k]);
                                        }
                                        System.out.println();
                                    }
                                    movimientos[userCont] = movimientos[userCont] + 1;
                                    System.out.println(" ");
                                    System.out.println("Siempre que desees terminar el juego presiona M.");
                                    System.out.println("Movimientos: " + movimientos[userCont]);
                                    System.out.println("Puntaje: " + punteo[userCont]);
                                }
                                if (tabla[v1][v2].equals(" ")) {
                                    tabla[v1 + 1][v2] = " ";
                                    tabla[v1][v2] = "V";

                                    for (int j = 1; j <= fil; j++) {
                                        for (int k = 1; k <= col; k++) {
                                            System.out.print(tabla[j][k]);
                                        }
                                        System.out.println();
                                    }
                                    movimientos[userCont] = movimientos[userCont] + 1;
                                    System.out.println(" ");
                                    System.out.println("Siempre que desees terminar el juego presiona M.");
                                    System.out.println("Movimientos: " + movimientos[userCont]);
                                    System.out.println("Puntaje: " + punteo[userCont]);
                                }
                                if (tabla[v1][v2].equals("#")) {
                                    tabla[v1+1][v2] = " ";
                                    tabla[v1][v2] = "V";
                                    do {
                                        u1 = (int) (Math.random() * (fil - 2) + 2);
                                        u2 = (int) (Math.random() * (col - 2) + 2);
                                    }while(tabla[u1][u2].equals("*")||tabla[u1][u2].equals("#")||tabla[u1][u2].equals("$")||tabla[u1][u2].equals("@")||tabla[u1][u2].equals("V"));
                                    tabla[u1][u2] = "#";

                                    for (int j = 1; j <= fil; j++) {
                                        for (int k = 1; k <= col; k++) {
                                            System.out.print(tabla[j][k]);
                                        }
                                        System.out.println();
                                    }
                                    movimientos[userCont] = movimientos[userCont] + 1;
                                    punteo[userCont] = punteo[userCont] - 10;
                                    System.out.println(" ");
                                    System.out.println("Siempre que desees terminar el juego presiona M.");
                                    System.out.println("Movimientos: " + movimientos[userCont]);
                                    System.out.println("Puntaje: " + punteo[userCont]);
                                }
                                if (tabla[v1][v2].equals("$")) {
                                    tabla[v1+1][v2] = " ";
                                    tabla[v1][v2] = "V";
                                    do {
                                        r1 = (int) (Math.random() * (fil - 2) + 2);
                                        r2 = (int) (Math.random() * (col - 2) + 2);
                                    }while(tabla[r1][r2].equals("*")||tabla[r1][r2].equals("#")||tabla[r1][r2].equals("$")||tabla[r1][r2].equals("@")||tabla[r1][r2].equals("V"));
                                    tabla[r1][r2] = "$";

                                    for (int j = 1; j <= fil; j++) {
                                        for (int k = 1; k <= col; k++) {
                                            System.out.print(tabla[j][k]);
                                        }
                                        System.out.println();
                                    }
                                    movimientos[userCont] = movimientos[userCont] + 1;
                                    punteo[userCont] = punteo[userCont] + 15;
                                    System.out.println(" ");
                                    System.out.println("Siempre que desees terminar el juego presiona M.");
                                    System.out.println("Movimientos: " + movimientos[userCont]);
                                    System.out.println("Puntaje: " + punteo[userCont]);
                                }
                                if (tabla[v1][v2].equals("@")) {
                                    tabla[v1+1][v2] = " ";
                                    tabla[v1][v2] = "V";
                                    do{
                                    p1 = (int) (Math.random() * (fil-2) + 2);
                                    p2 = (int) (Math.random() * (col-2) + 2);
                                    }while(tabla[p1][p2].equals("*")||tabla[p1][p2].equals("#")||tabla[p1][p2].equals("$")||tabla[p1][p2].equals("@")||tabla[p1][p2].equals("V"));
                                    tabla[p1][p2]="@";
                                    for (int j = 1; j <= fil; j++) {
                                        for (int k = 1; k <= col; k++) {
                                            System.out.print(tabla[j][k]);
                                        }
                                        System.out.println();
                                    }
                                    movimientos[userCont] = movimientos[userCont] + 1;
                                    punteo[userCont] = punteo[userCont] + 10;
                                    System.out.println(" ");
                                    System.out.println("Siempre que desees terminar el juego presiona M.");
                                    System.out.println("Movimientos: " + movimientos[userCont]);
                                    System.out.println("Puntaje: " + punteo[userCont]);
                                }
                            }
                        }
                        if(mov.equals("S") || mov.equals("s")){
                            v1 = v1 + 1;
                            if (tabla[v1][v2].equals("*")) {
                                v1= v1 - 1;
                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }

                            if (tabla[v1][v2].equals(" ")) {
                                tabla[v1 - 1][v2] = " ";
                                tabla[v1][v2] = "V";

                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals("#")) {
                                tabla[v1-1][v2] = " ";
                                tabla[v1][v2] = "V";
                                do {
                                    u1 = (int) (Math.random() * (fil - 2) + 2);
                                    u2 = (int) (Math.random() * (col - 2) + 2);
                                }while(tabla[u1][u2].equals("*")||tabla[u1][u2].equals("#")||tabla[u1][u2].equals("$")||tabla[u1][u2].equals("@")||tabla[u1][u2].equals("V"));
                                tabla[u1][u2] = "#";

                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                punteo[userCont] = punteo[userCont] - 10;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals("$")) {
                                tabla[v1-1][v2] = " ";
                                tabla[v1][v2] = "V";
                                do {
                                    r1 = (int) (Math.random() * (fil - 2) + 2);
                                    r2 = (int) (Math.random() * (col - 2) + 2);
                                }while(tabla[r1][r2].equals("*")||tabla[r1][r2].equals("#")||tabla[r1][r2].equals("$")||tabla[r1][r2].equals("@")||tabla[r1][r2].equals("V"));
                                tabla[r1][r2] = "$";

                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                punteo[userCont] = punteo[userCont] + 15;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals("@")) {
                                tabla[v1-1][v2] = " ";
                                tabla[v1][v2] = "V";
                                do{
                                    p1 = (int) (Math.random() * (fil-2) + 2);
                                    p2 = (int) (Math.random() * (col-2) + 2);
                                }while(tabla[p1][p2].equals("*")||tabla[p1][p2].equals("#")||tabla[p1][p2].equals("$")||tabla[p1][p2].equals("@")||tabla[p1][p2].equals("V"));
                                tabla[p1][p2]="@";
                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                punteo[userCont] = punteo[userCont] + 10;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }

                        }
                        if(mov.equals("A") || mov.equals("a")){
                            v2 = v2 - 1;
                            if(v1==m && v2==0 || v1==m2 && v2==0){
                                tabla[v1][1] = " ";
                                v2=col;
                                tabla[v1][v2] = "V";
                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals("*")) {
                                v2= v2 + 1;
                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals(" ")) {
                                tabla[v1][v2+1] = " ";
                                tabla[v1][v2] = "V";

                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals("#")) {
                                tabla[v1][v2+1] = " ";
                                tabla[v1][v2] = "V";
                                do {
                                    u1 = (int) (Math.random() * (fil - 2) + 2);
                                    u2 = (int) (Math.random() * (col - 2) + 2);
                                }while(tabla[u1][u2].equals("*")||tabla[u1][u2].equals("#")||tabla[u1][u2].equals("$")||tabla[u1][u2].equals("@")||tabla[u1][u2].equals("V"));
                                tabla[u1][u2] = "#";

                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                punteo[userCont] = punteo[userCont] - 10;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals("$")) {
                                tabla[v1][v2+1] = " ";
                                tabla[v1][v2] = "V";
                                do {
                                    r1 = (int) (Math.random() * (fil - 2) + 2);
                                    r2 = (int) (Math.random() * (col - 2) + 2);
                                }while(tabla[r1][r2].equals("*")||tabla[r1][r2].equals("#")||tabla[r1][r2].equals("$")||tabla[r1][r2].equals("@")||tabla[r1][r2].equals("V"));
                                tabla[r1][r2] = "$";

                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                punteo[userCont] = punteo[userCont] + 15;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals("@")) {
                                tabla[v1][v2+1] = " ";
                                tabla[v1][v2] = "V";
                                do{
                                    p1 = (int) (Math.random() * (fil-2) + 2);
                                    p2 = (int) (Math.random() * (col-2) + 2);
                                }while(tabla[p1][p2].equals("*")||tabla[p1][p2].equals("#")||tabla[p1][p2].equals("$")||tabla[p1][p2].equals("@")||tabla[p1][p2].equals("V"));
                                tabla[p1][p2]="@";
                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                punteo[userCont] = punteo[userCont] + 10;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                        }
                        if(mov.equals("D") || mov.equals("d")){
                            v2 = v2 + 1;
                            if(v1==m && v2==col+1 || v1==m2 && v2==col+1){
                                tabla[v1][col] = " ";
                                v2=1;
                                tabla[v1][v2] = "V";
                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals("*")) {
                                v2= v2 - 1;
                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals(" ")) {
                                tabla[v1][v2-1] = " ";
                                tabla[v1][v2] = "V";

                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals("#")) {
                                tabla[v1][v2-1] = " ";
                                tabla[v1][v2] = "V";
                                do {
                                    u1 = (int) (Math.random() * (fil - 2) + 2);
                                    u2 = (int) (Math.random() * (col - 2) + 2);
                                }while(tabla[u1][u2].equals("*")||tabla[u1][u2].equals("#")||tabla[u1][u2].equals("$")||tabla[u1][u2].equals("@")||tabla[u1][u2].equals("V"));
                                tabla[u1][u2] = "#";

                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                punteo[userCont] = punteo[userCont] - 10;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals("$")) {
                                tabla[v1][v2-1] = " ";
                                tabla[v1][v2] = "V";
                                do {
                                    r1 = (int) (Math.random() * (fil - 2) + 2);
                                    r2 = (int) (Math.random() * (col - 2) + 2);
                                }while(tabla[r1][r2].equals("*")||tabla[r1][r2].equals("#")||tabla[r1][r2].equals("$")||tabla[r1][r2].equals("@")||tabla[r1][r2].equals("V"));
                                tabla[r1][r2] = "$";

                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                punteo[userCont] = punteo[userCont] + 15;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);
                            }
                            if (tabla[v1][v2].equals("@")) {
                                tabla[v1][v2-1] = " ";
                                tabla[v1][v2] = "V";
                                do{
                                    p1 = (int) (Math.random() * (fil-2) + 2);
                                    p2 = (int) (Math.random() * (col-2) + 2);
                                }while(tabla[p1][p2].equals("*")||tabla[p1][p2].equals("#")||tabla[p1][p2].equals("$")||tabla[p1][p2].equals("@")||tabla[p1][p2].equals("V"));
                                tabla[p1][p2]="@";
                                for (int j = 1; j <= fil; j++) {
                                    for (int k = 1; k <= col; k++) {
                                        System.out.print(tabla[j][k]);
                                    }
                                    System.out.println();
                                }
                                movimientos[userCont] = movimientos[userCont] + 1;
                                punteo[userCont] = punteo[userCont] + 10;
                                System.out.println(" ");
                                System.out.println("Siempre que desees terminar el juego presiona M.");
                                System.out.println("Movimientos: " + movimientos[userCont]);
                                System.out.println("Puntaje: " + punteo[userCont]);

                            }

                        }
                        if(!"w".equals(mov)& !"W".equals(mov) & !"s".equals(mov) & !"S".equals(mov) & !"d".equals(mov) & !"D".equals(mov) & !"a".equals(mov) & !"A".equals(mov)){
                            for (int j = 1; j <= fil; j++) {
                                for (int k = 1; k <= col; k++) {
                                    System.out.print(tabla[j][k]);
                                }
                                System.out.println();
                            }
                            System.out.println("Movimientos: " + movimientos[userCont]);
                            System.out.println("Puntaje: " + punteo[userCont]);
                            System.out.println("*** CONTROLES NO VALIDOS ***");
                            System.out.println("Los controles para jugar son: ");
                            System.out.println("W = Arriba");
                            System.out.println("S = Abajo");
                            System.out.println("A = Izquierda");
                            System.out.println("D = Derecha");

                        }

                        if(mov.equals("M") || mov.equals("m")){
                            cancelar=1;
                        }

                        if(punteo[userCont]==0){
                            cancelar=2;
                        }

                    }while(cancelar<1 || cancelar>2);

                    if(punteo[userCont]==0){

                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("****** FIN DEL JUEGO ******");
                        System.out.println("Su puntuación fue 0.");
                        do {
                            System.out.println("");
                            System.out.println("Presione 1 para volver al menu!");
                            op2 = leer.nextInt();
                        }while (op2<1 || op2>1);
                    }
                    if(cancelar==1){
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("");
                        System.out.println("****** FIN DEL JUEGO ******");
                        System.out.println("Haz decidido terminar el juego!");
                        System.out.println("Su puntuación es: "+ punteo[userCont] + " con un total de: " + movimientos[userCont] +" movimientos.");
                        do {
                            System.out.println("");
                            System.out.println("Presione 1 para volver al menu!");
                            op2 = leer.nextInt();
                        }while (op2<1 || op2>1);
                    }

                }
                if(op==2){
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");
                    System.out.println("");

                    if(userCont==0){
                        System.out.println("Sin historial.");
                    }else{
                        System.out.println("*** HISTORIAL ***");
                        cn=0;
                        for(int i=1; i<=userCont; i++) {
                            if (punteo[i]>1) {
                                cn=cn+1;
                                System.out.println("°°°JUGADOR " + cn +"°°°");
                                System.out.println("Nombre: " + nom[i]);
                                System.out.println("Edad: " + edad[i]);
                                System.out.println("Puntuacion: " + punteo[i]);
                                System.out.println("Movimientos: " + movimientos[i]);
                                System.out.println("*****************");
                            }
                        }
                    }
                    do{
                        System.out.println("Desea regresar al menu? Oprima 1.");
                        op2=leer.nextInt();
                    }while(op2<1 || op2>1);

                }
                if(op==3){
                    System.exit(0);
                    return;
                }
            }
            while(op2==1);


            if(op<1 || op>3){
                System.out.println("Ingrese la opcion valida.");
            }

        }while(op<1 || op>3);

    }
}


