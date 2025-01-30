public class CircularTour {
    // method to find the starting petrol pump index
    public static int findStartingPoint(int[] petrol, int[] distance) {
        // Total petrol available
        int totalPetrol = 0;
        // Total distance required to travel
        int totalDistance = 0;
        // Potential starting index
        int start = 0;
        // Petrol balance while traveling
        int currentPetrol = 0;

        //Distance covered by specific amount of petro;
        for (int i = 0; i < petrol.length; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
            currentPetrol += petrol[i] - distance[i];

            // If balance petrol is negative, reset start index and petrol balance
            if (currentPetrol < 0) {
                start = i + 1;
                currentPetrol = 0;
            }
        }

        // If total petrol is less than total distance, no complete tour is possible
        return (totalPetrol >= totalDistance) ? start : -1;
    }

    public static void main(String[] args) {
        int[] petrol = {15, 6, 17, 4};
        int[] distance = {10, 15, 3, 5};

        // Finding the starting index
        int startIndex = findStartingPoint(petrol, distance);

        //output
        if (startIndex != -1) {
            System.out.println("Start at petrol pump index: " + startIndex);
        } else {
            System.out.println("No possible circular tour");
        }
    }
}