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

package org.camunda.dmn.engine.impl.context;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.camunda.dmn.engine.context.DmnScriptContext;
import org.camunda.dmn.juel.JuelScriptEngineFactory;

public class DmnScriptContextImpl implements DmnScriptContext {

  public static final String DEFAULT_SCRIPT_LANGUAGE = JuelScriptEngineFactory.NAME;

  protected String defaultScriptLanguage = DEFAULT_SCRIPT_LANGUAGE;
  protected ScriptEngineManager scriptEngineManager;

  public void setDefaultScriptLanguage(String defaultScriptLanguage) {
    this.defaultScriptLanguage = defaultScriptLanguage;
  }

  public String getDefaultScriptLanguage() {
    return defaultScriptLanguage;
  }

  public ScriptEngine getDefaultScriptEngine() {
    return getScriptEngineForName(defaultScriptLanguage);
  }

  public ScriptEngine getScriptEngineForName(String name) {
    return getScriptEngineManager().getEngineByName(name.toLowerCase());
  }

  public void setScriptEngineManager(ScriptEngineManager scriptEngineManager) {
    this.scriptEngineManager = scriptEngineManager;
  }

  public ScriptEngineManager getScriptEngineManager() {
    if (scriptEngineManager == null) {
      synchronized (this) {
        if (scriptEngineManager == null) {
          scriptEngineManager = new ScriptEngineManager();
        }
      }
    }
    return scriptEngineManager;
  }

}
