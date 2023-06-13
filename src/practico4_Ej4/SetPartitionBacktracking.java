package practico4_Ej4;

import java.util.ArrayList;
import java.util.List;

public class SetPartitionBacktracking {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6};
        ArrayList<Integer> foundPartition = partition(nums);
        
        System.out.println("¿Se encontró una partición?: " + !foundPartition.isEmpty() + " : " + foundPartition);
    }

    public static ArrayList<Integer> partition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Verificar si la suma total es impar (no se puede encontrar una partición)
        if (totalSum % 2 != 0) {
            return new ArrayList<>();
        }

        int targetSum = totalSum / 2;
        List<Integer> currentPartition = new ArrayList<>();
        if(backtrack(nums, targetSum, 0, currentPartition)){
        	return new ArrayList<>(currentPartition);
        }
        
        return new ArrayList<>();
    }

    private static boolean backtrack(int[] nums, int targetSum, int startIndex, List<Integer> currentPartition) {
        // Verificar si se alcanzó el objetivo de suma
        if (targetSum == 0) {
            return true;
        }

        // Recorrer los elementos restantes del conjunto
        for (int i = startIndex; i < nums.length; i++) {
            // Verificar si el elemento actual es válido para agregar a la partición
            if (nums[i] <= targetSum) {
                // Agregar el elemento actual a la partición
                currentPartition.add(nums[i]);

                // Llamar recursivamente al backtrack con el siguiente elemento
                boolean foundPartition = backtrack(nums, targetSum - nums[i], i + 1, currentPartition);
                if (foundPartition) {
                    return true;
                }

                // Retroceder (backtrack): eliminar el último elemento agregado
                currentPartition.remove(currentPartition.size() - 1);
            }
        }

        return false;
    }
}
