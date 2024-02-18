/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package im.tarefa1;
import java.util.Scanner;
import java.util.Random;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.lang.Math;

/**
 *
 * @author imcat
 */
public class Tarefa1 {

    public static void main(String[] args) {
//        System.out.println("*** Exercicio Um ***");
//        ex_one();
//        System.out.println("");
//        
//        System.out.println("*** Exercicio 2 ***");
//        ex_two();
//        System.out.println("");
//        
//        System.out.println("*** Exercicio 3 ***");
//        ex_three();
//        System.out.println("");
        
//        System.out.println("*** Exercicio 4 ***");
//        ex_four();
//        System.out.println("");

//        System.out.println("*** Exercicio 5 ***");
//        ex_five();
//        System.out.println("");
        
//        System.out.println("*** Exercicio 6 ***");
//        ex_six();
//        System.out.println("");
        
//        System.out.println("*** Exercicio 7 ***");
//        ex_seven();
//        System.out.println("");
        
        System.out.println("*** Exercicio 8 ***");
        ex_eigth();
        System.out.println("");
    }
    
    public static int fatorial_calc(int number){
        if (number == 0 || number == 1){
            return 1;
        }
        
        return number * fatorial_calc(number - 1);
    }
    
    public static void ex_one(){
        Scanner scanner = new Scanner(System.in);
        int[] array_a = new int[15], array_b = new int[15];
        
        for(int i=0; i<15; i++){
            System.out.printf("Valor %d: ", i+1);
            System.out.print("\n");
            array_a[i] = scanner.nextInt();
            array_b[i] = fatorial_calc(array_a[i]);   
        }
        
        System.out.println("\nVetor a | Vetor b");
        for(int j=0; j<15; j++){
            System.out.printf("%d | %d \n", array_a[j], array_b[j]);
            
        }
        
    }
    
    public static void ex_two(){
        Random random = new Random();
        
        int[] array_a = new int[10], evenOdd = new int[2];
        
        for(int i=0; i<10; i++){
            array_a[i] = random.nextInt();
            
            if(array_a[i] % 2 == 0){
                evenOdd[0] += 1;
            } else {
                evenOdd[1] += 1;
            }
        }
                
        System.out.println("Par | Impar");
        for(int amount : evenOdd){
            System.out.print(amount + "  | ");
        }
    }
    
    public static void ex_three(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Quantos funcionarios deseja cadastrar? ");
        int total = scanner.nextInt();
        scanner.nextLine();
        
        
        String birthday_date;
        String[] names = new String[total];
        
        int[] ages = new int[total], genders = new int[total];
        int total_fem = 0, total_masc = 0;
     
        
        LocalDate[] birthdays = new LocalDate[total];
        LocalDate current_date = LocalDate.now();
        
        System.out.println("\nCadastro de funcionarios");
        for(int i=0; i<total; i++){
            System.out.print("Nome: ");
            names[i] = scanner.nextLine();
            
            System.out.print("Genero: (1)Feminino (2)Masculino ");
            genders[i] = scanner.nextInt();
            scanner.nextLine();
            if(genders[i] == 1){
                total_fem += 1;
            } else if(genders[i] == 2){
                total_masc += 1;
            }
            
            System.out.print("Data de aniverário: (formato: dd/MM/AAAA) ");
            birthday_date = scanner.nextLine();
            
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                
                birthdays[i] = LocalDate.parse(birthday_date, formatter);
            } catch(Exception e){
                System.out.println("Formato de data inválido, insira a data no seguinte formato: dd/MM/yyyy");
            }
            
            System.out.println("");
       
        }
        
        // Calculando a idade dos funcionarios
        for(int i=0; i<total; i++){
            Period period = Period.between(birthdays[i], current_date);
            ages[i] = period.getYears();
        }
        
        System.out.println("\n**Relatorio de funcionarios**");
        for(int i=0; i<total; i++){
            String gender = "gender not defined";
            
            if(genders[i] == 1){
                gender = "feminino";
            } else if(genders[i] == 2){
                gender = "masculino";
            }
            
            System.out.printf("%d. %s, %s", i+1, names[i], gender + ", " + ages[i] + " anos, " + birthdays[i] + "\n");
        }
        
        float fem_percent, masc_percent;
        fem_percent = (total_fem*100)/total;
        masc_percent = (total_masc*100)/total;
        
        int ages_sum = 0, ages_fem_sum = 0, ages_masc_sum = 0, age_medium_rate;
        
        for(int age : ages){
            ages_sum += age;
        }
        
