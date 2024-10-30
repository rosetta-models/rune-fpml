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
import fpml.confirmation.FxAccrualRegionBoundModel;
import fpml.confirmation.FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder;
import fpml.confirmation.FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilderImpl;
import fpml.confirmation.FxAccrualRegionBoundModel.FxAccrualRegionBoundModelImpl;
import fpml.confirmation.FxAccrualRegionBoundModelSequence;
import fpml.confirmation.FxAccrualRegionUpperBound;
import fpml.confirmation.meta.FxAccrualRegionBoundModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * Defines the boundaries of the accrual region. If an upper or lower barrier is not defined then it is understood that if the barrier is missing in the direction facing the strike then the region is bounded by the strike but excludes the strike; if the barrier is missing in the direction facing away from the strike then the accrual region is unbounded in that direction. If the region is bounded by the strike then a barrier should be included to define whether the region includes or excludes the strike. If accrual regions overlap, it is understood that if one is nested within another wider region, the nested region takes precedence over the spot range that it applies. If there is an overlap but no nesting then this is invalid and barriers must be used to unequivocally define the regions.
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaDataType(value="FxAccrualRegionBoundModel", builder=FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilderImpl.class, version="0.0.0.master-SNAPSHOT")
public interface FxAccrualRegionBoundModel extends RosettaModelObject {

	FxAccrualRegionBoundModelMeta metaData = new FxAccrualRegionBoundModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the upper bound of a payoff region.
	 */
	FxAccrualRegionUpperBound getUpperBound();
	FxAccrualRegionBoundModelSequence getFxAccrualRegionBoundModelSequence();

	/*********************** Build Methods  ***********************/
	FxAccrualRegionBoundModel build();
	
	FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder toBuilder();
	
