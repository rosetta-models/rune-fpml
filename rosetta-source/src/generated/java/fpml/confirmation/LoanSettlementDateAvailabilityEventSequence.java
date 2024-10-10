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
import fpml.confirmation.LoanSettlementDateAvailabilityEventSequence;
import fpml.confirmation.LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder;
import fpml.confirmation.LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilderImpl;
import fpml.confirmation.LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceImpl;
import fpml.confirmation.meta.LoanSettlementDateAvailabilityEventSequenceMeta;
import java.time.LocalTime;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="LoanSettlementDateAvailabilityEventSequence", builder=LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilderImpl.class, version="${project.version}")
public interface LoanSettlementDateAvailabilityEventSequence extends RosettaModelObject {

	LoanSettlementDateAvailabilityEventSequenceMeta metaData = new LoanSettlementDateAvailabilityEventSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Number of days advance notification required to express the intent to settle a trade.
	 */
	Integer getLeadDays();
	/**
	 * Specific cutoff time to express the intent to settle a trade.
	 */
	LocalTime getCutOffTime();

	/*********************** Build Methods  ***********************/
	LoanSettlementDateAvailabilityEventSequence build();
	
	LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder toBuilder();
	
	static LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder builder() {
		return new LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends LoanSettlementDateAvailabilityEventSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends LoanSettlementDateAvailabilityEventSequence> getType() {
		return LoanSettlementDateAvailabilityEventSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("leadDays"), Integer.class, getLeadDays(), this);
		processor.processBasic(path.newSubPath("cutOffTime"), LocalTime.class, getCutOffTime(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface LoanSettlementDateAvailabilityEventSequenceBuilder extends LoanSettlementDateAvailabilityEventSequence, RosettaModelObjectBuilder {
		LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder setLeadDays(Integer leadDays);
		LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder setCutOffTime(LocalTime cutOffTime);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("leadDays"), Integer.class, getLeadDays(), this);
			processor.processBasic(path.newSubPath("cutOffTime"), LocalTime.class, getCutOffTime(), this);
		}
		

		LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of LoanSettlementDateAvailabilityEventSequence  ***********************/
	class LoanSettlementDateAvailabilityEventSequenceImpl implements LoanSettlementDateAvailabilityEventSequence {
		private final Integer leadDays;
		private final LocalTime cutOffTime;
		
		protected LoanSettlementDateAvailabilityEventSequenceImpl(LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder builder) {
			this.leadDays = builder.getLeadDays();
			this.cutOffTime = builder.getCutOffTime();
		}
		
		@Override
		@RosettaAttribute("leadDays")
		public Integer getLeadDays() {
			return leadDays;
		}
		
		@Override
		@RosettaAttribute("cutOffTime")
		public LocalTime getCutOffTime() {
			return cutOffTime;
		}
		
		@Override
		public LoanSettlementDateAvailabilityEventSequence build() {
			return this;
		}
		
		@Override
		public LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder toBuilder() {
			LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder builder) {
			ofNullable(getLeadDays()).ifPresent(builder::setLeadDays);
			ofNullable(getCutOffTime()).ifPresent(builder::setCutOffTime);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanSettlementDateAvailabilityEventSequence _that = getType().cast(o);
		
			if (!Objects.equals(leadDays, _that.getLeadDays())) return false;
			if (!Objects.equals(cutOffTime, _that.getCutOffTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (leadDays != null ? leadDays.hashCode() : 0);
			_result = 31 * _result + (cutOffTime != null ? cutOffTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanSettlementDateAvailabilityEventSequence {" +
				"leadDays=" + this.leadDays + ", " +
				"cutOffTime=" + this.cutOffTime +
			'}';
		}
	}

	/*********************** Builder Implementation of LoanSettlementDateAvailabilityEventSequence  ***********************/
	class LoanSettlementDateAvailabilityEventSequenceBuilderImpl implements LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder {
	
		protected Integer leadDays;
		protected LocalTime cutOffTime;
	
		public LoanSettlementDateAvailabilityEventSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("leadDays")
		public Integer getLeadDays() {
			return leadDays;
		}
		
		@Override
		@RosettaAttribute("cutOffTime")
		public LocalTime getCutOffTime() {
			return cutOffTime;
		}
		
		@Override
		@RosettaAttribute("leadDays")
		public LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder setLeadDays(Integer leadDays) {
			this.leadDays = leadDays==null?null:leadDays;
			return this;
		}
		@Override
		@RosettaAttribute("cutOffTime")
		public LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder setCutOffTime(LocalTime cutOffTime) {
			this.cutOffTime = cutOffTime==null?null:cutOffTime;
			return this;
		}
		
		@Override
		public LoanSettlementDateAvailabilityEventSequence build() {
			return new LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceImpl(this);
		}
		
		@Override
		public LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLeadDays()!=null) return true;
			if (getCutOffTime()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder o = (LoanSettlementDateAvailabilityEventSequence.LoanSettlementDateAvailabilityEventSequenceBuilder) other;
			
			
			merger.mergeBasic(getLeadDays(), o.getLeadDays(), this::setLeadDays);
			merger.mergeBasic(getCutOffTime(), o.getCutOffTime(), this::setCutOffTime);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			LoanSettlementDateAvailabilityEventSequence _that = getType().cast(o);
		
			if (!Objects.equals(leadDays, _that.getLeadDays())) return false;
			if (!Objects.equals(cutOffTime, _that.getCutOffTime())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (leadDays != null ? leadDays.hashCode() : 0);
			_result = 31 * _result + (cutOffTime != null ? cutOffTime.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "LoanSettlementDateAvailabilityEventSequenceBuilder {" +
				"leadDays=" + this.leadDays + ", " +
				"cutOffTime=" + this.cutOffTime +
			'}';
		}
	}
}
