package by.ryabchikov.lab1.model.figure.polygons.quadrangles;

import by.ryabchikov.lab1.model.Point;
import by.ryabchikov.lab1.model.figure.polygons.PolygonAbstract;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Data
public abstract class QuadrangleAbstract extends PolygonAbstract {
    protected Point startPoint;
    protected int width;
    protected int height;
    public QuadrangleAbstract(Point startPoint, int width, int height) {
        super();
        this.startPoint = startPoint;
        this.width = width;
        this.height = height;
    }
}
