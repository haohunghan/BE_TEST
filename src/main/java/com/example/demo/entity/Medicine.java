package com.example.demo.entity;

import com.example.demo.common.StringPrefixedSequenceIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "medicine")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Medicine extends SequenceStyleGenerator {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "medicine_sequence")
    @GenericGenerator(
            name= "medicine_sequence",
            strategy = "com.example.demo.common.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "MD_"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
            }
    )
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Integer price;
}
