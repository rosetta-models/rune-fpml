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
import fpml.confirmation.CompoundingRate;
import fpml.confirmation.CompoundingRate.CompoundingRateBuilder;
import fpml.confirmation.CompoundingRate.CompoundingRateBuilderImpl;
import fpml.confirmation.CompoundingRate.CompoundingRateImpl;
import fpml.confirmation.FloatingRateCalculationReference;
import fpml.confirmation.InterestAccrualsMethod;
import fpml.confirmation.meta.CompoundingRateMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type defining a compounding rate. The compounding interest can either point back to the floating rate calculation of interest calculation node on the Interest Leg, or be defined specifically.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="CompoundingRate", builder=CompoundingRate.CompoundingRateBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface CompoundingRate extends RosettaModelObject {

	CompoundingRateMeta metaData = new CompoundingRateMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Reference to the floating rate calculation of interest calculation node on the Interest Leg.
	 */
	FloatingRateCalculationReference getInterestLegRate();
	/**
	 * Defines a specific rate.
	 */
	InterestAccrualsMethod getSpecificRate();

	/*********************** Build Methods  ***********************/
	CompoundingRate build();
	
	CompoundingRate.CompoundingRateBuilder toBuilder();
	
	static CompoundingRate.CompoundingRateBuilder builder() {
		return new CompoundingRate.CompoundingRateBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CompoundingRate> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CompoundingRate> getType() {
		return CompoundingRate.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("interestLegRate"), processor, FloatingRateCalculationReference.class, getInterestLegRate());
		processRosetta(path.newSubPath("specificRate"), processor, InterestAccrualsMethod.class, getSpecificRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CompoundingRateBuilder extends CompoundingRate, RosettaModelObjectBuilder {
		FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder getOrCreateInterestLegRate();
		FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder getInterestLegRate();
		InterestAccrualsMethod.InterestAccrualsMethodBuilder getOrCreateSpecificRate();
		InterestAccrualsMethod.InterestAccrualsMethodBuilder getSpecificRate();
		CompoundingRate.CompoundingRateBuilder setInterestLegRate(FloatingRateCalculationReference interestLegRate);
		CompoundingRate.CompoundingRateBuilder setSpecificRate(InterestAccrualsMethod specificRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("interestLegRate"), processor, FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder.class, getInterestLegRate());
			processRosetta(path.newSubPath("specificRate"), processor, InterestAccrualsMethod.InterestAccrualsMethodBuilder.class, getSpecificRate());
		}
		

		CompoundingRate.CompoundingRateBuilder prune();
	}

	/*********************** Immutable Implementation of CompoundingRate  ***********************/
	class CompoundingRateImpl implements CompoundingRate {
		private final FloatingRateCalculationReference interestLegRate;
		private final InterestAccrualsMethod specificRate;
		
		protected CompoundingRateImpl(CompoundingRate.CompoundingRateBuilder builder) {
			this.interestLegRate = ofNullable(builder.getInterestLegRate()).map(f->f.build()).orElse(null);
			this.specificRate = ofNullable(builder.getSpecificRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("interestLegRate")
		public FloatingRateCalculationReference getInterestLegRate() {
			return interestLegRate;
		}
		
		@Override
		@RosettaAttribute("specificRate")
		public InterestAccrualsMethod getSpecificRate() {
			return specificRate;
		}
		
		@Override
		public CompoundingRate build() {
			return this;
		}
		
		@Override
		public CompoundingRate.CompoundingRateBuilder toBuilder() {
			CompoundingRate.CompoundingRateBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CompoundingRate.CompoundingRateBuilder builder) {
			ofNullable(getInterestLegRate()).ifPresent(builder::setInterestLegRate);
			ofNullable(getSpecificRate()).ifPresent(builder::setSpecificRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompoundingRate _that = getType().cast(o);
		
			if (!Objects.equals(interestLegRate, _that.getInterestLegRate())) return false;
			if (!Objects.equals(specificRate, _that.getSpecificRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interestLegRate != null ? interestLegRate.hashCode() : 0);
			_result = 31 * _result + (specificRate != null ? specificRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompoundingRate {" +
				"interestLegRate=" + this.interestLegRate + ", " +
				"specificRate=" + this.specificRate +
			'}';
		}
	}

	/*********************** Builder Implementation of CompoundingRate  ***********************/
	class CompoundingRateBuilderImpl implements CompoundingRate.CompoundingRateBuilder {
	
		protected FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder interestLegRate;
		protected InterestAccrualsMethod.InterestAccrualsMethodBuilder specificRate;
	
		public CompoundingRateBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("interestLegRate")
		public FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder getInterestLegRate() {
			return interestLegRate;
		}
		
		@Override
		public FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder getOrCreateInterestLegRate() {
			FloatingRateCalculationReference.FloatingRateCalculationReferenceBuilder result;
			if (interestLegRate!=null) {
				result = interestLegRate;
			}
			else {
				result = interestLegRate = FloatingRateCalculationReference.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("specificRate")
		public InterestAccrualsMethod.InterestAccrualsMethodBuilder getSpecificRate() {
			return specificRate;
		}
		
		@Override
		public InterestAccrualsMethod.InterestAccrualsMethodBuilder getOrCreateSpecificRate() {
			InterestAccrualsMethod.InterestAccrualsMethodBuilder result;
			if (specificRate!=null) {
				result = specificRate;
			}
			else {
				result = specificRate = InterestAccrualsMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interestLegRate")
		public CompoundingRate.CompoundingRateBuilder setInterestLegRate(FloatingRateCalculationReference interestLegRate) {
			this.interestLegRate = interestLegRate==null?null:interestLegRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("specificRate")
		public CompoundingRate.CompoundingRateBuilder setSpecificRate(InterestAccrualsMethod specificRate) {
			this.specificRate = specificRate==null?null:specificRate.toBuilder();
			return this;
		}
		
		@Override
		public CompoundingRate build() {
			return new CompoundingRate.CompoundingRateImpl(this);
		}
		
		@Override
		public CompoundingRate.CompoundingRateBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompoundingRate.CompoundingRateBuilder prune() {
			if (interestLegRate!=null && !interestLegRate.prune().hasData()) interestLegRate = null;
			if (specificRate!=null && !specificRate.prune().hasData()) specificRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInterestLegRate()!=null && getInterestLegRate().hasData()) return true;
			if (getSpecificRate()!=null && getSpecificRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CompoundingRate.CompoundingRateBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CompoundingRate.CompoundingRateBuilder o = (CompoundingRate.CompoundingRateBuilder) other;
			
			merger.mergeRosetta(getInterestLegRate(), o.getInterestLegRate(), this::setInterestLegRate);
			merger.mergeRosetta(getSpecificRate(), o.getSpecificRate(), this::setSpecificRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CompoundingRate _that = getType().cast(o);
		
			if (!Objects.equals(interestLegRate, _that.getInterestLegRate())) return false;
			if (!Objects.equals(specificRate, _that.getSpecificRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interestLegRate != null ? interestLegRate.hashCode() : 0);
			_result = 31 * _result + (specificRate != null ? specificRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CompoundingRateBuilder {" +
				"interestLegRate=" + this.interestLegRate + ", " +
				"specificRate=" + this.specificRate +
			'}';
		}
	}
}
