package org.shaolinmasters.akkadianlexicon.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Source {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false, name = "catalogue_ref")
  private String catalogueRef;

  @Lob
  @Column(nullable = false, columnDefinition = "MEDIUMTEXT")
  private String text;

  @ManyToOne
  @JoinColumn(name = "king_id")
  private King king;

  @Column(nullable = false)
  private String bibliography;

  @ManyToMany
  // @JoinTable not required, only included for explicit definition of names
  @JoinTable(
      name = "word_source",
      joinColumns = @JoinColumn(name = "source_id"),
      inverseJoinColumns = @JoinColumn(name = "word_id"))
  private List<Word> words;

  // hashcode
  // equals

}