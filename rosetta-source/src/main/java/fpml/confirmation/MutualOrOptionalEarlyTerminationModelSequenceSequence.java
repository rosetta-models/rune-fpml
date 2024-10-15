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
import fpml.confirmation.FeeElectionEnum;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequenceSequence;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilderImpl;
import fpml.confirmation.MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceImpl;
import fpml.confirmation.meta.MutualOrOptionalEarlyTerminationModelSequenceSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="MutualOrOptionalEarlyTerminationModelSequenceSequence", builder=MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilderImpl.class, version="${project.version}")
public interface MutualOrOptionalEarlyTerminationModelSequenceSequence extends RosettaModelObject {

	MutualOrOptionalEarlyTerminationModelSequenceSequenceMeta metaData = new MutualOrOptionalEarlyTerminationModelSequenceSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the fee type.
	 */
	FeeElectionEnum getBreakFeeElection();
	BigDecimal getBreakFeeRate();

	/*********************** Build Methods  ***********************/
	MutualOrOptionalEarlyTerminationModelSequenceSequence build();
	
	MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder toBuilder();
	
	static MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder builder() {
		return new MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends MutualOrOptionalEarlyTerminationModelSequenceSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends MutualOrOptionalEarlyTerminationModelSequenceSequence> getType() {
		return MutualOrOptionalEarlyTerminationModelSequenceSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("breakFeeElection"), FeeElectionEnum.class, getBreakFeeElection(), this);
		processor.processBasic(path.newSubPath("breakFeeRate"), BigDecimal.class, getBreakFeeRate(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder extends MutualOrOptionalEarlyTerminationModelSequenceSequence, RosettaModelObjectBuilder {
		MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder setBreakFeeElection(FeeElectionEnum breakFeeElection);
		MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder setBreakFeeRate(BigDecimal breakFeeRate);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("breakFeeElection"), FeeElectionEnum.class, getBreakFeeElection(), this);
			processor.processBasic(path.newSubPath("breakFeeRate"), BigDecimal.class, getBreakFeeRate(), this);
		}
		

		MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of MutualOrOptionalEarlyTerminationModelSequenceSequence  ***********************/
	class MutualOrOptionalEarlyTerminationModelSequenceSequenceImpl implements MutualOrOptionalEarlyTerminationModelSequenceSequence {
		private final FeeElectionEnum breakFeeElection;
		private final BigDecimal breakFeeRate;
		
		protected MutualOrOptionalEarlyTerminationModelSequenceSequenceImpl(MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder builder) {
			this.breakFeeElection = builder.getBreakFeeElection();
			this.breakFeeRate = builder.getBreakFeeRate();
		}
		
		@Override
		@RosettaAttribute("breakFeeElection")
		public FeeElectionEnum getBreakFeeElection() {
			return breakFeeElection;
		}
		
		@Override
		@RosettaAttribute("breakFeeRate")
		public BigDecimal getBreakFeeRate() {
			return breakFeeRate;
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModelSequenceSequence build() {
			return this;
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder toBuilder() {
			MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder builder) {
			ofNullable(getBreakFeeElection()).ifPresent(builder::setBreakFeeElection);
			ofNullable(getBreakFeeRate()).ifPresent(builder::setBreakFeeRate);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MutualOrOptionalEarlyTerminationModelSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(breakFeeElection, _that.getBreakFeeElection())) return false;
			if (!Objects.equals(breakFeeRate, _that.getBreakFeeRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (breakFeeElection != null ? breakFeeElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (breakFeeRate != null ? breakFeeRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MutualOrOptionalEarlyTerminationModelSequenceSequence {" +
				"breakFeeElection=" + this.breakFeeElection + ", " +
				"breakFeeRate=" + this.breakFeeRate +
			'}';
		}
	}

	/*********************** Builder Implementation of MutualOrOptionalEarlyTerminationModelSequenceSequence  ***********************/
	class MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilderImpl implements MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder {
	
		protected FeeElectionEnum breakFeeElection;
		protected BigDecimal breakFeeRate;
	
		public MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("breakFeeElection")
		public FeeElectionEnum getBreakFeeElection() {
			return breakFeeElection;
		}
		
		@Override
		@RosettaAttribute("breakFeeRate")
		public BigDecimal getBreakFeeRate() {
			return breakFeeRate;
		}
		
		@Override
		@RosettaAttribute("breakFeeElection")
		public MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder setBreakFeeElection(FeeElectionEnum breakFeeElection) {
			this.breakFeeElection = breakFeeElection==null?null:breakFeeElection;
			return this;
		}
		@Override
		@RosettaAttribute("breakFeeRate")
		public MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder setBreakFeeRate(BigDecimal breakFeeRate) {
			this.breakFeeRate = breakFeeRate==null?null:breakFeeRate;
			return this;
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModelSequenceSequence build() {
			return new MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceImpl(this);
		}
		
		@Override
		public MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getBreakFeeElection()!=null) return true;
			if (getBreakFeeRate()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder o = (MutualOrOptionalEarlyTerminationModelSequenceSequence.MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder) other;
			
			
			merger.mergeBasic(getBreakFeeElection(), o.getBreakFeeElection(), this::setBreakFeeElection);
			merger.mergeBasic(getBreakFeeRate(), o.getBreakFeeRate(), this::setBreakFeeRate);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			MutualOrOptionalEarlyTerminationModelSequenceSequence _that = getType().cast(o);
		
			if (!Objects.equals(breakFeeElection, _that.getBreakFeeElection())) return false;
			if (!Objects.equals(breakFeeRate, _that.getBreakFeeRate())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (breakFeeElection != null ? breakFeeElection.getClass().getName().hashCode() : 0);
			_result = 31 * _result + (breakFeeRate != null ? breakFeeRate.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "MutualOrOptionalEarlyTerminationModelSequenceSequenceBuilder {" +
				"breakFeeElection=" + this.breakFeeElection + ", " +
				"breakFeeRate=" + this.breakFeeRate +
			'}';
		}
	}
}
