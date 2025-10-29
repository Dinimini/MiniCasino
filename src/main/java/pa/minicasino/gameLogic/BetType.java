package pa.minicasino.gameLogic;

public enum BetType {


    GREATER_THAN(new int[]{1, 2, 3, 4, 5}) {
        @Override
        public double expectedValue(int n) {
            return (double) n/6;
        }
        @Override
        public boolean isWin(int guess, int roll) {
            return guess > roll;
        }
    },
    LESSER_THAN(new int[]{2, 3, 4, 5, 6}) {
        @Override
        public double expectedValue(int n) {
            return (double) n/6;
        }
        @Override
        public boolean isWin(int guess, int roll) {
            return guess < roll;
        }
    },   // Példa logika a LESSER esetén
    ISODD(null) {
        @Override
        public double expectedValue(int n) {
            return 2;
        }
        @Override
        public boolean isWin(int guess, int roll) {
            return guess % 2 != 0;
        }
    },
    ISEVEN(null) {
        @Override
        public double expectedValue(int n) {
            return 2;
        }
        @Override
        public boolean isWin(int guess, int roll) {
            return guess % 2 == 0;
        }
    };

    private String name;
    private int[] acceptedValues;

    BetType(int[] acceptedValues) {
        this.name = this.name().toLowerCase();
        this.acceptedValues = acceptedValues;
    }

    public boolean isAcceptedValue(int n) {
        if(this.acceptedValues == null){
            return true;
        }
        for(int i : acceptedValues){
            if(i == n){
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public BetType getBetType(String name) {
        for (BetType betType : BetType.values()) {
            if (betType.getName().equals(name)) {
                return betType;
            }
        }
        return null;
    }

    public abstract double expectedValue(int n);

    public abstract boolean isWin(int guess, int roll);
}