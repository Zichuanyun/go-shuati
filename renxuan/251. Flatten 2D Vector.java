public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> outer;
    Iterator<Integer> inner;

    public Vector2D(List<List<Integer>> vec2d) {
        outer = vec2d.iterator();
        inner = null;
    }

    @Override
    public Integer next() {
        if(!hasNext()) return null;
        return inner.next();
    }

    @Override
    public boolean hasNext() {
        while ((inner == null || !inner.hasNext()) && outer.hasNext())
            inner = outer.next().iterator();
        return inner != null && inner.hasNext();
    }

    @Override
    public void remove() {}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
 