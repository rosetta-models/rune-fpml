---

# FpML as Rune

This repository is a [Rune DSL](https://github.com/finos/rune-dsl) model that contains Rune representation of the FpML 5.13 schema, Confirmation view.  The model was created by the importing the FpML schema .xsd files, and translating each FpML schema complex type into a equivalent Rune data type, e.g., FpML `<dataDocument>` is imported into the Rune model as type `DataDocument`.

---

## 📦 Overview

This repository contains:

* **Rune DSL definitions** for FpML data types, enumerations, and message structures—
  enabling them to be reused by the Rosetta code-generation toolchain.
* **Rosetta Source library** (`com.regnosys.rune‑fpml:rosetta-source`),
  packaged as a Maven artifact for consumption in Rune-based pipelines.
  Latest version: **0.8.1** published May 6, 2025 ([Maven Repository][1], [GitHub][2]).
* **Model files** (under `.rosetta`) that map FpML schemas (confirmation, trade, etc.) to Rune constructs.
* **Annotations** to link FpML-coded enumerations into TdSL types—so generated code can reference up-to-date FpML code lists ([GitHub][2]).

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

## 🚀 How It Works

1. **FpML schemas** drive the Rune DSL model definitions.
2. **Rune DSL** models are compiled using Rosetta's code generators—producing Java types & factories.
3. These generated types align with **FpML semantics**, enabling seamless ingestion and processing of FpML messages.
4. The Rosetta code generation chain (Java, Kotlin, Go, Python, etc.) can then build APIs that interact directly with FpML-standardized data—no manual coding required.

---

## 🧩 Integration Flow

1. Add `rune-fpml` as a dependency in your Rune project.
2. Include the `.rosetta` namespace files alongside your CDM definitions.
3. Execute the Rosetta code-generation pipeline (`rune-dsl` / `rosetta-maven-plugin`) to produce sources.
4. Use the generated types in your business logic or validation pipelines for message ingestion, transformation, or data exchange.

---

## ✅ Why It Matters

* **Faster integration** between FpML ecosystems and Rosetta/CDM-based systems.
* **Code-gen consistency**, driven from authoritative FpML definitions.
* **Automatic updates** to code lists (e.g., FpML enumerations), reducing manual sync effort ([GitHub][3]).
* **Multi-language support**, leveraging Rosetta generators (Java by default, plus Scala, Go, Kotlin, TypeScript, C#, Python, DAML, …) ([GitHub][4]).

---

## 📚 Further Reading

* Learn more about how Rune DSL maps FpML into Rune model in the documentation ([Rosetta Documentation][6]).

---

## 📄 License

Apache License 2.0

- The FpML Specifications of this document are subject to the FpML Public License (the “License”); you may not use the FpML Specifications except in compliance with the License. You may obtain a copy of the License at http://www.FpML.org.
- The FpML Specifications distributed under the License are distributed on an “AS IS” basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the specific language governing rights and limitations under the License.
- The Licensor of the FpML Specifications is the International Swaps and Derivatives Association, Inc. All Rights Reserved.

---
