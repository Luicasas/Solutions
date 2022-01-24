class ParkingSystem {
    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int small, int medium, int big) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        switch (carType) {
            case 1 -> {
                if (this.small > 0) {
                    this.small -= 1;
                    return true;
                }
            }
            case 2 -> {
                if (this.medium > 0) {
                    this.medium -= 1;
                    return true;
                }
            }
            case 3 -> {
                if (this.big > 0) {
                    this.big -= 1;
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
