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
import fpml.confirmation.PeriodRate;
import fpml.confirmation.RateLimits;
import fpml.confirmation.RateLimits.RateLimitsBuilder;
import fpml.confirmation.RateLimits.RateLimitsBuilderImpl;
import fpml.confirmation.RateLimits.RateLimitsImpl;
import fpml.confirmation.meta.RateLimitsMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A structure that defines the limits associated with rates that can be applied to a loan instrument.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="RateLimits", builder=RateLimits.RateLimitsBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface RateLimits extends RosettaModelObject {

	RateLimitsMeta metaData = new RateLimitsMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The rate floor being applied.
	 */
	PeriodRate getFloorRate();
	/**
	 * The rate cap being applied.
	 */
	PeriodRate getCapRate();

	/*********************** Build Methods  ***********************/
	RateLimits build();
	
	RateLimits.RateLimitsBuilder toBuilder();
	
	static RateLimits.RateLimitsBuilder builder() {
		return new RateLimits.RateLimitsBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends RateLimits> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends RateLimits> getType() {
		return RateLimits.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("floorRate"), processor, PeriodRate.class, getFloorRate());
		processRosetta(path.newSubPath("capRate"), processor, PeriodRate.class, getCapRate());
	}
	

	/*********************** Builder Interface  ***********************/
	interface RateLimitsBuilder extends RateLimits, RosettaModelObjectBuilder {
		PeriodRate.PeriodRateBuilder getOrCreateFloorRate();
		PeriodRate.PeriodRateBuilder getFloorRate();
		PeriodRate.PeriodRateBuilder getOrCreateCapRate();
		PeriodRate.PeriodRateBuilder getCapRate();
		RateLimits.RateLimitsBuilder setFloorRate(PeriodRate floorRate);
		RateLimits.RateLimitsBuilder setCapRate(PeriodRate capRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("floorRate"), processor, PeriodRate.PeriodRateBuilder.class, getFloorRate());
			processRosetta(path.newSubPath("capRate"), processor, PeriodRate.PeriodRateBuilder.class, getCapRate());
		}
		

		RateLimits.RateLimitsBuilder prune();
	}

	/*********************** Immutable Implementation of RateLimits  ***********************/
	class RateLimitsImpl implements RateLimits {
		private final PeriodRate floorRate;
		private final PeriodRate capRate;
		
		protected RateLimitsImpl(RateLimits.RateLimitsBuilder builder) {
			this.floorRate = ofNullable(builder.getFloorRate()).map(f->f.build()).orElse(null);
			this.capRate = ofNullable(builder.getCapRate()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("floorRate")
		public PeriodRate getFloorRate() {
			return floorRate;
		}
		
		@Override
		@RosettaAttribute("capRate")
		public PeriodRate getCapRate() {
			return capRate;
		}
		
		@Override
		public RateLimits build() {
			return this;
		}
		
		@Override
		public RateLimits.RateLimitsBuilder toBuilder() {
			RateLimits.RateLimitsBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(RateLimits.RateLimitsBuilder builder) {
			ofNullable(getFloorRate()).ifPresent(builder::setFloorRate);
			ofNullable(getCapRate()).ifPresent(builder::setCapRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateLimits _that = getType().cast(o);
		
			if (!Objects.equals(floorRate, _that.getFloorRate())) return false;
			if (!Objects.equals(capRate, _that.getCapRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floorRate != null ? floorRate.hashCode() : 0);
			_result = 31 * _result + (capRate != null ? capRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateLimits {" +
				"floorRate=" + this.floorRate + ", " +
				"capRate=" + this.capRate +
			'}';
		}
	}

	/*********************** Builder Implementation of RateLimits  ***********************/
	class RateLimitsBuilderImpl implements RateLimits.RateLimitsBuilder {
	
		protected PeriodRate.PeriodRateBuilder floorRate;
		protected PeriodRate.PeriodRateBuilder capRate;
	
		public RateLimitsBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("floorRate")
		public PeriodRate.PeriodRateBuilder getFloorRate() {
			return floorRate;
		}
		
		@Override
		public PeriodRate.PeriodRateBuilder getOrCreateFloorRate() {
			PeriodRate.PeriodRateBuilder result;
			if (floorRate!=null) {
				result = floorRate;
			}
			else {
				result = floorRate = PeriodRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("capRate")
		public PeriodRate.PeriodRateBuilder getCapRate() {
			return capRate;
		}
		
		@Override
		public PeriodRate.PeriodRateBuilder getOrCreateCapRate() {
			PeriodRate.PeriodRateBuilder result;
			if (capRate!=null) {
				result = capRate;
			}
			else {
				result = capRate = PeriodRate.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("floorRate")
		public RateLimits.RateLimitsBuilder setFloorRate(PeriodRate floorRate) {
			this.floorRate = floorRate==null?null:floorRate.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("capRate")
		public RateLimits.RateLimitsBuilder setCapRate(PeriodRate capRate) {
			this.capRate = capRate==null?null:capRate.toBuilder();
			return this;
		}
		
		@Override
		public RateLimits build() {
			return new RateLimits.RateLimitsImpl(this);
		}
		
		@Override
		public RateLimits.RateLimitsBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateLimits.RateLimitsBuilder prune() {
			if (floorRate!=null && !floorRate.prune().hasData()) floorRate = null;
			if (capRate!=null && !capRate.prune().hasData()) capRate = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFloorRate()!=null && getFloorRate().hasData()) return true;
			if (getCapRate()!=null && getCapRate().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public RateLimits.RateLimitsBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			RateLimits.RateLimitsBuilder o = (RateLimits.RateLimitsBuilder) other;
			
			merger.mergeRosetta(getFloorRate(), o.getFloorRate(), this::setFloorRate);
			merger.mergeRosetta(getCapRate(), o.getCapRate(), this::setCapRate);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			RateLimits _that = getType().cast(o);
		
			if (!Objects.equals(floorRate, _that.getFloorRate())) return false;
			if (!Objects.equals(capRate, _that.getCapRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (floorRate != null ? floorRate.hashCode() : 0);
			_result = 31 * _result + (capRate != null ? capRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "RateLimitsBuilder {" +
				"floorRate=" + this.floorRate + ", " +
				"capRate=" + this.capRate +
			'}';
		}
	}
}
