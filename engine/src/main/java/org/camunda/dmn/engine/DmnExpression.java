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

package org.camunda.dmn.engine;

import org.camunda.dmn.engine.context.DmnDecisionContext;

public interface DmnExpression {

  void setId(String id);

  String getId();

  void setVariableName(String variableName);

  String getVariableName();

  void setExpression(String expression);

  String getExpression();

  void setExpressionLanguage(String expressionLanguage);

  String getExpressionLanguage();

  <T> T evaluate(DmnDecisionContext decisionContext);

}
