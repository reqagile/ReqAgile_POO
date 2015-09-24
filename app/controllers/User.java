package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class User extends Controller {

    public static void home() {
    	String name = "ReqAGILE";
        render(name);
    }

}