package chapter1;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * 생성자에 매개변수가 많다면 빌더를 고려하라.
 * 관련 사항 - lombok-builder-inheritance
 */
public class Item2 {
}

abstract class Pizza{
    public enum Topping {HAM,MUSHROOM,ONION,PEPPER,SAUSAGE}
    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>>{
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);
        public T addTopping(Topping topping){
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();
        protected abstract T self();
    }

    Pizza(Builder<?> builder){
        toppings = builder.toppings.clone();
    }
}

class NyPizza extends Pizza{
    public enum Size {SMALL, MEDIUM, LARGE};
    private final Size size;

    public static class Builder extends Pizza.Builder<Builder>{
        private final Size size;
        public Builder(Size size){
            this.size = Objects.requireNonNull(size);
        }

        @Override
        public NyPizza build(){
            return new NyPizza(this);
        }

        @Override
        protected Builder self(){
            return this;
        }
    }

    private NyPizza(Builder builder){
        super(builder);
        size = builder.size;
    }
}
