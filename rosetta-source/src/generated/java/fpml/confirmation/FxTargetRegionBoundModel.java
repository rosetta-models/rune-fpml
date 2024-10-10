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
import fpml.confirmation.FxTargetRegionBoundModel;
import fpml.confirmation.FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder;
import fpml.confirmation.FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilderImpl;
import fpml.confirmation.FxTargetRegionBoundModel.FxTargetRegionBoundModelImpl;
import fpml.confirmation.FxTargetRegionBoundModelSequence;
import fpml.confirmation.FxTargetRegionUpperBound;
import fpml.confirmation.meta.FxTargetRegionBoundModelMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetRegionBoundModel", builder=FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilderImpl.class, version="${project.version}")
public interface FxTargetRegionBoundModel extends RosettaModelObject {

	FxTargetRegionBoundModelMeta metaData = new FxTargetRegionBoundModelMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the upper bound of a payoff region.
	 */
	FxTargetRegionUpperBound getUpperBound();
	FxTargetRegionBoundModelSequence getFxTargetRegionBoundModelSequence();

	/*********************** Build Methods  ***********************/
	FxTargetRegionBoundModel build();
	
	FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder toBuilder();
	
	static FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder builder() {
		return new FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetRegionBoundModel> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetRegionBoundModel> getType() {
		return FxTargetRegionBoundModel.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("upperBound"), processor, FxTargetRegionUpperBound.class, getUpperBound());
		processRosetta(path.newSubPath("fxTargetRegionBoundModelSequence"), processor, FxTargetRegionBoundModelSequence.class, getFxTargetRegionBoundModelSequence());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetRegionBoundModelBuilder extends FxTargetRegionBoundModel, RosettaModelObjectBuilder {
		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getOrCreateUpperBound();
		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getUpperBound();
		FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder getOrCreateFxTargetRegionBoundModelSequence();
		FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder getFxTargetRegionBoundModelSequence();
		FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder setUpperBound(FxTargetRegionUpperBound upperBound);
		FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder setFxTargetRegionBoundModelSequence(FxTargetRegionBoundModelSequence fxTargetRegionBoundModelSequence);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("upperBound"), processor, FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder.class, getUpperBound());
			processRosetta(path.newSubPath("fxTargetRegionBoundModelSequence"), processor, FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder.class, getFxTargetRegionBoundModelSequence());
		}
		

		FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetRegionBoundModel  ***********************/
	class FxTargetRegionBoundModelImpl implements FxTargetRegionBoundModel {
		private final FxTargetRegionUpperBound upperBound;
		private final FxTargetRegionBoundModelSequence fxTargetRegionBoundModelSequence;
		
		protected FxTargetRegionBoundModelImpl(FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder builder) {
			this.upperBound = ofNullable(builder.getUpperBound()).map(f->f.build()).orElse(null);
			this.fxTargetRegionBoundModelSequence = ofNullable(builder.getFxTargetRegionBoundModelSequence()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("upperBound")
		public FxTargetRegionUpperBound getUpperBound() {
			return upperBound;
		}
		
		@Override
		@RosettaAttribute("fxTargetRegionBoundModelSequence")
		public FxTargetRegionBoundModelSequence getFxTargetRegionBoundModelSequence() {
			return fxTargetRegionBoundModelSequence;
		}
		
		@Override
		public FxTargetRegionBoundModel build() {
			return this;
		}
		
		@Override
		public FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder toBuilder() {
			FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder builder) {
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
			ofNullable(getFxTargetRegionBoundModelSequence()).ifPresent(builder::setFxTargetRegionBoundModelSequence);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetRegionBoundModel _that = getType().cast(o);
		
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(fxTargetRegionBoundModelSequence, _that.getFxTargetRegionBoundModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (fxTargetRegionBoundModelSequence != null ? fxTargetRegionBoundModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetRegionBoundModel {" +
				"upperBound=" + this.upperBound + ", " +
				"fxTargetRegionBoundModelSequence=" + this.fxTargetRegionBoundModelSequence +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetRegionBoundModel  ***********************/
	class FxTargetRegionBoundModelBuilderImpl implements FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder {
	
		protected FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder upperBound;
		protected FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder fxTargetRegionBoundModelSequence;
	
		public FxTargetRegionBoundModelBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("upperBound")
		public FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getUpperBound() {
			return upperBound;
		}
		
		@Override
		public FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getOrCreateUpperBound() {
			FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder result;
			if (upperBound!=null) {
				result = upperBound;
			}
			else {
				result = upperBound = FxTargetRegionUpperBound.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("fxTargetRegionBoundModelSequence")
		public FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder getFxTargetRegionBoundModelSequence() {
			return fxTargetRegionBoundModelSequence;
		}
		
		@Override
		public FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder getOrCreateFxTargetRegionBoundModelSequence() {
			FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder result;
			if (fxTargetRegionBoundModelSequence!=null) {
				result = fxTargetRegionBoundModelSequence;
			}
			else {
				result = fxTargetRegionBoundModelSequence = FxTargetRegionBoundModelSequence.builder();
			}
			
			return result;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		public FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder setUpperBound(FxTargetRegionUpperBound upperBound) {
			this.upperBound = upperBound==null?null:upperBound.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("fxTargetRegionBoundModelSequence")
		public FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder setFxTargetRegionBoundModelSequence(FxTargetRegionBoundModelSequence fxTargetRegionBoundModelSequence) {
			this.fxTargetRegionBoundModelSequence = fxTargetRegionBoundModelSequence==null?null:fxTargetRegionBoundModelSequence.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetRegionBoundModel build() {
			return new FxTargetRegionBoundModel.FxTargetRegionBoundModelImpl(this);
		}
		
		@Override
		public FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder prune() {
			if (upperBound!=null && !upperBound.prune().hasData()) upperBound = null;
			if (fxTargetRegionBoundModelSequence!=null && !fxTargetRegionBoundModelSequence.prune().hasData()) fxTargetRegionBoundModelSequence = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getUpperBound()!=null && getUpperBound().hasData()) return true;
			if (getFxTargetRegionBoundModelSequence()!=null && getFxTargetRegionBoundModelSequence().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder o = (FxTargetRegionBoundModel.FxTargetRegionBoundModelBuilder) other;
			
			merger.mergeRosetta(getUpperBound(), o.getUpperBound(), this::setUpperBound);
			merger.mergeRosetta(getFxTargetRegionBoundModelSequence(), o.getFxTargetRegionBoundModelSequence(), this::setFxTargetRegionBoundModelSequence);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetRegionBoundModel _that = getType().cast(o);
		
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			if (!Objects.equals(fxTargetRegionBoundModelSequence, _that.getFxTargetRegionBoundModelSequence())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			_result = 31 * _result + (fxTargetRegionBoundModelSequence != null ? fxTargetRegionBoundModelSequence.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetRegionBoundModelBuilder {" +
				"upperBound=" + this.upperBound + ", " +
				"fxTargetRegionBoundModelSequence=" + this.fxTargetRegionBoundModelSequence +
			'}';
		}
	}
}
