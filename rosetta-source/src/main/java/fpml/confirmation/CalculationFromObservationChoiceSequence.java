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
import fpml.confirmation.CalculationFromObservationChoiceSequence;
import fpml.confirmation.CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder;
import fpml.confirmation.CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilderImpl;
import fpml.confirmation.CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceImpl;
import fpml.confirmation.DeterminationMethod;
import fpml.confirmation.meta.CalculationFromObservationChoiceSequenceMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="CalculationFromObservationChoiceSequence", builder=CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilderImpl.class, version="${project.version}")
public interface CalculationFromObservationChoiceSequence extends RosettaModelObject {

	CalculationFromObservationChoiceSequenceMeta metaData = new CalculationFromObservationChoiceSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Contract will strike off this initial level. Providing just the initialLevel without initialLevelSource, infers that this is AgreedInitialPrice - a specified Initial Index Level.
	 */
	BigDecimal getInitialLevel();
	/**
	 * In this context, this is AgreedInitialPrice - a specified Initial Index Level. Note: No other values from the DeterminationMethodScheme should not be provided.
	 */
	DeterminationMethod getInitialLevelSource();

	/*********************** Build Methods  ***********************/
	CalculationFromObservationChoiceSequence build();
	
	CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder toBuilder();
	
	static CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder builder() {
		return new CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends CalculationFromObservationChoiceSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends CalculationFromObservationChoiceSequence> getType() {
		return CalculationFromObservationChoiceSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processor.processBasic(path.newSubPath("initialLevel"), BigDecimal.class, getInitialLevel(), this);
		processRosetta(path.newSubPath("initialLevelSource"), processor, DeterminationMethod.class, getInitialLevelSource());
	}
	

	/*********************** Builder Interface  ***********************/
	interface CalculationFromObservationChoiceSequenceBuilder extends CalculationFromObservationChoiceSequence, RosettaModelObjectBuilder {
		DeterminationMethod.DeterminationMethodBuilder getOrCreateInitialLevelSource();
		DeterminationMethod.DeterminationMethodBuilder getInitialLevelSource();
		CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder setInitialLevel(BigDecimal initialLevel);
		CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder setInitialLevelSource(DeterminationMethod initialLevelSource);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processor.processBasic(path.newSubPath("initialLevel"), BigDecimal.class, getInitialLevel(), this);
			processRosetta(path.newSubPath("initialLevelSource"), processor, DeterminationMethod.DeterminationMethodBuilder.class, getInitialLevelSource());
		}
		

		CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of CalculationFromObservationChoiceSequence  ***********************/
	class CalculationFromObservationChoiceSequenceImpl implements CalculationFromObservationChoiceSequence {
		private final BigDecimal initialLevel;
		private final DeterminationMethod initialLevelSource;
		
		protected CalculationFromObservationChoiceSequenceImpl(CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder builder) {
			this.initialLevel = builder.getInitialLevel();
			this.initialLevelSource = ofNullable(builder.getInitialLevelSource()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initialLevel")
		public BigDecimal getInitialLevel() {
			return initialLevel;
		}
		
		@Override
		@RosettaAttribute("initialLevelSource")
		public DeterminationMethod getInitialLevelSource() {
			return initialLevelSource;
		}
		
		@Override
		public CalculationFromObservationChoiceSequence build() {
			return this;
		}
		
		@Override
		public CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder toBuilder() {
			CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder builder) {
			ofNullable(getInitialLevel()).ifPresent(builder::setInitialLevel);
			ofNullable(getInitialLevelSource()).ifPresent(builder::setInitialLevelSource);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationFromObservationChoiceSequence _that = getType().cast(o);
		
			if (!Objects.equals(initialLevel, _that.getInitialLevel())) return false;
			if (!Objects.equals(initialLevelSource, _that.getInitialLevelSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialLevel != null ? initialLevel.hashCode() : 0);
			_result = 31 * _result + (initialLevelSource != null ? initialLevelSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationFromObservationChoiceSequence {" +
				"initialLevel=" + this.initialLevel + ", " +
				"initialLevelSource=" + this.initialLevelSource +
			'}';
		}
	}

	/*********************** Builder Implementation of CalculationFromObservationChoiceSequence  ***********************/
	class CalculationFromObservationChoiceSequenceBuilderImpl implements CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder {
	
		protected BigDecimal initialLevel;
		protected DeterminationMethod.DeterminationMethodBuilder initialLevelSource;
	
		public CalculationFromObservationChoiceSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialLevel")
		public BigDecimal getInitialLevel() {
			return initialLevel;
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
		@RosettaAttribute("initialLevel")
		public CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder setInitialLevel(BigDecimal initialLevel) {
			this.initialLevel = initialLevel==null?null:initialLevel;
			return this;
		}
		@Override
		@RosettaAttribute("initialLevelSource")
		public CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder setInitialLevelSource(DeterminationMethod initialLevelSource) {
			this.initialLevelSource = initialLevelSource==null?null:initialLevelSource.toBuilder();
			return this;
		}
		
		@Override
		public CalculationFromObservationChoiceSequence build() {
			return new CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceImpl(this);
		}
		
		@Override
		public CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder prune() {
			if (initialLevelSource!=null && !initialLevelSource.prune().hasData()) initialLevelSource = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialLevel()!=null) return true;
			if (getInitialLevelSource()!=null && getInitialLevelSource().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder o = (CalculationFromObservationChoiceSequence.CalculationFromObservationChoiceSequenceBuilder) other;
			
			merger.mergeRosetta(getInitialLevelSource(), o.getInitialLevelSource(), this::setInitialLevelSource);
			
			merger.mergeBasic(getInitialLevel(), o.getInitialLevel(), this::setInitialLevel);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			CalculationFromObservationChoiceSequence _that = getType().cast(o);
		
			if (!Objects.equals(initialLevel, _that.getInitialLevel())) return false;
			if (!Objects.equals(initialLevelSource, _that.getInitialLevelSource())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialLevel != null ? initialLevel.hashCode() : 0);
			_result = 31 * _result + (initialLevelSource != null ? initialLevelSource.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "CalculationFromObservationChoiceSequenceBuilder {" +
				"initialLevel=" + this.initialLevel + ", " +
				"initialLevelSource=" + this.initialLevelSource +
			'}';
		}
	}
}
