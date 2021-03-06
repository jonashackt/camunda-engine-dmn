/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.camunda.dmn.engine.impl.transform;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.model.dmn.instance.Decision;
import org.camunda.bpm.model.dmn.instance.DecisionTable;
import org.camunda.bpm.model.dmn.instance.DmnModelElementInstance;
import org.camunda.bpm.model.dmn.instance.LiteralExpression;
import org.camunda.dmn.engine.transform.DmnElementHandler;
import org.camunda.dmn.engine.transform.DmnElementHandlerRegistry;

public class DmnElementHandlerRegistryImpl implements DmnElementHandlerRegistry {

  protected Map<Class<? extends DmnModelElementInstance>, DmnElementHandler> elementHandlers = new HashMap<Class<? extends DmnModelElementInstance>, DmnElementHandler>();

  public DmnElementHandlerRegistryImpl() {
    elementHandlers.put(Decision.class, new DmnDecisionHandler());
    elementHandlers.put(DecisionTable.class, new DmnDecisionTableHandler());
    elementHandlers.put(LiteralExpression.class, new DmnLiteralExpressionHandler());
  }

  @SuppressWarnings("unchecked")
  public <Target extends DmnModelElementInstance, Source> DmnElementHandler<Target, Source> getElementHandler(Class<Target> elementClass) {
    return elementHandlers.get(elementClass);
  }

}
