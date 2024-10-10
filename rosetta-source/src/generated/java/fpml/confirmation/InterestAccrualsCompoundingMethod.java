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
import fpml.confirmation.FloatingRateCalculation;
import fpml.confirmation.InterestAccrualsCompoundingMethod;
import fpml.confirmation.InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder;
import fpml.confirmation.InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilderImpl;
import fpml.confirmation.InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodImpl;
import fpml.confirmation.InterestAccrualsCompoundingMethodSequence;
import fpml.confirmation.InterestAccrualsMethod;
import fpml.confirmation.InterestAccrualsMethod.InterestAccrualsMethodBuilder;
import fpml.confirmation.InterestAccrualsMethod.InterestAccrualsMethodBuilderImpl;
import fpml.confirmation.InterestAccrualsMethod.InterestAccrualsMethodImpl;
import fpml.confirmation.meta.InterestAccrualsCompoundingMethodMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining the way in which interests are accrued: the applicable rate (fixed or floating reference) and the compounding method.
 * @version ${project.version}
 */
@RosettaDataType(value="InterestAccrualsCompoundingMethod", builder=InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilderImpl.class, version="${project.version}")
public interface InterestAccrualsCompoundingMethod extends InterestAccrualsMethod {

	InterestAccrualsCompoundingMethodMeta metaData = new InterestAccrualsCompoundingMethodMeta();

	/*********************** Getter Methods  ***********************/
	InterestAccrualsCompoundingMethodSequence getInterestAccrualsCompoundingMethodSequence();

	/*********************** Build Methods  ***********************/
	InterestAccrualsCompoundingMethod build();
	
	InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder toBuilder();
	
