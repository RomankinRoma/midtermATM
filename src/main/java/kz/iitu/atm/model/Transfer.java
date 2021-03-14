package kz.iitu.atm.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Long amount;
    @ManyToOne
    @JoinColumn(name = "sender_id", insertable = false, updatable = false)
    @JsonIgnore
    private User sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id", insertable = false, updatable = false)
    @JsonIgnore
    private User receiver;
    @Column(name = "sender_id")
    private Integer senderId;
    @Column(name = "receiver_id")
    private Integer receiverId;
}
