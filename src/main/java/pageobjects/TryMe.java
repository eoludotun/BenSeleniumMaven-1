//package pageobjects;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.Reader;
//import java.util.Map;
//import java.util.Set;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.List;
//import org.yaml.snakeyaml.Yaml;
//
//import com.esotericsoftware.yamlbeans.YamlReader;
//
//import org.testng.internal.Configuration;
//import java.util.Map;
//
//public class TryMe {
//	
////	public static Configuration load(String filepath) throws FileNotFoundException {
////	    Configuration result = new Configuration();
////	    Reader input = new FileReader(new File(filepath));
////	    Yaml yaml = new Yaml();
////	    Map<String, Object> map = (Map<String, Object>) yaml.load(input);
////	    result.hostAddress = map2PeerAddress(map);
////	    List<Map> neighborList = (List<Map>) map.get("Neighbors");
////	    result.neighbors = new PeerAddress[neighborList.size()];
////	    for (int i = 0; i < neighborList.size(); i++) {
////	        result.neighbors[i] = map2PeerAddress(neighborList.get(i));
////	    }
////	    return result;
////	}
////	/**
////	 * {@inheritDoc}
////	 */
////	@Override
////	public int read(InputStream in, ColumnInfo[] columns, Callback callback) {
////	    try {
////	        int count = 0;
////	        Yaml yaml = new Yaml();
////	        for (Object o : yaml.loadAll(new InputStreamReader(in, charset))) {
////	            @SuppressWarnings("unchecked")
////	            Map<String, Object> param = (Map<String, Object>) o;
////	            if (param == null || param.isEmpty()) {
////	                continue;
////	            }
////
////	            if (!hasAllKeys(param, columns)) {
////	                Log.w("Fixtures", String.format("not mutch columns. ignore %d th", count + 1));
////	                continue;
////	            }
////
////	            Row row = new Row(++count);
////	            for (int i = 0; i < columns.length; i++) {
////	                Object value = param.get(columns[i].getName());
////	                row.add(columns[i], value == null ? null : value.toString());
////	            }
////
////	            callback.handleRow(row);
////	        }
////
////	        return count;
////	    } catch (IOException e) {
////	        throw new RuntimeException(e);
////	    }
////	}
//	 
//	public void load_yml_as_map_snake() {
//
////	    String yamlAsString = "{JYaml: Original Java Implementation, "
////	            + "JvYaml: Java port of RbYaml, SnakeYAML: {{$guid}}, "
////	            + "YamlBeans: To/from JavaBeans}";
////	    
//	    String yamlAsString = "{\r\n" + 
//	    		"    \"data\": {\r\n" + 
//	    		"        \"shipFrom\": {\r\n" + 
//	    		"            \"country\": \"US\",\r\n" + 
//	    		"            \"region\": \"\"\r\n" + 
//	    		"        },\r\n" + 
//	    		"        \"shipTo\": {\r\n" + 
//	    		"            \"country\": \"US\",\r\n" + 
//	    		"            \"region\": \"NY\"\r\n" + 
//	    		"        },\r\n" + 
//	    		"        \"currency\": \"USD\",\r\n" + 
//	    		"        \"shipping\": {\r\n" + 
//	    		"            \"method\": \"COURIER\",\r\n" + 
//	    		"            \"cost\": \"Testuser{{$randomInt}}\"\r\n" + 
//	    		"        },\r\n" + 
//	    		"        \"items\": [{\r\n" + 
//	    		"            \"mid\": 1232,\r\n" + 
//	    		"            \"sku\": \"000000000004888144\",\r\n" + 
//	    		"            \"qty\": 1,\r\n" + 
//	    		"            \"cost\": 2789.99\r\n" + 
//	    		"        }]\r\n" + 
//	    		"    }\r\n" + 
//	    		"}";
//	    	    
//	  
//	    Yaml yaml = new Yaml();
//
//	    @SuppressWarnings("unchecked")
//	    Map<String, String> yamlParsers = (Map<String, String>) yaml
//	            .load(yamlAsString);
//	    System.out.println(yamlParsers.values());
////	    System.out.println(yamlParsers.keySet());
//	    System.out.println(yamlParsers.get("shipFrom"));
//	    System.out.println(yamlParsers.get("country"));
//	    Set<String> ben = yamlParsers.keySet();
//	    
//
////	    assertThat(yamlParsers.keySet(),
////	            hasItems("JYaml", "JvYaml", "YamlBeans", "SnakeYAML"));
//	}
//	
//	public void loadFromFile(String path) throws IOException {
//	      System.out.printf("-- loading from %s --%n", path);
//	      Yaml yaml = new Yaml();
//	      try (InputStream in = this.getClass().getResourceAsStream(path)) {
//	          Iterable<Object> itr = yaml.loadAll(in);
//	          for (Object o : itr) {
//	              System.out.println("Loaded object type:" + o.getClass());
//	              System.out.println(o);            
//	          }
//	      }
//	}
//	               
//	public void getIndividualFruit(String path, String value)throws IOException {
//		YamlReader reader = new YamlReader(new FileReader(path));
//		Object object = reader.read();
//		System.out.println(object);
//	    Map map = (Map)object;
//		System.out.println(map.get(value));
//		
//	          
//	          
//	      }
//	      
//	      
//	      
//	      
//	      
//	      
//	      
//	
////	 private static void loadFromFile(String path) throws IOException {
////	      System.out.printf("-- loading from %s --%n", path);
////	      Yaml yaml = new Yaml();
////	      try (InputStream in = LoadMapList.class.getResourceAsStream(path)) {
////	          Iterable<Object> itr = yaml.loadAll(in);
////	          for (Object o : itr) {
////	              System.out.println("Loaded object type:" + o.getClass());
////	              Map<String, List<String>> map = (Map<String, List<String>>) o;
////	              System.out.println("-- the map --");
////	              System.out.println(map);
////	              System.out.println("-- iterating --");
////	              map.entrySet().forEach((e) -> {
////	                  System.out.println("key: " + e.getKey());
////	                  System.out.println("values:");
////	                  List<String> list = e.getValue();
////	                  for (String s : list) {
////	                      System.out.println(s);
////	                  }
////	              });
////	          }
////	      }
////	  }
//	}
//
//	
