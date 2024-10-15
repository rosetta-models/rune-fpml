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
import fpml.confirmation.CalculationFromObservationChoice;
import fpml.confirmation.CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder;
import fpml.confirmation.CalculationFromObservationChoice.CalculationFromObservationChoiceBuilderImpl;
import fpml.confirmation.CalculationFromObservationChoice.CalculationFromObservationChoiceImpl;
import fpml.confirmation.CalculationFromObservationChoiceSequence;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.meta.CalculationFromObservationChoiceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CalculationFromObservationChoice", builder=CalculationFromObservationChoice.CalculationFromObservationChoiceBuilderImpl.class, version="${project.version}")
public interface CalculationFromObservationChoice extends RosettaModelObject {

	CalculationFromObservationChoiceMeta metaData = new CalculationFromObservationChoiceMeta();

	/*********************** Getter Methods  ***********************/
	CalculationFromObservationChoiceSequence getCalculationFromObservationChoiceSequence();
	/**
	 * Specifies whether the Initial Index Level determination method should be the Closing Price Level, the Expiring Contract Level, VWAPPrice, TWAPPrice, NAV or Open Price. Note: the AgreedInitialPrice value is not allowed here.
	 */
	DeterminationMethod getInitialLevelSource();

	/*********************** Build Methods  ***********************/
	CalculationFromObservationChoice build();
	
	CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder toBuilder();
	
