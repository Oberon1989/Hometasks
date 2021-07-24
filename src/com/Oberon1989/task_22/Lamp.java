package com.Oberon1989.task_22;

import java.util.Objects;
import java.util.UUID;

public class Lamp {
    String id;
    boolean isEnabled;
    float brightness;
    String color;

    public Lamp() {
        this.id = UUID.randomUUID().toString();
        this.color = Colors.WHITE.getValue();
        this.brightness = 75;
        isEnabled = false;
    }

    public Lamp(boolean isEnabled, float brightness, String color) {
        this.id = UUID.randomUUID().toString();
        this.isEnabled = isEnabled;
        this.brightness = brightness;
        this.color = color;
    }

    public Lamp(Lamp lamp) {
        this.id = UUID.randomUUID().toString();
        this.isEnabled = lamp.isEnabled;
        this.brightness = lamp.brightness;
        this.color = lamp.color;
    }

    public String getId() {
        return id;
    }


    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    public float getBrightness() {
        return brightness;
    }

    public void setBrightness(float brightness) {
        if (brightness <= 100 & brightness > 0) {
            this.brightness = brightness;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(Lamp.Colors color) {
        this.color = color.value;
    }


    @Override
    public String toString() {
        return "Lamp{" +
                "Id='" + id + '\'' +
                ", Enabled=" + isEnabled +
                ", Brightness=" + brightness + " % " +
                ", Color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lamp)) return false;
        Lamp lamp = (Lamp) o;
        return isEnabled() == lamp.isEnabled() && Float.compare(lamp.getBrightness(), getBrightness()) == 0 && getId().equals(lamp.getId()) && getColor().equals(lamp.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), isEnabled(), getBrightness(), getColor());
    }

    enum Colors {
        RED("Red"),
        YELLOW("Yellow"),
        GREEN("Green"),
        PURPLE("Purple"),
        BLUE("Blue"),
        WHITE("White"),
        AQUA("Aqua");

        private String value;

        Colors(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }
}
