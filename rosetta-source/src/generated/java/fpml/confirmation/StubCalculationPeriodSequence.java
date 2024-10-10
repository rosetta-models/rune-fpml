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
import fpml.confirmation.Stub;
import fpml.confirmation.StubCalculationPeriodSequence;
import fpml.confirmation.StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder;
import fpml.confirmation.StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilderImpl;
import fpml.confirmation.StubCalculationPeriodSequence.StubCalculationPeriodSequenceImpl;
import fpml.confirmation.meta.StubCalculationPeriodSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="StubCalculationPeriodSequence", builder=StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilderImpl.class, version="${project.version}")
public interface StubCalculationPeriodSequence extends RosettaModelObject {

	StubCalculationPeriodSequenceMeta metaData = new StubCalculationPeriodSequenceMeta();

	/*********************** Getter Methods  ***********************/
	Stub getInitialStub();
	Stub getFinalStub();

	/*********************** Build Methods  ***********************/
	StubCalculationPeriodSequence build();
	
	StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder toBuilder();
	
	static StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder builder() {
		return new StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StubCalculationPeriodSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends StubCalculationPeriodSequence> getType() {
		return StubCalculationPeriodSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("initialStub"), processor, Stub.class, getInitialStub());
		processRosetta(path.newSubPath("finalStub"), processor, Stub.class, getFinalStub());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StubCalculationPeriodSequenceBuilder extends StubCalculationPeriodSequence, RosettaModelObjectBuilder {
		Stub.StubBuilder getOrCreateInitialStub();
		Stub.StubBuilder getInitialStub();
		Stub.StubBuilder getOrCreateFinalStub();
		Stub.StubBuilder getFinalStub();
		StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder setInitialStub(Stub initialStub);
		StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder setFinalStub(Stub finalStub);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("initialStub"), processor, Stub.StubBuilder.class, getInitialStub());
			processRosetta(path.newSubPath("finalStub"), processor, Stub.StubBuilder.class, getFinalStub());
		}
		

		StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of StubCalculationPeriodSequence  ***********************/
	class StubCalculationPeriodSequenceImpl implements StubCalculationPeriodSequence {
		private final Stub initialStub;
		private final Stub finalStub;
		
		protected StubCalculationPeriodSequenceImpl(StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder builder) {
			this.initialStub = ofNullable(builder.getInitialStub()).map(f->f.build()).orElse(null);
			this.finalStub = ofNullable(builder.getFinalStub()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("initialStub")
		public Stub getInitialStub() {
			return initialStub;
		}
		
		@Override
		@RosettaAttribute("finalStub")
		public Stub getFinalStub() {
			return finalStub;
		}
		
		@Override
		public StubCalculationPeriodSequence build() {
			return this;
		}
		
		@Override
		public StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder toBuilder() {
			StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder builder) {
			ofNullable(getInitialStub()).ifPresent(builder::setInitialStub);
			ofNullable(getFinalStub()).ifPresent(builder::setFinalStub);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubCalculationPeriodSequence _that = getType().cast(o);
		
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
			return "StubCalculationPeriodSequence {" +
				"initialStub=" + this.initialStub + ", " +
				"finalStub=" + this.finalStub +
			'}';
		}
	}

	/*********************** Builder Implementation of StubCalculationPeriodSequence  ***********************/
	class StubCalculationPeriodSequenceBuilderImpl implements StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder {
	
		protected Stub.StubBuilder initialStub;
		protected Stub.StubBuilder finalStub;
	
		public StubCalculationPeriodSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("initialStub")
		public Stub.StubBuilder getInitialStub() {
			return initialStub;
		}
		
		@Override
		public Stub.StubBuilder getOrCreateInitialStub() {
			Stub.StubBuilder result;
			if (initialStub!=null) {
				result = initialStub;
			}
			else {
				result = initialStub = Stub.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("finalStub")
		public Stub.StubBuilder getFinalStub() {
			return finalStub;
		}
		
		@Override
		public Stub.StubBuilder getOrCreateFinalStub() {
			Stub.StubBuilder result;
			if (finalStub!=null) {
				result = finalStub;
			}
			else {
				result = finalStub = Stub.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("initialStub")
		public StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder setInitialStub(Stub initialStub) {
			this.initialStub = initialStub==null?null:initialStub.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("finalStub")
		public StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder setFinalStub(Stub finalStub) {
			this.finalStub = finalStub==null?null:finalStub.toBuilder();
			return this;
		}
		
		@Override
		public StubCalculationPeriodSequence build() {
			return new StubCalculationPeriodSequence.StubCalculationPeriodSequenceImpl(this);
		}
		
		@Override
		public StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder prune() {
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
		public StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder o = (StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder) other;
			
			merger.mergeRosetta(getInitialStub(), o.getInitialStub(), this::setInitialStub);
			merger.mergeRosetta(getFinalStub(), o.getFinalStub(), this::setFinalStub);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubCalculationPeriodSequence _that = getType().cast(o);
		
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
			return "StubCalculationPeriodSequenceBuilder {" +
				"initialStub=" + this.initialStub + ", " +
				"finalStub=" + this.finalStub +
			'}';
		}
	}
}