	static InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder builder() {
		return new InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestAccrualsCompoundingMethod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestAccrualsCompoundingMethod> getType() {
		return InterestAccrualsCompoundingMethod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.class, getFloatingRateCalculation());
		processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
		processRosetta(path.newSubPath("interestAccrualsCompoundingMethodSequence"), processor, InterestAccrualsCompoundingMethodSequence.class, getInterestAccrualsCompoundingMethodSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestAccrualsCompoundingMethodBuilder extends InterestAccrualsCompoundingMethod, InterestAccrualsMethod.InterestAccrualsMethodBuilder {
		InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder getOrCreateInterestAccrualsCompoundingMethodSequence();
		InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder getInterestAccrualsCompoundingMethodSequence();
		InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation);
		InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder setFixedRate(BigDecimal fixedRate);
		InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder setInterestAccrualsCompoundingMethodSequence(InterestAccrualsCompoundingMethodSequence interestAccrualsCompoundingMethodSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floatingRateCalculation"), processor, FloatingRateCalculation.FloatingRateCalculationBuilder.class, getFloatingRateCalculation());
			processor.processBasic(path.newSubPath("fixedRate"), BigDecimal.class, getFixedRate(), this);
			processRosetta(path.newSubPath("interestAccrualsCompoundingMethodSequence"), processor, InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder.class, getInterestAccrualsCompoundingMethodSequence());
		}
		

		InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder prune();
	}

	/*********************** Immutable Implementation of InterestAccrualsCompoundingMethod  ***********************/
	class InterestAccrualsCompoundingMethodImpl extends InterestAccrualsMethod.InterestAccrualsMethodImpl implements InterestAccrualsCompoundingMethod {
		private final InterestAccrualsCompoundingMethodSequence interestAccrualsCompoundingMethodSequence;
		
		protected InterestAccrualsCompoundingMethodImpl(InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder builder) {
			super(builder);
			this.interestAccrualsCompoundingMethodSequence = ofNullable(builder.getInterestAccrualsCompoundingMethodSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("interestAccrualsCompoundingMethodSequence")
		public InterestAccrualsCompoundingMethodSequence getInterestAccrualsCompoundingMethodSequence() {
			return interestAccrualsCompoundingMethodSequence;
		}
		
		@Override
		public InterestAccrualsCompoundingMethod build() {
			return this;
		}
		
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder toBuilder() {
			InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder builder) {
			super.setBuilderFields(builder);
			ofNullable(getInterestAccrualsCompoundingMethodSequence()).ifPresent(builder::setInterestAccrualsCompoundingMethodSequence);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestAccrualsCompoundingMethod _that = getType().cast(o);
		
			if (!Objects.equals(interestAccrualsCompoundingMethodSequence, _that.getInterestAccrualsCompoundingMethodSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (interestAccrualsCompoundingMethodSequence != null ? interestAccrualsCompoundingMethodSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAccrualsCompoundingMethod {" +
				"interestAccrualsCompoundingMethodSequence=" + this.interestAccrualsCompoundingMethodSequence +
			'}' + " " + super.toString();
		}
	}

	/*********************** Builder Implementation of InterestAccrualsCompoundingMethod  ***********************/
	class InterestAccrualsCompoundingMethodBuilderImpl extends InterestAccrualsMethod.InterestAccrualsMethodBuilderImpl  implements InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder {
	
		protected InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder interestAccrualsCompoundingMethodSequence;
	
		public InterestAccrualsCompoundingMethodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("interestAccrualsCompoundingMethodSequence")
		public InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder getInterestAccrualsCompoundingMethodSequence() {
			return interestAccrualsCompoundingMethodSequence;
		}
		
		@Override
		public InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder getOrCreateInterestAccrualsCompoundingMethodSequence() {
			InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder result;
			if (interestAccrualsCompoundingMethodSequence!=null) {
				result = interestAccrualsCompoundingMethodSequence;
			}
			else {
				result = interestAccrualsCompoundingMethodSequence = InterestAccrualsCompoundingMethodSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floatingRateCalculation")
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder setFloatingRateCalculation(FloatingRateCalculation floatingRateCalculation) {
			this.floatingRateCalculation = floatingRateCalculation==null?null:floatingRateCalculation.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixedRate")
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder setFixedRate(BigDecimal fixedRate) {
			this.fixedRate = fixedRate==null?null:fixedRate;
			return this;
		}
		@Override
		@RosettaAttribute("interestAccrualsCompoundingMethodSequence")
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder setInterestAccrualsCompoundingMethodSequence(InterestAccrualsCompoundingMethodSequence interestAccrualsCompoundingMethodSequence) {
			this.interestAccrualsCompoundingMethodSequence = interestAccrualsCompoundingMethodSequence==null?null:interestAccrualsCompoundingMethodSequence.toBuilder();
			return this;
		}
		
		@Override
		public InterestAccrualsCompoundingMethod build() {
			return new InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodImpl(this);
		}
		
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder prune() {
			super.prune();
			if (interestAccrualsCompoundingMethodSequence!=null && !interestAccrualsCompoundingMethodSequence.prune().hasData()) interestAccrualsCompoundingMethodSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (super.hasData()) return true;
			if (getInterestAccrualsCompoundingMethodSequence()!=null && getInterestAccrualsCompoundingMethodSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			super.merge(other, merger);
			
			InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder o = (InterestAccrualsCompoundingMethod.InterestAccrualsCompoundingMethodBuilder) other;
			
			merger.mergeRosetta(getInterestAccrualsCompoundingMethodSequence(), o.getInterestAccrualsCompoundingMethodSequence(), this::setInterestAccrualsCompoundingMethodSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
			if (!super.equals(o)) return false;
		
			InterestAccrualsCompoundingMethod _that = getType().cast(o);
		
			if (!Objects.equals(interestAccrualsCompoundingMethodSequence, _that.getInterestAccrualsCompoundingMethodSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = super.hashCode();
			_result = 31 * _result + (interestAccrualsCompoundingMethodSequence != null ? interestAccrualsCompoundingMethodSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAccrualsCompoundingMethodBuilder {" +
				"interestAccrualsCompoundingMethodSequence=" + this.interestAccrualsCompoundingMethodSequence +
			'}' + " " + super.toString();
		}
	}
}
