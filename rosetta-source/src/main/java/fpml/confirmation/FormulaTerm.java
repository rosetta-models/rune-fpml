package fpml.confirmation;

import com.google.common.collect.ImmutableList;
import com.rosetta.model.lib.RosettaModelObject;
import com.rosetta.model.lib.RosettaModelObjectBuilder;
import com.rosetta.model.lib.annotations.RosettaAttribute;
import com.rosetta.model.lib.annotations.RosettaDataType;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.path.RosettaPath;
import com.rosetta.model.lib.process.BuilderMerger;
import com.rosetta.model.lib.process.BuilderProcessor;
import com.rosetta.model.lib.process.Processor;
import com.rosetta.util.ListEquals;
import fpml.confirmation.FormulaTerm;
import fpml.confirmation.FormulaTerm.FormulaTermBuilder;
import fpml.confirmation.FormulaTerm.FormulaTermBuilderImpl;
import fpml.confirmation.FormulaTerm.FormulaTermImpl;
import fpml.confirmation.PricingParameterDerivativeReference;
import fpml.confirmation.meta.FormulaTermMeta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

/**
 * A type defining a term of the formula. Its value is the product of the its coefficient and the referenced partial derivatives.
 * @version ${project.version}
 */
@RosettaDataType(value="FormulaTerm", builder=FormulaTerm.FormulaTermBuilderImpl.class, version="${project.version}")
public interface FormulaTerm extends RosettaModelObject {

	FormulaTermMeta metaData = new FormulaTermMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The coefficient by which this term is multiplied, typically 1 or -1.
	 */
	BigDecimal getCoefficient();
	/**
	 * A reference to the partial derivative.
	 */
	List<? extends PricingParameterDerivativeReference> getPartialDerivativeReference();

	/*********************** Build Methods  ***********************/
	FormulaTerm build();
	
	FormulaTerm.FormulaTermBuilder toBuilder();
	
	static FormulaTerm.FormulaTermBuilder builder() {
		return new FormulaTerm.FormulaTermBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FormulaTerm> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FormulaTerm> getType() {
		return FormulaTerm.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("coefficient"), BigDecimal.class, getCoefficient(), this);
		processRosetta(path.newSubPath("partialDerivativeReference"), processor, PricingParameterDerivativeReference.class, getPartialDerivativeReference());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FormulaTermBuilder extends FormulaTerm, RosettaModelObjectBuilder {
		PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder getOrCreatePartialDerivativeReference(int _index);
		List<? extends PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder> getPartialDerivativeReference();
		FormulaTerm.FormulaTermBuilder setCoefficient(BigDecimal coefficient);
		FormulaTerm.FormulaTermBuilder addPartialDerivativeReference(PricingParameterDerivativeReference partialDerivativeReference0);
		FormulaTerm.FormulaTermBuilder addPartialDerivativeReference(PricingParameterDerivativeReference partialDerivativeReference1, int _idx);
		FormulaTerm.FormulaTermBuilder addPartialDerivativeReference(List<? extends PricingParameterDerivativeReference> partialDerivativeReference2);
		FormulaTerm.FormulaTermBuilder setPartialDerivativeReference(List<? extends PricingParameterDerivativeReference> partialDerivativeReference3);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("coefficient"), BigDecimal.class, getCoefficient(), this);
			processRosetta(path.newSubPath("partialDerivativeReference"), processor, PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder.class, getPartialDerivativeReference());
		}
		

