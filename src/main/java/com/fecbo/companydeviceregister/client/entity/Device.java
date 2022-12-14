package com.fecbo.companydeviceregister.client.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "device")
@NoArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "device_id")
    @ToString.Include
    @EqualsAndHashCode.Include
    private Integer deviceId;

    @NotBlank(message = "error.'${validatedValue}'.empty")
    @Column(name = "name")
    @ToString.Include
    @EqualsAndHashCode.Include
    private String name;

    @NotNull(message = "error.'${validatedValue}'.empty")
    @Column(name = "description")
    @ToString.Include
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "worker_id", updatable = false, insertable = false)
    @JsonBackReference
    @ToString.Exclude
    private Worker worker;

    @Column(name = "worker_id")
    private Integer workerId;

    @Column(name = "time_of_registration")
    @NotNull(message = "error.'${validatedValue}'.empty")
    private LocalDateTime timeOfRegistration;

}
