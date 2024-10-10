package fpml.confirmation;

import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import fpml.confirmation.Formula;
import fpml.confirmation.FormulaComponent;
import fpml.confirmation.FormulaComponent.FormulaComponentBuilder;
import fpml.confirmation.FormulaComponent.FormulaComponentBuilderImpl;
import fpml.confirmation.FormulaComponent.FormulaComponentImpl;
import fpml.confirmation.meta.FormulaComponentMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Elements describing the components of the formula. The name attribute points to a value used in the math element. The href attribute points to a numeric value defined elsewhere in the document that is used by the formula component.
 * @version ${project.version}
 */
@RosettaDataType(value="FormulaComponent", builder=FormulaComponent.FormulaComponentBuilderImpl.class, version="${project.version}")
public interface FormulaComponent extends RosettaModelObject {

	FormulaComponentMeta metaData = new FormulaComponentMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Text description of the component
	 */
	String getComponentDescription();
	/**
	 * Additional formulas required to describe this component
	 */
	Formula getFormula();
	String getName();

	/*********************** Build Methods  ***********************/
	FormulaComponent build();
	
	FormulaComponent.FormulaComponentBuilder toBuilder();
	
	static FormulaComponent.FormulaComponentBuilder builder() {
		return new FormulaComponent.FormulaComponentBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FormulaComponent> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FormulaComponent> getType() {
		return FormulaComponent.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("componentDescription"), String.class, getComponentDescription(), this);
		processRosetta(path.newSubPath("formula"), processor, Formula.class, getFormula());
		processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FormulaComponentBuilder extends FormulaComponent, RosettaModelObjectBuilder {
		Formula.FormulaBuilder getOrCreateFormula();
		Formula.FormulaBuilder getFormula();
		FormulaComponent.FormulaComponentBuilder setComponentDescription(String componentDescription);
		FormulaComponent.FormulaComponentBuilder setFormula(Formula formula);
		FormulaComponent.FormulaComponentBuilder setName(String name);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("componentDescription"), String.class, getComponentDescription(), this);
			processRosetta(path.newSubPath("formula"), processor, Formula.FormulaBuilder.class, getFormula());
			processor.processBasic(path.newSubPath("name"), String.class, getName(), this);
		}
		

		FormulaComponent.FormulaComponentBuilder prune();
	}

	/*********************** Immutable Implementation of FormulaComponent  ***********************/
	class FormulaComponentImpl implements FormulaComponent {
		private final String componentDescription;
		private final Formula formula;
		private final String name;
		
		protected FormulaComponentImpl(FormulaComponent.FormulaComponentBuilder builder) {
			this.componentDescription = builder.getComponentDescription();
			this.formula = ofNullable(builder.getFormula()).map(f->f.build()).orElse(null);
			this.name = builder.getName();
		}
		
		@Override
		@RosettaAttribute("componentDescription")
		public String getComponentDescription() {
			return componentDescription;
		}
		
		@Override
		@RosettaAttribute("formula")
		public Formula getFormula() {
			return formula;
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		public FormulaComponent build() {
			return this;
		}
		
		@Override
		public FormulaComponent.FormulaComponentBuilder toBuilder() {
			FormulaComponent.FormulaComponentBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FormulaComponent.FormulaComponentBuilder builder) {
			ofNullable(getComponentDescription()).ifPresent(builder::setComponentDescription);
			ofNullable(getFormula()).ifPresent(builder::setFormula);
			ofNullable(getName()).ifPresent(builder::setName);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FormulaComponent _that = getType().cast(o);
		
			if (!Objects.equals(componentDescription, _that.getComponentDescription())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (componentDescription != null ? componentDescription.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FormulaComponent {" +
				"componentDescription=" + this.componentDescription + ", " +
				"formula=" + this.formula + ", " +
				"name=" + this.name +
			'}';
		}
	}

	/*********************** Builder Implementation of FormulaComponent  ***********************/
	class FormulaComponentBuilderImpl implements FormulaComponent.FormulaComponentBuilder {
	
		protected String componentDescription;
		protected Formula.FormulaBuilder formula;
		protected String name;
	
		public FormulaComponentBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("componentDescription")
		public String getComponentDescription() {
			return componentDescription;
		}
		
		@Override
		@RosettaAttribute("formula")
		public Formula.FormulaBuilder getFormula() {
			return formula;
		}
		
		@Override
		public Formula.FormulaBuilder getOrCreateFormula() {
			Formula.FormulaBuilder result;
			if (formula!=null) {
				result = formula;
			}
			else {
				result = formula = Formula.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("name")
		public String getName() {
			return name;
		}
		
		@Override
		@RosettaAttribute("componentDescription")
		public FormulaComponent.FormulaComponentBuilder setComponentDescription(String componentDescription) {
			this.componentDescription = componentDescription==null?null:componentDescription;
			return this;
		}
		@Override
		@RosettaAttribute("formula")
		public FormulaComponent.FormulaComponentBuilder setFormula(Formula formula) {
			this.formula = formula==null?null:formula.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("name")
		public FormulaComponent.FormulaComponentBuilder setName(String name) {
			this.name = name==null?null:name;
			return this;
		}
		
		@Override
		public FormulaComponent build() {
			return new FormulaComponent.FormulaComponentImpl(this);
		}
		
		@Override
		public FormulaComponent.FormulaComponentBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FormulaComponent.FormulaComponentBuilder prune() {
			if (formula!=null && !formula.prune().hasData()) formula = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getComponentDescription()!=null) return true;
			if (getFormula()!=null && getFormula().hasData()) return true;
			if (getName()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FormulaComponent.FormulaComponentBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FormulaComponent.FormulaComponentBuilder o = (FormulaComponent.FormulaComponentBuilder) other;
			
			merger.mergeRosetta(getFormula(), o.getFormula(), this::setFormula);
			
			merger.mergeBasic(getComponentDescription(), o.getComponentDescription(), this::setComponentDescription);
			merger.mergeBasic(getName(), o.getName(), this::setName);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FormulaComponent _that = getType().cast(o);
		
			if (!Objects.equals(componentDescription, _that.getComponentDescription())) return false;
			if (!Objects.equals(formula, _that.getFormula())) return false;
			if (!Objects.equals(name, _that.getName())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (componentDescription != null ? componentDescription.hashCode() : 0);
			_result = 31 * _result + (formula != null ? formula.hashCode() : 0);
			_result = 31 * _result + (name != null ? name.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FormulaComponentBuilder {" +
				"componentDescription=" + this.componentDescription + ", " +
				"formula=" + this.formula + ", " +
				"name=" + this.name +
			'}';
		}
	}
}
