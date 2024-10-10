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
import fpml.confirmation.FxTargetConstantPayoff;
import fpml.confirmation.FxTargetConstantPayoff.FxTargetConstantPayoffBuilder;
import fpml.confirmation.FxTargetConstantPayoff.FxTargetConstantPayoffBuilderImpl;
import fpml.confirmation.FxTargetConstantPayoff.FxTargetConstantPayoffImpl;
import fpml.confirmation.FxTargetConstantPayoffSequence;
import fpml.confirmation.meta.FxTargetConstantPayoffMeta;
import java.math.BigDecimal;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetConstantPayoff", builder=FxTargetConstantPayoff.FxTargetConstantPayoffBuilderImpl.class, version="${project.version}")
public interface FxTargetConstantPayoff extends RosettaModelObject {

	FxTargetConstantPayoffMeta metaData = new FxTargetConstantPayoffMeta();

	/*********************** Getter Methods  ***********************/
	FxTargetConstantPayoffSequence getFxTargetConstantPayoffSequence();
	/**
	 * Payoff (gain) expressed as a fixing adjustment. This style is used in the &quot;bonus collar&quot; TARF.
	 */
	BigDecimal getFixingAdjustment();

	/*********************** Build Methods  ***********************/
	FxTargetConstantPayoff build();
	
	FxTargetConstantPayoff.FxTargetConstantPayoffBuilder toBuilder();
	
	static FxTargetConstantPayoff.FxTargetConstantPayoffBuilder builder() {
		return new FxTargetConstantPayoff.FxTargetConstantPayoffBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetConstantPayoff> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetConstantPayoff> getType() {
		return FxTargetConstantPayoff.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("fxTargetConstantPayoffSequence"), processor, FxTargetConstantPayoffSequence.class, getFxTargetConstantPayoffSequence());
		processor.processBasic(path.newSubPath("fixingAdjustment"), BigDecimal.class, getFixingAdjustment(), this);
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetConstantPayoffBuilder extends FxTargetConstantPayoff, RosettaModelObjectBuilder {
		FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder getOrCreateFxTargetConstantPayoffSequence();
		FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder getFxTargetConstantPayoffSequence();
		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setFxTargetConstantPayoffSequence(FxTargetConstantPayoffSequence fxTargetConstantPayoffSequence);
		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setFixingAdjustment(BigDecimal fixingAdjustment);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("fxTargetConstantPayoffSequence"), processor, FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder.class, getFxTargetConstantPayoffSequence());
			processor.processBasic(path.newSubPath("fixingAdjustment"), BigDecimal.class, getFixingAdjustment(), this);
		}
		

		FxTargetConstantPayoff.FxTargetConstantPayoffBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetConstantPayoff  ***********************/
	class FxTargetConstantPayoffImpl implements FxTargetConstantPayoff {
		private final FxTargetConstantPayoffSequence fxTargetConstantPayoffSequence;
		private final BigDecimal fixingAdjustment;
		
		protected FxTargetConstantPayoffImpl(FxTargetConstantPayoff.FxTargetConstantPayoffBuilder builder) {
			this.fxTargetConstantPayoffSequence = ofNullable(builder.getFxTargetConstantPayoffSequence()).map(f->f.build()).orElse(null);
			this.fixingAdjustment = builder.getFixingAdjustment();
		}
		
		@Override
		@RosettaAttribute("fxTargetConstantPayoffSequence")
		public FxTargetConstantPayoffSequence getFxTargetConstantPayoffSequence() {
			return fxTargetConstantPayoffSequence;
		}
		
		@Override
		@RosettaAttribute("fixingAdjustment")
		public BigDecimal getFixingAdjustment() {
			return fixingAdjustment;
		}
		
		@Override
		public FxTargetConstantPayoff build() {
			return this;
		}
		
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder toBuilder() {
			FxTargetConstantPayoff.FxTargetConstantPayoffBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetConstantPayoff.FxTargetConstantPayoffBuilder builder) {
			ofNullable(getFxTargetConstantPayoffSequence()).ifPresent(builder::setFxTargetConstantPayoffSequence);
			ofNullable(getFixingAdjustment()).ifPresent(builder::setFixingAdjustment);
		}

		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetConstantPayoff _that = getType().cast(o);
		
