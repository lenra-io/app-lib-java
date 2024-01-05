package io.lenra.applibjava;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.lenra.applibjava.component.View;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Manifest {
    private Exposer json;
    private Exposer lenra;

    
    public Exposer getJson() {
        return json;
    }

    public void setJson(Exposer json) {
        this.json = json;
    }

    public Exposer getLenra() {
        return lenra;
    }

    public void setLenra(Exposer lenra) {
        this.lenra = lenra;
    }


    public static class Exposer {
        private List<Route> routes;

        public Exposer() {
        }

        public Exposer(List<Route> routes) {
            this.routes = routes;
        }

        public List<Route> getRoutes() {
            return routes;
        }
    }

    public static class Route {
        private String path;
        private View view;

        public Route() {
        }

        public Route(String path, View view) {
            this.path = path;
            this.view = view;
        }

        public String getPath() {
            return path;
        }

        public View getView() {
            return view;
        }
    }
}
