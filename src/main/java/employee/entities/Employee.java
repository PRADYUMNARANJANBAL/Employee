package employee.entities;


    import jakarta.persistence.*;
    import lombok.AllArgsConstructor;
    import lombok.Data;
    import lombok.NoArgsConstructor;

    // import javax.persistence.*;
    import java.math.BigDecimal;
    import java.time.LocalDate;
    import java.util.List;
   @Data
   @AllArgsConstructor
   @NoArgsConstructor
    @Entity
    @Table(name = "employee")
    public class Employee {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(name = "employee_id", nullable = false, unique = true)
        private String employeeId;

        @Column(name = "first_name", nullable = false)
        private String firstName;

        @Column(name = "last_name", nullable = false)
        private String lastName;

        @Column(nullable = false)
        private String email;

        @ElementCollection
        @CollectionTable(name = "employee_phone_numbers", joinColumns = @JoinColumn(name = "employee_id"))
        @Column(name = "phone_number")
        private List<String> phoneNumbers;

        @Column(name = "date_of_joining", nullable = false)
        private LocalDate doj;

        @Column(nullable = false)
        private BigDecimal salary;

    }


