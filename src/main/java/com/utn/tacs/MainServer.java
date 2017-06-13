package com.utn.tacs;

import com.utn.tacs.routing.Router;

/**
 * Created by alalbiero on 6/10/17.
 */
public class MainServer {
    public static void main(String[] args) throws Exception {
        new Router().init();
    }
}
