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
import fpml.confirmation.NotionalStepRuleSequence;
import fpml.confirmation.NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder;
import fpml.confirmation.NotionalStepRuleSequence.NotionalStepRuleSequenceBuilderImpl;
import fpml.confirmation.NotionalStepRuleSequence.NotionalStepRuleSequenceImpl;
import fpml.confirmation.StepRelativeToEnum;
import fpml.confirmation.meta.NotionalStepRuleSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="NotionalStepRuleSequence", builder=NotionalStepRuleSequence.NotionalStepRuleSequenceBuilderImpl.class, version="${project.version}")
public interface NotionalStepRuleSequence extends RosettaModelObject {

	NotionalStepRuleSequenceMeta metaData = new NotionalStepRuleSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * The percentage amount by which the notional changes on each step date. The percentage is either a percentage applied to the initial notional amount or the previous outstanding notional, depending on the value of the element stepRelativeTo. The percentage can be either positive or negative. A percentage of 5% would be represented as 0.05.
	 */
	BigDecimal getNotionalStepRate();
	/**
	 * Specifies whether the notionalStepRate should be applied to the initial notional or the previous notional in order to calculate the notional step change amount.
	 */
	StepRelativeToEnum getStepRelativeTo();

	/*********************** Build Methods  ***********************/
	NotionalStepRuleSequence build();
	
	NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder toBuilder();
	
	static NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder builder() {
		return new NotionalStepRuleSequence.NotionalStepRuleSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends NotionalStepRuleSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends NotionalStepRuleSequence> getType() {
		return NotionalStepRuleSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("notionalStepRate"), BigDecimal.class, getNotionalStepRate(), this);
		processor.processBasic(path.newSubPath("stepRelativeTo"), StepRelativeToEnum.class, getStepRelativeTo(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface NotionalStepRuleSequenceBuilder extends NotionalStepRuleSequence, RosettaModelObjectBuilder {
		NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder setNotionalStepRate(BigDecimal notionalStepRate);
		NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder setStepRelativeTo(StepRelativeToEnum stepRelativeTo);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("notionalStepRate"), BigDecimal.class, getNotionalStepRate(), this);
			processor.processBasic(path.newSubPath("stepRelativeTo"), StepRelativeToEnum.class, getStepRelativeTo(), this);
		}
		

		NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of NotionalStepRuleSequence  ***********************/
	class NotionalStepRuleSequenceImpl implements NotionalStepRuleSequence {
		private final BigDecimal notionalStepRate;
		private final StepRelativeToEnum stepRelativeTo;
		
		protected NotionalStepRuleSequenceImpl(NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder builder) {
			this.notionalStepRate = builder.getNotionalStepRate();
			this.stepRelativeTo = builder.getStepRelativeTo();
		}
		
		@Override
		@RosettaAttribute("notionalStepRate")
		public BigDecimal getNotionalStepRate() {
			return notionalStepRate;
		}
		
		@Override
		@RosettaAttribute("stepRelativeTo")
		public StepRelativeToEnum getStepRelativeTo() {
			return stepRelativeTo;
		}
		
		@Override
		public NotionalStepRuleSequence build() {
			return this;
		}
		
		@Override
		public NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder toBuilder() {
			NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder builder) {
			ofNullable(getNotionalStepRate()).ifPresent(builder::setNotionalStepRate);
			ofNullable(getStepRelativeTo()).ifPresent(builder::setStepRelativeTo);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalStepRuleSequence _that = getType().cast(o);
		
			if (!Objects.equals(notionalStepRate, _that.getNotionalStepRate())) return false;
			if (!Objects.equals(stepRelativeTo, _that.getStepRelativeTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalStepRate != null ? notionalStepRate.hashCode() : 0);
			_result = 31 * _result + (stepRelativeTo != null ? stepRelativeTo.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalStepRuleSequence {" +
				"notionalStepRate=" + this.notionalStepRate + ", " +
				"stepRelativeTo=" + this.stepRelativeTo +
			'}';
		}
	}

	/*********************** Builder Implementation of NotionalStepRuleSequence  ***********************/
	class NotionalStepRuleSequenceBuilderImpl implements NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder {
	
		protected BigDecimal notionalStepRate;
		protected StepRelativeToEnum stepRelativeTo;
	
		public NotionalStepRuleSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("notionalStepRate")
		public BigDecimal getNotionalStepRate() {
			return notionalStepRate;
		}
		
		@Override
		@RosettaAttribute("stepRelativeTo")
		public StepRelativeToEnum getStepRelativeTo() {
			return stepRelativeTo;
		}
		
		@Override
		@RosettaAttribute("notionalStepRate")
		public NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder setNotionalStepRate(BigDecimal notionalStepRate) {
			this.notionalStepRate = notionalStepRate==null?null:notionalStepRate;
			return this;
		}
		@Override
		@RosettaAttribute("stepRelativeTo")
		public NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder setStepRelativeTo(StepRelativeToEnum stepRelativeTo) {
			this.stepRelativeTo = stepRelativeTo==null?null:stepRelativeTo;
			return this;
		}
		
		@Override
		public NotionalStepRuleSequence build() {
			return new NotionalStepRuleSequence.NotionalStepRuleSequenceImpl(this);
		}
		
		@Override
		public NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getNotionalStepRate()!=null) return true;
			if (getStepRelativeTo()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder o = (NotionalStepRuleSequence.NotionalStepRuleSequenceBuilder) other;
			
			
			merger.mergeBasic(getNotionalStepRate(), o.getNotionalStepRate(), this::setNotionalStepRate);
			merger.mergeBasic(getStepRelativeTo(), o.getStepRelativeTo(), this::setStepRelativeTo);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			NotionalStepRuleSequence _that = getType().cast(o);
		
			if (!Objects.equals(notionalStepRate, _that.getNotionalStepRate())) return false;
			if (!Objects.equals(stepRelativeTo, _that.getStepRelativeTo())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (notionalStepRate != null ? notionalStepRate.hashCode() : 0);
			_result = 31 * _result + (stepRelativeTo != null ? stepRelativeTo.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "NotionalStepRuleSequenceBuilder {" +
				"notionalStepRate=" + this.notionalStepRate + ", " +
				"stepRelativeTo=" + this.stepRelativeTo +
			'}';
		}
	}
}
