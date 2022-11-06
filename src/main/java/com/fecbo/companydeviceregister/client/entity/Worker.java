package com.fecbo.companydeviceregister.client.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "worker")
@NoArgsConstructor
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "worker_id")
    @ToString.Include
    private Integer workerId;

    @NotBlank(message = "error.'${validatedValue}'.empty")
    @Column(name = "name")
    @ToString.Include
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    @JsonBackReference
    @NotNull(message = "error.'${validatedValue}'.empty")
    @ToString.Exclude
    private Group group;

    @Column(name = "details")
    @ToString.Include
    private String details;

    @OneToMany(mappedBy = "worker", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    @ToString.Include
    private Set<Device> devices = new HashSet<>();
}
