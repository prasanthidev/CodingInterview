package com.ib.strings;

import java.util.ArrayList;

public class PrettyJson {
	
	public class Solution{
		
		public ArrayList<String> prettyJSON(String a) {
		    ArrayList<StringBuilder> output = new ArrayList<StringBuilder>();
			output = toJSON(a, output, 0,  new ArrayList<StringBuilder>());
						
			ArrayList<String> json2 = new ArrayList<String>();
			for(int i=0; i<output.size(); i++){	
				json2.add(output.get(i).toString());	
				json2.add("\n");
			}
			return json2;	
		}
		
		public StringBuilder StringtoJSON(String a){
			ArrayList<StringBuilder> output = new ArrayList<StringBuilder>();			
			output = toJSON(a, output, 0,  new ArrayList<StringBuilder>());
			
			StringBuilder json = new StringBuilder();
			for(int i=0; i<output.size(); i++){			
				json.append(output.get(i).toString());
				json.append("\n");
			}
			return json;		
		}
		
		private StringBuilder addSpace(int lineCount, String data){
			StringBuilder line = new StringBuilder();
			while(lineCount > 0){
				line.append("\t");
				lineCount--;
			}
			return line.append(data);
		}
		
		private ArrayList<StringBuilder> toJSON(String a, ArrayList<StringBuilder> output, int lineCount, ArrayList<StringBuilder> closeBrace){
			char[] json = a.toCharArray();
			int length = a.length();
			
			int i=0;
			if(json[i] == '{' )
				closeBrace.add(new StringBuilder(addSpace(lineCount, "}")));
			if(json[i] == '[')
				closeBrace.add(new StringBuilder(addSpace(lineCount, "]")));
			if((json[i]== '}' || json[i] == ']') && json[i+1] == ','){
				output.add(addSpace(lineCount, "" + json[i] + ","));
				i++;
				lineCount--;
			}
			else if(json[i]!= '}' && json[i] != ']')
				output.add(addSpace(lineCount, "" + json[i]));
			i++;
			if(i<length){		
				String line = "";
				while(json[i] != '}' && json[i] != ']'){
					if(json[i] == '{' ||  json[i] == '['){
						if(!line.equals(" ") && !line.equals(""))
							output.add(addSpace(lineCount+1, line.trim()));
						line = "";
						return toJSON(a.substring(i, length), output, lineCount+1, closeBrace);
					}
					if(json[i] == '"'){
						line += json[i];
						i++;
						while(json[i] != '"'){
							line += json[i];
							i++;
						}
					}
					line += json[i];
					
					if(json[i] == ',' && !line.equals(",")){
						output.add(addSpace(lineCount+1, line));
						line = "";
					}else if(line.equals(",")){
						line="";
					}
					
					i++;
				}
				if(!line.equals(""))
					output.add(addSpace(lineCount+1, line));
				
				if(i<length-1 && (json[i+1] == '}'||json[i+1] == ']')){
					output.add(addSpace(lineCount--, ""+json[i]));
					closeBrace.remove(closeBrace.size()-1);
					return toJSON(a.substring(i, length), output, lineCount, closeBrace);
				}
				
				if(i<length-1 && json[i+1] == ','){
					closeBrace.remove(closeBrace.size()-1);
					return toJSON(a.substring(i, length), output, lineCount, closeBrace);
				}
				for(int j=closeBrace.size()-1; j>=0; j--){	
					output.add(closeBrace.get(j));
				}
			}
			return output;
		}
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrettyJson obj = new PrettyJson();
		Solution sol = obj.new Solution();
		//System.out.println(sol.prettyJSON("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}"));
		//System.out.println(sol.prettyJSON("[\"foo\",{\"bar\":[\"baz\",null,1.0,2]}]"));
		//System.out.println(sol.prettyJSON("{\"array\":[1,2,3],\"boolean\":true,\"number\":123,\"object\":{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"},\"string\":\"Hello World\"}"));
		System.out.println(sol.prettyJSON("[{\"_id\":\"57f23fda91b0413eb912250c\",\"index\":0,\"guid\":\"4bbd4881-d69e-4c95-93b2-85b4f37e4eb7\",\"isActive\":false,\"balance\":\"$2,537.05\",\"picture\":\"http://placehold.it/32x32\",\"age\":37,\"eyeColor\":\"blue\",\"name\":\"Jenny Ross\",\"gender\":\"female\",\"company\":\"ESSENSIA\",\"email\":\"jennyross@essensia.com\",\"phone\":\"+1 (957) 417-3756\",\"address\":\"227 Clifford Place, Nanafalia, District Of Columbia, 4300\",\"about\":\"Mollit non velit nulla magna nisi cupidatat aliquip elit adipisicing dolore tempor. Eiusmod dolore officia aute nisi ipsum culpa. Deserunt sint ex id quis amet in labore sit reprehenderit reprehenderit culpa ex consequat. Aliquip ex in voluptate ad nulla est dolore aliqua consectetur nostrud.\",\"registered\":\"2015-08-15T12:52:30 -06:-30\",\"latitude\":-59.725406,\"longitude\":162.200984,\"tags\":[\"Lorem\",\"exercitation\",\"culpa\",\"in\",\"consectetur\",\"exercitation\",\"proident\"],\"friends\":[{\"id\":0,\"name\":\"Holcomb Watts\"},{\"id\":1,\"name\":\"Angelina Harvey\"},{\"id\":2,\"name\":\"Flowers Carver\"}],\"greeting\":\"Hello, Jenny Ross! You have 3 unread messages.\",\"favoriteFruit\":\"apple\"},{\"_id\":\"57f23fdaa1b85398104a2448\",\"index\":1,\"guid\":\"c4f977c6-93d4-4112-a3a4-fa537b5b118b\",\"isActive\":true,\"balance\":\"$1,498.35\",\"picture\":\"http://placehold.it/32x32\",\"age\":20,\"eyeColor\":\"green\",\"name\":\"Walton Miller\",\"gender\":\"male\",\"company\":\"CONFRENZY\",\"email\":\"waltonmiller@confrenzy.com\",\"phone\":\"+1 (903) 483-3567\",\"address\":\"183 Cumberland Walk, Farmers, Wyoming, 4754\",\"about\":\"Magna do officia laboris ut quis nostrud non veniam sint voluptate exercitation reprehenderit qui est. Est pariatur enim nostrud nulla quis qui cupidatat. Aliquip mollit anim elit proident adipisicing eiusmod aliquip dolor occaecat in id pariatur velit. Do laboris eu consectetur proident ad laboris elit laboris irure anim velit minim. Lorem aliquip nisi commodo ad quis sit.\",\"registered\":\"2014-10-16T02:12:16 -06:-30\",\"latitude\":-15.327753,\"longitude\":-76.18179,\"tags\":[\"ex\",\"non\",\"labore\",\"consectetur\",\"do\",\"commodo\",\"dolore\"],\"friends\":[{\"id\":0,\"name\":\"Lori Hanson\"},{\"id\":1,\"name\":\"Katherine Clemons\"},{\"id\":2,\"name\":\"Byers Burt\"}],\"greeting\":\"Hello, Walton Miller! You have 6 unread messages.\",\"favoriteFruit\":\"banana\"},{\"_id\":\"57f23fda8a95d209b4d32f81\",\"index\":2,\"guid\":\"d61d169a-5489-419d-9ee8-45281f5223fd\",\"isActive\":true,\"balance\":\"$1,107.42\",\"picture\":\"http://placehold.it/32x32\",\"age\":20,\"eyeColor\":\"green\",\"name\":\"Valencia Mooney\",\"gender\":\"male\",\"company\":\"GYNKO\",\"email\":\"valenciamooney@gynko.com\",\"phone\":\"+1 (869) 553-2859\",\"address\":\"403 Dupont Street, Shrewsbury, Guam, 7783\",\"about\":\"Lorem id duis nulla ea ad enim officia. Amet adipisicing in voluptate dolore et enim ullamco. Lorem incididunt Lorem Lorem quis nostrud enim incididunt. Id ex ullamco culpa nisi eu ut anim incididunt ea cupidatat aliquip est deserunt amet. Enim ad quis minim labore elit. Lorem amet in dolore sit nisi cupidatat ad ipsum labore id quis et deserunt.\r\",\"registered\":\"2015-03-14T07:16:55 -06:-30\",\"latitude\":41.409798,\"longitude\":-51.364671,\"tags\":[\"veniam\",\"aliqua\",\"nulla\",\"in\",\"labore\",\"commodo\",\"elit\"],\"friends\":[{\"id\":0,\"name\":\"Guthrie Martin\"},{\"id\":1,\"name\":\"Christian Jones\"},{\"id\":2,\"name\":\"Kelsey Sweet\"}],\"greeting\":\"Hello, Valencia Mooney! You have 10 unread messages.\",\"favoriteFruit\":\"apple\"},{\"_id\":\"57f23fda381b5b697399bec1\",\"index\":3,\"guid\":\"a5716976-44ae-409f-b04b-44b2d0fc77a8\",\"isActive\":true,\"balance\":\"$1,013.96\",\"picture\":\"http://placehold.it/32x32\",\"age\":32,\"eyeColor\":\"green\",\"name\":\"Florine Tran\",\"gender\":\"female\",\"company\":\"GORGANIC\",\"email\":\"florinetran@gorganic.com\",\"phone\":\"+1 (931) 592-3746\",\"address\":\"756 Degraw Street, Crenshaw, Louisiana, 8175\",\"about\":\"Incididunt laboris eu aliquip pariatur eu sit voluptate occaecat fugiat ut exercitation qui. Sunt commodo ut pariatur duis dolore aliqua excepteur veniam. Ut non culpa laborum pariatur ut dolore reprehenderit.\r\",\"registered\":\"2015-08-23T06:20:28 -06:-30\",\"latitude\":-0.251308,\"longitude\":-19.677524,\"tags\":[\"consectetur\",\"aliquip\",\"laboris\",\"enim\",\"ex\",\"aute\",\"sint\"],\"friends\":[{\"id\":0,\"name\":\"Rogers Mccullough\"},{\"id\":1,\"name\":\"Tina Douglas\"},{\"id\":2,\"name\":\"Foley Pierce\"}],\"greeting\":\"Hello, Florine Tran! You have 2 unread messages.\",\"favoriteFruit\":\"strawberry\"},{\"_id\":\"57f23fda10c4b81f2a4c581e\",\"index\":4,\"guid\":\"8d800818-a3ac-459d-a24c-f9753fe33691\",\"isActive\":false,\"balance\":\"$1,489.88\",\"picture\":\"http://placehold.it/32x32\",\"age\":29,\"eyeColor\":\"brown\",\"name\":\"Irma Kelley\",\"gender\":\"female\",\"company\":\"ZILLAR\",\"email\":\"irmakelley@zillar.com\",\"phone\":\"+1 (861) 585-3820\",\"address\":\"952 Graham Avenue, Thynedale, Marshall Islands, 9814\",\"about\":\"Nostrud nisi amet est eu deserunt occaecat elit pariatur occaecat consectetur. Id id laborum aute officia sunt duis et proident amet esse nisi pariatur ut dolor. Duis laboris sit dolore esse eu culpa et ut quis cupidatat Lorem ipsum nisi. Officia et enim non incididunt adipisicing voluptate eu fugiat eiusmod incididunt elit cillum.\r\",\"registered\":\"2016-04-01T11:19:06 -06:-30\",\"latitude\":-64.349834,\"longitude\":173.580019,\"tags\":[\"adipisicing\",\"nulla\",\"ad\",\"laborum\",\"aliquip\",\"exercitation\",\"in\"],\"friends\":[{\"id\":0,\"name\":\"Curtis Hines\"},{\"id\":1,\"name\":\"Glenna Woods\"},{\"id\":2,\"name\":\"Doreen Justice\"}],\"greeting\":\"Hello, Irma Kelley! You have 1 unread messages.\",\"favoriteFruit\":\"apple\"},{\"_id\":\"57f23fda17f7c4d2dd4dfc31\",\"index\":5,\"guid\":\"8b60a78d-764b-4929-b976-d9160327815a\",\"isActive\":true,\"balance\":\"$2,744.93\",\"picture\":\"http://placehold.it/32x32\",\"age\":32,\"eyeColor\":\"green\",\"name\":\"Erika Woodard\",\"gender\":\"female\",\"company\":\"CRUSTATIA\",\"email\":\"erikawoodard@crustatia.com\",\"phone\":\"+1 (846) 556-2688\",\"address\":\"542 Willow Place, Darrtown, Virginia, 1403\",\"about\":\"Eiusmod aliqua ullamco proident sunt in consequat non non voluptate aliquip proident esse dolore cillum. Ullamco incididunt deserunt aute do consectetur cupidatat occaecat eu incididunt enim non sint nisi. Pariatur culpa amet eiusmod cillum ut voluptate.\",\"registered\":\"2016-04-03T07:01:01 -06:-30\",\"latitude\":-9.517761,\"longitude\":72.354806,\"tags\":[\"officia\",\"mollit\",\"mollit\",\"adipisicing\",\"fugiat\",\"pariatur\",\"qui\"],\"friends\":[{\"id\":0,\"name\":\"Stacie Bowers\"},{\"id\":1,\"name\":\"Dawn Hill\"},{\"id\":2,\"name\":\"Rochelle Barlow\"}],\"greeting\":\"Hello, Erika Woodard! You have 4 unread messages.\",\"favoriteFruit\":\"strawberry\"}]"));
		
		
	}

}
