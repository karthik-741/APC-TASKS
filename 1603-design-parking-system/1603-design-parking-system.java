class ParkingSystem {
    private int[] count;

    public ParkingSystem(int big, int medium, int small) {
        // Index 1 = big, 2 = medium, 3 = small
        count = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (count[carType] > 0) {
            count[carType]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */