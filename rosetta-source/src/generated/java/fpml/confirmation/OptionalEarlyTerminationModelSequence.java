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
import fpml.confirmation.ExercisePeriod;
import fpml.confirmation.OptionalEarlyTermination;
import fpml.confirmation.OptionalEarlyTerminationModelSequence;
import fpml.confirmation.OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder;
import fpml.confirmation.OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilderImpl;
import fpml.confirmation.OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceImpl;
import fpml.confirmation.meta.OptionalEarlyTerminationModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="OptionalEarlyTerminationModelSequence", builder=OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilderImpl.class, version="${project.version}")
public interface OptionalEarlyTerminationModelSequence extends RosettaModelObject {

	OptionalEarlyTerminationModelSequenceMeta metaData = new OptionalEarlyTerminationModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Definition of the first early termination date and the frequency of the termination dates subsequent to that. American exercise is defined by having a frequency of one day.
	 */
	ExercisePeriod getOptionalEarlyTerminationParameters();
	/**
	 * An option for either or both parties to terminate the swap at fair value.
	 */
	OptionalEarlyTermination getOptionalEarlyTermination();

	/*********************** Build Methods  ***********************/
	OptionalEarlyTerminationModelSequence build();
	
	OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder toBuilder();
	
	static OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder builder() {
		return new OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends OptionalEarlyTerminationModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends OptionalEarlyTerminationModelSequence> getType() {
		return OptionalEarlyTerminationModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("optionalEarlyTerminationParameters"), processor, ExercisePeriod.class, getOptionalEarlyTerminationParameters());
		processRosetta(path.newSubPath("optionalEarlyTermination"), processor, OptionalEarlyTermination.class, getOptionalEarlyTermination());
	}
	

