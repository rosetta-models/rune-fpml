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
import fpml.confirmation.StubCalculationPeriod;
import fpml.confirmation.StubCalculationPeriod.StubCalculationPeriodBuilder;
import fpml.confirmation.StubCalculationPeriod.StubCalculationPeriodBuilderImpl;
import fpml.confirmation.StubCalculationPeriod.StubCalculationPeriodImpl;
import fpml.confirmation.StubCalculationPeriodSequence;
import fpml.confirmation.meta.StubCalculationPeriodMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * A type describing the Stub Calculation Period.
 * @version ${project.version}
 */
@RosettaDataType(value="StubCalculationPeriod", builder=StubCalculationPeriod.StubCalculationPeriodBuilderImpl.class, version="${project.version}")
public interface StubCalculationPeriod extends RosettaModelObject {

	StubCalculationPeriodMeta metaData = new StubCalculationPeriodMeta();

	/*********************** Getter Methods  ***********************/
	StubCalculationPeriodSequence getStubCalculationPeriodSequence();
	Stub getFinalStub();

	/*********************** Build Methods  ***********************/
	StubCalculationPeriod build();
	
	StubCalculationPeriod.StubCalculationPeriodBuilder toBuilder();
	
	static StubCalculationPeriod.StubCalculationPeriodBuilder builder() {
		return new StubCalculationPeriod.StubCalculationPeriodBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends StubCalculationPeriod> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends StubCalculationPeriod> getType() {
		return StubCalculationPeriod.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("stubCalculationPeriodSequence"), processor, StubCalculationPeriodSequence.class, getStubCalculationPeriodSequence());
		processRosetta(path.newSubPath("finalStub"), processor, Stub.class, getFinalStub());
	}
	

