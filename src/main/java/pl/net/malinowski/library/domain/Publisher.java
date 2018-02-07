package pl.net.malinowski.library.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "publishers")
@Getter @Setter @NoArgsConstructor
public class Publisher {

    @Id
    private String id;

    private String organizationName;

    public Publisher(String organizationName) {
        this.organizationName = organizationName;
    }
}
