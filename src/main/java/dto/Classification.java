package dto;

public enum Classification {
    Notice(1),
    Study(2),
    Free(3),
    Documents(4),
    Anonymous(5);

    private final int value;
    Classification(int value){this.value=value;}
    public int getValue(){return this.value;}
}