        for(int i=0; i<total; i++){
            if(genders[i] == 1){
                ages_fem_sum += ages[i]; 
            } else if(genders[i] == 2){
                ages_masc_sum += ages[i];
            }
        }
        
        age_medium_rate = ages_sum/total;
        int age_medium_fem_rate = ages_fem_sum/total_fem;
        int age_medium_masc_rate = ages_masc_sum/total_masc;
        
        
        System.out.println("\n**Relatorio final**");
        System.out.printf("Quantidade de funcionarios: %d\nQuantidade de mulheres: %d Percentual: %.2f\nQuantidade de homens: %d Percentual: %.2f", total, total_fem, fem_percent, total_masc, masc_percent);
        System.out.printf("\nIdade media geral: %d\nIdade media das mulheres: %d \nIdade media dos homens: %d", age_medium_rate, age_medium_fem_rate, age_medium_masc_rate);
        
        
    }
    
    public static void average_calc(float score1, float score2, float score3, char average_type, int student){
        float average;
        
        if(average_type == 'a'){
            average = (score1 + score2 + score3)/3;
            System.out.printf("\nMedia airtmetica do aluno %d: %.2f\n", student, average);
        } else if(average_type == 'p'){
            average = (score1*5 + score2*3 + score3 * 2)/10;
            System.out.printf("\nMedia ponderada do aluno %d: %.2f\n", student, average);
        }
    }
    public static void ex_four(){
        Scanner scanner = new Scanner(System.in);
        int number_students, student;
        float score1, score2, score3;
        char average_type;
        
        System.out.printf("Quantidade de alunos: ");
        number_students = scanner.nextInt();
        
        for(int i=0; i<number_students; i++){
            System.out.print("\nNota 1: ");
            score1 = scanner.nextFloat();
            
            System.out.print("Nota 2: ");
            score2 = scanner.nextFloat();
            
            System.out.print("Nota 3: ");
            score3 = scanner.nextFloat();
            
            System.out.print("Tipo de média: (A)Aritmetica (P)Ponderada ");
            average_type = scanner.next().charAt(0);
            
            average_type = Character.toLowerCase(average_type);
            
            student = i+1;
            
            average_calc(score1, score2, score3, average_type, student);
        }
        
    }
    
    public static void calc_population_average_salary(){
        Scanner scanner = new Scanner(System.in);
        
        char flag;
        float sum_salary=0, salary, population_average_salary;
        int son_amount, total_population=0;
        
        System.out.print("Deseja cadastrar habitante? (s)Sim (n)Não ");
        flag = scanner.next().charAt(0);
        flag = Character.toLowerCase(flag);
            
        while(flag == 's'){
            System.out.print("\nSalario: ");
            salary = scanner.nextFloat();
            sum_salary += salary;
            
            System.out.print("Quantidade de filhos: ");
            son_amount = scanner.nextInt();
            total_population += son_amount + 1;
            
            System.out.println("\nDeseja cadastrar habitante? (s)Sim (n)Não ");
            flag = scanner.next().charAt(0);
            flag = Character.toLowerCase(flag);
        }
        
        population_average_salary = sum_salary/total_population;
        
        System.out.printf("\nMedia salarial da população: %.2f", population_average_salary);
    }
    
    public static void ex_five(){
        calc_population_average_salary();
    }
    
    public static void setup_ascending_order(float[] array_numbers){
        Arrays.sort(array_numbers);
        
        System.out.print("Em ordem: ");
        for(float number : array_numbers){
            System.out.printf("%.2f ", number);
        }
        System.out.println("");
    }
    
    public static void ex_six(){
        Scanner scanner = new Scanner(System.in);
        
        int groups_quant;
        float[] numbers = new float[3];
        
        System.out.print("Quantidade de conjuntos de 3 numeros a serem lidos: ");
        groups_quant = scanner.nextInt();
        
        System.out.println("");
        for(int i=0; i<groups_quant; i++){
            for(int j=0; j<numbers.length; j++){
                System.out.printf("Numero %d: ", j+1);
                numbers[j] = scanner.nextFloat();
            }
            setup_ascending_order(numbers);
            System.out.println("");
        }
    }
    
    public static int[] sum_array(int[] array1, int[] array2){
        int[] array_sum = new int[array1.length], inverted_array = new int[array1.length];
        
        for(int i=0; i<array1.length; i++){
            array_sum[i] = array1[i] + array2[i];
        }
        
        List<Integer> list = new ArrayList<>();
        for(int num : array_sum){
            list.add(num);
        }
        
        Collections.reverse(list);
        
//        Integer[] inverted_array_sum = list.toArray(new Integer[0]);
        
        for(int i=0; i<list.size();i++){
            inverted_array[i] = list.get(i);
        }
        
        return inverted_array;
        
    }
    
    public static void ex_seven(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
                
        int array_size;
        System.out.print("Tamanho do vetor que deseja: ");
        array_size = scanner.nextInt();
        
        int[] array1 = new int[array_size], array2 = new int[array_size];
        
        for(int i=0; i<array_size; i++){
            array1[i] = random.nextInt(100);
            array2[i] = random.nextInt(100);
        }
        
        int[] inverted_array_sum = sum_array(array1, array2);
        
        System.out.println("Array a: " + Arrays.toString(array1));
        System.out.println("Array b: " + Arrays.toString(array2));
        System.out.println("Soma dos arrays: " + Arrays.toString(inverted_array_sum));
        
//        System.out.println("Vetor a | Vetor b | Soma dos vetores");
//        for(int i=0; i<array_size; i++){
//            System.out.printf("  %5d | %6d  | %6d \n", array1[i], array2[i], array_sum[i]);
//        ps: da pra substituir isso pelo metodo Arrays.toString(array_name)
//        }
        
    }
    
    public static void ex_eigth(){
        Scanner scanner = new Scanner(System.in);
        
        int[][] matriz = {{5, 10, 7, 8}, {13, 4, 1, 3}, {9,2,6,5}, {10, 7, 4, 9}};
        int [][] matriz_transposta = new int [4][4];        
        // matriz transposta é quando a linha se torna coluna
        
        int item_b=0;
        
        for(int i=0; i<matriz.length;i++){
            for(int j=0; j<matriz[i].length;j++){
                matriz_transposta[j][i] = matriz[i][j];
                
//                if((i+j) == (i*(1-j*1-1))){
//                    int item = matriz[i][j];
//                    item_b += Math.pow(item, 2);
//                }
            }
        }
        System.out.print("\n**item a**\n");
        System.out.println("Matriz Tranposta");
        for(int[] array : matriz_transposta){
            for(int i=0; i<array.length; i++){
                System.out.printf("%d ", array[i]);
            }
            System.out.println("");
        }
        
        // Calculando a some dos quadrados da diagonal secundária
        // indices ds diagonal secundaria: [0][3] - [1][2] - [2][1] - [3][0]
        System.out.print("\n**item b**");
        System.out.println("\nDiagonal Secundária: ");
        for(int i=0; i<matriz.length; i++){
            int item = matriz[i][matriz.length - i - 1];
            item_b += Math.pow(item, 2);
            System.out.printf("%d ", item);
        }
        
        System.out.printf("\nSoma dos quadrados da diagonal secundária: %d", item_b);
        
        // Multiplicação da matriz por constante C
        int constant;
        int[][] matriz_multiplicada = new int[4][4];
        System.out.print("\n\n**item c**\n");
        System.out.print("Insira um valor para multiplicar a matriz: ");
        constant = scanner.nextInt();
        
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                matriz_multiplicada[i][j] = matriz[i][j] * constant;
//                System.out.printf("%d vira %d\n", matriz[i][j], matriz_multiplicada[i][j]);
            }
        }
        
        System.out.printf("\nMatriz multiplicada por %d\n", constant);
        for (int[] matriz_multiplicada1 : matriz_multiplicada) {
            for (int j = 0; j < matriz_multiplicada1.length; j++) {
                System.out.printf("%d ", matriz_multiplicada1[j]);
            }
            System.out.println("");
        }
//        System.out.printf("\nMatriz original multiplicada por %d\n", constant);
//        for(int i=0; i<matriz.length; i++){
//            for(int j=0; j< matriz[i].length; i++){
//                System.out.printf("%d ", matriz_multiplicada[i][j]);
//            }
//            System.out.println("");
//        }

        System.out.println("\n**item d**");
        // terceira linha: [2][0] [2][1] [2][2] [2][3]
        //terceira coluna: [0][2] [1][2] [2][2] [2][3]
        // inverter a linha 2
        
        int[][] matriz_d = new int[4][4];
        
        System.out.println("Matriz com a 3° linha invertida com a 3° coluna da original:");
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz[i].length; j++){
                if (i == 2){
                    matriz_d[j][i] = matriz[i][j];
                    //System.out.printf("%d virou %d\n", matriz[i][j], matriz_d[j][i]);
                } else {
                    matriz_d[i][j] = matriz[i][j];
                }
            }
        }
        
        for (int[] matriz_d1 : matriz_d) {
            for (int j = 0; j < matriz_d1.length; j++) {
                int item = matriz_d1[j];
                System.out.printf("%d ", item);
            }
            System.out.println("");
        }
        
    }        
}
