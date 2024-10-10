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
import fpml.confirmation.PricingParameterDerivativeReference;
import fpml.confirmation.WeightedPartialDerivative;
import fpml.confirmation.WeightedPartialDerivative.WeightedPartialDerivativeBuilder;
import fpml.confirmation.WeightedPartialDerivative.WeightedPartialDerivativeBuilderImpl;
import fpml.confirmation.WeightedPartialDerivative.WeightedPartialDerivativeImpl;
import fpml.confirmation.meta.WeightedPartialDerivativeMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A partial derivative multiplied by a weighting factor.
 * @version ${project.version}
 */
@RosettaDataType(value="WeightedPartialDerivative", builder=WeightedPartialDerivative.WeightedPartialDerivativeBuilderImpl.class, version="${project.version}")
public interface WeightedPartialDerivative extends RosettaModelObject {

	WeightedPartialDerivativeMeta metaData = new WeightedPartialDerivativeMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A reference to a partial derivative defined in the ComputedDerivative.model, i.e. defined as part of this sensitivity definition.
	 */
	PricingParameterDerivativeReference getPartialDerivativeReference();
	/**
	 * The weight factor to be applied to the partial derivative, e.g. 1 or -1, or some other scaling value.
	 */
	BigDecimal getWeight();

	/*********************** Build Methods  ***********************/
	WeightedPartialDerivative build();
	
	WeightedPartialDerivative.WeightedPartialDerivativeBuilder toBuilder();
	
	static WeightedPartialDerivative.WeightedPartialDerivativeBuilder builder() {
		return new WeightedPartialDerivative.WeightedPartialDerivativeBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends WeightedPartialDerivative> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends WeightedPartialDerivative> getType() {
		return WeightedPartialDerivative.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("partialDerivativeReference"), processor, PricingParameterDerivativeReference.class, getPartialDerivativeReference());
		processor.processBasic(path.newSubPath("weight"), BigDecimal.class, getWeight(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface WeightedPartialDerivativeBuilder extends WeightedPartialDerivative, RosettaModelObjectBuilder {
		PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder getOrCreatePartialDerivativeReference();
		PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder getPartialDerivativeReference();
		WeightedPartialDerivative.WeightedPartialDerivativeBuilder setPartialDerivativeReference(PricingParameterDerivativeReference partialDerivativeReference);
		WeightedPartialDerivative.WeightedPartialDerivativeBuilder setWeight(BigDecimal weight);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("partialDerivativeReference"), processor, PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder.class, getPartialDerivativeReference());
			processor.processBasic(path.newSubPath("weight"), BigDecimal.class, getWeight(), this);
		}
		

		WeightedPartialDerivative.WeightedPartialDerivativeBuilder prune();
	}

	/*********************** Immutable Implementation of WeightedPartialDerivative  ***********************/
	class WeightedPartialDerivativeImpl implements WeightedPartialDerivative {
		private final PricingParameterDerivativeReference partialDerivativeReference;
		private final BigDecimal weight;
		
		protected WeightedPartialDerivativeImpl(WeightedPartialDerivative.WeightedPartialDerivativeBuilder builder) {
			this.partialDerivativeReference = ofNullable(builder.getPartialDerivativeReference()).map(f->f.build()).orElse(null);
			this.weight = builder.getWeight();
		}
		
		@Override
		@RosettaAttribute("partialDerivativeReference")
		public PricingParameterDerivativeReference getPartialDerivativeReference() {
			return partialDerivativeReference;
		}
		
		@Override
		@RosettaAttribute("weight")
		public BigDecimal getWeight() {
			return weight;
		}
		
		@Override
		public WeightedPartialDerivative build() {
			return this;
		}
		
		@Override
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder toBuilder() {
			WeightedPartialDerivative.WeightedPartialDerivativeBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(WeightedPartialDerivative.WeightedPartialDerivativeBuilder builder) {
			ofNullable(getPartialDerivativeReference()).ifPresent(builder::setPartialDerivativeReference);
			ofNullable(getWeight()).ifPresent(builder::setWeight);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeightedPartialDerivative _that = getType().cast(o);
		
			if (!Objects.equals(partialDerivativeReference, _that.getPartialDerivativeReference())) return false;
			if (!Objects.equals(weight, _that.getWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partialDerivativeReference != null ? partialDerivativeReference.hashCode() : 0);
			_result = 31 * _result + (weight != null ? weight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeightedPartialDerivative {" +
				"partialDerivativeReference=" + this.partialDerivativeReference + ", " +
				"weight=" + this.weight +
			'}';
		}
	}

	/*********************** Builder Implementation of WeightedPartialDerivative  ***********************/
	class WeightedPartialDerivativeBuilderImpl implements WeightedPartialDerivative.WeightedPartialDerivativeBuilder {
	
		protected PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder partialDerivativeReference;
		protected BigDecimal weight;
	
		public WeightedPartialDerivativeBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("partialDerivativeReference")
		public PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder getPartialDerivativeReference() {
			return partialDerivativeReference;
		}
		
		@Override
		public PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder getOrCreatePartialDerivativeReference() {
			PricingParameterDerivativeReference.PricingParameterDerivativeReferenceBuilder result;
			if (partialDerivativeReference!=null) {
				result = partialDerivativeReference;
			}
			else {
				result = partialDerivativeReference = PricingParameterDerivativeReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("weight")
		public BigDecimal getWeight() {
			return weight;
		}
		
		@Override
		@RosettaAttribute("partialDerivativeReference")
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder setPartialDerivativeReference(PricingParameterDerivativeReference partialDerivativeReference) {
			this.partialDerivativeReference = partialDerivativeReference==null?null:partialDerivativeReference.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("weight")
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder setWeight(BigDecimal weight) {
			this.weight = weight==null?null:weight;
			return this;
		}
		
		@Override
		public WeightedPartialDerivative build() {
			return new WeightedPartialDerivative.WeightedPartialDerivativeImpl(this);
		}
		
		@Override
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder prune() {
			if (partialDerivativeReference!=null && !partialDerivativeReference.prune().hasData()) partialDerivativeReference = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getPartialDerivativeReference()!=null && getPartialDerivativeReference().hasData()) return true;
			if (getWeight()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public WeightedPartialDerivative.WeightedPartialDerivativeBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			WeightedPartialDerivative.WeightedPartialDerivativeBuilder o = (WeightedPartialDerivative.WeightedPartialDerivativeBuilder) other;
			
			merger.mergeRosetta(getPartialDerivativeReference(), o.getPartialDerivativeReference(), this::setPartialDerivativeReference);
			
			merger.mergeBasic(getWeight(), o.getWeight(), this::setWeight);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			WeightedPartialDerivative _that = getType().cast(o);
		
			if (!Objects.equals(partialDerivativeReference, _that.getPartialDerivativeReference())) return false;
			if (!Objects.equals(weight, _that.getWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (partialDerivativeReference != null ? partialDerivativeReference.hashCode() : 0);
			_result = 31 * _result + (weight != null ? weight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "WeightedPartialDerivativeBuilder {" +
				"partialDerivativeReference=" + this.partialDerivativeReference + ", " +
				"weight=" + this.weight +
			'}';
		}
	}
}
