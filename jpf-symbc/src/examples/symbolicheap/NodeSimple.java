/*
 * Copyright (C) 2014, United States Government, as represented by the
 * Administrator of the National Aeronautics and Space Administration.
 * All rights reserved.
 *
 * Symbolic Pathfinder (jpf-symbc) is licensed under the Apache License, 
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0. 
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and 
 * limitations under the License.
 */

package symbolicheap;

import gov.nasa.jpf.symbc.Debug;

public class NodeSimple {

	int elem;
    NodeSimple next;
  
	
    public NodeSimple(int x) {
    	elem = x;
    	next = null;
    }
	//test z
    public void test(NodeSimple n) {
    	if(n!=null && n.next!=null)
    		System.out.println("nulllllllllllllllllll1111111111asdasda");
    	if(n!=null && n.elem == 2){
    		System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaa222222222222");
    	}
    }
	public static void main(String[] args) {	
		
		NodeSimple X = new NodeSimple(5);
        (new NodeSimple(0)).test(X);
	}

}
