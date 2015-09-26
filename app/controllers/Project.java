package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

public class Project extends Controller {

	public static void createProject() {
    	String name = "ReqAGILE";
        render(name);
    }

}