	static CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder builder() {
		return new CalculationFromObservationChoice.CalculationFromObservationChoiceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationFromObservationChoice> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculationFromObservationChoice> getType() {
		return CalculationFromObservationChoice.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("calculationFromObservationChoiceSequence"), processor, CalculationFromObservationChoiceSequence.class, getCalculationFromObservationChoiceSequence());
		processRosetta(path.newSubPath("initialLevelSource"), processor, DeterminationMethod.class, getInitialLevelSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationFromObservationChoiceBuilder extends CalculationFromObservationChoice, RosettaModelObjectBuilder {
		CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder getOrCreateCalculationFromObservationChoiceSequence();
		CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder getCalculationFromObservationChoiceSequence();
		DeterminationMethod.DeterminationMethodBuilder getOrCreateInitialLevelSource();
		DeterminationMethod.DeterminationMethodBuilder getInitialLevelSource();
		CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder setCalculationFromObservationChoiceSequence(CalculationFromObservationChoiceSequence calculationFromObservationChoiceSequence);
		CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder setInitialLevelSource(DeterminationMethod initialLevelSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("calculationFromObservationChoiceSequence"), processor, CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder.class, getCalculationFromObservationChoiceSequence());
			processRosetta(path.newSubPath("initialLevelSource"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getInitialLevelSource());
		}
		

		CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationFromObservationChoice  ***********************/
	class CalculationFromObservationChoiceImpl implements CalculationFromObservationChoice {
		private final CalculationFromObservationChoiceSequence calculationFromObservationChoiceSequence;
		private final DeterminationMethod initialLevelSource;
		
		protected CalculationFromObservationChoiceImpl(CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder builder) {
			this.calculationFromObservationChoiceSequence = ofNullable(builder.getCalculationFromObservationChoiceSequence()).map(f->f.build()).orElse(null);
			this.initialLevelSource = ofNullable(builder.getInitialLevelSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("calculationFromObservationChoiceSequence")
		public CalculationFromObservationChoiceSequence getCalculationFromObservationChoiceSequence() {
			return calculationFromObservationChoiceSequence;
		}
		
		@Override
		@RosettaAttribute("initialLevelSource")
		public DeterminationMethod getInitialLevelSource() {
			return initialLevelSource;
		}
		
		@Override
		public CalculationFromObservationChoice build() {
			return this;
		}
		
		@Override
		public CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder toBuilder() {
			CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder builder) {
			ofNullable(getCalculationFromObservationChoiceSequence()).ifPresent(builder::setCalculationFromObservationChoiceSequence);
			ofNullable(getInitialLevelSource()).ifPresent(builder::setInitialLevelSource);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationFromObservationChoice _that = getType().cast(o);
		
			if (!Objects.equals(calculationFromObservationChoiceSequence, _that.getCalculationFromObservationChoiceSequence())) return false;
			if (!Objects.equals(initialLevelSource, _that.getInitialLevelSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationFromObservationChoiceSequence != null ? calculationFromObservationChoiceSequence.hashCode() : 0);
			_result = 31 * _result + (initialLevelSource != null ? initialLevelSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationFromObservationChoice {" +
				"calculationFromObservationChoiceSequence=" + this.calculationFromObservationChoiceSequence + ", " +
				"initialLevelSource=" + this.initialLevelSource +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationFromObservationChoice  ***********************/
	class CalculationFromObservationChoiceBuilderImpl implements CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder {
	
		protected CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder calculationFromObservationChoiceSequence;
		protected DeterminationMethod.DeterminationMethodBuilder initialLevelSource;
	
		public CalculationFromObservationChoiceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("calculationFromObservationChoiceSequence")
		public CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder getCalculationFromObservationChoiceSequence() {
			return calculationFromObservationChoiceSequence;
		}
		
		@Override
		public CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder getOrCreateCalculationFromObservationChoiceSequence() {
			CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder result;
			if (calculationFromObservationChoiceSequence!=null) {
				result = calculationFromObservationChoiceSequence;
			}
			else {
				result = calculationFromObservationChoiceSequence = CalculationFromObservationChoiceSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialLevelSource")
		public DeterminationMethod.DeterminationMethodBuilder getInitialLevelSource() {
			return initialLevelSource;
		}
		
		@Override
		public DeterminationMethod.DeterminationMethodBuilder getOrCreateInitialLevelSource() {
			DeterminationMethod.DeterminationMethodBuilder result;
			if (initialLevelSource!=null) {
				result = initialLevelSource;
			}
			else {
				result = initialLevelSource = DeterminationMethod.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("calculationFromObservationChoiceSequence")
		public CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder setCalculationFromObservationChoiceSequence(CalculationFromObservationChoiceSequence calculationFromObservationChoiceSequence) {
			this.calculationFromObservationChoiceSequence = calculationFromObservationChoiceSequence==null?null:calculationFromObservationChoiceSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("initialLevelSource")
		public CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder setInitialLevelSource(DeterminationMethod initialLevelSource) {
			this.initialLevelSource = initialLevelSource==null?null:initialLevelSource.toBuilder();
			return this;
		}
		
		@Override
		public CalculationFromObservationChoice build() {
			return new CalculationFromObservationChoice.CalculationFromObservationChoiceImpl(this);
		}
		
		@Override
		public CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder prune() {
			if (calculationFromObservationChoiceSequence!=null && !calculationFromObservationChoiceSequence.prune().hasData()) calculationFromObservationChoiceSequence = null;
			if (initialLevelSource!=null && !initialLevelSource.prune().hasData()) initialLevelSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getCalculationFromObservationChoiceSequence()!=null && getCalculationFromObservationChoiceSequence().hasData()) return true;
			if (getInitialLevelSource()!=null && getInitialLevelSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder o = (CalculationFromObservationChoice.CalculationFromObservationChoiceBuilder) other;
			
			merger.mergeRosetta(getCalculationFromObservationChoiceSequence(), o.getCalculationFromObservationChoiceSequence(), this::setCalculationFromObservationChoiceSequence);
			merger.mergeRosetta(getInitialLevelSource(), o.getInitialLevelSource(), this::setInitialLevelSource);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationFromObservationChoice _that = getType().cast(o);
		
			if (!Objects.equals(calculationFromObservationChoiceSequence, _that.getCalculationFromObservationChoiceSequence())) return false;
			if (!Objects.equals(initialLevelSource, _that.getInitialLevelSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (calculationFromObservationChoiceSequence != null ? calculationFromObservationChoiceSequence.hashCode() : 0);
			_result = 31 * _result + (initialLevelSource != null ? initialLevelSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationFromObservationChoiceBuilder {" +
				"calculationFromObservationChoiceSequence=" + this.calculationFromObservationChoiceSequence + ", " +
				"initialLevelSource=" + this.initialLevelSource +
			'}';
		}
	}
}
