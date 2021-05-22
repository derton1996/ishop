package org.example.ishop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product extends BaseEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "gauge")
    private String gauge;

    @Column(name = "country_origin")
    private String countryOrigin;

    @Column(name = "description")
    private String description;

    public Product() {
    }

    public Product(String id) {
        this.id = id != null ? id : UUID.randomUUID().toString();
    }

    public Product(String gauge, String countryOrigin, String description) {
        this.id = UUID.randomUUID().toString();
        this.gauge = gauge;
        this.countryOrigin = countryOrigin;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGauge() {
        return gauge;
    }

    public void setGauge(String gauge) {
        this.gauge = gauge;
    }

    public String getCountryOrigin() {
        return countryOrigin;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", gauge='" + gauge + '\'' +
                ", countryOrigin='" + countryOrigin + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
