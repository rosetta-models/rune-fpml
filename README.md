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

Or with Gradle:

```groovy
implementation "com.regnosys.rune-fpml:rosetta-source:0.8.1"
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

* [Rosetta Models](https://github.com/rosetta-models) overview: home to CDM, Rune DSL, and model extensions ([GitHub][5]).
* Learn more about how Rune maps FpML into Rosetta in the Rune Modelling component docs ([Rosetta Documentation][6]).

---

## 🛠️ Contributing

Contributions welcome! Please open issues or pull requests for:

* Adding new FpML message types
* Fixing / expanding mappings and annotations
* Support for more FpML code lists or newer schema versions

---

## 📄 License

Apache License 2.0

---

Let me know if you'd like to expand on usage examples or integration steps!

[1]: https://mvnrepository.com/artifact/com.regnosys.rune-fpml/rosetta-source/0.8.1?utm_source=chatgpt.com "rosetta-source » 0.8.1 - com.regnosys.rune-fpml - Maven Repository"
[2]: https://github.com/finos/rune-dsl/issues/879?utm_source=chatgpt.com "Loading External Reference Data into CDM - FpML Coding Schemes"
[3]: https://github.com/REGnosys/rosetta-dsl/releases?utm_source=chatgpt.com "Releases · finos/rune-dsl - GitHub"
[4]: https://github.com/REGnosys/rosetta-code-generators?utm_source=chatgpt.com "Write code generators for any language, based on the rosetta DSL"
[5]: https://github.com/rosetta-models?utm_source=chatgpt.com "rosetta-models - GitHub"
[6]: https://docs.rosetta-technology.io/rosetta/rosetta-dsl/rune-modelling-component/?utm_source=chatgpt.com "Rune Modelling Components - Rosetta Documentation"
