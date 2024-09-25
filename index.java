class Animal {
    public void animalSound() { // Parent class method
        System.out.println("The animal makes a sound");
    }
}

class Pig extends Animal { // Child class inheriting from Animal
    @Override
    public void animalSound() { // Override the parent method
        System.out.println("The pig says: wee wee");
    }
}

class Dog extends Animal { // Another child class inheriting from Animal
    @Override
    public void animalSound() { // Override the parent method
        System.out.println("The dog says: bow wow");
    }
}

class index {
    public static void main(String[] args) {
        Animal myAnimal = new Animal(); // Create an Animal object
        Animal myPig = new Pig(); // Create a Pig object (polymorphism)
        Animal myDog = new Dog(); // Create a Dog object (polymorphism)
        myAnimal.animalSound(); // Calls Animal's animalSound
        myPig.animalSound(); // Calls Pig's animalSound
        myDog.animalSound(); // Calls Dog's animalSound
    }
}