		FormulaTerm.FormulaTermBuilder prune();
	}

	/*********************** Immutable Implementation of FormulaTerm  ***********************/
	class FormulaTermImpl implements FormulaTerm {
		private final BigDecimal coefficient;
		private final List<? extends PricingParameterDerivativeReference> partialDerivativeReference;
		
		protected FormulaTermImpl(FormulaTerm.FormulaTermBuilder builder) {
			this.coefficient = builder.getCoefficient();
			this.partialDerivativeReference = ofNullable(builder.getPartialDerivativeReference()).filter(_l->!_l.isEmpty()).map(list -> list.stream().filter(Objects::nonNull).map(f->f.build()).filter(Objects::nonNull).collect(ImmutableList.toImmutableList())).orElse(null);
		}
		
		@Override
		@RosettaAttribute("coefficient")
		public BigDecimal getCoefficient() {
			return coefficient;
		}
		
		@Override
		@RosettaAttribute("partialDerivativeReference")
		public List<? extends PricingParameterDerivativeReference> getPartialDerivativeReference() {
			return partialDerivativeReference;
		}
		
		@Override
		public FormulaTerm build() {
			return this;
		}
		
		@Override
		public FormulaTerm.FormulaTermBuilder toBuilder() {
			FormulaTerm.FormulaTermBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FormulaTerm.FormulaTermBuilder builder) {
			ofNullable(getCoefficient()).ifPresent(builder::setCoefficient);
			ofNullable(getPartialDerivativeReference()).ifPresent(builder::setPartialDerivativeReference);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FormulaTerm _that = getType().cast(o);
		
			if (!Objects.equals(coefficient, _that.getCoefficient())) return false;
			if (!ListEquals.listEquals(partialDerivativeReference, _that.getPartialDerivativeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (coefficient != null ? coefficient.hashCode() : 0);
			_result = 31 * _result + (partialDerivativeReference != null ? partialDerivativeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FormulaTerm {" +
				"coefficient=" + this.coefficient + ", " +
				"partialDerivativeReference=" + this.partialDerivativeReference +
			'}';
		}
	}

	/*********************** Builder Implementation of FormulaTerm  ***********************/
	class FormulaTermBuilderImpl implements FormulaTerm.FormulaTermBuilder {
	
		protected BigDecimal coefficient;
		protected List<PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder> partialDerivativeReference = new ArrayList<>();
	
		public FormulaTermBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("coefficient")
		public BigDecimal getCoefficient() {
			return coefficient;
		}
		
		@Override
		@RosettaAttribute("partialDerivativeReference")
		public List<? extends PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder> getPartialDerivativeReference() {
			return partialDerivativeReference;
		}
		
		public PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder getOrCreatePartialDerivativeReference(int _index) {
		
			if (partialDerivativeReference==null) {
				this.partialDerivativeReference = new ArrayList<>();
			}
			PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder result;
			return getIndex(partialDerivativeReference, _index, () -> {
						PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder newPartialDerivativeReference = PricingParameterDerivativeReference.builder();
						return newPartialDerivativeReference;
					});
		}
		
		@Override
		@RosettaAttribute("coefficient")
		public FormulaTerm.FormulaTermBuilder setCoefficient(BigDecimal coefficient) {
			this.coefficient = coefficient==null?null:coefficient;
			return this;
		}
		@Override
		public FormulaTerm.FormulaTermBuilder addPartialDerivativeReference(PricingParameterDerivativeReference partialDerivativeReference) {
			if (partialDerivativeReference!=null) this.partialDerivativeReference.add(partialDerivativeReference.toBuilder());
			return this;
		}
		
		@Override
		public FormulaTerm.FormulaTermBuilder addPartialDerivativeReference(PricingParameterDerivativeReference partialDerivativeReference, int _idx) {
			getIndex(this.partialDerivativeReference, _idx, () -> partialDerivativeReference.toBuilder());
			return this;
		}
		@Override 
		public FormulaTerm.FormulaTermBuilder addPartialDerivativeReference(List<? extends PricingParameterDerivativeReference> partialDerivativeReferences) {
			if (partialDerivativeReferences != null) {
				for (PricingParameterDerivativeReference toAdd : partialDerivativeReferences) {
					this.partialDerivativeReference.add(toAdd.toBuilder());
				}
			}
			return this;
		}
		
		@Override 
		@RosettaAttribute("partialDerivativeReference")
		public FormulaTerm.FormulaTermBuilder setPartialDerivativeReference(List<? extends PricingParameterDerivativeReference> partialDerivativeReferences) {
			if (partialDerivativeReferences == null)  {
				this.partialDerivativeReference = new ArrayList<>();
			}
			else {
				this.partialDerivativeReference = partialDerivativeReferences.stream()
					.map(_a->_a.toBuilder())
					.collect(Collectors.toCollection(()->new ArrayList<>()));
			}
			return this;
		}
		
		
		@Override
		public FormulaTerm build() {
			return new FormulaTerm.FormulaTermImpl(this);
		}
		
		@Override
		public FormulaTerm.FormulaTermBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FormulaTerm.FormulaTermBuilder prune() {
			partialDerivativeReference = partialDerivativeReference.stream().filter(b->b!=null).<PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder>map(b->b.prune()).filter(b->b.hasData()).collect(Collectors.toList());
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCoefficient()!=null) return true;
			if (getPartialDerivativeReference()!=null && getPartialDerivativeReference().stream().filter(Objects::nonNull).anyMatch(a->a.hasData())) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FormulaTerm.FormulaTermBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FormulaTerm.FormulaTermBuilder o = (FormulaTerm.FormulaTermBuilder) other;
			
			merger.mergeRosetta(getPartialDerivativeReference(), o.getPartialDerivativeReference(), this::getOrCreatePartialDerivativeReference);
			
			merger.mergeBasic(getCoefficient(), o.getCoefficient(), this::setCoefficient);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FormulaTerm _that = getType().cast(o);
		
			if (!Objects.equals(coefficient, _that.getCoefficient())) return false;
			if (!ListEquals.listEquals(partialDerivativeReference, _that.getPartialDerivativeReference())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (coefficient != null ? coefficient.hashCode() : 0);
			_result = 31 * _result + (partialDerivativeReference != null ? partialDerivativeReference.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FormulaTermBuilder {" +
				"coefficient=" + this.coefficient + ", " +
				"partialDerivativeReference=" + this.partialDerivativeReference +
			'}';
		}
	}
}