	static FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder builder() {
		return new FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxAccrualRegionBoundModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxAccrualRegionBoundModel> getType() {
		return FxAccrualRegionBoundModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("upperBound"), processor, FxAccrualRegionUpperBound.class, getUpperBound());
		processRosetta(path.newSubPath("fxAccrualRegionBoundModelSequence"), processor, FxAccrualRegionBoundModelSequence.class, getFxAccrualRegionBoundModelSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxAccrualRegionBoundModelBuilder extends FxAccrualRegionBoundModel, RosettaModelObjectBuilder {
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getOrCreateUpperBound();
		FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getUpperBound();
		FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder getOrCreateFxAccrualRegionBoundModelSequence();
		FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder getFxAccrualRegionBoundModelSequence();
		FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder setUpperBound(FxAccrualRegionUpperBound upperBound);
		FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder setFxAccrualRegionBoundModelSequence(FxAccrualRegionBoundModelSequence fxAccrualRegionBoundModelSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("upperBound"), processor, FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder.class, getUpperBound());
			processRosetta(path.newSubPath("fxAccrualRegionBoundModelSequence"), processor, FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder.class, getFxAccrualRegionBoundModelSequence());
		}
		

		FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder prune();
	}

	/*********************** Immutable Implementation of FxAccrualRegionBoundModel  ***********************/
	class FxAccrualRegionBoundModelImpl implements FxAccrualRegionBoundModel {
		private final FxAccrualRegionUpperBound upperBound;
		private final FxAccrualRegionBoundModelSequence fxAccrualRegionBoundModelSequence;
		
		protected FxAccrualRegionBoundModelImpl(FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder builder) {
			this.upperBound = ofNullable(builder.getUpperBound()).map(f->f.build()).orElse(null);
			this.fxAccrualRegionBoundModelSequence = ofNullable(builder.getFxAccrualRegionBoundModelSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("upperBound")
		public FxAccrualRegionUpperBound getUpperBound() {
			return upperBound;
		}
		
		@Override
		@RosettaAttribute("fxAccrualRegionBoundModelSequence")
		public FxAccrualRegionBoundModelSequence getFxAccrualRegionBoundModelSequence() {
			return fxAccrualRegionBoundModelSequence;
		}
		
		@Override
		public FxAccrualRegionBoundModel build() {
			return this;
		}
		
		@Override
		public FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder toBuilder() {
			FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder builder) {
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
			ofNullable(getFxAccrualRegionBoundModelSequence()).ifPresent(builder::setFxAccrualRegionBoundModelSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionBoundModel _that = getType().cast(o);
		
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(fxAccrualRegionBoundModelSequence, _that.getFxAccrualRegionBoundModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (fxAccrualRegionBoundModelSequence != null ? fxAccrualRegionBoundModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualRegionBoundModel {" +
				"upperBound=" + this.upperBound + ", " +
				"fxAccrualRegionBoundModelSequence=" + this.fxAccrualRegionBoundModelSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of FxAccrualRegionBoundModel  ***********************/
	class FxAccrualRegionBoundModelBuilderImpl implements FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder {
	
		protected FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder upperBound;
		protected FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder fxAccrualRegionBoundModelSequence;
	
		public FxAccrualRegionBoundModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("upperBound")
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getUpperBound() {
			return upperBound;
		}
		
		@Override
		public FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder getOrCreateUpperBound() {
			FxAccrualRegionUpperBound.FxAccrualRegionUpperBoundBuilder result;
			if (upperBound!=null) {
				result = upperBound;
			}
			else {
				result = upperBound = FxAccrualRegionUpperBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxAccrualRegionBoundModelSequence")
		public FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder getFxAccrualRegionBoundModelSequence() {
			return fxAccrualRegionBoundModelSequence;
		}
		
		@Override
		public FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder getOrCreateFxAccrualRegionBoundModelSequence() {
			FxAccrualRegionBoundModelSequence.FxAccrualRegionBoundModelSequenceBuilder result;
			if (fxAccrualRegionBoundModelSequence!=null) {
				result = fxAccrualRegionBoundModelSequence;
			}
			else {
				result = fxAccrualRegionBoundModelSequence = FxAccrualRegionBoundModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		public FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder setUpperBound(FxAccrualRegionUpperBound upperBound) {
			this.upperBound = upperBound==null?null:upperBound.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxAccrualRegionBoundModelSequence")
		public FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder setFxAccrualRegionBoundModelSequence(FxAccrualRegionBoundModelSequence fxAccrualRegionBoundModelSequence) {
			this.fxAccrualRegionBoundModelSequence = fxAccrualRegionBoundModelSequence==null?null:fxAccrualRegionBoundModelSequence.toBuilder();
			return this;
		}
		
		@Override
		public FxAccrualRegionBoundModel build() {
			return new FxAccrualRegionBoundModel.FxAccrualRegionBoundModelImpl(this);
		}
		
		@Override
		public FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder prune() {
			if (upperBound!=null && !upperBound.prune().hasData()) upperBound = null;
			if (fxAccrualRegionBoundModelSequence!=null && !fxAccrualRegionBoundModelSequence.prune().hasData()) fxAccrualRegionBoundModelSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUpperBound()!=null && getUpperBound().hasData()) return true;
			if (getFxAccrualRegionBoundModelSequence()!=null && getFxAccrualRegionBoundModelSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder o = (FxAccrualRegionBoundModel.FxAccrualRegionBoundModelBuilder) other;
			
			merger.mergeRosetta(getUpperBound(), o.getUpperBound(), this::setUpperBound);
			merger.mergeRosetta(getFxAccrualRegionBoundModelSequence(), o.getFxAccrualRegionBoundModelSequence(), this::setFxAccrualRegionBoundModelSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxAccrualRegionBoundModel _that = getType().cast(o);
		
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(fxAccrualRegionBoundModelSequence, _that.getFxAccrualRegionBoundModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (fxAccrualRegionBoundModelSequence != null ? fxAccrualRegionBoundModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxAccrualRegionBoundModelBuilder {" +
				"upperBound=" + this.upperBound + ", " +
				"fxAccrualRegionBoundModelSequence=" + this.fxAccrualRegionBoundModelSequence +
			'}';
		}
	}
}
