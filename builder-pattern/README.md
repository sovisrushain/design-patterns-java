# Builder Pattern

The Builder design pattern is a creational pattern used to construct complex objects step by step. It separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

The Builder Pattern is useful when you need to construct an object that requires many different parts and configurations. This pattern is particularly helpful in situations where constructors with many parameters would become cumbersome and hard to manage.

### Example

First, we define the House class, which will be the product constructed by the builder:

```angular2html
public class House {
    private String foundation;
    private String structure;
    private String roof;
    private String interior;

    private House(HouseBuilder builder) {
        this.foundation = builder.foundation;
        this.structure = builder.structure;
        this.roof = builder.roof;
        this.interior = builder.interior;
    }

    @Override
    public String toString() {
        return "House [foundation=" + foundation + ", structure=" + structure +
                ", roof=" + roof + ", interior=" + interior + "]";
    }

    public static class HouseBuilder {
        private String foundation;
        private String structure;
        private String roof;
        private String interior;

        public HouseBuilder setFoundation(String foundation) {
            this.foundation = foundation;
            return this;
        }

        public HouseBuilder setStructure(String structure) {
            this.structure = structure;
            return this;
        }

        public HouseBuilder setRoof(String roof) {
            this.roof = roof;
            return this;
        }

        public HouseBuilder setInterior(String interior) {
            this.interior = interior;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}
```

### Explanation

1. House Class: This is the product class with private fields and a private constructor that takes a HouseBuilder object.
2. HouseBuilder Class: This static nested class contains the same fields as House and methods for setting these fields. Each method returns the HouseBuilder object itself (this), allowing method chaining.
3. build Method: This method constructs the final House object using the builder's current state.


### Usage

```angular2html
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
```
### Explanation of Usage
1. Create Builder Instance: We create a new instance of HouseBuilder.
2. Set Attributes: We set the attributes of the house using the builder methods.
3. Build the House: We call the build method to get the final House object.
4. Output: Finally, we print the House object, which shows the set attributes.

## Benefits of Builder Pattern

1. Readability: The code for constructing an object is more readable and understandable.
2. Flexibility: The same construction process can create different representations.
3. Immutability: The final object can be immutable if desired, as it's only constructed once with all required attributes.
4. Reduced Complexity: The construction process is separated from the object, reducing the complexity of object creation.
