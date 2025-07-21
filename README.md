---

# FpML as Rune

This repository is a [Rune DSL](https://github.com/finos/rune-dsl) model that contains Rune representation of the FpML 5.13 schema, Confirmation view.  The model was created by the importing the FpML schema .xsd files, which translates each FpML schema complex type into a equivalent Rune data type, e.g., FpML `<dataDocument>` is imported into the Rune model as type `DataDocument`.

---

## 🔧 Getting Started

### Maven Dependency

```xml
<dependency>
  <groupId>com.regnosys.rune-fpml</groupId>
  <artifactId>rosetta-source</artifactId>
  <version>0.8.1</version>
</dependency>
```

---

## 📚 Further Reading

* Learn more about how Rune DSL maps FpML into Rune model in the documentation ([Rosetta Documentation][6]).

---

## 📄 License

Apache License 2.0

### Exhibit A

- The FpML Specifications of this document are subject to the FpML Public License (the “License”); you may not use the FpML Specifications except in compliance with the License. You may obtain a copy of the License at http://www.FpML.org.
- The FpML Specifications distributed under the License are distributed on an “AS IS” basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific language governing rights and limitations under the License.
- The Licensor of the FpML Specifications is the International Swaps and Derivatives Association, Inc. All Rights Reserved.

---
