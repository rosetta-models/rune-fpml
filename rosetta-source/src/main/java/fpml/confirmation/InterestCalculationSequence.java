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
import fpml.confirmation.InterestCalculationSequence;
import fpml.confirmation.InterestCalculationSequence.InterestCalculationSequenceBuilder;
import fpml.confirmation.InterestCalculationSequence.InterestCalculationSequenceBuilderImpl;
import fpml.confirmation.InterestCalculationSequence.InterestCalculationSequenceImpl;
import fpml.confirmation.InterpolationMethod;
import fpml.confirmation.InterpolationPeriodEnum;
import fpml.confirmation.meta.InterestCalculationSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="InterestCalculationSequence", builder=InterestCalculationSequence.InterestCalculationSequenceBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface InterestCalculationSequence extends RosettaModelObject {

	InterestCalculationSequenceMeta metaData = new InterestCalculationSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies the type of interpolation used.
	 */
	InterpolationMethod getInterpolationMethod();
	/**
	 * Defines applicable periods for interpolation.
	 */
	InterpolationPeriodEnum getInterpolationPeriod();

	/*********************** Build Methods  ***********************/
	InterestCalculationSequence build();
	
	InterestCalculationSequence.InterestCalculationSequenceBuilder toBuilder();
	
	static InterestCalculationSequence.InterestCalculationSequenceBuilder builder() {
		return new InterestCalculationSequence.InterestCalculationSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InterestCalculationSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InterestCalculationSequence> getType() {
		return InterestCalculationSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("interpolationMethod"), processor, InterpolationMethod.class, getInterpolationMethod());
		processor.processBasic(path.newSubPath("interpolationPeriod"), InterpolationPeriodEnum.class, getInterpolationPeriod(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface InterestCalculationSequenceBuilder extends InterestCalculationSequence, RosettaModelObjectBuilder {
		InterpolationMethod.InterpolationMethodBuilder getOrCreateInterpolationMethod();
		InterpolationMethod.InterpolationMethodBuilder getInterpolationMethod();
		InterestCalculationSequence.InterestCalculationSequenceBuilder setInterpolationMethod(InterpolationMethod interpolationMethod);
		InterestCalculationSequence.InterestCalculationSequenceBuilder setInterpolationPeriod(InterpolationPeriodEnum interpolationPeriod);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("interpolationMethod"), processor, InterpolationMethod.InterpolationMethodBuilder.class, getInterpolationMethod());
			processor.processBasic(path.newSubPath("interpolationPeriod"), InterpolationPeriodEnum.class, getInterpolationPeriod(), this);
		}
		

		InterestCalculationSequence.InterestCalculationSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of InterestCalculationSequence  ***********************/
	class InterestCalculationSequenceImpl implements InterestCalculationSequence {
		private final InterpolationMethod interpolationMethod;
		private final InterpolationPeriodEnum interpolationPeriod;
		
		protected InterestCalculationSequenceImpl(InterestCalculationSequence.InterestCalculationSequenceBuilder builder) {
			this.interpolationMethod = ofNullable(builder.getInterpolationMethod()).map(f->f.build()).orElse(null);
			this.interpolationPeriod = builder.getInterpolationPeriod();
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		public InterpolationMethod getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		@RosettaAttribute("interpolationPeriod")
		public InterpolationPeriodEnum getInterpolationPeriod() {
			return interpolationPeriod;
		}
		
		@Override
		public InterestCalculationSequence build() {
			return this;
		}
		
		@Override
		public InterestCalculationSequence.InterestCalculationSequenceBuilder toBuilder() {
			InterestCalculationSequence.InterestCalculationSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InterestCalculationSequence.InterestCalculationSequenceBuilder builder) {
			ofNullable(getInterpolationMethod()).ifPresent(builder::setInterpolationMethod);
			ofNullable(getInterpolationPeriod()).ifPresent(builder::setInterpolationPeriod);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestCalculationSequence _that = getType().cast(o);
		
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(interpolationPeriod, _that.getInterpolationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (interpolationPeriod != null ? interpolationPeriod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestCalculationSequence {" +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"interpolationPeriod=" + this.interpolationPeriod +
			'}';
		}
	}

	/*********************** Builder Implementation of InterestCalculationSequence  ***********************/
	class InterestCalculationSequenceBuilderImpl implements InterestCalculationSequence.InterestCalculationSequenceBuilder {
	
		protected InterpolationMethod.InterpolationMethodBuilder interpolationMethod;
		protected InterpolationPeriodEnum interpolationPeriod;
	
		public InterestCalculationSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("interpolationMethod")
		public InterpolationMethod.InterpolationMethodBuilder getInterpolationMethod() {
			return interpolationMethod;
		}
		
		@Override
		public InterpolationMethod.InterpolationMethodBuilder getOrCreateInterpolationMethod() {
			InterpolationMethod.InterpolationMethodBuilder result;
			if (interpolationMethod!=null) {
				result = interpolationMethod;
			}
			else {
				result = interpolationMethod = InterpolationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("interpolationPeriod")
		public InterpolationPeriodEnum getInterpolationPeriod() {
			return interpolationPeriod;
		}
		
		@Override
		@RosettaAttribute("interpolationMethod")
		public InterestCalculationSequence.InterestCalculationSequenceBuilder setInterpolationMethod(InterpolationMethod interpolationMethod) {
			this.interpolationMethod = interpolationMethod==null?null:interpolationMethod.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("interpolationPeriod")
		public InterestCalculationSequence.InterestCalculationSequenceBuilder setInterpolationPeriod(InterpolationPeriodEnum interpolationPeriod) {
			this.interpolationPeriod = interpolationPeriod==null?null:interpolationPeriod;
			return this;
		}
		
		@Override
		public InterestCalculationSequence build() {
			return new InterestCalculationSequence.InterestCalculationSequenceImpl(this);
		}
		
		@Override
		public InterestCalculationSequence.InterestCalculationSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestCalculationSequence.InterestCalculationSequenceBuilder prune() {
			if (interpolationMethod!=null && !interpolationMethod.prune().hasData()) interpolationMethod = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInterpolationMethod()!=null && getInterpolationMethod().hasData()) return true;
			if (getInterpolationPeriod()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InterestCalculationSequence.InterestCalculationSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InterestCalculationSequence.InterestCalculationSequenceBuilder o = (InterestCalculationSequence.InterestCalculationSequenceBuilder) other;
			
			merger.mergeRosetta(getInterpolationMethod(), o.getInterpolationMethod(), this::setInterpolationMethod);
			
			merger.mergeBasic(getInterpolationPeriod(), o.getInterpolationPeriod(), this::setInterpolationPeriod);
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InterestCalculationSequence _that = getType().cast(o);
		
			if (!Objects.equals(interpolationMethod, _that.getInterpolationMethod())) return false;
			if (!Objects.equals(interpolationPeriod, _that.getInterpolationPeriod())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (interpolationMethod != null ? interpolationMethod.hashCode() : 0);
			_result = 31 * _result + (interpolationPeriod != null ? interpolationPeriod.getClass().getName().hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InterestCalculationSequenceBuilder {" +
				"interpolationMethod=" + this.interpolationMethod + ", " +
				"interpolationPeriod=" + this.interpolationPeriod +
			'}';
		}
	}
}
