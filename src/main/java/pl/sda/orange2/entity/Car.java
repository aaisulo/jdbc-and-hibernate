package pl.sda.orange2.entity;
// recordy klasa - dla klasy bez seterownikow



public record Car(
        Long id,
        String colour,
        String brand,
        String model
) {
}
