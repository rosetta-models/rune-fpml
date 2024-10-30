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
import fpml.confirmation.CompoundingMethodEnum;
import fpml.confirmation.InterestAccrualsCompoundingMethodSequence;
import fpml.confirmation.InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder;
import fpml.confirmation.InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilderImpl;
import fpml.confirmation.InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceImpl;
import fpml.confirmation.meta.InterestAccrualsCompoundingMethodSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="InterestAccrualsCompoundingMethodSequence", builder=InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface InterestAccrualsCompoundingMethodSequence extends RosettaModelObject {

	InterestAccrualsCompoundingMethodSequenceMeta metaData = new InterestAccrualsCompoundingMethodSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * If more that one calculation period contributes to a single payment amount this element specifies whether compounding is applicable, and if so, what compounding method is to be used. This element must only be included when more that one calculation period contributes to a single payment amount.
	 */
	CompoundingMethodEnum getCompoundingMethod();

	/*********************** Build Methods  ***********************/
	InterestAccrualsCompoundingMethodSequence build();
	
	InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder toBuilder();
	
	static InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder builder() {
		return new InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestAccrualsCompoundingMethodSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestAccrualsCompoundingMethodSequence> getType() {
		return InterestAccrualsCompoundingMethodSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("compoundingMethod"), CompoundingMethodEnum.class, getCompoundingMethod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestAccrualsCompoundingMethodSequenceBuilder extends InterestAccrualsCompoundingMethodSequence, RosettaModelObjectBuilder {
		InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder setCompoundingMethod(CompoundingMethodEnum compoundingMethod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("compoundingMethod"), CompoundingMethodEnum.class, getCompoundingMethod(), this);
		}
		

		InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of InterestAccrualsCompoundingMethodSequence  ***********************/
	class InterestAccrualsCompoundingMethodSequenceImpl implements InterestAccrualsCompoundingMethodSequence {
		private final CompoundingMethodEnum compoundingMethod;
		
		protected InterestAccrualsCompoundingMethodSequenceImpl(InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder builder) {
			this.compoundingMethod = builder.getCompoundingMethod();
		}
		
		@Override
		@RosettaAttribute("compoundingMethod")
		public CompoundingMethodEnum getCompoundingMethod() {
			return compoundingMethod;
		}
		
		@Override
		public InterestAccrualsCompoundingMethodSequence build() {
			return this;
		}
		
		@Override
		public InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder toBuilder() {
			InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder builder) {
			ofNullable(getCompoundingMethod()).ifPresent(builder::setCompoundingMethod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAccrualsCompoundingMethodSequence _that = getType().cast(o);
		
			if (!Objects.equals(compoundingMethod, _that.getCompoundingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compoundingMethod != null ? compoundingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAccrualsCompoundingMethodSequence {" +
				"compoundingMethod=" + this.compoundingMethod +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestAccrualsCompoundingMethodSequence  ***********************/
	class InterestAccrualsCompoundingMethodSequenceBuilderImpl implements InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder {
	
		protected CompoundingMethodEnum compoundingMethod;
	
		public InterestAccrualsCompoundingMethodSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("compoundingMethod")
		public CompoundingMethodEnum getCompoundingMethod() {
			return compoundingMethod;
		}
		
		@Override
		@RosettaAttribute("compoundingMethod")
		public InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder setCompoundingMethod(CompoundingMethodEnum compoundingMethod) {
			this.compoundingMethod = compoundingMethod==null?null:compoundingMethod;
			return this;
		}
		
		@Override
		public InterestAccrualsCompoundingMethodSequence build() {
			return new InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceImpl(this);
		}
		
		@Override
		public InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder prune() {
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCompoundingMethod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder o = (InterestAccrualsCompoundingMethodSequence.InterestAccrualsCompoundingMethodSequenceBuilder) other;
			
			
			merger.mergeBasic(getCompoundingMethod(), o.getCompoundingMethod(), this::setCompoundingMethod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestAccrualsCompoundingMethodSequence _that = getType().cast(o);
		
			if (!Objects.equals(compoundingMethod, _that.getCompoundingMethod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (compoundingMethod != null ? compoundingMethod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestAccrualsCompoundingMethodSequenceBuilder {" +
				"compoundingMethod=" + this.compoundingMethod +
			'}';
		}
	}
}
