package dto;

public enum Permission {
    Normal(1),
    Manager(2);

    private final int value;
    Permission(int value){this.value=value;}
    public int getValue(){return this.value;}
}
