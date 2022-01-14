package ejerciciosnivel01;
import java.util.Arrays;

/**
 *
 * @author xp
 */
public class EjerciciosNivel01 {
    public int[] maximos(int[] lista){
        int[] arrayMaximos = {0,0};
        for (int i=0; i<lista.length; i++){
            if(lista[i] > arrayMaximos[0]){
                arrayMaximos[1] = arrayMaximos[0];
                arrayMaximos[0] = lista[i];
            }
            else if(lista[i] > arrayMaximos[1]){
                arrayMaximos[1] = lista[i];
            }
        }
        return arrayMaximos;
    }
    //segundo ejercicio: palindromo
    //para hacer este ejercicio necesito hacer primero
    //una funcion que "limpie" el string para quitarle los acentos y los espaci
    //os en blanco
    
    private String limpiaFrase (String frase){
        frase = frase.toLowerCase(); //paso la frase a minúsculas
        frase = frase.replace('á', 'a');
        frase = frase.replace('é', 'a');
        frase = frase.replace('í', 'a');
        frase = frase.replace('ó', 'a');
        frase = frase.replace('ú', 'a');
        //quito también los espacios en blanco
        frase = frase.replace(" ", "");
        
        return frase;
    }
    
    public boolean esPalindromo(String frase){
        frase = limpiaFrase(frase); //quita acentos y espacios en la frase
        
        int indiceIzquierdo = 0;
        int indiceDerecho = frase.length()-1;
        
        while (frase.charAt(indiceIzquierdo) == frase.charAt(indiceDerecho) &&
                indiceIzquierdo <= indiceDerecho){
            indiceIzquierdo++;
            indiceDerecho--;
        }
        if(indiceIzquierdo > indiceDerecho){
            return true;
        }
        else{
            return false;
        }
    }
        public boolean esIsograma (String palabra){
            palabra = limpiaFrase(palabra);
            for (int i=0; i< palabra.length(); i++){
                for (int j=i+1; j< palabra.length(); j++){
                    if (palabra.charAt(i) == palabra.charAt(j)){
                        return false;
                    }
                }
            }
            return true;
        }
        /**
         * Convierte una frase en su acronimo
         * @param frase la frase a convertir en acrónimo 
         * @return el Acronimo en mayuscula
         */
        public String acronimo(String frase){
            //suponemos que por lo menos hay una letra en la...
            frase = frase.toUpperCase();
            String palabras[] = frase.split(" ");
            String resultado ="";
            for (int i=0; i< palabras.length; i++){
                    if (!(palabras[i].equals("Y") || palabras[i].equals("E") || 
                    palabras[i].equals("DE") || palabras[i].equals("LA") ||
                    palabras[i].equals("LAS") ) ){
                    
                    resultado = resultado + palabras[i].charAt(0);
                    }
            }
            return resultado;
        }
        public boolean anagrama (String palabra1, String palabra2){
            palabra1= limpiaFrase(palabra1);
            palabra2= limpiaFrase(palabra2);
            if(palabra1.length() != palabra2.length()){
                return false;//tienen distinto nº de letras
            }else{
            for (int i=0; i<palabra1.length(); i++){
                int j=0; 
                while (j < palabra2.length() && palabra1.charAt(i) != palabra2.charAt(j)){
                    j++;
                }
                if(j == palabra2.length()){//sale del while por que la letra no esta
                    return false;//ai no esta en la comparacion de cada letra
                }else{
                palabra2 = palabra2.substring(0, j) + palabra2.substring(j+1);
                }}   
            if (palabra2.length() == 0){
                return true;
            }else{
                return false;
                }
            }
        }
         public boolean anagramaV2 (String palabra1, String palabra2){
            palabra1= limpiaFrase(palabra1);
            palabra2= limpiaFrase(palabra2);
            if(palabra1.length() != palabra2.length()){
                return false;//tienen distinto nº de letras
            }else{
            for (int i=0; i<palabra1.length(); i++){
             if(palabra2.contains("" + palabra1.charAt(i))){
                 palabra2 = palabra2.replaceFirst("" + palabra1.charAt(i), "*");
                 //coge la segunda palabra y la sustituye por el assterisco
             }else{
                 return false;
             }
            }
            return true;
            }
        }
         public void imprimeMes(int numX){
             int contador = 0; //para saber que dia de la semana estoy imprimiendo
             //primera fase: imprime las XX
             for (int i=0; i< numX; i++){
                System.out.print("XX ");
                contador++;
             }
             // segunda fase: imprime los numeros desde el uno al treinta y uno
             for (int i=1; i<=31; i++){
                 if(i<10){
                     System.out.print("0"+ i + " ");
                 }else{
                     System.out.print(i + " ");
                 }
                 contador++;
                 if(contador % 7 == 0){
                     System.out.println("");
                 }
             }
             
             
             //tercera fase imprimo las XX del final
             while (contador % 7 != 0){
                 System.out.print("XX ");
             contador++;
             }
}
    public static void main(String[] args) {
        int[] numeros = {99, 37, 7, 54, 13};
        int[] numeros2 = {-1, 100, 8, 84, 103, 1005};
        EjerciciosNivel01 e = new EjerciciosNivel01();
                System.out.print(Arrays.toString(e.maximos(numeros)));
                System.out.print(Arrays.toString(e.maximos(numeros2)));
                System.out.println(e.esPalindromo("Acaso hubo buhos acá"));
                System.out.println(e.esIsograma("Pájaro"));
                System.out.println(e.esIsograma("Tijeras"));
                System.err.println("acronimo de Alta Velocidad Española: " + 
                e.acronimo ("Alta Velocidad Española "));
                System.err.println("Tecnologia de la Informaciom y de la Comunicacion: " + 
                e.acronimo ("Tecnologia de la Informaciom y de la Comunicacion"));
                System.out.println(e.anagramaV2("ROMA", "MORA"));
                e.imprimeMes(3);
                //e.imprimeMes(5);
    }
}