	/*********************** Builder Interface  ***********************/
	interface OptionalEarlyTerminationModelSequenceBuilder extends OptionalEarlyTerminationModelSequence, RosettaModelObjectBuilder {
		ExercisePeriod.ExercisePeriodBuilder getOrCreateOptionalEarlyTerminationParameters();
		ExercisePeriod.ExercisePeriodBuilder getOptionalEarlyTerminationParameters();
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder getOrCreateOptionalEarlyTermination();
		OptionalEarlyTermination.OptionalEarlyTerminationBuilder getOptionalEarlyTermination();
		OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder setOptionalEarlyTerminationParameters(ExercisePeriod optionalEarlyTerminationParameters);
		OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder setOptionalEarlyTermination(OptionalEarlyTermination optionalEarlyTermination);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("optionalEarlyTerminationParameters"), processor, ExercisePeriod.ExercisePeriodBuilder.class, getOptionalEarlyTerminationParameters());
			processRosetta(path.newSubPath("optionalEarlyTermination"), processor, OptionalEarlyTermination.OptionalEarlyTerminationBuilder.class, getOptionalEarlyTermination());
		}
		

		OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of OptionalEarlyTerminationModelSequence  ***********************/
	class OptionalEarlyTerminationModelSequenceImpl implements OptionalEarlyTerminationModelSequence {
		private final ExercisePeriod optionalEarlyTerminationParameters;
		private final OptionalEarlyTermination optionalEarlyTermination;
		
		protected OptionalEarlyTerminationModelSequenceImpl(OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder builder) {
			this.optionalEarlyTerminationParameters = ofNullable(builder.getOptionalEarlyTerminationParameters()).map(f->f.build()).orElse(null);
			this.optionalEarlyTermination = ofNullable(builder.getOptionalEarlyTermination()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationParameters")
		public ExercisePeriod getOptionalEarlyTerminationParameters() {
			return optionalEarlyTerminationParameters;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		public OptionalEarlyTermination getOptionalEarlyTermination() {
			return optionalEarlyTermination;
		}
		
		@Override
		public OptionalEarlyTerminationModelSequence build() {
			return this;
		}
		
		@Override
		public OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder toBuilder() {
			OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder builder) {
			ofNullable(getOptionalEarlyTerminationParameters()).ifPresent(builder::setOptionalEarlyTerminationParameters);
			ofNullable(getOptionalEarlyTermination()).ifPresent(builder::setOptionalEarlyTermination);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionalEarlyTerminationModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(optionalEarlyTerminationParameters, _that.getOptionalEarlyTerminationParameters())) return false;
			if (!Objects.equals(optionalEarlyTermination, _that.getOptionalEarlyTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionalEarlyTerminationParameters != null ? optionalEarlyTerminationParameters.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTermination != null ? optionalEarlyTermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionalEarlyTerminationModelSequence {" +
				"optionalEarlyTerminationParameters=" + this.optionalEarlyTerminationParameters + ", " +
				"optionalEarlyTermination=" + this.optionalEarlyTermination +
			'}';
		}
	}

	/*********************** Builder Implementation of OptionalEarlyTerminationModelSequence  ***********************/
	class OptionalEarlyTerminationModelSequenceBuilderImpl implements OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder {
	
		protected ExercisePeriod.ExercisePeriodBuilder optionalEarlyTerminationParameters;
		protected OptionalEarlyTermination.OptionalEarlyTerminationBuilder optionalEarlyTermination;
	
		public OptionalEarlyTerminationModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("optionalEarlyTerminationParameters")
		public ExercisePeriod.ExercisePeriodBuilder getOptionalEarlyTerminationParameters() {
			return optionalEarlyTerminationParameters;
		}
		
		@Override
		public ExercisePeriod.ExercisePeriodBuilder getOrCreateOptionalEarlyTerminationParameters() {
			ExercisePeriod.ExercisePeriodBuilder result;
			if (optionalEarlyTerminationParameters!=null) {
				result = optionalEarlyTerminationParameters;
			}
			else {
				result = optionalEarlyTerminationParameters = ExercisePeriod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder getOptionalEarlyTermination() {
			return optionalEarlyTermination;
		}
		
		@Override
		public OptionalEarlyTermination.OptionalEarlyTerminationBuilder getOrCreateOptionalEarlyTermination() {
			OptionalEarlyTermination.OptionalEarlyTerminationBuilder result;
			if (optionalEarlyTermination!=null) {
				result = optionalEarlyTermination;
			}
			else {
				result = optionalEarlyTermination = OptionalEarlyTermination.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("optionalEarlyTerminationParameters")
		public OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder setOptionalEarlyTerminationParameters(ExercisePeriod optionalEarlyTerminationParameters) {
			this.optionalEarlyTerminationParameters = optionalEarlyTerminationParameters==null?null:optionalEarlyTerminationParameters.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("optionalEarlyTermination")
		public OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder setOptionalEarlyTermination(OptionalEarlyTermination optionalEarlyTermination) {
			this.optionalEarlyTermination = optionalEarlyTermination==null?null:optionalEarlyTermination.toBuilder();
			return this;
		}
		
		@Override
		public OptionalEarlyTerminationModelSequence build() {
			return new OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceImpl(this);
		}
		
		@Override
		public OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder prune() {
			if (optionalEarlyTerminationParameters!=null && !optionalEarlyTerminationParameters.prune().hasData()) optionalEarlyTerminationParameters = null;
			if (optionalEarlyTermination!=null && !optionalEarlyTermination.prune().hasData()) optionalEarlyTermination = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getOptionalEarlyTerminationParameters()!=null && getOptionalEarlyTerminationParameters().hasData()) return true;
			if (getOptionalEarlyTermination()!=null && getOptionalEarlyTermination().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder o = (OptionalEarlyTerminationModelSequence.OptionalEarlyTerminationModelSequenceBuilder) other;
			
			merger.mergeRosetta(getOptionalEarlyTerminationParameters(), o.getOptionalEarlyTerminationParameters(), this::setOptionalEarlyTerminationParameters);
			merger.mergeRosetta(getOptionalEarlyTermination(), o.getOptionalEarlyTermination(), this::setOptionalEarlyTermination);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			OptionalEarlyTerminationModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(optionalEarlyTerminationParameters, _that.getOptionalEarlyTerminationParameters())) return false;
			if (!Objects.equals(optionalEarlyTermination, _that.getOptionalEarlyTermination())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (optionalEarlyTerminationParameters != null ? optionalEarlyTerminationParameters.hashCode() : 0);
			_result = 31 * _result + (optionalEarlyTermination != null ? optionalEarlyTermination.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "OptionalEarlyTerminationModelSequenceBuilder {" +
				"optionalEarlyTerminationParameters=" + this.optionalEarlyTerminationParameters + ", " +
				"optionalEarlyTermination=" + this.optionalEarlyTermination +
			'}';
		}
	}
}