			if (!Objects.equals(fxTargetConstantPayoffSequence, _that.getFxTargetConstantPayoffSequence())) return false;
			if (!Objects.equals(fixingAdjustment, _that.getFixingAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxTargetConstantPayoffSequence != null ? fxTargetConstantPayoffSequence.hashCode() : 0);
			_result = 31 * _result + (fixingAdjustment != null ? fixingAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetConstantPayoff {" +
				"fxTargetConstantPayoffSequence=" + this.fxTargetConstantPayoffSequence + ", " +
				"fixingAdjustment=" + this.fixingAdjustment +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetConstantPayoff  ***********************/
	class FxTargetConstantPayoffBuilderImpl implements FxTargetConstantPayoff.FxTargetConstantPayoffBuilder {
	
		protected FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder fxTargetConstantPayoffSequence;
		protected BigDecimal fixingAdjustment;
	
		public FxTargetConstantPayoffBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("fxTargetConstantPayoffSequence")
		public FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder getFxTargetConstantPayoffSequence() {
			return fxTargetConstantPayoffSequence;
		}
		
		@Override
		public FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder getOrCreateFxTargetConstantPayoffSequence() {
			FxTargetConstantPayoffSequence.FxTargetConstantPayoffSequenceBuilder result;
			if (fxTargetConstantPayoffSequence!=null) {
				result = fxTargetConstantPayoffSequence;
			}
			else {
				result = fxTargetConstantPayoffSequence = FxTargetConstantPayoffSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fixingAdjustment")
		public BigDecimal getFixingAdjustment() {
			return fixingAdjustment;
		}
		
		@Override
		@RosettaAttribute("fxTargetConstantPayoffSequence")
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setFxTargetConstantPayoffSequence(FxTargetConstantPayoffSequence fxTargetConstantPayoffSequence) {
			this.fxTargetConstantPayoffSequence = fxTargetConstantPayoffSequence==null?null:fxTargetConstantPayoffSequence.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fixingAdjustment")
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder setFixingAdjustment(BigDecimal fixingAdjustment) {
			this.fixingAdjustment = fixingAdjustment==null?null:fixingAdjustment;
			return this;
		}
		
		@Override
		public FxTargetConstantPayoff build() {
			return new FxTargetConstantPayoff.FxTargetConstantPayoffImpl(this);
		}
		
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder prune() {
			if (fxTargetConstantPayoffSequence!=null && !fxTargetConstantPayoffSequence.prune().hasData()) fxTargetConstantPayoffSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getFxTargetConstantPayoffSequence()!=null && getFxTargetConstantPayoffSequence().hasData()) return true;
			if (getFixingAdjustment()!=null) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetConstantPayoff.FxTargetConstantPayoffBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetConstantPayoff.FxTargetConstantPayoffBuilder o = (FxTargetConstantPayoff.FxTargetConstantPayoffBuilder) other;
			
			merger.mergeRosetta(getFxTargetConstantPayoffSequence(), o.getFxTargetConstantPayoffSequence(), this::setFxTargetConstantPayoffSequence);
			
			merger.mergeBasic(getFixingAdjustment(), o.getFixingAdjustment(), this::setFixingAdjustment);
			return this;
		}
	
		@Override
		public boolean equals(java.lang.Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetConstantPayoff _that = getType().cast(o);
		
			if (!Objects.equals(fxTargetConstantPayoffSequence, _that.getFxTargetConstantPayoffSequence())) return false;
			if (!Objects.equals(fixingAdjustment, _that.getFixingAdjustment())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (fxTargetConstantPayoffSequence != null ? fxTargetConstantPayoffSequence.hashCode() : 0);
			_result = 31 * _result + (fixingAdjustment != null ? fixingAdjustment.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetConstantPayoffBuilder {" +
				"fxTargetConstantPayoffSequence=" + this.fxTargetConstantPayoffSequence + ", " +
				"fixingAdjustment=" + this.fixingAdjustment +
			'}';
		}
	}
}
