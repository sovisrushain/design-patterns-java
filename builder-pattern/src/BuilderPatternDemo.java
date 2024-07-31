public class BuilderPatternDemo {
    public static void main(String[] args) {
        House house = new House.HouseBuilder()
                .setFoundation("Concrete")
                .setStructure("Wood and Brick")
                .setRoof("Sheet")
                .setInterior("Paint")
                .build();

        System.out.println(house);
    }
}
