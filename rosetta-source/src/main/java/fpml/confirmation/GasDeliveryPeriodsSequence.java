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
import fpml.confirmation.GasDeliveryPeriodsSequence;
import fpml.confirmation.GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder;
import fpml.confirmation.GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilderImpl;
import fpml.confirmation.GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceImpl;
import fpml.confirmation.PrevailingTime;
import fpml.confirmation.meta.GasDeliveryPeriodsSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="GasDeliveryPeriodsSequence", builder=GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface GasDeliveryPeriodsSequence extends RosettaModelObject {

	GasDeliveryPeriodsSequenceMeta metaData = new GasDeliveryPeriodsSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The time at which gas delivery should start on each day of the Delivery Period(s).
	 */
	PrevailingTime getSupplyStartTime();
	/**
	 * The time at which gas delivery should end on each day of the Delivery Period(s).
	 */
	PrevailingTime getSupplyEndTime();

	/*********************** Build Methods  ***********************/
	GasDeliveryPeriodsSequence build();
	
	GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder toBuilder();
	
	static GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder builder() {
		return new GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends GasDeliveryPeriodsSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends GasDeliveryPeriodsSequence> getType() {
		return GasDeliveryPeriodsSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("supplyStartTime"), processor, PrevailingTime.class, getSupplyStartTime());
		processRosetta(path.newSubPath("supplyEndTime"), processor, PrevailingTime.class, getSupplyEndTime());
	}
	

	/*********************** Builder Interface  ***********************/
	interface GasDeliveryPeriodsSequenceBuilder extends GasDeliveryPeriodsSequence, RosettaModelObjectBuilder {
		PrevailingTime.PrevailingTimeBuilder getOrCreateSupplyStartTime();
		PrevailingTime.PrevailingTimeBuilder getSupplyStartTime();
		PrevailingTime.PrevailingTimeBuilder getOrCreateSupplyEndTime();
		PrevailingTime.PrevailingTimeBuilder getSupplyEndTime();
		GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder setSupplyStartTime(PrevailingTime supplyStartTime);
		GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder setSupplyEndTime(PrevailingTime supplyEndTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("supplyStartTime"), processor, PrevailingTime.PrevailingTimeBuilder.class, getSupplyStartTime());
			processRosetta(path.newSubPath("supplyEndTime"), processor, PrevailingTime.PrevailingTimeBuilder.class, getSupplyEndTime());
		}
		

		GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of GasDeliveryPeriodsSequence  ***********************/
	class GasDeliveryPeriodsSequenceImpl implements GasDeliveryPeriodsSequence {
		private final PrevailingTime supplyStartTime;
		private final PrevailingTime supplyEndTime;
		
		protected GasDeliveryPeriodsSequenceImpl(GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder builder) {
			this.supplyStartTime = ofNullable(builder.getSupplyStartTime()).map(f->f.build()).orElse(null);
			this.supplyEndTime = ofNullable(builder.getSupplyEndTime()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("supplyStartTime")
		public PrevailingTime getSupplyStartTime() {
			return supplyStartTime;
		}
		
		@Override
		@RosettaAttribute("supplyEndTime")
		public PrevailingTime getSupplyEndTime() {
			return supplyEndTime;
		}
		
		@Override
		public GasDeliveryPeriodsSequence build() {
			return this;
		}
		
		@Override
		public GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder toBuilder() {
			GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder builder) {
			ofNullable(getSupplyStartTime()).ifPresent(builder::setSupplyStartTime);
			ofNullable(getSupplyEndTime()).ifPresent(builder::setSupplyEndTime);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasDeliveryPeriodsSequence _that = getType().cast(o);
		
			if (!Objects.equals(supplyStartTime, _that.getSupplyStartTime())) return false;
			if (!Objects.equals(supplyEndTime, _that.getSupplyEndTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supplyStartTime != null ? supplyStartTime.hashCode() : 0);
			_result = 31 * _result + (supplyEndTime != null ? supplyEndTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasDeliveryPeriodsSequence {" +
				"supplyStartTime=" + this.supplyStartTime + ", " +
				"supplyEndTime=" + this.supplyEndTime +
			'}';
		}
	}

	/*********************** Builder Implementation of GasDeliveryPeriodsSequence  ***********************/
	class GasDeliveryPeriodsSequenceBuilderImpl implements GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder {
	
		protected PrevailingTime.PrevailingTimeBuilder supplyStartTime;
		protected PrevailingTime.PrevailingTimeBuilder supplyEndTime;
	
		public GasDeliveryPeriodsSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("supplyStartTime")
		public PrevailingTime.PrevailingTimeBuilder getSupplyStartTime() {
			return supplyStartTime;
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder getOrCreateSupplyStartTime() {
			PrevailingTime.PrevailingTimeBuilder result;
			if (supplyStartTime!=null) {
				result = supplyStartTime;
			}
			else {
				result = supplyStartTime = PrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("supplyEndTime")
		public PrevailingTime.PrevailingTimeBuilder getSupplyEndTime() {
			return supplyEndTime;
		}
		
		@Override
		public PrevailingTime.PrevailingTimeBuilder getOrCreateSupplyEndTime() {
			PrevailingTime.PrevailingTimeBuilder result;
			if (supplyEndTime!=null) {
				result = supplyEndTime;
			}
			else {
				result = supplyEndTime = PrevailingTime.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("supplyStartTime")
		public GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder setSupplyStartTime(PrevailingTime supplyStartTime) {
			this.supplyStartTime = supplyStartTime==null?null:supplyStartTime.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("supplyEndTime")
		public GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder setSupplyEndTime(PrevailingTime supplyEndTime) {
			this.supplyEndTime = supplyEndTime==null?null:supplyEndTime.toBuilder();
			return this;
		}
		
		@Override
		public GasDeliveryPeriodsSequence build() {
			return new GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceImpl(this);
		}
		
		@Override
		public GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder prune() {
			if (supplyStartTime!=null && !supplyStartTime.prune().hasData()) supplyStartTime = null;
			if (supplyEndTime!=null && !supplyEndTime.prune().hasData()) supplyEndTime = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getSupplyStartTime()!=null && getSupplyStartTime().hasData()) return true;
			if (getSupplyEndTime()!=null && getSupplyEndTime().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder o = (GasDeliveryPeriodsSequence.GasDeliveryPeriodsSequenceBuilder) other;
			
			merger.mergeRosetta(getSupplyStartTime(), o.getSupplyStartTime(), this::setSupplyStartTime);
			merger.mergeRosetta(getSupplyEndTime(), o.getSupplyEndTime(), this::setSupplyEndTime);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			GasDeliveryPeriodsSequence _that = getType().cast(o);
		
			if (!Objects.equals(supplyStartTime, _that.getSupplyStartTime())) return false;
			if (!Objects.equals(supplyEndTime, _that.getSupplyEndTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (supplyStartTime != null ? supplyStartTime.hashCode() : 0);
			_result = 31 * _result + (supplyEndTime != null ? supplyEndTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "GasDeliveryPeriodsSequenceBuilder {" +
				"supplyStartTime=" + this.supplyStartTime + ", " +
				"supplyEndTime=" + this.supplyEndTime +
			'}';
		}
	}
}
