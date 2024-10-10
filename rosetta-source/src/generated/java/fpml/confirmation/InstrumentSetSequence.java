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
import fpml.confirmation.Asset;
import fpml.confirmation.InstrumentSetSequence;
import fpml.confirmation.InstrumentSetSequence.InstrumentSetSequenceBuilder;
import fpml.confirmation.InstrumentSetSequence.InstrumentSetSequenceBuilderImpl;
import fpml.confirmation.InstrumentSetSequence.InstrumentSetSequenceImpl;
import fpml.confirmation.meta.InstrumentSetSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="InstrumentSetSequence", builder=InstrumentSetSequence.InstrumentSetSequenceBuilderImpl.class, version="${project.version}")
public interface InstrumentSetSequence extends RosettaModelObject {

	InstrumentSetSequenceMeta metaData = new InstrumentSetSequenceMeta();

	/*********************** Getter Methods  ***********************/
	Asset getUnderlyingAsset();
	Asset getCurveInstrument();

	/*********************** Build Methods  ***********************/
	InstrumentSetSequence build();
	
	InstrumentSetSequence.InstrumentSetSequenceBuilder toBuilder();
	
	static InstrumentSetSequence.InstrumentSetSequenceBuilder builder() {
		return new InstrumentSetSequence.InstrumentSetSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends InstrumentSetSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends InstrumentSetSequence> getType() {
		return InstrumentSetSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.class, getUnderlyingAsset());
		processRosetta(path.newSubPath("curveInstrument"), processor, Asset.class, getCurveInstrument());
	}
	

	/*********************** Builder Interface  ***********************/
	interface InstrumentSetSequenceBuilder extends InstrumentSetSequence, RosettaModelObjectBuilder {
		Asset.AssetBuilder getOrCreateUnderlyingAsset();
		Asset.AssetBuilder getUnderlyingAsset();
		Asset.AssetBuilder getOrCreateCurveInstrument();
		Asset.AssetBuilder getCurveInstrument();
		InstrumentSetSequence.InstrumentSetSequenceBuilder setUnderlyingAsset(Asset underlyingAsset);
		InstrumentSetSequence.InstrumentSetSequenceBuilder setCurveInstrument(Asset curveInstrument);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("underlyingAsset"), processor, Asset.AssetBuilder.class, getUnderlyingAsset());
			processRosetta(path.newSubPath("curveInstrument"), processor, Asset.AssetBuilder.class, getCurveInstrument());
		}
		

		InstrumentSetSequence.InstrumentSetSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of InstrumentSetSequence  ***********************/
	class InstrumentSetSequenceImpl implements InstrumentSetSequence {
		private final Asset underlyingAsset;
		private final Asset curveInstrument;
		
		protected InstrumentSetSequenceImpl(InstrumentSetSequence.InstrumentSetSequenceBuilder builder) {
			this.underlyingAsset = ofNullable(builder.getUnderlyingAsset()).map(f->f.build()).orElse(null);
			this.curveInstrument = ofNullable(builder.getCurveInstrument()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		public Asset getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		@RosettaAttribute("curveInstrument")
		public Asset getCurveInstrument() {
			return curveInstrument;
		}
		
		@Override
		public InstrumentSetSequence build() {
			return this;
		}
		
		@Override
		public InstrumentSetSequence.InstrumentSetSequenceBuilder toBuilder() {
			InstrumentSetSequence.InstrumentSetSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(InstrumentSetSequence.InstrumentSetSequenceBuilder builder) {
			ofNullable(getUnderlyingAsset()).ifPresent(builder::setUnderlyingAsset);
			ofNullable(getCurveInstrument()).ifPresent(builder::setCurveInstrument);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentSetSequence _that = getType().cast(o);
		
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(curveInstrument, _that.getCurveInstrument())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (curveInstrument != null ? curveInstrument.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentSetSequence {" +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"curveInstrument=" + this.curveInstrument +
			'}';
		}
	}

	/*********************** Builder Implementation of InstrumentSetSequence  ***********************/
	class InstrumentSetSequenceBuilderImpl implements InstrumentSetSequence.InstrumentSetSequenceBuilder {
	
		protected Asset.AssetBuilder underlyingAsset;
		protected Asset.AssetBuilder curveInstrument;
	
		public InstrumentSetSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("underlyingAsset")
		public Asset.AssetBuilder getUnderlyingAsset() {
			return underlyingAsset;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateUnderlyingAsset() {
			Asset.AssetBuilder result;
			if (underlyingAsset!=null) {
				result = underlyingAsset;
			}
			else {
				result = underlyingAsset = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("curveInstrument")
		public Asset.AssetBuilder getCurveInstrument() {
			return curveInstrument;
		}
		
		@Override
		public Asset.AssetBuilder getOrCreateCurveInstrument() {
			Asset.AssetBuilder result;
			if (curveInstrument!=null) {
				result = curveInstrument;
			}
			else {
				result = curveInstrument = Asset.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("underlyingAsset")
		public InstrumentSetSequence.InstrumentSetSequenceBuilder setUnderlyingAsset(Asset underlyingAsset) {
			this.underlyingAsset = underlyingAsset==null?null:underlyingAsset.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("curveInstrument")
		public InstrumentSetSequence.InstrumentSetSequenceBuilder setCurveInstrument(Asset curveInstrument) {
			this.curveInstrument = curveInstrument==null?null:curveInstrument.toBuilder();
			return this;
		}
		
		@Override
		public InstrumentSetSequence build() {
			return new InstrumentSetSequence.InstrumentSetSequenceImpl(this);
		}
		
		@Override
		public InstrumentSetSequence.InstrumentSetSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentSetSequence.InstrumentSetSequenceBuilder prune() {
			if (underlyingAsset!=null && !underlyingAsset.prune().hasData()) underlyingAsset = null;
			if (curveInstrument!=null && !curveInstrument.prune().hasData()) curveInstrument = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUnderlyingAsset()!=null && getUnderlyingAsset().hasData()) return true;
			if (getCurveInstrument()!=null && getCurveInstrument().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public InstrumentSetSequence.InstrumentSetSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			InstrumentSetSequence.InstrumentSetSequenceBuilder o = (InstrumentSetSequence.InstrumentSetSequenceBuilder) other;
			
			merger.mergeRosetta(getUnderlyingAsset(), o.getUnderlyingAsset(), this::setUnderlyingAsset);
			merger.mergeRosetta(getCurveInstrument(), o.getCurveInstrument(), this::setCurveInstrument);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			InstrumentSetSequence _that = getType().cast(o);
		
			if (!Objects.equals(underlyingAsset, _that.getUnderlyingAsset())) return false;
			if (!Objects.equals(curveInstrument, _that.getCurveInstrument())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (underlyingAsset != null ? underlyingAsset.hashCode() : 0);
			_result = 31 * _result + (curveInstrument != null ? curveInstrument.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "InstrumentSetSequenceBuilder {" +
				"underlyingAsset=" + this.underlyingAsset + ", " +
				"curveInstrument=" + this.curveInstrument +
			'}';
		}
	}
}
