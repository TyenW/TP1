    public class bool {

    
    static boolean[] GetBoolMap(String frase) {
        int tamanho = Integer.parseInt(String.valueOf(frase.charAt(0))); 
        
        boolean[] arraybool = new boolean[tamanho];
        int count = 0;
        for (int i = 0; i < tamanho * 2 + 1; i++) {
            if (frase.charAt(i) == '1') {
                arraybool[count] = true;
                count++;
            } else if (frase.charAt(i) == '0') {
                arraybool[count] = false;
                count++;
            }
        }
        return arraybool;
    }

    public static void main(String[] args) {
        boolean arraybool[];
        while (true) {
            String frase = MyIO.readLine();
            if (igual_0(frase)) {
                break;
            }
            arraybool = GetBoolMap(frase); 
                                          
            frase = GetOperators(frase, arraybool); 
            

            frase = CalculateBooleanExpresion(frase);
            MyIO.println(frase);

        }

    }

    
    public static String CalculateBooleanExpresion(String frase) {
       
        int operadores = 0;

        for (int i = 0; i < frase.length(); i++) { 
            if (frase.charAt(i) == '^' || frase.charAt(i) == 'V' || frase.charAt(i) == '!') {
                operadores++;
            }
        }

        int[] OperatorsIndex = new int[operadores]; 
        int index = 0; 

        for (int i = frase.length() - 1; i >= 0; i--) { 
                                                       
            if (frase.charAt(i) == '^' || frase.charAt(i) == 'V' || frase.charAt(i) == '!') {
                OperatorsIndex[index] = i;
                index++;
            }
        }

        for (int i : OperatorsIndex) { 
            if (frase.charAt(i) == '^') {
                frase = andElement(frase, i);
            } else if (frase.charAt(i) == 'V') {
                frase = OrElement(frase, i);
            } else if (frase.charAt(i) == '!') {

                frase = notElementSingle(frase, i);
            }
        }

        return frase;
    }

   
    public static String andElement(String frase, int index) {
        StringBuilder newFrase = new StringBuilder();
        int i = 0;
        int length = frase.length();
    
        while (i < length) {
            if (i == index) {
                int count = 0;
                int positivo = 0;
                int currentIndex = index; 
                while (frase.charAt(currentIndex) != ')') {
                    char c = frase.charAt(currentIndex);
                    if (Character.isDigit(c)) {
                        count++;
                        if (c == '1') {
                            positivo++;
                        }
                    }
                    currentIndex++;
                }
    
               
                newFrase.append((positivo == count) ? '1' : '0');
    
                i = currentIndex + 1; 
            } else {
                newFrase.append(frase.charAt(i));
                i++;
            }
        }
    
        return newFrase.toString();
    }
    

    
    public static String notElementSingle(String frase, int index) {
        StringBuilder newFrase = new StringBuilder();
        int i = 0;
        int length = frase.length();
    
        while (i < length) {
            if (i == index) {
                int count = 0;
    
                
                while (frase.charAt(index) != ')') {
                    char c = frase.charAt(index);
                    if (Character.isDigit(c)) {
                        count++;
                        newFrase.append(c == '1' ? '0' : '1'); 
                    }
                    index++; 
                }
    
                i += count + 3; 
            } else {
                newFrase.append(frase.charAt(i));
                i++;
            }
        }
    
        return newFrase.toString();
    }
    

    
    public static String OrElement(String frase, int index) {
        StringBuilder newFrase = new StringBuilder();
        int i = 0;
        int length = frase.length();
    
        while (i < length) {
            if (i == index) {
                int count = 0;
                int positivo = 0;
                int currentIndex = index; 
                while (frase.charAt(currentIndex) != ')') {
                    char c = frase.charAt(currentIndex);
                    if (Character.isDigit(c)) {
                        count++;
                        if (c == '1') {
                            positivo++;
                        }
                    }
                    currentIndex++;
                }
    
                
                newFrase.append((positivo > 0) ? '1' : '0');
    
                i += count + 3;
            } else {
                newFrase.append(frase.charAt(i));
                i++;
            }
        }
    
        return newFrase.toString();
    }
    

   
    public static String CleanString(String frase) {
        String newfrase = "";
        int newindex = 0; 

        
        for (int i = 0; i < frase.length(); i++) { 
            if (frase.charAt(i) == 'V' || frase.charAt(i) == '!' || frase.charAt(i) == '^') {
                newindex = i;
                break; 
            }
            if (!clear(frase.charAt(i))) { 
                newfrase += frase.charAt(i); 
            }
        }

        for (int i = newindex; i < frase.length(); i++) {
            if (frase.charAt(i) == ' ' || frase.charAt(i) == ',')
                continue; 
            else
                newfrase += frase.charAt(i);
        }
        
        return newfrase;
    }

    
    public static String getBoolValue(String frase, boolean[] arraybool) {
        String newfrase = "";
        int qtd = arraybool.length;

        for (char element : frase.toCharArray()) {
            if (element == 'A') {
                if (arraybool[0]) {
                    newfrase += '1';
                } else {
                    newfrase += '0';
                }
            } else if (element == 'B' && qtd > 1) {
                if (arraybool[1]) {
                    newfrase += '1';
                } else {
                    newfrase += '0';
                }
            } else if (element == 'C' && qtd > 2) {
                if (arraybool[2]) {
                    newfrase += '1';
                } else {
                    newfrase += '0';
                }
            } else {
                newfrase += element;
            }
        }
        return newfrase;
    }

   
    public static String GetOperators(String frase, boolean[] arraybool) {

        frase = equalsAnd(frase); 
        frase = equalsNot(frase); 
        frase = equalsOr(frase);
        frase = (getBoolValue(frase, arraybool)); 
        frase = CleanString(frase); 

        return frase;
    }

    
    public static String equalsNot(String frase) {
        return frase.replace("not", "!");
    }
    
    
    public static String equalsOr(String frase) {
        return frase.replace("or", "V");
    }
    
    
    public static String equalsAnd(String frase) {
        return frase.replace("and", "^");
    }
    
    
    static boolean igual_0(String frase) {
        return frase.equals("0");
    }
    
    
    static boolean clear(char c) {
        return Character.isDigit(c) || c == ' ' || c == ',' || c == '.';
    }

    
    static boolean isnumber(char c) {
        return Character.isDigit(c);
    }
}