package az.pashabank.groggyphoenix.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Book {
    private int id;
    private String title;
    private String description;
    private int year;
    private String author;
}
