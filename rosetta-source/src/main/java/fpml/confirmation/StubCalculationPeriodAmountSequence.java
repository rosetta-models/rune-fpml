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
import fpml.confirmation.StubCalculationPeriodAmountSequence;
import fpml.confirmation.StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder;
import fpml.confirmation.StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilderImpl;
import fpml.confirmation.StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceImpl;
import fpml.confirmation.StubValue;
import fpml.confirmation.meta.StubCalculationPeriodAmountSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="StubCalculationPeriodAmountSequence", builder=StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilderImpl.class, version="${project.version}")
public interface StubCalculationPeriodAmountSequence extends RosettaModelObject {

	StubCalculationPeriodAmountSequenceMeta metaData = new StubCalculationPeriodAmountSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Specifies how the initial stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
	 */
	StubValue getInitialStub();
	/**
	 * Specifies how the final stub amount is calculated. A single floating rate tenor different to that used for the regular part of the calculation periods schedule may be specified, or two floating tenors may be specified. If two floating rate tenors are specified then Linear Interpolation (in accordance with the 2000 ISDA Definitions, Section 8.3. Interpolation) is assumed to apply. Alternatively, an actual known stub rate or stub amount may be specified.
	 */
	StubValue getFinalStub();

	/*********************** Build Methods  ***********************/
	StubCalculationPeriodAmountSequence build();
	
	StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder toBuilder();
	
	static StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder builder() {
		return new StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StubCalculationPeriodAmountSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends StubCalculationPeriodAmountSequence> getType() {
		return StubCalculationPeriodAmountSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initialStub"), processor, StubValue.class, getInitialStub());
		processRosetta(path.newSubPath("finalStub"), processor, StubValue.class, getFinalStub());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StubCalculationPeriodAmountSequenceBuilder extends StubCalculationPeriodAmountSequence, RosettaModelObjectBuilder {
		StubValue.StubValueBuilder getOrCreateInitialStub();
		StubValue.StubValueBuilder getInitialStub();
		StubValue.StubValueBuilder getOrCreateFinalStub();
		StubValue.StubValueBuilder getFinalStub();
		StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder setInitialStub(StubValue initialStub);
		StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder setFinalStub(StubValue finalStub);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initialStub"), processor, StubValue.StubValueBuilder.class, getInitialStub());
			processRosetta(path.newSubPath("finalStub"), processor, StubValue.StubValueBuilder.class, getFinalStub());
		}
		

		StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of StubCalculationPeriodAmountSequence  ***********************/
	class StubCalculationPeriodAmountSequenceImpl implements StubCalculationPeriodAmountSequence {
		private final StubValue initialStub;
		private final StubValue finalStub;
		
		protected StubCalculationPeriodAmountSequenceImpl(StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder builder) {
			this.initialStub = ofNullable(builder.getInitialStub()).map(f->f.build()).orElse(null);
			this.finalStub = ofNullable(builder.getFinalStub()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initialStub")
		public StubValue getInitialStub() {
			return initialStub;
		}
		
		@Override
		@RosettaAttribute("finalStub")
		public StubValue getFinalStub() {
			return finalStub;
		}
		
		@Override
		public StubCalculationPeriodAmountSequence build() {
			return this;
		}
		
		@Override
		public StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder toBuilder() {
			StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder builder) {
			ofNullable(getInitialStub()).ifPresent(builder::setInitialStub);
			ofNullable(getFinalStub()).ifPresent(builder::setFinalStub);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubCalculationPeriodAmountSequence _that = getType().cast(o);
		
			if (!Objects.equals(initialStub, _that.getInitialStub())) return false;
			if (!Objects.equals(finalStub, _that.getFinalStub())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialStub != null ? initialStub.hashCode() : 0);
			_result = 31 * _result + (finalStub != null ? finalStub.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubCalculationPeriodAmountSequence {" +
				"initialStub=" + this.initialStub + ", " +
				"finalStub=" + this.finalStub +
			'}';
		}
	}

	/*********************** Builder Implementation of StubCalculationPeriodAmountSequence  ***********************/
	class StubCalculationPeriodAmountSequenceBuilderImpl implements StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder {
	
		protected StubValue.StubValueBuilder initialStub;
		protected StubValue.StubValueBuilder finalStub;
	
		public StubCalculationPeriodAmountSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialStub")
		public StubValue.StubValueBuilder getInitialStub() {
			return initialStub;
		}
		
		@Override
		public StubValue.StubValueBuilder getOrCreateInitialStub() {
			StubValue.StubValueBuilder result;
			if (initialStub!=null) {
				result = initialStub;
			}
			else {
				result = initialStub = StubValue.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalStub")
		public StubValue.StubValueBuilder getFinalStub() {
			return finalStub;
		}
		
		@Override
		public StubValue.StubValueBuilder getOrCreateFinalStub() {
			StubValue.StubValueBuilder result;
			if (finalStub!=null) {
				result = finalStub;
			}
			else {
				result = finalStub = StubValue.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialStub")
		public StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder setInitialStub(StubValue initialStub) {
			this.initialStub = initialStub==null?null:initialStub.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("finalStub")
		public StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder setFinalStub(StubValue finalStub) {
			this.finalStub = finalStub==null?null:finalStub.toBuilder();
			return this;
		}
		
		@Override
		public StubCalculationPeriodAmountSequence build() {
			return new StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceImpl(this);
		}
		
		@Override
		public StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder prune() {
			if (initialStub!=null && !initialStub.prune().hasData()) initialStub = null;
			if (finalStub!=null && !finalStub.prune().hasData()) finalStub = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getInitialStub()!=null && getInitialStub().hasData()) return true;
			if (getFinalStub()!=null && getFinalStub().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder o = (StubCalculationPeriodAmountSequence.StubCalculationPeriodAmountSequenceBuilder) other;
			
			merger.mergeRosetta(getInitialStub(), o.getInitialStub(), this::setInitialStub);
			merger.mergeRosetta(getFinalStub(), o.getFinalStub(), this::setFinalStub);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubCalculationPeriodAmountSequence _that = getType().cast(o);
		
			if (!Objects.equals(initialStub, _that.getInitialStub())) return false;
			if (!Objects.equals(finalStub, _that.getFinalStub())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (initialStub != null ? initialStub.hashCode() : 0);
			_result = 31 * _result + (finalStub != null ? finalStub.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubCalculationPeriodAmountSequenceBuilder {" +
				"initialStub=" + this.initialStub + ", " +
				"finalStub=" + this.finalStub +
			'}';
		}
	}
}