	/*********************** Builder Interface  ***********************/
	interface StubCalculationPeriodBuilder extends StubCalculationPeriod, RosettaModelObjectBuilder {
		StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder getOrCreateStubCalculationPeriodSequence();
		StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder getStubCalculationPeriodSequence();
		Stub.StubBuilder getOrCreateFinalStub();
		Stub.StubBuilder getFinalStub();
		StubCalculationPeriod.StubCalculationPeriodBuilder setStubCalculationPeriodSequence(StubCalculationPeriodSequence stubCalculationPeriodSequence);
		StubCalculationPeriod.StubCalculationPeriodBuilder setFinalStub(Stub finalStub);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("stubCalculationPeriodSequence"), processor, StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder.class, getStubCalculationPeriodSequence());
			processRosetta(path.newSubPath("finalStub"), processor, Stub.StubBuilder.class, getFinalStub());
		}
		

		StubCalculationPeriod.StubCalculationPeriodBuilder prune();
	}

	/*********************** Immutable Implementation of StubCalculationPeriod  ***********************/
	class StubCalculationPeriodImpl implements StubCalculationPeriod {
		private final StubCalculationPeriodSequence stubCalculationPeriodSequence;
		private final Stub finalStub;
		
		protected StubCalculationPeriodImpl(StubCalculationPeriod.StubCalculationPeriodBuilder builder) {
			this.stubCalculationPeriodSequence = ofNullable(builder.getStubCalculationPeriodSequence()).map(f->f.build()).orElse(null);
			this.finalStub = ofNullable(builder.getFinalStub()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("stubCalculationPeriodSequence")
		public StubCalculationPeriodSequence getStubCalculationPeriodSequence() {
			return stubCalculationPeriodSequence;
		}
		
		@Override
		@RosettaAttribute("finalStub")
		public Stub getFinalStub() {
			return finalStub;
		}
		
		@Override
		public StubCalculationPeriod build() {
			return this;
		}
		
		@Override
		public StubCalculationPeriod.StubCalculationPeriodBuilder toBuilder() {
			StubCalculationPeriod.StubCalculationPeriodBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(StubCalculationPeriod.StubCalculationPeriodBuilder builder) {
			ofNullable(getStubCalculationPeriodSequence()).ifPresent(builder::setStubCalculationPeriodSequence);
			ofNullable(getFinalStub()).ifPresent(builder::setFinalStub);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(stubCalculationPeriodSequence, _that.getStubCalculationPeriodSequence())) return false;
			if (!Objects.equals(finalStub, _that.getFinalStub())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (stubCalculationPeriodSequence != null ? stubCalculationPeriodSequence.hashCode() : 0);
			_result = 31 * _result + (finalStub != null ? finalStub.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubCalculationPeriod {" +
				"stubCalculationPeriodSequence=" + this.stubCalculationPeriodSequence + ", " +
				"finalStub=" + this.finalStub +
			'}';
		}
	}

	/*********************** Builder Implementation of StubCalculationPeriod  ***********************/
	class StubCalculationPeriodBuilderImpl implements StubCalculationPeriod.StubCalculationPeriodBuilder {
	
		protected StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder stubCalculationPeriodSequence;
		protected Stub.StubBuilder finalStub;
	
		public StubCalculationPeriodBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("stubCalculationPeriodSequence")
		public StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder getStubCalculationPeriodSequence() {
			return stubCalculationPeriodSequence;
		}
		
		@Override
		public StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder getOrCreateStubCalculationPeriodSequence() {
			StubCalculationPeriodSequence.StubCalculationPeriodSequenceBuilder result;
			if (stubCalculationPeriodSequence!=null) {
				result = stubCalculationPeriodSequence;
			}
			else {
				result = stubCalculationPeriodSequence = StubCalculationPeriodSequence.builder();
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
		@RosettaAttribute("stubCalculationPeriodSequence")
		public StubCalculationPeriod.StubCalculationPeriodBuilder setStubCalculationPeriodSequence(StubCalculationPeriodSequence stubCalculationPeriodSequence) {
			this.stubCalculationPeriodSequence = stubCalculationPeriodSequence==null?null:stubCalculationPeriodSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("finalStub")
		public StubCalculationPeriod.StubCalculationPeriodBuilder setFinalStub(Stub finalStub) {
			this.finalStub = finalStub==null?null:finalStub.toBuilder();
			return this;
		}
		
		@Override
		public StubCalculationPeriod build() {
			return new StubCalculationPeriod.StubCalculationPeriodImpl(this);
		}
		
		@Override
		public StubCalculationPeriod.StubCalculationPeriodBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubCalculationPeriod.StubCalculationPeriodBuilder prune() {
			if (stubCalculationPeriodSequence!=null && !stubCalculationPeriodSequence.prune().hasData()) stubCalculationPeriodSequence = null;
			if (finalStub!=null && !finalStub.prune().hasData()) finalStub = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getStubCalculationPeriodSequence()!=null && getStubCalculationPeriodSequence().hasData()) return true;
			if (getFinalStub()!=null && getFinalStub().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public StubCalculationPeriod.StubCalculationPeriodBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			StubCalculationPeriod.StubCalculationPeriodBuilder o = (StubCalculationPeriod.StubCalculationPeriodBuilder) other;
			
			merger.mergeRosetta(getStubCalculationPeriodSequence(), o.getStubCalculationPeriodSequence(), this::setStubCalculationPeriodSequence);
			merger.mergeRosetta(getFinalStub(), o.getFinalStub(), this::setFinalStub);
			
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			StubCalculationPeriod _that = getType().cast(o);
		
			if (!Objects.equals(stubCalculationPeriodSequence, _that.getStubCalculationPeriodSequence())) return false;
			if (!Objects.equals(finalStub, _that.getFinalStub())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (stubCalculationPeriodSequence != null ? stubCalculationPeriodSequence.hashCode() : 0);
			_result = 31 * _result + (finalStub != null ? finalStub.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "StubCalculationPeriodBuilder {" +
				"stubCalculationPeriodSequence=" + this.stubCalculationPeriodSequence + ", " +
				"finalStub=" + this.finalStub +
			'}';
		}
	}
}
