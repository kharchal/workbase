package ua.com.hav.workbase.view;

import lombok.Data;
import lombok.NoArgsConstructor;
import ua.com.hav.workbase.model.Client;
import ua.com.hav.workbase.model.Level;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class ClientView {

    private Integer id;

    @Size(min = 3, max = 10)
    private String name;

    @Size(min = 3, max = 10)
    private String surname;
    private Integer personId;
    private Level level;
//    private Integer levelId;
    @Min(0)
    @Max(50000)
    private Integer balance;

    public ClientView(Integer id, String name, String surname, Integer personId, Level level, Integer balance) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.personId = personId;
        this.level = level;
        this.balance = balance;
    }

    public static ClientView convert(Client client) {
        return new ClientView(client.getId(),
                client.getPerson().getName(),
                client.getPerson().getSurname(),
                client.getPerson().getId(),
                client.getLevel(),
                client.getBalance());
    }
}
