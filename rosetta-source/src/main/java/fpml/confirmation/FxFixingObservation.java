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
import com.rosetta.model.lib.records.Date;
import fpml.confirmation.FxFixingObservation;
import fpml.confirmation.FxFixingObservation.FxFixingObservationBuilder;
import fpml.confirmation.FxFixingObservation.FxFixingObservationBuilderImpl;
import fpml.confirmation.FxFixingObservation.FxFixingObservationImpl;
import fpml.confirmation.meta.FxFixingObservationMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxFixingObservation", builder=FxFixingObservation.FxFixingObservationBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxFixingObservation extends RosettaModelObject {

	FxFixingObservationMeta metaData = new FxFixingObservationMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * A specific date for which an observation against a particular rate will be made and will be used for subsequent computations.
	 */
	Date getDate();
	/**
	 * An optional factor that can be used for weighting certain observation dates. Typically, firms will weight each date with a factor of 1 if there are standard, unweighted adjustments. If omitted, weight is defaulted to 1.
	 */
	BigDecimal getWeight();

	/*********************** Build Methods  ***********************/
	FxFixingObservation build();
	
	FxFixingObservation.FxFixingObservationBuilder toBuilder();
	
	static FxFixingObservation.FxFixingObservationBuilder builder() {
		return new FxFixingObservation.FxFixingObservationBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxFixingObservation> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxFixingObservation> getType() {
		return FxFixingObservation.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
		processor.processBasic(path.newSubPath("weight"), BigDecimal.class, getWeight(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxFixingObservationBuilder extends FxFixingObservation, RosettaModelObjectBuilder {
		FxFixingObservation.FxFixingObservationBuilder setDate(Date date);
		FxFixingObservation.FxFixingObservationBuilder setWeight(BigDecimal weight);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("date"), Date.class, getDate(), this);
			processor.processBasic(path.newSubPath("weight"), BigDecimal.class, getWeight(), this);
		}
		

		FxFixingObservation.FxFixingObservationBuilder prune();
	}

	/*********************** Immutable Implementation of FxFixingObservation  ***********************/
	class FxFixingObservationImpl implements FxFixingObservation {
		private final Date date;
		private final BigDecimal weight;
		
		protected FxFixingObservationImpl(FxFixingObservation.FxFixingObservationBuilder builder) {
			this.date = builder.getDate();
			this.weight = builder.getWeight();
		}
		
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("weight")
		public BigDecimal getWeight() {
			return weight;
		}
		
		@Override
		public FxFixingObservation build() {
			return this;
		}
		
		@Override
		public FxFixingObservation.FxFixingObservationBuilder toBuilder() {
			FxFixingObservation.FxFixingObservationBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxFixingObservation.FxFixingObservationBuilder builder) {
			ofNullable(getDate()).ifPresent(builder::setDate);
			ofNullable(getWeight()).ifPresent(builder::setWeight);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingObservation _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(weight, _that.getWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (weight != null ? weight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingObservation {" +
				"date=" + this.date + ", " +
				"weight=" + this.weight +
			'}';
		}
	}

	/*********************** Builder Implementation of FxFixingObservation  ***********************/
	class FxFixingObservationBuilderImpl implements FxFixingObservation.FxFixingObservationBuilder {
	
		protected Date date;
		protected BigDecimal weight;
	
		public FxFixingObservationBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("date")
		public Date getDate() {
			return date;
		}
		
		@Override
		@RosettaAttribute("weight")
		public BigDecimal getWeight() {
			return weight;
		}
		
		@Override
		@RosettaAttribute("date")
		public FxFixingObservation.FxFixingObservationBuilder setDate(Date date) {
			this.date = date==null?null:date;
			return this;
		}
		@Override
		@RosettaAttribute("weight")
		public FxFixingObservation.FxFixingObservationBuilder setWeight(BigDecimal weight) {
			this.weight = weight==null?null:weight;
			return this;
		}
		
		@Override
		public FxFixingObservation build() {
			return new FxFixingObservation.FxFixingObservationImpl(this);
		}
		
		@Override
		public FxFixingObservation.FxFixingObservationBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingObservation.FxFixingObservationBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getDate()!=null) return true;
			if (getWeight()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxFixingObservation.FxFixingObservationBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxFixingObservation.FxFixingObservationBuilder o = (FxFixingObservation.FxFixingObservationBuilder) other;
			
			
			merger.mergeBasic(getDate(), o.getDate(), this::setDate);
			merger.mergeBasic(getWeight(), o.getWeight(), this::setWeight);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxFixingObservation _that = getType().cast(o);
		
			if (!Objects.equals(date, _that.getDate())) return false;
			if (!Objects.equals(weight, _that.getWeight())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (date != null ? date.hashCode() : 0);
			_result = 31 * _result + (weight != null ? weight.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxFixingObservationBuilder {" +
				"date=" + this.date + ", " +
				"weight=" + this.weight +
			'}';
		}
	}
}
