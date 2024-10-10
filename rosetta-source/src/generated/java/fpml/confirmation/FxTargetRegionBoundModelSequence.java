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
import fpml.confirmation.FxTargetRegionBoundModelSequence;
import fpml.confirmation.FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder;
import fpml.confirmation.FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilderImpl;
import fpml.confirmation.FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceImpl;
import fpml.confirmation.FxTargetRegionLowerBound;
import fpml.confirmation.FxTargetRegionUpperBound;
import fpml.confirmation.meta.FxTargetRegionBoundModelSequenceMeta;
import java.util.Objects;

import static java.util.Optional.ofNullable;

/**
 * @version ${project.version}
 */
@RosettaDataType(value="FxTargetRegionBoundModelSequence", builder=FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilderImpl.class, version="${project.version}")
public interface FxTargetRegionBoundModelSequence extends RosettaModelObject {

	FxTargetRegionBoundModelSequenceMeta metaData = new FxTargetRegionBoundModelSequenceMeta();

	/*********************** Getter Methods  ***********************/
	/**
	 * Defines the lower bound of a payoff region.
	 */
	FxTargetRegionLowerBound getLowerBound();
	/**
	 * Defines the upper bound of a payoff region.
	 */
	FxTargetRegionUpperBound getUpperBound();

	/*********************** Build Methods  ***********************/
	FxTargetRegionBoundModelSequence build();
	
	FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder toBuilder();
	
	static FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder builder() {
		return new FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilderImpl();
	}

	/*********************** Utility Methods  ***********************/
	@Override
	default RosettaMetaData<? extends FxTargetRegionBoundModelSequence> metaData() {
		return metaData;
	}
	
	@Override
	default Class<? extends FxTargetRegionBoundModelSequence> getType() {
		return FxTargetRegionBoundModelSequence.class;
	}
	
	
	@Override
	default void process(RosettaPath path, Processor processor) {
		processRosetta(path.newSubPath("lowerBound"), processor, FxTargetRegionLowerBound.class, getLowerBound());
		processRosetta(path.newSubPath("upperBound"), processor, FxTargetRegionUpperBound.class, getUpperBound());
	}
	

	/*********************** Builder Interface  ***********************/
	interface FxTargetRegionBoundModelSequenceBuilder extends FxTargetRegionBoundModelSequence, RosettaModelObjectBuilder {
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getOrCreateLowerBound();
		FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getLowerBound();
		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getOrCreateUpperBound();
		FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder getUpperBound();
		FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder setLowerBound(FxTargetRegionLowerBound lowerBound);
		FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder setUpperBound(FxTargetRegionUpperBound upperBound);

		@Override
		default void process(RosettaPath path, BuilderProcessor processor) {
			processRosetta(path.newSubPath("lowerBound"), processor, FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder.class, getLowerBound());
			processRosetta(path.newSubPath("upperBound"), processor, FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder.class, getUpperBound());
		}
		

		FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder prune();
	}

	/*********************** Immutable Implementation of FxTargetRegionBoundModelSequence  ***********************/
	class FxTargetRegionBoundModelSequenceImpl implements FxTargetRegionBoundModelSequence {
		private final FxTargetRegionLowerBound lowerBound;
		private final FxTargetRegionUpperBound upperBound;
		
		protected FxTargetRegionBoundModelSequenceImpl(FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder builder) {
			this.lowerBound = ofNullable(builder.getLowerBound()).map(f->f.build()).orElse(null);
			this.upperBound = ofNullable(builder.getUpperBound()).map(f->f.build()).orElse(null);
		}
		
		@Override
		@RosettaAttribute("lowerBound")
		public FxTargetRegionLowerBound getLowerBound() {
			return lowerBound;
		}
		
		@Override
		@RosettaAttribute("upperBound")
		public FxTargetRegionUpperBound getUpperBound() {
			return upperBound;
		}
		
		@Override
		public FxTargetRegionBoundModelSequence build() {
			return this;
		}
		
		@Override
		public FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder toBuilder() {
			FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder builder = builder();
			setBuilderFields(builder);
			return builder;
		}
		
		protected void setBuilderFields(FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder builder) {
			ofNullable(getLowerBound()).ifPresent(builder::setLowerBound);
			ofNullable(getUpperBound()).ifPresent(builder::setUpperBound);
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetRegionBoundModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetRegionBoundModelSequence {" +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound +
			'}';
		}
	}

	/*********************** Builder Implementation of FxTargetRegionBoundModelSequence  ***********************/
	class FxTargetRegionBoundModelSequenceBuilderImpl implements FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder {
	
		protected FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder lowerBound;
		protected FxTargetRegionUpperBound.FxTargetRegionUpperBoundBuilder upperBound;
	
		public FxTargetRegionBoundModelSequenceBuilderImpl() {
		}
	
		@Override
		@RosettaAttribute("lowerBound")
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getLowerBound() {
			return lowerBound;
		}
		
		@Override
		public FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder getOrCreateLowerBound() {
			FxTargetRegionLowerBound.FxTargetRegionLowerBoundBuilder result;
			if (lowerBound!=null) {
				result = lowerBound;
			}
			else {
				result = lowerBound = FxTargetRegionLowerBound.builder();
			}
			
			return result;
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
		@RosettaAttribute("lowerBound")
		public FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder setLowerBound(FxTargetRegionLowerBound lowerBound) {
			this.lowerBound = lowerBound==null?null:lowerBound.toBuilder();
			return this;
		}
		@Override
		@RosettaAttribute("upperBound")
		public FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder setUpperBound(FxTargetRegionUpperBound upperBound) {
			this.upperBound = upperBound==null?null:upperBound.toBuilder();
			return this;
		}
		
		@Override
		public FxTargetRegionBoundModelSequence build() {
			return new FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceImpl(this);
		}
		
		@Override
		public FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder toBuilder() {
			return this;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder prune() {
			if (lowerBound!=null && !lowerBound.prune().hasData()) lowerBound = null;
			if (upperBound!=null && !upperBound.prune().hasData()) upperBound = null;
			return this;
		}
		
		@Override
		public boolean hasData() {
			if (getLowerBound()!=null && getLowerBound().hasData()) return true;
			if (getUpperBound()!=null && getUpperBound().hasData()) return true;
			return false;
		}
	
		@SuppressWarnings("unchecked")
		@Override
		public FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder merge(RosettaModelObjectBuilder other, BuilderMerger merger) {
			FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder o = (FxTargetRegionBoundModelSequence.FxTargetRegionBoundModelSequenceBuilder) other;
			
			merger.mergeRosetta(getLowerBound(), o.getLowerBound(), this::setLowerBound);
			merger.mergeRosetta(getUpperBound(), o.getUpperBound(), this::setUpperBound);
			
			return this;
		}
	
		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || !(o instanceof RosettaModelObject) || !getType().equals(((RosettaModelObject)o).getType())) return false;
		
			FxTargetRegionBoundModelSequence _that = getType().cast(o);
		
			if (!Objects.equals(lowerBound, _that.getLowerBound())) return false;
			if (!Objects.equals(upperBound, _that.getUpperBound())) return false;
			return true;
		}
		
		@Override
		public int hashCode() {
			int _result = 0;
			_result = 31 * _result + (lowerBound != null ? lowerBound.hashCode() : 0);
			_result = 31 * _result + (upperBound != null ? upperBound.hashCode() : 0);
			return _result;
		}
		
		@Override
		public String toString() {
			return "FxTargetRegionBoundModelSequenceBuilder {" +
				"lowerBound=" + this.lowerBound + ", " +
				"upperBound=" + this.upperBound +
			'}';
		}
	}
}
