package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Access extends Controller {

	public static void index() {
    	String name = "ReqAGILE";
        render(name);
    }

}