{{packages}};

{{imports}};

public class {{Entity}} {
	{{LOOP}}
		private {{propType}} {{propName}};
	{{/LOOP}}
	
	
	{{Setters}}
	
	{{Getters}}
	
	{{toString}}
}